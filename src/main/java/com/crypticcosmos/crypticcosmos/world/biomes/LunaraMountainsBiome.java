package com.crypticcosmos.crypticcosmos.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;

import javax.annotation.Nonnull;

public class LunaraMountainsBiome extends Biome {
    public LunaraMountainsBiome(Biome.Builder builder) {
        super(builder);

        DefaultBiomeFeatures.addCarvers(this);
    }

    @Override
    public void addSpawn(@Nonnull EntityClassification type, @Nonnull SpawnListEntry spawnListEntry) {
        super.addSpawn(type, spawnListEntry);
    }
}
