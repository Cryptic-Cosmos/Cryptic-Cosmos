package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class TagRegistries {
    public static final ITag.INamedTag<Block> LUNARA_PLANTABLE_BLOCKS = BlockTags.createOptional(CrypticCosmos.id("lunara_plantable"));
    public static final ITag.INamedTag<Item> LUNARA_PLANTABLE_ITEMS = ItemTags.createOptional(CrypticCosmos.id("lunara_plantable"));
}