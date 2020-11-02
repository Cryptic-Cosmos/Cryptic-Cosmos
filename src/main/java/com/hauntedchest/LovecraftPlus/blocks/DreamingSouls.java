package com.hauntedchest.LovecraftPlus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DreamingSouls extends Block {
    public DreamingSouls() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(50.0F, 1200.0F)
                .sound(SoundType.STONE)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
