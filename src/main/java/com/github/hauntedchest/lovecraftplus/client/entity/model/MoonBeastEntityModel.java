package com.github.hauntedchest.lovecraftplus.client.entity.model;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.entities.MoonBeastEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MoonBeastEntityModel extends AnimatedGeoModel<MoonBeastEntity> {
    @Override
    public ResourceLocation getModelLocation(MoonBeastEntity moonBeastEntity) {
        return new ResourceLocation(LovecraftPlus.MOD_ID, "geo/MoonBeastModel.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MoonBeastEntity moonBeastEntity) {
        return new ResourceLocation(LovecraftPlus.MOD_ID, "textures/entity/moon_beast_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MoonBeastEntity moonBeastEntity) {
        return new ResourceLocation(LovecraftPlus.MOD_ID, "animations/MoonBeastModel.animation.json");
    }
}
