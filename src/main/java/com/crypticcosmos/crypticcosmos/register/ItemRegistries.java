package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;

@SuppressWarnings("unused")
public class ItemRegistries {
    public static final ItemEntry<Item> CRATERED_BONE = getRegistrate().object("cratered_bone")
            .item(Item::new)
            .register();

    public static final ItemEntry<Item> GROMBLE_BERRY = getRegistrate().object("gromble_berry")
            .item(Item::new)
            .properties(p -> p.food(
                    new FoodProperties.Builder()
                            // 10 seconds of Slow Falling 1
                            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 0), 1)
                            .nutrition(2)
                            .saturationMod(0.1F)
                            // .alwaysEat()
                            .build()
            ))
            .register();

    public static final ItemEntry<Item> ROTTEN_GROMBLE_BERRY = getRegistrate().object("rotten_gromble_berry")
            .item(Item::new)
            .properties(p -> p.food(
                    new FoodProperties.Builder()
                            // 5 seconds of Effluvium 1
                            .effect(() -> new MobEffectInstance(EffectRegistries.EFFLUVIUM.get(), 450, 0), 1)
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
