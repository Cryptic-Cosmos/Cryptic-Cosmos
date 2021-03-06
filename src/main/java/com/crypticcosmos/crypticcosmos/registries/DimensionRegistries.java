package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;

public class DimensionRegistries {
    public static final RegistryKey<DimensionType> LUNARA_DIM =
            RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, CrypticCosmos.id("lunara"));
    public static final RegistryKey<DimensionType> ABYSS_DIM =
            RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, CrypticCosmos.id("abyss"));
    public static final RegistryKey<DimensionType> ISLAND_DIM =
            RegistryKey.getOrCreateKey(Registry.DIMENSION_TYPE_KEY, CrypticCosmos.id("island"));
}
