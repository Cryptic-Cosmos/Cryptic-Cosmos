package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.EffectRegistries;
import com.crypticcosmos.crypticcosmos.registries.EntityTypeRegistries;
import com.crypticcosmos.crypticcosmos.registries.ItemRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public abstract class LanguageGenerator extends LanguageProvider {
    public LanguageGenerator(DataGenerator gen, String locale) {
        super(gen, CrypticCosmos.MOD_ID, locale);
    }

    public static class English extends LanguageGenerator {
        public English(DataGenerator generator) {
            super(generator, "en_us");
        }

        @Override
        protected void addTranslations() {
            // Creative tabs
            add("itemGroup.cryptic_cosmos_tab", "Cryptic Cosmos Materials");

            // Items
            add(ItemRegistries.CRATERED_BONE.get(), "Cratered Bone");
            add(ItemRegistries.MOON_BEAST_SPAWN_EGG.get(), "Moon Beast Spawn Egg");
            add(ItemRegistries.MOON_FROG_SPAWN_EGG.get(), "Moon Frog Spawn Egg");

            // Blocks
            add(BlockRegistries.OVERGROWN_LUNON.get(), "Overgrown Lunon");

            add(BlockRegistries.LUNON.get(), "Lunon");
            add(BlockRegistries.LUNON_DUST.get(), "Lunon Dust");

            add(BlockRegistries.CHISELED_POLISHED_LUNON.get(), "Chiseled Polished Lunon");

            add(BlockRegistries.POLISHED_LUNON.get(), "Polished Lunon");
            add(BlockRegistries.POLISHED_LUNON_SLAB.get(), "Polished Lunon Slab");

            add(BlockRegistries.LUNON_BRICKS.get(), "Lunon Bricks");
            add(BlockRegistries.LUNON_BRICK_SLAB.get(), "Lunon Brick Slab");
            add(BlockRegistries.LUNON_BRICK_STAIRS.get(), "Lunon Brick Stairs");

            add(BlockRegistries.MOSSY_LUNON.get(), "Mossy Lunon");

            add(BlockRegistries.MONDROVE_LOG.get(), "Mondrove Log");
            add(BlockRegistries.MONDROVE_PLANKS.get(), "Mondrove Planks");
            add(BlockRegistries.MONDROVE_LEAVES.get(), "Mondrove Leaves");
            add(BlockRegistries.MONDROVE_SAPLING.get(), "Mondrove Sapling");
            add(BlockRegistries.MONDROVE_FUNGUS.get(), "Mondrove Fungus");

            add(BlockRegistries.RIFT_BLOCK.get(), "Rift Block");

            add(BlockRegistries.UMBRAL_DUNE.get(), "Umbral Sand");

            // Entities
            add(EntityTypeRegistries.MOON_BEAST.get(), "Moon Beast");
            add(EntityTypeRegistries.MOON_FROG.get(), "Moon Frog");

            // Biomes
            add(String.format("biome.%s.thorn_jungle", CrypticCosmos.MOD_ID), "Thorn Jungle");
            add(String.format("biome.%s.lunara_plains", CrypticCosmos.MOD_ID), "Lunara Plains");
            add(String.format("biome.%s.lunara_mountains", CrypticCosmos.MOD_ID), "Lunara Mountains");
            add(String.format("biome.%s.lunara_forest", CrypticCosmos.MOD_ID), "Lunara Forest");
            add(String.format("biome.%s.umbral_dunes", CrypticCosmos.MOD_ID), "Umbral Dunes");

            // Effects
            add(EffectRegistries.CORRUPTION.get(), "Corruption");
            add(EffectRegistries.PURIFICATION.get(), "Purification");

            // Death messages
            add("death.attack.corruption", "%1$s inhaled the spores");
            add("death.attack.corruption.player", "%1$s inhaled the spores whilst fighting %2$s");

            // Commands
            add("commands.rift.success", "%1$s rifted away to %2$s");

            // Potions
            add("item.minecraft.potion.effect.corruption", "Potion of Corruption");
            add("item.minecraft.splash_potion.effect.corruption", "Splash Potion of Corruption");
            add("item.minecraft.lingering_potion.effect.corruption", "Lingering Potion of Corruption");
            add("item.minecraft.tipped_arrow.effect.corruption", "Tipped Arrow of Corruption");

            add("item.minecraft.potion.effect.purification", "Potion of Purification");
            add("item.minecraft.splash_potion.effect.purification", "Splash Potion of Purification");
            add("item.minecraft.lingering_potion.effect.purification", "Lingering Potion of Purification");
            add("item.minecraft.tipped_arrow.effect.purification", "Tipped Arrow of Purification");
        }
    }
}
