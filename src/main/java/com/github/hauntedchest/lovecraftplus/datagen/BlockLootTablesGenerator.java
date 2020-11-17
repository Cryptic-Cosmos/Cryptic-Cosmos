package com.github.hauntedchest.lovecraftplus.datagen;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.blocks.LeavesBlockDroppingSaplings;
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
import net.minecraftforge.fml.RegistryObject;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NullableProblems")
public class BlockLootTablesGenerator extends LootTableProvider {
    private final HashMap<Block, LootTable.Builder> TABLES = new HashMap<>();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private final DataGenerator generator;

    public BlockLootTablesGenerator(DataGenerator generator) {
        super(generator);
        this.generator = generator;
    }

    private void addLootTables() {
        BlockRegistries.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            if (block instanceof SlabBlock) {
                this.addDroppingSlabs(block);
            } else if (block instanceof LeavesBlockDroppingSaplings) {
                this.add(
                        block,
                        BlockLootTables.droppingWithChancesSticksAndApples(
                                block,
                                ((LeavesBlockDroppingSaplings) block).getSapling().get(),
                                BlockLootTables.DEFAULT_SAPLING_DROP_RATES
                        )
                );
            } else {
                this.addDroppingSelf(block);
            }
        });
    }

    // Add a custom loot table
    private void add(Block block, LootTable.Builder loot) {
        TABLES.put(block, loot);
    }

    private void addDroppingSelf(Block block) {
        LootPool.Builder pool = LootPool.builder()
                .rolls(ConstantRange.of(1))
                .addEntry(ItemLootEntry.builder(block))
                .acceptCondition(SurvivesExplosion.builder());

        TABLES.put(block, LootTable.builder().addLootPool(pool));
    }

    private void addDroppingSlabs(Block block) {
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
        this.addLootTables();

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
        Path output = generator.getOutputFolder();

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
