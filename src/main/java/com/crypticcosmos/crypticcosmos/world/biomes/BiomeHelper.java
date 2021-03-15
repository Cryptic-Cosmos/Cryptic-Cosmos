package com.crypticcosmos.crypticcosmos.world.biomes;

import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeAmbience;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class BiomeHelper {
    @SuppressWarnings("unused")
    public static final int DEFAULT_WATER_COLOR = 0x3f76e4;
    @SuppressWarnings("unused")
    public static final int DEFAULT_WATER_FOG_COLOR = 0x50533;
    public static final int DEFAULT_GRASS_COLOR = 0x91bd59;
    public static final int DEFAULT_FOLIAGE_COLOR = 0x77ab2f;
    public static final int DEFAULT_SKY_FOG_COLOR = 12638463;

    /**
     * Base biome function Sky color is not generated
     */
    public static Biome biome(
            Biome.RainType precipitation,
            Biome.Category category,
            float depth,
            float scale,
            float temperature,
            float downfall,
            BiomeAmbience.Builder effects,
            BiomeGenerationSettings.Builder genSettings,
            MobSpawnInfo spawnSettings
    ) {
        return new Biome.Builder()
                .precipitation(precipitation)
                .biomeCategory(category)
                .depth(depth)
                .scale(scale)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(effects.build())
                .generationSettings(genSettings.build())
                .mobSpawnSettings(spawnSettings)
                .build();
    }

    /**
     * Shortcut function and enforces surface builder
     */
    public static <C extends ISurfaceBuilderConfig> BiomeGenerationSettings.Builder genSettings(SurfaceBuilder<C> surfaceBuilder, C config) {
        return new BiomeGenerationSettings.Builder().surfaceBuilder(surfaceBuilder.configured(config));
    }

    /**
     * Shortcut function
     */
    public static MobSpawnInfo.Builder spawnSettings() {
        return new MobSpawnInfo.Builder();
    }

    /**
     * Shortcut function
     */
    public static void addSpawn(
            MobSpawnInfo.Builder spawnSettings,
            EntityClassification classification,
            EntityType<?> entityType,
            int weight,
            int min,
            int max) {
        spawnSettings.addSpawn(classification,
                new MobSpawnInfo.Spawners(entityType, weight, min, max));
    }

    /**
     * Biome ambience add default parameters and enforced the required ones. Should prevent slip ups on my part :)
     */
    public static BiomeAmbience.Builder effects(int waterColor,
                                                int waterFogColor,
                                                int grassColor,
                                                int foliageColor,
                                                float temperature,
                                                int skyFogColor,
                                                SoundEvent music) {
        return new BiomeAmbience.Builder()
                .waterColor(waterColor)
                .waterFogColor(waterFogColor)
                .grassColorOverride(grassColor)
                .foliageColorOverride(foliageColor)
                .skyColor(getSkyForTemp(temperature))
                .fogColor(skyFogColor)
                .backgroundMusic(BackgroundMusicTracks.createGameMusic(music));
    }

    public static int getSkyForTemp(float temperature) {
        final float a = MathHelper.clamp(temperature / 3.0f, -1.0f, 1.0f);
        return MathHelper.hsvToRgb(0.62222224f - a * 0.05f, 0.5f + a * 0.1f, 1.0f);
    }
}
