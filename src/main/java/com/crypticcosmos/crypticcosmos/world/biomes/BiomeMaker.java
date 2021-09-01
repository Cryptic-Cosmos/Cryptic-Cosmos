package com.crypticcosmos.crypticcosmos.world.biomes;

import com.crypticcosmos.crypticcosmos.register.CerantRegistries;
import com.crypticcosmos.crypticcosmos.register.EntityTypeRegistries;
import com.crypticcosmos.crypticcosmos.register.SoundEventRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.Biome.Precipitation;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.BlockRegistries.UMBRAL_DUNE;
import static com.crypticcosmos.crypticcosmos.register.LunonRegistries.*;
import static com.crypticcosmos.crypticcosmos.world.biomes.BiomeHelper.*;

@SuppressWarnings("SameParameterValue")
public class BiomeMaker {
    public static Biome acerbicIsles() {
        final var genSettings = genSettings(SurfaceBuilder.DEFAULT, new SurfaceBuilderBaseConfiguration(
                LUNON.get().defaultBlockState(),
                LUNON.get().defaultBlockState(),
                LUNON_DUST.get().defaultBlockState()
        ));

        final var spawnSettings = spawnSettings();

        addSpawn(spawnSettings, MobCategory.MONSTER,
                EntityTypeRegistries.MAKROSSA_RAMBLER.get(), 8, 1, 2);

        addSpawn(spawnSettings, MobCategory.MONSTER,
                EntityType.ENDERMAN, 4, 1, 4);

        final var effects = effects(0xfffff5,
                0xfffff5,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                0,
                DEFAULT_SKY_FOG_COLOR,
                SoundEventRegistries.MUSIC_ACERBIC_ISLES.get()
        );

        return biome(
                Precipitation.RAIN,
                BiomeCategory.EXTREME_HILLS,
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
        final var genSettings = genSettings(SurfaceBuilder.DEFAULT, new SurfaceBuilderBaseConfiguration(
                FUNGAL_LUNON.get().defaultBlockState(),
                LUNON.get().defaultBlockState(),
                LUNON_DUST.get().defaultBlockState()
        ));

        final var spawnSettings = spawnSettings();

        addSpawn(spawnSettings, MobCategory.CREATURE,
                EntityTypeRegistries.GROMBLE_FROG.get(), 8, 2, 5);

        final var effects = effects(0xfffff5,
                0xfffff5,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                0,
                DEFAULT_SKY_FOG_COLOR,
                SoundEventRegistries.MUSIC_MONDROVE_GROVES.get()
        );

        return biome(
                Precipitation.RAIN,
                BiomeCategory.FOREST,
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
        final var genSettings = genSettings(SurfaceBuilder.DEFAULT, new SurfaceBuilderBaseConfiguration(
                OVERGROWN_LUNON.get().defaultBlockState(),
                LUNON.get().defaultBlockState(),
                LUNON_DUST.get().defaultBlockState()
        ));

        final var spawnSettings = spawnSettings();

        addSpawn(spawnSettings, MobCategory.CREATURE,
                EntityTypeRegistries.MAKROSSA_RAMBLER.get(), 8, 1, 2);

        addSpawn(spawnSettings, MobCategory.CREATURE,
                EntityType.ENDERMAN, 4, 1, 4);

        final var effects = effects(0xfffff5,
                0xfffff5,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                0,
                DEFAULT_SKY_FOG_COLOR,
                SoundEventRegistries.MUSIC_LUNARA.get());

        return biome(
                Precipitation.RAIN,
                BiomeCategory.PLAINS,
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
        final var genSettings = genSettings(SurfaceBuilder.NETHER_FOREST, new SurfaceBuilderBaseConfiguration(
                CerantRegistries.PHORAL_CERANT.get().defaultBlockState(),
                CerantRegistries.CERANT.get().defaultBlockState(),
                CerantRegistries.CERANT.get().defaultBlockState()
        ));

        final var spawnSettings = spawnSettings();

        addSpawn(spawnSettings, MobCategory.AMBIENT,
                EntityTypeRegistries.GROMBLE_FROG.get(), 8, 2, 5);

        final var effects = effects(0xfffff5,
                0xfffff5,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                5,
                GROMBLE_SKY_FOG_COLOR,
                SoundEventRegistries.MUSIC_MONDROVE_GROVES.get()
        );

        return biome(
                Precipitation.RAIN,
                BiomeCategory.FOREST,
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
        final var genSettings = genSettings(SurfaceBuilder.DEFAULT, new SurfaceBuilderBaseConfiguration(
                UMBRAL_DUNE.get().defaultBlockState(),
                UMBRAL_DUNE.get().defaultBlockState(),
                UMBRAL_DUNE.get().defaultBlockState()
        ));

        final var effects = effects(0x412,
                0x412,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                3f,
                DEFAULT_SKY_FOG_COLOR,
                SoundEventRegistries.MUSIC_ABYSS.get());

        return biome(
                Precipitation.RAIN,
                BiomeCategory.PLAINS,
                -0.5f,
                1f,
                3f,
                0,
                effects,
                genSettings,
                MobSpawnSettings.EMPTY
        );
    }
}