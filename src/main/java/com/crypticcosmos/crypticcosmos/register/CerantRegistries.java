package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;
import static com.tterrag.registrate.providers.RegistrateRecipeProvider.hasItem;

public class CerantRegistries {
    public static final BlockEntry<Block> PHORAL_CERANT = getRegistrate().object("phoral_cerant")
            .block(Material.STONE, Block::new)
            .properties(CerantRegistries::phoralCerantProperties)
            .tag(TagRegistries.LUNARA_PLANTABLE, TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
            .simpleItem()
            .register();

    // Lunon
    public static final BlockEntry<Block> CERANT = getRegistrate().object("cerant")
            .block(Material.STONE, Block::new)
            .properties(p -> p.strength(2.0f, 10)
                    .sound(SoundType.STONE)
                    .harvestLevel( 0)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops())
            .tag(TagRegistries.LUNARA_PLANTABLE, TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
            .simpleItem()
            .register();

    // Lunon bricks
    public static final BlockEntry<Block> POLISHED_CERANT_BRICKS = getRegistrate().object("polished_cerant_bricks")
            .block(Block::new)
            .properties(p -> Properties.copy(CERANT.get())
                    .strength(4.0f, 15)
                    .harvestLevel(2))
            .recipe((context, provider) -> provider.square(DataIngredient.items(CERANT), context, true))
            .recipe((context, provider) -> provider.stonecutting(DataIngredient.items(CERANT), context))
            .simpleItem()
            .register();

    // Lunon brick slab
    public static final BlockEntry<SlabBlock> POLISHED_CERANT_BRICK_SLAB = getRegistrate().object("polished_cerant_brick_slab")
            .block(SlabBlock::new)
            .properties(p -> Properties.copy(POLISHED_CERANT_BRICKS.get()))
            .loot((lootTables, block) ->
                    lootTables.add(block, BlockLootTables.createSlabItemTable(block))
            )
            .recipe((context, provider) -> provider.slab(DataIngredient.items(POLISHED_CERANT_BRICKS), context, null, true))
            .blockstate((context, provider) -> provider.slabBlock(context.get(), provider.blockTexture(POLISHED_CERANT_BRICKS.get()), provider.blockTexture(POLISHED_CERANT_BRICKS.get())))
            .item().tag(ItemTags.SLABS).build()
            .register();

    // Lunon brick stairs
    public static final BlockEntry<StairsBlock> POLISHED_CERANT_BRICK_STAIRS = getRegistrate().object("polished_cerant_brick_stairs")
            .block(p -> new StairsBlock(() -> POLISHED_CERANT_BRICKS.get().defaultBlockState(), p))
            .properties(p -> Properties.copy(POLISHED_CERANT_BRICKS.get()))
            .recipe((context, provider) -> provider.stairs(DataIngredient.items(POLISHED_CERANT_BRICKS), context, null, true))
            .blockstate((context, provider) -> provider.stairsBlock(context.get(), provider.blockTexture(POLISHED_CERANT_BRICKS.get())))
            .simpleItem()
            .register();
    // Polished Lunon
    public static final BlockEntry<Block> POLISHED_CERANT = getRegistrate().object("polished_cerant")
            .block(Block::new)
            .properties(p -> Properties.copy(POLISHED_CERANT_BRICKS.get()))
            .recipe((context, provider) -> provider.smelting(DataIngredient.items(CERANT), context, .1f, 200))
            .simpleItem()
            .register();
    // Polished Lunon slab
    public static final BlockEntry<SlabBlock> POLISHED_CERANT_SLAB = getRegistrate().object("polished_cerant_slab")
            .block(SlabBlock::new)
            .properties(p -> Properties.copy(POLISHED_CERANT.get()))
            .loot((lootTables, block) ->
                    lootTables.add(block, BlockLootTables.createSlabItemTable(block))
            )
            .recipe((context, provider) -> provider.slab(DataIngredient.items(POLISHED_CERANT), context, null, true))
            .blockstate((context, provider) -> provider.slabBlock(context.get(), POLISHED_CERANT.getId(), provider.blockTexture(POLISHED_CERANT.get())))
            .item().tag(ItemTags.SLABS).build()
            .register();

    // Chiseled Polished Lunon
    public static final BlockEntry<Block> CHISELED_POLISHED_LUNON = getRegistrate().object("chiseled_polished_cerant")
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

    public static final BlockEntry<Block> CHISELED_LUNON = getRegistrate().object("chiseled_cerant")
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

    // Lunon variants
    // Overgrown Lunon
    @Nonnull
    static AbstractBlock.Properties phoralCerantProperties(AbstractBlock.Properties p) {
        return p.strength(1.6f, 7)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops();
    }

    public static void init() {
        CrypticCosmos.LOGGER.info("Cerant Registries initialized");
    }
}
