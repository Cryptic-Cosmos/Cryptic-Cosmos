package com.hauntedchest.lovecraftplus.world.gen;

import com.hauntedchest.lovecraftplus.registries.FeatureHandler;
import com.hauntedchest.lovecraftplus.registries.MoonBiomeHandler;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
public class StructureGen {
    public static void generateStructures() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome == MoonBiomeHandler.MOON_PLAINS.get()) {
                biome.addStructure(FeatureHandler.MOON_PILLAR.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }

            if (biome == MoonBiomeHandler.MOON_MOUNTAINS.get()) {
                biome.addStructure(FeatureHandler.MOON_PILLAR.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }

            if (biome == MoonBiomeHandler.MOON_FOREST.get()) {
                biome.addStructure(FeatureHandler.MOON_PILLAR.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }

            biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
                    FeatureHandler.MOON_PILLAR.get()
                            .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                            .withPlacement(Placement.NOPE
                                    .configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        }
    }
}
