package com.hauntedchest.lovecraftplus.client.entity.model;// Made with Blockbench 3.7.0
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.hauntedchest.lovecraftplus.entities.MoonFrogEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MoonFrogModel<T extends MoonFrogEntity> extends EntityModel<T> {
	private final ModelRenderer right_leg;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer left_leg;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer right_arm;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer left_arm;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;

	public MoonFrogModel() {
		textureWidth = 16;
		textureHeight = 16;

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(0.0F, 24.0F, 7.0F);
		right_leg.setTextureOffset(8, 12).addBox(-4.0F, -1.0F, -7.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		right_leg.setTextureOffset(8, 12).addBox(-4.45F, -4.0F, -4.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		right_leg.setTextureOffset(8, 12).addBox(-4.45F, -2.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		right_leg.setTextureOffset(8, 12).addBox(-4.45F, -5.0F, -6.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-1.0F, 0.0F, -4.0F);
		right_leg.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
		cube_r1.setTextureOffset(8, 12).addBox(-1.75F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-4.0F, 0.0F, -5.0F);
		right_leg.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.7854F, 0.0F);
		cube_r2.setTextureOffset(8, 12).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(7.0F, 24.0F, 7.0F);
		left_leg.setTextureOffset(8, 12).addBox(-4.0F, -1.0F, -7.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		left_leg.setTextureOffset(8, 12).addBox(-4.45F, -4.0F, -4.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		left_leg.setTextureOffset(8, 12).addBox(-4.45F, -2.0F, -3.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		left_leg.setTextureOffset(8, 12).addBox(-4.45F, -5.0F, -6.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-1.0F, 0.0F, -4.0F);
		left_leg.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.7854F, 0.0F);
		cube_r3.setTextureOffset(8, 12).addBox(-1.75F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-4.0F, 0.0F, -5.0F);
		left_leg.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.7854F, 0.0F);
		cube_r4.setTextureOffset(8, 12).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 6).addBox(-4.45F, -9.0F, -3.0F, 9.0F, 4.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(0, 4).addBox(-4.45F, -10.0F, -3.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 4).addBox(-4.45F, -14.0F, -8.0F, 9.0F, 6.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-5.45F, -13.0F, -7.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(4.55F, -13.0F, -7.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(0.0F, 24.0F, 0.0F);
		right_arm.setTextureOffset(10, 0).addBox(-4.45F, -5.0F, -5.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		right_arm.setTextureOffset(10, 0).addBox(-4.45F, -8.0F, -6.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		right_arm.setTextureOffset(10, 0).addBox(-4.0F, -1.0F, -8.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-1.0F, 0.0F, -5.0F);
		right_arm.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -0.7854F, 0.0F);
		cube_r5.setTextureOffset(10, 0).addBox(-1.75F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-4.0F, 0.0F, -6.0F);
		right_arm.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.7854F, 0.0F);
		cube_r6.setTextureOffset(10, 0).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(7.0F, 24.0F, 0.0F);
		left_arm.setTextureOffset(10, 0).addBox(-4.45F, -5.0F, -5.0F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		left_arm.setTextureOffset(10, 0).addBox(-4.45F, -8.0F, -6.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);
		left_arm.setTextureOffset(10, 0).addBox(-4.0F, -1.0F, -8.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-1.0F, 0.0F, -5.0F);
		left_arm.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, -0.7854F, 0.0F);
		cube_r7.setTextureOffset(10, 0).addBox(-1.75F, -1.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-4.0F, 0.0F, -6.0F);
		left_arm.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.7854F, 0.0F);
		cube_r8.setTextureOffset(10, 0).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
	}

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

    public ModelRenderer getRight_leg() {
        return right_leg;
    }

    public ModelRenderer getRight_arm() {
        return right_arm;
    }

    public ModelRenderer getLeft_leg() {
        return left_leg;
    }

    public ModelRenderer getHead() {
        return head;
    }

    public ModelRenderer getLeft_arm() {
        return left_arm;
    }

    public ModelRenderer getCube_r5() {
        return cube_r5;
    }

    public ModelRenderer getCube_r6() {
        return cube_r6;
    }

    public ModelRenderer getCube_r4() {
        return cube_r4;
    }

    public ModelRenderer getCube_r3() {
        return cube_r3;
    }

    public ModelRenderer getCube_r2() {
        return cube_r2;
    }

    public ModelRenderer getCube_r1() {
        return cube_r1;
    }

    public ModelRenderer getBody() {
        return body;
    }

    public ModelRenderer getCube_r8() {
        return cube_r8;
    }

    public ModelRenderer getCube_r7() {
        return cube_r7;
    }
}