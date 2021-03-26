package com.crypticcosmos.crypticcosmos.creatures.moon_traploom;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TraploomRender extends GeoEntityRenderer<TraploomEntity> {
    public TraploomRender(EntityRendererManager renderManager) {
        super(renderManager, new TraploomModel());
        this.shadowRadius = 0.1F;
    }
}