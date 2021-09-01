package com.crypticcosmos.crypticcosmos.entity.creature.gromble_frog;// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class GrombleFrogModel extends AnimatedGeoModel<GrombleFrog> {

    @Override
    public ResourceLocation getModelLocation(GrombleFrog grombleFrog) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "geo/gromble_frog.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GrombleFrog grombleFrog) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/gromble_frog.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GrombleFrog grombleFrog) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "animations/gromble_frog.json");
    }

    @Override
    public void setLivingAnimations(GrombleFrog entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData data = (EntityModelData) customPredicate.getExtraData().get(0);
        // Apply head look to model
        IBone head = this.getAnimationProcessor().getBone("Head");
        head.setRotationY((float) Math.toRadians(Mth.clamp(data.netHeadYaw, -45, 45)));
        head.setRotationX(-(float) Math.toRadians(data.headPitch));
    }
}