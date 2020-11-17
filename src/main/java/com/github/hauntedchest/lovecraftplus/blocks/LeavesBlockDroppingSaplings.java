package com.github.hauntedchest.lovecraftplus.blocks;

import net.minecraft.block.Block;

import java.util.function.Supplier;

public interface LeavesBlockDroppingSaplings {
    Supplier<Block> getSapling();
}
