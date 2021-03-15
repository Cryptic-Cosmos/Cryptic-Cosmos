package com.crypticcosmos.crypticcosmos.world.biomes;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.EntityTypeRegistries;
import com.crypticcosmos.crypticcosmos.registries.FeatureRegistries;
import com.crypticcosmos.crypticcosmos.registries.SoundEventRegistries;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.world.biomes.BiomeHelper.*;

public class BiomeMaker {
    public static final SurfaceBuilderConfig LUNARA_SURFACE_BUILDER_CONFIG = new SurfaceBuilderConfig(
            BlockRegistries.OVERGROWN_LUNON.get().defaultBlockState(),
            BlockRegistries.LUNON.get().defaultBlockState(),
            BlockRegistries.LUNON_DUST.get().defaultBlockState()
    );

    public static final SurfaceBuilderConfig ABYSS_SURFACE_BUILDER_CONFIG = new SurfaceBuilderConfig(
            BlockRegistries.UMBRAL_DUNE.get().defaultBlockState(),
            BlockRegistries.UMBRAL_DUNE.get().defaultBlockState(),
            BlockRegistries.UMBRAL_DUNE.get().defaultBlockState()
    );

    public static Biome acerbicIsles() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, LUNARA_SURFACE_BUILDER_CONFIG);

        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityTypeRegistries.MOON_BEAST.get(), 8, 1, 2);

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityType.ENDERMAN, 4, 1, 4);

        final BiomeAmbience.Builder effects = effects(0xfffff5,
                0xfffff5,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                0,
                DEFAULT_SKY_FOG_COLOR,
                SoundEventRegistries.MUSIC_ACERBIC_ISLES.get()
        );

        return biome(
                RainType.RAIN,
                Category.EXTREME_HILLS,
                0.125f,
                1,
                0f,
                0.0001f,
                effects,
                genSettings,
                spawnSettings.build()
        );
    }

    public static Biome mondroveGroves() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, LUNARA_SURFACE_BUILDER_CONFIG);

        // Add mondrove fungus generation.
        genSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                FeatureRegistries.MONDROVE_FUNGUS
                        .decorated(Features.Placements.ADD_32)
                        .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                        .count(2));

        // Add mondrove tree generation.
        genSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                FeatureRegistries.MONDROVE_TREE
                        .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                        .decorated(Placement.COUNT_EXTRA
                                .configured(new AtSurfaceWithExtraConfig(7, 0.1F, 1))));

        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityType.ENDERMAN, 10, 1, 4);

        addSpawn(spawnSettings, EntityClassification.WATER_CREATURE,
                EntityTypeRegistries.TRAPLOOM.get(), 8, 1, 2);

        final BiomeAmbience.Builder effects = effects(0xfffff5,
                0xfffff5,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                0,
                DEFAULT_SKY_FOG_COLOR,
                SoundEventRegistries.MUSIC_MONDROVE_GROVES.get()
        );

        return biome(
                RainType.RAIN,
                Category.FOREST,
                0.125f,
                0.07f,
                0f,
                0.0001f,
                effects,
                genSettings,
                spawnSettings.build()
        );
    }

    @Nonnull
    public static Biome lunaraPlains() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, LUNARA_SURFACE_BUILDER_CONFIG);

        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityTypeRegistries.MOON_BEAST.get(), 8, 1, 2);

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityType.ENDERMAN, 4, 1, 4);

        final BiomeAmbience.Builder effects = effects(0xfffff5,
                0xfffff5,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                0,
                DEFAULT_SKY_FOG_COLOR,
                SoundEventRegistries.MUSIC_LUNARA.get());

        return biome(
                RainType.RAIN,
                Category.PLAINS,
                0.125f,
                0.1f,
                0f,
                0.0001f,
                effects,
                genSettings,
                spawnSettings.build()
        );
    }

    public static Biome umbralDunes() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, ABYSS_SURFACE_BUILDER_CONFIG);

        final BiomeAmbience.Builder effects = effects(0x412,
                0x412,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                3f,
                DEFAULT_SKY_FOG_COLOR,
                SoundEventRegistries.MUSIC_ABYSS.get());

        return biome(
                RainType.RAIN,
                Category.PLAINS,
                -0.5f,
                1f,
                3f,
                0,
                effects,
                genSettings,
                MobSpawnInfo.EMPTY
        );
    }
}