package com.crypticcosmos.crypticcosmos.world.feature;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class MoonTree extends Tree {
    public static final TreeFeatureConfig MOON_TREE_CONFIG2 = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockRegistries.MOON_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockRegistries.MOON_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))
            .baseHeight(5)
            .heightRandA(2)
            .foliageHeight(3)
            .ignoreVines()
            .decorators(ImmutableList.of(new BeehiveTreeDecorator(0.05F)))
            .setSapling((IPlantable) BlockRegistries.MOON_SAPLING.get()).build();

    public static final TreeFeatureConfig MOON_TREE_CONFIG = new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockRegistries.MOON_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockRegistries.MOON_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))
            .baseHeight(5)
            .heightRandA(2)
            .foliageHeight(3)
            .ignoreVines()
            .setSapling((IPlantable) BlockRegistries.MOON_SAPLING.get()).build();

    @Override
    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(@Nonnull Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(p_225546_2_ ? MOON_TREE_CONFIG2 : MOON_TREE_CONFIG);
    }
}
