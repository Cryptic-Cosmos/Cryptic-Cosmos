package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.TagRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

public class MakrossaPlantableBush extends BushBlock {
    public MakrossaPlantableBush(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return state.is(TagRegistries.MAKROSSA_PLANTABLE);
    }
}
