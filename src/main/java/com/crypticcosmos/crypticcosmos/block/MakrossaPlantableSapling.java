package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.TagRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

public class MakrossaPlantableSapling extends SaplingBlock {
    public MakrossaPlantableSapling(Tree tree, Properties properties) {
        super(tree, properties);
    }

    @Override
    public boolean mayPlaceOn(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return state.is(TagRegistries.MAKROSSA_PLANTABLE);
    }
}
