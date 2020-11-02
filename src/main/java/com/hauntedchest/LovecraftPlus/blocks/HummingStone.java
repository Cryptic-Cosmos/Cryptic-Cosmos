package com.hauntedchest.LovecraftPlus.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

@SuppressWarnings("NullableProblems")
public class HummingStone extends OreBlock {
    public HummingStone() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(6.0f, 34)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
        );
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return 3;
    }
}
