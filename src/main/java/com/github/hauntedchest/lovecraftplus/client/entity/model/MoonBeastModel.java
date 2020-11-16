package com.github.hauntedchest.lovecraftplus.client.entity.model;// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.github.hauntedchest.lovecraftplus.entities.MoonBeastEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MoonBeastModel<T extends MoonBeastEntity> extends EntityModel<T> {
    private final ModelRenderer body_main;
    private final ModelRenderer body_main_secondary;
    private final ModelRenderer thigh_left;
    private final ModelRenderer calf_left;
    private final ModelRenderer foot_left;
    private final ModelRenderer thigh_right;
    private final ModelRenderer calf_right;
    private final ModelRenderer foot_right;
    private final ModelRenderer head_skull;
    private final ModelRenderer head_jaw;
    private final ModelRenderer tentacle;
    private final ModelRenderer tentacle_main_1;
    private final ModelRenderer tentacle_secondary_1;
    private final ModelRenderer tentacle_tertiary_1;
    private final ModelRenderer tentacle_main_2;
    private final ModelRenderer tentacle_secondary_2;
    private final ModelRenderer tentacle_tertiary_2;
    private final ModelRenderer tentacle_main_3;
    private final ModelRenderer tentacle_secondary_3;
    private final ModelRenderer tentacle_tertiary_3;
    private final ModelRenderer tentacle_main_4;
    private final ModelRenderer tentacle_secondary_4;
    private final ModelRenderer tentacle_tertiary_4;
    private final ModelRenderer tentacle_main_5;
    private final ModelRenderer tentacle_secondary_5;
    private final ModelRenderer tentacle_tertiary_5;
    private final ModelRenderer tentacle_main_6;
    private final ModelRenderer tentacle_secondary_6;
    private final ModelRenderer tentacle_tertiary_6;
    private final ModelRenderer arm_proper_left;
    private final ModelRenderer forearm_left;
    private final ModelRenderer arm_proper_right;
    private final ModelRenderer forearm_right;
    private final ModelRenderer getArm_proper_left;
    private final ModelRenderer getArm_proper_right;
    private final ModelRenderer getBody_main;
    private final ModelRenderer getBody_main_secondary;
    private final ModelRenderer getCalf_left;
    private final ModelRenderer getCalf_right;
    private final ModelRenderer getFoot_left;
    private final ModelRenderer getFoot_right;
    private final ModelRenderer getForearm_left;
    private final ModelRenderer getForearm_right;
    private final ModelRenderer getHead_jaw;
    private final ModelRenderer getHead_skull;
    private final ModelRenderer getTentacle;
    private final ModelRenderer getTentacle_main_1;
    private final ModelRenderer getTentacle_main_2;
    private final ModelRenderer getTentacle_main_3;
    private final ModelRenderer getTentacle_main_4;
    private final ModelRenderer getTentacle_main_5;
    private final ModelRenderer getTentacle_main_6;
    private final ModelRenderer getTentacle_secondary_1;
    private final ModelRenderer getTentacle_secondary_2;
    private final ModelRenderer getTentacle_secondary_3;
    private final ModelRenderer getTentacle_secondary_4;
    private final ModelRenderer getTentacle_secondary_5;
    private final ModelRenderer getTentacle_secondary_6;
    private final ModelRenderer getTentacle_tertiary_1;
    private final ModelRenderer getTentacle_tertiary_2;
    private final ModelRenderer getTentacle_tertiary_3;
    private final ModelRenderer getTentacle_tertiary_4;
    private final ModelRenderer getTentacle_tertiary_5;
    private final ModelRenderer getTentacle_tertiary_6;
    private final ModelRenderer getThigh_left;
    private final ModelRenderer getThigh_right;

    public MoonBeastModel() {
        textureWidth = 130;
        textureHeight = 130;

        body_main = new ModelRenderer(this);
        body_main.setRotationPoint(-7.5F, -15.0F, 2.0F);
        setRotationAngle(body_main, 0.2618F, 0.0F, 0.0F);
        body_main.setTextureOffset(0, 38).addBox(0.1406F, -4.0341F, -20.2588F, 15.0F, 11.0F, 21.0F, 1.5F, false);

        body_main_secondary = new ModelRenderer(this);
        body_main_secondary.setRotationPoint(7.5F, -6.1363F, -1.0353F);
        body_main.addChild(body_main_secondary);
        setRotationAngle(body_main_secondary, -0.7854F, 0.0F, 0.0F);
        body_main_secondary.setTextureOffset(0, 0).addBox(-7.3594F, -0.1589F, 2.3284F, 15.0F, 13.0F, 25.0F, 0.0F, false);

        thigh_left = new ModelRenderer(this);
        thigh_left.setRotationPoint(4.0F, 6.0F, 22.0F);
        body_main_secondary.addChild(thigh_left);
        setRotationAngle(thigh_left, -0.0873F, 0.2618F, 0.0F);
        thigh_left.setTextureOffset(84, 86).addBox(1.1406F, -4.5299F, -3.4989F, 6.0F, 9.0F, 16.0F, 0.5F, false);

        calf_left = new ModelRenderer(this);
        calf_left.setRotationPoint(4.0F, 0.0F, 13.0F);
        thigh_left.addChild(calf_left);
        setRotationAngle(calf_left, -1.4835F, -0.0873F, 0.0F);
        calf_left.setTextureOffset(0, 97).addBox(-2.3594F, -4.1743F, -0.0076F, 5.0F, 7.0F, 16.0F, 0.0F, false);

        foot_left = new ModelRenderer(this);
        foot_left.setRotationPoint(0.0F, -1.1743F, 16.0F);
        calf_left.addChild(foot_left);
        setRotationAngle(foot_left, 1.1345F, 0.0F, -0.0873F);
        foot_left.setTextureOffset(86, 23).addBox(-1.3594F, -2.5F, -0.0076F, 3.0F, 4.0F, 10.0F, 0.0F, false);

        thigh_right = new ModelRenderer(this);
        thigh_right.setRotationPoint(-4.0F, 6.0F, 22.0F);
        body_main_secondary.addChild(thigh_right);
        setRotationAngle(thigh_right, -0.4363F, -0.2618F, 0.0F);
        thigh_right.setTextureOffset(85, 61).addBox(-6.8594F, -4.5299F, -3.4989F, 6.0F, 9.0F, 16.0F, 0.5F, false);

        calf_right = new ModelRenderer(this);
        calf_right.setRotationPoint(-4.0F, 0.0F, 13.0F);
        thigh_right.addChild(calf_right);
        setRotationAngle(calf_right, -1.5708F, 0.0873F, 0.0F);
        calf_right.setTextureOffset(86, 0).addBox(-2.3594F, -4.1743F, -0.0076F, 5.0F, 7.0F, 16.0F, 0.0F, false);

        foot_right = new ModelRenderer(this);
        foot_right.setRotationPoint(0.0F, -1.1743F, 16.0F);
        calf_right.addChild(foot_right);
        setRotationAngle(foot_right, 1.5708F, 0.0F, 0.0873F);
        foot_right.setTextureOffset(31, 70).addBox(-1.3594F, -2.5F, -0.0076F, 3.0F, 4.0F, 10.0F, 0.0F, false);

        head_skull = new ModelRenderer(this);
        head_skull.setRotationPoint(7.5F, 3.9659F, -22.2588F);
        body_main.addChild(head_skull);
        setRotationAngle(head_skull, -0.2618F, 0.0F, 0.0F);
        head_skull.setTextureOffset(78, 41).addBox(-6.8594F, -9.5341F, -11.7588F, 14.0F, 8.0F, 12.0F, 0.0F, false);

        head_jaw = new ModelRenderer(this);
        head_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        head_skull.addChild(head_jaw);
        setRotationAngle(head_jaw, 1.2217F, 0.0F, 0.0F);
        head_jaw.setTextureOffset(55, 0).addBox(-5.3594F, 0.4659F, -7.7588F, 11.0F, 2.0F, 8.0F, 0.0F, false);

        tentacle = new ModelRenderer(this);
        tentacle.setRotationPoint(0.0F, -1.0F, 0.0F);
        head_skull.addChild(tentacle);
        setRotationAngle(tentacle, -0.1745F, 0.0F, 0.0F);


        tentacle_main_1 = new ModelRenderer(this);
        tentacle_main_1.setRotationPoint(-3.25F, -0.2841F, 0.3412F);
        tentacle.addChild(tentacle_main_1);
        setRotationAngle(tentacle_main_1, -0.6981F, 0.1745F, 0.0F);
        tentacle_main_1.setTextureOffset(0, 38).addBox(-1.3594F, 0.0F, -0.85F, 2.0F, 10.0F, 2.0F, 0.25F, false);

        tentacle_secondary_1 = new ModelRenderer(this);
        tentacle_secondary_1.setRotationPoint(-0.5F, 10.25F, 0.15F);
        tentacle_main_1.addChild(tentacle_secondary_1);
        setRotationAngle(tentacle_secondary_1, 0.7854F, 0.0F, -0.0873F);
        tentacle_secondary_1.setTextureOffset(0, 70).addBox(-0.8594F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

        tentacle_tertiary_1 = new ModelRenderer(this);
        tentacle_tertiary_1.setRotationPoint(0.0F, 9.0F, 0.0F);
        tentacle_secondary_1.addChild(tentacle_tertiary_1);
        setRotationAngle(tentacle_tertiary_1, -0.1745F, 0.0F, 0.2618F);
        tentacle_tertiary_1.setTextureOffset(51, 50).addBox(-0.3594F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        tentacle_main_2 = new ModelRenderer(this);
        tentacle_main_2.setRotationPoint(3.75F, 0.7159F, 0.3412F);
        tentacle.addChild(tentacle_main_2);
        setRotationAngle(tentacle_main_2, -1.0472F, -0.1745F, 0.0F);
        tentacle_main_2.setTextureOffset(16, 12).addBox(-1.3594F, 0.0F, -0.85F, 2.0F, 10.0F, 2.0F, 0.25F, false);

        tentacle_secondary_2 = new ModelRenderer(this);
        tentacle_secondary_2.setRotationPoint(-0.5F, 10.25F, 0.15F);
        tentacle_main_2.addChild(tentacle_secondary_2);
        setRotationAngle(tentacle_secondary_2, 0.6109F, 0.0F, 0.1745F);
        tentacle_secondary_2.setTextureOffset(63, 10).addBox(-0.8594F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

        tentacle_tertiary_2 = new ModelRenderer(this);
        tentacle_tertiary_2.setRotationPoint(0.0F, 9.0F, 0.0F);
        tentacle_secondary_2.addChild(tentacle_tertiary_2);
        setRotationAngle(tentacle_tertiary_2, 0.4363F, 0.0F, -0.1745F);
        tentacle_tertiary_2.setTextureOffset(0, 50).addBox(-0.3594F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        tentacle_main_3 = new ModelRenderer(this);
        tentacle_main_3.setRotationPoint(-0.25F, 2.7159F, 0.3412F);
        tentacle.addChild(tentacle_main_3);
        setRotationAngle(tentacle_main_3, -0.6981F, 0.0F, 0.0F);
        tentacle_main_3.setTextureOffset(16, 0).addBox(-1.3594F, 0.0F, -0.85F, 2.0F, 10.0F, 2.0F, 0.25F, false);

        tentacle_secondary_3 = new ModelRenderer(this);
        tentacle_secondary_3.setRotationPoint(-0.5F, 10.25F, 0.15F);
        tentacle_main_3.addChild(tentacle_secondary_3);
        setRotationAngle(tentacle_secondary_3, 0.6109F, 0.0F, -0.1745F);
        tentacle_secondary_3.setTextureOffset(57, 48).addBox(-0.8594F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

        tentacle_tertiary_3 = new ModelRenderer(this);
        tentacle_tertiary_3.setRotationPoint(0.0F, 9.0F, 0.0F);
        tentacle_secondary_3.addChild(tentacle_tertiary_3);
        setRotationAngle(tentacle_tertiary_3, -0.2618F, 0.0F, 0.1745F);
        tentacle_tertiary_3.setTextureOffset(11, 49).addBox(-0.3594F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        tentacle_main_4 = new ModelRenderer(this);
        tentacle_main_4.setRotationPoint(1.75F, -1.2841F, 0.3412F);
        tentacle.addChild(tentacle_main_4);
        setRotationAngle(tentacle_main_4, -1.2217F, 0.1745F, 0.0F);
        tentacle_main_4.setTextureOffset(0, 12).addBox(-1.3594F, 0.0F, -0.85F, 2.0F, 10.0F, 2.0F, 0.25F, false);

        tentacle_secondary_4 = new ModelRenderer(this);
        tentacle_secondary_4.setRotationPoint(-0.5F, 10.25F, 0.15F);
        tentacle_main_4.addChild(tentacle_secondary_4);
        setRotationAngle(tentacle_secondary_4, 0.3491F, 0.0F, 0.0F);
        tentacle_secondary_4.setTextureOffset(55, 10).addBox(-0.8594F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

        tentacle_tertiary_4 = new ModelRenderer(this);
        tentacle_tertiary_4.setRotationPoint(0.0F, 9.0F, 0.0F);
        tentacle_secondary_4.addChild(tentacle_tertiary_4);
        setRotationAngle(tentacle_tertiary_4, 0.4363F, 0.0F, -0.4363F);
        tentacle_tertiary_4.setTextureOffset(7, 49).addBox(-0.3594F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        tentacle_main_5 = new ModelRenderer(this);
        tentacle_main_5.setRotationPoint(1.25F, 1.2159F, 0.3412F);
        tentacle.addChild(tentacle_main_5);
        setRotationAngle(tentacle_main_5, -1.1345F, 0.0F, 0.0F);
        tentacle_main_5.setTextureOffset(8, 8).addBox(-1.3594F, 0.0F, -0.85F, 2.0F, 10.0F, 2.0F, 0.25F, false);

        tentacle_secondary_5 = new ModelRenderer(this);
        tentacle_secondary_5.setRotationPoint(-0.5F, 10.25F, 0.15F);
        tentacle_main_5.addChild(tentacle_secondary_5);
        setRotationAngle(tentacle_secondary_5, 0.5236F, 0.0F, -0.1745F);
        tentacle_secondary_5.setTextureOffset(51, 39).addBox(-0.8594F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

        tentacle_tertiary_5 = new ModelRenderer(this);
        tentacle_tertiary_5.setRotationPoint(0.0F, 9.0F, 0.0F);
        tentacle_secondary_5.addChild(tentacle_tertiary_5);
        setRotationAngle(tentacle_tertiary_5, 0.6109F, 0.0F, -0.0873F);
        tentacle_tertiary_5.setTextureOffset(16, 47).addBox(-0.3594F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        tentacle_main_6 = new ModelRenderer(this);
        tentacle_main_6.setRotationPoint(-1.75F, 0.7159F, 0.3412F);
        tentacle.addChild(tentacle_main_6);
        setRotationAngle(tentacle_main_6, -0.9599F, 0.0F, 0.0F);
        tentacle_main_6.setTextureOffset(0, 0).addBox(-1.3594F, 0.0F, -0.85F, 2.0F, 10.0F, 2.0F, 0.25F, false);

        tentacle_secondary_6 = new ModelRenderer(this);
        tentacle_secondary_6.setRotationPoint(-0.5F, 10.25F, 0.15F);
        tentacle_main_6.addChild(tentacle_secondary_6);
        setRotationAngle(tentacle_secondary_6, 0.6109F, 0.0F, 0.1745F);
        tentacle_secondary_6.setTextureOffset(8, 38).addBox(-0.8594F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

        tentacle_tertiary_6 = new ModelRenderer(this);
        tentacle_tertiary_6.setRotationPoint(0.0F, 9.0F, 0.0F);
        tentacle_secondary_6.addChild(tentacle_tertiary_6);
        setRotationAngle(tentacle_tertiary_6, 0.0F, 0.0F, -0.2618F);
        tentacle_tertiary_6.setTextureOffset(16, 38).addBox(-0.3594F, 0.0F, -0.5F, 1.0F, 8.0F, 1.0F, 0.0F, false);

        arm_proper_left = new ModelRenderer(this);
        arm_proper_left.setRotationPoint(14.0F, 1.9659F, -9.2588F);
        body_main.addChild(arm_proper_left);
        setRotationAngle(arm_proper_left, -0.6109F, 0.3491F, 0.0F);
        arm_proper_left.setTextureOffset(50, 75).addBox(-1.3594F, -3.7564F, -3.2562F, 6.0F, 8.0F, 19.0F, 0.5F, false);

        forearm_left = new ModelRenderer(this);
        forearm_left.setRotationPoint(1.5F, -0.7564F, 13.2438F);
        arm_proper_left.addChild(forearm_left);
        setRotationAngle(forearm_left, -1.7454F, 0.0F, 0.0F);
        forearm_left.setTextureOffset(57, 15).addBox(-1.3083F, -1.5614F, -0.4083F, 3.0F, 3.0F, 23.0F, 0.5F, false);

        arm_proper_right = new ModelRenderer(this);
        arm_proper_right.setRotationPoint(1.0F, 1.9659F, -9.2588F);
        body_main.addChild(arm_proper_right);
        setRotationAngle(arm_proper_right, -1.3963F, -0.3491F, 0.0873F);
        arm_proper_right.setTextureOffset(0, 70).addBox(-4.3594F, -3.7564F, -3.2562F, 6.0F, 8.0F, 19.0F, 0.5F, false);

        forearm_right = new ModelRenderer(this);
        forearm_right.setRotationPoint(-1.5F, -0.7564F, 13.2438F);
        arm_proper_right.addChild(forearm_right);
        setRotationAngle(forearm_right, -0.5236F, 0.0F, 0.0F);
        forearm_right.setTextureOffset(49, 49).addBox(-1.4105F, -1.5614F, -0.4083F, 3.0F, 3.0F, 23.0F, 0.5F, false);

        getArm_proper_left = new ModelRenderer(this);
        getArm_proper_left.setRotationPoint(0.0F, 0.0F, 0.0F);


        getArm_proper_right = new ModelRenderer(this);
        getArm_proper_right.setRotationPoint(0.0F, 0.0F, 0.0F);


        getBody_main = new ModelRenderer(this);
        getBody_main.setRotationPoint(0.0F, 0.0F, 0.0F);


        getBody_main_secondary = new ModelRenderer(this);
        getBody_main_secondary.setRotationPoint(0.0F, 0.0F, 0.0F);


        getCalf_left = new ModelRenderer(this);
        getCalf_left.setRotationPoint(0.0F, 0.0F, 0.0F);


        getCalf_right = new ModelRenderer(this);
        getCalf_right.setRotationPoint(0.0F, 0.0F, 0.0F);


        getFoot_left = new ModelRenderer(this);
        getFoot_left.setRotationPoint(0.0F, 0.0F, 0.0F);


        getFoot_right = new ModelRenderer(this);
        getFoot_right.setRotationPoint(0.0F, 0.0F, 0.0F);


        getForearm_left = new ModelRenderer(this);
        getForearm_left.setRotationPoint(0.0F, 0.0F, 0.0F);


        getForearm_right = new ModelRenderer(this);
        getForearm_right.setRotationPoint(0.0F, 0.0F, 0.0F);


        getHead_jaw = new ModelRenderer(this);
        getHead_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);


        getHead_skull = new ModelRenderer(this);
        getHead_skull.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle = new ModelRenderer(this);
        getTentacle.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_main_1 = new ModelRenderer(this);
        getTentacle_main_1.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_main_2 = new ModelRenderer(this);
        getTentacle_main_2.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_main_3 = new ModelRenderer(this);
        getTentacle_main_3.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_main_4 = new ModelRenderer(this);
        getTentacle_main_4.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_main_5 = new ModelRenderer(this);
        getTentacle_main_5.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_main_6 = new ModelRenderer(this);
        getTentacle_main_6.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_secondary_1 = new ModelRenderer(this);
        getTentacle_secondary_1.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_secondary_2 = new ModelRenderer(this);
        getTentacle_secondary_2.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_secondary_3 = new ModelRenderer(this);
        getTentacle_secondary_3.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_secondary_4 = new ModelRenderer(this);
        getTentacle_secondary_4.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_secondary_5 = new ModelRenderer(this);
        getTentacle_secondary_5.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_secondary_6 = new ModelRenderer(this);
        getTentacle_secondary_6.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_tertiary_1 = new ModelRenderer(this);
        getTentacle_tertiary_1.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_tertiary_2 = new ModelRenderer(this);
        getTentacle_tertiary_2.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_tertiary_3 = new ModelRenderer(this);
        getTentacle_tertiary_3.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_tertiary_4 = new ModelRenderer(this);
        getTentacle_tertiary_4.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_tertiary_5 = new ModelRenderer(this);
        getTentacle_tertiary_5.setRotationPoint(0.0F, 0.0F, 0.0F);


        getTentacle_tertiary_6 = new ModelRenderer(this);
        getTentacle_tertiary_6.setRotationPoint(0.0F, 0.0F, 0.0F);


        getThigh_left = new ModelRenderer(this);
        getThigh_left.setRotationPoint(0.0F, 0.0F, 0.0F);


        getThigh_right = new ModelRenderer(this);
        getThigh_right.setRotationPoint(0.0F, 0.0F, 0.0F);

    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        body_main.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        //body_main_secondary.render(matrixStackIn,bufferIn,packedLightIn,packedOverlayIn,red,green,blue,alpha);
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

    public ModelRenderer getArm_proper_left() {
        return arm_proper_left;
    }

    public ModelRenderer getArm_proper_right() {
        return arm_proper_right;
    }

    public ModelRenderer getBody_main() {
        return body_main;
    }

    public ModelRenderer getBody_main_secondary() {
        return body_main_secondary;
    }

    public ModelRenderer getCalf_left() {
        return calf_left;
    }

    public ModelRenderer getCalf_right() {
        return calf_right;
    }

    public ModelRenderer getFoot_left() {
        return foot_left;
    }

    public ModelRenderer getFoot_right() {
        return foot_right;
    }

    public ModelRenderer getForearm_left() {
        return forearm_left;
    }

    public ModelRenderer getForearm_right() {
        return forearm_right;
    }

    public ModelRenderer getHead_jaw() {
        return head_jaw;
    }

    public ModelRenderer getHead_skull() {
        return head_skull;
    }

    public ModelRenderer getTentacle() {
        return tentacle;
    }

    public ModelRenderer getTentacle_main_1() {
        return tentacle_main_1;
    }

    public ModelRenderer getTentacle_main_2() {
        return tentacle_main_2;
    }

    public ModelRenderer getTentacle_main_3() {
        return tentacle_main_3;
    }

    public ModelRenderer getTentacle_main_4() {
        return tentacle_main_4;
    }

    public ModelRenderer getTentacle_main_5() {
        return tentacle_main_5;
    }

    public ModelRenderer getTentacle_main_6() {
        return tentacle_main_6;
    }

    public ModelRenderer getTentacle_secondary_1() {
        return tentacle_secondary_1;
    }

    public ModelRenderer getTentacle_secondary_2() {
        return tentacle_secondary_2;
    }

    public ModelRenderer getTentacle_secondary_3() {
        return tentacle_secondary_3;
    }

    public ModelRenderer getTentacle_secondary_4() {
        return tentacle_secondary_4;
    }

    public ModelRenderer getTentacle_secondary_5() {
        return tentacle_secondary_5;
    }

    public ModelRenderer getTentacle_secondary_6() {
        return tentacle_secondary_6;
    }

    public ModelRenderer getTentacle_tertiary_1() {
        return tentacle_tertiary_1;
    }

    public ModelRenderer getTentacle_tertiary_2() {
        return tentacle_tertiary_2;
    }

    public ModelRenderer getTentacle_tertiary_3() {
        return tentacle_tertiary_3;
    }

    public ModelRenderer getTentacle_tertiary_4() {
        return tentacle_tertiary_4;
    }

    public ModelRenderer getTentacle_tertiary_5() {
        return tentacle_tertiary_5;
    }

    public ModelRenderer getTentacle_tertiary_6() {
        return tentacle_tertiary_6;
    }

    public ModelRenderer getThigh_left() {
        return thigh_left;
    }

    public ModelRenderer getThigh_right() {
        return thigh_right;
    }
}