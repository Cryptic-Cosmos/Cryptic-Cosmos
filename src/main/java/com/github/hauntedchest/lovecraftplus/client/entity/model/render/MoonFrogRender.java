package com.github.hauntedchest.lovecraftplus.client.entity.model.render;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.client.entity.model.MoonFrogModel;
import com.github.hauntedchest.lovecraftplus.entities.MoonFrogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class MoonFrogRender extends MobRenderer<MoonFrogEntity, MoonFrogModel<MoonFrogEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LovecraftPlus.MOD_ID, "textures/entity/moon_frog.png");

    public MoonFrogRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MoonFrogModel<>(), 0.5f);

    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull MoonFrogEntity entity) {
        return TEXTURE;
    }
}