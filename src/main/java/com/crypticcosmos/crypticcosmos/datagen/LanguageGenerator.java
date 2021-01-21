package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.BiomeRegistries;
import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.creatures.EntityTypeRegistries;
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
            add("itemGroup.item_tab", "Cryptic Cosmos Materials");
            add("itemGroup.block_tab", "Cryptic Cosmos Blocks");

            // Items
            add(ItemRegistries.HUMMING_INGOT.get(), "Humming Ingot");
            add(ItemRegistries.NECRONOMICON.get(), "Necronomicon");
            add(ItemRegistries.PAGE_NECRONOMICON.get(), "Undecipherable Page");
            add(ItemRegistries.CRATERED_BONE.get(), "Cratered Bone");
            add(ItemRegistries.BUNDLE_NECRONOMICON.get(), "Corrupted Bundle of Knowledge");
            add(ItemRegistries.MOON_BEAST_SPAWN_EGG.get(), "Moon Beast Spawn Egg");
            add(ItemRegistries.MOON_FROG_SPAWN_EGG.get(), "Moon Frog Spawn Egg");

            // Blocks
            add(BlockRegistries.HUMMING_STONE.get(), "Humming Stone");
            add(BlockRegistries.HUMMING_OBSIDIAN.get(), "Humming Obsidian");

            add(BlockRegistries.MOONCALITE.get(), "Mooncalite");
            add(BlockRegistries.MOONCALITE_SLAB.get(), "Mooncalite Slab");
            add(BlockRegistries.MOONCALITE_STAIRS.get(), "Mooncalite Stairs");

            add(BlockRegistries.MOONSTONE.get(), "Moonstone");
            add(BlockRegistries.MOONSTONE_SLAB.get(), "Moonstone Slab");
            add(BlockRegistries.MOONSTONE_STAIRS.get(), "Moonstone Stairs");

            add(BlockRegistries.SMOOTH_MOONSTONE.get(), "Smooth Moonstone");
            add(BlockRegistries.SMOOTH_MOONSTONE_SLAB.get(), "Smooth Moonstone Slab");
            add(BlockRegistries.SMOOTH_MOONSTONE_STAIRS.get(), "Smooth Moonstone Stairs");

            add(BlockRegistries.MOONSTONE_BRICKS.get(), "Moonstone Bricks");
            add(BlockRegistries.MOONSTONE_BRICK_SLAB.get(), "Moonstone Brick Slab");
            add(BlockRegistries.MOONSTONE_BRICK_STAIRS.get(), "Moonstone Brick Stairs");

            add(BlockRegistries.THORN_LOG.get(), "Thorn Log");
            add(BlockRegistries.THORN_PLANKS.get(), "Thorn Planks");
            add(BlockRegistries.THORN_SLAB.get(), "Thorn Slab");
            add(BlockRegistries.THORN_LEAVES.get(), "Thorn Leaves");
            add(BlockRegistries.THORN_SAPLING.get(), "Thorn Sapling");
            add(BlockRegistries.THORN_DOOR.get(), "Thorn Door");

            add(BlockRegistries.MONDROVE_LOG.get(), "Moon Log");
            add(BlockRegistries.MONDROVE_PLANKS.get(), "Moon Planks");
            add(BlockRegistries.MONDROVE_LEAVES.get(), "Moon Leaves");
            add(BlockRegistries.MONDROVE_SAPLING.get(), "Moon Sapling");

            add(BlockRegistries.LAVA_SPONGE.get(), "Lava Sponge");
            add(BlockRegistries.MOLTEN_LAVA_SPONGE.get(), "Molten Lava Sponge");
            add(BlockRegistries.RIFT_BLOCK.get(), "Rift Block");

            add(BlockRegistries.UMBRAL_DUNE.get(), "Umbral Sand");

            // Entities
            add(EntityTypeRegistries.MOON_BEAST.get(), "Moon Beast");
            add(EntityTypeRegistries.MOON_FROG.get(), "Moon Frog");

            // Biomes
            add(BiomeRegistries.THORN_JUNGLE.get(), "Thorn Jungle");
        }
    }
}
