package com.crypticcosmos.crypticcosmos.blocks;

import com.crypticcosmos.crypticcosmos.registries.CrypticCosmosDimensions;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

public interface Infectable {
    IntegerProperty INFECTION_LEVEL = IntegerProperty.create("infection_level", 0, 2);

    default void infect(ServerWorld world, BlockPos pos) {
        if (world.dimension() == CrypticCosmosDimensions.MAKROSSA_KEY) {
            BlockState infectedLogState = world.getBlockState(pos);

            if (infectedLogState.getValue(INFECTION_LEVEL) < 2) {
                world.setBlock(
                        pos,
                        infectedLogState.setValue(
                                INFECTION_LEVEL,
                                infectedLogState.getValue(INFECTION_LEVEL) + 1
                        ),
                        3
                );
            }
        }
    }
}
