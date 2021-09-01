package com.crypticcosmos.crypticcosmos.world.feature;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import com.crypticcosmos.crypticcosmos.register.OsminstemRegistries;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.NoiseCountFactorDecoratorConfiguration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Objects;

import static com.crypticcosmos.crypticcosmos.register.GrombleRegistries.*;
import static com.crypticcosmos.crypticcosmos.register.MondroveRegistries.*;
import static com.crypticcosmos.crypticcosmos.register.OsminstemRegistries.OSMINSTEM_CAP;
import static com.crypticcosmos.crypticcosmos.register.OsminstemRegistries.OSMINSTEM_LOG;
import static com.crypticcosmos.crypticcosmos.world.feature.FeatureRegistries.GROMBLE_STALK_FEATURE;
import static net.minecraft.data.worldgen.Features.Decorators.*;
import static net.minecraft.data.worldgen.Features.weightedBlockStateBuilder;

public class ConfiguredFeatureRegistries {
    public static ConfiguredFeature<TreeConfiguration, ?> MONDROVE_TREE;

    public static ConfiguredFeature<TreeConfiguration, ?> OSMINSTEM_TREE;

    public static ConfiguredFeature<TreeConfiguration, ?> GROMBLE_TREE;

    public static ConfiguredFeature<?, ?> MONDROVE_FUNGUS;

    public static ConfiguredFeature<?, ?> STINKY_OSMIN;

    public static ConfiguredFeature<?, ?> GROMBLE_STALK;

    public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
        final String biomeName = Objects.requireNonNull(event.getName()).getPath();
        final BiomeGenerationSettingsBuilder biome = event.getGeneration();

        switch (biomeName) {
            case "kafisnian_forest" -> {
                biome.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.MONDROVE_FUNGUS
                                .decorated(ADD_32)
                                .decorated(HEIGHTMAP_SQUARE)
                                .count(2)
                );
                biome.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.STINKY_OSMIN
                                .decorated(ADD_32)
                                .decorated(HEIGHTMAP_SQUARE)
                                .count(2)
                );
                biome.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.MONDROVE_TREE
                                .decorated(HEIGHTMAP_SQUARE)
                                .decorated(FeatureDecorator.COUNT_EXTRA
                                        .configured(new FrequencyWithExtraChanceDecoratorConfiguration(7, 0.1F, 1)))
                );
                biome.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.OSMINSTEM_TREE
                                .decorated(HEIGHTMAP_SQUARE)
                                .decorated(FeatureDecorator.COUNT_EXTRA
                                        .configured(new FrequencyWithExtraChanceDecoratorConfiguration(14, 0.1F, 3)))
                );
            }
            case "gromble_grove" -> {
                biome.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.GROMBLE_TREE
                                .decorated(HEIGHTMAP_SQUARE)
                                .decorated(FeatureDecorator.COUNT_EXTRA
                                        .configured(new FrequencyWithExtraChanceDecoratorConfiguration(10, 2f, 13)))
                );
                biome.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.GROMBLE_STALK
                                .decorated(ADD_32)
                                .decorated(HEIGHTMAP_SQUARE)
                                .count(2)
                );
            }
        }
    }

    public static void registerFeatures() {
        GROMBLE_STALK = GROMBLE_STALK_FEATURE.get()
                .configured(new ProbabilityFeatureConfiguration(0.1f))
                .decorated(HEIGHTMAP_WORLD_SURFACE)
                .squared()
                .decorated(FeatureDecorator.COUNT_NOISE_BIASED
                        .configured(new NoiseCountFactorDecoratorConfiguration(12, 15, 0.3))
                );
        registerFeature("gromble_stalk", GROMBLE_STALK);

        STINKY_OSMIN = Feature.FLOWER.configured(new RandomPatchConfiguration.GrassConfigurationBuilder(
                new WeightedStateProvider(weightedBlockStateBuilder().add(OsminstemRegistries.STINKY_OSMIN.getDefaultState(), 2)),
                new SimpleBlockPlacer())
                .tries(64)
                .build());
        registerFeature("stinky_osmin", STINKY_OSMIN);

        MONDROVE_FUNGUS = Feature.FLOWER.configured(new RandomPatchConfiguration.GrassConfigurationBuilder(
                new WeightedStateProvider(weightedBlockStateBuilder().add(BlockRegistries.MONDROVE_FUNGUS.getDefaultState(), 2)),
                new SimpleBlockPlacer())
                .tries(64)
                .build());
        registerFeature("mondrove_fungus", MONDROVE_FUNGUS);

        GROMBLE_TREE = Feature.TREE.configured(
                new TreeConfiguration.TreeConfigurationBuilder(
                        new SimpleStateProvider(GROMBLE_LOG.getDefaultState()),
                        new DarkOakTrunkPlacer(6, 7, 9),
                        new SimpleStateProvider(GROMBLE_LEAVES.getDefaultState()),
                        new SimpleStateProvider(GROMBLE_SAPLING.getDefaultState()),
                        new BlobFoliagePlacer(UniformInt.of(4, 4),
                                UniformInt.of(4, 4), 3),
                        new TwoLayersFeatureSize(6, 3, 5)).ignoreVines().build()
        );
        registerFeature("gromble_tree", GROMBLE_TREE);

        MONDROVE_TREE = Feature.TREE.configured(
                new TreeConfiguration.TreeConfigurationBuilder(
                        new SimpleStateProvider(MONDROVE_LOG.getDefaultState()),
                        new StraightTrunkPlacer(4, 2, 0),
                        new SimpleStateProvider(MONDROVE_LEAVES.getDefaultState()),
                        new SimpleStateProvider(MONDROVE_SAPLING.getDefaultState()),
                        new BlobFoliagePlacer(UniformInt.of(2, 2),
                                UniformInt.of(0, 0), 3),
                        new TwoLayersFeatureSize(1, 0, 1))
                        .ignoreVines()
                        .build()
        );
        registerFeature("mondrove_tree", MONDROVE_TREE);

        OSMINSTEM_TREE = Feature.TREE.configured(
                new TreeConfiguration.TreeConfigurationBuilder(
                        new SimpleStateProvider(OSMINSTEM_LOG.getDefaultState()),
                        new ForkingTrunkPlacer(3, 8, 5),
                        new SimpleStateProvider(OSMINSTEM_CAP.getDefaultState()),
                        new SimpleStateProvider(OsminstemRegistries.STINKY_OSMIN.getDefaultState()),
                        new AcaciaFoliagePlacer(UniformInt.of(2, 2),
                                UniformInt.of(1, 1)),
                        new TwoLayersFeatureSize(1, 3, 5))
                        .ignoreVines()
                        .build()
        );
        registerFeature("osminstem_tree", OSMINSTEM_TREE);
    }

    public static <T extends ConfiguredFeature<? extends FeatureConfiguration, ? extends Feature<? extends FeatureConfiguration>>>
    void registerFeature(String path, T feature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
                CrypticCosmos.id(path),
                feature);
    }
}