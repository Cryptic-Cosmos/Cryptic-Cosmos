package com.crypticcosmos.crypticcosmos.creatures.moon_tadpole;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MoonTadpoleRender extends GeoEntityRenderer<MoonTadpoleEntity> {
    public MoonTadpoleRender(EntityRendererManager renderManager) {
        super(renderManager, new MoonTadpoleModel());
        this.shadowSize = 0.1F;
    }
}