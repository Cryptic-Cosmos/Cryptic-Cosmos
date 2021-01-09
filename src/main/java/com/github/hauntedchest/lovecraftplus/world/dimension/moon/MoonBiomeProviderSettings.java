package com.github.hauntedchest.lovecraftplus.world.dimension.moon;

import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

import javax.annotation.Nonnull;

public class MoonBiomeProviderSettings implements IBiomeProviderSettings {
    private final long seed;

    public MoonBiomeProviderSettings(@Nonnull WorldInfo info) {
        this.seed = info.getSeed();
    }

    public long getSeed() {
        return this.seed;
    }
}
