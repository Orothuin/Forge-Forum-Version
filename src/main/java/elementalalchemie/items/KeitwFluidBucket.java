package elementalalchemie.items;

import java.util.function.Supplier;

import elementalalchemie.DispenseBehaviors;
import net.minecraft.block.DispenserBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;

public class KeitwFluidBucket extends BucketItem{

	public KeitwFluidBucket(Supplier<? extends Fluid> supplier, Properties builder) {
		super(supplier, builder);
		DispenserBlock.registerDispenseBehavior(this, DispenseBehaviors.LIQUIED_BUCKED_BEHAVIOR);
	}
	
}
