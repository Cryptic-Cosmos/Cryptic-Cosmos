package com.hauntedchest.lovecraftplus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

@SuppressWarnings("NullableProblems")
public class MoonLog extends LogBlock implements IInfectable {
    public MoonLog() {
        super(MaterialColor.WOOD, Properties.from(Blocks.BIRCH_LOG));
        this.setDefaultState(this.getDefaultState().with(INFECTION_LEVEL, 0));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        this.infect(world, pos);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(INFECTION_LEVEL);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        //noinspection ConstantConditions
        return super.getStateForPlacement(context).with(INFECTION_LEVEL, 0);
    }

    @Override
    public boolean ticksRandomly(BlockState state) {
        return true;
    }
}
