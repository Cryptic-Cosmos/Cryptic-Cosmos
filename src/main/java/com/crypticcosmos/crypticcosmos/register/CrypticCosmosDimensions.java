package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class CrypticCosmosDimensions {
    public static final List<ResourceKey<Level>> RIFT_VALID_DIMENSIONS = new ArrayList<>();
    public static final ResourceKey<Level> MAKROSSA_KEY = newDimensionKey("makrossa");
    public static final ResourceKey<Level> UMBRAL_DAWN_KEY = newDimensionKey("umbral_dawn");

    private static ResourceKey<Level> newDimensionKey(String id) {
        final ResourceKey<Level> key = ResourceKey.create(Registry.DIMENSION_REGISTRY, CrypticCosmos.id(id));

        if (!RIFT_VALID_DIMENSIONS.contains(Level.OVERWORLD)) RIFT_VALID_DIMENSIONS.add(Level.OVERWORLD);
        RIFT_VALID_DIMENSIONS.add(key);
        return key;
    }
}