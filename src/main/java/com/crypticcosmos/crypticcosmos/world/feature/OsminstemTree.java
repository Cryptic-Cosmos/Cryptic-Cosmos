package com.crypticcosmos.crypticcosmos.world.feature;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class OsminstemTree extends AbstractTreeGrower {
    @Override
    @Nullable
    public ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(@Nonnull Random randomIn, boolean largeHive) {
        return ConfiguredFeatureRegistries.OSMINSTEM_TREE;
    }
}