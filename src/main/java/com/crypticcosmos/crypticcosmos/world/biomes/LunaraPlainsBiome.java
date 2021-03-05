package com.crypticcosmos.crypticcosmos.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;

import javax.annotation.Nonnull;

public class LunaraPlainsBiome extends Biome {
    public LunaraPlainsBiome(Biome.Builder builder) {
        super(builder);
    }

    @Override
    public void addSpawn(@Nonnull EntityClassification type, @Nonnull SpawnListEntry spawnListEntry) {
        super.addSpawn(type, spawnListEntry);
    }
}
