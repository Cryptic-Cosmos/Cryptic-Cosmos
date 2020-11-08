package com.hauntedchest.lovecraftplus.client.entity.model.render;

import com.hauntedchest.lovecraftplus.client.entity.model.MoonFrogModel1;
import com.hauntedchest.lovecraftplus.entities.MoonFrogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib.renderers.geo.GeoEntityRenderer;

public class MoonFrogRender extends GeoEntityRenderer<MoonFrogEntity> {
    public MoonFrogRender(EntityRendererManager renderManager)
    {
        super(renderManager, new MoonFrogModel1());
    }
}
