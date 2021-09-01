package com.crypticcosmos.crypticcosmos.world.feature;

import com.crypticcosmos.crypticcosmos.block.GrombleStalkTop;
import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import com.crypticcosmos.crypticcosmos.register.GrombleRegistries;
import com.mojang.serialization.Codec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;

import javax.annotation.Nonnull;

public class GrombleStalkFeature extends Feature<ProbabilityFeatureConfiguration> {
    private static final BlockState STALK_TRUNK = BlockRegistries.GROMBLE_STALK_PLANT.get().defaultBlockState();
    private static final BlockState TOP_STALK = BlockRegistries.GROMBLE_STALK.get().defaultBlockState().setValue(GrombleStalkTop.AGE, 25);
    private static final BlockState TOP_BERRY = GrombleRegistries.GIANT_GROMBLE_BERRY.get().defaultBlockState();
    private static final BlockState TOP_BERRY_ROTTEN = GrombleRegistries.GIANT_ROTTEN_GROMBLE_BERRY.get().defaultBlockState();

    public GrombleStalkFeature(Codec<ProbabilityFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(@Nonnull FeaturePlaceContext<ProbabilityFeatureConfiguration> context) {
        // A number between 0 and 1, higher = more rotten berries
        final float rottenBerryChance = 0f;

        int i = 0;
        final var origin = context.origin();
        var firstPos = origin.mutable();
        final var level = context.level();
        if (level.isEmptyBlock(firstPos)) {
            if (BlockRegistries.GROMBLE_STALK_PLANT.get().defaultBlockState().canSurvive(level, firstPos)) {
                int j = context.random().nextInt(12) + 5;

                for (int l1 = 0; l1 < j && level.isEmptyBlock(firstPos); l1++) {
                    level.setBlock(firstPos, STALK_TRUNK, 2);
                    firstPos.move(Direction.UP, 1);
                }

                if (firstPos.getY() - origin.getY() >= 3) {
                    level.setBlock(firstPos.move(Direction.DOWN, 1), TOP_STALK, 1);
                    if (level.isEmptyBlock(firstPos.above())) {
                        level.setBlock(firstPos.move(Direction.UP, 1),
                                context.random().nextInt() > rottenBerryChance ? TOP_BERRY : TOP_BERRY_ROTTEN, 1);
                    }
                }
            }

            i++;
        }

        return i > 0;
    }
}
