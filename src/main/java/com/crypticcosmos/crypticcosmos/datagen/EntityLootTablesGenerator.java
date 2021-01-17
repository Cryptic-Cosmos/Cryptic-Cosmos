package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.EntityTypeRegistries;
import com.crypticcosmos.crypticcosmos.registries.ItemRegistries;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.LootTableProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.RandomChanceWithLooting;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NullableProblems")
public class EntityLootTablesGenerator extends LootTableProvider {
    private final HashMap<EntityType<?>, LootTable.Builder> TABLES = new HashMap<>();
    private final DataGenerator GENERATOR;
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public EntityLootTablesGenerator(DataGenerator generator) {
        super(generator);
        this.GENERATOR = generator;
    }

    private void addLootTables(EntityLootTablesGenerator loot) {
        loot.addLoot(
                EntityTypeRegistries.MOON_BEAST.get(),
                LootTable.builder()
                        .addLootPool(LootPool.builder()
                                .rolls(ConstantRange.of(1))
                                .addEntry(ItemLootEntry.builder(ItemRegistries.CRATERED_BONE.get()))
                                .acceptCondition(RandomChanceWithLooting
                                        .builder(0.5f, 0.07f)))
        );
    }

    // Add a custom loot table
    private void addLoot(EntityType<?> entity, LootTable.Builder loot) {
        TABLES.put(entity, loot);
    }

    @Override
    public void act(DirectoryCache cache) {
        addLootTables(this);

        HashMap<ResourceLocation, LootTable> namespacedTables = new HashMap<>();

        for (Map.Entry<EntityType<?>, LootTable.Builder> entry : TABLES.entrySet()) {
            namespacedTables.put(
                    entry.getKey().getLootTable(),
                    entry.getValue().setParameterSet(LootParameterSets.ENTITY).build()
            );
        }

        writeLootTables(namespacedTables, cache);
    }

    private void writeLootTables(HashMap<ResourceLocation, LootTable> tables, DirectoryCache cache) {
        Path output = GENERATOR.getOutputFolder();

        tables.forEach((key, table) -> {
            Path path = output.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");

            try {
                IDataProvider.save(GSON, cache, LootTableManager.toJson(table), path);
            } catch (IOException e) {
                CrypticCosmos.LOGGER.error("couldn't write loot table" + path, e);
            }
        });
    }


    @Override
    public String getName() {
        return "Entity Loot Tables";
    }
}
