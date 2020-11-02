package com.hauntedchest.LovecraftPlus.world.biomes;

import com.hauntedchest.LovecraftPlus.registries.BlockHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MoonMountainsBiome extends Biome {
    public static final BlockState MOON_PEBBLES = BlockHandler.MOON_BLOCK.get().getDefaultState();
    public static final BlockState MOONSTONE = BlockHandler.MOONSTONE.get().getDefaultState();
    public static final SurfaceBuilderConfig MPEBBLES_MSTONE_MSTONE_CONFIG = new SurfaceBuilderConfig(MOON_PEBBLES, MOONSTONE, MOONSTONE);

    public MoonMountainsBiome(Builder biomeBuilder) {
        super((new Builder()).surfaceBuilder(SurfaceBuilder.MOUNTAIN, MPEBBLES_MSTONE_MSTONE_CONFIG).precipitation(RainType.RAIN).category(Category.EXTREME_HILLS).depth(0.125F).scale(0.05F).temperature(0F).downfall(0.4F).waterColor(16777205).waterFogColor(16777205).parent(null));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        DefaultBiomeFeatures.addCarvers(this);
    }
}
