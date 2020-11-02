package com.hauntedchest.LovecraftPlus.registries;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.world.biomes.ThornJungleBiome;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeHandler {
    public static final DeferredRegister<Biome> BIOMES =
            new DeferredRegister<>(ForgeRegistries.BIOMES, LovecraftPlusMod.MOD_ID);

    public static final SurfaceBuilderConfig GRASS_STONE_SAND = new SurfaceBuilderConfig(
            Blocks.GRASS_BLOCK.getDefaultState(),
            Blocks.STONE.getDefaultState(),
            Blocks.SAND.getDefaultState());

    public static final RegistryObject<Biome> THORN_JUNGLE = BIOMES.register("thorn_jungle",
            ThornJungleBiome::new);

    public static void registerBiomes() {
        registerBiome(THORN_JUNGLE.get(), Type.JUNGLE, Type.LUSH, Type.OVERWORLD, Type.SPOOKY);
    }

    private static void registerBiome(Biome biome, Type... types) {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,
                new BiomeManager.BiomeEntry(biome, 25));

        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
