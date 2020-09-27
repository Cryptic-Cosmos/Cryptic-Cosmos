package com.hauntedchest.LovecraftPlus.world.biomes;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;

public class MoonBiome extends Biome {
    public MoonBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        addSpawn(EntityClassification.MONSTER,new SpawnListEntry(EntityType.ENDERMAN,20,2,10));
    }
}
