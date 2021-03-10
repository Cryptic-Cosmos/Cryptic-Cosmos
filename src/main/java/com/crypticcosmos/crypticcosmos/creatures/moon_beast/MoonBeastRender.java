package com.crypticcosmos.crypticcosmos.creatures.moon_beast;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MoonBeastRender extends GeoEntityRenderer<MoonBeastEntity> {
    public MoonBeastRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MoonBeastModel());
        this.shadowRadius = 1.2f;
    }
}