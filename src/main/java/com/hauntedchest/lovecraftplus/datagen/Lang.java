package com.hauntedchest.lovecraftplus.datagen;

import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import com.hauntedchest.lovecraftplus.registries.BiomeHandler;
import com.hauntedchest.lovecraftplus.registries.BlockHandler;
import com.hauntedchest.lovecraftplus.registries.EntityTypeHandler;
import com.hauntedchest.lovecraftplus.registries.ItemHandler;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public abstract class Lang extends LanguageProvider {
    public Lang(DataGenerator gen, String locale) {
        super(gen, LovecraftPlusMod.MOD_ID, locale);
    }

    static class English extends Lang {
        public English(DataGenerator generator) {
            super(generator, "en_us");
        }

        @Override
        protected void addTranslations() {
            // Creative tabs
            add("itemGroup.item_tab", "Lovecraft Materials");
            add("itemGroup.block_tab", "Lovecraft Blocks");

            // Items
            add(ItemHandler.HUMMING_INGOT.get(), "Humming Ingot");
            add(ItemHandler.NECRONOMICON.get(), "Necronomicon");
            add(ItemHandler.PAGE_NECRONOMICON.get(), "Undecipherable Page");
            add(ItemHandler.BUNDLE_NECRONOMICON.get(), "Corrupted Bundle of Knowledge");
            add(ItemHandler.MOON_BEAST_SPAWN_EGG.get(), "Moon Beast Spawn Egg");

            // Blocks
            add(BlockHandler.HUMMING_STONE.get(), "Humming Stone");
            add(BlockHandler.MOONCALITE.get(), "Mooncalite");
            add(BlockHandler.MOONSTONE.get(), "Moonstone");
            add(BlockHandler.SMOOTH_MOONSTONE.get(), "Smooth Moonstone");
            add(BlockHandler.MOONSTONE_BRICKS.get(), "Moonstone Bricks");
            add(BlockHandler.MOONSTONE_BRICK_SLAB.get(), "Moonstone Brick Slab");
            add(BlockHandler.SMOOTH_MOONSTONE_SLAB.get(), "Smooth Moonstone Slab");
            add(BlockHandler.MOONSTONE_SLAB.get(), "Moonstone Slab");
            add(BlockHandler.THORN_SLAB.get(), "Thorn Slab");
            add(BlockHandler.HUMMING_OBSIDIAN.get(), "Humming Obsidian");
            add(BlockHandler.THORN_LOG.get(), "Thorn Log");
            add(BlockHandler.THORN_PLANKS.get(), "Thorn Planks");
            add(BlockHandler.THORN_LEAVES.get(), "Thorn Leaves");
            add(BlockHandler.THORN_SAPLING.get(), "Thorn Sapling");
            add(BlockHandler.MOON_LOG.get(), "Moon Log");
            add(BlockHandler.MOON_PLANKS.get(), "Moon Planks");
            add(BlockHandler.MOON_LEAVES.get(), "Moon Leaves");
            add(BlockHandler.MOON_SAPLING.get(), "Moon Sapling");
            add(BlockHandler.THORN_DOOR.get(), "Thorn Door");
            add(BlockHandler.LAVA_SPONGE.get(), "Lava Sponge");
            add(BlockHandler.MOLTEN_LAVA_SPONGE.get(), "Molten Lava Sponge");

            // Entities
            add(EntityTypeHandler.MOON_BEAST.get(), "Moon Beast");
            add(EntityTypeHandler.MOON_FROG.get(), "Moon Frog");

            // Biomes
            add(BiomeHandler.THORN_JUNGLE.get(), "Thorn Jungle");
        }
    }
}
