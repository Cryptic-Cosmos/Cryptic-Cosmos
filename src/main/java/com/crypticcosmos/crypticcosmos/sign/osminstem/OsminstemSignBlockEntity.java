package com.crypticcosmos.crypticcosmos.sign.osminstem;

import com.crypticcosmos.crypticcosmos.register.SignRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class OsminstemSignBlockEntity extends SignBlockEntity {
    private final BlockEntityType<? extends BlockEntity> type;

    public OsminstemSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
        this.type = SignRegistries.OSMINSTEM_SIGN.getSibling(ForgeRegistries.BLOCK_ENTITIES).get();
    }

    public OsminstemSignBlockEntity(BlockPos pos, BlockState state, BlockEntityType<? extends BlockEntity> type) {
        super(pos, state);
        this.type = type;
    }

    @Nonnull
    @Override
    public BlockEntityType<? extends BlockEntity> getType() {
        return type;
    }
}
