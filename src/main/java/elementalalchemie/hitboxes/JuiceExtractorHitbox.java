package elementalalchemie.hitboxes;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class JuiceExtractorHitbox implements IFacedHitboxProvider {

	private static final VoxelShape bE0 = Block.makeCuboidShape(15.0D, 0.0D, 1.0D, 1.0D, 5.0D, 15.0D);
	private static final VoxelShape bS0 = Block.makeCuboidShape(1.0D, 0.0D, 15.0D, 15.0D, 5.0D, 1.0D);
	private static final VoxelShape bW0 = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 5.0D, 15.0D);
	private static final VoxelShape bN0 = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 5.0D, 15.0D);
	private static final VoxelShape bE1 = Block.makeCuboidShape(14.0D, 5.0D, 2.0D, 13.0D, 14.0D, 14.0D);
	private static final VoxelShape bS1 = Block.makeCuboidShape(2.0D, 5.0D, 14.0D, 14.0D, 14.0D, 13.0D);
	private static final VoxelShape bW1 = Block.makeCuboidShape(2.0D, 5.0D, 2.0D, 3.0D, 14.0D, 14.0D);
	private static final VoxelShape bN1 = Block.makeCuboidShape(2.0D, 5.0D, 2.0D, 14.0D, 14.0D, 3.0D);
	private static final VoxelShape v1_0E = VoxelShapes.or(bE1, bE0);
	private static final VoxelShape v1_0S = VoxelShapes.or(bS1, bS0);
	private static final VoxelShape v1_0W = VoxelShapes.or(bW1, bW0);
	private static final VoxelShape v1_0N = VoxelShapes.or(bN1, bN0);
	private static final VoxelShape bE2 = Block.makeCuboidShape(3.0D, 4.0D, 2.0D, 2.0D, 14.0D, 14.0D);
	private static final VoxelShape bS2 = Block.makeCuboidShape(2.0D, 4.0D, 3.0D, 14.0D, 14.0D, 2.0D);
	private static final VoxelShape bW2 = Block.makeCuboidShape(13.0D, 4.0D, 2.0D, 14.0D, 14.0D, 14.0D);
	private static final VoxelShape bN2 = Block.makeCuboidShape(2.0D, 4.0D, 13.0D, 14.0D, 14.0D, 14.0D);
	private static final VoxelShape bE3 = Block.makeCuboidShape(13.0D, 5.0D, 13.0D, 3.0D, 14.0D, 14.0D);
	private static final VoxelShape bS3 = Block.makeCuboidShape(13.0D, 5.0D, 13.0D, 14.0D, 14.0D, 3.0D);
	private static final VoxelShape bW3 = Block.makeCuboidShape(3.0D, 5.0D, 13.0D, 13.0D, 14.0D, 14.0D);
	private static final VoxelShape bN3 = Block.makeCuboidShape(13.0D, 5.0D, 3.0D, 14.0D, 14.0D, 13.0D);
	private static final VoxelShape v1_1E = VoxelShapes.or(bE3, bE2);
	private static final VoxelShape v1_1S = VoxelShapes.or(bS3, bS2);
	private static final VoxelShape v1_1W = VoxelShapes.or(bW3, bW2);
	private static final VoxelShape v1_1N = VoxelShapes.or(bN3, bN2);
	private static final VoxelShape bE4 = Block.makeCuboidShape(13.0D, 5.0D, 2.0D, 3.0D, 14.0D, 3.0D);
	private static final VoxelShape bS4 = Block.makeCuboidShape(2.0D, 5.0D, 13.0D, 3.0D, 14.0D, 3.0D);
	private static final VoxelShape bW4 = Block.makeCuboidShape(3.0D, 5.0D, 2.0D, 13.0D, 14.0D, 3.0D);
	private static final VoxelShape bN4 = Block.makeCuboidShape(2.0D, 5.0D, 3.0D, 3.0D, 14.0D, 13.0D);
	private static final VoxelShape bE5 = Block.makeCuboidShape(16.0D, 9.0D, 6.0D, 14.0D, 10.0D, 7.0D);
	private static final VoxelShape bS5 = Block.makeCuboidShape(6.0D, 9.0D, 16.0D, 7.0D, 10.0D, 14.0D);
	private static final VoxelShape bW5 = Block.makeCuboidShape(0.0D, 9.0D, 6.0D, 2.0D, 10.0D, 7.0D);
	private static final VoxelShape bN5 = Block.makeCuboidShape(6.0D, 9.0D, 0.0D, 7.0D, 10.0D, 2.0D);
	private static final VoxelShape v1_2E = VoxelShapes.or(bE5, bE4);
	private static final VoxelShape v1_2S = VoxelShapes.or(bS5, bS4);
	private static final VoxelShape v1_2W = VoxelShapes.or(bW5, bW4);
	private static final VoxelShape v1_2N = VoxelShapes.or(bN5, bN4);
	private static final VoxelShape bE6 = Block.makeCuboidShape(16.0D, 8.0D, 6.0D, 14.0D, 9.0D, 10.0D);
	private static final VoxelShape bS6 = Block.makeCuboidShape(6.0D, 8.0D, 16.0D, 10.0D, 9.0D, 14.0D);
	private static final VoxelShape bW6 = Block.makeCuboidShape(0.0D, 8.0D, 6.0D, 2.0D, 9.0D, 10.0D);
	private static final VoxelShape bN6 = Block.makeCuboidShape(6.0D, 8.0D, 0.0D, 10.0D, 9.0D, 2.0D);
	private static final VoxelShape bE7 = Block.makeCuboidShape(16.0D, 9.0D, 9.0D, 14.0D, 10.0D, 10.0D);
	private static final VoxelShape bS7 = Block.makeCuboidShape(9.0D, 9.0D, 16.0D, 10.0D, 10.0D, 14.0D);
	private static final VoxelShape bW7 = Block.makeCuboidShape(0.0D, 9.0D, 9.0D, 2.0D, 10.0D, 10.0D);
	private static final VoxelShape bN7 = Block.makeCuboidShape(9.0D, 9.0D, 0.0D, 10.0D, 10.0D, 2.0D);
	private static final VoxelShape v1_3E = VoxelShapes.or(bE7, bE6);
	private static final VoxelShape v1_3S = VoxelShapes.or(bS7, bS6);
	private static final VoxelShape v1_3W = VoxelShapes.or(bW7, bW6);
	private static final VoxelShape v1_3N = VoxelShapes.or(bN7, bN6);
	private static final VoxelShape bE8 = Block.makeCuboidShape(13.0D, 5.0D, 1.0D, 1.0D, 11.0D, 2.0D);
	private static final VoxelShape bS8 = Block.makeCuboidShape(1.0D, 5.0D, 13.0D, 2.0D, 11.0D, 1.0D);
	private static final VoxelShape bW8 = Block.makeCuboidShape(3.0D, 5.0D, 1.0D, 15.0D, 11.0D, 2.0D);
	private static final VoxelShape bN8 = Block.makeCuboidShape(1.0D, 5.0D, 3.0D, 2.0D, 11.0D, 15.0D);
	private static final VoxelShape bE9 = Block.makeCuboidShape(13.0D, 5.0D, 14.0D, 1.0D, 11.0D, 15.0D);
	private static final VoxelShape bS9 = Block.makeCuboidShape(14.0D, 5.0D, 13.0D, 15.0D, 11.0D, 1.0D);
	private static final VoxelShape bW9 = Block.makeCuboidShape(3.0D, 5.0D, 14.0D, 15.0D, 11.0D, 15.0D);
	private static final VoxelShape bN9 = Block.makeCuboidShape(14.0D, 5.0D, 3.0D, 15.0D, 11.0D, 15.0D);
	private static final VoxelShape v1_4E = VoxelShapes.or(bE9, bE8);
	private static final VoxelShape v1_4S = VoxelShapes.or(bS9, bS8);
	private static final VoxelShape v1_4W = VoxelShapes.or(bW9, bW8);
	private static final VoxelShape v1_4N = VoxelShapes.or(bN9, bN8);
	private static final VoxelShape v1_5E = Block.makeCuboidShape(2.0D, 5.0D, 2.0D, 1.0D, 11.0D, 14.0D);
	private static final VoxelShape v1_5S = Block.makeCuboidShape(2.0D, 5.0D, 2.0D, 14.0D, 11.0D, 1.0D);
	private static final VoxelShape v1_5W = Block.makeCuboidShape(14.0D, 5.0D, 2.0D, 15.0D, 11.0D, 14.0D);
	private static final VoxelShape v1_5N = Block.makeCuboidShape(2.0D, 5.0D, 14.0D, 14.0D, 11.0D, 15.0D);

	private static final VoxelShape v2_0E = VoxelShapes.or(v1_0E, v1_1E);
	private static final VoxelShape v2_0S = VoxelShapes.or(v1_0S, v1_1S);
	private static final VoxelShape v2_0W = VoxelShapes.or(v1_0W, v1_1W);
	private static final VoxelShape v2_0N = VoxelShapes.or(v1_0N, v1_1N);
	private static final VoxelShape v2_1E = VoxelShapes.or(v1_2E, v1_3E);
	private static final VoxelShape v2_1S = VoxelShapes.or(v1_2S, v1_3S);
	private static final VoxelShape v2_1W = VoxelShapes.or(v1_2W, v1_3W);
	private static final VoxelShape v2_1N = VoxelShapes.or(v1_2N, v1_3N);
	private static final VoxelShape v2_2E = VoxelShapes.or(v1_4E, v1_5E);
	private static final VoxelShape v2_2S = VoxelShapes.or(v1_4S, v1_5S);
	private static final VoxelShape v2_2W = VoxelShapes.or(v1_4W, v1_5W);
	private static final VoxelShape v2_2N = VoxelShapes.or(v1_4N, v1_5N);

	private static final VoxelShape v3_0E = VoxelShapes.or(v2_0E, v2_1E);
	private static final VoxelShape v3_0S = VoxelShapes.or(v2_0S, v2_1S);
	private static final VoxelShape v3_0W = VoxelShapes.or(v2_0W, v2_1W);
	private static final VoxelShape v3_0N = VoxelShapes.or(v2_0N, v2_1N);

	private static final VoxelShape cV0E = VoxelShapes.or(v2_2E, v3_0E);
	private static final VoxelShape cV0S = VoxelShapes.or(v2_2S, v3_0S);
	private static final VoxelShape cV0W = VoxelShapes.or(v2_2W, v3_0W);
	private static final VoxelShape cV0N = VoxelShapes.or(v2_2N, v3_0N);

	@Override
	public VoxelShape getHitbox(Direction face) {

		switch (face) {
		case NORTH:
			
			return cV0N;
		case EAST:

			return cV0E;
		case SOUTH:

			return cV0S;
		case WEST:

			return cV0W;
		default:
			return cV0N;
		}
	}
}
