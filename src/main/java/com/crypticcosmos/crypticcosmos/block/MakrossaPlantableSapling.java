package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.TagRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class MakrossaPlantableSapling extends SaplingBlock {
    public MakrossaPlantableSapling(AbstractTreeGrower tree, Properties properties) {
        super(tree, properties);
    }

    @Override
    public boolean mayPlaceOn(@Nonnull BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos) {
        return state.is(TagRegistries.MAKROSSA_PLANTABLE);
    }
}
