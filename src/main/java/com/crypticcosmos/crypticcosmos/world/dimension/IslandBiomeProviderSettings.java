package com.crypticcosmos.crypticcosmos.world.dimension;

import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

import javax.annotation.Nonnull;

public class IslandBiomeProviderSettings implements IBiomeProviderSettings {
    private final long seed;

    public IslandBiomeProviderSettings(@Nonnull WorldInfo info) {
        this.seed = info.getSeed();
    }

    public long getSeed() {
        return this.seed;
    }
}
