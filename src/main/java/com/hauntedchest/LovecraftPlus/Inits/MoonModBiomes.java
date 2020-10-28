package com.hauntedchest.LovecraftPlus.Inits;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.world.biomes.MoonForestBiome;
import com.hauntedchest.LovecraftPlus.world.biomes.MoonMountainsBiome;
import com.hauntedchest.LovecraftPlus.world.biomes.MoonPlainsBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

public class MoonModBiomes {
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister(ForgeRegistries.BIOMES, LovecraftPlusMod.MOD_ID);

    public static final IForgeRegistry<Biome> MOON_BIOMES = RegistryManager.ACTIVE.getRegistry(Biome.class);

    public static final RegistryObject<Biome> MOON_PLAINS = BIOMES.register("moon_plains", () -> new MoonPlainsBiome(new Biome.Builder().scale(1f).temperature(0f).waterColor(16777205).waterFogColor(16777205).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BlockHandeler.MOON_BLOCK.get().getDefaultState(), BlockHandeler.MOONSTONE.get().getDefaultState(), BlockHandeler.MOON_BLOCK.get().getDefaultState())).category(Biome.Category.PLAINS).downfall(0.0001f).depth(0.125f).parent(null).precipitation(Biome.RainType.RAIN)));
    public static final RegistryObject<Biome> MOON_MOUNTAINS = BIOMES.register("moon_mountains", () -> new MoonMountainsBiome(new Biome.Builder().scale(1f).temperature(0f).waterColor(16777205).waterFogColor(16777205).surfaceBuilder(SurfaceBuilder.MOUNTAIN, new SurfaceBuilderConfig(BlockHandeler.MOON_BLOCK.get().getDefaultState(), BlockHandeler.MOONSTONE.get().getDefaultState(), BlockHandeler.MOON_BLOCK.get().getDefaultState())).category(Biome.Category.EXTREME_HILLS).downfall(0.0001f).depth(0.125f).parent(null).precipitation(Biome.RainType.RAIN)));
    public static final RegistryObject<Biome> MOON_FOREST = BIOMES.register("moon_forest", () -> new MoonForestBiome(new Biome.Builder().scale(1f).temperature(0f).waterColor(16777205).waterFogColor(16777205).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BlockHandeler.MOON_BLOCK.get().getDefaultState(), BlockHandeler.MOONSTONE.get().getDefaultState(), BlockHandeler.MOON_BLOCK.get().getDefaultState())).category(Biome.Category.FOREST).downfall(0.0001f).depth(0.125f).parent(null).precipitation(Biome.RainType.RAIN)));


    private static void registerBiomes(Biome biome, BiomeDictionary.Type... types){
        registerBiome(MOON_PLAINS.get(), Type.PLAINS, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        registerBiome(MOON_MOUNTAINS.get(), Type.MOUNTAIN, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        registerBiome(MOON_FOREST.get(), Type.FOREST, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
    }

    private static void registerBiome(Biome biome, Type... types)
    {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
