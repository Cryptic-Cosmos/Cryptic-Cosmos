package com.hauntedchest.LovecraftPlus.client;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.client.entity.model.render.MoonBeastRender;
import com.hauntedchest.LovecraftPlus.registries.BlockHandler;
import com.hauntedchest.LovecraftPlus.registries.EntityTypeHandler;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = LovecraftPlusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockHandler.THORN_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandler.THORN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandler.MOON_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandler.THORN_DOOR.get(), RenderType.getCutout());
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeHandler.MOON_BEAST.get(), MoonBeastRender::new);

    }
}
