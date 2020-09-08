package elementalalchemie.init;

import elementalalchemie.ElementalalchemieMod;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {
	
	//Fluids are registered in a Fluid-Class to keep this clean
	public static DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS, ElementalalchemieMod.MODID);
	
	}
