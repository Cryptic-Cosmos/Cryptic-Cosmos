package com.crypticcosmos.crypticcosmos.sign;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SignRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CrypticCosmos.MOD_ID);

}
