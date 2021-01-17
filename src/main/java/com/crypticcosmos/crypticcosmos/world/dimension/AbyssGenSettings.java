package com.crypticcosmos.crypticcosmos.world.dimension;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import net.minecraft.world.gen.GenerationSettings;

public class AbyssGenSettings extends GenerationSettings {
    public AbyssGenSettings() {
        this.defaultBlock = BlockRegistries.UMBRAL_DUNE.get().getDefaultState();
    }

    @Override
    public int getBedrockFloorHeight() {
        return 0;
    }
}
