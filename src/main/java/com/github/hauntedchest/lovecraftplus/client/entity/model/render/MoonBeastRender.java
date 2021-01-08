package com.github.hauntedchest.lovecraftplus.client.entity.model.render;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.client.entity.model.MoonBeastEntityModel;
import com.github.hauntedchest.lovecraftplus.entities.MoonBeastEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

@SuppressWarnings("NullableProblems")
public class MoonBeastRender extends GeoEntityRenderer<MoonBeastEntity> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(LovecraftPlus.MOD_ID, "textures/entity/moon_beast_texture.png");

    public MoonBeastRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MoonBeastEntityModel());
        this.shadowSize = 0.6f;

    }

    @Override
    public ResourceLocation getEntityTexture(MoonBeastEntity entity) {
        return null;
    }
}
