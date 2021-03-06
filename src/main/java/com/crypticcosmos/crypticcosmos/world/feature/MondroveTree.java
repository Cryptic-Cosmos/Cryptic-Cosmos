package com.crypticcosmos.crypticcosmos.world.feature;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class MondroveTree extends Tree {
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> MONDROVE_TREE = Feature.TREE.withConfiguration(
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BlockRegistries.MONDROVE_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BlockRegistries.MONDROVE_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2),
                            FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))
                    .setIgnoreVines()
                    .build()
    );

    @Override
    @Nullable
    public ConfiguredFeature<BaseTreeFeatureConfig, ?> getTreeFeature(@Nonnull Random randomIn, boolean p_225546_2_) {
        return MONDROVE_TREE;
    }
}
