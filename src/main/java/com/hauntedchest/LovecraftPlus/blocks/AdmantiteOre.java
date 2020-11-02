package com.hauntedchest.LovecraftPlus.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AdmantiteOre extends OreBlock {
    public AdmantiteOre() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(6.0f, 34)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
