package com.hauntedchest.LovecraftPlus.client;

import com.hauntedchest.LovecraftPlus.Inits.BlockHandeler;
import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = LovecraftPlusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockHandeler.THORN_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandeler.THORN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandeler.MOON_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandeler.THORN_DOOR.get(), RenderType.getCutout());

    }
}
