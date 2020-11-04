package com.hauntedchest.lovecraftplus.world.biomes;

import com.hauntedchest.lovecraftplus.registries.BlockHandler;
import com.hauntedchest.lovecraftplus.registries.EntityTypeHandler;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.util.Lazy;

@SuppressWarnings("NullableProblems")
public class MoonMountainsBiome extends Biome {
    private final Lazy<EntityType<?>> MOON_BEAST = Lazy.of(EntityTypeHandler.MOON_BEAST::get);

    public MoonMountainsBiome() {
        super(new Builder()
                .scale(1f)
                .temperature(0f)
                .waterColor(0xfffff5)
                .waterFogColor(0xfffff5)
                .surfaceBuilder(SurfaceBuilder.DEFAULT,
                        new SurfaceBuilderConfig(
                                BlockHandler.MOONCALITE.get().getDefaultState(),
                                BlockHandler.MOONSTONE.get().getDefaultState(),
                                BlockHandler.MOONCALITE.get().getDefaultState()
                        ))
                .category(Biome.Category.EXTREME_HILLS)
                .downfall(0.0001f)
                .depth(0.125f)
                .parent(null)
                .precipitation(Biome.RainType.RAIN));

        DefaultBiomeFeatures.addCarvers(this);
    }

    @Override
    public void addSpawn(EntityClassification type, SpawnListEntry spawnListEntry) {
        super.addSpawn(type, spawnListEntry);
    }
}
