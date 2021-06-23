package com.crypticcosmos.crypticcosmos.util;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.register.EffectRegistries;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;

public abstract class LanguageGenerator {
    public static class English extends LanguageGenerator {
        public static void addTranslations() {
            // Biomes
            getRegistrate().addLang("biome", CrypticCosmos.id("umbral_dunes"), "Umbral Dunes");
            getRegistrate().addLang("biome", CrypticCosmos.id("kafsinian_forest"), "Kafsinian Forest");
            getRegistrate().addLang("biome", CrypticCosmos.id("acerbic_isles"), "Acerbic Isles");
            getRegistrate().addLang("biome", CrypticCosmos.id("lunaran_plains"), "Lunaran Plains");

            // Effects
            getRegistrate().addLang("effect", EffectRegistries.CORRUPTION.getId(), "Corruption");
            getRegistrate().addLang("effect", EffectRegistries.PURIFICATION.getId(), "Purification");
            getRegistrate().addLang("effect", EffectRegistries.EFFLUVIUM.getId(), "Effluvium");

            // Death messages
            getRegistrate().addRawLang("death.attack.corruption", "%1$s inhaled the spores");
            getRegistrate().addRawLang("death.attack.corruption.player", "%1$s inhaled the spores whilst fighting %2$s");

            // Commands
            getRegistrate().addRawLang("commands.rift.success", "%1$s rifted away to %2$s");

            // Potions
            getRegistrate().addRawLang("item.minecraft.potion.effect.corruption", "Potion of Corruption");
            getRegistrate().addRawLang("item.minecraft.splash_potion.effect.corruption", "Splash Potion of Corruption");
            getRegistrate().addRawLang("item.minecraft.lingering_potion.effect.corruption", "Lingering Potion of Corruption");
            getRegistrate().addRawLang("item.minecraft.tipped_arrow.effect.corruption", "Tipped Arrow of Corruption");

            getRegistrate().addRawLang("item.minecraft.potion.effect.purification", "Potion of Purification");
            getRegistrate().addRawLang("item.minecraft.splash_potion.effect.purification", "Splash Potion of Purification");
            getRegistrate().addRawLang("item.minecraft.lingering_potion.effect.purification", "Lingering Potion of Purification");
            getRegistrate().addRawLang("item.minecraft.tipped_arrow.effect.purification", "Tipped Arrow of Purification");

            getRegistrate().addRawLang("item.minecraft.potion.effect.effluvium", "Potion of Effluvium");
            getRegistrate().addRawLang("item.minecraft.splash_potion.effect.effluvium", "Splash Potion of Effluvium");
            getRegistrate().addRawLang("item.minecraft.lingering_potion.effect.effluvium", "Lingering Potion of Effluvium");
            getRegistrate().addRawLang("item.minecraft.tipped_arrow.effect.effluvium", "Tipped Arrow of Effluvium");
        }
    }
}
