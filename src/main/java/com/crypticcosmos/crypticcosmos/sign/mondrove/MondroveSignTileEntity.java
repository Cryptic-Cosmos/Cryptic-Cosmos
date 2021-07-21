package com.crypticcosmos.crypticcosmos.sign.mondrove;

import com.crypticcosmos.crypticcosmos.register.SignRegistries;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;

public class MondroveSignTileEntity extends SignTileEntity {
    @Nonnull
    @Override
    public TileEntityType<?> getType() {
        return SignRegistries.MONDROVE_SIGN.getSibling(ForgeRegistries.TILE_ENTITIES).get();
    }
}
