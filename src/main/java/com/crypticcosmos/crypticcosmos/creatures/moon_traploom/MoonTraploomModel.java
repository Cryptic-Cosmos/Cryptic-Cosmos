package com.crypticcosmos.crypticcosmos.creatures.moon_traploom;// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MoonTraploomModel extends AnimatedGeoModel<MoonTraploomEntity> {

    @Override
    public ResourceLocation getModelLocation(MoonTraploomEntity moonFrogEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "geo/moon_traploom.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MoonTraploomEntity moonFrogEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/moon_traploom.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MoonTraploomEntity moonFrogEntity) {
        return null;
    }
}