package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.util.Strippable;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.Random;

public class MondroveLog extends RotatedPillarBlock implements Infectable, Strippable {
    private final Block strippedBlock;

    public MondroveLog(Properties properties, BlockEntry<? extends Block> strippedBlock) {
        super(properties);
        this.strippedBlock = strippedBlock.get();
        this.registerDefaultState(this.defaultBlockState().setValue(INFECTION_LEVEL, 0));
    }

    public MondroveLog(Properties properties) {
        super(properties);
        this.strippedBlock = this;
        this.registerDefaultState(this.defaultBlockState().setValue(INFECTION_LEVEL, 0));
    }

    @SuppressWarnings("deprecation")
    @Nonnull
    @Override
    public ActionResultType use(@Nonnull BlockState state,
                                @Nonnull World world,
                                @Nonnull BlockPos pos,
                                @Nonnull PlayerEntity player,
                                @Nonnull Hand hand,
                                @Nonnull BlockRayTraceResult rayTraceResult) {
        return strip(strippedBlock,
                player.getItemInHand(hand),
                world, pos, state, player, hand);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(@Nonnull BlockState state, @Nonnull ServerWorld world, @Nonnull BlockPos pos, @Nonnull Random rand) {
        this.infect(world, pos);
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(INFECTION_LEVEL);
    }

    @Override
    public BlockState getStateForPlacement(@Nonnull BlockItemUseContext context) {
        //noinspection ConstantConditions
        return super.getStateForPlacement(context).setValue(INFECTION_LEVEL, 0);
    }

    @Override
    public boolean isRandomlyTicking(@Nonnull BlockState state) {
        return true;
    }
}
