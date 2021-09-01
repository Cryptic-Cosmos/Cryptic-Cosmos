package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class GrombleSnatcherRender extends GeoEntityRenderer<GrombleSnatcher> {
    public GrombleSnatcherRender(EntityRendererProvider.Context context) {
        super(context, new GrombleSnatcherModel());
        this.shadowRadius = 1.8F;
    }

    @Override
    public RenderType getRenderType(GrombleSnatcher animatable, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityCutoutNoCull(textureLocation);
    }
}
