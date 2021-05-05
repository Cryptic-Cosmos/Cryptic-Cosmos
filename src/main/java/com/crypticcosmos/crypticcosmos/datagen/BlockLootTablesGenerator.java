package com.crypticcosmos.crypticcosmos.datagen;

import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

import static com.crypticcosmos.crypticcosmos.registries.BlockRegistries.*;

@SuppressWarnings("NullableProblems")
public class BlockLootTablesGenerator extends LootTableProvider {
    private final HashMap<Block, LootTable.Builder> TABLES = new HashMap<>();
    private final DataGenerator GENERATOR;

    public BlockLootTablesGenerator(DataGenerator generator) {
        super(generator);
        this.GENERATOR = generator;
    }

    private void addLootTables(BlockLootTablesGenerator loot) {
        loot.dropSelf(OVERGROWN_LUNON.get());

        loot.dropSelf(MONDROVE_LOG.get());

        loot.dropSelf(MONDROVE_WOOD.get());

        loot.dropSelf(STRIPPED_MONDROVE_LOG.get());

        loot.dropSelf(STRIPPED_MONDROVE_WOOD.get());

        loot.dropSelf(MONDROVE_PLANKS.get());

        loot.dropSelf(MONDROVE_SLAB.get());

        loot.dropSelf(MONDROVE_STAIRS.get());

        loot.dropSelf(MONDROVE_SAPLING.get());

        loot.dropSelf(MONDROVE_FUNGUS_BLOCK.get());

        loot.dropSelf(MONDROVE_FUNGUS_SPORE_BLOCK.get());

        loot.dropSelf(SMOOTH_MONDROVE_FUNGUS_BLOCK.get());

        loot.dropSelf(SMOOTH_MONDROVE_FUNGUS_BRICKS.get());

        loot.dropSelf(MONDROVE_FUNGUS.get());

        loot.dropSelf(OSMINSTEM_CAP.get());

        loot.dropSelf(OSMINSTEM_LOG.get());

        loot.dropSelf(OSMINSTEM_POROUS_LOG.get());

        loot.dropSelf(OSMINSTEM_WOOD.get());

        loot.dropSelf(STRIPPED_OSMINSTEM_WOOD.get());

        loot.dropSelf(STRIPPED_OSMINSTEM_LOG.get());

        loot.dropSelf(OSMINSTEM_PLANKS.get());

        loot.dropSelf(OSMINSTEM_DOOR.get());

        loot.dropSelf(OSMINSTEM_TRAPDOOR.get());

        loot.dropSelf(MONDROVE_DOOR.get());

        loot.dropSelf(MONDROVE_TRAPDOOR.get());

        loot.dropSelf(LUNON.get());

        loot.dropSelf(LUNON_DUST.get());

        loot.dropSelf(LUNON_BRICKS.get());

        loot.dropSlabs(LUNON_BRICK_SLAB.get());

        loot.dropSelf(LUNON_BRICK_STAIRS.get());

        loot.dropSelf(POLISHED_LUNON.get());

        loot.dropSlabs(POLISHED_LUNON_SLAB.get());

        loot.dropSelf(CHISELED_POLISHED_LUNON.get());

        loot.dropSelf(MOSSY_LUNON.get());

        loot.dropSelf(UMBRAL_DUNE.get());
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

        DataGenerators.writeLootTables(GENERATOR, namespacedTables, cache);
    }

    @Override
    public String getName() {
        return "Block Loot Tables";
    }
}
