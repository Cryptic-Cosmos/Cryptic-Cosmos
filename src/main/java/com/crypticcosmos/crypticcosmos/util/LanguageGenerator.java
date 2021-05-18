package com.crypticcosmos.crypticcosmos.util;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.register.EffectRegistries;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.registrate;

public abstract class LanguageGenerator {
    public static class English extends LanguageGenerator {
        public static void addTranslations() {
            // Biomes
            registrate.get().addLang("biome", CrypticCosmos.id("umbral_dunes"), "Umbral Dunes");
            registrate.get().addLang("biome", CrypticCosmos.id("kafsinian_forest"), "Kafsinian Forest");
            registrate.get().addLang("biome", CrypticCosmos.id("acerbic_isles"), "Acerbic Isles");
            registrate.get().addLang("biome", CrypticCosmos.id("lunaran_plains"), "Lunaran Plains");

            // Effects
            registrate.get().addLang("effect", EffectRegistries.CORRUPTION.getId(), "Corruption");
            registrate.get().addLang("effect", EffectRegistries.PURIFICATION.getId(), "Purification");

            // Death messages
            registrate.get().addRawLang("death.attack.corruption", "%1$s inhaled the spores");
            registrate.get().addRawLang("death.attack.corruption.player", "%1$s inhaled the spores whilst fighting %2$s");

            // Commands
            registrate.get().addRawLang("commands.rift.success", "%1$s rifted away to %2$s");

            // Potions
            registrate.get().addRawLang("item.minecraft.potion.effect.corruption", "Potion of Corruption");
            registrate.get().addRawLang("item.minecraft.splash_potion.effect.corruption", "Splash Potion of Corruption");
            registrate.get().addRawLang("item.minecraft.lingering_potion.effect.corruption", "Lingering Potion of Corruption");
            registrate.get().addRawLang("item.minecraft.tipped_arrow.effect.corruption", "Tipped Arrow of Corruption");

            registrate.get().addRawLang("item.minecraft.potion.effect.purification", "Potion of Purification");
            registrate.get().addRawLang("item.minecraft.splash_potion.effect.purification", "Splash Potion of Purification");
            registrate.get().addRawLang("item.minecraft.lingering_potion.effect.purification", "Lingering Potion of Purification");
            registrate.get().addRawLang("item.minecraft.tipped_arrow.effect.purification", "Tipped Arrow of Purification");
        }
    }
}
