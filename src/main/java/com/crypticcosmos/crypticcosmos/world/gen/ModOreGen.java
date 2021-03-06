package com.crypticcosmos.crypticcosmos.world.gen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrypticCosmos.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {
    @SubscribeEvent
    public static void generateOres(BiomeLoadingEvent event) {
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                new OreFeatureConfig(
                        OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                        BlockRegistries.HUMMING_STONE.get().getDefaultState(),
                        7 // vein size
                )).withPlacement(Placement.RANGE.configure(
                new TopSolidRangeConfig(8, 2, 22))
        ));
    }
}