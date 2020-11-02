package com.hauntedchest.LovecraftPlus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class ModLeaves extends Block {
    public ModLeaves() {
        super(Properties.create(Material.ORGANIC)
                .hardnessAndResistance(0.5F, 1.0F)
                .sound(SoundType.PLANT)
                .variableOpacity()
                .notSolid()
                .harvestLevel(0)
                .harvestTool(ToolType.AXE));
    }
}
