package com.github.hauntedchest.lovecraftplus.registries;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.items.CustomSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LovecraftPlus.MOD_ID);

    //Items
    public static final RegistryObject<Item> HUMMING_INGOT = ITEMS.register(
            "humming_ingot",
            () -> new Item(LovecraftPlus.ITEM_GROUP_PROPERTY)
    );

    public static final RegistryObject<Item> NECRONOMICON = ITEMS.register(
            "necronomicon",
            () -> new Item(LovecraftPlus.ITEM_GROUP_PROPERTY)
    );

    public static final RegistryObject<Item> PAGE_NECRONOMICON = ITEMS.register(
            "page_necro",
            () -> new Item(LovecraftPlus.ITEM_GROUP_PROPERTY)
    );

    public static final RegistryObject<Item> BUNDLE_NECRONOMICON = ITEMS.register(
            "bundle_necro",
            () -> new Item(LovecraftPlus.ITEM_GROUP_PROPERTY)
    );

    public static final RegistryObject<Item> CRATERED_BONE = ITEMS.register(
            "cratered_bone",
            () -> new Item(LovecraftPlus.ITEM_GROUP_PROPERTY)
    );

    public static final RegistryObject<Item> MOON_BEAST_SPAWN_EGG = ITEMS.register(
            "moon_beast_spawn_egg",
            () -> new CustomSpawnEggItem(
                    EntityTypeRegistries.MOON_BEAST::get,
                    0x616a65,
                    0x800000,
                    LovecraftPlus.ITEM_GROUP_PROPERTY
            )
    );

    public static final RegistryObject<Item> MOON_FROG_SPAWN_EGG = ITEMS.register(
            "moon_frog_spawn_egg",
            () -> new CustomSpawnEggItem(
                    EntityTypeRegistries.MOON_FROG::get,
                    0x003dff,
                    0x1a1a1b,
                    LovecraftPlus.ITEM_GROUP_PROPERTY
            )
    );
}
