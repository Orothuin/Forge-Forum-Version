package elementalalchemie.hitboxes;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class PrimitivKeitwFluidEvaporatorHitbox implements IFacedHitboxProvider {

	private static final VoxelShape bE0 = Block.makeCuboidShape(16.0D,0.0D,0.0D,0.0D,10.0D,16.0D);
	private static final VoxelShape bS0 = Block.makeCuboidShape(0.0D,0.0D,16.0D,16.0D,10.0D,0.0D);
	private static final VoxelShape bW0 = Block.makeCuboidShape(0.0D,0.0D,0.0D,16.0D,10.0D,16.0D);
	private static final VoxelShape bN0 = Block.makeCuboidShape(0.0D,0.0D,0.0D,16.0D,10.0D,16.0D);
	private static final VoxelShape bE1 = Block.makeCuboidShape(15.0D,19.0D,1.0D,1.0D,32.0D,15.0D);
	private static final VoxelShape bS1 = Block.makeCuboidShape(1.0D,19.0D,15.0D,15.0D,32.0D,1.0D);
	private static final VoxelShape bW1 = Block.makeCuboidShape(1.0D,19.0D,1.0D,15.0D,32.0D,15.0D);
	private static final VoxelShape bN1 = Block.makeCuboidShape(1.0D,19.0D,1.0D,15.0D,32.0D,15.0D);
	private static final VoxelShape v1_0E = VoxelShapes.or(bE0,bE1);
	private static final VoxelShape v1_0S = VoxelShapes.or(bS0,bS1);
	private static final VoxelShape v1_0W = VoxelShapes.or(bW0,bW1);
	private static final VoxelShape v1_0N = VoxelShapes.or(bN0,bN1);
	private static final VoxelShape bE2 = Block.makeCuboidShape(15.0D,10.0D,1.0D,1.0D,16.0D,2.0D);
	private static final VoxelShape bS2 = Block.makeCuboidShape(1.0D,10.0D,15.0D,2.0D,16.0D,1.0D);
	private static final VoxelShape bW2 = Block.makeCuboidShape(1.0D,10.0D,1.0D,15.0D,16.0D,2.0D);
	private static final VoxelShape bN2 = Block.makeCuboidShape(1.0D,10.0D,1.0D,2.0D,16.0D,15.0D);
	private static final VoxelShape bE3 = Block.makeCuboidShape(15.0D,10.0D,14.0D,1.0D,16.0D,15.0D);
	private static final VoxelShape bS3 = Block.makeCuboidShape(14.0D,10.0D,15.0D,15.0D,16.0D,1.0D);
	private static final VoxelShape bW3 = Block.makeCuboidShape(1.0D,10.0D,14.0D,15.0D,16.0D,15.0D);
	private static final VoxelShape bN3 = Block.makeCuboidShape(14.0D,10.0D,1.0D,15.0D,16.0D,15.0D);
	private static final VoxelShape v1_1E = VoxelShapes.or(bE2,bE3);
	private static final VoxelShape v1_1S = VoxelShapes.or(bS2,bS3);
	private static final VoxelShape v1_1W = VoxelShapes.or(bW2,bW3);
	private static final VoxelShape v1_1N = VoxelShapes.or(bN2,bN3);
	private static final VoxelShape bE4 = Block.makeCuboidShape(2.0D,10.0D,2.0D,1.0D,16.0D,14.0D);
	private static final VoxelShape bS4 = Block.makeCuboidShape(2.0D,10.0D,2.0D,14.0D,16.0D,1.0D);
	private static final VoxelShape bW4 = Block.makeCuboidShape(14.0D,10.0D,2.0D,15.0D,16.0D,14.0D);
	private static final VoxelShape bN4 = Block.makeCuboidShape(2.0D,10.0D,14.0D,14.0D,16.0D,15.0D);
	private static final VoxelShape bE5 = Block.makeCuboidShape(15.0D,10.0D,2.0D,14.0D,16.0D,14.0D);
	private static final VoxelShape bS5 = Block.makeCuboidShape(2.0D,10.0D,15.0D,14.0D,16.0D,14.0D);
	private static final VoxelShape bW5 = Block.makeCuboidShape(1.0D,10.0D,2.0D,2.0D,16.0D,14.0D);
	private static final VoxelShape bN5 = Block.makeCuboidShape(2.0D,10.0D,1.0D,14.0D,16.0D,2.0D);
	private static final VoxelShape v1_2E = VoxelShapes.or(bE4,bE5);
	private static final VoxelShape v1_2S = VoxelShapes.or(bS4,bS5);
	private static final VoxelShape v1_2W = VoxelShapes.or(bW4,bW5);
	private static final VoxelShape v1_2N = VoxelShapes.or(bN4,bN5);
	private static final VoxelShape bE6 = Block.makeCuboidShape(1.0D,22.0D,6.0D,0.0D,23.0D,11.0D);
	private static final VoxelShape bS6 = Block.makeCuboidShape(6.0D,22.0D,1.0D,11.0D,23.0D,0.0D);
	private static final VoxelShape bW6 = Block.makeCuboidShape(15.0D,22.0D,6.0D,16.0D,23.0D,11.0D);
	private static final VoxelShape bN6 = Block.makeCuboidShape(6.0D,22.0D,15.0D,11.0D,23.0D,16.0D);
	private static final VoxelShape bE7 = Block.makeCuboidShape(4.0D,17.0D,4.0D,3.0D,19.0D,13.0D);
	private static final VoxelShape bS7 = Block.makeCuboidShape(4.0D,17.0D,4.0D,13.0D,19.0D,3.0D);
	private static final VoxelShape bW7 = Block.makeCuboidShape(12.0D,17.0D,4.0D,13.0D,19.0D,13.0D);
	private static final VoxelShape bN7 = Block.makeCuboidShape(4.0D,17.0D,12.0D,13.0D,19.0D,13.0D);
	private static final VoxelShape v1_3E = VoxelShapes.or(bE6,bE7);
	private static final VoxelShape v1_3S = VoxelShapes.or(bS6,bS7);
	private static final VoxelShape v1_3W = VoxelShapes.or(bW6,bW7);
	private static final VoxelShape v1_3N = VoxelShapes.or(bN6,bN7);
	private static final VoxelShape bE8 = Block.makeCuboidShape(1.0D,27.0D,6.0D,0.0D,28.0D,10.0D);
	private static final VoxelShape bS8 = Block.makeCuboidShape(6.0D,27.0D,1.0D,10.0D,28.0D,0.0D);
	private static final VoxelShape bW8 = Block.makeCuboidShape(15.0D,27.0D,6.0D,16.0D,28.0D,10.0D);
	private static final VoxelShape bN8 = Block.makeCuboidShape(6.0D,27.0D,15.0D,10.0D,28.0D,16.0D);
	private static final VoxelShape bE9 = Block.makeCuboidShape(13.0D,17.0D,4.0D,12.0D,19.0D,12.0D);
	private static final VoxelShape bS9 = Block.makeCuboidShape(4.0D,17.0D,13.0D,12.0D,19.0D,12.0D);
	private static final VoxelShape bW9 = Block.makeCuboidShape(3.0D,17.0D,4.0D,4.0D,19.0D,12.0D);
	private static final VoxelShape bN9 = Block.makeCuboidShape(4.0D,17.0D,3.0D,12.0D,19.0D,4.0D);
	private static final VoxelShape v1_4E = VoxelShapes.or(bE8,bE9);
	private static final VoxelShape v1_4S = VoxelShapes.or(bS8,bS9);
	private static final VoxelShape v1_4W = VoxelShapes.or(bW8,bW9);
	private static final VoxelShape v1_4N = VoxelShapes.or(bN8,bN9);
	private static final VoxelShape bE10 = Block.makeCuboidShape(1.0D,23.0D,10.0D,0.0D,28.0D,11.0D);
	private static final VoxelShape bS10 = Block.makeCuboidShape(10.0D,23.0D,1.0D,11.0D,28.0D,0.0D);
	private static final VoxelShape bW10 = Block.makeCuboidShape(15.0D,23.0D,10.0D,16.0D,28.0D,11.0D);
	private static final VoxelShape bN10 = Block.makeCuboidShape(10.0D,23.0D,15.0D,11.0D,28.0D,16.0D);
	private static final VoxelShape bE11 = Block.makeCuboidShape(13.0D,17.0D,12.0D,4.0D,19.0D,13.0D);
	private static final VoxelShape bS11 = Block.makeCuboidShape(12.0D,17.0D,13.0D,13.0D,19.0D,4.0D);
	private static final VoxelShape bW11 = Block.makeCuboidShape(3.0D,17.0D,12.0D,12.0D,19.0D,13.0D);
	private static final VoxelShape bN11 = Block.makeCuboidShape(12.0D,17.0D,3.0D,13.0D,19.0D,12.0D);
	private static final VoxelShape v1_5E = VoxelShapes.or(bE10,bE11);
	private static final VoxelShape v1_5S = VoxelShapes.or(bS10,bS11);
	private static final VoxelShape v1_5W = VoxelShapes.or(bW10,bW11);
	private static final VoxelShape v1_5N = VoxelShapes.or(bN10,bN11);
	private static final VoxelShape bE12 = Block.makeCuboidShape(1.0D,22.0D,5.0D,0.0D,28.0D,6.0D);
	private static final VoxelShape bS12 = Block.makeCuboidShape(5.0D,22.0D,1.0D,6.0D,28.0D,0.0D);
	private static final VoxelShape bW12 = Block.makeCuboidShape(15.0D,22.0D,5.0D,16.0D,28.0D,6.0D);
	private static final VoxelShape bN12 = Block.makeCuboidShape(5.0D,22.0D,15.0D,6.0D,28.0D,16.0D);
	private static final VoxelShape bE13 = Block.makeCuboidShape(13.0D,17.0D,3.0D,3.0D,19.0D,4.0D);
	private static final VoxelShape bS13 = Block.makeCuboidShape(3.0D,17.0D,13.0D,4.0D,19.0D,3.0D);
	private static final VoxelShape bW13 = Block.makeCuboidShape(3.0D,17.0D,3.0D,13.0D,19.0D,4.0D);
	private static final VoxelShape bN13 = Block.makeCuboidShape(3.0D,17.0D,3.0D,4.0D,19.0D,13.0D);
	private static final VoxelShape v1_6E = VoxelShapes.or(bE12,bE13);
	private static final VoxelShape v1_6S = VoxelShapes.or(bS12,bS13);
	private static final VoxelShape v1_6W = VoxelShapes.or(bW12,bW13);
	private static final VoxelShape v1_6N = VoxelShapes.or(bN12,bN13);
	private static final VoxelShape bE14 = Block.makeCuboidShape(16.0D,14.0D,0.0D,15.0D,22.0D,1.0D);
	private static final VoxelShape bS14 = Block.makeCuboidShape(0.0D,14.0D,16.0D,1.0D,22.0D,15.0D);
	private static final VoxelShape bW14 = Block.makeCuboidShape(0.0D,14.0D,0.0D,1.0D,22.0D,1.0D);
	private static final VoxelShape bN14 = Block.makeCuboidShape(0.0D,14.0D,0.0D,1.0D,22.0D,1.0D);
	private static final VoxelShape bE15 = Block.makeCuboidShape(16.0D,14.0D,15.0D,15.0D,22.0D,16.0D);
	private static final VoxelShape bS15 = Block.makeCuboidShape(15.0D,14.0D,16.0D,16.0D,22.0D,15.0D);
	private static final VoxelShape bW15 = Block.makeCuboidShape(0.0D,14.0D,15.0D,1.0D,22.0D,16.0D);
	private static final VoxelShape bN15 = Block.makeCuboidShape(15.0D,14.0D,0.0D,16.0D,22.0D,1.0D);
	private static final VoxelShape v1_7E = VoxelShapes.or(bE14,bE15);
	private static final VoxelShape v1_7S = VoxelShapes.or(bS14,bS15);
	private static final VoxelShape v1_7W = VoxelShapes.or(bW14,bW15);
	private static final VoxelShape v1_7N = VoxelShapes.or(bN14,bN15);
	private static final VoxelShape bE16 = Block.makeCuboidShape(1.0D,14.0D,15.0D,0.0D,22.0D,16.0D);
	private static final VoxelShape bS16 = Block.makeCuboidShape(15.0D,14.0D,1.0D,16.0D,22.0D,0.0D);
	private static final VoxelShape bW16 = Block.makeCuboidShape(15.0D,14.0D,15.0D,16.0D,22.0D,16.0D);
	private static final VoxelShape bN16 = Block.makeCuboidShape(15.0D,14.0D,15.0D,16.0D,22.0D,16.0D);
	private static final VoxelShape bE17 = Block.makeCuboidShape(1.0D,14.0D,0.0D,0.0D,22.0D,1.0D);
	private static final VoxelShape bS17 = Block.makeCuboidShape(0.0D,14.0D,1.0D,1.0D,22.0D,0.0D);
	private static final VoxelShape bW17 = Block.makeCuboidShape(15.0D,14.0D,0.0D,16.0D,22.0D,1.0D);
	private static final VoxelShape bN17 = Block.makeCuboidShape(0.0D,14.0D,15.0D,1.0D,22.0D,16.0D);
	private static final VoxelShape v1_8E = VoxelShapes.or(bE16,bE17);
	private static final VoxelShape v1_8S = VoxelShapes.or(bS16,bS17);
	private static final VoxelShape v1_8W = VoxelShapes.or(bW16,bW17);
	private static final VoxelShape v1_8N = VoxelShapes.or(bN16,bN17);
	private static final VoxelShape bE18 = Block.makeCuboidShape(15.0D,13.0D,0.0D,14.0D,21.0D,1.0D);
	private static final VoxelShape bS18 = Block.makeCuboidShape(0.0D,13.0D,15.0D,1.0D,21.0D,14.0D);
	private static final VoxelShape bW18 = Block.makeCuboidShape(1.0D,13.0D,0.0D,2.0D,21.0D,1.0D);
	private static final VoxelShape bN18 = Block.makeCuboidShape(0.0D,13.0D,1.0D,1.0D,21.0D,2.0D);
	private static final VoxelShape bE19 = Block.makeCuboidShape(15.0D,13.0D,15.0D,14.0D,21.0D,16.0D);
	private static final VoxelShape bS19 = Block.makeCuboidShape(15.0D,13.0D,15.0D,16.0D,21.0D,14.0D);
	private static final VoxelShape bW19 = Block.makeCuboidShape(1.0D,13.0D,15.0D,2.0D,21.0D,16.0D);
	private static final VoxelShape bN19 = Block.makeCuboidShape(15.0D,13.0D,1.0D,16.0D,21.0D,2.0D);
	private static final VoxelShape v1_9E = VoxelShapes.or(bE18,bE19);
	private static final VoxelShape v1_9S = VoxelShapes.or(bS18,bS19);
	private static final VoxelShape v1_9W = VoxelShapes.or(bW18,bW19);
	private static final VoxelShape v1_9N = VoxelShapes.or(bN18,bN19);
	private static final VoxelShape bE20 = Block.makeCuboidShape(2.0D,13.0D,15.0D,1.0D,21.0D,16.0D);
	private static final VoxelShape bS20 = Block.makeCuboidShape(15.0D,13.0D,2.0D,16.0D,21.0D,1.0D);
	private static final VoxelShape bW20 = Block.makeCuboidShape(14.0D,13.0D,15.0D,15.0D,21.0D,16.0D);
	private static final VoxelShape bN20 = Block.makeCuboidShape(15.0D,13.0D,14.0D,16.0D,21.0D,15.0D);
	private static final VoxelShape bE21 = Block.makeCuboidShape(2.0D,13.0D,0.0D,1.0D,21.0D,1.0D);
	private static final VoxelShape bS21 = Block.makeCuboidShape(0.0D,13.0D,2.0D,1.0D,21.0D,1.0D);
	private static final VoxelShape bW21 = Block.makeCuboidShape(14.0D,13.0D,0.0D,15.0D,21.0D,1.0D);
	private static final VoxelShape bN21 = Block.makeCuboidShape(0.0D,13.0D,14.0D,1.0D,21.0D,15.0D);
	private static final VoxelShape v1_10E = VoxelShapes.or(bE20,bE21);
	private static final VoxelShape v1_10S = VoxelShapes.or(bS20,bS21);
	private static final VoxelShape v1_10W = VoxelShapes.or(bW20,bW21);
	private static final VoxelShape v1_10N = VoxelShapes.or(bN20,bN21);
	private static final VoxelShape bE22 = Block.makeCuboidShape(16.0D,13.0D,1.0D,15.0D,21.0D,2.0D);
	private static final VoxelShape bS22 = Block.makeCuboidShape(1.0D,13.0D,16.0D,2.0D,21.0D,15.0D);
	private static final VoxelShape bW22 = Block.makeCuboidShape(0.0D,13.0D,1.0D,1.0D,21.0D,2.0D);
	private static final VoxelShape bN22 = Block.makeCuboidShape(1.0D,13.0D,0.0D,2.0D,21.0D,1.0D);
	private static final VoxelShape bE23 = Block.makeCuboidShape(16.0D,13.0D,14.0D,15.0D,21.0D,15.0D);
	private static final VoxelShape bS23 = Block.makeCuboidShape(14.0D,13.0D,16.0D,15.0D,21.0D,15.0D);
	private static final VoxelShape bW23 = Block.makeCuboidShape(0.0D,13.0D,14.0D,1.0D,21.0D,15.0D);
	private static final VoxelShape bN23 = Block.makeCuboidShape(14.0D,13.0D,0.0D,15.0D,21.0D,1.0D);
	private static final VoxelShape v1_11E = VoxelShapes.or(bE22,bE23);
	private static final VoxelShape v1_11S = VoxelShapes.or(bS22,bS23);
	private static final VoxelShape v1_11W = VoxelShapes.or(bW22,bW23);
	private static final VoxelShape v1_11N = VoxelShapes.or(bN22,bN23);
	private static final VoxelShape bE24 = Block.makeCuboidShape(1.0D,13.0D,14.0D,0.0D,21.0D,15.0D);
	private static final VoxelShape bS24 = Block.makeCuboidShape(14.0D,13.0D,1.0D,15.0D,21.0D,0.0D);
	private static final VoxelShape bW24 = Block.makeCuboidShape(15.0D,13.0D,14.0D,16.0D,21.0D,15.0D);
	private static final VoxelShape bN24 = Block.makeCuboidShape(14.0D,13.0D,15.0D,15.0D,21.0D,16.0D);
	private static final VoxelShape bE25 = Block.makeCuboidShape(1.0D,13.0D,1.0D,0.0D,21.0D,2.0D);
	private static final VoxelShape bS25 = Block.makeCuboidShape(1.0D,13.0D,1.0D,2.0D,21.0D,0.0D);
	private static final VoxelShape bW25 = Block.makeCuboidShape(15.0D,13.0D,1.0D,16.0D,21.0D,2.0D);
	private static final VoxelShape bN25 = Block.makeCuboidShape(1.0D,13.0D,15.0D,2.0D,21.0D,16.0D);
	private static final VoxelShape v1_12E = VoxelShapes.or(bE24,bE25);
	private static final VoxelShape v1_12S = VoxelShapes.or(bS24,bS25);
	private static final VoxelShape v1_12W = VoxelShapes.or(bW24,bW25);
	private static final VoxelShape v1_12N = VoxelShapes.or(bN24,bN25);
	private static final VoxelShape v1_13E = Block.makeCuboidShape(12.0D,18.0D,4.0D,4.0D,18.0D,12.0D);
	private static final VoxelShape v1_13S = Block.makeCuboidShape(4.0D,18.0D,12.0D,12.0D,18.0D,4.0D);
	private static final VoxelShape v1_13W = Block.makeCuboidShape(4.0D,18.0D,4.0D,12.0D,18.0D,12.0D);
	private static final VoxelShape v1_13N = Block.makeCuboidShape(4.0D,18.0D,4.0D,12.0D,18.0D,12.0D);

	private static final VoxelShape v2_0E = VoxelShapes.or(v1_0E,v1_1E);
	private static final VoxelShape v2_0S = VoxelShapes.or(v1_0S,v1_1S);
	private static final VoxelShape v2_0W = VoxelShapes.or(v1_0W,v1_1W);
	private static final VoxelShape v2_0N = VoxelShapes.or(v1_0N,v1_1N);
	private static final VoxelShape v2_1E = VoxelShapes.or(v1_2E,v1_3E);
	private static final VoxelShape v2_1S = VoxelShapes.or(v1_2S,v1_3S);
	private static final VoxelShape v2_1W = VoxelShapes.or(v1_2W,v1_3W);
	private static final VoxelShape v2_1N = VoxelShapes.or(v1_2N,v1_3N);
	private static final VoxelShape v2_2E = VoxelShapes.or(v1_4E,v1_5E);
	private static final VoxelShape v2_2S = VoxelShapes.or(v1_4S,v1_5S);
	private static final VoxelShape v2_2W = VoxelShapes.or(v1_4W,v1_5W);
	private static final VoxelShape v2_2N = VoxelShapes.or(v1_4N,v1_5N);
	private static final VoxelShape v2_3E = VoxelShapes.or(v1_6E,v1_7E);
	private static final VoxelShape v2_3S = VoxelShapes.or(v1_6S,v1_7S);
	private static final VoxelShape v2_3W = VoxelShapes.or(v1_6W,v1_7W);
	private static final VoxelShape v2_3N = VoxelShapes.or(v1_6N,v1_7N);
	private static final VoxelShape v2_4E = VoxelShapes.or(v1_8E,v1_9E);
	private static final VoxelShape v2_4S = VoxelShapes.or(v1_8S,v1_9S);
	private static final VoxelShape v2_4W = VoxelShapes.or(v1_8W,v1_9W);
	private static final VoxelShape v2_4N = VoxelShapes.or(v1_8N,v1_9N);
	private static final VoxelShape v2_5E = VoxelShapes.or(v1_10E,v1_11E);
	private static final VoxelShape v2_5S = VoxelShapes.or(v1_10S,v1_11S);
	private static final VoxelShape v2_5W = VoxelShapes.or(v1_10W,v1_11W);
	private static final VoxelShape v2_5N = VoxelShapes.or(v1_10N,v1_11N);
	private static final VoxelShape v2_6E = VoxelShapes.or(v1_12E,v1_13E);
	private static final VoxelShape v2_6S = VoxelShapes.or(v1_12S,v1_13S);
	private static final VoxelShape v2_6W = VoxelShapes.or(v1_12W,v1_13W);
	private static final VoxelShape v2_6N = VoxelShapes.or(v1_12N,v1_13N);

	private static final VoxelShape v3_0E = VoxelShapes.or(v2_0E,v2_1E);
	private static final VoxelShape v3_0S = VoxelShapes.or(v2_0S,v2_1S);
	private static final VoxelShape v3_0W = VoxelShapes.or(v2_0W,v2_1W);
	private static final VoxelShape v3_0N = VoxelShapes.or(v2_0N,v2_1N);
	private static final VoxelShape v3_1E = VoxelShapes.or(v2_2E,v2_3E);
	private static final VoxelShape v3_1S = VoxelShapes.or(v2_2S,v2_3S);
	private static final VoxelShape v3_1W = VoxelShapes.or(v2_2W,v2_3W);
	private static final VoxelShape v3_1N = VoxelShapes.or(v2_2N,v2_3N);
	private static final VoxelShape v3_2E = VoxelShapes.or(v2_4E,v2_5E);
	private static final VoxelShape v3_2S = VoxelShapes.or(v2_4S,v2_5S);
	private static final VoxelShape v3_2W = VoxelShapes.or(v2_4W,v2_5W);
	private static final VoxelShape v3_2N = VoxelShapes.or(v2_4N,v2_5N);

	private static final VoxelShape v4_0E = VoxelShapes.or(v3_0E,v3_1E);
	private static final VoxelShape v4_0S = VoxelShapes.or(v3_0S,v3_1S);
	private static final VoxelShape v4_0W = VoxelShapes.or(v3_0W,v3_1W);
	private static final VoxelShape v4_0N = VoxelShapes.or(v3_0N,v3_1N);

	private static final VoxelShape cV0E = VoxelShapes.or(v2_6E,v4_0E);
	private static final VoxelShape cV0S = VoxelShapes.or(v2_6S,v4_0S);
	private static final VoxelShape cV0W = VoxelShapes.or(v2_6W,v4_0W);
	private static final VoxelShape cV0N = VoxelShapes.or(v2_6N,v4_0N);
	private static final VoxelShape resultE = VoxelShapes.or(v3_2E,cV0E);
	private static final VoxelShape resultS = VoxelShapes.or(v3_2S,cV0S);
	private static final VoxelShape resultW = VoxelShapes.or(v3_2W,cV0W);
	private static final VoxelShape resultN = VoxelShapes.or(v3_2N,cV0N);

	@Override
	public VoxelShape getHitbox(Direction face) {

		switch (face) {
		case NORTH:
			
			return resultN;
		case EAST:

			return resultE;
		case SOUTH:

			return resultS;
		case WEST:

			return resultW;
		default:
			return resultN;
		}
	}
}
