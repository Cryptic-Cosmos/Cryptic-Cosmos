package com.crypticcosmos.crypticcosmos.entity.creature.gromble_frog;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GrombleFrogRender extends GeoEntityRenderer<GrombleFrog> {
    public GrombleFrogRender(EntityRendererProvider.Context context) {
        super(context, new GrombleFrogModel());
        this.shadowRadius = 0.4F;
    }
}