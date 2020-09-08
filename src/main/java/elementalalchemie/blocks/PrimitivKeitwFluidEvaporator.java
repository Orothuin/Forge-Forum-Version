package elementalalchemie.blocks;

import elementalalchemie.hitboxes.PrimitivKeitwFluidEvaporatorHitbox;
import elementalalchemie.init.TileEntityTypeInit;
import elementalalchemie.tileentitys.PrimitvKeitwFluidEvaporatorTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;

public class PrimitivKeitwFluidEvaporator extends Block {

	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	public static final BooleanProperty BURNING_STATE = BooleanProperty.create("burningstate");
	
	public PrimitivKeitwFluidEvaporator(Properties properties) {
		super(properties);
		this.setDefaultState(
				this.stateContainer.getBaseState().with(HALF, DoubleBlockHalf.LOWER).with(FACING, Direction.NORTH).with(BURNING_STATE,false));
	}
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {

		if(state.get(HALF)==DoubleBlockHalf.LOWER)
		
		return BlockRenderType.MODEL;
		
		else return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}
	
	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		if(state.get(HALF)==DoubleBlockHalf.LOWER)
		return new PrimitivKeitwFluidEvaporatorHitbox().getHitbox(state.get(FACING));
		else return new PrimitivKeitwFluidEvaporatorHitbox().getHitbox(state.get(FACING)).withOffset(0, -1, 0);
	}
	
	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {

		ItemStack stack = player.getHeldItem(handIn);

		TileEntity tile = worldIn.getTileEntity(pos);
		
		if (!stack.isEmpty() && tile instanceof PrimitvKeitwFluidEvaporatorTileEntity) {

			PrimitvKeitwFluidEvaporatorTileEntity evaporator = ((PrimitvKeitwFluidEvaporatorTileEntity) tile);

			if (evaporator.getInventory().isItemValid(0, stack)
					&& evaporator.getInventory().getStackInSlot(0).isEmpty()) {

				if (worldIn.isRemote)
					return true;

				ItemStack insertStack = stack.copy();

				insertStack.setCount(1);

				evaporator.getInventory().insertItem(0, insertStack, false);

				if (!player.isCreative())
					stack.shrink(1);
					
				worldIn.notifyBlockUpdate(pos, state, state, 2);	
				
				return true;
				
			} else if (stack.getItem() instanceof BucketItem && evaporator.getFluidTank().isEmpty() && evaporator
					.getFluidTank().isFluidValid(new FluidStack(((BucketItem) stack.getItem()).getFluid(), 1000))) {

				SoundEvent soundevent = ((BucketItem) stack.getItem()).getFluid().getAttributes().getEmptySound();

				player.playSound(soundevent, 1.0F, 1.0F);

				if (worldIn.isRemote)
					return true;

				evaporator.getFluidTank().fill(new FluidStack(((BucketItem) stack.getItem()).getFluid(), 1000),
						FluidAction.EXECUTE);
				
				if (!player.isCreative()) {
					int slot = player.inventory.getSlotFor(stack);

					player.inventory.setInventorySlotContents(slot, stack.getContainerItem());
				}
				
				worldIn.notifyBlockUpdate(pos, state, state, 2);
				
				return true;
			}
		}

		return false;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		
		if(blockIn==this)
			worldIn.setBlockState(pos, state.with(BURNING_STATE, worldIn.getBlockState(fromPos).get(BURNING_STATE)), 2);
		
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {

		return super.getStateForPlacement(context).with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		worldIn.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

		DoubleBlockHalf doubleblockhalf = state.get(HALF);
		BlockPos blockpos = doubleblockhalf == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.getBlock() == this && blockstate.get(HALF) != doubleblockhalf) {

			if (!worldIn.isRemote) {

				TileEntity tileentity = worldIn.getTileEntity(pos);
				if (tileentity instanceof PrimitvKeitwFluidEvaporatorTileEntity) {
					InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(),
							((PrimitvKeitwFluidEvaporatorTileEntity) tileentity).getInventory().getStackInSlot(0)
									.copy());
				}
			}
			worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 32);
			worldIn.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
			ItemStack itemstack = player.getHeldItemMainhand();
			if (!worldIn.isRemote && !player.isCreative()) {

				Block.spawnDrops(state, worldIn, pos, (TileEntity) null, player, itemstack);
				Block.spawnDrops(blockstate, worldIn, blockpos, (TileEntity) null, player, itemstack);
			}

		}

		super.onBlockHarvested(worldIn, pos, state, player);
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(HALF, FACING,BURNING_STATE);
	}

	@Override
	public boolean hasTileEntity(BlockState state) {

		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {

		return TileEntityTypeInit.PRIMITV_EVAPORATOR_TE.get().create();
	}
}
