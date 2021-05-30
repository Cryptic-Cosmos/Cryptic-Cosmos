package com.crypticcosmos.crypticcosmos.util;

import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import com.crypticcosmos.crypticcosmos.register.GrombleRegistries;
import com.crypticcosmos.crypticcosmos.register.ItemRegistries;
import com.crypticcosmos.crypticcosmos.register.PotionRegistries;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.Potions;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nonnull;

public class BrewingRecipes {
    public static void registerBrewingRecipes(@SuppressWarnings("unused") FMLCommonSetupEvent event) {

        addMix(Potions.WATER, BlockRegistries.MONDROVE_FUNGUS.get(), PotionRegistries.CORRUPTION.get());
        addMix(Potions.WATER, GrombleRegistries.GIANT_ROTTEN_GROMBLE_BERRY.get(), PotionRegistries.EFFLUVIUM.get());


        addPotency(PotionRegistries.CORRUPTION.get(), PotionRegistries.STRONG_CORRUPTION.get());
        addTime(PotionRegistries.CORRUPTION.get(), PotionRegistries.LONG_CORRUPTION.get());
        addPotency(PotionRegistries.EFFLUVIUM.get(), PotionRegistries.STRONG_EFFLUVIUM.get());
        addTime(PotionRegistries.EFFLUVIUM.get(), PotionRegistries.LONG_EFFLUVIUM.get());

        addInverted(PotionRegistries.CORRUPTION.get(), PotionRegistries.PURIFICATION.get());
        addInverted(PotionRegistries.STRONG_CORRUPTION.get(), PotionRegistries.PURIFICATION.get());
        addInverted(PotionRegistries.LONG_CORRUPTION.get(), PotionRegistries.PURIFICATION.get());
        addInverted(PotionRegistries.PURIFICATION.get(), PotionRegistries.CORRUPTION.get());
    }

    private static void addMix(@SuppressWarnings("SameParameterValue") Potion input,
                               @Nonnull IItemProvider ingredient,
                               Potion output) {
        PotionBrewing.addMix(input, ingredient.asItem(), output);
    }

    private static void addPotency(Potion input, Potion output) {
        PotionBrewing.addMix(input, ItemRegistries.CRATERED_BONE.get(), output);
    }

    private static void addTime(Potion input, Potion output) {
        PotionBrewing.addMix(input, Items.REDSTONE, output);
    }

    private static void addInverted(Potion input, Potion output) {
        PotionBrewing.addMix(input, Items.FERMENTED_SPIDER_EYE, output);
    }
}
