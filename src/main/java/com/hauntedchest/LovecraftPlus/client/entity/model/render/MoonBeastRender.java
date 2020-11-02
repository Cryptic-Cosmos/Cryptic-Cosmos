package com.hauntedchest.LovecraftPlus.client.entity.model.render;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.client.entity.model.MoonBeastModel;
import com.hauntedchest.LovecraftPlus.entities.MoonBeastEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MoonBeastRender extends MobRenderer<MoonBeastEntity, MoonBeastModel<MoonBeastEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(LovecraftPlusMod.MOD_ID, "textures/entity/moon_beast_texture.png");

    public MoonBeastRender(EntityRendererManager renderManagerIn){
        super(renderManagerIn, new MoonBeastModel<MoonBeastEntity>(), 0.5f);

    }

    @Override
    public ResourceLocation getEntityTexture(MoonBeastEntity entity) {
        return TEXTURE;
    }
}
