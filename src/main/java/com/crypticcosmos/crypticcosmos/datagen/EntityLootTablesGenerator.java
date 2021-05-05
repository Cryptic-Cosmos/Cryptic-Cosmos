package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.registries.EntityTypeRegistries;
import com.crypticcosmos.crypticcosmos.registries.ItemRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.LootTableProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.RandomChanceWithLooting;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NullableProblems")
public class EntityLootTablesGenerator extends LootTableProvider {
    private final HashMap<EntityType<?>, LootTable.Builder> TABLES = new HashMap<>();
    private final DataGenerator GENERATOR;

    public EntityLootTablesGenerator(DataGenerator generator) {
        super(generator);
        this.GENERATOR = generator;
    }

    private void addLootTables(EntityLootTablesGenerator loot) {
        loot.addLoot(
                EntityTypeRegistries.MAKROSSA_RAMBLER.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantRange.exactly(1))
                                .add(ItemLootEntry.lootTableItem(ItemRegistries.CRATERED_BONE.get()))
                                .when(RandomChanceWithLooting.randomChanceAndLootingBoost(0.5f, 0.07f)))
        );
    }

    // Add a custom loot table
    private void addLoot(EntityType<?> entity, LootTable.Builder loot) {
        TABLES.put(entity, loot);
    }

    @Override
    public void run(DirectoryCache cache) {
        addLootTables(this);

        HashMap<ResourceLocation, LootTable> namespacedTables = new HashMap<>();

        for (Map.Entry<EntityType<?>, LootTable.Builder> entry : TABLES.entrySet()) {
            namespacedTables.put(
                    entry.getKey().getDefaultLootTable(),
                    entry.getValue().setParamSet(LootParameterSets.ENTITY).build()
            );
        }

        DataGenerators.writeLootTables(GENERATOR, namespacedTables, cache);
    }

    @Override
    public String getName() {
        return "Entity Loot Tables";
    }
}
