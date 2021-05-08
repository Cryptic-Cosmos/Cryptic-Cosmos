package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.TagRegistries;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

import static com.crypticcosmos.crypticcosmos.registries.BlockRegistries.*;

public class ItemTagGenerator extends ItemTagsProvider {
    public ItemTagGenerator(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, CrypticCosmos.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ItemTags.LEAVES).add(MONDROVE_LEAVES.get().asItem(), OSMINSTEM_CAP.get().asItem());
        tag(ItemTags.LOGS).add(MONDROVE_LOG.get().asItem(), OSMINSTEM_LOG.get().asItem(), GROMBLE_LOG.get().asItem());
        tag(ItemTags.PLANKS).add(MONDROVE_PLANKS.get().asItem(), OSMINSTEM_PLANKS.get().asItem(), GROMBLE_PLANKS.get().asItem());
        tag(ItemTags.SAPLINGS).add(MONDROVE_SAPLING.get().asItem(), STINKY_OSMIN.get().asItem(), GROMBLE_SAPLING.get().asItem());

        tag(TagRegistries.LUNARA_PLANTABLE_ITEMS).add(
                LUNON.get().asItem(),
                OVERGROWN_LUNON.get().asItem(),
                FUNGAL_LUNON.get().asItem(),
                GLUM_LUNON.get().asItem()
        );

        tag(TagRegistries.MONDROVE_FUNGUS_PLANTABLE_ITEMS)
                .add(MONDROVE_FUNGUS_BLOCK.get().asItem(), MONDROVE_FUNGUS_SPORE_BLOCK.get().asItem())
                .addTag(TagRegistries.LUNARA_PLANTABLE_ITEMS);

        tag(TagRegistries.MONDROVE_LOGS_ITEMS).add(
                MONDROVE_LOG.get().asItem(),
                MONDROVE_WOOD.get().asItem(),
                STRIPPED_MONDROVE_LOG.get().asItem(),
                STRIPPED_MONDROVE_WOOD.get().asItem()
        );

        tag(TagRegistries.OSMINSTEM_LOGS_ITEMS).add(
                BlockRegistries.OSMINSTEM_LOG.get().asItem(),
                BlockRegistries.OSMINSTEM_WOOD.get().asItem(),
                BlockRegistries.STRIPPED_OSMINSTEM_LOG.get().asItem(),
                BlockRegistries.STRIPPED_OSMINSTEM_WOOD.get().asItem(),
                BlockRegistries.OSMINSTEM_POROUS_LOG.get().asItem()
        );

        tag(TagRegistries.GROMBLE_LOGS_ITEMS).add(
                BlockRegistries.GROMBLE_LOG.get().asItem(),
                BlockRegistries.GROMBLE_WOOD.get().asItem(),
                BlockRegistries.STRIPPED_GROMBLE_LOG.get().asItem(),
                BlockRegistries.STRIPPED_OSMINSTEM_WOOD.get().asItem(),
                BlockRegistries.OSMINSTEM_POROUS_LOG.get().asItem()
        );
    }
}
