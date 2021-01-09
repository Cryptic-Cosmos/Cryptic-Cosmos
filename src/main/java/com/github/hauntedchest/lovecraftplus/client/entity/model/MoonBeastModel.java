package com.github.hauntedchest.lovecraftplus.client.entity.model;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.entities.MoonBeastEntity;
import com.github.hauntedchest.lovecraftplus.registries.Utils;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import javax.annotation.Nullable;

public class MoonBeastModel extends AnimatedGeoModel<MoonBeastEntity> {
    @Override
    public ResourceLocation getModelLocation(MoonBeastEntity moonBeastEntity) {
        return new ResourceLocation(LovecraftPlus.MOD_ID, "geo/moonbeastmodel.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MoonBeastEntity moonBeastEntity) {
        return new ResourceLocation(LovecraftPlus.MOD_ID, "textures/entity/moon_beast_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MoonBeastEntity moonBeastEntity) {
        return new ResourceLocation(LovecraftPlus.MOD_ID, "animations/moonbeast.json");
    }

    @Override
    public void setLivingAnimations(MoonBeastEntity entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        assert customPredicate != null;
        EntityModelData data = (EntityModelData) customPredicate.getExtraData().get(0);

        // Apply head look to model
        IBone head = this.getAnimationProcessor().getBone("head_skull");
        head.setRotationY((float) Math.toRadians(Utils.clamp(data.netHeadYaw, -45, 45)));
        head.setRotationX(-(float) Math.toRadians(data.headPitch));
    }
}
