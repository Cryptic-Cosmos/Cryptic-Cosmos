package com.crypticcosmos.crypticcosmos.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class RawMoonBeast extends Item {
    public RawMoonBeast(Properties defaultProperty) {
        super(new Item.Properties()
                .food(new Food.Builder()
                        .nutrition(3)
                        .saturationMod(3f)
                        .effect(new EffectInstance(Effects.UNLUCK,300,10), 3f)
                        .build())



        );
    }
}
