package com.crypticcosmos.crypticcosmos.util;

import com.crypticcosmos.crypticcosmos.block.Infectable;
import com.crypticcosmos.crypticcosmos.block.MondroveLog;
import com.crypticcosmos.crypticcosmos.block.OvergrownLunonBlock;
import com.crypticcosmos.crypticcosmos.register.LunonRegistries;
import com.crypticcosmos.crypticcosmos.register.MondroveRegistries;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.core.Direction.Axis;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.ConfiguredModel;

import java.util.function.Supplier;

import static net.minecraft.advancements.critereon.ItemPredicate.Builder.item;
import static net.minecraft.advancements.critereon.MinMaxBounds.Ints.atLeast;
import static net.minecraft.world.item.enchantment.Enchantments.BLOCK_FORTUNE;
import static net.minecraft.world.item.enchantment.Enchantments.SILK_TOUCH;
import static net.minecraft.world.level.storage.loot.LootPool.lootPool;
import static net.minecraft.world.level.storage.loot.LootTable.lootTable;
import static net.minecraft.world.level.storage.loot.entries.AlternativesEntry.alternatives;
import static net.minecraft.world.level.storage.loot.entries.LootItem.lootTableItem;
import static net.minecraft.world.level.storage.loot.functions.ApplyBonusCount.addOreBonusCount;
import static net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay.explosionDecay;
import static net.minecraft.world.level.storage.loot.functions.SetItemCountFunction.setCount;
import static net.minecraft.world.level.storage.loot.predicates.AlternativeLootItemCondition.alternative;
import static net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition.bonusLevelFlatChance;
import static net.minecraft.world.level.storage.loot.predicates.MatchTool.toolMatches;
import static net.minecraft.world.level.storage.loot.providers.number.ConstantValue.exactly;
import static net.minecraft.world.level.storage.loot.providers.number.UniformGenerator.between;
import static net.minecraftforge.client.model.generators.ConfiguredModel.builder;
import static net.minecraftforge.common.Tags.Items.SHEARS;

public class RegistrationUtils {
    public static ConfiguredModel[] infectableBlockModels(BlockState state,
                                                          DataGenContext<Block, ? extends Infectable> context,
                                                          RegistrateBlockstateProvider provider) {
        String infectionLevel = state.getValue(Infectable.INFECTION_LEVEL) == 0 ? ""
                : state.getValue(Infectable.INFECTION_LEVEL).toString();

        return builder()
                .modelFile(provider.models().cubeAll(context.getName() + infectionLevel,
                                blockTexture(context, infectionLevel)
                        )
                ).build();
    }

    public static ConfiguredModel[] mondroveLogModels(BlockState state,
                                                      DataGenContext<Block, MondroveLog> context,
                                                      RegistrateBlockstateProvider provider,
                                                      boolean isStripped) {
        String infectionLevel = state.getValue(Infectable.INFECTION_LEVEL) == 0 ? ""
                : state.getValue(Infectable.INFECTION_LEVEL).toString();
        var axis = state.getValue(BlockStateProperties.AXIS);

        return builder().modelFile(provider.models().cubeColumn(
                        context.getName() + infectionLevel,
                        blockTexture(isStripped ? "stripped_" : "", MondroveRegistries.MONDROVE_LOG, !isStripped ? infectionLevel : ""),
                        blockTexture(isStripped ? "stripped_" : "", MondroveRegistries.MONDROVE_LOG, "_top")))
                .rotationX(axis.equals(Axis.Z) || axis.equals(Axis.X) ? 90 : 0)
                .rotationY(axis.equals(Axis.X) ? 90 : 0).build();
    }

    public static ConfiguredModel[] mondroveWoodModels(BlockState state,
                                                       DataGenContext<Block, MondroveLog> context,
                                                       RegistrateBlockstateProvider provider,
                                                       boolean isStripped) {
        var axis = state.getValue(BlockStateProperties.AXIS);
        String infectionLevel = state.getValue(Infectable.INFECTION_LEVEL) == 0 ? ""
                : state.getValue(Infectable.INFECTION_LEVEL).toString();

        return builder().modelFile(provider.models().cubeAll(
                        context.getName() + infectionLevel,
                        blockTexture(isStripped ? "stripped_" : "",
                                MondroveRegistries.MONDROVE_LOG,
                                !isStripped ? infectionLevel : ""
                        ))
                ).rotationX(axis.equals(Axis.Z) || axis.equals(Axis.X) ? 90 : 0)
                .rotationY(axis.equals(Axis.X) ? 90 : 0).build();
    }

    public static void overgrownLunonModels(DataGenContext<Block, OvergrownLunonBlock> context, RegistrateBlockstateProvider provider) {
        provider.getVariantBuilder(context.get()).forAllStates(
                blockState -> {
                    boolean isSnowy = blockState.getValue(OvergrownLunonBlock.SNOWY);
                    var axis = blockState.getValue(OvergrownLunonBlock.FACING);
                    final ConfiguredModel.Builder<?> builder = builder();

                    int degree = (int) axis.toYRot();

                    if (!isSnowy) {
                        builder.modelFile(provider.models().cubeBottomTop(
                                        context.getName(),
                                        blockTexture(context, "_side"),
                                        provider.blockTexture(LunonRegistries.LUNON.get()),
                                        blockTexture(context, "_top")))
                                .rotationY(degree);
                    } else {
                        builder.modelFile(provider.models().cubeBottomTop(
                                context.getName(),
                                blockTexture(LunonRegistries.OVERGROWN_LUNON, "_snow"),
                                provider.blockTexture(LunonRegistries.LUNON.get()),
                                blockTexture(context, "_top")));
                    }

                    return builder.build();
                }
        );
    }

    public static void leavesModel(DataGenContext<Block, LeavesBlock> context, RegistrateBlockstateProvider provider) {
        provider.getVariantBuilder(context.get())
                .forAllStates(state -> builder().modelFile(
                                provider.models()
                                        .withExistingParent(context.getName(), provider.mcLoc("leaves"))
                                        .texture("all", provider.blockTexture(context.get()))
                        ).build()
                );
    }

    public static void crossModel(DataGenContext<Block, ? extends Block> context, RegistrateBlockstateProvider provider) {
        provider.getVariantBuilder(context.get())
                .forAllStates(state -> builder().modelFile(
                        provider.models().cross(context.getName(), provider.blockTexture(context.get()))).build()
                );
    }

    public static void doorModel(DataGenContext<Block, ? extends DoorBlock> context, RegistrateBlockstateProvider provider) {
        provider.doorBlock(context.get(),
                RegistrationUtils.blockTexture(context, "_bottom"),
                RegistrationUtils.blockTexture(context, "_top"));
    }

    public static void buttonModel(DataGenContext<Block, ? extends ButtonBlock> context, RegistrateBlockstateProvider provider, NonNullSupplier<? extends Block> planks) {
        final ConfiguredModel.Builder<?> buttonModel = builder().modelFile(provider.models()
                .withExistingParent(context.getName(), "button")
                .texture("texture", provider.blockTexture(planks.get())));

        final ConfiguredModel.Builder<?> buttonPressedModel = builder().modelFile(provider.models()
                .withExistingParent(context.getName() + "_pressed", "button_pressed")
                .texture("texture", provider.blockTexture(planks.get())));

        //noinspection unused
        final ConfiguredModel.Builder<?> buttonInventoryModel = builder().modelFile(provider.models()
                .withExistingParent(context.getName() + "_inventory", "button_inventory")
                .texture("texture", provider.blockTexture(planks.get())));

        provider.getVariantBuilder(context.get())
                .forAllStates(state -> {
                    final var attachedFace = state.getValue(ButtonBlock.FACE);
                    final var direction = state.getValue(ButtonBlock.FACING);
                    final boolean isPowered = state.getValue(ButtonBlock.POWERED);

                    int rotationY = switch (direction) {
                        case NORTH -> 0;
                        case EAST -> 90;
                        case SOUTH -> 180;
                        default -> 270;
                    };

                    int rotationX = switch (attachedFace) {
                        case FLOOR -> 0;
                        case WALL -> 90;
                        case CEILING -> 180;
                    };

                    if (!isPowered) return buttonModel.rotationX(rotationX).rotationY(rotationY).build();
                    else return buttonPressedModel.rotationX(rotationX).rotationY(rotationY).build();
                });
    }

    public static void pressurePlateModels(DataGenContext<Block, ? extends PressurePlateBlock> context,
                                           RegistrateBlockstateProvider provider,
                                           NonNullSupplier<? extends Block> planks) {
        provider.getVariantBuilder(context.get())
                .forAllStates(state -> {
                    final String parentSuffix = state.getValue(PressurePlateBlock.POWERED) ? "_down" : "_up";
                    final String idSuffix = state.getValue(PressurePlateBlock.POWERED) ? "_down" : "";

                    return builder().modelFile(provider.models()
                            .withExistingParent(context.getName() + idSuffix, "pressure_plate" + parentSuffix)
                            .texture("texture", provider.blockTexture(planks.get()))).build();
                });
    }

    public static ResourceLocation blockTexture(Supplier<? extends Block> block, String suffix) {
        //noinspection ConstantConditions
        return new ResourceLocation(block.get().getRegistryName().getNamespace(),
                "block/" + block.get().getRegistryName().getPath() + suffix
        );
    }

    public static ResourceLocation blockTexture(String prefix, Supplier<? extends Block> block, String suffix) {
        //noinspection ConstantConditions
        return new ResourceLocation(block.get().getRegistryName().getNamespace(),
                "block/" + prefix + block.get().getRegistryName().getPath() + suffix
        );
    }

    public static <BLOCK extends Block, ITEM extends NonNullSupplier<Item>> void silkTouchFortune(
            RegistrateBlockLootTables lootTables,
            BLOCK block,
            ITEM fortuneDrop,
            int minDrop,
            int maxDrop
    ) {
        lootTables.add(block, lootTable()
                .withPool(lootPool()
                        .add(alternatives(
                                lootTableItem(block)
                                        .when(toolMatches(item()
                                                .hasEnchantment(new EnchantmentPredicate(
                                                        SILK_TOUCH, atLeast(1))
                                                )
                                        )),

                                lootTableItem(fortuneDrop.get())
                                        .apply(setCount(minDrop != maxDrop
                                                ? between(minDrop, maxDrop)
                                                : exactly(minDrop)
                                        ))
                                        .apply(addOreBonusCount(BLOCK_FORTUNE))
                                        .apply(explosionDecay())
                        ))
                )
        );
    }

    public static <TOP extends Block, BODY extends Block> void vinesLootTable(RegistrateBlockLootTables lootTables, TOP topVine, BODY bodyVine) {
        final var lootTable = lootTable()
                .withPool(lootPool()
                        .add(lootTableItem(topVine)
                                .when(alternative(
                                        toolMatches(item().of(SHEARS)),
                                        toolMatches(item().hasEnchantment(
                                                new EnchantmentPredicate(SILK_TOUCH, atLeast(1)))
                                        )
                                ))
                                .otherwise(lootTableItem(topVine)
                                        .when(bonusLevelFlatChance(BLOCK_FORTUNE, 0.33f, 0.55f, 0.77f, 1.0f))
                                )
                        )
                );

        lootTables.add(topVine, lootTable);
        lootTables.add(bodyVine, lootTable);
    }

    public static <BLOCK extends NonNullSupplier<? extends Block>> void particleModel(
            DataGenContext<Block, ? extends Block> context,
            RegistrateBlockstateProvider provider,
            BLOCK block
    ) {
        provider.getVariantBuilder(context.get()).forAllStates($ -> ConfiguredModel.builder().modelFile(provider.models()
                .getBuilder(context.getName()).texture("particle", provider.blockTexture(block.get()))
        ).build());
    }
}
