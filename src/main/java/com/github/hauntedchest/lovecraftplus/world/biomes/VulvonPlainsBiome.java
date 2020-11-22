package com.github.hauntedchest.lovecraftplus.world.biomes;

import com.github.hauntedchest.lovecraftplus.registries.BlockRegistries;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MultipleWithChanceRandomFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

@SuppressWarnings("NullableProblems")
public class VulvonPlainsBiome extends Biome {
    private static final BlockState VINESWORD = BlockRegistries.CORRUPTED_VINESWORD.get().getDefaultState();
    public static final BlockClusterFeatureConfig VINESWORD_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(VINESWORD), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();


    public VulvonPlainsBiome(Biome.Builder builder) {
        super(builder);

        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addTaigaRocks(this);
        DefaultBiomeFeatures.addDeadBushes(this);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_RANDOM_SELECTOR.withConfiguration(new MultipleWithChanceRandomFeatureConfig(ImmutableList.of(Feature.RANDOM_PATCH.withConfiguration(this.VINESWORD_CONFIG), Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.ROSE_BUSH_CONFIG), Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.PEONY_CONFIG), Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.LILY_OF_THE_VALLEY_CONFIG)), 2)).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(5))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.FOREST_FLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(100))));

    }

    @Override
    public void addSpawn(EntityClassification type, SpawnListEntry spawnListEntry) {
        super.addSpawn(type, spawnListEntry);
    }
}
