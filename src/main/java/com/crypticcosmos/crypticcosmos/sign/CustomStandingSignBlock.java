package com.crypticcosmos.crypticcosmos.sign;

import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WoodType;

public class CustomStandingSignBlock extends StandingSignBlock {
    public CustomStandingSignBlock(Properties propertiesIn, WoodType woodTypeIn) {
        super(propertiesIn, woodTypeIn);
    }

    // @Override
    // public boolean hasTileEntity(BlockState stateIn) {
    //     return true;
    // }
    //
    // @Override
    // public TileEntity newBlockEntity(@Nonnull IBlockReader worldIn) {
    //     return new CustomSignTileEntity(GROMBLE_SIGN.get());
    // }
}
