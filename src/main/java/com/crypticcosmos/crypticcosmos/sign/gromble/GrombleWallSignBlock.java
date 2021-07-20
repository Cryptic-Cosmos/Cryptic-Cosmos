package com.crypticcosmos.crypticcosmos.sign.gromble;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.SignRegistries.GROMBLE_WOOD_TYPE;

public class GrombleWallSignBlock extends WallSignBlock {
    public GrombleWallSignBlock(Properties propertiesIn) {
        super(propertiesIn, GROMBLE_WOOD_TYPE);
    }

    @Override
    public boolean hasTileEntity(BlockState stateIn) {
        return true;
    }

    @Override
    public TileEntity newBlockEntity(@Nonnull IBlockReader worldIn) {
        return new GrombleSignTileEntity();
    }
}
