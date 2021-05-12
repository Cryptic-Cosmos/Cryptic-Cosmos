package com.crypticcosmos.crypticcosmos.blocks;

import com.crypticcosmos.crypticcosmos.registries.TagRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

public class LunaraPlantableSapling extends SaplingBlock {
    public LunaraPlantableSapling(Tree tree, Properties properties) {
        super(tree, properties);
    }

    @Override
    public boolean mayPlaceOn(@Nonnull BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return state.is(TagRegistries.LUNARA_PLANTABLE);
    }
}
