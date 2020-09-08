package elementalalchemie.client.renderer.tileentitys;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import elementalalchemie.blocks.JuiceExtractorBlock;
import elementalalchemie.fluids.Keitw_Fluid;
import elementalalchemie.tileentitys.JuiceExtractorTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IEnviromentBlockReader;

@SuppressWarnings("deprecation")
public class JuiceExtractorRenderer extends TileEntityRenderer<JuiceExtractorTileEntity> {

	@SuppressWarnings("incomplete-switch")
	@Override
	public void render(JuiceExtractorTileEntity tile, double x, double y, double z, float partialTicks,
			int destroyStage) {

		BlockState state = tile.getWorld().getBlockState(tile.getPos());

		Direction dir = state.get(JuiceExtractorBlock.FACING);
		GlStateManager.pushMatrix();

		switch (dir) {

		case EAST:
			GlStateManager.translated(x + 1.0, y - 0.01, z + 0.50);
			break;
		case NORTH:
			GlStateManager.translated(x + 0.5, y - 0.01, z - 0.0);
			break;
		case SOUTH:
			GlStateManager.translated(x + 0.5, y - 0.01, z + 1.0);
			break;
		case WEST:
			GlStateManager.translated(x - 0.0, y - 0.01, z + 0.50);
			break;
		}

		GlStateManager.scaled(0.6f, 0.6f, 0.6f);

		setupRenderItem();

		GlStateManager.translated(0, 0.5, 0);
		GlStateManager.rotatef(dir.getHorizontalAngle(), 0, 1, 0);

		if (tile.getBucket() != null && !tile.getBucket().isEmpty()) {

			Minecraft.getInstance().getItemRenderer().renderItem(tile.getBucket(),
					ItemCameraTransforms.TransformType.FIXED);
		}

		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();

		GlStateManager.translated(x + 0.5, y + (1.0 / 16.0) * 7.0, z + 0.5);

		setupRenderItem();

		if (tile.getInv() != null) {

			for (int i = 0; i < tile.getInv().getSlots(); i++) {
				
				if(tile.getCurrentStamps()>=JuiceExtractorTileEntity.NEEDED_STAMPS)break;
				
				GlStateManager.translated(0, (1.0 / 16.0), 0);

				GlStateManager.scaled(0.6f, 0.6f, 0.6f);

				GlStateManager.rotatef(90, 1, 0, 0);

				GlStateManager.rotatef(dir.getHorizontalAngle() + 360.0f / JuiceExtractorBlock.MAX_INGRIEDIENTS * i, 0,
						0, 1);
				Minecraft.getInstance().getItemRenderer().renderItem(tile.getInv().getStackInSlot(i),
						ItemCameraTransforms.TransformType.FIXED);

				GlStateManager.rotatef(-dir.getHorizontalAngle() - 360.0f / JuiceExtractorBlock.MAX_INGRIEDIENTS * i, 0,
						0, 1);

				GlStateManager.rotatef(-90, 1, 0, 0);

				GlStateManager.scaled(1.0 / 0.6f, 1.0 / 0.6f, 1.0 / 0.6f);
			}
		}

		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();

		GlStateManager.enableBlend();
		
		GlStateManager.translated(x, y+2.0f/16.0f, z);
		
		GlStateManager.translated(0.5, 0, 0.5);
		
		GlStateManager.rotatef(-dir.getHorizontalAngle()*365-180, 0, 1, 0);
		
		GlStateManager.translated(-0.5, 0, -0.5);
		
        bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
		
		Tessellator.getInstance().getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);
		
		renderFluidTop(tile.getWorld(), tile.getPos(), Tessellator.getInstance().getBuffer(),
				Keitw_Fluid.KEITW_FLUID.get().getDefaultState(),0.6f*(((float)tile.getCurrentStamps()/(float)JuiceExtractorTileEntity.NEEDED_STAMPS)-((float)tile.getFillBucketRenderTicks()/(float)JuiceExtractorTileEntity.MAX_FILL_BUCKET_RENDER_TICKS)));
		
		
		if(tile.getFillBucketRenderTicks()>0)
			renderFaucetFluid(tile.getWorld(), tile.getPos(), Tessellator.getInstance().getBuffer(),
					Keitw_Fluid.KEITW_FLUID.get().getDefaultState(),dir);
	
		Tessellator.getInstance().draw();
		
		GlStateManager.popMatrix();
	}
	private static float f;
	private void renderFluidTop(IEnviromentBlockReader reader, BlockPos pos, BufferBuilder bufferBuilderIn,
			IFluidState fluidStateIn, float height) {

		TextureAtlasSprite[] atextureatlassprite = net.minecraftforge.client.ForgeHooksClient.getFluidSprites(reader,
				pos, fluidStateIn);
		
		int color = fluidStateIn.getFluid().getAttributes().getColor(reader, pos);

		float alpha = (float) (color >> 24 & 255) / 255.0F;
		float red = (float) (color >> 16 & 255) / 255.0F;
		float green = (float) (color >> 8 & 255) / 255.0F;
		float blue = (float) (color & 255) / 255.0F;
		
		TextureAtlasSprite textureatlassprite1 = atextureatlassprite[0];
		float u1 = textureatlassprite1.getInterpolatedU(0.0D);
		float v1 = textureatlassprite1.getInterpolatedV(0.0D);
		float u2 = u1;
		float v2 = textureatlassprite1.getInterpolatedV(16.0D);
		float u3 = textureatlassprite1.getInterpolatedU(16.0D);
		float v3 = v2;
		float u4 = u3;
		float v4 = v1;
		alpha=f;
		f+=0.001f;
		f=f%1;
		float middleU = (u1 + u2 + u3 + u4) / 4.0F;
		float middleV = (v1 + v2 + v3 + v4) / 4.0F;
		
		float f42 = (float) atextureatlassprite[0].getWidth()
				/ (atextureatlassprite[0].getMaxU() - atextureatlassprite[0].getMinU());

		float f44 = 4.0F / f42;
		
		u1 = MathHelper.lerp(f44, u1, middleU);
		u2 = MathHelper.lerp(f44, u2, middleU);
		u3 = MathHelper.lerp(f44, u3, middleU);
		u4 = MathHelper.lerp(f44, u4, middleU);
		v1 = MathHelper.lerp(f44, v1, middleV);
		v2 = MathHelper.lerp(f44, v2, middleV);
		v3 = MathHelper.lerp(f44, v3, middleV);
		v4 = MathHelper.lerp(f44, v4, middleV);
		
		int j = this.getCombinedLightUpMax(reader, pos);
		int k = j >> 16 & '\uffff';
		int l = j & '\uffff';
		
		bufferBuilderIn.pos( 0.0D+3.0f/16.0f,  (double)height, 0.0D+3.0f/16.0f).color(red, green, blue, alpha).tex((double)u1, (double)v1).lightmap(k, l).endVertex();
        bufferBuilderIn.pos( 0.0D+3.0f/16.0f,  (double)height, 1.0D-3.0f/16.0f).color(red, green, blue, alpha).tex((double)u2, (double)v2).lightmap(k, l).endVertex();
        bufferBuilderIn.pos( 1.0D-3.0f/16.0f,  (double)height, 1.0D-3.0f/16.0f).color(red, green, blue, alpha).tex((double)u3, (double)v3).lightmap(k, l).endVertex();
        bufferBuilderIn.pos( 1.0D-3.0f/16.0f,  (double)height, 0.0D+3.0f/16.0f).color(red, green, blue, alpha).tex((double)u4, (double)v4).lightmap(k, l).endVertex();
	}
	
	private void renderFaucetFluid(IEnviromentBlockReader reader, BlockPos pos, BufferBuilder bufferBuilderIn,
			IFluidState fluidStateIn,Direction dir) {
			
		TextureAtlasSprite[] atextureatlassprite = net.minecraftforge.client.ForgeHooksClient.getFluidSprites(reader,
				pos, fluidStateIn);
		
		int color = fluidStateIn.getFluid().getAttributes().getColor(reader, pos);

		float alpha = (float) (color >> 24 & 255) / 255.0F;
		float red = (float) (color >> 16 & 255) / 255.0F;
		float green = (float) (color >> 8 & 255) / 255.0F;
		float blue = (float) (color & 255) / 255.0F;

		TextureAtlasSprite textureatlassprite2 = atextureatlassprite[1];
	        
	    float f20 = (float)MathHelper.atan2(-1, 0) - ((float)Math.PI / 2F);
	    float f21 = MathHelper.sin(f20) * 0.25F;
	    float f22 = MathHelper.cos(f20) * 0.25F;
	       
	    float u1 = textureatlassprite2.getInterpolatedU((double)(4F + (-f22 - f21) * 8.0F));
	    float v1 = textureatlassprite2.getInterpolatedV((double)(2.0F + (-f22 + f21) * 4.0F));
	    float u2 = textureatlassprite2.getInterpolatedU((double)(4F + (-f22 + f21) * 8.0F));
	    float v2 = textureatlassprite2.getInterpolatedV((double)(2.0F + (f22 + f21) * 4.0F));
	    float u3 = textureatlassprite2.getInterpolatedU((double)(4F + (f22 + f21) * 8.0F));
	    float v3 = textureatlassprite2.getInterpolatedV((double)(2.0F + (f22 - f21) * 4.0F));
	    float u4 = textureatlassprite2.getInterpolatedU((double)(4F + (f22 - f21) * 8.0F));
	    float v4 = textureatlassprite2.getInterpolatedV((double)(2.0F + (-f22 - f21) * 4.0F));
	        
	    float middleU = (u1 + u2 + u3 + u4) / 4.0F;
	    float middleV = (v1 + v2 + v3 + v4) / 4.0F;
			
		float f42 = (float) atextureatlassprite[1].getWidth()
					/ (atextureatlassprite[1].getMaxU() - atextureatlassprite[1].getMinU());
		
		float f44 = 4.0F /f42;
			
		u1 = MathHelper.lerp(f44, u1, middleU);
		u2 = MathHelper.lerp(f44, u2, middleU);
		u3 = MathHelper.lerp(f44, u3, middleU);
		u4 = MathHelper.lerp(f44, u4, middleU);
		v1 = MathHelper.lerp(f44, v1, middleV);
		v2 = MathHelper.lerp(f44, v2, middleV);
		v3 = MathHelper.lerp(f44, v3, middleV);
		v4 = MathHelper.lerp(f44, v4, middleV);
	        
	    int i1 = this.getCombinedLightUpMax(reader,pos);
	    int j1 = i1 >> 16 & '\uffff';
	    int k1 = i1 & '\uffff';
	    
	    //render faucet top
	    bufferBuilderIn.pos( 0.0D+7.0f/16.0f,  (double)7.85/16.0, 0.0D-0.2f/16.0f).color(red, green, blue, alpha).tex((double)u1, (double)v1).lightmap(j1, k1).endVertex();
	    bufferBuilderIn.pos( 0.0D+7.0f/16.0f,  (double)7.85/16.0, 0.0D+2.0f/16.0f).color(red, green, blue, alpha).tex((double)u2, (double)v2).lightmap(j1, k1).endVertex();
	    bufferBuilderIn.pos( 0.0D+9.0f/16.0f,  (double)7.85/16.0, 0.0D+2.0f/16.0f).color(red, green, blue, alpha).tex((double)u3, (double)v3).lightmap(j1, k1).endVertex();
	    bufferBuilderIn.pos( 0.0D+9.0f/16.0f,  (double)7.85/16.0, 0.0D-0.2f/16.0f).color(red, green, blue, alpha).tex((double)u4, (double)v4).lightmap(j1, k1).endVertex();
		
	    //render faucet side
	    bufferBuilderIn.pos( 0.0D+7.0f/16.0f,  (double)5.85/16.0, 0.0D-0.2f/16.0f).color(red, green, blue, alpha).tex((double)u1, (double)v1).lightmap(j1, k1).endVertex();
	    bufferBuilderIn.pos( 0.0D+7.0f/16.0f,  (double)7.85/16.0, 0.0D-0.2f/16.0f).color(red, green, blue, alpha).tex((double)u2, (double)v2).lightmap(j1, k1).endVertex();
	    bufferBuilderIn.pos( 0.0D+9.0f/16.0f,  (double)7.85/16.0, 0.0D-0.2f/16.0f).color(red, green, blue, alpha).tex((double)u3, (double)v3).lightmap(j1, k1).endVertex();
	    bufferBuilderIn.pos( 0.0D+9.0f/16.0f,  (double)5.85/16.0, 0.0D-0.2f/16.0f).color(red, green, blue, alpha).tex((double)u4, (double)v4).lightmap(j1, k1).endVertex();
	}
	
	private int getCombinedLightUpMax(IEnviromentBlockReader reader, BlockPos pos) {
		int i = reader.getCombinedLight(pos, 0);
		int j = reader.getCombinedLight(pos.up(), 0);
		int k = i & 255;
		int l = j & 255;
		int i1 = i >> 16 & 255;
		int j1 = j >> 16 & 255;
		return (k > l ? k : l) | (i1 > j1 ? i1 : j1) << 16;
	}

	private void setupRenderItem() {
		RenderHelper.disableStandardItemLighting();

		if (Minecraft.isAmbientOcclusionEnabled())
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		else
			GlStateManager.shadeModel(GL11.GL_FLAT);

	}
}
