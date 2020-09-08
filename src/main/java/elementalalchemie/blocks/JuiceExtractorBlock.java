package elementalalchemie.blocks;

import elementalalchemie.InventoryUtil;
import elementalalchemie.hitboxes.JuiceExtractorHitbox;
import elementalalchemie.init.ItemInit;
import elementalalchemie.init.TileEntityTypeInit;
import elementalalchemie.tileentitys.JuiceExtractorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;

public class JuiceExtractorBlock extends Block {

	public static DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public static final int MAX_INGRIEDIENTS = 10;

	public JuiceExtractorBlock(Properties properties) {
		super(properties);
		setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {

		return new JuiceExtractorHitbox().getHitbox(state.get(FACING));
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {

		ItemStack stack = player.getHeldItem(handIn);

		TileEntity tile = worldIn.getTileEntity(pos);

		if (tile instanceof JuiceExtractorTileEntity) {

			JuiceExtractorTileEntity juiceTE = ((JuiceExtractorTileEntity) tile);
			
			if(stack.getItem().equals(ItemInit.PESTLE.get())) {
				juiceTE.onStamp();
				return true;
			}else if ((juiceTE.getBucket() == null || juiceTE.getBucket().isEmpty())
					&& stack.getItem().equals(Items.BUCKET)) {

				if (worldIn.isRemote)
					return true;

				ItemStack s = stack.copy();
				s.setCount(1);

				juiceTE.setBucket(s);
				stack.shrink(1);

				worldIn.notifyBlockUpdate(pos, state, state, 2);

				return true;

			} else if (InventoryUtil.slotsFilled(juiceTE.getInv()) < MAX_INGRIEDIENTS&&!stack.isEmpty()&&juiceTE.getCurrentStamps()==0) {

				if (worldIn.isRemote)
					return true;

				ItemStack s = stack.copy();
				s.setCount(1);

				InventoryUtil.insertFreeSlot(juiceTE.getInv(), s);
				stack.shrink(1);

				worldIn.notifyBlockUpdate(pos, state, state, 2);

				return true;

			} else {
				if (worldIn.isRemote)
					return true;

				if (!juiceTE.getBucket().isEmpty()) {

					ItemHandlerHelper.giveItemToPlayer(player, juiceTE.removeBucket());
					worldIn.notifyBlockUpdate(pos, state, state, 2);
					
					return true;

				} else if (!InventoryUtil.isEmpty(juiceTE.getInv())&&juiceTE.getCurrentStamps()==0) {
					ItemHandlerHelper.giveItemToPlayer(player,
							InventoryUtil.extractStack(juiceTE.getInv(), InventoryUtil.slotsFilled(juiceTE.getInv()) - 1));
					worldIn.notifyBlockUpdate(pos, state, state, 2);
					
					return true;
				}
			}
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {

		if (state.getBlock() != newState.getBlock()) {

			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof JuiceExtractorTileEntity) {
				InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(),
						((JuiceExtractorTileEntity) tileentity).removeBucket());

				IItemHandler inv = ((JuiceExtractorTileEntity) tileentity).getInv();
				
				if(((JuiceExtractorTileEntity) tileentity).getCurrentStamps()==0)
				for (int i = 0; i < inv.getSlots(); i++)
					InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(),
							InventoryUtil.extractStack(inv, i));

			}
		}
		super.onReplaced(state, worldIn, pos, newState, isMoving);
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return super.getStateForPlacement(context).with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {

		builder.add(FACING);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {

		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {

		return TileEntityTypeInit.JUICE_EXTRACTOR_TE.get().create();
	}

}
