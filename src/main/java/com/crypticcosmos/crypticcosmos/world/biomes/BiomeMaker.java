package com.crypticcosmos.crypticcosmos.world.biomes;

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

import static com.crypticcosmos.crypticcosmos.registries.BlockRegistries.UMBRAL_DUNE;
import static com.crypticcosmos.crypticcosmos.registries.LunonRegistries.*;
import static com.crypticcosmos.crypticcosmos.world.biomes.BiomeHelper.*;

@SuppressWarnings("SameParameterValue")
public class BiomeMaker {
    public static Biome acerbicIsles() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
                LUNON.get().defaultBlockState(),
                LUNON.get().defaultBlockState(),
                LUNON_DUST.get().defaultBlockState()
        ));

        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.MONSTER,
                EntityTypeRegistries.MAKROSSA_RAMBLER.get(), 8, 1, 2);

        addSpawn(spawnSettings, EntityClassification.MONSTER,
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

    public static Biome kafisnianForest() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
                FUNGAL_LUNON.get().defaultBlockState(),
                LUNON.get().defaultBlockState(),
                LUNON_DUST.get().defaultBlockState()
        ));

        // Add mondrove fungus generation.
        genSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                FeatureRegistries.MONDROVE_FUNGUS
                        .decorated(Features.Placements.ADD_32)
                        .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                        .count(2));

        genSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                FeatureRegistries.STINKY_OSMIN
                        .decorated(Features.Placements.ADD_32)
                        .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                        .count(2));

        // Add mondrove tree generation.
        genSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                FeatureRegistries.MONDROVE_TREE
                        .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                        .decorated(Placement.COUNT_EXTRA
                                .configured(new AtSurfaceWithExtraConfig(7, 0.1F, 1))));

        genSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                FeatureRegistries.OSMINSTEM_TREE
                        .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                        .decorated(Placement.COUNT_EXTRA
                                .configured(new AtSurfaceWithExtraConfig(14, 0.1F, 3))));


        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityTypeRegistries.GROMBLE_FROG.get(), 8, 2, 5);

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
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
                OVERGROWN_LUNON.get().defaultBlockState(),
                LUNON.get().defaultBlockState(),
                LUNON_DUST.get().defaultBlockState()
        ));

        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityTypeRegistries.MAKROSSA_RAMBLER.get(), 8, 1, 2);

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

    public static Biome grombleGrove() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.NETHER_FOREST, new SurfaceBuilderConfig(
                GLUM_LUNON.get().defaultBlockState(),
                LUNON.get().defaultBlockState(),
                LUNON_DUST.get().defaultBlockState()
        ));

        genSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                FeatureRegistries.GIANT_GROMBLE_BERRY_PATCH
                        .decorated(Features.Placements.ADD_32)
                        .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                        .count(5));

        genSettings.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                FeatureRegistries.GROMBLE_TREE
                        .decorated(Features.Placements.HEIGHTMAP_SQUARE)
                        .decorated(Placement.COUNT_EXTRA
                                .configured(new AtSurfaceWithExtraConfig(10, 2F, 13))));


        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityTypeRegistries.GROMBLE_FROG.get(), 8, 2, 5);

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
                0.5f,
                0.07f,
                0f,
                0.0001f,
                effects,
                genSettings,
                spawnSettings.build()
        );
    }

    public static Biome umbralDunes() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(
                UMBRAL_DUNE.get().defaultBlockState(),
                UMBRAL_DUNE.get().defaultBlockState(),
                UMBRAL_DUNE.get().defaultBlockState()
        ));

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