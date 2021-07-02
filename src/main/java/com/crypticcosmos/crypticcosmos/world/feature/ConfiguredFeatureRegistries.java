package com.crypticcosmos.crypticcosmos.world.feature;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import com.crypticcosmos.crypticcosmos.register.OsminstemRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidWithNoiseConfig;
import net.minecraft.world.gen.trunkplacer.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.ForkyTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Objects;

import static com.crypticcosmos.crypticcosmos.register.GrombleRegistries.GROMBLE_LEAVES;
import static com.crypticcosmos.crypticcosmos.register.GrombleRegistries.GROMBLE_LOG;
import static com.crypticcosmos.crypticcosmos.register.MondroveRegistries.MONDROVE_LEAVES;
import static com.crypticcosmos.crypticcosmos.register.MondroveRegistries.MONDROVE_LOG;
import static com.crypticcosmos.crypticcosmos.register.OsminstemRegistries.OSMINSTEM_CAP;
import static com.crypticcosmos.crypticcosmos.register.OsminstemRegistries.OSMINSTEM_LOG;
import static com.crypticcosmos.crypticcosmos.world.feature.FeatureRegistries.GROMBLE_STALK_FEATURE;

public class ConfiguredFeatureRegistries {
    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> MONDROVE_TREE;

    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> OSMINSTEM_TREE;

    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> GROMBLE_TREE;

    public static ConfiguredFeature<?, ?> MONDROVE_FUNGUS;

    public static ConfiguredFeature<?, ?> STINKY_OSMIN;

    public static ConfiguredFeature<?, ?> GROMBLE_STALK;

    public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
        final String biomeName = Objects.requireNonNull(event.getName()).getPath();
        final BiomeGenerationSettingsBuilder biome = event.getGeneration();

        switch (biomeName) {
            case "kafisnian_forest":
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.MONDROVE_FUNGUS
                                .decorated(Features.Placements.ADD_32)
                                .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                                .count(2)
                );

                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.STINKY_OSMIN
                                .decorated(Features.Placements.ADD_32)
                                .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                                .count(2)
                );

                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.MONDROVE_TREE
                                .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                                .decorated(Placement.COUNT_EXTRA
                                        .configured(new AtSurfaceWithExtraConfig(7, 0.1F, 1)))
                );

                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.OSMINSTEM_TREE
                                .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                                .decorated(Placement.COUNT_EXTRA
                                        .configured(new AtSurfaceWithExtraConfig(14, 0.1F, 3)))
                );
                break;

            case "gromble_grove":
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.GROMBLE_TREE
                                .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                                .decorated(Placement.COUNT_EXTRA
                                        .configured(new AtSurfaceWithExtraConfig(10, 2f, 13)))
                );

                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        ConfiguredFeatureRegistries.GROMBLE_STALK
                                .decorated(Features.Placements.ADD_32)
                                .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                                .count(2)
                );
                break;
        }
    }

    public static void registerFeatures() {
        GROMBLE_STALK = GROMBLE_STALK_FEATURE.get()
                .configured(new ProbabilityConfig(0.1f))
                .decorated(Features.Placements.HEIGHTMAP_WORLD_SURFACE)
                .squared()
                .decorated(Placement.COUNT_NOISE_BIASED
                        .configured(new TopSolidWithNoiseConfig(12, 15, 0.3))
                );
        registerFeature("gromble_stalk", GROMBLE_STALK);

        STINKY_OSMIN = Feature.FLOWER.configured(
                new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider()
                        .add(OsminstemRegistries.STINKY_OSMIN.get().defaultBlockState(), 2),
                        new SimpleBlockPlacer())
                        .tries(64)
                        .build()
        );
        registerFeature("stinky_osmin", STINKY_OSMIN);

        MONDROVE_FUNGUS = Feature.FLOWER.configured(
                new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider()
                        .add(BlockRegistries.MONDROVE_FUNGUS.get().defaultBlockState(), 2),
                        new SimpleBlockPlacer())
                        .tries(64)
                        .build()
        );
        registerFeature("mondrove_fungus", MONDROVE_FUNGUS);

        GROMBLE_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(GROMBLE_LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(GROMBLE_LEAVES.get().defaultBlockState()),
                        new BlobFoliagePlacer(FeatureSpread.fixed(4),
                                FeatureSpread.fixed(4), 3),
                        new DarkOakTrunkPlacer(6, 7, 9),
                        new TwoLayerFeature(6, 3, 5)).ignoreVines().build()
        );
        registerFeature("gromble_tree", GROMBLE_TREE);

        MONDROVE_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(MONDROVE_LOG.getDefaultState()),
                        new SimpleBlockStateProvider(MONDROVE_LEAVES.getDefaultState()),
                        new BlobFoliagePlacer(FeatureSpread.fixed(2),
                                FeatureSpread.fixed(0), 3),
                        new StraightTrunkPlacer(4, 2, 0),
                        new TwoLayerFeature(1, 0, 1))
                        .ignoreVines()
                        .build()
        );
        registerFeature("mondrove_tree", MONDROVE_TREE);

        OSMINSTEM_TREE = Feature.TREE.configured(
                new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(OSMINSTEM_LOG.get().defaultBlockState()),
                        new SimpleBlockStateProvider(OSMINSTEM_CAP.get().defaultBlockState()),
                        new AcaciaFoliagePlacer(FeatureSpread.fixed(2),
                                FeatureSpread.fixed(1)),
                        new ForkyTrunkPlacer(3, 8, 5),
                        new TwoLayerFeature(1, 3, 5))
                        .ignoreVines()
                        .build()
        );
        registerFeature("osminstem_tree", OSMINSTEM_TREE);
    }

    public static <T extends ConfiguredFeature<? extends IFeatureConfig, ? extends Feature<? extends IFeatureConfig>>>
    void registerFeature(String path, T feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE,
                CrypticCosmos.id(path),
                feature);
    }
}