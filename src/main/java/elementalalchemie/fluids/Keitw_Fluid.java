package elementalalchemie.fluids;

import java.awt.Color;

import elementalalchemie.init.BlockInit;
import elementalalchemie.init.FluidInit;
import elementalalchemie.init.ItemInit;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;

public class Keitw_Fluid{
	
	public static final ResourceLocation KEITW_FLUID_SOURCE_TEXTURE = new ResourceLocation("minecraft","block/water_still");
	public static final ResourceLocation KEITW_FLUID_FLOWING_TEXTURE = new ResourceLocation("minecraft","block/water_flow");
	
	public static final RegistryObject<ForgeFlowingFluid> KEITW_FLUID = FluidInit.FLUIDS.register("keitw_fluid", ()-> new ForgeFlowingFluid.Source(Keitw_Fluid.KEITW_FLUID_PROPERTIES));
		
	public static final RegistryObject<ForgeFlowingFluid> KEITW_FLUID_FLOWING = FluidInit.FLUIDS.register("keitw_fluid_flowing", ()-> new ForgeFlowingFluid.Flowing(Keitw_Fluid.KEITW_FLUID_PROPERTIES));
		
	public static final ForgeFlowingFluid.Properties KEITW_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(()->KEITW_FLUID.get(),()-> KEITW_FLUID_FLOWING.get(), FluidAttributes.builder(KEITW_FLUID_SOURCE_TEXTURE, KEITW_FLUID_FLOWING_TEXTURE).sound(SoundEvents.ITEM_BUCKET_FILL, SoundEvents.ITEM_BUCKET_EMPTY).viscosity(1).color(new Color(236, 130, 58).getRGB())).block(BlockInit.KEITW_FLUID_BLOCK::get).bucket(ItemInit.KEITW_FLUID_BUCKET::get);
	
	
}
