package com.crypticcosmos.crypticcosmos.entity.creature.makrossa_rambler;// Made with Blockbench 3.7.2
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class MakrossaRamblerModel extends AnimatedGeoModel<MakrossaRambler> {
    @Override
    public ResourceLocation getModelLocation(MakrossaRambler makrossaRambler) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "geo/makrossa_rambler.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MakrossaRambler makrossaRambler) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/makrossa_rambler.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MakrossaRambler makrossaRambler) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "animations/makrossa_rambler.json");
    }

    @Override
    public void setLivingAnimations(MakrossaRambler entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData data = (EntityModelData) customPredicate.getExtraData().get(0);
        // Apply head look to model
        IBone head = this.getAnimationProcessor().getBone("head_skull");
        head.setRotationY((float) Math.toRadians(Mth.clamp(data.netHeadYaw, -45, 45)));
        head.setRotationX(-(float) Math.toRadians(data.headPitch));
    }
}