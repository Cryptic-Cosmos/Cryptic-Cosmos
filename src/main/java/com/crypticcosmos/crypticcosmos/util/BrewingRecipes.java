package com.crypticcosmos.crypticcosmos.util;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.Potions;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.BlockRegistries.MONDROVE_FUNGUS;
import static com.crypticcosmos.crypticcosmos.register.ItemRegistries.GROMBLE_BERRY;
import static com.crypticcosmos.crypticcosmos.register.ItemRegistries.ROTTEN_GROMBLE_BERRY;
import static com.crypticcosmos.crypticcosmos.register.PotionRegistries.*;
import static net.minecraft.potion.Potions.SLOW_FALLING;

@SuppressWarnings("SameParameterValue")
public class BrewingRecipes {
    public static void registerBrewingRecipes(@SuppressWarnings("unused") FMLCommonSetupEvent event) {
        addMix(Potions.WATER, MONDROVE_FUNGUS, CORRUPTION);
        addMix(Potions.WATER, GROMBLE_BERRY, SLOW_FALLING);
        addMix(Potions.WATER, ROTTEN_GROMBLE_BERRY, EFFLUVIUM);

        addPotency(CORRUPTION, STRONG_CORRUPTION);
        addTime(CORRUPTION, LONG_CORRUPTION);
        addPotency(EFFLUVIUM, STRONG_EFFLUVIUM);
        addTime(EFFLUVIUM, LONG_EFFLUVIUM);

        addInverted(CORRUPTION, PURIFICATION);
        addInverted(STRONG_CORRUPTION, PURIFICATION);
        addInverted(LONG_CORRUPTION, PURIFICATION);
        addInverted(PURIFICATION, CORRUPTION);
    }

    private static void addMix(Potion input,
                               @Nonnull ItemEntry<? extends Item> item,
                               RegistryObject<Potion> output) {
        PotionBrewing.addMix(input, item.get().asItem(), output.get());
    }

    private static void addMix(@SuppressWarnings("SameParameterValue") Potion input,
                               @Nonnull BlockEntry<? extends Block> block,
                               RegistryObject<Potion> output) {
        PotionBrewing.addMix(input, block.get().asItem(), output.get());
    }

    private static void addMix(@SuppressWarnings("SameParameterValue") Potion input,
                               @Nonnull ItemEntry<? extends Item> item,
                               Potion output) {
        PotionBrewing.addMix(input, item.get().asItem(), output);
    }

    private static void addPotency(RegistryObject<Potion> input, RegistryObject<Potion> output) {
        PotionBrewing.addMix(input.get(), Items.GLOWSTONE_DUST, output.get());
    }

    private static void addTime(RegistryObject<Potion> input, RegistryObject<Potion> output) {
        PotionBrewing.addMix(input.get(), Items.REDSTONE, output.get());
    }

    private static void addInverted(RegistryObject<Potion> input, RegistryObject<Potion> output) {
        PotionBrewing.addMix(input.get(), Items.FERMENTED_SPIDER_EYE, output.get());
    }
}
