package com.hauntedchest.LovecraftPlus.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MoonBlock extends Block {
    public MoonBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(2.0f, 10)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
