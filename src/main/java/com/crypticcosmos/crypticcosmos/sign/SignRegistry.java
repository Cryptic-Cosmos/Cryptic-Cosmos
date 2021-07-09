package com.crypticcosmos.crypticcosmos.sign;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SignRegistry {
    //TODO: PugzAreCute: Register Signs
    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, CrypticCosmos.MOD_ID);
    //public static final RegistryObject<TileEntityType<CustomSignTileEntity>> GROMBLE_SIGN = TILES.register("gromble_sign", () -> TileEntityType.Builder.of(CustomSignTileEntity::new, GROMBLE_WALL_SIGN.get(), GROMBLE_STANDING_SIGN.get()).build(null));
}
