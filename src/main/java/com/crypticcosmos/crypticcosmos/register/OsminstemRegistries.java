package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.block.MakrossaPlantableSapling;
import com.crypticcosmos.crypticcosmos.block.OsminstemLog;
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
import net.minecraftforge.client.model.generators.ConfiguredModel;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;
import static com.tterrag.registrate.util.DataIngredient.items;
import static net.minecraft.block.material.Material.WOOD;
import static net.minecraft.block.material.MaterialColor.TERRACOTTA_RED;
import static net.minecraft.data.RecipeProvider.*;
import static net.minecraft.data.loot.BlockLootTables.NORMAL_LEAVES_SAPLING_CHANCES;
import static net.minecraft.data.loot.BlockLootTables.createDoorTable;

@SuppressWarnings("unused")
public class OsminstemRegistries {
    public static final Properties OSMINSTEM_PROPERTIES = Properties.of(WOOD, TERRACOTTA_RED)
            .strength(2.0F)
            .sound(SoundType.WOOD);

    // osminstem blocks
    @SuppressWarnings("SpellCheckingInspection")
    public static final BlockEntry<MakrossaPlantableSapling> STINKY_OSMIN = getRegistrate().object("stinky_osmin")
            .block(p -> new MakrossaPlantableSapling(new OsminstemTree(), p))
            .properties(p -> Properties.copy(Blocks.BIRCH_SAPLING))
            .addLayer(() -> RenderType::cutout)
            .tag(BlockTags.SAPLINGS)
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
            .loot((lootTables, block) -> lootTables.add(block, BlockLootTables.createLeavesDrops(
                    block, STINKY_OSMIN.get(), NORMAL_LEAVES_SAPLING_CHANCES
            )))
            .tag(BlockTags.LEAVES)
            .item().tag(ItemTags.LEAVES).build()
            .register();

    public static final BlockEntry<Block> OSMINSTEM_HIVE = getRegistrate().object("osminstem_hive")
            .block(Block::new)
            .properties(p -> OSMINSTEM_PROPERTIES.strength(1.5f, 6f))
            .simpleItem()
            .register();

    public static final BlockEntry<RotatedPillarBlock> STRIPPED_OSMINSTEM_LOG = getRegistrate().object("stripped_osminstem_log")
            .block(p -> Blocks.log(MaterialColor.CRIMSON_HYPHAE, MaterialColor.CRIMSON_HYPHAE))
            .tag(TagRegistries.OSMINSTEM_LOGS)
            .blockstate((context, provider) -> provider.logBlock(context.get()))
            .item().tag(TagRegistries.OSMINSTEM_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> STRIPPED_OSMINSTEM_WOOD = getRegistrate().object("stripped_osminstem_wood")
            .block(RotatedPillarBlock::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .tag(TagRegistries.OSMINSTEM_LOGS)
            .blockstate((context, provider) -> provider.getVariantBuilder(context.get())
                    .forAllStates(state -> ConfiguredModel.builder().modelFile(
                            provider.models().cubeAll(context.getName(),
                                    provider.blockTexture(STRIPPED_OSMINSTEM_LOG.get()))
                            ).build()
                    ))
            .item().tag(TagRegistries.OSMINSTEM_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<OsminstemLog> OSMINSTEM_LOG = getRegistrate().object("osminstem_log")
            .block(p -> new OsminstemLog(p, STRIPPED_OSMINSTEM_LOG))
            .tag(BlockTags.LOGS, TagRegistries.OSMINSTEM_LOGS)
            .blockstate((context, provider) -> provider.logBlock(context.get()))
            .item().tag(ItemTags.LOGS, TagRegistries.OSMINSTEM_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<OsminstemLog> OSMINSTEM_WOOD = getRegistrate().object("osminstem_wood")
            .block(p -> new OsminstemLog(p, STRIPPED_OSMINSTEM_WOOD))
            .properties(p -> OSMINSTEM_PROPERTIES)
            .recipe((context, provider) -> woodFromLogs(provider, context.get(), OSMINSTEM_LOG.get()))
            .tag(TagRegistries.OSMINSTEM_LOGS)
            .blockstate((context, provider) -> provider.getVariantBuilder(context.get())
                    .forAllStates(state -> ConfiguredModel.builder().modelFile(
                            provider.models().cubeAll(context.getName(),
                                    provider.blockTexture(OSMINSTEM_LOG.get()))
                            ).build()
                    ))
            .item().tag(TagRegistries.OSMINSTEM_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> OSMINSTEM_POROUS_LOG = getRegistrate().object("osminstem_porous_log")
            .block(p -> Blocks.log(MaterialColor.CRIMSON_HYPHAE, MaterialColor.SAND))
            .tag(TagRegistries.OSMINSTEM_LOGS)
            .blockstate((context, provider) -> provider.axisBlock(
                    context.get(),
                    provider.blockTexture(context.get()),
                    RegistrationUtils.blockTexture(OSMINSTEM_LOG, "_top")))
            .item().tag(TagRegistries.OSMINSTEM_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<Block> OSMINSTEM_PLANKS = getRegistrate().object("osminstem_planks")
            .block(Block::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .recipe((context, provider) -> provider.planks(DataIngredient.tag(TagRegistries.OSMINSTEM_LOGS_ITEMS), context))
            .tag(BlockTags.PLANKS)
            .item().tag(ItemTags.PLANKS).build()
            .register();

    public static final BlockEntry<SlabBlock> OSMINSTEM_SLAB = getRegistrate().object("osminstem_slab")
            .block(SlabBlock::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .loot((lootTables, block) -> lootTables.add(block, BlockLootTables.createSlabItemTable(block)))
            .recipe((context, provider) -> provider.slab(items(OSMINSTEM_PLANKS), context, "wooden_slab", false))
            .tag(BlockTags.WOODEN_SLABS)
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
            .recipe((context, provider) ->
                    provider.stairs(items(OSMINSTEM_PLANKS), context, "wooden_stairs", false)
            )
            .tag(BlockTags.WOODEN_STAIRS)
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
            .loot((lootTables, block) -> lootTables.add(block, createDoorTable(block)))
            .recipe((context, provider) -> provider.door(items(OSMINSTEM_PLANKS), context, "wooden_door"))
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
            .recipe((context, provider) -> provider.trapDoor(items(OSMINSTEM_PLANKS), context, "wooden_trapdoor"))
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
            .recipe((context, provider) -> woodenButton(provider, context.get(), OSMINSTEM_PLANKS.get()))
            .tag(BlockTags.WOODEN_BUTTONS)
            .blockstate((context, provider) -> RegistrationUtils.buttonModel(context, provider, OSMINSTEM_PLANKS))

            .item()
            .model((context, provider) -> provider.blockItem(() -> context.get().getBlock(), "_inventory"))
            .tag(ItemTags.WOODEN_BUTTONS)
            .build()

            .register();

    public static final BlockEntry<PressurePlateBlock> OSMINSTEM_PRESSURE_PLATE = getRegistrate().object("osminstem_pressure_plate")
            .block(p -> new PressurePlateBlock(Sensitivity.EVERYTHING, p))
            .properties(p -> OSMINSTEM_PROPERTIES)
            .recipe((context, provider) -> woodenPressurePlate(provider, context.get(), OSMINSTEM_PLANKS.get()))
            .tag(BlockTags.WOODEN_PRESSURE_PLATES)
            .blockstate((context, provider) -> RegistrationUtils.pressurePlateModels(context, provider, OSMINSTEM_PLANKS))
            .item().tag(ItemTags.WOODEN_PRESSURE_PLATES).build()
            .register();

    public static final BlockEntry<FenceBlock> OSMINSTEM_FENCE = getRegistrate().object("osminstem_fence")
            .block(FenceBlock::new)
            .properties(p -> OSMINSTEM_PROPERTIES)
            .recipe((context, provider) -> provider.fence(items(OSMINSTEM_PLANKS), context, "wooden_fence"))
            .tag(BlockTags.WOODEN_FENCES)
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
            .recipe((context, provider) -> provider.fenceGate(items(OSMINSTEM_PLANKS), context, "wooden_fence_gate"))
            .tag(BlockTags.FENCE_GATES)
            .blockstate((context, provider) -> provider.fenceGateBlock(context.get(), provider.blockTexture(OSMINSTEM_PLANKS.get())))
            .simpleItem()
            .register();

    public static final ItemEntry<BoatItem> OSMINSTEM_BOAT = getRegistrate().object("osminstem_boat")
            .item(p -> new BoatItem(BoatEntity.Type.OAK, p))
            .recipe((context, provider) ->
                    woodenBoat(provider, context.get(), OSMINSTEM_PLANKS.get())
            )
            .tag(ItemTags.BOATS)
            .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("OsminstemRegistries initialized");
    }
}