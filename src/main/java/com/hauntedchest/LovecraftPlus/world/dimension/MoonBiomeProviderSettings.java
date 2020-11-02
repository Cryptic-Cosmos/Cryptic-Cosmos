package com.hauntedchest.LovecraftPlus.world.dimension;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

import javax.annotation.Nonnull;

public class MoonBiomeProviderSettings implements IBiomeProviderSettings {
    private final long seed;
    private final WorldType worldType;
    private MoonGenSettings generatorSettings = new MoonGenSettings();

    public MoonBiomeProviderSettings(@Nonnull WorldInfo info) {
        this.seed = info.getSeed();
        this.worldType = info.getGenerator();
    }

    public long getSeed() {
        return this.seed;
    }

    public WorldType getWorldType() {
        return worldType;
    }

    public MoonGenSettings getGeneratorSettings() {
        return generatorSettings;
    }

    public MoonBiomeProviderSettings setGeneratorSettings(MoonGenSettings generatorSettings) {
        this.generatorSettings = generatorSettings;
        return this;
    }
}
