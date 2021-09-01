package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GrombleSnatcherModel extends AnimatedGeoModel<GrombleSnatcher> {
    @Override
    public ResourceLocation getModelLocation(GrombleSnatcher grombleSnatcher) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "geo/gromble_snatcher.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GrombleSnatcher grombleSnatcher) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/gromble_snatcher.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GrombleSnatcher grombleSnatcher) {
        return null;
    }

    /*@Override
    public void setLivingAnimations(GrombleSnatcher entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData data = (EntityModelData) customPredicate.getExtraData().get(0);
        // Apply head look to model
        IBone head = this.getAnimationProcessor().getBone("mouthbody");
        head.setRotationY((float) Math.toRadians(MathHelper.clamp(data.netHeadYaw, -45, 45)));
        head.setRotationX(-(float) Math.toRadians(data.headPitch));
    } */
}
