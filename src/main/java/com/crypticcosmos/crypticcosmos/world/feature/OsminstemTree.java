package com.crypticcosmos.crypticcosmos.world.feature;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class OsminstemTree extends Tree {
    @Override
    @Nullable
    public ConfiguredFeature<BaseTreeFeatureConfig, ?> getConfiguredFeature(@Nonnull Random randomIn, boolean largeHive) {
        return ConfiguredFeatureRegistries.OSMINSTEM_TREE;
    }
}