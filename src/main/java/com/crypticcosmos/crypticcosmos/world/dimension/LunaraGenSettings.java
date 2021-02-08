package com.crypticcosmos.crypticcosmos.world.dimension;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import net.minecraft.world.gen.GenerationSettings;

public class LunaraGenSettings extends GenerationSettings {
    public LunaraGenSettings() {
        this.defaultBlock = BlockRegistries.LUNON.get().getDefaultState();
    }

    @Override
    public int getBedrockFloorHeight() {
        return 0;
    }
}
