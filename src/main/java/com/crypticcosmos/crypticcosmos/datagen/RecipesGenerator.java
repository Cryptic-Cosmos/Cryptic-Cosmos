package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.registries.TagRegistries;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Consumer;

import static com.crypticcosmos.crypticcosmos.registries.BlockRegistries.*;

@SuppressWarnings("NullableProblems")
public class RecipesGenerator extends RecipeProvider {
    public RecipesGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        registerLunonRecipes(consumer);
        registerMondroveRecipes(consumer);
        registerOsminstemRecipes(consumer);
        registerGrombleRecipes(consumer);
    }

    private void registerLunonRecipes(Consumer<IFinishedRecipe> consumer) {
        // Lunon bricks
        ShapedRecipeBuilder.shaped(LUNON_BRICKS.get(), 4)
                .pattern("bb")
                .pattern("bb")
                .define('b', LUNON.get())
                .unlockedBy("has_lunon_bricks", has(LUNON_BRICKS.get()))
                .save(consumer, LUNON_BRICKS.getId());

        // Lunon bricks (in stonecutter)
        SingleItemRecipeBuilder
                .stonecutting(
                        Ingredient.of(POLISHED_LUNON.get()),
                        LUNON_BRICKS.get()
                )
                .unlocks("has_polished_lunon", has(POLISHED_LUNON.get()))
                .save(consumer, "lunon_bricks_stonecutter");

        // Lunon bricks slab
        ShapedRecipeBuilder.shaped(LUNON_BRICK_SLAB.get(), 6)
                .pattern("mmm")
                .define('m', LUNON_BRICKS.get())
                .unlockedBy("has_lunon_bricks", has(LUNON_BRICKS.get()))
                .save(consumer, LUNON_BRICK_SLAB.getId());

        // Lunon bricks slab (in stonecutter)
        SingleItemRecipeBuilder
                .stonecutting(
                        Ingredient.of(LUNON_BRICKS.get()),
                        LUNON_BRICK_SLAB.get()
                )
                .unlocks("has_lunon_bricks", has(LUNON_BRICKS.get()))
                .save(consumer, "lunon_bricks_slab_stonecutter");

        // Lunon bricks stairs
        ShapedRecipeBuilder.shaped(LUNON_BRICK_STAIRS.get(), 4)
                .pattern("m  ")
                .pattern("mm ")
                .pattern("mmm")
                .define('m', LUNON_BRICKS.get())
                .unlockedBy("has_lunon_bricks", has(LUNON_BRICKS.get()))
                .save(consumer, LUNON_BRICK_STAIRS.getId());

        // Lunon bricks stairs (in stonecutter)
        SingleItemRecipeBuilder
                .stonecutting(
                        Ingredient.of(LUNON_BRICKS.get()),
                        LUNON_BRICK_STAIRS.get()
                )
                .unlocks("has_lunon_bricks", has(LUNON_BRICKS.get()))
                .save(consumer, "lunon_bricks_stairs_stonecutter");


        // Polished Lunon
        ShapedRecipeBuilder.shaped(POLISHED_LUNON.get(), 4)
                .pattern("mm")
                .pattern("mm")
                .define('m', LUNON.get())
                .unlockedBy("has_polished_lunon", has(LUNON.get()))
                .save(consumer, POLISHED_LUNON.getId());

        // Polished Lunon (in stonecutter)
        SingleItemRecipeBuilder
                .stonecutting(
                        Ingredient.of(LUNON.get()),
                        POLISHED_LUNON.get()
                )
                .unlocks("has_lunon", has(LUNON.get()))
                .save(consumer, "polished_lunon_stonecutter");

        // Polished Lunon slab
        ShapedRecipeBuilder.shaped(POLISHED_LUNON_SLAB.get(), 6)
                .pattern("mmm")
                .define('m', POLISHED_LUNON.get())
                .unlockedBy("has_polished_lunon", has(POLISHED_LUNON.get()))
                .save(consumer, POLISHED_LUNON_SLAB.getId());

        // Polished Lunon slab (in stonecutter)
        SingleItemRecipeBuilder
                .stonecutting(
                        Ingredient.of(POLISHED_LUNON.get()),
                        POLISHED_LUNON_SLAB.get()
                )
                .unlocks("has_polished_lunon", has(POLISHED_LUNON.get()))
                .save(consumer, "polished_lunon_slab_stonecutter");

        // Chiseled Polished Lunon
        ShapedRecipeBuilder.shaped(CHISELED_POLISHED_LUNON.get(), 1)
                .pattern("m")
                .pattern("m")
                .define('m', POLISHED_LUNON_SLAB.get())
                .unlockedBy("has_polished_lunon_slab", has(POLISHED_LUNON_SLAB.get()))
                .save(consumer, CHISELED_POLISHED_LUNON.getId());

        // Polished Lunon (in stonecutter)
        SingleItemRecipeBuilder
                .stonecutting(
                        Ingredient.of(POLISHED_LUNON.get()),
                        CHISELED_POLISHED_LUNON.get()
                )
                .unlocks("has_polished_lunon", has(POLISHED_LUNON.get()))
                .save(consumer, "chiseled_polished_lunon_stonecutter");

        // Mossy lunon
        ShapelessRecipeBuilder
                .shapeless(MOSSY_LUNON.get())
                .requires(LUNON.get())
                .requires(Blocks.VINE).unlockedBy("has_vine", has(Blocks.VINE))
                .save(consumer);
    }

    private void registerMondroveRecipes(Consumer<IFinishedRecipe> consumer) {
        planksFromLogs(consumer, MONDROVE_PLANKS.get(), TagRegistries.MONDROVE_LOGS_ITEMS);
        woodFromLogs(consumer, MONDROVE_WOOD.get(), MONDROVE_LOG.get());
        woodenDoor(consumer, MONDROVE_DOOR.get(), MONDROVE_PLANKS.get());
        woodenSlab(consumer, MONDROVE_SLAB.get(), MONDROVE_PLANKS.get());
        woodenStairs(consumer, MONDROVE_STAIRS.get(), MONDROVE_PLANKS.get());
        woodenTrapdoor(consumer, MONDROVE_TRAPDOOR.get(), MONDROVE_PLANKS.get());
    }

    private void registerOsminstemRecipes(Consumer<IFinishedRecipe> consumer) {
        planksFromLogs(consumer, OSMINSTEM_PLANKS.get(), TagRegistries.OSMINSTEM_LOGS_ITEMS);
        woodFromLogs(consumer, OSMINSTEM_WOOD.get(), OSMINSTEM_LOG.get());
        // woodFromLogs(consumer, OSMINSTEM_WOOD.get(), OSMINSTEM_POROUS_LOG.get());
        woodenDoor(consumer, OSMINSTEM_DOOR.get(), OSMINSTEM_PLANKS.get());
        woodenTrapdoor(consumer, OSMINSTEM_TRAPDOOR.get(), OSMINSTEM_PLANKS.get());
    }

    private void registerGrombleRecipes(Consumer<IFinishedRecipe> consumer) {
        planksFromLogs(consumer, GROMBLE_PLANKS.get(), TagRegistries.GROMBLE_LOGS_ITEMS);
        woodFromLogs(consumer, GROMBLE_WOOD.get(), GROMBLE_LOG.get());
        woodenDoor(consumer, GROMBLE_DOOR.get(), GROMBLE_PLANKS.get());
        woodenTrapdoor(consumer, GROMBLE_TRAPDOOR.get(), GROMBLE_PLANKS.get());
    }
}
