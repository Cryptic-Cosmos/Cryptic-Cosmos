package com.hauntedchest.lovecraftplus.client.entity.model;

import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import com.hauntedchest.lovecraftplus.entities.MoonFrogEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class MoonFrogModel extends AnimatedGeoModel<MoonFrogEntity> {

    @Override
    public ResourceLocation getModelLocation(MoonFrogEntity moonFrogEntity) {
        return new ResourceLocation(LovecraftPlusMod.MOD_ID, "geo/moonfrogmodel.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MoonFrogEntity moonFrogEntity) {
        return new ResourceLocation(LovecraftPlusMod.MOD_ID, "textures/entity/moon_frog.png");

    }

    @Override
    public ResourceLocation getAnimationFileLocation(MoonFrogEntity moonFrogEntity) {
        return new ResourceLocation(LovecraftPlusMod.MOD_ID, "animations/frog_move.json");
    }
}
