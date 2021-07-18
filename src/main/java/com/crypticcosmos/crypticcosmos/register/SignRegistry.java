package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.sign.gromble.GrombleSignTileEntity;
import com.crypticcosmos.crypticcosmos.sign.gromble.GrombleStandingSignBlock;
import com.crypticcosmos.crypticcosmos.sign.gromble.GrombleWallSignBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.TileEntityEntry;
import net.minecraft.block.SoundType;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.item.SignItem;
import net.minecraft.util.ResourceLocation;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;

public class SignRegistry {
    //Gromble section
    public static final WoodType GROMBLE_WOOD_TYPE = WoodType.create(new ResourceLocation(CrypticCosmos.MOD_ID, "gromble").toString());

    public static final BlockEntry<GrombleStandingSignBlock> STANDING_GROMBLE_SIGN = getRegistrate().object("gromble_sign")
            .block(p -> new GrombleStandingSignBlock(p, GROMBLE_WOOD_TYPE))
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1.0F)
                    .sound(SoundType.WOOD))
            .register();

    public static final BlockEntry<GrombleWallSignBlock> GROMBLE_WALL_SIGN = getRegistrate().object("gromble_wall_sign")
            .block(p -> new GrombleWallSignBlock(p, GROMBLE_WOOD_TYPE))
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1f)
                    .sound(SoundType.WOOD))

            .item((currentBlock, p) -> new SignItem(p, STANDING_GROMBLE_SIGN.get(), currentBlock))
            .properties(p -> p.stacksTo(16))
            .build()

            .register();

    //Register the Tile Entity(Block Entity)
    public static final TileEntityEntry<GrombleSignTileEntity> GROMBLE_SIGN = getRegistrate().object("gromble_sign")
            .tileEntity(GrombleSignTileEntity::new)
            .validBlocks(GROMBLE_WALL_SIGN, STANDING_GROMBLE_SIGN)
            .renderer(() -> SignTileEntityRenderer::new)
            .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("SignRegistries initialized");
    }
}
