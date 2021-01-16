package com.github.hauntedchest.lovecraftplus.world.dimension;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationSettings;

public class IslandGenSettings extends GenerationSettings {
    public IslandGenSettings() {
        this.defaultBlock = Blocks.GRASS_BLOCK.getDefaultState();
    }

    @Override
    public int getBedrockFloorHeight() {
        return 0;
    }
}
