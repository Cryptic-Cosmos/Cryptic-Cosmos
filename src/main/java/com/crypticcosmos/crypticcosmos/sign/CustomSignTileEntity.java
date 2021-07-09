package com.crypticcosmos.crypticcosmos.sign;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

public class CustomSignTileEntity extends SignTileEntity {
    @Override
    public TileEntityType<CustomSignTileEntity> getType()
    {
        return CUSTOM_SIGN.get();
    }
}
