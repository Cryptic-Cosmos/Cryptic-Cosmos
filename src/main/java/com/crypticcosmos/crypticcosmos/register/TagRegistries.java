package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class TagRegistries {
    public static final ITag.INamedTag<Block> MAKROSSA_PLANTABLE = BlockTags.createOptional(CrypticCosmos.id("makrossa_plantable"));
    public static final ITag.INamedTag<Block> MONDROVE_FUNGUS_PLANTABLE = BlockTags.createOptional(CrypticCosmos.id("mondrove_fungus_plantable"));

    public static final ITag.INamedTag<Block> MONDROVE_LOGS = BlockTags.createOptional(CrypticCosmos.id("mondrove_logs"));
    public static final ITag.INamedTag<Item> MONDROVE_LOGS_ITEMS = ItemTags.createOptional(CrypticCosmos.id("mondrove_logs"));
    public static final ITag.INamedTag<Block> OSMINSTEM_LOGS = BlockTags.createOptional(CrypticCosmos.id("osminstem_logs"));
    public static final ITag.INamedTag<Item> OSMINSTEM_LOGS_ITEMS = ItemTags.createOptional(CrypticCosmos.id("osminstem_logs"));
    public static final ITag.INamedTag<Block> GROMBLE_LOGS = BlockTags.createOptional(CrypticCosmos.id("gromble_logs"));
    public static final ITag.INamedTag<Item> GROMBLE_LOGS_ITEMS = ItemTags.createOptional(CrypticCosmos.id("gromble_logs"));

    public static final ITag.INamedTag<Block> GIANT_GROMBLE_BERRIES = BlockTags.createOptional(CrypticCosmos.id("giant_gromble_berries"));
    public static final ITag.INamedTag<Item> GIANT_GROMBLE_BERRIES_ITEMS = ItemTags.createOptional(CrypticCosmos.id("giant_gromble_berries"));
}