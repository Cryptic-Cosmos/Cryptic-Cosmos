package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CrypticCosmosDimensions {
    public static final List<RegistryKey<World>> RIFT_VALID_DIMENSIONS = new ArrayList<>();
    public static final RegistryKey<World> LUNARA_KEY = newDimensionKey("lunara");
    public static final RegistryKey<World> ABYSS_KEY = newDimensionKey("abyss");

    private static RegistryKey<World> newDimensionKey(String id) {
        final RegistryKey<World> key = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, CrypticCosmos.id(id));

        if (!RIFT_VALID_DIMENSIONS.contains(World.OVERWORLD)) RIFT_VALID_DIMENSIONS.add(World.OVERWORLD);
        RIFT_VALID_DIMENSIONS.add(key);
        return key;
    }
}