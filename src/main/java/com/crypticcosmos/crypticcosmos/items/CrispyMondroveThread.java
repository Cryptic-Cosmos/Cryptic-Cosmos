package com.crypticcosmos.crypticcosmos.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class CrispyMondroveThread extends Item {
    public CrispyMondroveThread(Properties defaultProperty) {
        super(new Item.Properties()
                .food(new Food.Builder()
                        .nutrition(3)
                        .saturationMod(3f)
                        .build())



        );
    }
}
