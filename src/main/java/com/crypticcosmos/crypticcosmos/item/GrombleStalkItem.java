package com.crypticcosmos.crypticcosmos.item;

import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class GrombleStalkItem extends BlockItem {
    public GrombleStalkItem(Properties properties, boolean artificial) {
        super(!artificial
                        ? BlockRegistries.GROMBLE_STALK.get()
                        : BlockRegistries.ARTIFICIAL_GROMBLE_STALK.get(),
                properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> type) {
        return 50;
    }
}
