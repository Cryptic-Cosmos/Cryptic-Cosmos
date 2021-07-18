package com.crypticcosmos.crypticcosmos.util;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.block.Infectable;
import com.crypticcosmos.crypticcosmos.block.MondroveLog;
import com.crypticcosmos.crypticcosmos.block.OvergrownLunonBlock;
import com.crypticcosmos.crypticcosmos.register.LunonRegistries;
import com.crypticcosmos.crypticcosmos.register.MondroveRegistries;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.block.*;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ConfiguredModel;

import java.util.function.Supplier;

import static net.minecraft.advancements.criterion.ItemPredicate.Builder.item;
import static net.minecraft.advancements.criterion.MinMaxBounds.IntBound.atLeast;
import static net.minecraft.enchantment.Enchantments.BLOCK_FORTUNE;
import static net.minecraft.enchantment.Enchantments.SILK_TOUCH;
import static net.minecraft.loot.AlternativesLootEntry.alternatives;
import static net.minecraft.loot.ConstantRange.exactly;
import static net.minecraft.loot.ItemLootEntry.lootTableItem;
import static net.minecraft.loot.LootPool.lootPool;
import static net.minecraft.loot.LootTable.lootTable;
import static net.minecraft.loot.RandomValueRange.between;
import static net.minecraft.loot.conditions.Alternative.alternative;
import static net.minecraft.loot.conditions.MatchTool.toolMatches;
import static net.minecraft.loot.conditions.TableBonus.bonusLevelFlatChance;
import static net.minecraft.loot.functions.ApplyBonus.addOreBonusCount;
import static net.minecraft.loot.functions.ExplosionDecay.explosionDecay;
import static net.minecraft.loot.functions.SetCount.setCount;
import static net.minecraftforge.client.model.generators.ConfiguredModel.builder;
import static net.minecraftforge.common.Tags.Items.SHEARS;

public class RegistrationUtils {
    public static ConfiguredModel[] infectableBlockModels(BlockState state,
                                                          DataGenContext<Block, ? extends Infectable> context,
                                                          RegistrateBlockstateProvider provider) {
        String infectionLevel = state.getValue(Infectable.INFECTION_LEVEL) == 0 ? ""
                : state.getValue(Infectable.INFECTION_LEVEL).toString();
        final String name = context.getId().getPath() + infectionLevel;

        return builder()
                .modelFile(provider.models().cubeAll(name, blockTexture(context, infectionLevel)))
                .build();
    }

    public static ConfiguredModel[] mondroveLogModels(BlockState state,
                                                      DataGenContext<Block, MondroveLog> context,
                                                      RegistrateBlockstateProvider provider,
                                                      boolean isStripped) {
        String infectionLevel = state.getValue(Infectable.INFECTION_LEVEL) == 0 ? ""
                : state.getValue(Infectable.INFECTION_LEVEL).toString();
        Axis axis = getAxisFromBlockState(state);
        final String name = context.getId().getPath() + infectionLevel;

        return builder().modelFile(provider.models().cubeColumn(
                name,
                blockTexture(isStripped ? "stripped_" : "", MondroveRegistries.MONDROVE_LOG.get(), !isStripped ? infectionLevel : ""),
                blockTexture(isStripped ? "stripped_" : "", MondroveRegistries.MONDROVE_LOG.get(), "_top")))
                .rotationX(axis.equals(Axis.Z) || axis.equals(Axis.X) ? 90 : 0)
                .rotationY(axis.equals(Axis.X) ? 90 : 0).build();
    }

    public static ConfiguredModel[] mondroveWoodModels(BlockState state,
                                                       DataGenContext<Block, MondroveLog> context,
                                                       RegistrateBlockstateProvider provider,
                                                       boolean isStripped) {
        Axis axis = getAxisFromBlockState(state);
        String infectionLevel = state.getValue(Infectable.INFECTION_LEVEL) == 0 ? ""
                : state.getValue(Infectable.INFECTION_LEVEL).toString();
        final String name = context.getId().getPath() + infectionLevel;

        return builder().modelFile(provider.models().cubeAll(
                name,
                blockTexture(isStripped ? "stripped_" : "",
                        MondroveRegistries.MONDROVE_LOG.get(),
                        !isStripped ? infectionLevel : ""
                ))
        ).rotationX(axis.equals(Axis.Z) || axis.equals(Axis.X) ? 90 : 0)
                .rotationY(axis.equals(Axis.X) ? 90 : 0).build();
    }

    public static void overgrownLunonModels(DataGenContext<Block, OvergrownLunonBlock> context, RegistrateBlockstateProvider provider) {
        provider.getVariantBuilder(context.get()).forAllStates(
                blockState -> {
                    boolean isSnowy = blockState.getValue(OvergrownLunonBlock.SNOWY);
                    Direction axis = blockState.getValue(OvergrownLunonBlock.FACING);
                    final ConfiguredModel.Builder<?> builder = builder();
                    final String id = context.getId().getPath();

                    int degree = (int) axis.toYRot();

                    if (!isSnowy) {
                        builder.modelFile(provider.models().cubeBottomTop(
                                id,
                                blockTexture(context, "_side"),
                                provider.blockTexture(LunonRegistries.LUNON.get()),
                                blockTexture(context, "_top")))
                                .rotationY(degree);
                    } else {
                        builder.modelFile(provider.models().cubeBottomTop(
                                id,
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
                                .withExistingParent(context.getId().getPath(), provider.mcLoc("leaves"))
                                .texture("all", provider.blockTexture(context.get()))
                        ).build()
                );
    }

    public static void crossModel(DataGenContext<Block, ? extends Block> context, RegistrateBlockstateProvider provider) {
        final String name = context.getId().getPath();
        provider.getVariantBuilder(context.get())
                .forAllStates(state -> builder().modelFile(
                        provider.models().cross(name, provider.blockTexture(context.get()))).build()
                );
    }

    public static void doorModel(DataGenContext<Block, ? extends DoorBlock> context, RegistrateBlockstateProvider provider) {
        provider.doorBlock(context.get(),
                RegistrationUtils.blockTexture(context, "_bottom"),
                RegistrationUtils.blockTexture(context, "_top"));
    }

    public static void buttonModel(DataGenContext<Block, ? extends AbstractButtonBlock> context, RegistrateBlockstateProvider provider, NonNullSupplier<? extends Block> planks) {
        final String id = context.getId().getPath();
        final ConfiguredModel.Builder<?> buttonModel = builder().modelFile(provider.models()
                .withExistingParent(id, "button")
                .texture("texture", provider.blockTexture(planks.get())));

        final ConfiguredModel.Builder<?> buttonPressedModel = builder().modelFile(provider.models()
                .withExistingParent(id + "_pressed", "button_pressed")
                .texture("texture", provider.blockTexture(planks.get())));

        //noinspection unused
        final ConfiguredModel.Builder<?> buttonInventoryModel = builder().modelFile(provider.models()
                .withExistingParent(id + "_inventory", "button_inventory")
                .texture("texture", provider.blockTexture(planks.get())));

        provider.getVariantBuilder(context.get())
                .forAllStates(state -> {
                    final AttachFace attachedFace = state.getValue(AbstractButtonBlock.FACE);
                    final Direction direction = state.getValue(AbstractButtonBlock.FACING);
                    final boolean isPowered = state.getValue(AbstractButtonBlock.POWERED);

                    int rotationY = 0;
                    if (direction.equals(Direction.EAST)) rotationY = 90;
                    if (direction.equals(Direction.SOUTH)) rotationY = 180;
                    if (direction.equals(Direction.WEST)) rotationY = 270;

                    int rotationX = 0;
                    if (attachedFace.equals(AttachFace.CEILING)) rotationX = 180;
                    else if (attachedFace.equals(AttachFace.WALL)) rotationX = 90;

                    if (!isPowered) return buttonModel.rotationX(rotationX).rotationY(rotationY).build();
                    else return buttonPressedModel.rotationX(rotationX).rotationY(rotationY).build();
                });
    }

    public static void pressurePlateModels(DataGenContext<Block, ? extends PressurePlateBlock> context,
                                           RegistrateBlockstateProvider provider,
                                           NonNullSupplier<? extends Block> planks) {
        final String id = context.getId().getPath();
        provider.getVariantBuilder(context.get())
                .forAllStates(state -> {
                    final String parentSuffix = state.getValue(PressurePlateBlock.POWERED) ? "_down" : "_up";
                    final String idSuffix = state.getValue(PressurePlateBlock.POWERED) ? "_down" : "";

                    return builder().modelFile(provider.models()
                            .withExistingParent(id + idSuffix, "pressure_plate" + parentSuffix)
                            .texture("texture", provider.blockTexture(planks.get()))).build();
                });
    }

    public static Axis getAxisFromBlockState(BlockState state) {
        return state.getValue(BlockStateProperties.AXIS);
    }

    public static ResourceLocation blockTexture(Supplier<? extends Block> block, String suffix) {
        //noinspection ConstantConditions
        return CrypticCosmos.id("block/" + block.get().getRegistryName().getPath() + suffix);
    }

    public static ResourceLocation blockTexture(String prefix, Block block, String suffix) {
        //noinspection ConstantConditions
        return CrypticCosmos.id("block/" + prefix + block.getRegistryName().getPath() + suffix);
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
                                        .apply(addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                                        .apply(explosionDecay())
                        ))
                )
        );
    }

    public static void standingSignModel(DataGenContext<Block, StandingSignBlock> context, RegistrateBlockstateProvider provider) {
        provider.getVariantBuilder(context.get())
                .forAllStates(state -> builder().modelFile(
                        provider.models()
                                .withExistingParent(context.getId().getPath(), provider.mcLoc("sign"))
                                .texture("all", provider.blockTexture(context.get()))
                        ).build()
                );
    }

    public static <TOP extends Block, BODY extends Block> void vinesLootTable(RegistrateBlockLootTables lootTables, TOP topVine, BODY bodyVine) {
        final LootTable.Builder lootTable = lootTable()
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
}
