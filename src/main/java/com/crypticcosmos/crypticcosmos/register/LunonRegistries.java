package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.block.OvergrownLunonBlock;
import com.crypticcosmos.crypticcosmos.util.RegistrationUtils;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;
import static com.tterrag.registrate.providers.RegistrateRecipeProvider.hasItem;

public class LunonRegistries {
    public static final BlockEntry<OvergrownLunonBlock> OVERGROWN_LUNON = getRegistrate().object("overgrown_lunon")
            .block(Material.STONE, OvergrownLunonBlock::new)
            .properties(LunonRegistries::overgrownLunonProperties)
            .tag(TagRegistries.LUNARA_PLANTABLE, TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
            .blockstate(RegistrationUtils::overgrownLunonModels)
            .simpleItem()
            .register();

    // Fungal lunon
    public static final BlockEntry<OvergrownLunonBlock> FUNGAL_LUNON = getRegistrate().object("fungal_lunon")
            .block(Material.STONE, OvergrownLunonBlock::new)
            .properties(LunonRegistries::overgrownLunonProperties)
            .tag(TagRegistries.LUNARA_PLANTABLE, TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
            .blockstate(RegistrationUtils::overgrownLunonModels)
            .simpleItem()
            .register();

    // Glum Lunon
    public static final BlockEntry<OvergrownLunonBlock> GLUM_LUNON = getRegistrate().object("glum_lunon")
            .block(OvergrownLunonBlock::new)
            .properties(LunonRegistries::overgrownLunonProperties)
            .tag(TagRegistries.LUNARA_PLANTABLE, TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
            .blockstate(RegistrationUtils::overgrownLunonModels)
            .simpleItem()
            .register();

    // Lunon
    public static final BlockEntry<Block> LUNON = getRegistrate().object("lunon")
            .block(Material.STONE, Block::new)
            .properties(p -> p.strength(2.0f, 10)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops())
            .tag(TagRegistries.LUNARA_PLANTABLE, TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
            .simpleItem()
            .register();

    // Lunon bricks
    public static final BlockEntry<Block> LUNON_BRICKS = getRegistrate().object("lunon_bricks")
            .block(Block::new)
            .properties(p -> Properties.copy(LUNON.get())
                    .strength(4.0f, 15)
                    .harvestLevel(2))
            .recipe((context, provider) -> provider.square(DataIngredient.items(LUNON), context, true))
            .recipe((context, provider) -> provider.stonecutting(DataIngredient.items(LUNON), context))
            .simpleItem()
            .register();

    // Lunon brick slab
    public static final BlockEntry<SlabBlock> LUNON_BRICK_SLAB = getRegistrate().object("lunon_brick_slab")
            .block(SlabBlock::new)
            .properties(p -> Properties.copy(LUNON_BRICKS.get()))
            .loot((lootTables, block) ->
                    lootTables.add(block, BlockLootTables.createSlabItemTable(block))
            )
            .recipe((context, provider) -> provider.slab(DataIngredient.items(LUNON_BRICKS), context, null, true))
            .blockstate((context, provider) -> provider.slabBlock(context.get(), provider.blockTexture(LUNON_BRICKS.get()), provider.blockTexture(LUNON_BRICKS.get())))
            .item().tag(ItemTags.SLABS).build()
            .register();

    // Lunon brick stairs
    public static final BlockEntry<StairsBlock> LUNON_BRICK_STAIRS = getRegistrate().object("lunon_brick_stairs")
            .block(p -> new StairsBlock(() -> LUNON_BRICKS.get().defaultBlockState(), p))
            .properties(p -> Properties.copy(LUNON_BRICKS.get()))
            .recipe((context, provider) -> provider.stairs(DataIngredient.items(LUNON_BRICKS), context, null, true))
            .blockstate((context, provider) -> provider.stairsBlock(context.get(), provider.blockTexture(LUNON_BRICKS.get())))
            .simpleItem()
            .register();
    // Polished Lunon
    public static final BlockEntry<Block> POLISHED_LUNON = getRegistrate().object("polished_lunon")
            .block(Block::new)
            .properties(p -> Properties.copy(LUNON_BRICKS.get()))
            .recipe((context, provider) -> provider.smelting(DataIngredient.items(LUNON), context, .1f, 200))
            .simpleItem()
            .register();
    // Polished Lunon slab
    public static final BlockEntry<SlabBlock> POLISHED_LUNON_SLAB = getRegistrate().object("polished_lunon_slab")
            .block(SlabBlock::new)
            .properties(p -> Properties.copy(POLISHED_LUNON.get()))
            .loot((lootTables, block) ->
                    lootTables.add(block, BlockLootTables.createSlabItemTable(block))
            )
            .recipe((context, provider) -> provider.slab(DataIngredient.items(POLISHED_LUNON), context, null, true))
            .blockstate((context, provider) -> provider.slabBlock(context.get(), POLISHED_LUNON.getId(), provider.blockTexture(POLISHED_LUNON.get())))
            .item().tag(ItemTags.SLABS).build()
            .register();

    // Chiseled Polished Lunon
    public static final BlockEntry<Block> CHISELED_POLISHED_LUNON = getRegistrate().object("chiseled_polished_lunon")
            .block(Block::new)
            .properties(p -> Properties.copy(POLISHED_LUNON.get()))
            .recipe((context, provider) ->
                    ShapedRecipeBuilder.shaped(context.get())
                            .define('#', POLISHED_LUNON_SLAB.get())
                            .pattern("#")
                            .pattern("#")
                            .unlockedBy("has_polished_lunon", hasItem(Blocks.POLISHED_BLACKSTONE))
                            .save(provider, provider.safeId(context.get()))
            )
            .blockstate((context, provider) -> provider.simpleBlock(context.get(),
                    provider.models().cubeColumn(
                            context.getName(),
                            provider.blockTexture(context.get()),
                            provider.blockTexture(POLISHED_LUNON.get()))
            ))
            .simpleItem()
            .register();
    // Mossy lunon
    public static final BlockEntry<Block> MOSSY_LUNON = getRegistrate().object("mossy_lunon")
            .block(Block::new)
            .properties(p -> Properties.copy(OVERGROWN_LUNON.get()))
            .recipe((context, provider) -> ShapelessRecipeBuilder.shapeless(context.get())
                    .requires(LUNON.get())
                    .requires(Blocks.VINE)
                    .unlockedBy("has_vine", hasItem(context.get()))
                    .save(provider)
            )
            .simpleItem()
            .register();
    // Lunon dust
    public static final BlockEntry<SandBlock> LUNON_DUST = getRegistrate().object("lunon_dust")
            .block(Material.SAND, p -> new SandBlock(22, p))
            .properties(p -> p.strength(0.5F).sound(SoundType.SAND))
            .simpleItem()
            .register();

    // Lunon variants
    // Overgrown Lunon
    @Nonnull
    static Properties overgrownLunonProperties(Properties p) {
        return p.strength(1.6f, 7)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops();
    }

    public static void init() {
        CrypticCosmos.LOGGER.info("BlockRegistries initialized");
    }
}
