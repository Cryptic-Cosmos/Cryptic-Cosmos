package com.hauntedchest.LovecraftPlus.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MoonHolesBlock extends Block {
    public MoonHolesBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(3.0f, 15)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
