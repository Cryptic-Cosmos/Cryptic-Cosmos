package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NullableProblems")
public class BlockLootTablesGenerator extends LootTableProvider {
    private final HashMap<Block, LootTable.Builder> TABLES = new HashMap<>();
    private final DataGenerator GENERATOR;
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public BlockLootTablesGenerator(DataGenerator generator) {
        super(generator);
        this.GENERATOR = generator;
    }

    private void addLootTables(BlockLootTablesGenerator loot) {
        loot.dropSelf(BlockRegistries.OVERGROWN_LUNON.get());

        loot.dropSelf(BlockRegistries.MONDROVE_LOG.get());

        loot.dropSelf(BlockRegistries.MONDROVE_WOOD.get());

        loot.dropSelf(BlockRegistries.STRIPPED_MONDROVE_LOG.get());

        loot.dropSelf(BlockRegistries.STRIPPED_MONDROVE_WOOD.get());

        loot.dropSelf(BlockRegistries.MONDROVE_PLANKS.get());

        loot.dropSelf(BlockRegistries.MONDROVE_PLANKS_SLAB.get());

        loot.dropSelf(BlockRegistries.MONDROVE_PLANKS_STAIRS.get());

        loot.dropSelf(BlockRegistries.MONDROVE_SAPLING.get());

        loot.dropSelf(BlockRegistries.MONDROVE_FUNGUS.get());

        loot.dropSelf(BlockRegistries.LUNON.get());

        loot.dropSelf(BlockRegistries.LUNON_DUST.get());

        loot.dropSelf(BlockRegistries.LUNON_BRICKS.get());

        loot.dropSlabs(BlockRegistries.LUNON_BRICK_SLAB.get());

        loot.dropSelf(BlockRegistries.LUNON_BRICK_STAIRS.get());

        loot.dropSelf(BlockRegistries.POLISHED_LUNON.get());

        loot.dropSlabs(BlockRegistries.POLISHED_LUNON_SLAB.get());

        loot.dropSelf(BlockRegistries.CHISELED_POLISHED_LUNON.get());

        loot.dropSelf(BlockRegistries.MOSSY_LUNON.get());

        loot.dropSelf(BlockRegistries.UMBRAL_DUNE.get());
    }

    // Add a custom loot table
    private void addLoot(Block block, LootTable.Builder loot) {
        TABLES.put(block, loot);
    }

    private void dropSelf(Block block) {
        LootPool.Builder pool = LootPool.lootPool()
                .setRolls(ConstantRange.exactly(1))
                .add(ItemLootEntry.lootTableItem(block))
                .when(SurvivesExplosion.survivesExplosion());

        TABLES.put(block, LootTable.lootTable().withPool(pool));
    }

    private void dropSlabs(Block block) {
        LootPool.Builder pool = LootPool.lootPool()
                .setRolls(ConstantRange.exactly(1))
                .add(ItemLootEntry.lootTableItem(block))
                .when(SurvivesExplosion.survivesExplosion())
                .apply(SetCount.setCount(ConstantRange.exactly(2))
                        .when(BlockStateProperty.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder
                                        .properties()
                                        .hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))));

        TABLES.put(block, LootTable.lootTable().withPool(pool));
    }

    @Override
    public void run(DirectoryCache cache) {
        addLootTables(this);

        HashMap<ResourceLocation, LootTable> namespacedTables = new HashMap<>();

        for (Map.Entry<Block, LootTable.Builder> entry : TABLES.entrySet()) {
            namespacedTables.put(
                    entry.getKey().getLootTable(),
                    entry.getValue().setParamSet(LootParameterSets.BLOCK).build()
            );
        }

        writeLootTables(namespacedTables, cache);
    }

    private void writeLootTables(HashMap<ResourceLocation, LootTable> tables, DirectoryCache cache) {
        Path output = GENERATOR.getOutputFolder();

        tables.forEach((key, table) -> {
            Path path = output.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");

            try {
                IDataProvider.save(GSON, cache, LootTableManager.serialize(table), path);
            } catch (IOException e) {
                CrypticCosmos.LOGGER.error("couldn't write loot table" + path, e);
            }
        });
    }

    @Override
    public String getName() {
        return "Block Loot Tables";
    }
}
