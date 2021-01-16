package com.github.hauntedchest.lovecraftplus.client.entity.model.render;

import com.github.hauntedchest.lovecraftplus.client.entity.model.MoonFrogModel;
import com.github.hauntedchest.lovecraftplus.entities.MoonFrogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MoonFrogRender extends GeoEntityRenderer<MoonFrogEntity> {
    public MoonFrogRender(EntityRendererManager renderManager) {
        super(renderManager, new MoonFrogModel());
        this.shadowSize = 0.6f;
    }
}