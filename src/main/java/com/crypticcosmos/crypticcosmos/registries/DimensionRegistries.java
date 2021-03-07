package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class DimensionRegistries {
    public static final RegistryKey<World> LUNARA_KEY =
            RegistryKey.getOrCreateKey(Registry.WORLD_KEY, CrypticCosmos.id("lunara"));
    public static final RegistryKey<World> ABYSS_KEY =
            RegistryKey.getOrCreateKey(Registry.WORLD_KEY, CrypticCosmos.id("abyss"));
}