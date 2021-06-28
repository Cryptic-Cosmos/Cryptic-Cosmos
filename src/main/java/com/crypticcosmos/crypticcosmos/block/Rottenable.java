package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.GrombleRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.Random;

import static com.crypticcosmos.crypticcosmos.register.BlockRegistries.GROMBLE_STALK;

public class Rottenable extends Block {
    public Rottenable(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(@Nonnull BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(@Nonnull BlockState state,
                           @Nonnull ServerWorld world,
                           @Nonnull BlockPos pos,
                           @Nonnull Random random) {
        super.randomTick(state, world, pos, random);

        // higher == rarer
        final int rottingChance = 60000;

        final boolean isOnStalk = world.getBlockState(pos.below()).getBlock().is(GROMBLE_STALK.get());

        if (random.nextInt(rottingChance) > 10 && !isOnStalk)
            world.setBlockAndUpdate(pos,
                    GrombleRegistries.GIANT_ROTTEN_GROMBLE_BERRY.get().defaultBlockState());
    }
}
