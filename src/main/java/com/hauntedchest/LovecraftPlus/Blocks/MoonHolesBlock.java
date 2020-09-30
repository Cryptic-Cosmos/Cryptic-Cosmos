package com.hauntedchest.LovecraftPlus.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MoonHolesBlock extends Block {
    public MoonHolesBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(4.0f, 12)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
