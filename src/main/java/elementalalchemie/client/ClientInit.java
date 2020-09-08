package elementalalchemie.client;

import elementalalchemie.ElementalalchemieMod;
import elementalalchemie.client.renderer.entitys.StoneTurtleRenderer;
import elementalalchemie.client.renderer.tileentitys.JuiceExtractorRenderer;
import elementalalchemie.client.renderer.tileentitys.PrimitivEvaporatorRenderer;
import elementalalchemie.entitys.StoneTurtleEntity;
import elementalalchemie.tileentitys.JuiceExtractorTileEntity;
import elementalalchemie.tileentitys.PrimitvKeitwFluidEvaporatorTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientInit {
	
	public static final ResourceLocation GASBLOCK_MODEL_LOCATION =new ResourceLocation(ElementalalchemieMod.MODID, "block/gasblock");
	
	public static void init() {
		
		ClientRegistry.bindTileEntitySpecialRenderer(JuiceExtractorTileEntity.class, new JuiceExtractorRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(PrimitvKeitwFluidEvaporatorTileEntity.class, new PrimitivEvaporatorRenderer());
		
		RenderingRegistry.registerEntityRenderingHandler(StoneTurtleEntity.class, StoneTurtleRenderer::new);
		
	}
	
	 @SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			
			System.out.println("");
			ModelLoader.addSpecialModel(ClientInit.GASBLOCK_MODEL_LOCATION);
			
		}
	
}
