package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.CrypticCosmosDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public interface Infectable {
    IntegerProperty INFECTION_LEVEL = IntegerProperty.create("infection_level", 0, 2);

    default void infect(ServerLevel world, BlockPos pos) {
        if (world.dimension() == CrypticCosmosDimensions.MAKROSSA_KEY) {
            var infectedLogState = world.getBlockState(pos);

            if (infectedLogState.getBlock() instanceof Infectable &&
                infectedLogState.getValue(INFECTION_LEVEL) < 2) {
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
