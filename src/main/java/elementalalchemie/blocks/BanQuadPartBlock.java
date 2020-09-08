package elementalalchemie.blocks;

import java.util.ArrayList;

import elementalalchemie.init.BlockInit;
import elementalalchemie.init.CapabilityInit;
import elementalalchemie.init.TileEntityTypeInit;
import elementalalchemie.tileentitys.BanQuadPartTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BanQuadPartBlock extends Block {

	public static final BooleanProperty COMPLETE = BooleanProperty.create("complete");

	private static final int MAX_QUAD_FINDER_RECUSIONS = 1000;

	public BanQuadPartBlock() {
		super(Properties.from(Blocks.STONE));
		setDefaultState(this.stateContainer.getBaseState().with(COMPLETE, false));
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {

		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);

		if (!worldIn.isRemote) {

			System.out.println("da name:" + placer.getCapability(CapabilityInit.ELEMENTAL_BEEING, Direction.NORTH)
					.orElse(null).getElemental().getName());

			System.out.println(placer.getCapability(CapabilityInit.ELEMENTAL_BEEING, Direction.NORTH).orElse(null)
					.getElemental().getEnergyOutput());
			
			ArrayList<BlockPos> banQuadStones = new ArrayList<>();
			int width;
			System.err.println("FOUND:" + (width = checkBanQuad(worldIn, pos, new BlockPos(pos), null, false, null,
					banQuadStones, 0, 0, 0)));

			if (width > 0)
				for (BlockPos p : banQuadStones) {
					worldIn.setBlockState(p, worldIn.getBlockState(p).with(COMPLETE, true), 2);
					((BanQuadPartTileEntity)worldIn.getTileEntity(p)).setPlacer(placer);
				}

			System.out.println("CENTER:" + getBanQuadCenter(worldIn, pos));

		}
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {

		if (!worldIn.isRemote) {

			ArrayList<BlockPos> banQuadStones = new ArrayList<>();
			checkBanQuad(worldIn, pos, new BlockPos(pos), null, false, null, banQuadStones, 0, 0, 0);

			for (BlockPos p : banQuadStones)
				worldIn.setBlockState(p, worldIn.getBlockState(p).with(COMPLETE, false));
		}

		super.onBlockHarvested(worldIn, pos, state, player);
	}

	private static int checkBanQuad(World worldIn, BlockPos startPos, BlockPos currPos, Direction dir,
			boolean setCorner, Corner corner, ArrayList<BlockPos> banQuadStones, int width, int maxWidth, int iter) {

		iter += 1;
		if (iter > MAX_QUAD_FINDER_RECUSIONS)
			return 0;

		if (setCorner && startPos.equals(currPos)) {
			//System.out.println(maxWidth + 2);
			return maxWidth + 2;
		}
		if (banQuadStones != null)
			banQuadStones.add(currPos);

		if (dir != null && worldIn.getBlockState(currPos.offset(dir)).getBlock() == BlockInit.BAN_QUAD_PART.get()) {

			return checkBanQuad(worldIn, startPos, currPos.offset(dir), dir, setCorner, corner, banQuadStones,
					width + 1, width < maxWidth ? maxWidth : maxWidth + 1, iter);
		} else if (width < maxWidth) {
			return 0;
		} else if (worldIn.getBlockState(currPos.north()).getBlock() == BlockInit.BAN_QUAD_PART.get()
				&& (dir == null || Direction.NORTH != dir.getOpposite())
				&& (!setCorner || getCorner(dir, Direction.NORTH) == corner)) {

			if (dir != null && !setCorner) {
				Corner c = getCorner(dir, Direction.NORTH);
				return checkBanQuad(worldIn, startPos, currPos.north(), Direction.NORTH, true, c, banQuadStones, 0,
						maxWidth, iter);
			} else
				return checkBanQuad(worldIn, startPos, currPos.north(), Direction.NORTH, setCorner, corner,
						banQuadStones, 0, maxWidth, iter);
		} else if (worldIn.getBlockState(currPos.east()).getBlock() == BlockInit.BAN_QUAD_PART.get()
				&& (dir == null || Direction.EAST != dir.getOpposite())
				&& (!setCorner || getCorner(dir, Direction.EAST) == corner))

			if (dir != null && !setCorner) {
				Corner c = getCorner(dir, Direction.EAST);
				return checkBanQuad(worldIn, startPos, currPos.east(), Direction.EAST, true, c, banQuadStones, 0,
						maxWidth, iter);
			} else
				return checkBanQuad(worldIn, startPos, currPos.east(), Direction.EAST, setCorner, corner, banQuadStones,
						0, maxWidth, iter);

		else if (worldIn.getBlockState(currPos.south()).getBlock() == BlockInit.BAN_QUAD_PART.get()
				&& (dir == null || Direction.SOUTH != dir.getOpposite())
				&& (!setCorner || getCorner(dir, Direction.SOUTH) == corner))
			if (dir != null && !setCorner) {
				Corner c = getCorner(dir, Direction.SOUTH);
				return checkBanQuad(worldIn, startPos, currPos.south(), Direction.SOUTH, true, c, banQuadStones, 0,
						maxWidth, iter);
			} else
				return checkBanQuad(worldIn, startPos, currPos.south(), Direction.SOUTH, setCorner, corner,
						banQuadStones, 0, maxWidth, iter);

		else if (worldIn.getBlockState(currPos.west()).getBlock() == BlockInit.BAN_QUAD_PART.get()
				&& (dir == null || Direction.WEST != dir.getOpposite())
				&& (!setCorner || getCorner(dir, Direction.WEST) == corner))
			if (dir != null && !setCorner) {
				Corner c = getCorner(dir, Direction.WEST);
				return checkBanQuad(worldIn, startPos, currPos.west(), Direction.WEST, true, c, banQuadStones, 0,
						maxWidth, iter);
			} else
				return checkBanQuad(worldIn, startPos, currPos.west(), Direction.WEST, setCorner, corner, banQuadStones,
						0, maxWidth, iter);

		return 0;
	}

	public static int getBanQuadSize(World world, BlockPos pos) {
		return checkBanQuad(world, pos, pos, null, false, null, null, 0, 0, 0);
	}

	public static BlockPos getBanQuadCenter(World world, BlockPos pos) {

		ArrayList<BlockPos> banQuadStones = new ArrayList<>();

		checkBanQuad(world, pos, pos, null, false, null, banQuadStones, 0, 0, 0);

		double x = 0, y = 0, z = 0;

		for (BlockPos p : banQuadStones) {
			x += p.getX();
			y += p.getY();
			z += p.getZ();
		}

		return new BlockPos(x / banQuadStones.size(), y / banQuadStones.size(), z / banQuadStones.size());
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(COMPLETE);
	}

	private static Corner getCorner(Direction dirOne, Direction dirSec) {

		Direction d = Direction.byHorizontalIndex(getDirectionIndex(dirOne) + 1);

		Corner c = d == dirSec ? Corner.RIGHT_CORNER : Corner.LEFT_CORNER;
		return c;
	}

	private static int getDirectionIndex(Direction dir) {

		switch (dir) {
		case NORTH:
			return 2;
		case EAST:
			return 3;
		case SOUTH:
			return 0;
		case WEST:
			return 1;

		default:
			return 2;
		}
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityTypeInit.BAN_QUAD_PART_TE.get().create();
	}
	
	private enum Corner {
		LEFT_CORNER, RIGHT_CORNER
	}
}
