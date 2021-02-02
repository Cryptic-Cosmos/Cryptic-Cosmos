package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.world.biomes.*;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeRegistries {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, CrypticCosmos.MOD_ID);

    public static final SurfaceBuilderConfig GRASS_STONE_SAND = new SurfaceBuilderConfig(
            Blocks.GRASS_BLOCK.getDefaultState(),
            Blocks.STONE.getDefaultState(),
            Blocks.SAND.getDefaultState()
    );

    public static final RegistryObject<Biome> THORN_JUNGLE = BIOMES.register(
            "thorn_jungle",
            () -> new ThornJungleBiome(new Biome.Builder()
                    .scale(1f)
                    .temperature(0.2f)
                    .waterColor(0x465623)
                    .waterFogColor(0x88ba40)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT, BiomeRegistries.GRASS_STONE_SAND)
                    .category(Biome.Category.JUNGLE)
                    .downfall(0.0001f)
                    .depth(0.125f)
                    .parent(null)
                    .precipitation(Biome.RainType.RAIN))
    );

    // moon biomes
    public static final RegistryObject<LunaraPlainsBiome> LUNARA_PLAINS = BIOMES.register(
            "moon_plains",
            () -> new LunaraPlainsBiome(new Biome.Builder()
                    .scale(1f)
                    .temperature(0f)
                    .waterColor(0xfffff5)
                    .waterFogColor(0xfffff5)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    BlockRegistries.GRASS_LUNON.get().getDefaultState(),
                                    BlockRegistries.LUNON.get().getDefaultState(),
                                    BlockRegistries.LUNON.get().getDefaultState()))
                    .category(Biome.Category.PLAINS)
                    .downfall(0.0001f)
                    .depth(0.125f)
                    .parent(null)
                    .precipitation(Biome.RainType.RAIN))
    );
    public static final RegistryObject<LunaraMountainsBiome> LUNARA_MOUNTAINS = BIOMES.register(
            "lunara_mountains",
            () -> new LunaraMountainsBiome(new Biome.Builder()
                    .scale(1f)
                    .temperature(0f)
                    .waterColor(0xfffff5)
                    .waterFogColor(0xfffff5)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    BlockRegistries.GRASS_LUNON.get().getDefaultState(),
                                    BlockRegistries.LUNON.get().getDefaultState(),
                                    BlockRegistries.LUNON.get().getDefaultState()
                            ))
                    .category(Biome.Category.EXTREME_HILLS)
                    .downfall(0.0001f)
                    .depth(0.125f)
                    .parent(null)
                    .precipitation(Biome.RainType.RAIN))
    );
    public static final RegistryObject<LunaraForestBiome> LUNARA_FOREST = BIOMES.register(
            "lunara_forest",
            () -> new LunaraForestBiome(new Biome.Builder()
                    .scale(1f)
                    .temperature(0f)
                    .waterColor(0xfffff5)
                    .waterFogColor(0xfffff5)
                    .surfaceBuilder(
                            SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    BlockRegistries.GRASS_LUNON.get().getDefaultState(),
                                    BlockRegistries.LUNON.get().getDefaultState(),
                                    BlockRegistries.LUNON.get().getDefaultState()
                            )
                    )
                    .category(Biome.Category.FOREST)
                    .downfall(0.0001f)
                    .depth(0.125f)
                    .parent(null)
                    .precipitation(Biome.RainType.RAIN))
    );
    public static final RegistryObject<UmbralDunes> UMBRAL_DUNES = BIOMES.register(
            "umbral_dunes",
            () -> new UmbralDunes(new Biome.Builder()
                    .scale(1f)
                    .temperature(3f)
                    .waterColor(1042)
                    .waterFogColor(1042)
                    .surfaceBuilder(SurfaceBuilder.DEFAULT,
                            new SurfaceBuilderConfig(
                                    BlockRegistries.UMBRAL_DUNE.get().getDefaultState(),
                                    BlockRegistries.UMBRAL_DUNE.get().getDefaultState(),
                                    BlockRegistries.UMBRAL_DUNE.get().getDefaultState()))
                    .category(Biome.Category.PLAINS)
                    .downfall(0)
                    .depth(-0.5f)
                    .parent(null)
                    .precipitation(Biome.RainType.RAIN))
    );

    public static void registerBiomes() {
        registerBiome(THORN_JUNGLE.get(), true, Type.JUNGLE, Type.LUSH, Type.OVERWORLD, Type.SPOOKY);
        registerBiome(LUNARA_PLAINS.get(), false, Type.PLAINS, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        registerBiome(LUNARA_MOUNTAINS.get(), false, Type.MOUNTAIN, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        registerBiome(LUNARA_FOREST.get(), false, Type.FOREST, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        registerBiome(UMBRAL_DUNES.get(), false, Type.HOT, Type.DRY, Type.PLAINS, Type.DEAD);

    }

    private static void registerBiome(Biome biome, boolean addBiome, Type... types) {
        if (addBiome) {
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 25));
        }

        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
