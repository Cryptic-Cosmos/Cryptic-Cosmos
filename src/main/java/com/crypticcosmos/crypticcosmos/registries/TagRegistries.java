package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class TagRegistries {
    public static final ITag.INamedTag<Block> MOON_PLANTS_GROUND_BLOCKS = BlockTags.createOptional(CrypticCosmos.id("moon_plantable"));
    public static final ITag.INamedTag<Item> MOON_PLANTS_GROUND_ITEMS = ItemTags.createOptional(CrypticCosmos.id("moon_plantable"));
}