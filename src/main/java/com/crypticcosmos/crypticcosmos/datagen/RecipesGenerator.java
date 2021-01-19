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
                .addCriterion("has_humming_ingot", this.hasItem(ItemRegistries.HUMMING_INGOT.get()))
                .build(consumer, BlockRegistries.HUMMING_OBSIDIAN.getId());

        // Moon planks
        ShapelessRecipeBuilder.shapelessRecipe(BlockRegistries.MONDROVE_PLANKS.get(), 4)
                .addIngredient(BlockRegistries.MONDROVE_LOG.get())
                .setGroup("planks")
                .addCriterion("has_moon_log", this.hasItem(BlockRegistries.MONDROVE_LOG.get()))
                .build(consumer, BlockRegistries.MONDROVE_PLANKS.getId());

        // Thorn planks
        ShapelessRecipeBuilder.shapelessRecipe(BlockRegistries.THORN_PLANKS.get(), 4)
                .addIngredient(BlockRegistries.THORN_LOG.get())
                .setGroup("planks")
                .addCriterion("has_thorn_log", this.hasItem(BlockRegistries.THORN_LOG.get()))
                .build(consumer, BlockRegistries.THORN_PLANKS.getId());

        // Haunted ingot
        CookingRecipeBuilder
                .smeltingRecipe(
                        Ingredient.fromItems(BlockRegistries.HUMMING_STONE.get()),
                        ItemRegistries.HUMMING_INGOT.get(),
                        0.75f,
                        400
                )
                .addCriterion("has_humming_stone", this.hasItem(BlockRegistries.HUMMING_STONE.get()))
                .build(consumer, ItemRegistries.HUMMING_INGOT.getId());

        // Lava sponge
        CookingRecipeBuilder
                .smeltingRecipe(
                        Ingredient.fromItems(BlockRegistries.MOLTEN_LAVA_SPONGE.get()),
                        BlockRegistries.LAVA_SPONGE.get(),
                        0.75f,
                        400
                )
                .addCriterion("has_lava_sponge", this.hasItem(BlockRegistries.LAVA_SPONGE.get()))
                .build(consumer, BlockRegistries.LAVA_SPONGE.getId());

        registerMoonstoneRecipes(consumer);

        registerMooncaliteRecipes(consumer);
    }

    private void registerMooncaliteRecipes(Consumer<IFinishedRecipe> consumer) {
        // Mooncalite slab
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.MOONCALITE_SLAB.get(), 6)
                .patternLine("mmm")
                .key('m', BlockRegistries.MOONCALITE.get())
                .addCriterion("has_mooncalite", hasItem(BlockRegistries.MOONCALITE.get()))
                .build(consumer, BlockRegistries.MOONCALITE_SLAB.getId());

        // Mooncalite slab (in stonecutter)
        SingleItemRecipeBuilder.stonecuttingRecipe(
                Ingredient.fromItems(BlockRegistries.MOONCALITE.get()),
                BlockRegistries.MOONCALITE_SLAB.get()
        ).addCriterion("has_mooncalite", hasItem(BlockRegistries.MOONCALITE.get()))
                .build(consumer, "mooncalite_slab_stonecutter");

        // Mooncalite stairs
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.MOONCALITE_STAIRS.get(), 4)
                .patternLine("m  ")
                .patternLine("mm ")
                .patternLine("mmm")
                .key('m', BlockRegistries.MOONCALITE.get())
                .addCriterion("has_mooncalite", hasItem(BlockRegistries.MOONCALITE.get()))
                .build(consumer, BlockRegistries.MOONCALITE_STAIRS.getId());

        // Mooncalite stairs (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.MOONCALITE.get()),
                        BlockRegistries.MOONCALITE_STAIRS.get()
                )
                .addCriterion("has_mooncalite", hasItem(BlockRegistries.MOONCALITE.get()))
                .build(consumer, "mooncalite_stairs_stonecutter");
    }

    private void registerMoonstoneRecipes(Consumer<IFinishedRecipe> consumer) {
        // Moonstone slab
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.MOONSTONE_SLAB.get(), 6)
                .patternLine("mmm")
                .key('m', BlockRegistries.MOONSTONE.get())
                .addCriterion("has_moonstone", hasItem(BlockRegistries.MOONSTONE.get()))
                .build(consumer, BlockRegistries.MOONSTONE_SLAB.getId());

        // Moonstone slab (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.MOONSTONE.get()),
                        BlockRegistries.MOONSTONE_SLAB.get()
                )
                .addCriterion("has_moonstone", hasItem(BlockRegistries.MOONSTONE.get()))
                .build(consumer, "moonstone_slab_stonecutter");

        // Moonstone stairs
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.MOONSTONE_STAIRS.get(), 4)
                .patternLine("m  ")
                .patternLine("mm ")
                .patternLine("mmm")
                .key('m', BlockRegistries.MOONSTONE.get())
                .addCriterion("has_moonstone", hasItem(BlockRegistries.MOONSTONE.get()))
                .build(consumer, BlockRegistries.MOONSTONE_STAIRS.getId());

        // Moonstone stairs (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.MOONSTONE.get()),
                        BlockRegistries.MOONSTONE_STAIRS.get()
                )
                .addCriterion("has_moonstone", hasItem(BlockRegistries.MOONSTONE.get()))
                .build(consumer, "moonstone_stairs_stonecutter");


        // Moonstone bricks
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.MOONSTONE_BRICKS.get(), 4)
                .patternLine("bb")
                .patternLine("bb")
                .key('b', BlockRegistries.MOONSTONE.get())
                .addCriterion("has_moonstone_bricks", hasItem(BlockRegistries.MOONSTONE_BRICKS.get()))
                .build(consumer, BlockRegistries.MOONSTONE_BRICKS.getId());

        // Moonstone bricks (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.SMOOTH_MOONSTONE.get()),
                        BlockRegistries.MOONSTONE_BRICKS.get()
                )
                .addCriterion("has_smooth_moonstone", this.hasItem(BlockRegistries.SMOOTH_MOONSTONE.get()))
                .build(consumer, "moonstone_bricks_stonecutter");

        // Moonstone bricks slab
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.MOONSTONE_BRICK_SLAB.get(), 6)
                .patternLine("mmm")
                .key('m', BlockRegistries.MOONSTONE_BRICKS.get())
                .addCriterion("has_moonstone_bricks", hasItem(BlockRegistries.MOONSTONE_BRICKS.get()))
                .build(consumer, BlockRegistries.MOONSTONE_BRICK_SLAB.getId());

        // Moonstone bricks slab (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.MOONSTONE_BRICKS.get()),
                        BlockRegistries.MOONSTONE_BRICK_SLAB.get()
                )
                .addCriterion("has_moonstone_bricks", hasItem(BlockRegistries.MOONSTONE_BRICKS.get()))
                .build(consumer, "moonstone_bricks_slab_stonecutter");

        // Moonstone bricks stairs
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.MOONSTONE_BRICK_STAIRS.get(), 4)
                .patternLine("m  ")
                .patternLine("mm ")
                .patternLine("mmm")
                .key('m', BlockRegistries.MOONSTONE_BRICKS.get())
                .addCriterion("has_moonstone_bricks", hasItem(BlockRegistries.MOONSTONE_BRICKS.get()))
                .build(consumer, BlockRegistries.MOONSTONE_BRICK_STAIRS.getId());

        // Moonstone bricks stairs (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.MOONSTONE_BRICKS.get()),
                        BlockRegistries.MOONSTONE_BRICK_STAIRS.get()
                )
                .addCriterion("has_moonstone_bricks", hasItem(BlockRegistries.MOONSTONE_BRICKS.get()))
                .build(consumer, "moonstone_bricks_stairs_stonecutter");


        // Smooth moonstone
        CookingRecipeBuilder
                .smeltingRecipe(
                        Ingredient.fromItems(BlockRegistries.MOONSTONE.get()),
                        BlockRegistries.SMOOTH_MOONSTONE.get(),
                        0.5f,
                        200
                )
                .addCriterion("has_moonstone", this.hasItem(BlockRegistries.MOONSTONE.get()))
                .build(consumer, BlockRegistries.SMOOTH_MOONSTONE.getId());

        // Smooth moonstone (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.MOONSTONE.get()),
                        BlockRegistries.SMOOTH_MOONSTONE.get()
                )
                .addCriterion("has_moonstone", hasItem(BlockRegistries.MOONSTONE.get()))
                .build(consumer, "smooth_moonstone_stonecutter");

        // Smooth moonstone slab
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.SMOOTH_MOONSTONE_SLAB.get(), 6)
                .patternLine("mmm")
                .key('m', BlockRegistries.SMOOTH_MOONSTONE.get())
                .addCriterion("has_smooth_moonstone", hasItem(BlockRegistries.SMOOTH_MOONSTONE.get()))
                .build(consumer, BlockRegistries.SMOOTH_MOONSTONE_SLAB.getId());

        // Smooth moonstone slab (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.SMOOTH_MOONSTONE.get()),
                        BlockRegistries.SMOOTH_MOONSTONE_SLAB.get()
                )
                .addCriterion("has_smooth_moonstone", hasItem(BlockRegistries.SMOOTH_MOONSTONE.get()))
                .build(consumer, "smooth_moonstone_slab_stonecutter");

        // Smooth moonstone stairs
        ShapedRecipeBuilder.shapedRecipe(BlockRegistries.SMOOTH_MOONSTONE_STAIRS.get(), 4)
                .patternLine("m  ")
                .patternLine("mm ")
                .patternLine("mmm")
                .key('m', BlockRegistries.SMOOTH_MOONSTONE.get())
                .addCriterion("has_smooth_moonstone", hasItem(BlockRegistries.SMOOTH_MOONSTONE.get()))
                .build(consumer, BlockRegistries.SMOOTH_MOONSTONE_STAIRS.getId());

        // Moonstone bricks stairs (in stonecutter)
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(BlockRegistries.SMOOTH_MOONSTONE.get()),
                        BlockRegistries.SMOOTH_MOONSTONE_STAIRS.get()
                )
                .addCriterion("has_smooth_moonstone", hasItem(BlockRegistries.SMOOTH_MOONSTONE.get()))
                .build(consumer, "smooth_moonstone_stairs_stonecutter");
    }
}
