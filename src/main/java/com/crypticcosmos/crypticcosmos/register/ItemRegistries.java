package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;

@SuppressWarnings("unused")
public class ItemRegistries {
    public static final ItemEntry<Item> CRATERED_BONE = getRegistrate().object("cratered_bone")
            .item(Item::new)
            .register();

    public static final ItemEntry<Item> GROMBLE_BERRY = getRegistrate().object("gromble_berry")
            .item(Item::new)
            .properties(p -> p.food(
                    new Food.Builder()
                            // 10 seconds of Slow Falling 1
                            .effect(() -> new EffectInstance(Effects.SLOW_FALLING, 600, 0), 1)
                            .nutrition(2)
                            .saturationMod(0.1F)
                            // .alwaysEat()
                            .build()
            ))
            .register();

    public static final ItemEntry<Item> ROTTEN_GROMBLE_BERRY = getRegistrate().object("rotten_gromble_berry")
            .item(Item::new)
            .properties(p -> p.food(
                    new Food.Builder()
                            // 5 seconds of Effluvium 1
                            .effect(() -> new EffectInstance(EffectRegistries.EFFLUVIUM.get(), 450, 0), 1)
                            .nutrition(2)
                            .saturationMod(0.1F)
                            // .alwaysEat()
                            .build()
            ))
            .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("ItemRegistries initialized");
    }
}
