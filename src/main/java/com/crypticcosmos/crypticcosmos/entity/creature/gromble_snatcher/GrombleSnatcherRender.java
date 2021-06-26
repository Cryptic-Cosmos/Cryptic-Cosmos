package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class GrombleSnatcherRender extends GeoEntityRenderer<GrombleSnatcherEntity> {
    public GrombleSnatcherRender(EntityRendererManager renderManager) {
        super(renderManager, new GrombleSnatcherModel());
        this.shadowRadius = 1.8F;
    }

    @Override
    public RenderType getRenderType(GrombleSnatcherEntity animatable, float partialTicks, MatrixStack stack, @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityCutoutNoCull(textureLocation);
    }
}
