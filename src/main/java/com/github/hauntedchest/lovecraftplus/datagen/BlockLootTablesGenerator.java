package com.github.hauntedchest.lovecraftplus.datagen;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.registries.BlockRegistries;
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

        loot.dropSelf(BlockRegistries.MOONCALITE.get());

        loot.dropSlabs(BlockRegistries.MOONCALITE_SLAB.get());

        loot.dropSelf(BlockRegistries.MOONCALITE_STAIRS.get());

        loot.addLoot(
                BlockRegistries.MOON_LEAVES.get(),
                BlockLootTables.droppingWithChancesSticksAndApples(
                        BlockRegistries.MOON_LEAVES.get(),
                        BlockRegistries.MOON_SAPLING.get(),
                        BlockLootTables.DEFAULT_SAPLING_DROP_RATES
                )
        );

        loot.dropSelf(BlockRegistries.MOON_LOG.get());

        loot.dropSelf(BlockRegistries.MOON_PLANKS.get());

        loot.dropSelf(BlockRegistries.MOON_SAPLING.get());

        loot.dropSelf(BlockRegistries.MOONSTONE.get());

        loot.dropSlabs(BlockRegistries.MOONSTONE_SLAB.get());

        loot.dropSelf(BlockRegistries.MOONSTONE_STAIRS.get());

        loot.dropSelf(BlockRegistries.MOONSTONE_BRICKS.get());

        loot.dropSlabs(BlockRegistries.MOONSTONE_BRICK_SLAB.get());

        loot.dropSelf(BlockRegistries.MOONSTONE_BRICK_STAIRS.get());

        loot.dropSelf(BlockRegistries.SMOOTH_MOONSTONE.get());

        loot.dropSlabs(BlockRegistries.SMOOTH_MOONSTONE_SLAB.get());

        loot.dropSelf(BlockRegistries.SMOOTH_MOONSTONE_STAIRS.get());

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
                LovecraftPlus.LOGGER.error("couldn't write loot table" + path, e);
            }
        });
    }

    @Override
    public String getName() {
        return "Block Loot Tables";
    }
}
