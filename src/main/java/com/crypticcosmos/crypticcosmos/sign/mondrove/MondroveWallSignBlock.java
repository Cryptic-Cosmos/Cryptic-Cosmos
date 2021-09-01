package com.crypticcosmos.crypticcosmos.sign.mondrove;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.SignRegistries.MONDROVE_WOOD_TYPE;

public class MondroveWallSignBlock extends WallSignBlock {
    public MondroveWallSignBlock(Properties propertiesIn) {
        super(propertiesIn, MONDROVE_WOOD_TYPE);
    }

    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new MondroveSignBlockEntity(pos, state);
    }
}
