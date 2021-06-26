package com.crypticcosmos.crypticcosmos.entity.creature.gromble_frog;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GrombleFrogRender extends GeoEntityRenderer<GrombleFrogEntity> {
    public GrombleFrogRender(EntityRendererManager renderManager) {
        super(renderManager, new GrombleFrogModel());
        this.shadowRadius = 0.4F;
    }
}