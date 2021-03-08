package com.crypticcosmos.crypticcosmos.world.biomes;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.EntityTypeRegistries;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import static net.minecraft.world.biome.Biome.*;

@SuppressWarnings("SameParameterValue")
public class BiomeMaker {
    public static final SurfaceBuilderConfig LUNARA_SURFACE_BUILDER_CONFIG = new SurfaceBuilderConfig(
            BlockRegistries.OVERGROWN_LUNON.get().getDefaultState(),
            BlockRegistries.LUNON.get().getDefaultState(),
            BlockRegistries.LUNON_DUST.get().getDefaultState()
    );

    public static final SurfaceBuilderConfig ABYSS_SURFACE_BUILDER_CONFIG = new SurfaceBuilderConfig(
            BlockRegistries.UMBRAL_DUNE.get().getDefaultState(),
            BlockRegistries.UMBRAL_DUNE.get().getDefaultState(),
            BlockRegistries.UMBRAL_DUNE.get().getDefaultState()
    );

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MONDROVE_TREE = Feature.TREE.withConfiguration(
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BlockRegistries.MONDROVE_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BlockRegistries.MONDROVE_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2),
                            FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))
                    .setIgnoreVines()
                    .build()
    );

    @SuppressWarnings("unused")
    public static final int DEFAULT_WATER_COLOR = 0x3f76e4;
    @SuppressWarnings("unused")
    public static final int DEFAULT_WATER_FOG_COLOR = 0x50533;
    public static final int DEFAULT_GRASS_COLOR = 0x91bd59;
    public static final int DEFAULT_FOLIAGE_COLOR = 0x77ab2f;
    public static final int DEFAULT_SKY_FOG_COLOR = 12638463;

    public static Biome makeLunaraMountains() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, LUNARA_SURFACE_BUILDER_CONFIG);

        WorldGenRegistries.init();

        DefaultBiomeFeatures.withCavesAndCanyons(genSettings);

        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityTypeRegistries.MOON_BEAST.get(), 8, 1, 2);

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityType.ENDERMAN, 4, 1, 4);

        return biome(
                RainType.RAIN,
                Category.EXTREME_HILLS,
                0.125f,
                1,
                0f,
                0.0001f,
                effects(0xfffff5,
                        0xfffff5,
                        DEFAULT_GRASS_COLOR,
                        DEFAULT_FOLIAGE_COLOR,
                        0,
                        DEFAULT_SKY_FOG_COLOR),
                genSettings,
                spawnSettings.copy()
        );
    }

    public static Biome makeLunaraForest() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, LUNARA_SURFACE_BUILDER_CONFIG);

        WorldGenRegistries.init();

        DefaultBiomeFeatures.withCavesAndCanyons(genSettings);

        final BlockClusterFeatureConfig MONDROVE_FUNGUS_CONFIG =
                new BlockClusterFeatureConfig.Builder(new WeightedBlockStateProvider()
                        .addWeightedBlockstate(BlockRegistries.MONDROVE_FUNGUS.get().getDefaultState(), 2),
                        new SimpleBlockPlacer()
                ).tries(64).build();

        // Add mondrove fungus generation.
        genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.FLOWER.withConfiguration(MONDROVE_FUNGUS_CONFIG)
                        .withPlacement(Features.Placements.VEGETATION_PLACEMENT)
                        .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT)
                        .func_242731_b(2));

        // Add mondrove tree generation.
        genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, MONDROVE_TREE);

        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityType.ENDERMAN, 10, 1, 4);

        return biome(
                RainType.RAIN,
                Category.FOREST,
                0.125f,
                1,
                0f,
                0.0001f,
                effects(0xfffff5,
                        0xfffff5,
                        DEFAULT_GRASS_COLOR,
                        DEFAULT_FOLIAGE_COLOR,
                        0,
                        DEFAULT_SKY_FOG_COLOR),
                genSettings,
                spawnSettings.copy()
        );
    }

    public static Biome makeLunaraPlains() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, LUNARA_SURFACE_BUILDER_CONFIG);

        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityTypeRegistries.MOON_BEAST.get(), 8, 1, 2);

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityType.ENDERMAN, 4, 1, 4);

        return biome(
                RainType.RAIN,
                Category.PLAINS,
                0.125f,
                1,
                0f,
                0.0001f,
                effects(0xfffff5,
                        0xfffff5,
                        DEFAULT_GRASS_COLOR,
                        DEFAULT_FOLIAGE_COLOR,
                        0,
                        DEFAULT_SKY_FOG_COLOR),
                genSettings,
                spawnSettings.copy()
        );
    }

    public static Biome makeUmbralDunes() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, ABYSS_SURFACE_BUILDER_CONFIG);

        return biome(
                RainType.RAIN,
                Category.PLAINS,
                -0.5f,
                1f,
                3f,
                0,
                effects(0x412,
                        0x412,
                        DEFAULT_GRASS_COLOR,
                        DEFAULT_FOLIAGE_COLOR,
                        3f,
                        DEFAULT_SKY_FOG_COLOR),
                genSettings,
                MobSpawnInfo.EMPTY
        );
    }

    /**
     * Base biome function Sky color is not generated
     */
    private static Biome biome(
            RainType precipitation,
            Category category,
            float depth,
            float scale,
            float temperature,
            float downfall,
            BiomeAmbience.Builder effects,
            BiomeGenerationSettings.Builder genSettings,
            MobSpawnInfo spawnSettings
    ) {
        return new Builder()
                .precipitation(precipitation)
                .category(category)
                .depth(depth)
                .scale(scale)
                .temperature(temperature)
                .downfall(downfall)
                .setEffects(effects.build())
                .withGenerationSettings(genSettings.build())
                .withMobSpawnSettings(spawnSettings)
                .build();
    }

    /**
     * Shortcut function and enforces surface builder
     */
    private static <C extends ISurfaceBuilderConfig> BiomeGenerationSettings.Builder genSettings(SurfaceBuilder<C> surfaceBuilder, C config) {
        return new BiomeGenerationSettings.Builder()
                .withSurfaceBuilder(surfaceBuilder.func_242929_a(config));
    }

    /**
     * Shortcut function
     */
    private static MobSpawnInfo.Builder spawnSettings() {
        return new MobSpawnInfo.Builder();
    }

    /**
     * Shortcut function
     */
    private static void addSpawn(
            MobSpawnInfo.Builder spawnSettings,
            EntityClassification classification,
            EntityType<?> entityType,
            int weight,
            int min,
            int max) {
        spawnSettings.withSpawner(classification,
                new MobSpawnInfo.Spawners(entityType, weight, min, max));
    }

    /**
     * Biome ambience with default parameters and enforced the required ones. Should prevent slip ups on my part :)
     */
    private static BiomeAmbience.Builder effects(int waterColor,
                                                 int waterFogColor,
                                                 int grassColor,
                                                 int foliageColor,
                                                 float temperature,
                                                 int skyFogColor) {
        return new BiomeAmbience.Builder()
                .setWaterColor(waterColor)
                .setWaterFogColor(waterFogColor)
                .withGrassColor(grassColor)
                .withFoliageColor(foliageColor)
                .withSkyColor(getSkyForTemp(temperature))
                .setFogColor(skyFogColor);
    }

    private static int getSkyForTemp(float temperature) {
        final float a = MathHelper.clamp(temperature / 3.0f, -1.0f, 1.0f);
        return MathHelper.hsvToRGB(0.62222224f - a * 0.05f, 0.5f + a * 0.1f, 1.0f);
    }
}