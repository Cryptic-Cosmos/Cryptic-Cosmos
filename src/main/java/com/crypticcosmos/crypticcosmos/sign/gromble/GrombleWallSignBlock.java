package com.crypticcosmos.crypticcosmos.sign.gromble;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.SignRegistries.GROMBLE_WOOD_TYPE;

public class GrombleWallSignBlock extends WallSignBlock {
    public GrombleWallSignBlock(Properties propertiesIn) {
        super(propertiesIn, GROMBLE_WOOD_TYPE);
    }

    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new GrombleSignBlockEntity(pos, state);
    }
}
