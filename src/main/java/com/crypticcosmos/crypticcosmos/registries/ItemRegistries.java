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

    public static final RegistryObject<MondroveThread> MONDROVE_THREADS = ITEMS.register(
            "mondrove_threads",
            () -> new MondroveThread(CrypticCosmos.DEFAULT_PROPERTY)
    );

    public static final RegistryObject<CrispyMondroveThread> CRISPY_MONDROVE_THREADS = ITEMS.register(
            "crispy_mondrove_thread",
            () -> new CrispyMondroveThread(CrypticCosmos.DEFAULT_PROPERTY)
    );

    public static final RegistryObject<RawMoonBeast> RAW_MOON_BEAST_FLESH = ITEMS.register(
            "raw_moon_beast_flesh",
            () -> new RawMoonBeast(CrypticCosmos.DEFAULT_PROPERTY)
    );

    public static final RegistryObject<CookedMoonBeast> COOKED_MOON_BEAST_FLESH = ITEMS.register(
            "cooked_moon_beast_flesh",
            () -> new CookedMoonBeast(CrypticCosmos.DEFAULT_PROPERTY)
    );

    public static final RegistryObject<Item> MOON_BEAST_SPAWN_EGG = ITEMS.register(
            "moon_beast_spawn_egg",
            () -> new CustomSpawnEggItem(
                    EntityTypeRegistries.MOON_BEAST::get,
                    0x7694969,
                    0x2039088,
                    CrypticCosmos.DEFAULT_PROPERTY
            )
    );

    public static final RegistryObject<Item> MOON_FROG_SPAWN_EGG = ITEMS.register(
            "moon_frog_spawn_egg",
            () -> new CustomSpawnEggItem(
                    EntityTypeRegistries.MOON_FROG::get,
                    0x993333,
                    0x660033,
                    CrypticCosmos.DEFAULT_PROPERTY
            )
    );
}
