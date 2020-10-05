package com.hauntedchest.LovecraftPlus.world.feature;

import com.google.common.collect.ImmutableList;
import com.hauntedchest.LovecraftPlus.Inits.BlockHandeler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.JungleFoliagePlacer;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nullable;
import java.util.Random;

public class ThornTree extends Tree {
    public static final BaseTreeFeatureConfig THORN_SAPLING_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockHandeler.THORN_LOG.get().getDefaultState()), new SimpleBlockStateProvider(BlockHandeler.THORN_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0, 0, 0, 3), new StraightTrunkPlacer(4, 8, 0), new TwoLayerFeature(1, 0, 1))).func_236700_a_().build();
    public static final BaseTreeFeatureConfig MEGA_THORN_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockHandeler.THORN_LOG.get().getDefaultState()), new SimpleBlockStateProvider(BlockHandeler.THORN_LEAVES.get().getDefaultState()), new JungleFoliagePlacer(2, 0, 0, 0, 2), new MegaJungleTrunkPlacer(10, 2, 19), new TwoLayerFeature(1, 1, 2))).func_236703_a_(ImmutableList.of(TrunkVineTreeDecorator.field_236879_b_, LeaveVineTreeDecorator.field_236871_b_)).build();



    /**
     * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of tree
     */
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return (new TreeFeature(BaseTreeFeatureConfig.field_236676_a_)).withConfiguration(ThornTree.THORN_SAPLING_TREE_CONFIG);
    }

    /**
     * Get a {@link net.minecraft.world.gen.feature.ConfiguredFeature} of the huge variant of this tree
     */
    @Nullable
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
        return Feature.field_236291_c_.withConfiguration(ThornTree.MEGA_THORN_TREE_CONFIG);
    }
}
