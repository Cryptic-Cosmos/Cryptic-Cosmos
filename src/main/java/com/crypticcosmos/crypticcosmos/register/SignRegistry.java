package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.sign.gromble.GrombleSignTileEntity;
import com.crypticcosmos.crypticcosmos.sign.gromble.GrombleStandingSignBlock;
import com.crypticcosmos.crypticcosmos.sign.gromble.GrombleWallSignBlock;
import com.crypticcosmos.crypticcosmos.sign.mondrove.MondroveSignTileEntity;
import com.crypticcosmos.crypticcosmos.sign.mondrove.MondroveStandingSignBlock;
import com.crypticcosmos.crypticcosmos.sign.mondrove.MondroveWallSignBlock;
import com.crypticcosmos.crypticcosmos.sign.osminstem.OsminstemSignTileEntity;
import com.crypticcosmos.crypticcosmos.sign.osminstem.OsminstemStandingSignBlock;
import com.crypticcosmos.crypticcosmos.sign.osminstem.OsminstemWallSignBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.TileEntityEntry;
import net.minecraft.block.SoundType;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.item.SignItem;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;

public class SignRegistry {
    public static final WoodType MONDROVE_WOOD_TYPE = WoodType.create("mondrove");
    public static final WoodType OSMINSTEM_WOOD_TYPE = WoodType.create("osminstem");
    public static final WoodType GROMBLE_WOOD_TYPE = WoodType.create("gromble");

    //Register the sign (Wall & Standing)
    public static final BlockEntry<GrombleStandingSignBlock> STANDING_GROMBLE_SIGN = getRegistrate().object("gromble_sign")
            .block(GrombleStandingSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1.0F)
                    .sound(SoundType.WOOD))

            .register();

    public static final BlockEntry<GrombleWallSignBlock> GROMBLE_WALL_SIGN = getRegistrate().object("gromble_wall_sign")
            .block(GrombleWallSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1f)
                    .sound(SoundType.WOOD))

            .item((currentBlock, p) -> new SignItem(p, STANDING_GROMBLE_SIGN.get(), currentBlock))
            .model((context, provider) -> provider.generated(() -> STANDING_GROMBLE_SIGN.asStack().getItem()))
            .properties(p -> p.stacksTo(16))
            .build()

            .register();

    public static final BlockEntry<MondroveStandingSignBlock> STANDING_MONDROVE_SIGN = getRegistrate().object("mondrove_sign")
            .block(MondroveStandingSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1.0F)
                    .sound(SoundType.WOOD))
            .register();

    public static final BlockEntry<MondroveWallSignBlock> MONDROVE_WALL_SIGN = getRegistrate().object("mondrove_wall_sign")
            .block(MondroveWallSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1f)
                    .sound(SoundType.WOOD))

            .item((currentBlock, p) -> new SignItem(p, STANDING_MONDROVE_SIGN.get(), currentBlock))
            .model((context, provider) -> provider.generated(() -> STANDING_MONDROVE_SIGN.asStack().getItem()))
            .properties(p -> p.stacksTo(16))
            .build()

            .register();

    public static final BlockEntry<OsminstemStandingSignBlock> STANDING_OSMINSTEM_SIGN = getRegistrate().object("osminstem_sign")
            .block(OsminstemStandingSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1.0F)
                    .sound(SoundType.WOOD))
            .register();

    public static final BlockEntry<OsminstemWallSignBlock> OSMINSTEM_WALL_SIGN = getRegistrate().object("osminstem_wall_sign")
            .block(OsminstemWallSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1f)
                    .sound(SoundType.WOOD))

            .item((currentBlock, p) -> new SignItem(p, STANDING_OSMINSTEM_SIGN.get(), currentBlock))
            .model((context, provider) -> provider.generated(() -> STANDING_OSMINSTEM_SIGN.asStack().getItem()))
            .properties(p -> p.stacksTo(16))
            .build()

            .register();

    //Register the Tile Entity(Block Entity)
    public static final TileEntityEntry<MondroveSignTileEntity> MONDROVE_SIGN = getRegistrate().object("mondrove_sign")
            .tileEntity(MondroveSignTileEntity::new)
            .validBlocks(MONDROVE_WALL_SIGN, STANDING_MONDROVE_SIGN)
            .renderer(() -> SignTileEntityRenderer::new)
            .register();

    public static final TileEntityEntry<OsminstemSignTileEntity> OSMINSTEM_SIGN = getRegistrate().object("osminstem_sign")
            .tileEntity(OsminstemSignTileEntity::new)
            .validBlocks(OSMINSTEM_WALL_SIGN, STANDING_OSMINSTEM_SIGN)
            .renderer(() -> SignTileEntityRenderer::new)
            .register();

    public static final TileEntityEntry<GrombleSignTileEntity> GROMBLE_SIGN = getRegistrate().object("gromble_sign")
            .tileEntity(GrombleSignTileEntity::new)
            .validBlocks(GROMBLE_WALL_SIGN, STANDING_GROMBLE_SIGN)
            .renderer(() -> SignTileEntityRenderer::new)
            .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("SignRegistries initialized");
    }
}
