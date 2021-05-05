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
        tag(BlockTags.LEAVES).add(MONDROVE_LEAVES.get(), OSMINSTEM_CAP.get());
        tag(BlockTags.LOGS).add(MONDROVE_LOG.get());
        tag(BlockTags.PLANKS).add(MONDROVE_PLANKS.get());
        tag(BlockTags.SAPLINGS).add(MONDROVE_SAPLING.get(), STINKY_OSMIN.get());

        tag(TagRegistries.LUNARA_PLANTABLE)
                .add(LUNON.get(), OVERGROWN_LUNON.get(), FUNGAL_LUNON.get());

        tag(TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
                .add(MONDROVE_FUNGUS_BLOCK.get(), MONDROVE_FUNGUS_SPORE_BLOCK.get())
                .addTag(TagRegistries.LUNARA_PLANTABLE);

        tag(TagRegistries.MONDROVE_LOGS).add(
                MONDROVE_LOG.get(),
                MONDROVE_WOOD.get(),
                STRIPPED_MONDROVE_LOG.get(),
                STRIPPED_MONDROVE_WOOD.get()
        );

        tag(TagRegistries.OSMINSTEM_LOGS).add(
                OSMINSTEM_LOG.get(),
                OSMINSTEM_WOOD.get(),
                STRIPPED_OSMINSTEM_LOG.get(),
                STRIPPED_OSMINSTEM_WOOD.get(),
                OSMINSTEM_POROUS_LOG.get()
        );

        // this makes sure the mondrove trees generate correctly
        tag(Tags.Blocks.DIRT).addTag(TagRegistries.MONDROVE_FUNGUS_PLANTABLE);
    }
}
