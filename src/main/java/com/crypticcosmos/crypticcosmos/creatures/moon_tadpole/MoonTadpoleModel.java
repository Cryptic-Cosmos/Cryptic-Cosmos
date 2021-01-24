package com.crypticcosmos.crypticcosmos.creatures.moon_tadpole;// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports


import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

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
}