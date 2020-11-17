package com.github.hauntedchest.lovecraftplus.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;

import javax.annotation.Nonnull;

public class MoonMountainsBiome extends Biome {
    public MoonMountainsBiome(Biome.Builder builder) {
        super(builder);

        DefaultBiomeFeatures.addCarvers(this);
    }

    @Override
    public void addSpawn(@Nonnull EntityClassification type, @Nonnull SpawnListEntry spawnListEntry) {
        super.addSpawn(type, spawnListEntry);
    }
}
