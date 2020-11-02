package com.hauntedchest.lovecraftplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MoonStoneBricks extends Block {
    public MoonStoneBricks() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(4.0f, 15)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
