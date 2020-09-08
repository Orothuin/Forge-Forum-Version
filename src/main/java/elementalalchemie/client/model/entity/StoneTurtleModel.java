package elementalalchemie.client.model.entity;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import elementalalchemie.entitys.StoneTurtleEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;

public class StoneTurtleModel extends EntityModel<StoneTurtleEntity> {
	
	private final RendererModel bone;
	private final RendererModel bone27;
	private final RendererModel bone8;
	private final RendererModel bone5;
	private final RendererModel bone2;
	private final RendererModel bone3;
	private final RendererModel bone4;
	private final RendererModel bone6;
	private final RendererModel bone7;
	private final RendererModel bone9;
	private final RendererModel bone10;
	private final RendererModel bone11;
	private final RendererModel bone12;
	private final RendererModel bone13;
	private final RendererModel bone14;
	private final RendererModel bone15;
	private final RendererModel bone18;
	private final RendererModel bone16;
	private final RendererModel bone17;
	private final RendererModel bone19;
	private final RendererModel bone20;
	private final RendererModel bone21;
	private final RendererModel bone22;
	private final RendererModel bone23;
	private final RendererModel bone24;
	private final RendererModel bone25;
	private final RendererModel crystals;
	private final RendererModel crystal1;
	private final RendererModel crystal2;
	private final RendererModel crystal3;
	private final RendererModel crystal4;
	private final RendererModel crystal5;
	private final RendererModel crystal6;
	private final RendererModel crystal7;
	private final RendererModel crystal8;
	private final RendererModel crystal9;
	private final RendererModel crystal10;
	private final RendererModel crystal11;
	
	private ArrayList<RendererModel> crystalList;
	
	public StoneTurtleModel() {
		textureWidth = 40;
		textureHeight = 40;
		
		crystalList=new ArrayList<>();
		
		bone = new RendererModel(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 4, -3.0F, -3.0F, -5.0F, 6, 3, 10, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 4, -4.0F, -10.0F, -5.0F, 8, 3, 10, 0.0F, false));

		bone27 = new RendererModel(this);
		bone27.setRotationPoint(0.0F, -4.5F, 0.0F);
		bone.addChild(bone27);
		setRotationAngle(bone27, 0.0F, 180.0F, 0.0F);
		bone27.cubeList.add(new ModelBox(bone27, 0, 11, -4.0F, -2.0F, -6.0F, 8, 4, 12, 0.0F, false));

		bone8 = new RendererModel(this);
		bone8.setRotationPoint(4.0643F, -2.5825F, -5.4065F);
		bone.addChild(bone8);
		

		bone5 = new RendererModel(this);
		bone5.setRotationPoint(0.25F, 0.0F, 0.25F);
		bone8.addChild(bone5);
		setRotationAngle(bone5, 0.0F, -10.0F, 0.0F);
		

		bone2 = new RendererModel(this);
		bone2.setRotationPoint(-1.3143F, -4.9175F, 0.4065F);
		bone5.addChild(bone2);
		setRotationAngle(bone2, 30.0F, 45.0F, 40.0F);
		bone2.cubeList.add(new ModelBox(bone2, 0, 4, -1.4583F, -1.7858F, -1.2095F, 6, 3, 4, 0.0F, false));

		bone3 = new RendererModel(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone3);
		setRotationAngle(bone3, -30.0F, 45.0F, -40.0F);
		bone3.cubeList.add(new ModelBox(bone3, 0, 4, -2.5F, -1.5F, -2.0F, 5, 2, 3, 0.0F, false));

		bone4 = new RendererModel(this);
		bone4.setRotationPoint(-8.25F, 0.0F, 0.5F);
		bone8.addChild(bone4);
		setRotationAngle(bone4, 0.0F, 90.0F, 0.0F);
		

		bone6 = new RendererModel(this);
		bone6.setRotationPoint(-1.3143F, -4.9175F, 0.4065F);
		bone4.addChild(bone6);
		setRotationAngle(bone6, 30.0F, 45.0F, 40.0F);
		bone6.cubeList.add(new ModelBox(bone6, 0, 4, -1.4583F, -1.7858F, -1.2095F, 5, 3, 4, 0.0F, false));

		bone7 = new RendererModel(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone7);
		setRotationAngle(bone7, -30.0F, 45.0F, -40.0F);
		bone7.cubeList.add(new ModelBox(bone7, 0, 4, -2.5F, -1.5F, -2.0F, 6, 2, 3, 0.0F, false));

		bone9 = new RendererModel(this);
		bone9.setRotationPoint(-3.9357F, -2.5825F, 5.5935F);
		bone.addChild(bone9);
		setRotationAngle(bone9, 0.0F, 180.0F, 0.0F);
		

		bone10 = new RendererModel(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.25F);
		bone9.addChild(bone10);
		

		bone11 = new RendererModel(this);
		bone11.setRotationPoint(-1.3143F, -4.9175F, 0.4065F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, 30.0F, 45.0F, 40.0F);
		bone11.cubeList.add(new ModelBox(bone11, 0, 4, -1.4583F, -1.7858F, -1.2095F, 5, 3, 4, 0.0F, false));

		bone12 = new RendererModel(this);
		bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone10.addChild(bone12);
		setRotationAngle(bone12, -30.0F, 45.0F, -40.0F);
		bone12.cubeList.add(new ModelBox(bone12, 7, 21, -2.5F, -1.5F, -2.0F, 6, 2, 3, 0.0F, false));

		bone13 = new RendererModel(this);
		bone13.setRotationPoint(-8.25F, 0.0F, 0.5F);
		bone9.addChild(bone13);
		setRotationAngle(bone13, 0.0F, 90.0F, 0.0F);
		

		bone14 = new RendererModel(this);
		bone14.setRotationPoint(-1.3143F, -4.9175F, 0.4065F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, 30.0F, 45.0F, 40.0F);
		bone14.cubeList.add(new ModelBox(bone14, 0, 4, -1.4583F, -1.7858F, -1.2095F, 6, 3, 4, 0.0F, false));

		bone15 = new RendererModel(this);
		bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone15);
		setRotationAngle(bone15, -30.0F, 45.0F, -40.0F);
		bone15.cubeList.add(new ModelBox(bone15, 0, 4, -2.5F, -1.5F, -2.0F, 5, 2, 3, 0.0F, false));

		bone18 = new RendererModel(this);
		bone18.setRotationPoint(-7.25F, -4.5F, 0.5F);
		bone.addChild(bone18);
		

		bone16 = new RendererModel(this);
		bone16.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone18.addChild(bone16);
		setRotationAngle(bone16, 0.0F, 0.0F, 50.0F);
		bone16.cubeList.add(new ModelBox(bone16, 0, 4, -0.5F, -1.5F, -5.75F, 5, 3, 11, 0.0F, false));

		bone17 = new RendererModel(this);
		bone17.setRotationPoint(0.0F, -0.25F, 0.0F);
		bone18.addChild(bone17);
		setRotationAngle(bone17, 0.0F, 0.0F, -65.0F);
		bone17.cubeList.add(new ModelBox(bone17, 0, 4, -0.5F, -1.5F, -5.0F, 6, 3, 9, 0.0F, false));

		bone19 = new RendererModel(this);
		bone19.setRotationPoint(7.25F, -4.5F, 0.0F);
		bone.addChild(bone19);
		setRotationAngle(bone19, 0.0F, 180.0F, 0.0F);
		

		bone20 = new RendererModel(this);
		bone20.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone19.addChild(bone20);
		setRotationAngle(bone20, 0.0F, 0.0F, 50.0F);
		bone20.cubeList.add(new ModelBox(bone20, 0, 4, -0.5F, -1.5F, -5.5F, 5, 3, 11, 0.0F, false));

		bone21 = new RendererModel(this);
		bone21.setRotationPoint(0.0F, -0.25F, 0.0F);
		bone19.addChild(bone21);
		setRotationAngle(bone21, 0.0F, 0.0F, -65.0F);
		bone21.cubeList.add(new ModelBox(bone21, 0, 4, -0.5F, -1.5F, -4.5F, 6, 3, 9, 0.0F, false));

		bone22 = new RendererModel(this);
		bone22.setRotationPoint(0.0F, -1.75F, -6.0F);
		bone.addChild(bone22);
		setRotationAngle(bone22, -40.0F, 0.0F, 0.0F);
		bone22.cubeList.add(new ModelBox(bone22, 0, 4, -3.0F, -1.5F, -2.0F, 6, 2, 3, 0.0F, false));

		bone23 = new RendererModel(this);
		bone23.setRotationPoint(0.25F, -1.75F, 6.0F);
		bone.addChild(bone23);
		setRotationAngle(bone23, -40.0F, 180.0F, 0.0F);
		bone23.cubeList.add(new ModelBox(bone23, 0, 4, -3.0F, -1.5F, -3.0F, 6, 2, 4, 0.0F, false));

		bone24 = new RendererModel(this);
		bone24.setRotationPoint(0.0F, -7.2981F, 5.8216F);
		bone.addChild(bone24);
		setRotationAngle(bone24, -125.0F, 180.0F, 0.0F);
		bone24.cubeList.add(new ModelBox(bone24, 0, 4, -3.75F, -0.4264F, -2.3192F, 7, 1, 4, 0.0F, false));

		bone25 = new RendererModel(this);
		bone25.setRotationPoint(-0.25F, -8.1927F, -6.0276F);
		bone.addChild(bone25);
		setRotationAngle(bone25, -45.0F, 180.0F, 0.0F);
		bone25.cubeList.add(new ModelBox(bone25, 0, 4, -3.5F, -1.0F, -1.5F, 7, 2, 2, 0.0F, false));

		crystals = new RendererModel(this);
		crystals.setRotationPoint(3.0F, -13.0F+24.0f, 0.0F);
		//bone.addChild(crystals);
		

		crystal1 = new RendererModel(this);
		crystal1.setRotationPoint(0.75F, 3.25F, 0.0F);
		crystals.addChild(crystal1);
		crystal1.cubeList.add(new ModelBox(crystal1, 10, 35, -3.0F, -2.0F, -1.0F, 3, 2, 3, 0.0F, false));
		crystalList.add(crystal1);
		
		crystal2 = new RendererModel(this);
		crystal2.setRotationPoint(-4.0F, 0.0F, 0.0F);
		crystals.addChild(crystal2);
		crystal2.cubeList.add(new ModelBox(crystal2, 20, 30, -4.0F, -1.0F, 0.0F, 4, 5, 4, 0.0F, false));
		crystalList.add(crystal2);
		
		crystal3 = new RendererModel(this);
		crystal3.setRotationPoint(-4.0F, 0.0F, 0.0F);
		crystals.addChild(crystal3);
		crystal3.cubeList.add(new ModelBox(crystal3, 27, 32, -1.0F, -1.75F, -2.0F, 3, 5, 3, 0.0F, false));
		crystalList.add(crystal3);
		
		crystal4 = new RendererModel(this);
		crystal4.setRotationPoint(-1.0F, 3.25F, -3.0F);
		crystals.addChild(crystal4);
		crystal4.cubeList.add(new ModelBox(crystal4, 11, 32, -2.0F, -3.0F, 0.0F, 2, 3, 2, 0.0F, false));
		crystalList.add(crystal4);
		
		crystal5 = new RendererModel(this);
		crystal5.setRotationPoint(-1.0F, 1.25F, 1.0F);
		crystals.addChild(crystal5);
		crystal5.cubeList.add(new ModelBox(crystal5, 19, 32, -3.0F, -1.0F, 0.0F, 3, 3, 3, 0.0F, false));
		crystalList.add(crystal5);
		
		crystal6 = new RendererModel(this);
		crystal6.setRotationPoint(-2.75F, 3.25F, -4.0F);
		crystals.addChild(crystal6);
		crystal6.cubeList.add(new ModelBox(crystal6, 0, 34, -4.0F, -2.0F, 0.0F, 4, 2, 4, 0.0F, false));
		crystalList.add(crystal6);
		
		crystal7 = new RendererModel(this);
		crystal7.setRotationPoint(0.0F, 3.25F, -3.0F);
		crystals.addChild(crystal7);
		crystal7.cubeList.add(new ModelBox(crystal7, 7, 32, -1.0F, -1.0F, -1.0F, 3, 1, 3, 0.0F, false));
		crystalList.add(crystal7);
		
		crystal8 = new RendererModel(this);
		crystal8.setRotationPoint(0.0F, 2.25F, -2.0F);
		crystals.addChild(crystal8);
		crystal8.cubeList.add(new ModelBox(crystal8, 6, 32, -1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F, false));
		crystalList.add(crystal8);
		
		crystal9 = new RendererModel(this);
		crystal9.setRotationPoint(0.0F, -0.75F, -2.0F);
		crystals.addChild(crystal9);
		crystal9.cubeList.add(new ModelBox(crystal9, 24, 37, -1.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, false));
		crystalList.add(crystal9);
		
		crystal10 = new RendererModel(this);
		crystal10.setRotationPoint(-3.0F, -1.75F, -1.0F);
		crystals.addChild(crystal10);
		crystal10.cubeList.add(new ModelBox(crystal10, 5, 35, -1.0F, -2.0F, 0.0F, 1, 2, 1, 0.0F, false));
		crystalList.add(crystal10);
		
		crystal11 = new RendererModel(this);
		crystal11.setRotationPoint(-6.0F, -1.75F, 1.0F);
		crystals.addChild(crystal11);
		crystal11.cubeList.add(new ModelBox(crystal11, 16, 36, -1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F, false));
		crystalList.add(crystal11);
	}
	
	
	
	@Override
	public void render(StoneTurtleEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		
		for(RendererModel r : crystalList)
			r.isHidden=false;
		
		int i=(entity.isSheared()? crystalList.size():0)-(int) ((float)crystalList.size()*(float)entity.getCrystalGrowthTimer()/(float)StoneTurtleEntity.CRYSTAL_GROWTH_TIME);
				
		for(int z =0;z<i;z++)
			crystalList.get(crystalList.size()-1-z).isHidden=true;
		
		bone.render(f5);
		
		GlStateManager.enableBlend();
		GlStateManager.enableLighting();
		GlStateManager.blendFunc(GL11.GL_ONE, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.disableCull();
		crystals.render(f5);
		GlStateManager.disableLighting();
		GlStateManager.disableBlend();
		
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = (float) (x * (Math.PI / 180F));
		modelRenderer.rotateAngleY = (float) (y * (Math.PI / 180F));
		modelRenderer.rotateAngleZ = (float) (z * (Math.PI / 180F));
	}
}