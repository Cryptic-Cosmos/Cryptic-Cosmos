package com.crypticcosmos.crypticcosmos.util;

import com.crypticcosmos.crypticcosmos.blocks.Infectable;
import com.crypticcosmos.crypticcosmos.blocks.MondroveLog;
import com.crypticcosmos.crypticcosmos.blocks.OvergrownLunonBlock;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.block.*;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ConfiguredModel;

public class RegistrationUtils {
    public static ConfiguredModel[] infectableBlockModels(BlockState state,
                                                          DataGenContext<Block, ? extends Infectable> context,
                                                          RegistrateBlockstateProvider provider) {
        Integer infectionLevel = state.getValue(Infectable.INFECTION_LEVEL);
        final String id = context.getId().getPath();

        return ConfiguredModel.builder()
                .modelFile(provider.models().cubeAll(id, provider.modLoc(id + infectionLevel)))
                .build();
    }

    public static ConfiguredModel[] mondroveLogModels(BlockState state,
                                                      DataGenContext<Block, MondroveLog> context,
                                                      RegistrateBlockstateProvider provider,
                                                      boolean isStripped) {
        int infectionLevel = state.getValue(MondroveLog.INFECTION_LEVEL);
        Axis axis = getAxisFromBlockState(state);
        final String id = context.getId().getPath();

        return ConfiguredModel.builder().modelFile(provider.models().cubeColumn(id,
                provider.modLoc(!isStripped ? "mondrove_log" + infectionLevel : "stripped_mondrove_log"),
                provider.modLoc(!isStripped ? "mondrove_log_top" : "stripped_mondrove_log_top")))
                .rotationX(axis.equals(Axis.Z) || axis.equals(Axis.X) ? 90 : 0)
                .rotationY(axis.equals(Axis.X) ? 90 : 0).build();
    }

    public static ConfiguredModel[] mondroveWoodModels(BlockState state,
                                                       DataGenContext<Block, MondroveLog> context,
                                                       RegistrateBlockstateProvider provider) {
        Axis axis = getAxisFromBlockState(state);

        return ConfiguredModel.builder().modelFile(provider.cubeAll(context.get()))
                .rotationX(axis.equals(Axis.Z) || axis.equals(Axis.X) ? 90 : 0)
                .rotationY(axis.equals(Axis.X) ? 90 : 0).build();
    }

    public static ConfiguredModel[] fungalLunonModels(BlockState state, DataGenContext<Block, OvergrownLunonBlock> context, RegistrateBlockstateProvider provider) {
        boolean isSnowy = state.getValue(OvergrownLunonBlock.SNOWY);
        Direction axis = state.getValue(OvergrownLunonBlock.FACING);
        final ConfiguredModel.Builder<?> builder = ConfiguredModel.builder();
        final String id = context.getId().getPath();

        int degree = (int) axis.toYRot();

        if (!isSnowy) {
            builder.modelFile(provider.models().cubeBottomTop(
                    id,
                    provider.modLoc(id + "_side"),
                    provider.modLoc("lunon"),
                    provider.modLoc(id + "_top")))
                    .rotationY(degree);
        } else {
            builder.modelFile(provider.models().cubeBottomTop(
                    id,
                    provider.modLoc("overgrown_lunon_snow"),
                    provider.modLoc("lunon"),
                    provider.modLoc(id + "_top")));
        }

        return builder.build();
    }

    public static void leavesModel(DataGenContext<Block, LeavesBlock> context, RegistrateBlockstateProvider provider) {
        provider.getVariantBuilder(context.get())
                .forAllStates(state -> ConfiguredModel.builder().modelFile(
                        provider.models()
                                .withExistingParent(context.getId().getPath(), provider.mcLoc("leaves"))
                                .texture("all", context.getId())
                        ).build()
                );
    }

    public static void crossModel(DataGenContext<Block, ? extends Block> context, RegistrateBlockstateProvider provider) {
        provider.getVariantBuilder(context.get())
                .forAllStates(state -> ConfiguredModel.builder().modelFile(
                        provider.models().cross(context.getId().getPath(), context.getId())).build()
                );
    }

    public static void doorModel(DataGenContext<Block, ? extends DoorBlock> context, RegistrateBlockstateProvider provider) {
        String id = context.getId().getPath();
        ResourceLocation doorBottom = provider.modLoc(id + "_bottom");
        ResourceLocation doorTop = provider.modLoc(id + "_top");

        provider.doorBlock(context.get(),
                provider.models().doorBottomLeft(id, doorBottom, doorTop),
                provider.models().doorBottomRight(id, doorBottom, doorTop),
                provider.models().doorTopLeft(id, doorBottom, doorTop),
                provider.models().doorTopRight(id, doorBottom, doorTop)
        );
    }

    public static void buttonModel(DataGenContext<Block, ? extends AbstractButtonBlock> context, RegistrateBlockstateProvider provider, NonNullSupplier<? extends Block> planks) {
        final String id = context.getId().getPath();
        final ConfiguredModel.Builder<?> buttonModel = ConfiguredModel.builder().modelFile(provider.models()
                .withExistingParent(id, "button")
                .texture("texture", planks.get().getRegistryName()));

        final ConfiguredModel.Builder<?> buttonPressedModel = ConfiguredModel.builder().modelFile(provider.models()
                .withExistingParent(id + "_pressed", "button_pressed")
                .texture("texture", planks.get().getRegistryName()));

        final ConfiguredModel.Builder<?> buttonInventoryModel = ConfiguredModel.builder().modelFile(provider.models()
                .withExistingParent(id + "_inventory", "button_inventory")
                .texture("texture", planks.get().getRegistryName()));

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

    public static void pressurePlateModels(DataGenContext<Block, ? extends PressurePlateBlock> context, RegistrateBlockstateProvider provider, NonNullSupplier<? extends Block> planks) {
        final String id = context.getId().getPath();
        provider.getVariantBuilder(context.get())
                .forAllStates(state -> {
                    final String postfix = state.getValue(PressurePlateBlock.POWERED) ? "_down" : "";

                    return ConfiguredModel.builder().modelFile(provider.models()
                            .withExistingParent(id + postfix, "pressure_plate" + postfix)
                            .texture("texture", planks.get().getRegistryName())).build();
                });
    }

    public static Axis getAxisFromBlockState(BlockState state) {
        return state.getValue(BlockStateProperties.AXIS);
    }
}
