package com.crypticcosmos.crypticcosmos.sign.mondrove;

import com.crypticcosmos.crypticcosmos.sign.gromble.GrombleSignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.SignRegistry.MONDROVE_WOOD_TYPE;

public class MondroveWallSignBlock extends WallSignBlock {
    public MondroveWallSignBlock(Properties propertiesIn) {
        super(propertiesIn, MONDROVE_WOOD_TYPE);
    }

    @Override
    public boolean hasTileEntity(BlockState stateIn) {
        return true;
    }

    @Override
    public TileEntity newBlockEntity(@Nonnull IBlockReader worldIn) {
        return new MondroveSignTileEntity();
    }
}
