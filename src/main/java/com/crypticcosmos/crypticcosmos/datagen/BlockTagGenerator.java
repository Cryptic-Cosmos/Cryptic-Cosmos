package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.TagRegistries;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

import static com.crypticcosmos.crypticcosmos.registries.BlockRegistries.*;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, CrypticCosmos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(BlockTags.LEAVES).add(MONDROVE_LEAVES.get());
        tag(BlockTags.LOGS).add(MONDROVE_LOG.get());
        tag(BlockTags.PLANKS).add(MONDROVE_PLANKS.get());
        tag(BlockTags.SAPLINGS).add(MONDROVE_SAPLING.get());
        // this makes sure the mondrove trees generate correctly
        tag(Tags.Blocks.DIRT).addTag(TagRegistries.MONDROVE_PLANTABLE_BLOCKS);
    }
}
