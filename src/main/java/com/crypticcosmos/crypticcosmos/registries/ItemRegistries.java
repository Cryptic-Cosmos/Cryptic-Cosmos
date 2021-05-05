package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.items.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class ItemRegistries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CrypticCosmos.MOD_ID);

    public static final RegistryObject<Item> CRATERED_BONE = ITEMS.register(
            "cratered_bone",
            () -> new Item(CrypticCosmos.DEFAULT_PROPERTY)
    );

    public static final RegistryObject<Item> MAKROSSA_RAMBLER_SPAWN_EGG = ITEMS.register(
            "makrossa_rambler_spawn_egg",
            () -> new CustomSpawnEggItem(
                    EntityTypeRegistries.MAKROSSA_RAMBLER::get,
                    0x65616a,
                    0x1f1d30,
                    CrypticCosmos.DEFAULT_PROPERTY
            )
    );

    public static final RegistryObject<Item> GROMBLE_FROG_SPAWN_EGG = ITEMS.register(
            "gromble_frog_spawn_egg",
            () -> new CustomSpawnEggItem(
                    EntityTypeRegistries.GROMBLE_FROG::get,
                    0xc26d7d,
                    0x9e427e,
                    CrypticCosmos.DEFAULT_PROPERTY
            )
    );
}
