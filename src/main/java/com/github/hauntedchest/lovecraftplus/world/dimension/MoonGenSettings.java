package com.github.hauntedchest.lovecraftplus.world.dimension;

import com.github.hauntedchest.lovecraftplus.registries.BlockRegistries;
import net.minecraft.world.gen.GenerationSettings;

public class MoonGenSettings extends GenerationSettings {
    public MoonGenSettings() {
        this.defaultBlock = BlockRegistries.MOONSTONE.get().getDefaultState();
    }

    @Override
    public int getBedrockFloorHeight() {
        return 0;
    }
}
