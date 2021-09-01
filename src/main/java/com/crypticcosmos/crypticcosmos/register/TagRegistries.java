package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagRegistries {
    public static final Tag.Named<Block> MAKROSSA_PLANTABLE = BlockTags.createOptional(CrypticCosmos.id("makrossa_plantable"));
    public static final Tag.Named<Block> MONDROVE_FUNGUS_PLANTABLE = BlockTags.createOptional(CrypticCosmos.id("mondrove_fungus_plantable"));

    public static final Tag.Named<Block> MONDROVE_LOGS = BlockTags.createOptional(CrypticCosmos.id("mondrove_logs"));
    public static final Tag.Named<Item> MONDROVE_LOGS_ITEMS = ItemTags.createOptional(CrypticCosmos.id("mondrove_logs"));
    public static final Tag.Named<Block> OSMINSTEM_LOGS = BlockTags.createOptional(CrypticCosmos.id("osminstem_logs"));
    public static final Tag.Named<Item> OSMINSTEM_LOGS_ITEMS = ItemTags.createOptional(CrypticCosmos.id("osminstem_logs"));
    public static final Tag.Named<Block> GROMBLE_LOGS = BlockTags.createOptional(CrypticCosmos.id("gromble_logs"));
    public static final Tag.Named<Item> GROMBLE_LOGS_ITEMS = ItemTags.createOptional(CrypticCosmos.id("gromble_logs"));

    public static final Tag.Named<Block> GIANT_GROMBLE_BERRIES = BlockTags.createOptional(CrypticCosmos.id("giant_gromble_berries"));
    public static final Tag.Named<Item> GIANT_GROMBLE_BERRIES_ITEMS = ItemTags.createOptional(CrypticCosmos.id("giant_gromble_berries"));
}