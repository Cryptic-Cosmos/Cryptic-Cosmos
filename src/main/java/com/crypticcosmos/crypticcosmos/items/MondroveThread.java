package com.crypticcosmos.crypticcosmos.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class MondroveThread extends Item {

    public MondroveThread(Properties defaultProperty) {
        super(new Item.Properties()
                .food(new Food.Builder()
                        .nutrition(1)
                        .saturationMod(1f)
                        .build())



        );
    }
}
