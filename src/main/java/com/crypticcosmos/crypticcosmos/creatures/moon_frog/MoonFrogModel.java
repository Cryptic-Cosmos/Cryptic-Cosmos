package com.crypticcosmos.crypticcosmos.creatures.moon_frog;// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MoonFrogModel extends AnimatedGeoModel<MoonFrogEntity>{

    @Override
    public ResourceLocation getModelLocation(MoonFrogEntity moonFrogEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "geo/moonfrog.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MoonFrogEntity moonFrogEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/moon_frog.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MoonFrogEntity moonFrogEntity) {
        return new ResourceLocation(CrypticCosmos.MOD_ID, "animations/moon.frog.json");
    }
}