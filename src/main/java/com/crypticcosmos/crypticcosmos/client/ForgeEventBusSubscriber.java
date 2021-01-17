package com.crypticcosmos.crypticcosmos.client;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.DimensionRegistries;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrypticCosmos.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {
    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if (DimensionType.byName(DimensionRegistries.LUNARA_DIM_TYPE) == null) {
            DimensionManager.registerDimension(
                    DimensionRegistries.LUNARA_DIM_TYPE,
                    DimensionRegistries.LUNARA_DIM.get(),
                    null,
                    true
            );

            CrypticCosmos.LOGGER.debug("Dimensions registered to DimensionManager!");
        }
        if (DimensionType.byName(DimensionRegistries.ABYSS_DIM_TYPE) == null) {
            DimensionManager.registerDimension(
                    DimensionRegistries.ABYSS_DIM_TYPE,
                    DimensionRegistries.ABYSS_DIM.get(),
                    null,
                    true
            );

            CrypticCosmos.LOGGER.debug("Dimensions registered to DimensionManager!");
        }
        if (DimensionType.byName(DimensionRegistries.ISLAND_DIM_TYPE) == null) {
            DimensionManager.registerDimension(
                    DimensionRegistries.ISLAND_DIM_TYPE,
                    DimensionRegistries.ISLAND_DIM.get(),
                    null,
                    true
            );

            CrypticCosmos.LOGGER.debug("Dimensions registered to DimensionManager!");
        }
    }
}
