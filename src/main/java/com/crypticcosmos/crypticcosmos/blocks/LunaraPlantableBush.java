package com.crypticcosmos.crypticcosmos.blocks;

import com.crypticcosmos.crypticcosmos.registries.TagRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

public class LunaraPlantableBush extends BushBlock {
    public LunaraPlantableBush(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return state.is(TagRegistries.LUNARA_PLANTABLE);
    }
}
