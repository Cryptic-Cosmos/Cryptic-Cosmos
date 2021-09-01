package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.util.Strippable;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

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
    public InteractionResult use(@Nonnull BlockState state,
                                 @Nonnull Level world,
                                 @Nonnull BlockPos pos,
                                 @Nonnull Player player,
                                 @Nonnull InteractionHand hand,
                                 @Nonnull BlockHitResult rayTraceResult) {
        return strip(strippedBlock,
                player.getItemInHand(hand),
                world, pos, state, player, hand);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(@Nonnull BlockState state, @Nonnull ServerLevel world, @Nonnull BlockPos pos, @Nonnull Random rand) {
        this.infect(world, pos);
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(INFECTION_LEVEL);
    }

    @Override
    public BlockState getStateForPlacement(@Nonnull BlockPlaceContext context) {
        //noinspection ConstantConditions
        return super.getStateForPlacement(context).setValue(INFECTION_LEVEL, 0);
    }

    @Override
    public boolean isRandomlyTicking(@Nonnull BlockState state) {
        return true;
    }
}
