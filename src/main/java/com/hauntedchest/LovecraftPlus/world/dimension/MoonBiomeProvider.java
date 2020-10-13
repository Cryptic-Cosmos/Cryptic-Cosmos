package com.hauntedchest.LovecraftPlus.world.dimension;

import com.hauntedchest.LovecraftPlus.Inits.MoonModBiomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraftforge.fml.RegistryObject;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MoonBiomeProvider extends BiomeProvider {
    private static final Set<Biome> biomeList = new HashSet<>();

    private MoonGenerator biomeNoise;
    double biomeSize = 32.0d;

    public MoonBiomeProvider(MoonBiomeProviderSettings genSettings) {
        super(biomeList);
        this.biomeNoise = new MoonGenerator();
        this.biomeNoise.setSeed((int) genSettings.getSeed());
        MoonModBiomes.BIOMES.getEntries().stream().map(RegistryObject::get).forEach(biomeList::add);
    }



    @Override
    public Biome getNoiseBiome(int x, int y, int z) {
        return getBiome(new LinkedList<Biome>(biomeList),
                biomeNoise.getValue((double) x / biomeSize, (double) y / biomeSize, (double) z / biomeSize));
    }

    public Biome getBiome(List<Biome> biomeList, double noiseVal) {
        for (int i = biomeList.size(); i >= 0; i--) {
            if (noiseVal > (2.0f / biomeList.size()) * i - 1)
                return biomeList.get(i);
        }
        return biomeList.get(biomeList.size() - 1);
    }
}
