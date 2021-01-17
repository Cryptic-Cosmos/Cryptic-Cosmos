package com.crypticcosmos.crypticcosmos.client.entity.model.render;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.client.entity.model.MoonFrogModel;
import com.crypticcosmos.crypticcosmos.entities.MoonFrogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class MoonFrogRender extends MobRenderer<MoonFrogEntity, MoonFrogModel<MoonFrogEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/moon_frog.png");

    public MoonFrogRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MoonFrogModel<>(), 0.5f);

    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull MoonFrogEntity entity) {
        return TEXTURE;
    }
}