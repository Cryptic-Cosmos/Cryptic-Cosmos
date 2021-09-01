package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.world.biomes.BiomeMaker;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeRegistries {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, CrypticCosmos.MOD_ID);

    // lunara biomes
    public static final RegistryObject<Biome> LUNARAN_PLAINS = BIOMES.register("lunaran_plains", BiomeMaker::lunaraPlains);
    public static final ResourceKey<Biome> LUNARAN_PLAINS_KEY =
            ResourceKey.create(Registry.BIOME_REGISTRY, CrypticCosmos.id("lunaran_plains"));

    public static final RegistryObject<Biome> ACERBIC_ISLES = BIOMES.register("acerbic_isles", BiomeMaker::acerbicIsles);
    public static final ResourceKey<Biome> ACERBIC_ISLES_KEY =
            ResourceKey.create(Registry.BIOME_REGISTRY, CrypticCosmos.id("acerbic_isles"));

    public static final RegistryObject<Biome> KAFSINIAN_FOREST = BIOMES.register("kafsinian_forest", BiomeMaker::kafisnianForest);
    public static final ResourceKey<Biome> KAFSINIAN_FOREST_KEY =
            ResourceKey.create(Registry.BIOME_REGISTRY, CrypticCosmos.id("kafsinian_forest"));

    public static final RegistryObject<Biome> GROMBLE_GROVE = BIOMES.register("gromble_grove", BiomeMaker::grombleGrove);
    public static final ResourceKey<Biome> GROMBLE_GROVE_KEY =
            ResourceKey.create(Registry.BIOME_REGISTRY, CrypticCosmos.id("gromble_grove"));

    public static final RegistryObject<Biome> UMBRAL_DUNES = BIOMES.register("umbral_dunes", BiomeMaker::umbralDunes);
    public static final ResourceKey<Biome> UMBRAL_DUNES_KEY =
            ResourceKey.create(Registry.BIOME_REGISTRY, CrypticCosmos.id("umbral_dunes"));

    public static void biomeLoading(FMLCommonSetupEvent event) {
        BiomeDictionary.addTypes(LUNARAN_PLAINS_KEY, Type.PLAINS, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        BiomeDictionary.addTypes(ACERBIC_ISLES_KEY, Type.MOUNTAIN, Type.DEAD, Type.NETHER, Type.HOT);
        BiomeDictionary.addTypes(KAFSINIAN_FOREST_KEY, Type.FOREST, Type.DRY, BiomeDictionary.Type.COLD, Type.DEAD);
        BiomeDictionary.addTypes(GROMBLE_GROVE_KEY, Type.FOREST, Type.LUSH, Type.HOT, Type.HILLS);
        BiomeDictionary.addTypes(UMBRAL_DUNES_KEY, Type.HOT, Type.DRY, Type.PLAINS, Type.DEAD);
    }
}