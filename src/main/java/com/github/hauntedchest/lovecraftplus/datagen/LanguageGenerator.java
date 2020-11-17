package com.github.hauntedchest.lovecraftplus.datagen;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.registries.BiomeRegistries;
import com.github.hauntedchest.lovecraftplus.registries.BlockRegistries;
import com.github.hauntedchest.lovecraftplus.registries.EntityTypeRegistries;
import com.github.hauntedchest.lovecraftplus.registries.ItemRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.lang3.tuple.Pair;

public abstract class LanguageGenerator extends LanguageProvider {
    private LanguageGenerator(DataGenerator gen, String locale) {
        super(gen, LovecraftPlus.MOD_ID, locale);
    }

    public static class English extends LanguageGenerator {
        public English(DataGenerator generator) {
            super(generator, "en_us");
        }

        @Override
        protected void addTranslations() {
            // Creative tabs
            add("itemGroup.item_tab", "Lovecraft Materials");
            add("itemGroup.block_tab", "Lovecraft Blocks");

            ItemRegistries.ITEMS
                    .getEntries()
                    .stream()
                    .map(it -> Pair.of(it.get(), it.getId().getPath()))
                    .forEach(itemToIdPair -> {
                        Item item = itemToIdPair.getLeft();
                        // icky hardcoded if statement, but don't want to change the registry name
                        if (item == ItemRegistries.PAGE_NECRONOMICON.get()) {
                            this.add(item, "Undecipherable Page");
                        } else if (item == ItemRegistries.BUNDLE_NECRONOMICON.get()) {
                            this.add(item, "Corrupted Bundle of Knowledge");
                        } else {
                            this.add(item, WordUtils.capitalizeFully(itemToIdPair.getRight().replace("_", " ")));
                        }
                    });

            BlockRegistries.BLOCKS
                    .getEntries()
                    .stream()
                    .map(it -> Pair.of(it.get(), it.getId().getPath()))
                    .forEach(blockToIdPair -> this.add(
                            blockToIdPair.getLeft(),
                            WordUtils.capitalizeFully(blockToIdPair.getRight().replace("_", " "))
                    ));

            EntityTypeRegistries.ENTITY_TYPES
                    .getEntries()
                    .stream()
                    .map(it -> Pair.of(it.get(), it.getId().getPath()))
                    .forEach(entityTypeToIdPair -> this.add(
                            entityTypeToIdPair.getLeft(),
                            WordUtils.capitalizeFully(entityTypeToIdPair.getRight().replace("_", " "))
                    ));

            BiomeRegistries.BIOMES
                    .getEntries()
                    .stream()
                    .map(it -> Pair.of(it.get(), it.getId().getPath()))
                    .forEach(biomeToIdPair -> this.add(
                            biomeToIdPair.getLeft(),
                            WordUtils.capitalizeFully(biomeToIdPair.getRight().replace("_", " "))
                    ));
        }
    }
}
