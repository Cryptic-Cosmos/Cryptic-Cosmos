package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.world.biomes.BiomeMaker;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeRegistries {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, CrypticCosmos.MOD_ID);

    // lunara biomes
    public static final RegistryObject<Biome> LUNARA_PLAINS = BIOMES.register("moon_plains", BiomeMaker::makeLunaraPlains);
    public static final RegistryKey<Biome> LUNARA_PLAINS_KEY =
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, CrypticCosmos.id("lunara_plains"));

    public static final RegistryObject<Biome> LUNARA_MOUNTAINS = BIOMES.register("lunara_mountains", BiomeMaker::makeLunaraMountains);
    public static final RegistryKey<Biome> LUNARA_MOUNTAINS_KEY =
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, CrypticCosmos.id("lunara_mountains"));

    public static final RegistryObject<Biome> LUNARA_FOREST = BIOMES.register("lunara_forest", BiomeMaker::makeLunaraForest);
    public static final RegistryKey<Biome> LUNARA_FOREST_KEY =
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, CrypticCosmos.id("lunara_forest"));

    public static final RegistryObject<Biome> UMBRAL_DUNES = BIOMES.register("umbral_dunes", BiomeMaker::makeUmbralDunes);
    public static final RegistryKey<Biome> UMBRAL_DUNES_KEY =
            RegistryKey.getOrCreateKey(Registry.BIOME_KEY, CrypticCosmos.id("umbral_dunes"));

    public static void biomeLoading(BiomeLoadingEvent event) {
        BiomeDictionary.addTypes(LUNARA_PLAINS_KEY, Type.PLAINS, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        BiomeDictionary.addTypes(LUNARA_MOUNTAINS_KEY, Type.MOUNTAIN, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        BiomeDictionary.addTypes(LUNARA_FOREST_KEY, Type.FOREST, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        BiomeDictionary.addTypes(UMBRAL_DUNES_KEY, Type.HOT, Type.DRY, Type.PLAINS, Type.DEAD);
    }
}
