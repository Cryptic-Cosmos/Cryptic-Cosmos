package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;

public class SignRegistry {
    // public static final WoodType GROMBLE_WOOD_TYPE = WoodType.create(new ResourceLocation(CrypticCosmos.MOD_ID, "gromble").toString());
    //
    // //Register the sign (Wall & Standing)
    // public static final BlockEntry<CustomStandingSignBlock> STANDING_GROMBLE_SIGN = getRegistrate().object("gromble_sign")
    //         .block(p -> new CustomStandingSignBlock(p, GROMBLE_WOOD_TYPE))
    //         .initialProperties(Material.WOOD)
    //         .properties(p -> p.noCollission()
    //                 .strength(1.0F)
    //                 .sound(SoundType.WOOD))
    //         .register();
    //
    // public static final BlockEntry<CustomWallSignBlock> GROMBLE_WALL_SIGN = getRegistrate().object("gromble_wall_sign")
    //         .block(p -> new CustomWallSignBlock(p, GROMBLE_WOOD_TYPE))
    //         .initialProperties(Material.WOOD)
    //         .properties(p -> p.noCollission()
    //                 .strength(1f)
    //                 .sound(SoundType.WOOD))
    //
    //         .item((currentBlock, p) -> new SignItem(p, STANDING_GROMBLE_SIGN.get(), currentBlock))
    //         .properties(p -> p.stacksTo(16))
    //         .build()
    //
    //         .register();
    //
    // //Register the Tile Entity(Block Entity)
    // public static final TileEntityEntry<CustomSignTileEntity> GROMBLE_SIGN = getRegistrate().object("gromble_sign")
    //         .tileEntity(CustomSignTileEntity::new)
    //         .validBlocks(GROMBLE_WALL_SIGN, STANDING_GROMBLE_SIGN)
    //         .renderer(() -> SignTileEntityRenderer::new)
    //         .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("SignRegistries initialized");
    }
}
