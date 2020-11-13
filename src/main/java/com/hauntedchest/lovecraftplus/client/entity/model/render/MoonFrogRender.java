package com.hauntedchest.lovecraftplus.client.entity.model.render;

import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import com.hauntedchest.lovecraftplus.client.entity.model.MoonFrogModel;
import com.hauntedchest.lovecraftplus.entities.MoonFrogEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MoonFrogRender extends MobRenderer<MoonFrogEntity, MoonFrogModel<MoonFrogEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(LovecraftPlusMod.MOD_ID, "textures/entity/moon_frog.png");

    public MoonFrogRender(EntityRendererManager renderManagerIn){
        super(renderManagerIn, new MoonFrogModel<>(), 0.5f);

    }

    @Override
    public ResourceLocation getEntityTexture(MoonFrogEntity entity) {
        return TEXTURE;
    }
}