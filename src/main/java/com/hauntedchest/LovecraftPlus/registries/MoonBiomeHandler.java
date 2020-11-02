package com.hauntedchest.LovecraftPlus.registries;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.world.biomes.MoonForestBiome;
import com.hauntedchest.LovecraftPlus.world.biomes.MoonMountainsBiome;
import com.hauntedchest.LovecraftPlus.world.biomes.MoonPlainsBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MoonBiomeHandler {
    public static final DeferredRegister<Biome> BIOMES =
            DeferredRegister.create(ForgeRegistries.BIOMES, LovecraftPlusMod.MOD_ID);

    public static final SurfaceBuilderConfig MOON_BLOCK_MOONSTONE_MOON_BLOCK =
            new SurfaceBuilderConfig(
                    BlockHandler.MOON_BLOCK.get().getDefaultState(),
                    BlockHandler.MOONSTONE.get().getDefaultState(),
                    BlockHandler.MOON_BLOCK.get().getDefaultState());

    public static final RegistryObject<Biome> MOON_PLAINS = BIOMES.register("moon_plains",
            MoonPlainsBiome::new);

    public static final RegistryObject<Biome> MOON_MOUNTAINS = BIOMES.register("moon_mountains",
            MoonMountainsBiome::new);

    public static final RegistryObject<Biome> MOON_FOREST = BIOMES.register("moon_forest",
            MoonForestBiome::new);

    public static void registerBiomes() {
        registerBiome(MOON_PLAINS.get(), Type.PLAINS, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        registerBiome(MOON_MOUNTAINS.get(), Type.MOUNTAIN, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        registerBiome(MOON_FOREST.get(), Type.FOREST, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
    }

    private static void registerBiome(Biome biome, Type... types) {
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}