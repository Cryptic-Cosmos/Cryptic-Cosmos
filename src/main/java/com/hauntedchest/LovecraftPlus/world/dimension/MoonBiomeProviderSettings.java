package com.hauntedchest.LovecraftPlus.world.dimension;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class MoonBiomeProviderSettings implements IBiomeProviderSettings {
    private final long seed;
    private final WorldType worldType;
    private MoonGenSettings generatorSettings = new MoonGenSettings();

    public MoonBiomeProviderSettings(WorldInfo info) {
        this.seed = info.getSeed();
        this.worldType = info.getGenerator();
    }

    public MoonBiomeProviderSettings setGeneratorSettings(MoonGenSettings settings) {
        this.generatorSettings = settings;
        return this;
    }

    public long getSeed() {
        return this.seed;
    }

    public WorldType getWorldType() {
        return this.worldType;
    }

    public MoonGenSettings getGeneratorSettings() {
        return this.generatorSettings;
    }
}
