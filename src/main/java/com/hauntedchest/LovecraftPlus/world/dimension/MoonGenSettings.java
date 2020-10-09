package com.hauntedchest.LovecraftPlus.world.dimension;

import com.hauntedchest.LovecraftPlus.Inits.BlockHandeler;
import net.minecraft.world.gen.GenerationSettings;

public class MoonGenSettings extends GenerationSettings {

    public MoonGenSettings(){
        this.defaultBlock = BlockHandeler.MOONSTONE.get().getDefaultState();
    }

    public int getBiomeSize() {
        return 4;
    }

    public int getRiverSize() {
        return 2;
    }

    public int getBiomeId() {
        return -1;
    }

    @Override
    public int getBedrockFloorHeight() {
        return 0;
    }
}
