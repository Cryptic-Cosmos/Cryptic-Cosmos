package com.crypticcosmos.crypticcosmos.sign.mondrove;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.SignRegistries.MONDROVE_SIGN;

public class MondroveSignBlockEntity extends SignBlockEntity {
    private final BlockEntityType<? extends BlockEntity> type;

    public MondroveSignBlockEntity(BlockPos pos, BlockState state, BlockEntityType<? extends BlockEntity> type) {
        super(pos, state);
        this.type = type;
    }

    public MondroveSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
        this.type = MONDROVE_SIGN.getSibling(ForgeRegistries.BLOCK_ENTITIES).get();
    }

    @Nonnull
    @Override
    public BlockEntityType<? extends BlockEntity> getType() {
        return type;
    }
}
