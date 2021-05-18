package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CrypticCosmosDimensions {
    public static final List<RegistryKey<World>> RIFT_VALID_DIMENSIONS = new ArrayList<>();
    public static final RegistryKey<World> MAKROSSA_KEY = newDimensionKey("makrossa");
    public static final RegistryKey<World> UMBRAL_DAWN_KEY = newDimensionKey("umbral_dawn");

    private static RegistryKey<World> newDimensionKey(String id) {
        final RegistryKey<World> key = RegistryKey.create(Registry.DIMENSION_REGISTRY, CrypticCosmos.id(id));

        if (!RIFT_VALID_DIMENSIONS.contains(World.OVERWORLD)) RIFT_VALID_DIMENSIONS.add(World.OVERWORLD);
        RIFT_VALID_DIMENSIONS.add(key);
        return key;
    }
}