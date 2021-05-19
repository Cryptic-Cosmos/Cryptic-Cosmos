package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.block.InfectableBlock;
import com.crypticcosmos.crypticcosmos.block.LunaraPlantableSapling;
import com.crypticcosmos.crypticcosmos.block.MondroveLog;
import com.crypticcosmos.crypticcosmos.util.RegistrationUtils;
import com.crypticcosmos.crypticcosmos.world.feature.MondroveTree;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.*;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;
import static com.crypticcosmos.crypticcosmos.util.RegistrationUtils.*;
import static com.tterrag.registrate.util.DataIngredient.items;
import static net.minecraft.block.material.Material.WOOD;
import static net.minecraft.block.material.MaterialColor.TERRACOTTA_PURPLE;
import static net.minecraft.data.RecipeProvider.*;
import static net.minecraft.data.loot.BlockLootTables.NORMAL_LEAVES_SAPLING_CHANCES;
import static net.minecraft.data.loot.BlockLootTables.createDoorTable;

@SuppressWarnings("unused")
public class MondroveRegistries {
    public static final Properties MONDROVE_PROPERTIES = Properties.of(WOOD, TERRACOTTA_PURPLE)
            .strength(2.0F)
            .sound(SoundType.WOOD);

    public static final BlockEntry<LunaraPlantableSapling> MONDROVE_SAPLING = getRegistrate().object("mondrove_sapling")
            .block(p -> new LunaraPlantableSapling(new MondroveTree(), p))
            .properties(p -> Properties.copy(Blocks.BIRCH_SAPLING))
            .addLayer(() -> RenderType::cutout)
            .tag(BlockTags.SAPLINGS)
            .blockstate(RegistrationUtils::crossModel)

            .item()
            .model((context, provider) -> provider.generated(context,
                    provider.modLoc("block/" + provider.name(context)))
            )
            .tag(ItemTags.SAPLINGS).build()

            .register();

    public static final BlockEntry<LeavesBlock> MONDROVE_LEAVES = getRegistrate().object("mondrove_leaves")
            .block(p -> Blocks.leaves())
            .addLayer(() -> RenderType::cutout)
            .loot((lootTables, block) -> lootTables.add(block, BlockLootTables.createLeavesDrops(
                    block, MONDROVE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES
            )))
            .tag(BlockTags.LEAVES)
            .blockstate(RegistrationUtils::leavesModel)
            .item().tag(ItemTags.LEAVES).build()
            .register();

    // Mondrove Wood set
    public static final BlockEntry<MondroveLog> MONDROVE_LOG = getRegistrate().object("mondrove_log")
            .block(MondroveLog::new)
            .properties(p -> MONDROVE_PROPERTIES)
            .tag(BlockTags.LOGS, TagRegistries.MONDROVE_LOGS)
            .blockstate((context, provider) -> provider.getVariantBuilder(context.get())
                    .forAllStates(blockState -> mondroveLogModels(blockState, context, provider, false))
            )
            .item().tag(ItemTags.LOGS, TagRegistries.MONDROVE_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<MondroveLog> MONDROVE_WOOD = getRegistrate().object("mondrove_wood")
            .block(MondroveLog::new)
            .properties(p -> MONDROVE_PROPERTIES)
            .recipe((context, provider) -> woodFromLogs(provider, context.get(), MONDROVE_LOG.get()))
            .tag(TagRegistries.MONDROVE_LOGS)
            .blockstate((context, provider) -> provider.getVariantBuilder(context.get())
                    .forAllStates(blockState -> mondroveWoodModels(blockState, context, provider, false)))
            .item().tag(TagRegistries.MONDROVE_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<MondroveLog> STRIPPED_MONDROVE_LOG = getRegistrate().object("stripped_mondrove_log")
            .block(MondroveLog::new)
            .properties(p -> MONDROVE_PROPERTIES)
            .tag(TagRegistries.MONDROVE_LOGS)
            .blockstate((context, provider) -> provider.getVariantBuilder(context.get())
                    .forAllStates(blockState -> mondroveLogModels(blockState, context, provider, true))
            )
            .item().tag(TagRegistries.MONDROVE_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<MondroveLog> STRIPPED_MONDROVE_WOOD = getRegistrate().object("stripped_mondrove_wood")
            .block(MondroveLog::new)
            .properties(p -> MONDROVE_PROPERTIES)
            .tag(TagRegistries.MONDROVE_LOGS)
            .blockstate((context, provider) -> provider.getVariantBuilder(context.get())
                    .forAllStates(blockState -> mondroveWoodModels(blockState, context, provider, true)))
            .item().tag(TagRegistries.MONDROVE_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<InfectableBlock> MONDROVE_PLANKS = getRegistrate().object("mondrove_planks")
            .block(InfectableBlock::new)
            .properties(p -> MONDROVE_PROPERTIES)
            .recipe((context, provider) -> provider.planks(DataIngredient.tag(TagRegistries.MONDROVE_LOGS_ITEMS), context))
            .tag(BlockTags.PLANKS)
            .blockstate((context, provider) -> provider.getVariantBuilder(context.get())
                    .forAllStates(state -> infectableBlockModels(state, context, provider))
            )
            .item().tag(ItemTags.PLANKS).build()
            .register();

    public static final BlockEntry<SlabBlock> MONDROVE_SLAB = getRegistrate().object("mondrove_slab")
            .block(SlabBlock::new)
            .properties(p -> MONDROVE_PROPERTIES)
            .loot((lootTables, block) ->
                    lootTables.add(block, BlockLootTables.createSlabItemTable(block))
            )
            .recipe((context, provider) ->
                    provider.slab(items(MONDROVE_PLANKS), context, "wooden_slab", false)
            )
            .tag(BlockTags.SLABS)
            .blockstate((context, provider) -> provider.slabBlock(context.get(), provider.blockTexture(MONDROVE_PLANKS.get()), provider.blockTexture(MONDROVE_PLANKS.get())))
            .item().tag(ItemTags.WOODEN_SLABS).build()
            .register();

    public static final BlockEntry<StairsBlock> MONDROVE_STAIRS = getRegistrate().object("mondrove_stairs")
            .block(p -> new StairsBlock(() -> MONDROVE_PLANKS.get().defaultBlockState(), p))
            .properties(p -> MONDROVE_PROPERTIES)
            .recipe((context, provider) ->
                    provider.stairs(items(MONDROVE_PLANKS), context, "wooden_stairs", false)
            )
            .tag(BlockTags.WOODEN_STAIRS)
            .blockstate((context, provider) -> provider.stairsBlock(context.get(), provider.blockTexture(MONDROVE_PLANKS.get())))
            .item().tag(ItemTags.WOODEN_STAIRS).build()
            .register();

    public static final BlockEntry<DoorBlock> MONDROVE_DOOR = getRegistrate().object("mondrove_door")
            .block(DoorBlock::new)
            .properties(p -> MONDROVE_PROPERTIES.strength(3f).noOcclusion())
            .addLayer(() -> RenderType::cutout)
            .loot((lootTables, block) -> lootTables.add(block, createDoorTable(block)))
            .recipe((context, provider) -> provider.door(items(MONDROVE_PLANKS), context, "wooden_door"))
            .tag(BlockTags.WOODEN_DOORS)
            .blockstate(RegistrationUtils::doorModel)

            .item()
            .model((context, provider) -> provider.generated(context))
            .tag(ItemTags.WOODEN_DOORS)
            .build()
            .register();

    public static final BlockEntry<TrapDoorBlock> MONDROVE_TRAPDOOR = getRegistrate().object("mondrove_trapdoor")
            .block(TrapDoorBlock::new)
            .properties(p -> Properties.copy(MONDROVE_DOOR.get()))
            .addLayer(() -> RenderType::cutout)
            .recipe((context, provider) ->
                    provider.trapDoor(items(MONDROVE_PLANKS.get()), context, "wooden_trapdoor")
            )
            .tag(BlockTags.WOODEN_TRAPDOORS)
            .blockstate((context, provider) -> provider.trapdoorBlock(context.get(), provider.blockTexture(context.get()), true))

            .item()
            .model((context, provider) -> provider.blockItem(context::getEntry, "_bottom"))
            .tag(ItemTags.WOODEN_TRAPDOORS)
            .build()

            .register();

    public static final BlockEntry<WoodButtonBlock> MONDROVE_BUTTON = getRegistrate().object("mondrove_button")
            .block(WoodButtonBlock::new)
            .properties(p -> MONDROVE_PROPERTIES)
            .recipe((context, provider) -> woodenButton(provider, context.get(), MONDROVE_PLANKS.get()))
            .tag(BlockTags.WOODEN_BUTTONS)
            .blockstate((context, provider) -> RegistrationUtils.buttonModel(context, provider, MONDROVE_PLANKS))

            .item()
            .model((context, provider) -> provider.blockItem(() -> context.get().getBlock(), "_inventory"))
            .tag(ItemTags.WOODEN_BUTTONS)
            .build()

            .register();

    public static final BlockEntry<PressurePlateBlock> MONDROVE_PRESSURE_PLATE = getRegistrate().object("mondrove_pressure_plate")
            .block(p -> new PressurePlateBlock(Sensitivity.EVERYTHING, p))
            .properties(p -> MONDROVE_PROPERTIES)
            .recipe((context, provider) -> woodenPressurePlate(provider, context.get(), MONDROVE_PLANKS.get()))
            .tag(BlockTags.WOODEN_PRESSURE_PLATES)
            .blockstate((context, provider) -> RegistrationUtils.pressurePlateModels(context, provider, MONDROVE_PLANKS))
            .item().tag(ItemTags.WOODEN_PRESSURE_PLATES).build()
            .register();

    public static final BlockEntry<FenceBlock> MONDROVE_FENCE = getRegistrate().object("mondrove_fence")
            .block(FenceBlock::new)
            .properties(p -> MONDROVE_PROPERTIES)
            .recipe((context, provider) -> provider.fence(items(MONDROVE_PLANKS), context, "wooden_fence"))
            .tag(BlockTags.WOODEN_FENCES)
            .blockstate((context, provider) -> provider.fenceBlock(context.get(), provider.blockTexture(MONDROVE_PLANKS.get())))

            .item().tag(ItemTags.WOODEN_FENCES)
            .model((context, provider) -> provider.fenceInventory(context.getId().getPath(),
                    provider.modLoc("block/" + provider.name(MONDROVE_PLANKS))))
            .build()

            .register();

    public static final BlockEntry<FenceGateBlock> MONDROVE_FENCE_GATE = getRegistrate().object("mondrove_fence_gate")
            .block(FenceGateBlock::new)
            .properties(p -> MONDROVE_PROPERTIES)
            .recipe((context, provider) -> provider.fenceGate(items(MONDROVE_PLANKS), context, "wooden_fence_gate"))
            .tag(BlockTags.FENCE_GATES)
            .blockstate((context, provider) -> provider.fenceGateBlock(context.get(), provider.blockTexture(MONDROVE_PLANKS.get())))
            .simpleItem()
            .register();

    public static final ItemEntry<BoatItem> MONDROVE_BOAT = getRegistrate().object("mondrove_boat")
            .item(p -> new BoatItem(BoatEntity.Type.OAK, p))
            .properties(p -> p.stacksTo(1))
            .recipe((context, provider) ->
                    woodenBoat(provider, context.get(), MONDROVE_PLANKS.get())
            )
            .tag(ItemTags.BOATS)
            .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("MondroveRegistries initialized");
    }
}
