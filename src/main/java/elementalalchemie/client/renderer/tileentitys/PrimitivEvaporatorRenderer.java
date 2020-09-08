package elementalalchemie.client.renderer.tileentitys;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import elementalalchemie.blocks.PrimitivKeitwFluidEvaporator;
import elementalalchemie.client.ClientInit;
import elementalalchemie.tileentitys.PrimitvKeitwFluidEvaporatorTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IEnviromentBlockReader;
import net.minecraftforge.client.model.ModelDataManager;

public class PrimitivEvaporatorRenderer extends TileEntityRenderer<PrimitvKeitwFluidEvaporatorTileEntity> {
	
	private static int[] sf = {GL11.GL_ZERO, GL11.GL_ONE,GL11.GL_SRC_COLOR,GL11.GL_ONE_MINUS_SRC_COLOR,GL11.GL_DST_COLOR,GL11.GL_ONE_MINUS_DST_COLOR,GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA,GL11.GL_DST_ALPHA,GL11.GL_ONE_MINUS_DST_ALPHA};
	
	private int c;
	private int i1=0;
	private int i2=0;
	
	@Override
	public void render(PrimitvKeitwFluidEvaporatorTileEntity tileEntityIn, double x, double y, double z,
			float partialTicks, int destroyStage) {

		if (getWorld().getBlockState(tileEntityIn.getPos())
				.get(PrimitivKeitwFluidEvaporator.HALF) == DoubleBlockHalf.LOWER)
			return;

		IBakedModel model = Minecraft.getInstance().getModelManager().getModel(ClientInit.GASBLOCK_MODEL_LOCATION);

		bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);

		GlStateManager.pushMatrix();
		
		GlStateManager.translated(x, y + 3.0 / 16.0, z + 1);

		GlStateManager.enableBlend();
		
		GlStateManager.depthMask(false);
		
		//GlStateManager.blendFunc(sf[i1],sf[i2]);
		GlStateManager.blendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		
		//used to switch blend modes to see wich looks best
		if(c>500) {
			
			System.out.println(i1+","+i2);
			
			c=0;
			i2++;
			
			if(i2%sf.length==0)i1++;
			
			i1=i1%sf.length;
			i2=i2%sf.length;
			
			
		}else c++;
		
		//Not used due to the testing
		float f = Math
				.max((float) tileEntityIn.getGasAmount() / (float) PrimitvKeitwFluidEvaporatorTileEntity.MAX_GAS_AMOUNT
						- 0.2f, 0);
		
		f=(int)(f/0.05f)*0.05f;
		
		//setupRenderItem();
	
		//Mostly copied this and following methods from BlockRendererDispatcher since I could not get the varying transperency working otherwise
		renderModelBrightness(tileEntityIn,model, tileEntityIn.getWorld().getBlockState(tileEntityIn.getPos()),(float)c/500.0f);
		
	
		GlStateManager.depthMask(true);
		
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
		
	}

	public void renderModelBrightnessColor(PrimitvKeitwFluidEvaporatorTileEntity tile ,@Nullable BlockState state, IBakedModel modelIn, float red,
			float green, float blue,float alpha) {
		Random random = new Random();

		for (Direction direction : Direction.values()) {
			random.setSeed(42L);
			this.renderModelBrightnessColorQuads(tile, red, green, blue,
					modelIn.getQuads(state, direction, random, ModelDataManager.getModelData(getWorld(), tile.getPos())),alpha);
		}
		random.setSeed(42L);
		this.renderModelBrightnessColorQuads(tile, red, green, blue,
				modelIn.getQuads(state, (Direction)null, random, ModelDataManager.getModelData(getWorld(), tile.getPos())),alpha);
	}

	public void renderModelBrightness(PrimitvKeitwFluidEvaporatorTileEntity tile,IBakedModel model, BlockState state,float alpha) {

		GlStateManager.rotatef(90.0F, 0.0F, 1.0F, 0.0F);

		this.renderModelBrightnessColor(tile,state, model, 1, 1, 1,alpha);
	}
	
	private void renderModelBrightnessColorQuads(PrimitvKeitwFluidEvaporatorTileEntity tile, float red, float green, float blue,
			List<BakedQuad> listQuads,float alpha) {

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
	
		int j = this.getCombinedLightUpMax(getWorld(), tile.getPos());
		int k = j >> 16 & '\uffff';
		int l = j & '\uffff';
		
		for (int i = 0; i < listQuads.size(); ++i) {

			BakedQuad bakedquad = listQuads.get(i);
			bufferbuilder.begin(7, DefaultVertexFormats.BLOCK);
			
			for (int z = 0; z < 4; z++)
				bufferbuilder
						.pos(Float.intBitsToFloat(bakedquad.getVertexData()[0 + 7 * z]),
								Float.intBitsToFloat(bakedquad.getVertexData()[1 + 7 * z]),
								Float.intBitsToFloat(bakedquad.getVertexData()[2 + 7 * z]))
						.color(red, blue, green, alpha)
						.tex((double) Float.intBitsToFloat(bakedquad.getVertexData()[4 + 7 * z]),
								(double) Float.intBitsToFloat(bakedquad.getVertexData()[5 + 7 * z]))
						.lightmap(k, l).endVertex();

			tessellator.draw();
		}
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
}
