package com.crypticcosmos.crypticcosmos.world.gen;

import com.crypticcosmos.crypticcosmos.registries.BiomeRegistries;
import com.crypticcosmos.crypticcosmos.registries.FeatureRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureGen {
    public static void generateStructures() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome == BiomeRegistries.LUNARA_PLAINS.get()) {
                biome.addStructure(FeatureRegistries.MOON_PILLAR.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }

            if (biome == BiomeRegistries.LUNARA_MOUNTAINS.get()) {
                biome.addStructure(FeatureRegistries.MOON_PILLAR.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }

            if (biome == BiomeRegistries.LUNARA_FOREST.get()) {
                biome.addStructure(FeatureRegistries.MOON_PILLAR.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }

            biome.addFeature(
                    GenerationStage.Decoration.SURFACE_STRUCTURES,
                    FeatureRegistries.MOON_PILLAR.get()
                            .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                            .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG))
            );
        }
    }
}
