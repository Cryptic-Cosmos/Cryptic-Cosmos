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
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.BlockStateProperty;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraft.world.storage.loot.functions.SetCount;

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
        loot.dropSelf(BlockRegistries.HUMMING_OBSIDIAN.get());

        loot.dropSelf(BlockRegistries.HUMMING_STONE.get());

        loot.dropSelf(BlockRegistries.LAVA_SPONGE.get());

        loot.dropSelf(BlockRegistries.MOLTEN_LAVA_SPONGE.get());

        loot.dropSelf(BlockRegistries.OVERGROWN_LUNON.get());

        loot.addLoot(
                BlockRegistries.MONDROVE_LEAVES.get(),
                BlockLootTables.droppingWithChancesSticksAndApples(
                        BlockRegistries.MONDROVE_LEAVES.get(),
                        BlockRegistries.MONDROVE_SAPLING.get(),
                        BlockLootTables.DEFAULT_SAPLING_DROP_RATES
                )
        );

        loot.dropSelf(BlockRegistries.MONDROVE_LOG.get());

        loot.dropSelf(BlockRegistries.MONDROVE_PLANKS.get());

        loot.dropSelf(BlockRegistries.MONDROVE_SAPLING.get());

        loot.dropSelf(BlockRegistries.LUNON.get());

        loot.dropSelf(BlockRegistries.LUNON_BRICKS.get());

        loot.dropSlabs(BlockRegistries.LUNON_BRICK_SLAB.get());

        loot.dropSelf(BlockRegistries.LUNON_BRICK_STAIRS.get());

        loot.dropSelf(BlockRegistries.POLISHED_LUNON.get());

        loot.dropSlabs(BlockRegistries.POLISHED_LUNON_SLAB.get());

        loot.dropSlabs(BlockRegistries.CHISELED_POLISHED_LUNON.get());

        loot.addLoot(
                BlockRegistries.THORN_LEAVES.get(),
                BlockLootTables.droppingWithChancesSticksAndApples(
                        BlockRegistries.THORN_LEAVES.get(),
                        BlockRegistries.THORN_SAPLING.get(),
                        BlockLootTables.DEFAULT_SAPLING_DROP_RATES
                )
        );
        
        loot.dropSelf(BlockRegistries.THORN_LOG.get());

        loot.dropSelf(BlockRegistries.THORN_PLANKS.get());

        loot.dropSelf(BlockRegistries.THORN_SAPLING.get());

        loot.dropSelf(BlockRegistries.UMBRAL_DUNE.get());
    }

    // Add a custom loot table
    private void addLoot(Block block, LootTable.Builder loot) {
        TABLES.put(block, loot);
    }

    private void dropSelf(Block block) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantRange.of(1))
                .addEntry(ItemLootEntry.builder(block))
                .acceptCondition(SurvivesExplosion.builder());

        TABLES.put(block, LootTable.builder().addLootPool(pool));
    }

    private void dropSlabs(Block block) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantRange.of(1))
                .addEntry(ItemLootEntry.builder(block))
                .acceptCondition(SurvivesExplosion.builder())
                .acceptFunction(SetCount.builder(ConstantRange.of(2))
                        .acceptCondition(BlockStateProperty.builder(block)
                                .fromProperties(StatePropertiesPredicate.Builder
                                        .newBuilder()
                                        .withProp(SlabBlock.TYPE, SlabType.DOUBLE))));

        TABLES.put(block, LootTable.builder().addLootPool(pool));
    }

    @Override
    public void act(DirectoryCache cache) {
        addLootTables(this);

        HashMap<ResourceLocation, LootTable> namespacedTables = new HashMap<>();

        for (Map.Entry<Block, LootTable.Builder> entry : TABLES.entrySet()) {
            namespacedTables.put(
                    entry.getKey().getLootTable(),
                    entry.getValue().setParameterSet(LootParameterSets.BLOCK).build()
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
        return "Block Loot Tables";
    }
}
