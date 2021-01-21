package com.crypticcosmos.crypticcosmos.creatures.moon_tadpole;// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.util.Utils;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class MoonTadpoleModel extends AnimatedGeoModel<MoonTadpoleEntity>{

    @Override
    public ResourceLocation getModelLocation(MoonTadpoleEntity moonFrogEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "geo/moon_tadpole.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MoonTadpoleEntity moonFrogEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/moon_tadpole.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MoonTadpoleEntity moonFrogEntity) {
        return null;
    }

    @Override
    public void setLivingAnimations(MoonTadpoleEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData data = (EntityModelData) customPredicate.getExtraData().get(0);
        // Apply head look to model
        IBone head = this.getAnimationProcessor().getBone("head");
        head.setRotationY((float) Math.toRadians(Utils.clamp(data.netHeadYaw, -45, 45)));
        head.setRotationX(-(float) Math.toRadians(data.headPitch));
    }
}