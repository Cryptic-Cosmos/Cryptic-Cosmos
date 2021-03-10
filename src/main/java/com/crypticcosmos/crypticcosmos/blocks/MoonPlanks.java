package com.crypticcosmos.crypticcosmos.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

@SuppressWarnings("NullableProblems")
public class MoonPlanks extends Block implements Infectable {
    public MoonPlanks() {
        super(Properties.copy(Blocks.BIRCH_PLANKS));

        this.registerDefaultState(this.defaultBlockState().setValue(INFECTION_LEVEL, 0));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        this.infect(world, pos);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(INFECTION_LEVEL);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(INFECTION_LEVEL, 0);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }
}
