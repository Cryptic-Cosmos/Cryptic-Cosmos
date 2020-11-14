package com.hauntedchest.lovecraftplus.blocks;

import com.hauntedchest.lovecraftplus.registries.DimensionHandler;
import net.minecraft.block.BlockState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;

public interface IInfectable {
    IntegerProperty INFECTION_LEVEL = IntegerProperty.create("infection_level", 0, 2);

    default void infect(ServerWorld world, BlockPos pos) {
        if (world.getDimension().getType() == DimensionType.byName(DimensionHandler.MOON_DIM_TYPE)) {
            BlockState infectedLogState = world.getBlockState(pos);

            if (infectedLogState.get(INFECTION_LEVEL) < 2) {
                world.setBlockState(pos,
                        infectedLogState.with(INFECTION_LEVEL,
                                infectedLogState.get(INFECTION_LEVEL) + 1),
                        3);
            }
        }
    }
}
