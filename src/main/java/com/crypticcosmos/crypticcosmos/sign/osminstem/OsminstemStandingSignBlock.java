package com.crypticcosmos.crypticcosmos.sign.osminstem;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.SignRegistries.OSMINSTEM_WOOD_TYPE;

public class OsminstemStandingSignBlock extends StandingSignBlock {
    public OsminstemStandingSignBlock(Properties properties) {
        super(properties, OSMINSTEM_WOOD_TYPE);
    }

    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new OsminstemSignBlockEntity(pos, state);
    }
}
