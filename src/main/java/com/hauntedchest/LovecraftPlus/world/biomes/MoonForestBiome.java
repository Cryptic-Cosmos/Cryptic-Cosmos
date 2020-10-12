package com.hauntedchest.LovecraftPlus.world.biomes;

import com.google.common.collect.ImmutableList;
import com.hauntedchest.LovecraftPlus.Inits.BlockHandeler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;

public class MoonForestBiome extends Biome {
    private static final BlockState MOON_LOG = BlockHandeler.MOON_LOG.get().getDefaultState();
    private static final BlockState MOON_LEAVES = BlockHandeler.MOON_LEAVES.get().getDefaultState();
    public static final BlockState MOON_PEBBLES = BlockHandeler.MOON_BLOCK.get().getDefaultState();
    public static final BlockState MOONSTONE = BlockHandeler.MOONSTONE.get().getDefaultState();
    public static final TreeFeatureConfig field_230129_h_ = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MOON_LOG), new SimpleBlockStateProvider(MOON_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).foliageHeight(3).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F))).setSapling((net.minecraftforge.common.IPlantable) BlockHandeler.MOON_SAPLING.get()).build();
    public static final TreeFeatureConfig FANCY_MOON_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(MOON_LOG), new SimpleBlockStateProvider(MOON_LEAVES), new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable) BlockHandeler.MOON_SAPLING.get()).build();
    public static final SurfaceBuilderConfig MPEBBLES_MSTONE_MSTONE_CONFIG = new SurfaceBuilderConfig(MOON_PEBBLES, MOONSTONE, MOONSTONE);
    public MoonForestBiome(Builder biomeBuilder) {
        super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, MPEBBLES_MSTONE_MSTONE_CONFIG).precipitation(Biome.RainType.RAIN).category(Category.FOREST).depth(0.125F).scale(0.05F).temperature(0F).downfall(0.4F).waterColor(16777205).waterFogColor(16777205).parent((String)null));
        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.COW, 8, 4, 4));
        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        DefaultBiomeFeatures.addCarvers(this);
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(field_230129_h_).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));

    }
}
