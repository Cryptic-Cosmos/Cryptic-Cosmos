package com.hauntedchest.LovecraftPlus.world.feature;

import com.google.common.collect.ImmutableList;
import com.hauntedchest.LovecraftPlus.Inits.BlockHandeler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class ThornTree extends Tree {
        public static final TreeFeatureConfig THORN_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockHandeler.THORN_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockHandeler.THORN_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))).baseHeight(9).heightRandA(4).foliageHeight(3)
            .setSapling((IPlantable) BlockHandeler.THORN_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(THORN_TREE_CONFIG);
    }

    public static final HugeTreeFeatureConfig MEGA_THORN_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockHandeler.THORN_LOG.get().getDefaultState()), new SimpleBlockStateProvider(BlockHandeler.THORN_LEAVES.get().getDefaultState()))).baseHeight(10).heightInterval(20).decorators(ImmutableList.of(new TrunkVineTreeDecorator(), new LeaveVineTreeDecorator())).setSapling((net.minecraftforge.common.IPlantable) BlockHandeler.THORN_SAPLING.get()).build();


    @Nullable
    protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
        return Feature.MEGA_JUNGLE_TREE.withConfiguration(this.MEGA_THORN_TREE_CONFIG);
    }


}
