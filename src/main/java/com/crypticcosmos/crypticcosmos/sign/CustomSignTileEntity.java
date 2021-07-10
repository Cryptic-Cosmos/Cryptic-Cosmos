package com.crypticcosmos.crypticcosmos.sign;

import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nonnull;

public class CustomSignTileEntity extends SignTileEntity {
    private final TileEntityType<CustomSignTileEntity> tileEntityType;

    public CustomSignTileEntity(TileEntityType<CustomSignTileEntity> type) {
        this.tileEntityType = type;
    }

    @Nonnull
    @Override
    public TileEntityType<?> getType() {
        return tileEntityType;
    }
}
