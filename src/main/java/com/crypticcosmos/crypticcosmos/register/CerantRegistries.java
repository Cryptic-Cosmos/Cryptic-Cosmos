package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;
import static com.tterrag.registrate.providers.RegistrateRecipeProvider.hasItem;
import static com.tterrag.registrate.util.DataIngredient.items;
import static net.minecraft.data.loot.BlockLootTables.createSlabItemTable;

@SuppressWarnings("unused")
public class CerantRegistries {
    public static final BlockEntry<Block> PHORAL_CERANT = getRegistrate().object("phoral_cerant")
            .block(Material.STONE, Block::new)
            .properties(CerantRegistries::phoralCerantProperties)
            .tag(TagRegistries.LUNARA_PLANTABLE, TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
            .simpleItem()
            .register();

    public static final BlockEntry<Block> POLISHED_PHORAL_CERANT = getRegistrate().object("polished_phoral_cerant")
            .block(Block::new)
            .properties(p -> Properties.copy(PHORAL_CERANT.get()))
            .recipe((context, provider) -> provider.smelting(items(PHORAL_CERANT), context, .1f, 200))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CUT_PHORAL_CERANT = getRegistrate().object("cut_phoral_cerant")
            .block(Block::new)
            .properties(p -> Properties.copy(PHORAL_CERANT.get()))
            .recipe((context, provider) ->
                    ShapedRecipeBuilder.shaped(context.get())
                            .define('#', PHORAL_CERANT.get())
                            .pattern("##")
                            .pattern("##")
                            .unlockedBy("has_polished_lunon", hasItem(Blocks.POLISHED_BLACKSTONE))
                            .save(provider, provider.safeId(context.get()))
            )
            .simpleItem()
            .register();

    public static final BlockEntry<Block> POLISHED_CUT_PHORAL_CERANT = getRegistrate().object("polished_cut_phoral_cerant")
            .block(Block::new)
            .properties(p -> Properties.copy(PHORAL_CERANT.get()))
            .recipe((context, provider) -> provider.smelting(items(PHORAL_CERANT), context, .1f, 200))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> POLISHED_CUT_PHORAL_CERANT_BRICKS = getRegistrate().object("polished_cut_phoral_cerant_bricks")
            .block(Block::new)
            .properties(p -> Properties.copy(CUT_PHORAL_CERANT.get())
                    .strength(4.0f, 15)
                    .harvestLevel(0))
            .recipe((context, provider) -> provider.square(items(CUT_PHORAL_CERANT), context, true))
            .recipe((context, provider) -> provider.stonecutting(items(CUT_PHORAL_CERANT), context))
            .tag(BlockTags.STONE_BRICKS)
            .item().tag(ItemTags.STONE_BRICKS).build()
            .register();

    public static final BlockEntry<Block> CERANT = getRegistrate().object("cerant")
            .block(Material.STONE, Block::new)
            .properties(CerantRegistries::cerantProperties)
            .tag(TagRegistries.LUNARA_PLANTABLE, TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
            .item().tag(ItemTags.STONE_CRAFTING_MATERIALS, ItemTags.STONE_TOOL_MATERIALS).build()
            .simpleItem()
            .register();

    public static final BlockEntry<SlabBlock> CERANT_SLAB = getRegistrate().object("cerant_slab")
            .block(SlabBlock::new)
            .properties(p -> Properties.copy(CERANT.get()))
            .loot((lootTables, block) -> lootTables.add(block, createSlabItemTable(block)))
            .recipe((context, provider) -> provider.slab(items(CERANT), context, null, true))
            .tag(BlockTags.SLABS)
            .blockstate((context, provider) -> provider.slabBlock(context.get(),
                    provider.blockTexture(CERANT.get()),
                    provider.blockTexture(CERANT.get()))
            )
            .item().tag(ItemTags.SLABS).build()
            .register();

    public static final BlockEntry<Block> POLISHED_CERANT_BRICKS = getRegistrate().object("polished_cerant_bricks")
            .block(Block::new)
            .properties(p -> Properties.copy(CERANT.get())
                    .strength(4.0f, 15)
                    .harvestLevel(0))
            .recipe((context, provider) -> provider.square(items(CERANT), context, true))
            .recipe((context, provider) -> provider.stonecutting(items(CERANT), context))
            .tag(BlockTags.STONE_BRICKS)
            .item().tag(ItemTags.STONE_BRICKS).build()
            .register();

    public static final BlockEntry<SlabBlock> POLISHED_CERANT_BRICK_SLAB = getRegistrate().object("polished_cerant_brick_slab")
            .block(SlabBlock::new)
            .properties(p -> Properties.copy(POLISHED_CERANT_BRICKS.get()))
            .loot((lootTables, block) -> lootTables.add(block, createSlabItemTable(block)))
            .recipe((context, provider) -> provider.slab(items(POLISHED_CERANT_BRICKS), context, null, true))
            .tag(BlockTags.SLABS)
            .blockstate((context, provider) -> provider.slabBlock(context.get(),
                    provider.blockTexture(POLISHED_CERANT_BRICKS.get()),
                    provider.blockTexture(POLISHED_CERANT_BRICKS.get()))
            )
            .item().tag(ItemTags.SLABS).build()
            .register();

    public static final BlockEntry<StairsBlock> POLISHED_CERANT_BRICK_STAIRS = getRegistrate().object("polished_cerant_brick_stairs")
            .block(p -> new StairsBlock(() -> POLISHED_CERANT_BRICKS.get().defaultBlockState(), p))
            .properties(p -> Properties.copy(POLISHED_CERANT_BRICKS.get()))
            .recipe((context, provider) -> provider.stairs(items(POLISHED_CERANT_BRICKS), context, null, true))
            .blockstate((context, provider) -> provider.stairsBlock(context.get(), provider.blockTexture(POLISHED_CERANT_BRICKS.get())))
            .tag(BlockTags.STAIRS)
            .item().tag(ItemTags.STAIRS).build()
            .register();

    public static final BlockEntry<Block> POLISHED_VERTICAL_CERANT_BRICKS = getRegistrate().object("polished_vertical_cerant_bricks")
            .block(Block::new)
            .properties(p -> Properties.copy(CERANT.get())
                    .strength(4.0f, 15)
                    .harvestLevel(0))
            .recipe((context, provider) -> provider.square(items(CERANT), context, true))
            .recipe((context, provider) -> provider.stonecutting(items(CERANT), context))
            .tag(BlockTags.STONE_BRICKS)
            .item().tag(ItemTags.STONE_BRICKS).build()
            .register();

    public static final BlockEntry<SlabBlock> POLISHED_VERTICAL_CERANT_BRICK_SLAB = getRegistrate().object("polished_vertical_cerant_brick_slab")
            .block(SlabBlock::new)
            .properties(p -> Properties.copy(POLISHED_CERANT_BRICKS.get()))
            .loot((lootTables, block) -> lootTables.add(block, createSlabItemTable(block)))
            .recipe((context, provider) -> provider.slab(items(POLISHED_CERANT_BRICKS), context, null, true))
            .tag(BlockTags.SLABS)
            .blockstate((context, provider) -> provider.slabBlock(context.get(),
                    provider.blockTexture(POLISHED_CERANT_BRICKS.get()),
                    provider.blockTexture(POLISHED_CERANT_BRICKS.get()))
            )
            .item().tag(ItemTags.SLABS).build()
            .register();

    public static final BlockEntry<StairsBlock> POLISHED_VERTICAL_CERANT_BRICK_STAIRS = getRegistrate().object("polished_vertical_cerant_brick_stairs")
            .block(p -> new StairsBlock(() -> POLISHED_CERANT_BRICKS.get().defaultBlockState(), p))
            .properties(p -> Properties.copy(POLISHED_CERANT_BRICKS.get()))
            .recipe((context, provider) -> provider.stairs(items(POLISHED_CERANT_BRICKS), context, null, true))
            .blockstate((context, provider) -> provider.stairsBlock(context.get(), provider.blockTexture(POLISHED_CERANT_BRICKS.get())))
            .tag(BlockTags.STAIRS)
            .item().tag(ItemTags.STAIRS).build()
            .register();

    public static final BlockEntry<Block> POLISHED_CERANT = getRegistrate().object("polished_cerant")
            .block(Block::new)
            .properties(p -> Properties.copy(POLISHED_CERANT_BRICKS.get()))
            .recipe((context, provider) -> provider.smelting(items(CERANT), context, .1f, 200))
            .simpleItem()
            .register();

    public static final BlockEntry<SlabBlock> POLISHED_CERANT_SLAB = getRegistrate().object("polished_cerant_slab")
            .block(SlabBlock::new)
            .properties(p -> Properties.copy(POLISHED_CERANT.get()))
            .loot((lootTables, block) ->
                    lootTables.add(block, createSlabItemTable(block))
            )
            .recipe((context, provider) -> provider.slab(items(POLISHED_CERANT), context, null, true))
            .tag(BlockTags.SLABS)
            .blockstate((context, provider) -> provider.slabBlock(context.get(),
                    provider.blockTexture(POLISHED_CERANT.get()),
                    provider.blockTexture(POLISHED_CERANT.get()))
            )
            .item().tag(ItemTags.SLABS).build()
            .register();
    // Chiseled Polished Lunon

    public static final BlockEntry<Block> CHISELED_POLISHED_CERANT = getRegistrate().object("chiseled_polished_cerant")
            .block(Block::new)
            .properties(p -> Properties.copy(POLISHED_CERANT.get()))
            .recipe((context, provider) ->
                    ShapedRecipeBuilder.shaped(context.get())
                            .define('#', POLISHED_CERANT_SLAB.get())
                            .pattern("#")
                            .pattern("#")
                            .unlockedBy("has_polished_lunon", hasItem(Blocks.POLISHED_BLACKSTONE))
                            .save(provider, provider.safeId(context.get()))
            )
            .blockstate((context, provider) -> provider.simpleBlock(context.get(),
                    provider.models().cubeColumn(
                            context.getName(),
                            provider.blockTexture(context.get()),
                            provider.blockTexture(POLISHED_CERANT.get()))
            ))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CHISELED_POLISHED_CERANT_BRICKS = getRegistrate().object("chiseled_polished_cerant_bricks")
            .block(Block::new)
            .properties(p -> Properties.copy(POLISHED_CERANT.get()))
            .recipe((context, provider) ->
                    ShapedRecipeBuilder.shaped(context.get())
                            .define('#', POLISHED_CERANT_BRICK_SLAB.get())
                            .pattern("#")
                            .pattern("#")
                            .unlockedBy("has_polished_lunon", hasItem(Blocks.POLISHED_BLACKSTONE))
                            .save(provider, provider.safeId(context.get()))
            )
            .blockstate((context, provider) -> provider.simpleBlock(context.get(),
                    provider.models().cubeColumn(
                            context.getName(),
                            provider.blockTexture(context.get()),
                            provider.blockTexture(POLISHED_CERANT.get()))
            ))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CHISELED_VERTICAL_POLISHED_CERANT_BRICKS = getRegistrate().object("chiseled_polished_vertical_cerant_bricks")
            .block(Block::new)
            .properties(p -> Properties.copy(POLISHED_CERANT.get()))
            .recipe((context, provider) ->
                    ShapedRecipeBuilder.shaped(context.get())
                            .define('#', POLISHED_VERTICAL_CERANT_BRICK_SLAB.get())
                            .pattern("#")
                            .pattern("#")
                            .unlockedBy("has_polished_lunon", hasItem(Blocks.POLISHED_BLACKSTONE))
                            .save(provider, provider.safeId(context.get()))
            )
            .blockstate((context, provider) -> provider.simpleBlock(context.get(),
                    provider.models().cubeColumn(
                            context.getName(),
                            provider.blockTexture(context.get()),
                            provider.blockTexture(POLISHED_CERANT.get()))
            ))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> CHISELED_CERANT = getRegistrate().object("chiseled_cerant")
            .block(Block::new)
            .properties(p -> Properties.copy(POLISHED_CERANT.get()))
            .recipe((context, provider) ->
                    ShapedRecipeBuilder.shaped(context.get())
                            .define('#', CERANT_SLAB.get())
                            .pattern("#")
                            .pattern("#")
                            .unlockedBy("has_polished_lunon", hasItem(Blocks.POLISHED_BLACKSTONE))
                            .save(provider, provider.safeId(context.get()))
            )
            .blockstate((context, provider) -> provider.simpleBlock(context.get(),
                    provider.models().cubeColumn(
                            context.getName(),
                            provider.blockTexture(context.get()),
                            provider.blockTexture(CERANT.get()))
            ))
            .simpleItem()
            .register();

    @Nonnull
    private static Properties cerantProperties(Properties p) {
        return p.strength(2.7f, 13)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops();
    }

    @Nonnull
    private static Properties phoralCerantProperties(Properties p) {
        return p.strength(2.0f, 9)
                .sound(SoundType.STONE)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops();
    }

    public static void init() {
        CrypticCosmos.LOGGER.info("Cerant Registries initialized");
    }
}
