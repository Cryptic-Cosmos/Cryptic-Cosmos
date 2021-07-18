package com.crypticcosmos.crypticcosmos.sign.mondrove;

import com.crypticcosmos.crypticcosmos.sign.gromble.GrombleSignTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.register.SignRegistry.MONDROVE_WOOD_TYPE;

public class MondroveStandingSignBlock extends StandingSignBlock {
    public MondroveStandingSignBlock(Properties properties) {
        super(properties, MONDROVE_WOOD_TYPE);
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
