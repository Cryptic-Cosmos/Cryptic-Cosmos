package com.crypticcosmos.crypticcosmos.blocks;

import com.crypticcosmos.crypticcosmos.registries.DimensionRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public interface Infectable {
    IntegerProperty INFECTION_LEVEL = IntegerProperty.create("infection_level", 0, 2);

    default void infect(ServerWorld world, BlockPos pos) {
        if (world.getDimensionKey() == DimensionRegistries.LUNARA_KEY) {
            BlockState infectedLogState = world.getBlockState(pos);

            if (infectedLogState.get(INFECTION_LEVEL) < 2) {
                world.setBlockState(
                        pos,
                        infectedLogState.with(
                                INFECTION_LEVEL,
                                infectedLogState.get(INFECTION_LEVEL) + 1
                        ),
                        3
                );
            }
        }
    }
}
