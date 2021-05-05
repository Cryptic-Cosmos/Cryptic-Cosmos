package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class TagRegistries {
    public static final ITag.INamedTag<Block> LUNARA_PLANTABLE = BlockTags.createOptional(CrypticCosmos.id("lunara_plantable"));
    public static final ITag.INamedTag<Item> LUNARA_PLANTABLE_ITEMS = ItemTags.createOptional(CrypticCosmos.id("lunara_plantable"));
    public static final ITag.INamedTag<Block> MONDROVE_FUNGUS_PLANTABLE = BlockTags.createOptional(CrypticCosmos.id("mondrove_fungus_plantable"));
    public static final ITag.INamedTag<Item> MONDROVE_FUNGUS_PLANTABLE_ITEMS = ItemTags.createOptional(CrypticCosmos.id("mondrove_fungus_plantable"));

    public static final ITag.INamedTag<Block> MONDROVE_LOGS = BlockTags.createOptional(CrypticCosmos.id("mondrove_logs"));
    public static final ITag.INamedTag<Item> MONDROVE_LOGS_ITEMS = ItemTags.createOptional(CrypticCosmos.id("mondrove_logs"));
    public static final ITag.INamedTag<Block> OSMINSTEM_LOGS = BlockTags.createOptional(CrypticCosmos.id("osminstem_logs"));
    public static final ITag.INamedTag<Item> OSMINSTEM_LOGS_ITEMS = ItemTags.createOptional(CrypticCosmos.id("osminstem_logs"));
}