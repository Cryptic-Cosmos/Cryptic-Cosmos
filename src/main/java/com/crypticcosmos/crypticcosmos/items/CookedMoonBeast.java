package com.crypticcosmos.crypticcosmos.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class CookedMoonBeast extends Item {
    public CookedMoonBeast(Properties defaultProperty) {
        super(new Item.Properties()
                .food(new Food.Builder()
                        .nutrition(6)
                        .saturationMod(6f)
                        .build())



        );
    }
}
