package elementalalchemie.init;

import elementalalchemie.ElementalalchemieMod;
import elementalalchemie.tileentitys.BanQuadPartTileEntity;
import elementalalchemie.tileentitys.JuiceExtractorTileEntity;
import elementalalchemie.tileentitys.PrimitvKeitwFluidEvaporatorTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeInit {
	
	public static final DeferredRegister<TileEntityType<?>> TILEENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, ElementalalchemieMod.MODID);

	public static final RegistryObject<TileEntityType<JuiceExtractorTileEntity>> JUICE_EXTRACTOR_TE = TILEENTITY_TYPES.register(
			"juice_extractor",
			() -> TileEntityType.Builder.create(JuiceExtractorTileEntity::new, BlockInit.JUICE_EXTRACTOR_BLOCK.get()).build(null));
	
	public static final RegistryObject<TileEntityType<PrimitvKeitwFluidEvaporatorTileEntity>> PRIMITV_EVAPORATOR_TE = TILEENTITY_TYPES.register("primitiv_keitw_fluid_evaporator", ()->TileEntityType.Builder.create(()-> new PrimitvKeitwFluidEvaporatorTileEntity(), BlockInit.KEITW_FLUID_EVAPORATOR.get()).build(null));
	
	public static final RegistryObject<TileEntityType<BanQuadPartTileEntity>> BAN_QUAD_PART_TE = TILEENTITY_TYPES.register("ban_quad_part", ()->TileEntityType.Builder.create(()-> new BanQuadPartTileEntity(), BlockInit.BAN_QUAD_PART.get()).build(null));

}
