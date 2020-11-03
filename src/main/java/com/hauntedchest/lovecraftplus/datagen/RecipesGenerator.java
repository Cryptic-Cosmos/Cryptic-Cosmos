package com.hauntedchest.lovecraftplus.datagen;

import com.hauntedchest.lovecraftplus.registries.ItemHandler;
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
        ShapedRecipeBuilder.shapedRecipe(ItemHandler.HUMMING_OBSIDIAN_ITEM.get(), 1)
                .patternLine("yxy")
                .patternLine("xzx")
                .patternLine("yxy")
                .key('x', ItemHandler.HUMMING_INGOT.get())
                .key('y', Items.GLOWSTONE_DUST)
                .key('z', Items.OBSIDIAN)
                .addCriterion("has_humming_ingot", this.hasItem(ItemHandler.HUMMING_INGOT.get()))
                .build(consumer, ItemHandler.HUMMING_OBSIDIAN_ITEM.getId());

        // Moon planks
        ShapelessRecipeBuilder.shapelessRecipe(ItemHandler.MOON_PLANKS_ITEM.get(), 4)
                .addIngredient(ItemHandler.MOON_LOG_ITEM.get())
                .setGroup("planks")
                .addCriterion("has_moon_log", this.hasItem(ItemHandler.MOON_LOG_ITEM.get()))
                .build(consumer, ItemHandler.MOON_PLANKS_ITEM.getId());

        // Thorn planks
        ShapelessRecipeBuilder.shapelessRecipe(ItemHandler.THORN_PLANKS_ITEM.get(), 4)
                .addIngredient(ItemHandler.THORN_LOG_ITEM.get())
                .setGroup("planks")
                .addCriterion("has_thorn_log", this.hasItem(ItemHandler.THORN_LOG_ITEM.get()))
                .build(consumer, ItemHandler.THORN_PLANKS_ITEM.getId());


        // Smooth moonstone
        CookingRecipeBuilder.smeltingRecipe(
                Ingredient.fromItems(ItemHandler.MOONSTONE_ITEM.get()),
                ItemHandler.SMOOTH_MOONSTONE_ITEM.get(),
                0.5f,
                200)
                .addCriterion("has_moonstone", this.hasItem(ItemHandler.MOONSTONE_ITEM.get()))
                .build(consumer, ItemHandler.SMOOTH_MOONSTONE_ITEM.getId());

        // Haunted ingot
        CookingRecipeBuilder.smeltingRecipe(
                Ingredient.fromItems(ItemHandler.HUMMING_STONE_ITEM.get()),
                ItemHandler.HUMMING_INGOT.get(),
                0.75f,
                400)
                .addCriterion("has_humming_stone", this.hasItem(ItemHandler.HUMMING_STONE_ITEM.get()))
                .build(consumer, ItemHandler.HUMMING_INGOT.getId());

        // Lava sponge
        CookingRecipeBuilder.smeltingRecipe(
                Ingredient.fromItems(ItemHandler.MOLTEN_LAVA_SPONGE_ITEM.get()),
                ItemHandler.LAVA_SPONGE_ITEM.get(),
                0.75f,
                400)
                .addCriterion("has_lava_sponge", this.hasItem(ItemHandler.LAVA_SPONGE_ITEM.get()))
                .build(consumer, ItemHandler.LAVA_SPONGE_ITEM.getId());

        // Moonstone bricks
        SingleItemRecipeBuilder
                .stonecuttingRecipe(
                        Ingredient.fromItems(ItemHandler.SMOOTH_MOONSTONE_ITEM.get()),
                        ItemHandler.MOONSTONE_BRICKS_ITEM.get())
                .addCriterion("has_smooth_moonstone",
                        this.hasItem(ItemHandler.SMOOTH_MOONSTONE_ITEM.get()))
                .build(consumer, ItemHandler.MOONSTONE_BRICKS_ITEM.getId());
    }
}
