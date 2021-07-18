package com.crypticcosmos.crypticcosmos.sign;

import com.crypticcosmos.crypticcosmos.register.SignRegistry;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nonnull;

public class CustomSignTileEntity extends SignTileEntity {
    @Override
    public TileEntityType<CustomSignTileEntity> getType()
    {
        return SignRegistry.GROMBLE_SIGN.get();
    }
}
