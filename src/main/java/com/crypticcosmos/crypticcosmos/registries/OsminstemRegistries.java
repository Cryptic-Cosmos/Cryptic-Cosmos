package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.blocks.LunaraPlantableSapling;
import com.crypticcosmos.crypticcosmos.util.RegistrationUtils;
import com.crypticcosmos.crypticcosmos.world.feature.OsminstemTree;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.*;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.BoatItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;
import static net.minecraft.block.material.Material.WOOD;
import static net.minecraft.block.material.MaterialColor.TERRACOTTA_RED;
import static net.minecraft.data.RecipeProvider.*;
import static net.minecraft.data.loot.BlockLootTables.NORMAL_LEAVES_SAPLING_CHANCES;

public class OsminstemRegistries {
    public static final Properties OSMINSTEM_PROPERTIES = Properties.of(WOOD, TERRACOTTA_RED)
            .strength(2.0F)
            .sound(SoundType.WOOD);

    // osminstem blocks
    @SuppressWarnings("SpellCheckingInspection")
    public static final BlockEntry<LunaraPlantableSapling> STINKY_OSMIN = getRegistrate().object("stinky_osmin")
            .block(p -> new LunaraPlantableSapling(new OsminstemTree(), p))
            .properties(p -> Properties.copy(Blocks.BIRCH_SAPLING))
            .tag(BlockTags.SAPLINGS)
            .addLayer(() -> RenderType::cutout)
            .blockstate(RegistrationUtils::crossModel)

            .item()
            .model((context, provider) -> provider.generated(context,
                    provider.modLoc("block/" + provider.name(context)))
            )
            .tag(ItemTags.SAPLINGS)
            .build()
            .register();

    public static final BlockEntry<Block> OSMINSTEM_CAP = getRegistrate().object("osminstem_cap")
            .block(Block::new)
            .properties(p -> OSMINSTEM_PROPERTIES.strength(0.2f))
            .tag(BlockTags.LEAVES)
            .loot((lootTables, block) -> lootTables.add(block, BlockLootTables.createLeavesDrops(
                    block, Blocks.BIRCH_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES
            )))
            .item().tag(ItemTags.LEAVES).build()
            .register();

    public static final BlockEntry<Block> OSMINSTEM_HIVE = getRegistrate().object("osminstem_hive")
            .block(Block::new)
            .properties(p -> OSMINSTEM_PROPERTIES.strength(1.5f, 6f))
            .simpleItem()
            .register();

    public static final BlockEntry<RotatedPillarBlock> OSMINSTEM_LOG = getRegistrate().object("osminstem_log")
            .block(p -> Blocks.log(MaterialColor.CRIMSON_HYPHAE, MaterialColor.TERRACOTTA_BROWN))
            .tag(BlockTags.LOGS, TagRegistries.OSMINSTEM_LOGS)
            .blockstate((context, provider) -> provider.logBlock(context.get()))
            .item().tag(ItemTags.LOGS, TagRegistries.OSMINSTEM_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> STRIPPED_OSMINSTEM_LOG = getRegistrate().object("stripped_osminstem_log")
            .block(p -> Blocks.log(MaterialColor.CRIMSON_HYPHAE, MaterialColor.CRIMSON_HYPHAE))
            .tag(TagRegistries.OSMINSTEM_LOGS)
            .blockstate((context, provider) -> provider.logBlock(context.get()))
            .item().tag(TagRegistries.OSMINSTEM_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> OSMINSTEM_WOOD = getRegistrate().object("osminstem_wood")
            .block(RotatedPillarBlock::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .tag(TagRegistries.OSMINSTEM_LOGS)
            .recipe((context, provider) -> woodFromLogs(provider, context.get(), OSMINSTEM_LOG.get()))
            .blockstate((context, provider) -> provider.models()
                    .cubeAll(context.getName(), provider.blockTexture(OSMINSTEM_LOG.get()))
            )
            .item().tag(TagRegistries.OSMINSTEM_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> STRIPPED_OSMINSTEM_WOOD = getRegistrate().object("stripped_osminstem_wood")
            .block(RotatedPillarBlock::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .tag(TagRegistries.OSMINSTEM_LOGS)
            .blockstate((context, provider) -> provider.models()
                    .cubeAll(context.getName(), provider.blockTexture(STRIPPED_OSMINSTEM_LOG.get()))
            )
            .item().tag(TagRegistries.OSMINSTEM_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> OSMINSTEM_POROUS_LOG = getRegistrate().object("osminstem_porous_log")
            .block(p -> Blocks.log(MaterialColor.CRIMSON_HYPHAE, MaterialColor.SAND))
            .tag(TagRegistries.OSMINSTEM_LOGS)
            .blockstate((context, provider) -> provider.axisBlock(
                    context.get(),
                    provider.blockTexture(context.get()),
                    RegistrationUtils.blockTexture(OSMINSTEM_LOG.get(), "_top")))
            .item().tag(TagRegistries.OSMINSTEM_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<Block> OSMINSTEM_PLANKS = getRegistrate().object("osminstem_planks")
            .block(Block::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .tag(BlockTags.PLANKS)
            .recipe((context, provider) -> provider.planks(DataIngredient.tag(TagRegistries.OSMINSTEM_LOGS_ITEMS), context))
            .item().tag(ItemTags.PLANKS).build()
            .register();

    public static final BlockEntry<SlabBlock> OSMINSTEM_SLAB = getRegistrate().object("osminstem_slab")
            .block(SlabBlock::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .tag(BlockTags.WOODEN_SLABS)
            .loot((lootTables, block) -> lootTables.add(block, BlockLootTables.createSlabItemTable(block)))
            .recipe((context, provider) -> provider.slab(DataIngredient.items(OSMINSTEM_PLANKS), context, "wooden_slab", false))
            .blockstate((context, provider) -> provider.slabBlock(
                    context.get(),
                    provider.blockTexture(OSMINSTEM_PLANKS.get()),
                    provider.blockTexture(OSMINSTEM_PLANKS.get())
            ))
            .item().tag(ItemTags.WOODEN_SLABS).build()
            .register();

    public static final BlockEntry<StairsBlock> OSMINSTEM_STAIRS = getRegistrate().object("osminstem_stairs")
            .block(p -> new StairsBlock(() -> OSMINSTEM_PLANKS.get().defaultBlockState(), p))
            .properties(p -> OSMINSTEM_PROPERTIES)
            .tag(BlockTags.WOODEN_STAIRS)
            .recipe((context, provider) ->
                    provider.stairs(DataIngredient.items(OSMINSTEM_PLANKS), context, "wooden_stairs", false)
            )
            .blockstate((context, provider) -> provider.stairsBlock(
                    context.get(),
                    provider.blockTexture(OSMINSTEM_PLANKS.get())
            ))
            .item().tag(ItemTags.WOODEN_STAIRS).build()
            .register();

    public static final BlockEntry<DoorBlock> OSMINSTEM_DOOR = getRegistrate().object("osminstem_door")
            .block(DoorBlock::new)
            .properties(p -> OSMINSTEM_PROPERTIES.strength(3f).noOcclusion())
            .addLayer(() -> RenderType::cutout)
            .loot((lootTables, block) ->
                    lootTables.add(block, BlockLootTables.createDoorTable(block))
            )
            .recipe((context, provider) -> provider.door(DataIngredient.items(OSMINSTEM_PLANKS), context, "wooden_door"))
            .tag(BlockTags.WOODEN_DOORS)
            .blockstate(RegistrationUtils::doorModel)

            .item()
            .model((context, provider) -> provider.generated(context))
            .tag(ItemTags.WOODEN_DOORS).build()

            .register();

    public static final BlockEntry<TrapDoorBlock> OSMINSTEM_TRAPDOOR = getRegistrate().object("osminstem_trapdoor")
            .block(TrapDoorBlock::new)
            .properties(p -> Properties.copy(OSMINSTEM_DOOR.get()))
            .addLayer(() -> RenderType::cutout)
            .recipe((context, provider) -> provider.trapDoor(DataIngredient.items(OSMINSTEM_PLANKS), context, "wooden_trapdoor"))
            .tag(BlockTags.WOODEN_TRAPDOORS)
            .blockstate((context, provider) -> provider.trapdoorBlock(context.get(), provider.blockTexture(context.get()), true))

            .item()
            .model((context, provider) -> provider.blockItem(context::getEntry, "_bottom"))
            .tag(ItemTags.WOODEN_TRAPDOORS)
            .build()

            .register();

    public static final BlockEntry<WoodButtonBlock> OSMINSTEM_BUTTON = getRegistrate().object("osminstem_button")
            .block(WoodButtonBlock::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .tag(BlockTags.WOODEN_BUTTONS)
            .recipe((context, provider) -> woodenButton(provider, context.get(), OSMINSTEM_PLANKS.get()))
            .blockstate((context, provider) -> RegistrationUtils.buttonModel(context, provider, OSMINSTEM_PLANKS))

            .item()
            .model((context, provider) -> provider.blockItem(() -> context.get().getBlock(), "_inventory"))
            .tag(ItemTags.WOODEN_BUTTONS)
            .build()

            .register();

    public static final BlockEntry<PressurePlateBlock> OSMINSTEM_PRESSURE_PLATE = getRegistrate().object("osminstem_pressure_plate")
            .block(p -> new PressurePlateBlock(Sensitivity.EVERYTHING, p))
            .properties(p -> OSMINSTEM_PROPERTIES)
            .tag(BlockTags.WOODEN_PRESSURE_PLATES)
            .recipe((context, provider) -> woodenPressurePlate(provider, context.get(), OSMINSTEM_PLANKS.get()))
            .blockstate((context, provider) -> RegistrationUtils.pressurePlateModels(context, provider, OSMINSTEM_PLANKS))
            .item().tag(ItemTags.WOODEN_PRESSURE_PLATES).build()
            .register();

    public static final BlockEntry<FenceBlock> OSMINSTEM_FENCE = getRegistrate().object("osminstem_fence")
            .block(FenceBlock::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .tag(BlockTags.WOODEN_FENCES)
            .recipe((context, provider) -> provider.fence(DataIngredient.items(OSMINSTEM_PLANKS), context, "wooden_fence"))
            .blockstate((context, provider) -> provider.fenceBlock(context.get(), provider.blockTexture(OSMINSTEM_PLANKS.get())))

            .item()
            .tag(ItemTags.WOODEN_FENCES)
            .model((context, provider) -> provider.fenceInventory(context.getId().getPath(),
                    provider.modLoc("block/" + provider.name(OSMINSTEM_PLANKS))))
            .build()

            .register();

    public static final BlockEntry<FenceGateBlock> OSMINSTEM_FENCE_GATE = getRegistrate().object("osminstem_fence_gate")
            .block(FenceGateBlock::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .tag(BlockTags.FENCE_GATES)
            .recipe((context, provider) -> provider.fenceGate(DataIngredient.items(OSMINSTEM_PLANKS), context, "wooden_fence_gate"))
            .blockstate((context, provider) -> provider.fenceGateBlock(context.get(), provider.blockTexture(OSMINSTEM_PLANKS.get())))
            .simpleItem()
            .register();

    public static final ItemEntry<BoatItem> OSMINSTEM_BOAT = getRegistrate().object("osminstem_boat")
            .item(p -> new BoatItem(BoatEntity.Type.OAK, p))
            .tag(ItemTags.BOATS)
            .recipe((context, provider) ->
                    woodenBoat(provider, context.get(), OSMINSTEM_PLANKS.get())
            )
            .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("OsminstemRegistries initialized");
    }
}
