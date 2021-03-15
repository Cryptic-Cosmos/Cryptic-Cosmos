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
            add(ItemRegistries.TRAPLOOM_SPAWN_EGG.get(), "Traploom Spawn Egg");

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
            add(EntityTypeRegistries.TRAPLOOM.get(), "Traploom");

            // Biomes
            add("biome.crypticcosmos.thorn_jungle", "Thorn Jungle");
            add("biome.crypticcosmos.lunara_plains", "Lunara Plains");
            add("biome.crypticcosmos.lunara_mountains", "Lunara Mountains");
            add("biome.crypticcosmos.lunara_forest", "Lunara Forest");
            add("biome.crypticcosmos.umbral_dunes", "Umbral Dunes");

            // Effects
            add(EffectRegistries.CORRUPTION.get(), "Corruption");

            // Death messages
            add("death.attack.corruption", "%1$s inhaled the spores");
            add("death.attack.corruption.player", "%1$s inhaled the spores whilst fighting %2$s");

            // Commands
            add("commands.rift.success", "%1$s rifted away to %2$s");
        }
    }
}
