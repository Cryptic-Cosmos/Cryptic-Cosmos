package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.entity.creature.gromble_frog.GrombleFrog;
import com.crypticcosmos.crypticcosmos.entity.creature.gromble_frog.GrombleFrogRender;
import com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher.GrombleSnatcher;
import com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher.GrombleSnatcherRender;
import com.crypticcosmos.crypticcosmos.entity.creature.makrossa_rambler.MakrossaRambler;
import com.crypticcosmos.crypticcosmos.entity.creature.makrossa_rambler.MakrossaRamblerRender;
import com.tterrag.registrate.util.entry.EntityEntry;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;
import static net.minecraft.world.level.storage.loot.LootPool.lootPool;
import static net.minecraft.world.level.storage.loot.LootTable.lootTable;
import static net.minecraft.world.level.storage.loot.entries.LootItem.lootTableItem;
import static net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost;
import static net.minecraft.world.level.storage.loot.providers.number.ConstantValue.exactly;

@SuppressWarnings("unused")
public class EntityTypeRegistries {
    public static final EntityEntry<MakrossaRambler> MAKROSSA_RAMBLER = getRegistrate().object("makrossa_rambler")
            .entity(MakrossaRambler::new, MobCategory.MONSTER)
            .attributes(MakrossaRambler::setCustomAttributes)
            .renderer(() -> MakrossaRamblerRender::new)
            .spawnPlacement(SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules)
            .properties(builder -> builder.sized(3f, 2f))

            .loot((lootTables, entity) -> lootTables.add(entity,
                    lootTable().withPool(lootPool()
                            .setRolls(exactly(1))
                            .add(lootTableItem(ItemRegistries.CRATERED_BONE.get()))
                            .when(randomChanceAndLootingBoost(0.5f, 0.07f)))
            ))

            .spawnEgg(0x65616a, 0x1f1d30).build()
            .register();

    @SuppressWarnings("deprecation")
    public static final EntityEntry<GrombleFrog> GROMBLE_FROG = getRegistrate().object("gromble_frog")
            .entity(GrombleFrog::new, MobCategory.CREATURE)
            .attributes(GrombleFrog::setCustomAttributes)
            .renderer(() -> GrombleFrogRender::new)
            .spawnPlacement(SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules)
            .properties(builder -> builder.sized(1f, 1f))
            .loot((lootTables, entity) -> lootTables.add(entity, lootTable()))
            .spawnEgg(0xc26d7d, 0x9e427e).build()
            .register();

    public static final EntityEntry<GrombleSnatcher> GROMBLE_SNATCHER = getRegistrate().object("gromble_snatcher")
            .entity(GrombleSnatcher::new, MobCategory.CREATURE)
            .attributes(GrombleSnatcher::setCustomAttributes)
            .renderer(() -> GrombleSnatcherRender::new)
            .spawnPlacement(SpawnPlacements.Type.IN_WATER, Heightmap.Types.WORLD_SURFACE, Monster::checkMonsterSpawnRules)
            .properties(builder -> builder.sized(1.7f, 1.7f))
            .loot((lootTables, entity) -> lootTables.add(entity, lootTable()))
            .spawnEgg(0xa6427b, 0x91524c).build()
            .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("EntityTypeRegistries initialized");
    }
}
