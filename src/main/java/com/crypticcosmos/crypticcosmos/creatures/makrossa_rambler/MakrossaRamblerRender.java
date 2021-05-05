package com.crypticcosmos.crypticcosmos.creatures.makrossa_rambler;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MakrossaRamblerRender extends GeoEntityRenderer<MakrossaRamblerEntity> {
    public MakrossaRamblerRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MakrossaRamblerModel());
        this.shadowRadius = 1.2f;
    }
}