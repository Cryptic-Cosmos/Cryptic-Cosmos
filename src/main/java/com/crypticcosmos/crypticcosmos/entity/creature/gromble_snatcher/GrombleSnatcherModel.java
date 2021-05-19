package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class GrombleSnatcherModel extends AnimatedGeoModel<GrombleSnatcherEntity> {
    @Override
    public ResourceLocation getModelLocation(GrombleSnatcherEntity grombleSnatcherEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "geo/gromble_snatcher.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GrombleSnatcherEntity grombleSnatcherEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/gromble_snatcher.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GrombleSnatcherEntity grombleSnatcherEntity) {
        return null;
    }

    @Override
    public void setLivingAnimations(GrombleSnatcherEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        EntityModelData data = (EntityModelData) customPredicate.getExtraData().get(0);
        // Apply head look to model
        IBone head = this.getAnimationProcessor().getBone("mouthbody");
        head.setRotationY((float) Math.toRadians(MathHelper.clamp(data.netHeadYaw, -45, 45)));
        head.setRotationX(-(float) Math.toRadians(data.headPitch));
    }
}
