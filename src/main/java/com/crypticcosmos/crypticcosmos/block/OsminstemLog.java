package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.util.Strippable;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

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
}
