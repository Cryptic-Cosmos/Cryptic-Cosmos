package com.crypticcosmos.crypticcosmos.world.dimension;

import com.crypticcosmos.crypticcosmos.registries.BiomeRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AbyssBiomeProvider extends BiomeProvider {
    private static final Set<Biome> biomes = new HashSet<>();
    private static final double BIOME_SIZE = 32.0d;
    private final AbyssGenerator biomeNoise = new AbyssGenerator();

    public AbyssBiomeProvider(@Nonnull AbyssBiomeProviderSettings genSettings) {
        super(biomes);

        this.biomeNoise.setSeed((int) genSettings.getSeed());
        biomes.add(BiomeRegistries.UMBRAL_DUNES.get());
    }

    @Override
    @Nonnull
    public Biome getNoiseBiome(int x, int y, int z) {
        return getBiome(
                new LinkedList<>(biomes),
                biomeNoise.getValue((double) x / BIOME_SIZE, (double) y / BIOME_SIZE, (double) z / BIOME_SIZE)
        );
    }

    public Biome getBiome(@Nonnull List<Biome> biomeList, double noiseVal) {
        for (int i = biomeList.size(); i >= 0; i--) {
            if (noiseVal > (2.0f / biomeList.size()) * i - 1) return biomeList.get(i);
        }

        return biomeList.get(biomeList.size() - 1);
    }
}
