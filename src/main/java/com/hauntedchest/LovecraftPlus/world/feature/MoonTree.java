package com.hauntedchest.LovecraftPlus.world.feature;

import com.google.common.collect.ImmutableList;
import com.hauntedchest.LovecraftPlus.registries.BlockHandler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;

import javax.annotation.Nullable;
import java.util.Random;

public class MoonTree extends Tree {
    public static final TreeFeatureConfig MOON_TREE_CONFIG2 = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockHandler.MOON_LOG.get().getDefaultState()), new SimpleBlockStateProvider(BlockHandler.MOON_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).foliageHeight(3).ignoreVines().decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F))).setSapling((net.minecraftforge.common.IPlantable) BlockHandler.MOON_SAPLING.get()).build();
    public static final TreeFeatureConfig MOON_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockHandler.MOON_LOG.get().getDefaultState()), new SimpleBlockStateProvider(BlockHandler.MOON_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) BlockHandler.MOON_SAPLING.get()).build();

    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(p_225546_2_ ? MOON_TREE_CONFIG2 : MOON_TREE_CONFIG);
    }
}
