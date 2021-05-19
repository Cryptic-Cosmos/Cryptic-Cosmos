package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GrombleSnatcherRender extends GeoEntityRenderer<GrombleSnatcherEntity> {
    public GrombleSnatcherRender(EntityRendererManager renderManager) {
        super(renderManager, new GrombleSnatcherModel());
        this.shadowRadius = 1.8F;
    }
}
