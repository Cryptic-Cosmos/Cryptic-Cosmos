package com.hauntedchest.lovecraftplus.client.entity.model;// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.hauntedchest.lovecraftplus.entities.MoonFrogEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MoonFrogModel<T extends MoonFrogEntity> extends EntityModel<T> {
	private final ModelRenderer right_leg;
	private final ModelRenderer middle_finger;
	private final ModelRenderer right_back;
	private final ModelRenderer right_top;
	private final ModelRenderer right_center;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer left_leg;
	private final ModelRenderer middle_finger2;
	private final ModelRenderer left_back;
	private final ModelRenderer left_top;
	private final ModelRenderer left_center;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer head_neck;
	private final ModelRenderer le;
	private final ModelRenderer re;
	private final ModelRenderer right_arm;
	private final ModelRenderer arm_back;
	private final ModelRenderer arm;
	private final ModelRenderer middle_f;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer left_arm;
	private final ModelRenderer left_arm_back;
	private final ModelRenderer left_arm_top;
	private final ModelRenderer middle_ff;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer getBody;
	private final ModelRenderer getCube_r1;
	private final ModelRenderer getCube_r2;
	private final ModelRenderer getCube_r3;
	private final ModelRenderer getCube_r4;
	private final ModelRenderer getCube_r5;
	private final ModelRenderer getCube_r6;
	private final ModelRenderer getCube_r7;
	private final ModelRenderer getCube_r8;
	private final ModelRenderer getHead;
	private final ModelRenderer getLeft_arm;
	private final ModelRenderer getLeft_leg;
	private final ModelRenderer getRight_arm;
	private final ModelRenderer getRight_leg;

	public MoonFrogModel() {
		textureWidth = 16;
		textureHeight = 16;

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-3.5F, 19.0F, 2.0F);
		

		middle_finger = new ModelRenderer(this);
		middle_finger.setRotationPoint(0.0F, 4.6F, 1.0F);
		right_leg.addChild(middle_finger);
		middle_finger.setTextureOffset(8, 12).addBox(-0.5F, -0.6F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		right_back = new ModelRenderer(this);
		right_back.setRotationPoint(0.0F, 3.0F, 2.0F);
		right_leg.addChild(right_back);
		right_back.setTextureOffset(8, 12).addBox(-0.95F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		right_top = new ModelRenderer(this);
		right_top.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_leg.addChild(right_top);
		right_top.setTextureOffset(8, 12).addBox(-0.95F, 0.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		right_center = new ModelRenderer(this);
		right_center.setRotationPoint(0.0F, 1.0F, 1.5F);
		right_leg.addChild(right_center);
		right_center.setTextureOffset(8, 12).addBox(-0.95F, 0.0F, -0.5F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.6F, 4.7F, 1.2F);
		right_leg.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
		cube_r1.setTextureOffset(8, 12).addBox(-0.5479F, -0.7F, -2.9849F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-0.1F, 4.5F, 1.2F);
		right_leg.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.7854F, 0.0F);
		cube_r2.setTextureOffset(8, 12).addBox(-0.4343F, -0.5F, -3.1314F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(3.5F, 19.0F, 2.2F);
		

		middle_finger2 = new ModelRenderer(this);
		middle_finger2.setRotationPoint(0.0F, 4.5F, 0.8F);
		left_leg.addChild(middle_finger2);
		middle_finger2.setTextureOffset(8, 12).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		left_back = new ModelRenderer(this);
		left_back.setRotationPoint(0.0F, 3.0F, 1.8F);
		left_leg.addChild(left_back);
		left_back.setTextureOffset(8, 12).addBox(-0.95F, 0.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		left_top = new ModelRenderer(this);
		left_top.setRotationPoint(0.0F, 0.0F, -0.2F);
		left_leg.addChild(left_top);
		left_top.setTextureOffset(8, 12).addBox(-0.95F, 0.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		left_center = new ModelRenderer(this);
		left_center.setRotationPoint(0.0F, 1.0F, 1.3F);
		left_leg.addChild(left_center);
		left_center.setTextureOffset(8, 12).addBox(-0.95F, 0.0F, -0.5F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(0.6F, 4.7F, 1.0F);
		left_leg.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -0.7854F, 0.0F);
		cube_r9.setTextureOffset(8, 12).addBox(-0.5479F, -0.7F, -2.9849F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-0.1F, 4.5F, 1.0F);
		left_leg.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.7854F, 0.0F);
		cube_r10.setTextureOffset(8, 12).addBox(-0.4343F, -0.5F, -3.1314F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 18.0F, 0.0F);
		body.setTextureOffset(0, 6).addBox(-4.45F, -3.0F, -3.0F, 9.0F, 4.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.5F, -3.1F);
		

		head_neck = new ModelRenderer(this);
		head_neck.setRotationPoint(0.0F, -0.5F, 1.1F);
		head.addChild(head_neck);
		head_neck.setTextureOffset(0, 4).addBox(-4.45F, -1.0F, -1.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		head_neck.setTextureOffset(0, 4).addBox(-4.45F, -5.0F, -6.0F, 9.0F, 6.0F, 5.0F, 0.0F, false);

		le = new ModelRenderer(this);
		le.setRotationPoint(-4.3F, -3.3F, -2.9F);
		head.addChild(le);
		le.setTextureOffset(0, 0).addBox(8.85F, -1.2F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		re = new ModelRenderer(this);
		re.setRotationPoint(4.5F, -3.5F, -2.9F);
		head.addChild(re);
		re.setTextureOffset(0, 0).addBox(-9.95F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-3.5F, 16.0F, -5.5F);
		

		arm_back = new ModelRenderer(this);
		arm_back.setRotationPoint(0.0F, 0.0F, 0.0F);
		right_arm.addChild(arm_back);
		arm_back.setTextureOffset(10, 0).addBox(-0.95F, 3.0F, 0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		arm = new ModelRenderer(this);
		arm.setRotationPoint(0.0F, 3.5F, 0.5F);
		right_arm.addChild(arm);
		arm.setTextureOffset(10, 0).addBox(-0.95F, -3.5F, -1.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		middle_f = new ModelRenderer(this);
		middle_f.setRotationPoint(0.0F, 7.6F, 0.5F);
		right_arm.addChild(middle_f);
		middle_f.setTextureOffset(10, 0).addBox(-0.5F, -0.6F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.6F, 7.6F, 0.5F);
		right_arm.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -0.7854F, 0.0F);
		cube_r5.setTextureOffset(10, 0).addBox(-0.4065F, -0.6F, -2.8435F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-0.3F, 7.5F, 0.8F);
		right_arm.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.7854F, 0.0F);
		cube_r6.setTextureOffset(10, 0).addBox(-0.2222F, -0.5F, -3.0607F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(3.5F, 16.0F, -5.5F);
		

		left_arm_back = new ModelRenderer(this);
		left_arm_back.setRotationPoint(0.0F, 0.0F, 0.0F);
		left_arm.addChild(left_arm_back);
		left_arm_back.setTextureOffset(10, 0).addBox(-0.95F, 3.0F, 0.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);

		left_arm_top = new ModelRenderer(this);
		left_arm_top.setRotationPoint(0.0F, 3.5F, 0.5F);
		left_arm.addChild(left_arm_top);
		left_arm_top.setTextureOffset(10, 0).addBox(-0.95F, -3.5F, -1.0F, 2.0F, 4.0F, 1.0F, 0.0F, false);

		middle_ff = new ModelRenderer(this);
		middle_ff.setRotationPoint(0.0F, 7.6F, 0.5F);
		left_arm.addChild(middle_ff);
		middle_ff.setTextureOffset(10, 0).addBox(-0.5F, -0.6F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.6F, 7.6F, 0.5F);
		left_arm.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.7854F, 0.0F);
		cube_r3.setTextureOffset(10, 0).addBox(-0.4065F, -0.6F, -2.8435F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-0.3F, 7.5F, 0.8F);
		left_arm.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.7854F, 0.0F);
		cube_r4.setTextureOffset(10, 0).addBox(-0.2222F, -0.5F, -3.0607F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		getBody = new ModelRenderer(this);
		getBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getCube_r1 = new ModelRenderer(this);
		getCube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getCube_r2 = new ModelRenderer(this);
		getCube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getCube_r3 = new ModelRenderer(this);
		getCube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getCube_r4 = new ModelRenderer(this);
		getCube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getCube_r5 = new ModelRenderer(this);
		getCube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getCube_r6 = new ModelRenderer(this);
		getCube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getCube_r7 = new ModelRenderer(this);
		getCube_r7.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getCube_r8 = new ModelRenderer(this);
		getCube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getHead = new ModelRenderer(this);
		getHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getLeft_arm = new ModelRenderer(this);
		getLeft_arm.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getLeft_leg = new ModelRenderer(this);
		getLeft_leg.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getRight_arm = new ModelRenderer(this);
		getRight_arm.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		getRight_leg = new ModelRenderer(this);
		getRight_leg.setRotationPoint(0.0F, 0.0F, 0.0F);
		
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
		getBody.render(matrixStack, buffer, packedLight, packedOverlay);
		getCube_r1.render(matrixStack, buffer, packedLight, packedOverlay);
		getCube_r2.render(matrixStack, buffer, packedLight, packedOverlay);
		getCube_r3.render(matrixStack, buffer, packedLight, packedOverlay);
		getCube_r4.render(matrixStack, buffer, packedLight, packedOverlay);
		getCube_r5.render(matrixStack, buffer, packedLight, packedOverlay);
		getCube_r6.render(matrixStack, buffer, packedLight, packedOverlay);
		getCube_r7.render(matrixStack, buffer, packedLight, packedOverlay);
		getCube_r8.render(matrixStack, buffer, packedLight, packedOverlay);
		getHead.render(matrixStack, buffer, packedLight, packedOverlay);
		getLeft_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		getLeft_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		getRight_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		getRight_leg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}

	public ModelRenderer getRight_top() {
		return right_top;
	}

	public ModelRenderer getRight_center() {
		return right_center;
	}

	public ModelRenderer getRight_back() {
		return right_back;
	}

	public ModelRenderer getRe() {
		return re;
	}

	public ModelRenderer getMiddle_finger2() {
		return middle_finger2;
	}

	public ModelRenderer getMiddle_finger() {
		return middle_finger;
	}

	public ModelRenderer getMiddle_ff() {
		return middle_ff;
	}

	public ModelRenderer getMiddle_f() {
		return middle_f;
	}

	public ModelRenderer getLeft_top() {
		return left_top;
	}

	public ModelRenderer getLeft_center() {
		return left_center;
	}

	public ModelRenderer getLeft_back() {
		return left_back;
	}

	public ModelRenderer getLeft_arm_top() {
		return left_arm_top;
	}

	public ModelRenderer getLeft_arm_back() {
		return left_arm_back;
	}

	public ModelRenderer getLe() {
		return le;
	}

	public ModelRenderer getHead_neck() {
		return head_neck;
	}

	public ModelRenderer getGetRight_leg() {
		return getRight_leg;
	}

	public ModelRenderer getGetRight_arm() {
		return getRight_arm;
	}

	public ModelRenderer getGetLeft_leg() {
		return getLeft_leg;
	}

	public ModelRenderer getGetLeft_arm() {
		return getLeft_arm;
	}

	public ModelRenderer getGetHead() {
		return getHead;
	}

	public ModelRenderer getGetCube_r8() {
		return getCube_r8;
	}

	public ModelRenderer getGetCube_r7() {
		return getCube_r7;
	}

	public ModelRenderer getGetCube_r6() {
		return getCube_r6;
	}

	public ModelRenderer getGetCube_r5() {
		return getCube_r5;
	}

	public ModelRenderer getGetCube_r4() {
		return getCube_r4;
	}

	public ModelRenderer getGetCube_r3() {
		return getCube_r3;
	}

	public ModelRenderer getGetCube_r2() {
		return getCube_r2;
	}

	public ModelRenderer getGetCube_r1() {
		return getCube_r1;
	}

	public ModelRenderer getGetBody() {
		return getBody;
	}

	public ModelRenderer getCube_r10() {
		return cube_r10;
	}

	public ModelRenderer getCube_r9() {
		return cube_r9;
	}

	public ModelRenderer getArm_back() {
		return arm_back;
	}

	public ModelRenderer getArm() {
		return arm;
	}

	public ModelRenderer getBody() {
		return body;
	}

	public ModelRenderer getCube_r1() {
		return cube_r1;
	}

	public ModelRenderer getCube_r2() {
		return cube_r2;
	}

	public ModelRenderer getCube_r3() {
		return cube_r3;
	}

	public ModelRenderer getCube_r4() {
		return cube_r4;
	}

	public ModelRenderer getCube_r5() {
		return cube_r5;
	}

	public ModelRenderer getCube_r6() {
		return cube_r6;
	}

	public ModelRenderer getLeft_arm() {
		return left_arm;
	}

	public ModelRenderer getHead() {
		return head;
	}

	public ModelRenderer getLeft_leg() {
		return left_leg;
	}

	public ModelRenderer getRight_arm() {
		return right_arm;
	}

	public ModelRenderer getRight_leg() {
		return right_leg;
	}
}