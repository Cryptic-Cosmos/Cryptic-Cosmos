package com.crypticcosmos.crypticcosmos.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import javax.annotation.Nonnull;

@SuppressWarnings("deprecation")
public class OvergrownLunonBlock extends SnowyDirtBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public OvergrownLunonBlock(Properties properties) {
        super(properties);

        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(SNOWY, false));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        var blockState = context.getLevel().getBlockState(context.getClickedPos().above());
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(SNOWY, blockState.is(Blocks.SNOW_BLOCK) || blockState.is(Blocks.SNOW));
    }

    @Override
    @Nonnull
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @Override
    @Nonnull
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SNOWY);
    }
}