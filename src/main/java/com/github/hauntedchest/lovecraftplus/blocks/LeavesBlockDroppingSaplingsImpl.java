package com.github.hauntedchest.lovecraftplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;

import java.util.function.Supplier;

public class LeavesBlockDroppingSaplingsImpl extends LeavesBlock implements LeavesBlockDroppingSaplings {
    private final Supplier<Block> sapling;

    public LeavesBlockDroppingSaplingsImpl(Properties properties, Supplier<Block> sapling) {
        super(properties);

        this.sapling = sapling;
    }

    @Override
    public Supplier<Block> getSapling() {
        return sapling;
    }
}
