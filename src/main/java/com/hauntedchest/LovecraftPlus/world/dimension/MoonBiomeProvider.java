package com.hauntedchest.LovecraftPlus.world.dimension;

import com.google.common.collect.ImmutableSet;
import com.hauntedchest.LovecraftPlus.Inits.ModBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import java.util.Random;
import java.util.Set;

public class MoonBiomeProvider extends BiomeProvider {
    private Random rand;

    protected MoonBiomeProvider() {
        super(biomeList);
        rand = new Random();
    }

    private static final Set<Biome> biomeList = ImmutableSet.of(ModBiomes.MOON_PLAINS.get(), ModBiomes.MOON_MOUNTAINS.get());

    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return ModBiomes.MOON_PLAINS.get();
    }
}
