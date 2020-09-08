package elementalalchemie.client.renderer.entitys;

import elementalalchemie.client.model.entity.StoneTurtleModel;
import elementalalchemie.entitys.StoneTurtleEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class StoneTurtleRenderer extends MobRenderer<StoneTurtleEntity, StoneTurtleModel>{

	public StoneTurtleRenderer(EntityRendererManager renderManager) {
		super(renderManager, new StoneTurtleModel(), 0.9f);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(StoneTurtleEntity entity) {
		
		return new ResourceLocation("elementalalchemie:textures/entity/stone_turtle.png");
	}
	
	@Override
	protected boolean canRenderName(StoneTurtleEntity entity) {
		
		return super.canRenderName(entity);
		
	}
	
	@Override
	public void doRender(StoneTurtleEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
		
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
		
	}
}
