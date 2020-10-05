package com.hauntedchest.LovecraftPlus.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class LeaveBlocks extends Block {
    public LeaveBlocks() {
        super(Properties.create(Material.ORGANIC)
                .hardnessAndResistance(0.5F, 1.0F)
                .sound(SoundType.PLANT)
                .variableOpacity()
                .notSolid()
                .harvestLevel(0)
                .harvestTool(ToolType.AXE));
    }
}
