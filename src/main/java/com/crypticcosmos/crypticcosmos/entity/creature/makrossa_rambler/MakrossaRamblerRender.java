package com.crypticcosmos.crypticcosmos.entity.creature.makrossa_rambler;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MakrossaRamblerRender extends GeoEntityRenderer<MakrossaRambler> {
    public MakrossaRamblerRender(EntityRendererProvider.Context context) {
        super(context, new MakrossaRamblerModel());
        this.shadowRadius = 1.2f;
    }
}