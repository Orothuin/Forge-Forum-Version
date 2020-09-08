package elementalalchemie.hitboxes;

import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;

public interface IFacedHitboxProvider {
	
	public VoxelShape getHitbox(Direction face);
}
