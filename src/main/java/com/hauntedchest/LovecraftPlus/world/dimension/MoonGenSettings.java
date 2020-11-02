package com.hauntedchest.LovecraftPlus.world.dimension;

import com.hauntedchest.LovecraftPlus.registries.BlockHandler;
import net.minecraft.world.gen.GenerationSettings;

public class MoonGenSettings extends GenerationSettings {
    private final int field_202212_j = 4;
    private final int field_202213_k = 4;
    private final int field_202214_l = -1;
    private final int field_202215_m = 63;

    public MoonGenSettings(){
        this.defaultBlock = BlockHandler.MOONSTONE.get().getDefaultState();
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
