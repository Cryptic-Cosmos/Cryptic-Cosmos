package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, CrypticCosmos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags() {
        getOrCreateBuilder(BlockTags.LEAVES).add(BlockRegistries.MONDROVE_LEAVES.get());
        getOrCreateBuilder(BlockTags.LOGS).add(BlockRegistries.MONDROVE_LOG.get());
        getOrCreateBuilder(BlockTags.PLANKS).add(BlockRegistries.MONDROVE_PLANKS.get());
        getOrCreateBuilder(BlockTags.SAPLINGS).add(BlockRegistries.MONDROVE_SAPLING.get());
    }
}
