package com.crypticcosmos.crypticcosmos.creatures.moon_frog;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MoonFrogRender extends GeoEntityRenderer<MoonFrogEntity> {
    public MoonFrogRender(EntityRendererManager renderManager) {
        super(renderManager, new MoonFrogModel());
        this.shadowRadius = 0.4F;
    }
}