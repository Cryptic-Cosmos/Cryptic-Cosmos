package com.hauntedchest.LovecraftPlus.world.biomes;

import com.hauntedchest.LovecraftPlus.Inits.BlockHandeler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MoonPlainsBiome extends Biome {
    public static final BlockState MOON_PEBBLES = BlockHandeler.MOON_BLOCK.get().getDefaultState();
    public static final BlockState MOONSTONE = BlockHandeler.MOONSTONE.get().getDefaultState();
    public static final SurfaceBuilderConfig MPEBBLES_MSTONE_MSTONE_CONFIG = new SurfaceBuilderConfig(MOON_PEBBLES, MOONSTONE, MOONSTONE);
    public MoonPlainsBiome(Builder biomeBuilder) {
        super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, MPEBBLES_MSTONE_MSTONE_CONFIG).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0F).downfall(0.4F).waterColor(16777205).waterFogColor(16777205).parent((String)null));
        addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addLakes(this);
    }
}
