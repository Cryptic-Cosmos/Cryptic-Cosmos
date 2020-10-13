package com.hauntedchest.LovecraftPlus.Inits;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.world.biomes.ThornJungleBiome;
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

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister(ForgeRegistries.BIOMES, LovecraftPlusMod.MOD_ID);

    public static final RegistryObject<Biome> THORN_JUNGLE = BIOMES.register("thorn_jungle", () -> new ThornJungleBiome(new Biome.Builder().scale(1f).temperature(0.2f).waterColor(4609571).waterFogColor(8960576).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.SAND.getDefaultState())).category(Biome.Category.JUNGLE).downfall(0.0001f).depth(0.125f).parent(null).precipitation(Biome.RainType.RAIN)));
    public static void registerBiomes()
    {
        registerBiome(THORN_JUNGLE.get(), Type.JUNGLE, Type.LUSH, Type.OVERWORLD, Type.SPOOKY);
    }
    private static void registerBiome(Biome biome, Type... types)
    {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 25));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    private static void registerMoonBiome(Biome biome, Type... types)
    {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
