package com.crypticcosmos.crypticcosmos.world.biomes;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.EntityTypeRegistries;
import com.crypticcosmos.crypticcosmos.registries.FeatureRegistries;
import com.crypticcosmos.crypticcosmos.registries.SoundEventRegistries;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import javax.annotation.Nonnull;

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

    @SuppressWarnings("unused")
    public static final int DEFAULT_WATER_COLOR = 0x3f76e4;
    @SuppressWarnings("unused")
    public static final int DEFAULT_WATER_FOG_COLOR = 0x50533;
    public static final int DEFAULT_GRASS_COLOR = 0x91bd59;
    public static final int DEFAULT_FOLIAGE_COLOR = 0x77ab2f;
    public static final int DEFAULT_SKY_FOG_COLOR = 12638463;

    public static Biome makeAcerbicIsles() {
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
                SoundEventRegistries.MUSIC_LUNARA.get(),
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
                spawnSettings.copy()
        );
    }

    public static Biome makeMondroveGroves() {
        final BiomeGenerationSettings.Builder genSettings = genSettings(SurfaceBuilder.DEFAULT, LUNARA_SURFACE_BUILDER_CONFIG);

        // Add mondrove fungus generation.
        genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureRegistries.MONDROVE_FUNGUS);

        // Add mondrove tree generation.
        genSettings.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureRegistries.MONDROVE_TREE);

        final MobSpawnInfo.Builder spawnSettings = spawnSettings();

        addSpawn(spawnSettings, EntityClassification.CREATURE,
                EntityType.ENDERMAN, 10, 1, 4);

        final BiomeAmbience.Builder effects = effects(0xfffff5,
                0xfffff5,
                DEFAULT_GRASS_COLOR,
                DEFAULT_FOLIAGE_COLOR,
                0,
                DEFAULT_SKY_FOG_COLOR,
                SoundEventRegistries.MUSIC_LUNARA.get(),
                SoundEventRegistries.MUSIC_MONDROVE_GROVES.get());

        return biome(
                RainType.RAIN,
                Category.FOREST,
                0.125f,
                1,
                0f,
                0.0001f,
                effects,
                genSettings,
                spawnSettings.copy()
        );
    }

    @Nonnull
    public static Biome makeLunaraPlains() {
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
                1,
                0f,
                0.0001f,
                effects,
                genSettings,
                spawnSettings.copy()
        );
    }

    public static Biome makeUmbralDunes() {
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
                                                 int skyFogColor,
                                                 SoundEvent ambientSound) {
        return new BiomeAmbience.Builder()
                .setWaterColor(waterColor)
                .setWaterFogColor(waterFogColor)
                .withGrassColor(grassColor)
                .withFoliageColor(foliageColor)
                .withSkyColor(getSkyForTemp(temperature))
                .setFogColor(skyFogColor)
                .setAmbientSound(ambientSound);
    }

    /**
     * Biome ambience builder.
     */
    private static BiomeAmbience.Builder effects(int waterColor,
                                                 int waterFogColor,
                                                 int grassColor,
                                                 int foliageColor,
                                                 float temperature,
                                                 int skyFogColor,
                                                 SoundEvent ambientSound,
                                                 SoundEvent music) {
        return new BiomeAmbience.Builder()
                .setWaterColor(waterColor)
                .setWaterFogColor(waterFogColor)
                .withGrassColor(grassColor)
                .withFoliageColor(foliageColor)
                .withSkyColor(getSkyForTemp(temperature))
                .setFogColor(skyFogColor)
                .setAmbientSound(ambientSound)
                .setMusic(BackgroundMusicTracks.getDefaultBackgroundMusicSelector(music));
    }

    private static int getSkyForTemp(float temperature) {
        final float a = MathHelper.clamp(temperature / 3.0f, -1.0f, 1.0f);
        return MathHelper.hsvToRGB(0.62222224f - a * 0.05f, 0.5f + a * 0.1f, 1.0f);
    }
}