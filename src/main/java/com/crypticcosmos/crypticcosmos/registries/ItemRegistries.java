package com.crypticcosmos.crypticcosmos.registries;

import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.item.Item;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;

@SuppressWarnings("unused")
public class ItemRegistries {
    public static final ItemEntry<Item> CRATERED_BONE = getRegistrate().object("cratered_bone")
            .item(Item::new)
            .register();
}
