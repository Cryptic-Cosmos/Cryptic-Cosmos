package com.crypticcosmos.crypticcosmos.sign.osminstem;

import com.crypticcosmos.crypticcosmos.register.SignRegistries;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nonnull;

public class OsminstemSignTileEntity extends SignTileEntity {
    @Nonnull
    @Override
    public TileEntityType<OsminstemSignTileEntity> getType() {
        return SignRegistries.OSMINSTEM_SIGN.get();
    }
}
