package com.hauntedchest.LovecraftPlus.world.gen;

import com.hauntedchest.LovecraftPlus.Inits.FeatureInit;
import com.hauntedchest.LovecraftPlus.Inits.MoonModBiomes;
import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
@Mod.EventBusSubscriber(modid = LovecraftPlusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StructureGen {
    public static void generateStructures() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome == MoonModBiomes.MOON_PLAINS.get()) {
                biome.addStructure(FeatureInit.MOON_PILLAR.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }

            biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES,
                    FeatureInit.MOON_PILLAR.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                            .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        }
    }
}
