package com.crypticcosmos.crypticcosmos.creatures.moon_traploom;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MoonTraploomRender extends GeoEntityRenderer<MoonTraploomEntity> {
    public MoonTraploomRender(EntityRendererManager renderManager) {
        super(renderManager, new MoonTraploomModel());
        this.shadowSize = 0.1F;
    }
}