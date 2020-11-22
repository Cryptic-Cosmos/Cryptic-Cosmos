package com.github.hauntedchest.lovecraftplus.blocks;

import com.github.hauntedchest.lovecraftplus.registries.BlockRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class CorruptedVinesword extends FlowerBlock {
    public CorruptedVinesword(Effect effectIn, int effectDuration, Properties properties) {
        super(effectIn, effectDuration, properties);
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();

        return block == Blocks.GRASS_BLOCK
                || block == Blocks.DIRT
                || block == Blocks.COARSE_DIRT
                || block == Blocks.PODZOL
                || block == Blocks.FARMLAND
                || block == BlockRegistries.MOONCALITE.get();
    }
}
