package com.crypticcosmos.crypticcosmos.world.feature;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nonnull;
import java.util.Random;

public class ThornTree extends Tree {
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> THORN_TREE_CONFIG = Feature.TREE.withConfiguration(
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BlockRegistries.THORN_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BlockRegistries.THORN_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(
                            FeatureSpread.func_242252_a(2),
                            FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 8, 0),
                    new TwoLayerFeature(1, 0, 1))
                    .build());

    @Override
    protected ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(@Nonnull Random randomIn, boolean b) {
        return THORN_TREE_CONFIG;
    }
}