package elementalalchemie.blocks;

import java.util.function.Supplier;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;

public class KeitwFluidBlock extends FlowingFluidBlock{

	public KeitwFluidBlock(Supplier<? extends FlowingFluid> supplier, Properties properties) {
		super(supplier, properties);
	}
}
