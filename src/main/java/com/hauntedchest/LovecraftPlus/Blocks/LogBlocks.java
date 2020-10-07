package com.hauntedchest.LovecraftPlus.Blocks;

import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class LogBlocks extends LogBlock {
    public LogBlocks() {
        super(MaterialColor.WOOD, Properties.create(Material.WOOD)
                        .hardnessAndResistance(1.0F, 1.0F)
                        .sound(SoundType.WOOD)
                        .harvestLevel(0)
                        .harvestTool(ToolType.AXE)
        );

        ;
    }
}
