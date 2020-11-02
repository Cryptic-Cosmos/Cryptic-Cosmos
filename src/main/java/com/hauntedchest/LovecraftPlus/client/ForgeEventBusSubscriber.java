package com.hauntedchest.LovecraftPlus.client;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.registries.DimensionHandler;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LovecraftPlusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if (DimensionType.byName(DimensionHandler.MOON_DIM_TYPE) == null) {
            DimensionManager.registerDimension(DimensionHandler.MOON_DIM_TYPE, DimensionHandler.MOON_DIM.get(), null,
                    true);
        }

        LovecraftPlusMod.LOGGER.info("Dimensions Registered!");
    }
}
