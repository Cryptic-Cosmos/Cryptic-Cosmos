package com.crypticcosmos.crypticcosmos.client.entity.model.render;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.client.entity.model.MoonBeastModel;
import com.crypticcosmos.crypticcosmos.entities.MoonBeastEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("NullableProblems")
public class MoonBeastRender extends MobRenderer<MoonBeastEntity, MoonBeastModel<MoonBeastEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(CrypticCosmos.MOD_ID, "textures/entity/moon_beast_texture.png");

    public MoonBeastRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MoonBeastModel<>(), 0.5f);

    }

    @Override
    public ResourceLocation getEntityTexture(MoonBeastEntity entity) {
        return TEXTURE;
    }
}
