package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.TagRegistries;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, CrypticCosmos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.LEAVES).add(BlockRegistries.MONDROVE_LEAVES.get());
        tag(BlockTags.LOGS).add(BlockRegistries.MONDROVE_LOG.get());
        tag(BlockTags.PLANKS).add(BlockRegistries.MONDROVE_PLANKS.get());
        tag(BlockTags.SAPLINGS).add(BlockRegistries.MONDROVE_SAPLING.get());
        // this makes sure the mondrove trees generate correctly
        tag(Tags.Blocks.DIRT).addTag(TagRegistries.LUNARA_PLANTABLE_BLOCKS);
    }
}
