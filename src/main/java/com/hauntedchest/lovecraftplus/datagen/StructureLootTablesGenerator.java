package com.hauntedchest.lovecraftplus.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import com.hauntedchest.lovecraftplus.registries.ItemHandler;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.LootTableProvider;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.functions.SetCount;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

@SuppressWarnings("NullableProblems")
public class StructureLootTablesGenerator extends LootTableProvider {
    private final ResourceLocation MOON_PILLAR_CHEST = new ResourceLocation(LovecraftPlusMod.MOD_ID, "chests/moon_pillar_chest");
    private final HashMap<ResourceLocation, LootTable> TABLES = new HashMap<ResourceLocation, LootTable>() {{
        put(MOON_PILLAR_CHEST,
                LootTable.builder()
                        .addLootPool(LootPool.builder()
                                .rolls(RandomValueRange.of(2f, 4f))
                                .addEntry(ItemLootEntry.builder(ItemHandler.PAGE_NECRONOMICON.get())
                                        .weight(5)
                                        .acceptFunction(SetCount.builder(RandomValueRange.of(1f, 3f))))
                                .addEntry(ItemLootEntry.builder(ItemHandler.MOONCALITE_ITEM.get())
                                        .weight(5)
                                        .acceptFunction(SetCount.builder(RandomValueRange.of(1f, 5f))))
                                .addEntry(ItemLootEntry.builder(ItemHandler.MOONSTONE_ITEM.get())
                                        .weight(15)
                                        .acceptFunction(SetCount.builder(RandomValueRange.of(1f, 3f))))
                                .addEntry(ItemLootEntry.builder(Items.IRON_SWORD).weight(5))
                                .addEntry(ItemLootEntry.builder(Items.IRON_CHESTPLATE).weight(5))
                                .addEntry(ItemLootEntry.builder(Items.IRON_PICKAXE).weight(5))
                                .addEntry(ItemLootEntry.builder(Items.NETHER_WART)
                                        .weight(5)
                                        .acceptFunction(SetCount.builder(RandomValueRange.of(3f, 7f)))
                                )
                                .addEntry(ItemLootEntry.builder(Items.SADDLE).weight(10))
                                .addEntry(ItemLootEntry.builder(ItemHandler.HUMMING_OBSIDIAN_ITEM.get())
                                        .weight(2)
                                        .acceptFunction(SetCount.builder(RandomValueRange.of(2f, 4f)))
                                )
                        ).setParameterSet(LootParameterSets.CHEST).build());
    }};

    private final DataGenerator GENERATOR;
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public StructureLootTablesGenerator(DataGenerator generator) {
        super(generator);
        this.GENERATOR = generator;
    }

    @Override
    public void act(DirectoryCache cache) {
        writeLootTables(TABLES, cache);
    }

    private void writeLootTables(HashMap<ResourceLocation, LootTable> tables, DirectoryCache cache) {
        Path output = GENERATOR.getOutputFolder();

        tables.forEach((key, table) -> {
            Path path = output.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");

            try {
                IDataProvider.save(GSON, cache, LootTableManager.toJson(table), path);
            } catch (IOException e) {
                LovecraftPlusMod.LOGGER.error("couldn't write loot table" + path, e);
            }
        });
    }
}
