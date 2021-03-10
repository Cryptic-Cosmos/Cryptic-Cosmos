package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.world.biomes.BiomeMaker;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeRegistries {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, CrypticCosmos.MOD_ID);

    // lunara biomes
    public static final RegistryObject<Biome> LUNARA_PLAINS = BIOMES.register("lunara_plains", BiomeMaker::makeLunaraPlains);
    public static final RegistryKey<Biome> LUNARA_PLAINS_KEY =
            RegistryKey.create(Registry.BIOME_REGISTRY, CrypticCosmos.id("lunara_plains"));

    public static final RegistryObject<Biome> ACERBIC_ISLES = BIOMES.register("acerbic_isles", BiomeMaker::makeAcerbicIsles);
    public static final RegistryKey<Biome> LUNARA_MOUNTAINS_KEY =
            RegistryKey.create(Registry.BIOME_REGISTRY, CrypticCosmos.id("lunara_mountains"));

    public static final RegistryObject<Biome> MONDROVE_GROVES = BIOMES.register("mondrove_groves", BiomeMaker::makeMondroveGroves);
    public static final RegistryKey<Biome> LUNARA_FOREST_KEY =
            RegistryKey.create(Registry.BIOME_REGISTRY, CrypticCosmos.id("lunara_forest"));

    public static final RegistryObject<Biome> UMBRAL_DUNES = BIOMES.register("umbral_dunes", BiomeMaker::makeUmbralDunes);
    public static final RegistryKey<Biome> UMBRAL_DUNES_KEY =
            RegistryKey.create(Registry.BIOME_REGISTRY, CrypticCosmos.id("umbral_dunes"));

    public static void biomeLoading(FMLCommonSetupEvent event) {
        BiomeDictionary.addTypes(LUNARA_PLAINS_KEY, Type.PLAINS, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        BiomeDictionary.addTypes(LUNARA_MOUNTAINS_KEY, Type.MOUNTAIN, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        BiomeDictionary.addTypes(LUNARA_FOREST_KEY, Type.FOREST, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        BiomeDictionary.addTypes(UMBRAL_DUNES_KEY, Type.HOT, Type.DRY, Type.PLAINS, Type.DEAD);
    }
}