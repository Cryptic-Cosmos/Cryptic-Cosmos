package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.util.Strippable;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nonnull;

public class OsminstemLog extends RotatedPillarBlock implements Strippable {
    private final Block strippedBlock;

    public OsminstemLog(Properties properties, BlockEntry<? extends Block> strippedBlock) {
        super(properties);
        this.strippedBlock = strippedBlock.get();
        this.registerDefaultState(this.defaultBlockState());
    }

    public OsminstemLog(Properties properties) {
        super(properties);
        this.strippedBlock = this;
        this.registerDefaultState(this.defaultBlockState());
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
}
