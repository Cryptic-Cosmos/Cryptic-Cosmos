package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlockHelper;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.Random;

import static com.crypticcosmos.crypticcosmos.register.GrombleRegistries.GIANT_GROMBLE_BERRY;
import static com.crypticcosmos.crypticcosmos.register.TagRegistries.GIANT_GROMBLE_BERRIES;

public class GrombleStalkTop extends AbstractTopPlantBlock {
    public static final VoxelShape SHAPE = box(4.0D, 0.0D, 4.0D, 12.0D, 15.0D, 12.0D);

    public GrombleStalkTop(Properties p) {
        super(p, Direction.UP, SHAPE, false, 0.1D);
    }

    public int getBlocksToGrowWhenBonemealed(@Nonnull Random random) {
        return PlantBlockHelper.getBlocksToGrowWhenBonemealed(random);
    }

    @Nonnull
    protected Block getBodyBlock() {
        return BlockRegistries.GROMBLE_STALK_PLANT.get();
    }

    protected boolean canGrowInto(@Nonnull BlockState state) {
        return PlantBlockHelper.isValidGrowthState(state);
    }

    @Override
    public boolean isRandomlyTicking(@Nonnull BlockState state) {
        return true;
    }

    @Override
    public void randomTick(@Nonnull BlockState state,
                           @Nonnull ServerWorld world,
                           @Nonnull BlockPos pos,
                           @Nonnull Random random) {
        super.randomTick(state, world, pos, random);

        // if the stalk is at age 25 (the last one) and doesn't already have a berry on top, place one
        if (state.getValue(AGE) >= 25 && !world.getBlockState(pos.above()).getBlock().is(GIANT_GROMBLE_BERRIES)) {
            world.setBlockAndUpdate(pos.above(), GIANT_GROMBLE_BERRY.get().defaultBlockState());
        }
    }
}
