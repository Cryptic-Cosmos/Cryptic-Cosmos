package com.crypticcosmos.crypticcosmos.sign.osminstem;

import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.SignRegistries.OSMINSTEM_WOOD_TYPE;

public class OsminstemStandingSignBlock extends StandingSignBlock {
    public OsminstemStandingSignBlock(Properties properties) {
        super(properties, OSMINSTEM_WOOD_TYPE);
    }

    @Override
    public boolean hasTileEntity(BlockState stateIn) {
        return true;
    }

    @Override
    public TileEntity newBlockEntity(@Nonnull IBlockReader worldIn) {
        return new OsminstemSignTileEntity();
    }
}
