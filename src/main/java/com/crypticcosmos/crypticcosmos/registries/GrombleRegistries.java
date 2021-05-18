package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.blocks.LunaraPlantableBush;
import com.crypticcosmos.crypticcosmos.blocks.LunaraPlantableSapling;
import com.crypticcosmos.crypticcosmos.util.RegistrationUtils;
import com.crypticcosmos.crypticcosmos.world.feature.GrombleTree;
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
import static net.minecraft.block.material.Material.NETHER_WOOD;
import static net.minecraft.block.material.MaterialColor.TERRACOTTA_LIGHT_BLUE;
import static net.minecraft.data.RecipeProvider.*;
import static net.minecraft.data.loot.BlockLootTables.NORMAL_LEAVES_SAPLING_CHANCES;

public class GrombleRegistries {
    public static final Properties GROMBLE_PROPERTIES = Properties.of(NETHER_WOOD, TERRACOTTA_LIGHT_BLUE)
            .strength(2F)
            .sound(SoundType.STEM);

    //gromble blocks
    public static final BlockEntry<LunaraPlantableSapling> GROMBLE_SAPLING = getRegistrate().object("gromble_sapling")
            .block(p -> new LunaraPlantableSapling(new GrombleTree(), p))
            .properties(p -> Properties.copy(Blocks.BIRCH_SAPLING))
            .tag(BlockTags.SAPLINGS)
            .addLayer(() -> RenderType::cutout)
            .blockstate(RegistrationUtils::crossModel)

            .item()
            .model((context, provider) -> provider.generated(context,
                    provider.modLoc("block/" + provider.name(context)))
            )
            .tag(ItemTags.SAPLINGS).build()

            .register();

    public static final BlockEntry<LunaraPlantableBush> GIANT_GROMBLE_BERRY = getRegistrate().object("giant_gromble_berry")
            .block(LunaraPlantableBush::new)
            .properties(p -> Properties.copy(Blocks.SHROOMLIGHT))
            .register();

    public static final BlockEntry<LeavesBlock> GROMBLE_LEAVES = getRegistrate().object("gromble_leaves")
            .block(LeavesBlock::new)
            .properties(p -> Properties.copy(Blocks.OAK_LEAVES))
            .tag(BlockTags.LEAVES)
            .addLayer(() -> RenderType::cutout)
            .loot((lootTables, block) -> lootTables.add(block, BlockLootTables.createLeavesDrops(
                    block, GROMBLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES
            )))
            .blockstate(RegistrationUtils::leavesModel)
            .item().tag(ItemTags.LEAVES).build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> GROMBLE_LOG = getRegistrate().object("gromble_log")
            .block(p -> Blocks.log(MaterialColor.TERRACOTTA_LIGHT_BLUE, MaterialColor.PODZOL))
            .tag(BlockTags.LOGS, TagRegistries.GROMBLE_LOGS)
            .blockstate((context, provider) -> provider.logBlock(context.get()))
            .item().tag(ItemTags.LOGS, TagRegistries.GROMBLE_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> STRIPPED_GROMBLE_LOG = getRegistrate().object("stripped_gromble_log")
            .block(p -> Blocks.log(MaterialColor.TERRACOTTA_LIGHT_BLUE, MaterialColor.TERRACOTTA_LIGHT_BLUE))
            .tag(TagRegistries.GROMBLE_LOGS)
            .blockstate((context, provider) -> provider.logBlock(context.get()))
            .item().tag(TagRegistries.GROMBLE_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> GROMBLE_WOOD = getRegistrate().object("gromble_wood")
            .block(RotatedPillarBlock::new)
            .properties(p -> GROMBLE_PROPERTIES)
            .tag(TagRegistries.GROMBLE_LOGS)
            .recipe((context, provider) -> woodFromLogs(provider, context.get(), GROMBLE_LOG.get()))
            .blockstate((context, provider) -> provider.getVariantBuilder(context.get())
                    .forAllStates(state -> ConfiguredModel.builder().modelFile(
                            provider.models().cubeAll(context.getName(),
                                    provider.blockTexture(GROMBLE_LOG.get()))
                            ).build()
                    ))
            .item().tag(TagRegistries.GROMBLE_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> STRIPPED_GROMBLE_WOOD = getRegistrate().object("stripped_gromble_wood")
            .block(RotatedPillarBlock::new)
            .properties(p -> GROMBLE_PROPERTIES)
            .tag(TagRegistries.GROMBLE_LOGS)
            .blockstate((context, provider) -> provider.getVariantBuilder(context.get())
                    .forAllStates(state -> ConfiguredModel.builder().modelFile(
                            provider.models().cubeAll(context.getName(),
                                    provider.blockTexture(STRIPPED_GROMBLE_LOG.get()))
                            ).build()
                    ))
            .item().tag(TagRegistries.GROMBLE_LOGS_ITEMS).build()
            .register();

    public static final BlockEntry<Block> GROMBLE_PLANKS = getRegistrate().object("gromble_planks")
            .block(Block::new)
            .properties(p -> GROMBLE_PROPERTIES)
            .tag(BlockTags.PLANKS)
            .recipe((context, provider) -> provider.planks(DataIngredient.tag(TagRegistries.GROMBLE_LOGS_ITEMS), context))
            .item().tag(ItemTags.PLANKS).build()
            .register();

    public static final BlockEntry<SlabBlock> GROMBLE_SLAB = getRegistrate().object("gromble_slab")
            .block(SlabBlock::new)
            .properties(p -> GROMBLE_PROPERTIES)
            .tag(BlockTags.WOODEN_SLABS)
            .loot((lootTables, block) -> lootTables.add(block, BlockLootTables.createSlabItemTable(block)))
            .recipe((context, provider) -> provider.slab(DataIngredient.items(GROMBLE_PLANKS), context, "wooden_slab", false))
            .blockstate((context, provider) -> provider.slabBlock(
                    context.get(),
                    provider.blockTexture(GROMBLE_PLANKS.get()),
                    provider.blockTexture(GROMBLE_PLANKS.get())
            ))
            .item().tag(ItemTags.WOODEN_SLABS).build()
            .register();

    public static final BlockEntry<StairsBlock> GROMBLE_STAIRS = getRegistrate().object("gromble_stairs")
            .block(p -> new StairsBlock(() -> GROMBLE_PLANKS.get().defaultBlockState(), p))
            .properties(p -> GROMBLE_PROPERTIES)
            .tag(BlockTags.WOODEN_STAIRS)
            .recipe((context, provider) ->
                    provider.stairs(DataIngredient.items(GROMBLE_PLANKS), context, "wooden_stairs", false)
            )
            .blockstate((context, provider) -> provider.stairsBlock(
                    context.get(),
                    provider.blockTexture(GROMBLE_PLANKS.get())
            ))
            .item().tag(ItemTags.WOODEN_STAIRS).build()
            .register();

    public static final BlockEntry<DoorBlock> GROMBLE_DOOR = getRegistrate().object("gromble_door")
            .block(DoorBlock::new)
            .properties(p -> GROMBLE_PROPERTIES.strength(3f).noOcclusion())
            .addLayer(() -> RenderType::cutout)
            .loot((lootTables, block) ->
                    lootTables.add(block, BlockLootTables.createDoorTable(block))
            )
            .recipe((context, provider) -> provider.door(DataIngredient.items(GROMBLE_PLANKS), context, null))
            .tag(BlockTags.WOODEN_DOORS)
            .blockstate(RegistrationUtils::doorModel)

            .item()
            .model((context, provider) -> provider.generated(context))
            .tag(ItemTags.WOODEN_DOORS).build()

            .register();

    public static final BlockEntry<TrapDoorBlock> GROMBLE_TRAPDOOR = getRegistrate().object("gromble_trapdoor")
            .block(TrapDoorBlock::new)
            .properties(p -> Properties.copy(GROMBLE_DOOR.get()))
            .tag(BlockTags.WOODEN_TRAPDOORS)
            .recipe((context, provider) -> provider.trapDoor(DataIngredient.items(GROMBLE_PLANKS), context, null))
            .blockstate((context, provider) -> provider.trapdoorBlock(context.get(), provider.blockTexture(context.get()), true))

            .item()
            .model((context, provider) -> provider.blockItem(context::getEntry, "_bottom"))
            .tag(ItemTags.WOODEN_TRAPDOORS)
            .build()

            .register();

    public static final BlockEntry<WoodButtonBlock> GROMBLE_BUTTON = getRegistrate().object("gromble_button")
            .block(WoodButtonBlock::new)
            .properties(p -> GROMBLE_PROPERTIES)
            .tag(BlockTags.WOODEN_BUTTONS)
            .recipe((context, provider) -> woodenButton(provider, context.get(), GROMBLE_PLANKS.get()))
            .blockstate((context, provider) -> RegistrationUtils.buttonModel(context, provider, GROMBLE_PLANKS))

            .item()
            .model((context, provider) -> provider.blockItem(() -> context.get().getBlock(), "_inventory"))
            .tag(ItemTags.WOODEN_BUTTONS)
            .build()

            .register();

    public static final BlockEntry<PressurePlateBlock> GROMBLE_PRESSURE_PLATE = getRegistrate().object("gromble_pressure_plate")
            .block(p -> new PressurePlateBlock(Sensitivity.EVERYTHING, p))
            .properties(p -> GROMBLE_PROPERTIES)
            .tag(BlockTags.WOODEN_PRESSURE_PLATES)
            .recipe((context, provider) -> woodenPressurePlate(provider, context.get(), GROMBLE_PLANKS.get()))
            .blockstate((context, provider) -> RegistrationUtils.pressurePlateModels(context, provider, GROMBLE_PLANKS))
            .item().tag(ItemTags.WOODEN_PRESSURE_PLATES).build()
            .register();

    public static final BlockEntry<FenceBlock> GROMBLE_FENCE = getRegistrate().object("gromble_fence")
            .block(FenceBlock::new)
            .properties(p -> GROMBLE_PROPERTIES)
            .tag(BlockTags.WOODEN_FENCES)
            .recipe((context, provider) -> provider.fence(DataIngredient.items(GROMBLE_PLANKS), context, "wooden_fence"))
            .blockstate((context, provider) -> provider.fenceBlock(context.get(), provider.blockTexture(GROMBLE_PLANKS.get())))

            .item().tag(ItemTags.WOODEN_FENCES)
            .model((context, provider) -> provider.fenceInventory(context.getId().getPath(),
                    provider.modLoc("block/" + provider.name(GROMBLE_PLANKS))))
            .build()

            .register();

    public static final BlockEntry<FenceGateBlock> GROMBLE_FENCE_GATE = getRegistrate().object("gromble_fence_gate")
            .block(FenceGateBlock::new)
            .properties(p -> GROMBLE_PROPERTIES)
            .tag(BlockTags.FENCE_GATES)
            .recipe((context, provider) -> provider.fenceGate(DataIngredient.items(GROMBLE_PLANKS), context, "wooden_fence_gate"))
            .blockstate((context, provider) -> provider.fenceGateBlock(context.get(), provider.blockTexture(GROMBLE_PLANKS.get())))
            .simpleItem()
            .register();

    public static final ItemEntry<BoatItem> GROMBLE_BOAT = getRegistrate().object("gromble_boat")
            .item(p -> new BoatItem(BoatEntity.Type.OAK, p))
            .tag(ItemTags.BOATS)
            .recipe((context, provider) ->
                    woodenBoat(provider, context.get(), GROMBLE_PLANKS.get())
            )
            .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("GrombleRegistries initialized");
    }
}
