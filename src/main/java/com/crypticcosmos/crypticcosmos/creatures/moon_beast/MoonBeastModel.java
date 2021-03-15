package com.crypticcosmos.crypticcosmos.creatures.moon_beast;// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class MoonBeastModel extends AnimatedGeoModel<MoonBeastEntity> {
    @Override
    public ResourceLocation getModelLocation(MoonBeastEntity moonBeastEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "geo/moon_beast.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MoonBeastEntity moonBeastEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/moon_beast.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MoonBeastEntity moonBeastEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "animations/moon_beast.json");
    }

    @Override
    public void setLivingAnimations(MoonBeastEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData data = (EntityModelData) customPredicate.getExtraData().get(0);
        // Apply head look to model
        IBone head = this.getAnimationProcessor().getBone("head_skull");
        head.setRotationY((float) Math.toRadians(MathHelper.clamp(data.netHeadYaw, -45, 45)));
        head.setRotationX(-(float) Math.toRadians(data.headPitch));
    }
}