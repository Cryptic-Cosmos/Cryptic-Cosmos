package com.hauntedchest.lovecraftplus.world.biomes;

import com.hauntedchest.lovecraftplus.registries.BlockHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

@SuppressWarnings("NullableProblems")
public class MoonPlainsBiome extends Biome {
    public MoonPlainsBiome() {
        super(new Builder()
                .scale(1f)
                .temperature(0f)
                .waterColor(0xfffff5)
                .waterFogColor(0xfffff5)
                .surfaceBuilder(SurfaceBuilder.DEFAULT,
                        new SurfaceBuilderConfig(
                                BlockHandler.MOONCALITE.get().getDefaultState(),
                                BlockHandler.MOONSTONE.get().getDefaultState(),
                                BlockHandler.MOONCALITE.get().getDefaultState()))
                .category(Biome.Category.PLAINS)
                .downfall(0.0001f)
                .depth(0.125f)
                .parent(null)
                .precipitation(Biome.RainType.RAIN));

        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addTaigaRocks(this);
        DefaultBiomeFeatures.addDeadBushes(this);
    }

    @Override
    public void addSpawn(EntityClassification type, SpawnListEntry spawnListEntry) {
        super.addSpawn(type, spawnListEntry);
    }
}
