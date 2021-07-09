package com.crypticcosmos.crypticcosmos.sign;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;

public class CustomWallSignBlock extends WallSignBlock {

        public CustomWallSignBlock(Properties propertiesIn, WoodType woodTypeIn)
        {
            super(propertiesIn, woodTypeIn);
        }

        @Override
        public boolean hasTileEntity(BlockState stateIn)
        {
            return true;
        }

       /* @Override
        public TileEntity newBlockEntity(IBlockReader worldIn)
        {
            return new CustomSignTileEntity();
        } */
}
