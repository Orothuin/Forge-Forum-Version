package elementalalchemie.client.model.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class MoveIntoDarknessGoal extends MoveToBlockGoal {

	private int retreatRange;
	
	public MoveIntoDarknessGoal(CreatureEntity creature, double speedIn, int length) {
		super(creature, speedIn, length);
		retreatRange = length;
	}

	@Override
	public boolean shouldContinueExecuting() {
		
		return this.shouldMoveTo(this.creature.world, this.destinationBlock);
	}

	@Override
	protected int getRunDelay(CreatureEntity creatureIn) {

		return 5;
	}

	@Override
	protected boolean searchForDestination() {

		int i = retreatRange;
		int j = 1;
		BlockPos blockpos = new BlockPos(this.creature);
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
		BlockPos preferredPos = blockpos;
		
		
		for (int y = this.field_203112_e; y <= j; y = y > 0 ? -y : 1 - y) {
			
			for (int l = 0; l < i; ++l) {
				for (int x = 0; x <= l; x = x > 0 ? -x : 1 - x) {
					for (int z = x < l && x > -l ? l : 0; z <= l; z = z > 0 ? -z : 1 - z) {

						blockpos$mutableblockpos.setPos(blockpos).move(x, y - 1, z);

						if (this.creature.isWithinHomeDistanceFromPosition(blockpos$mutableblockpos)
								&& this.shouldMoveTo(this.creature.world, blockpos$mutableblockpos)) {

							int light1 = creature.world.getCombinedLight(blockpos$mutableblockpos, 0);

							int light2 = (creature.world.getFluidState(preferredPos).isEmpty()
									? creature.world.getCombinedLight(preferredPos, 0)
									: (15 << 20 | 0 << 4));

							if ((light1 < light2) ) {

									preferredPos = new BlockPos(blockpos$mutableblockpos);
							}
						}
					}
				}
			}
		}
		if (preferredPos.equals(blockpos))
			return false;
		else {
			this.destinationBlock = preferredPos;
			
			return true;
		}
	}

	@Override
	public boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {

		if (worldIn.getBlockState(pos).isAir(worldIn, pos) && this.creature.getPosition().distanceSq(pos) > 3
				&& worldIn.getBlockState(pos).getFluidState().isEmpty()) {

			return true;
		}
		return false;
	}

}
