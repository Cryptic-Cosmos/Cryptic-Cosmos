package com.hauntedchest.lovecraftplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Mooncalite extends Block {
    public Mooncalite() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(2.0f, 6)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
