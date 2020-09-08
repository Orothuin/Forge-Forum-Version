package elementalalchemie.init;

import java.util.ArrayList;
import java.util.function.Supplier;

import elementalalchemie.ElementalalchemieMod;
import elementalalchemie.blocks.BanQuadPartBlock;
import elementalalchemie.blocks.JuiceExtractorBlock;
import elementalalchemie.blocks.KeitwFluidBlock;
import elementalalchemie.blocks.PrimitivKeitwFluidEvaporator;
import elementalalchemie.blocks.KeitwPlantBlock;
import elementalalchemie.fluids.Keitw_Fluid;
import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ElementalalchemieMod.MODID);
	
	public static final ArrayList<RegistryObject<? extends Block>> itemblocks = new ArrayList<>();

	public static final RegistryObject<Block> KEITW_PLANT_BLOCK = BLOCKS.register("keitw_plant", ()-> new KeitwPlantBlock(Properties.from(Blocks.WHEAT)));
	public static final RegistryObject<Block> JUICE_EXTRACTOR_BLOCK = registerBlockandItem("juice_extractor", ()-> new JuiceExtractorBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5F)));
	public static final RegistryObject<FlowingFluidBlock> KEITW_FLUID_BLOCK = BLOCKS.register("keitw_fluid", ()->new KeitwFluidBlock(Keitw_Fluid.KEITW_FLUID::get,Properties.from(Blocks.WATER)));
	public static final RegistryObject<PrimitivKeitwFluidEvaporator> KEITW_FLUID_EVAPORATOR = registerBlockandItem("primitiv_keitw_fluid_evaporator", ()-> new PrimitivKeitwFluidEvaporator(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5F)));
	
	public static final RegistryObject<BanQuadPartBlock> BAN_QUAD_PART = registerBlockandItem("ban_quad_part", ()-> new BanQuadPartBlock());
	
	public static  <T extends Block> RegistryObject<T> registerBlockandItem(String name,Supplier<T> sup){
		
		RegistryObject<T> block =  BLOCKS.register(name,sup);
		itemblocks.add(block);
		return (RegistryObject<T>) block;
	}

}
