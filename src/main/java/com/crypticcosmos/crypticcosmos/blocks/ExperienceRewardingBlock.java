package com.crypticcosmos.crypticcosmos.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

import javax.annotation.Nonnull;

public class ExperienceRewardingBlock extends OreBlock {
    private final int xpDrop;

    public ExperienceRewardingBlock(Properties properties, int xpDrop) {
        super(properties);

        this.xpDrop = xpDrop;
    }

    @Override
    public int getExpDrop(@Nonnull BlockState state, @Nonnull IWorldReader reader, @Nonnull BlockPos pos, int fortune, int silktouch) {
        return xpDrop;
    }
}
