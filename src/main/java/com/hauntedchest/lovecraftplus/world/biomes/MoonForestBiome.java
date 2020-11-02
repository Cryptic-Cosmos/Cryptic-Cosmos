package com.hauntedchest.lovecraftplus.world.biomes;

import com.google.common.collect.ImmutableList;
import com.hauntedchest.lovecraftplus.registries.BlockHandler;
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
import net.minecraftforge.common.IPlantable;

public class MoonForestBiome extends Biome {
    private static final BlockState MOON_LOG = BlockHandler.MOON_LOG.get().getDefaultState();
    private static final BlockState MOON_LEAVES = BlockHandler.MOON_LEAVES.get().getDefaultState();
    public static final TreeFeatureConfig MOON_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(MOON_LOG),
            new SimpleBlockStateProvider(MOON_LEAVES),
            new BlobFoliagePlacer(2, 0)))
            .baseHeight(5)
            .heightRandA(2)
            .foliageHeight(3)
            .ignoreVines()
            .decorators(ImmutableList.of(new BeehiveTreeDecorator(0.002F)))
            .setSapling((IPlantable) BlockHandler.MOON_SAPLING.get())
            .build();

    public MoonForestBiome() {
        super(new Biome.Builder()
                .scale(1f)
                .temperature(0f)
                .waterColor(0xfffff5)
                .waterFogColor(0xfffff5)
                .surfaceBuilder(SurfaceBuilder.DEFAULT,
                        new SurfaceBuilderConfig(
                                BlockHandler.MOON_BLOCK.get().getDefaultState(),
                                BlockHandler.MOONSTONE.get().getDefaultState(),
                                BlockHandler.MOON_BLOCK.get().getDefaultState()))
                .category(Biome.Category.FOREST)
                .downfall(0.0001f)
                .depth(0.125f)
                .parent(null)
                .precipitation(Biome.RainType.RAIN));

        addSpawn(EntityClassification.CREATURE, new SpawnListEntry(
                EntityType.COW, 8, 4, 4));

        addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(
                EntityType.ENDERMAN, 10, 1, 4));

        DefaultBiomeFeatures.addCarvers(this);

        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.NORMAL_TREE.withConfiguration(MOON_TREE_CONFIG)
                        .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
                                .configure(new AtSurfaceWithExtraConfig(
                                        10, 0.1F, 1))));
    }
}
