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
            add(ItemRegistries.MAKROSSA_RAMBLER_SPAWN_EGG.get(), "Makrossa Rambler Spawn Egg");
            add(ItemRegistries.GROMBLE_FROG_SPAWN_EGG.get(), "Gromble Frog Spawn Egg");

            // Blocks
            add(BlockRegistries.OVERGROWN_LUNON.get(), "Overgrown Lunon");
            add(BlockRegistries.FUNGAL_LUNON.get(), "Fungal Lunon");

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
            add(BlockRegistries.MONDROVE_WOOD.get(), "Mondrove Wood");
            add(BlockRegistries.STRIPPED_MONDROVE_LOG.get(), "Stripped Mondrove Log");
            add(BlockRegistries.STRIPPED_MONDROVE_WOOD.get(), "Stripped Mondrove Wood");
            add(BlockRegistries.MONDROVE_PLANKS.get(), "Mondrove Planks");
            add(BlockRegistries.MONDROVE_PLANKS_SLAB.get(), "Mondrove Planks Slab");
            add(BlockRegistries.MONDROVE_PLANKS_STAIRS.get(), "Mondrove Planks Stairs");
            add(BlockRegistries.MONDROVE_LEAVES.get(), "Mondrove Leaves");
            add(BlockRegistries.MONDROVE_SAPLING.get(), "Mondrove Sapling");
            add(BlockRegistries.MONDROVE_FUNGUS.get(), "Mondrove Fungus");
            add(BlockRegistries.MONDROVE_FUNGUS_BLOCK.get(), "Mondrove Fungus Block");
            add(BlockRegistries.MONDROVE_FUNGUS_SPORE_BLOCK.get(), "Mondrove Fungus Spore Block");
            add(BlockRegistries.SMOOTH_MONDROVE_FUNGUS.get(), "Smooth Mondrove Fungus");
            add(BlockRegistries.SMOOTH_MONDROVE_BRICKS.get(), "Smooth Mondrove Bricks");
            add(BlockRegistries.OSMINSTEM_CAP.get(), "Osminstem Cap");
            add(BlockRegistries.OSMINSTEM_HIVE.get(), "Osminstem Hive");
            add(BlockRegistries.OSMINSTEM_LOG.get(), "Osminstem Log");
            add(BlockRegistries.OSMINSTEM_POROUS_LOG.get(), "Osminstem Porous Log");
            add(BlockRegistries.OSMINSTEM_WOOD.get(), "Osminstem Wood");
            add(BlockRegistries.STRIPPED_OSMINSTEM_LOG.get(), "Stripped Osminstem Log");
            add(BlockRegistries.STRIPPED_OSMINSTEM_WOOD.get(), "Stripped Osminstem Wood");
            add(BlockRegistries.STINKY_OSMIN.get(), "Stinky Osmin");
            add(BlockRegistries.OSMINSTEM_PLANKS.get(), "Osminstem Planks");
            add(BlockRegistries.OSMINSTEM_DOOR.get(), "Osminstem Door");
            add(BlockRegistries.OSMINSTEM_TRAPDOOR.get(), "Osminstem Trapdoor");
            add(BlockRegistries.MONDROVE_DOOR.get(), "Mondrove Door");
            add(BlockRegistries.MONDROVE_TRAPDOOR.get(), "Mondrove Trapdoor");



            add(BlockRegistries.RIFT_BLOCK.get(), "Rift Block");

            add(BlockRegistries.UMBRAL_DUNE.get(), "Umbral Sand");

            // Entities
            add(EntityTypeRegistries.MAKROSSA_RAMBLER.get(), "Makrossa Rambler");
            add(EntityTypeRegistries.GROMBLE_FROG.get(), "Gromble Frog");

            // Biomes
            add(String.format("biome.%s.umbral_dunes", CrypticCosmos.MOD_ID), "Umbral Dunes");
            add(String.format("biome.%s.kafsinian_forest", CrypticCosmos.MOD_ID), "Kafsinian Forest");
            add(String.format("biome.%s.lunaran_plains", CrypticCosmos.MOD_ID), "Lunaran Plains");
            add(String.format("biome.%s.acerbic_isles", CrypticCosmos.MOD_ID), "Acerbic Isles");

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
