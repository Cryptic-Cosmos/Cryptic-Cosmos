package com.crypticcosmos.crypticcosmos.sign.mondrove;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.SignRegistries.MONDROVE_WOOD_TYPE;

public class MondroveStandingSignBlock extends StandingSignBlock {
    public MondroveStandingSignBlock(Properties properties) {
        super(properties, MONDROVE_WOOD_TYPE);
    }

    @Override
    public BlockEntity newBlockEntity(@Nonnull BlockPos pos, @Nonnull BlockState state) {
        return new MondroveSignBlockEntity(pos, state);
    }
}
