package com.crypticcosmos.crypticcosmos.world.feature;

import com.crypticcosmos.crypticcosmos.block.GrombleStalkTop;
import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import com.crypticcosmos.crypticcosmos.register.GrombleRegistries;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import javax.annotation.Nonnull;
import java.util.Random;

public class GrombleStalkFeature extends Feature<ProbabilityConfig> {
    private static final BlockState STALK_TRUNK = BlockRegistries.GROMBLE_STALK_PLANT.get().defaultBlockState();
    private static final BlockState TOP_STALK = BlockRegistries.GROMBLE_STALK.get().defaultBlockState().setValue(GrombleStalkTop.AGE, 25);
    private static final BlockState TOP_BERRY = GrombleRegistries.GIANT_GROMBLE_BERRY.get().defaultBlockState();
    private static final BlockState TOP_BERRY_ROTTEN = GrombleRegistries.GIANT_ROTTEN_GROMBLE_BERRY.get().defaultBlockState();

    public GrombleStalkFeature(Codec<ProbabilityConfig> codec) {
        super(codec);
    }

    public boolean place(@Nonnull ISeedReader seedReader,
                         @Nonnull ChunkGenerator generator,
                         @Nonnull Random random,
                         @Nonnull BlockPos pos,
                         @Nonnull ProbabilityConfig probabilityConfig) {
        // A number between 0 and 1, higher = more rotten berries
        final float rottenBerryChance = 0.1f;

        int i = 0;
        BlockPos.Mutable firstPos = pos.mutable();
        if (seedReader.isEmptyBlock(firstPos)) {
            if (BlockRegistries.GROMBLE_STALK_PLANT.get().defaultBlockState().canSurvive(seedReader, firstPos)) {
                int j = random.nextInt(12) + 5;

                for (int l1 = 0; l1 < j && seedReader.isEmptyBlock(firstPos); l1++) {
                    seedReader.setBlock(firstPos, STALK_TRUNK, 2);
                    firstPos.move(Direction.UP, 1);
                }

                if (firstPos.getY() - pos.getY() >= 3) {
                    seedReader.setBlock(firstPos.move(Direction.DOWN, 1), TOP_STALK, 1);
                    if (seedReader.isEmptyBlock(firstPos.above())) {
                        seedReader.setBlock(firstPos.move(Direction.UP, 1),
                                random.nextInt() > rottenBerryChance ? TOP_BERRY : TOP_BERRY_ROTTEN, 1);
                    }
                }
            }

            i++;
        }

        return i > 0;
    }
}
