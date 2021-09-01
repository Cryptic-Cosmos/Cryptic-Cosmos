package com.crypticcosmos.crypticcosmos.world.biomes;

import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeBuilder;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderConfiguration;

public class BiomeHelper {
    @SuppressWarnings("unused")
    public static final int DEFAULT_WATER_COLOR = 0x3f76e4;
    @SuppressWarnings("unused")
    public static final int DEFAULT_WATER_FOG_COLOR = 0x50533;
    public static final int DEFAULT_GRASS_COLOR = 0x91bd59;
    public static final int DEFAULT_FOLIAGE_COLOR = 0x77ab2f;
    public static final int DEFAULT_SKY_FOG_COLOR = 12638463;

    public static final int GROMBLE_SKY_FOG_COLOR = 0x10557E;

    /**
     * Base biome function Sky color is not generated
     */
    public static Biome biome(
            Biome.Precipitation precipitation,
            Biome.BiomeCategory category,
            float depth,
            float scale,
            float temperature,
            float downfall,
            BiomeSpecialEffects.Builder effects,
            BiomeGenerationSettings.Builder genSettings,
            MobSpawnSettings spawnSettings
    ) {
        return new BiomeBuilder()
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
    public static <C extends SurfaceBuilderConfiguration> BiomeGenerationSettings.Builder genSettings(SurfaceBuilder<C> surfaceBuilder, C config) {
        return new BiomeGenerationSettings.Builder().surfaceBuilder(surfaceBuilder.configured(config));
    }

    /**
     * Shortcut function
     */
    public static MobSpawnSettings.Builder spawnSettings() {
        return new MobSpawnSettings.Builder();
    }

    /**
     * Shortcut function
     */
    public static void addSpawn(
            MobSpawnSettings.Builder spawnSettings,
            MobCategory classification,
            EntityType<?> entityType,
            int weight,
            int min,
            int max) {
        spawnSettings.addSpawn(classification,
                new SpawnerData(entityType, weight, min, max)
        );
    }

    /**
     * Biome ambience add default parameters and enforced the required ones. Should prevent slip ups on my part :)
     */
    public static BiomeSpecialEffects.Builder effects(int waterColor,
                                                      int waterFogColor,
                                                      int grassColor,
                                                      int foliageColor,
                                                      float temperature,
                                                      int skyFogColor,
                                                      SoundEvent music) {
        return new BiomeSpecialEffects.Builder()
                .waterColor(waterColor)
                .waterFogColor(waterFogColor)
                .grassColorOverride(grassColor)
                .foliageColorOverride(foliageColor)
                .skyColor(getSkyForTemp(temperature))
                .fogColor(skyFogColor)
                .backgroundMusic(Musics.createGameMusic(music));
    }

    public static int getSkyForTemp(float temperature) {
        final float a = Mth.clamp(temperature / 3.0f, -1.0f, 1.0f);
        return Mth.hsvToRgb(0.62222224f - a * 0.05f, 0.5f + a * 0.1f, 1.0f);
    }
}
