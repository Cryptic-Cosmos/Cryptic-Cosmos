package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.ItemRegistries;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

@SuppressWarnings("NullableProblems")
public class RecipesGenerator extends RecipeProvider {
    public RecipesGenerator(DataGenerator generator) {
        super(generator);
    }

    /**
     * Registers all recipes to the given consumer.
     */
    @Override
    public void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        // Dreaming souls
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.HUMMING_OBSIDIAN.get(), 1)
                .patternLine("yxy")
                .patternLine("xzx")
                .patternLine("yxy")
                .key('x', ItemRegistries.HUMMING_INGOT.get())
                .key('y', Items.GLOWSTONE_DUST)
                .key('z', Items.OBSIDIAN)
                .addCriterion("has_humming_ingot", hasItem(ItemRegistries.HUMMING_INGOT.get()))
                .build(consumer, BlockRegistries.HUMMING_OBSIDIAN.getId());

        // Moon planks
        ShapelessRecipeBuilder.shapelessRecipe(BlockRegistries.MONDROVE_PLANKS.get(), 4)
                .addIngredient(BlockRegistries.MONDROVE_LOG.get())
                .setGroup("planks")
                .addCriterion("has_moon_log", hasItem(BlockRegistries.MONDROVE_LOG.get()))
                .build(consumer, BlockRegistries.MONDROVE_PLANKS.getId());

        // Thorn planks
        ShapelessRecipeBuilder.shapelessRecipe(BlockRegistries.THORN_PLANKS.get(), 4)
                .addIngredient(BlockRegistries.THORN_LOG.get())
                .setGroup("planks")
                .addCriterion("has_thorn_log", hasItem(BlockRegistries.THORN_LOG.get()))
                .build(consumer, BlockRegistries.THORN_PLANKS.getId());

        // Haunted ingot
        CookingRecipeBuilder
                .smeltingRecipe(
                        Ingredient.fromItems(BlockRegistries.HUMMING_STONE.get()),
                        ItemRegistries.HUMMING_INGOT.get(),
                        0.75f,
                        400
                )
                .addCriterion("has_humming_stone", hasItem(BlockRegistries.HUMMING_STONE.get()))
                .build(consumer, ItemRegistries.HUMMING_INGOT.getId());

        // Lava sponge
        CookingRecipeBuilder
                .smeltingRecipe(
                        Ingredient.fromItems(BlockRegistries.MOLTEN_LAVA_SPONGE.get()),
                        BlockRegistries.LAVA_SPONGE.get(),
                        0.75f,
                        400
                )
                .addCriterion("has_lava_sponge", hasItem(BlockRegistries.LAVA_SPONGE.get()))
                .build(consumer, BlockRegistries.LAVA_SPONGE.getId());

        registerLunonRecipes(consumer);

    }

    private void registerLunonRecipes(Consumer<IFinishedRecipe> consumer) {
        // Lunon bricks
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.LUNON_BRICKS.get(), 4)
                .patternLine("bb")
                .patternLine("bb")
                .key('b', BlockRegistries.LUNON.get())
                .addCriterion("has_lunon_bricks", hasItem(BlockRegistries.LUNON_BRICKS.get()))
                .build(consumer, BlockRegistries.LUNON_BRICKS.getId());

        // Lunon bricks (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.POLISHED_LUNON.get()),
                        BlockRegistries.LUNON_BRICKS.get()
                )
                .addCriterion("has_polished_lunon", hasItem(BlockRegistries.POLISHED_LUNON.get()))
                .build(consumer, "lunon_bricks_stonecutter");

        // Lunon bricks slab
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.LUNON_BRICK_SLAB.get(), 6)
                .patternLine("mmm")
                .key('m', BlockRegistries.LUNON_BRICKS.get())
                .addCriterion("has_lunon_bricks", hasItem(BlockRegistries.LUNON_BRICKS.get()))
                .build(consumer, BlockRegistries.LUNON_BRICK_SLAB.getId());

        // Lunon bricks slab (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.LUNON_BRICKS.get()),
                        BlockRegistries.LUNON_BRICK_SLAB.get()
                )
                .addCriterion("has_lunon_bricks", hasItem(BlockRegistries.LUNON_BRICKS.get()))
                .build(consumer, "lunon_bricks_slab_stonecutter");

        // Lunon bricks stairs
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.LUNON_BRICK_STAIRS.get(), 4)
                .patternLine("m  ")
                .patternLine("mm ")
                .patternLine("mmm")
                .key('m', BlockRegistries.LUNON_BRICKS.get())
                .addCriterion("has_lunon_bricks", hasItem(BlockRegistries.LUNON_BRICKS.get()))
                .build(consumer, BlockRegistries.LUNON_BRICK_STAIRS.getId());

        // Lunon bricks stairs (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.LUNON_BRICKS.get()),
                        BlockRegistries.LUNON_BRICK_STAIRS.get()
                )
                .addCriterion("has_lunon_bricks", hasItem(BlockRegistries.LUNON_BRICKS.get()))
                .build(consumer, "lunon_bricks_stairs_stonecutter");


        // Polished Lunon
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.POLISHED_LUNON.get(), 4)
                .patternLine("mm")
                .patternLine("mm")
                .key('m', BlockRegistries.LUNON.get())
                .addCriterion("has_polished_lunon", hasItem(BlockRegistries.LUNON.get()))
                .build(consumer, BlockRegistries.POLISHED_LUNON.getId());

        // Polished Lunon (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.LUNON.get()),
                        BlockRegistries.POLISHED_LUNON.get()
                )
                .addCriterion("has_lunon", hasItem(BlockRegistries.LUNON.get()))
                .build(consumer, "polished_lunon_stonecutter");

        // Polished Lunon slab
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.POLISHED_LUNON_SLAB.get(), 6)
                .patternLine("mmm")
                .key('m', BlockRegistries.POLISHED_LUNON.get())
                .addCriterion("has_polished_lunon", hasItem(BlockRegistries.POLISHED_LUNON.get()))
                .build(consumer, BlockRegistries.POLISHED_LUNON_SLAB.getId());

        // Polished Lunon slab (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.POLISHED_LUNON.get()),
                        BlockRegistries.POLISHED_LUNON_SLAB.get()
                )
                .addCriterion("has_polished_lunon", hasItem(BlockRegistries.POLISHED_LUNON.get()))
                .build(consumer, "polished_lunon_slab_stonecutter");

        // Chiseled Polished Lunon
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.CHISELED_POLISHED_LUNON.get(), 1)
                .patternLine("m")
                .patternLine("m")
                .key('m', BlockRegistries.POLISHED_LUNON_SLAB.get())
                .addCriterion("has_polished_lunon_slab", hasItem(BlockRegistries.POLISHED_LUNON_SLAB.get()))
                .build(consumer, BlockRegistries.CHISELED_POLISHED_LUNON.getId());

        // Polished Lunon (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.POLISHED_LUNON.get()),
                        BlockRegistries.CHISELED_POLISHED_LUNON.get()
                )
                .addCriterion("has_polished_lunon", hasItem(BlockRegistries.POLISHED_LUNON.get()))
                .build(consumer, "chiseled_polished_lunon_stonecutter");

    }
}
