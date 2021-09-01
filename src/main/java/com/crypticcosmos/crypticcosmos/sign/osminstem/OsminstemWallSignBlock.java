package com.crypticcosmos.crypticcosmos.sign.osminstem;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.SignRegistries.OSMINSTEM_WOOD_TYPE;

public class OsminstemWallSignBlock extends WallSignBlock {
    public OsminstemWallSignBlock(Properties propertiesIn) {
        super(propertiesIn, OSMINSTEM_WOOD_TYPE);
    }

    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new OsminstemSignBlockEntity(pos, state);
    }
}
