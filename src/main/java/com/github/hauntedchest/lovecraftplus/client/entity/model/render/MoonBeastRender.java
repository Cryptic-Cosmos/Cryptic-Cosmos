package com.github.hauntedchest.lovecraftplus.client.entity.model.render;

import com.github.hauntedchest.lovecraftplus.client.entity.model.MoonBeastModel;
import com.github.hauntedchest.lovecraftplus.entities.MoonBeastEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@SuppressWarnings("NullableProblems")
public class MoonBeastRender extends GeoEntityRenderer<MoonBeastEntity> {
    public MoonBeastRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MoonBeastModel());
        this.shadowSize = 0.6f;

    }
}
