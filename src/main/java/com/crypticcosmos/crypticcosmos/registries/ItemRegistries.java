package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.items.CustomSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CrypticCosmos.MOD_ID);

    //Items
    public static final RegistryObject<Item> HUMMING_INGOT = ITEMS.register(
            "humming_ingot",
            () -> new Item(CrypticCosmos.ITEM_GROUP_PROPERTY)
    );

    public static final RegistryObject<Item> NECRONOMICON = ITEMS.register(
            "necronomicon",
            () -> new Item(CrypticCosmos.ITEM_GROUP_PROPERTY)
    );

    public static final RegistryObject<Item> PAGE_NECRONOMICON = ITEMS.register(
            "page_necro",
            () -> new Item(CrypticCosmos.ITEM_GROUP_PROPERTY)
    );

    public static final RegistryObject<Item> BUNDLE_NECRONOMICON = ITEMS.register(
            "bundle_necro",
            () -> new Item(CrypticCosmos.ITEM_GROUP_PROPERTY)
    );

    public static final RegistryObject<Item> CRATERED_BONE = ITEMS.register(
            "cratered_bone",
            () -> new Item(CrypticCosmos.ITEM_GROUP_PROPERTY)
    );

    public static final RegistryObject<Item> MOON_BEAST_SPAWN_EGG = ITEMS.register(
            "moon_beast_spawn_egg",
            () -> new CustomSpawnEggItem(
                    EntityTypeRegistries.MOON_BEAST::get,
                    0x666666,
                    0x333333,
                    CrypticCosmos.ITEM_GROUP_PROPERTY
            )
    );

    public static final RegistryObject<Item> MOON_FROG_SPAWN_EGG = ITEMS.register(
            "moon_frog_spawn_egg",
            () -> new CustomSpawnEggItem(
                    EntityTypeRegistries.MOON_FROG::get,
                    0x993333,
                    0x660033,
                    CrypticCosmos.ITEM_GROUP_PROPERTY
            )
    );
}
