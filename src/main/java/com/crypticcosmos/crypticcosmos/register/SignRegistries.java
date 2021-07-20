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
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.TileEntityEntry;
import net.minecraft.block.SoundType;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.item.SignItem;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;
import static com.crypticcosmos.crypticcosmos.CrypticCosmos.id;
import static com.crypticcosmos.crypticcosmos.register.GrombleRegistries.GROMBLE_PLANKS;
import static com.crypticcosmos.crypticcosmos.register.MondroveRegistries.MONDROVE_PLANKS;
import static com.crypticcosmos.crypticcosmos.register.OsminstemRegistries.OSMINSTEM_PLANKS;
import static com.crypticcosmos.crypticcosmos.util.RegistrationUtils.particleModel;

@SuppressWarnings("deprecation")
public class SignRegistries {
    public static final WoodType MONDROVE_WOOD_TYPE = WoodType.create(id("mondrove").toString());
    public static final WoodType OSMINSTEM_WOOD_TYPE = WoodType.create(id("osminstem").toString());
    public static final WoodType GROMBLE_WOOD_TYPE = WoodType.create(id("gromble").toString());

    //Register the sign (Wall & Standing)
    public static final BlockEntry<GrombleWallSignBlock> GROMBLE_WALL_SIGN = getRegistrate().object("gromble_wall_sign")
            .block(GrombleWallSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1f)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, GROMBLE_PLANKS))
            .register();

    public static final BlockEntry<GrombleStandingSignBlock> STANDING_GROMBLE_SIGN = getRegistrate().object("gromble_sign")
            .block(GrombleStandingSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1.0F)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, GROMBLE_PLANKS))

            // .item((currentBlock, p) -> new SignItem(p, currentBlock, GROMBLE_WALL_SIGN.get()))
            // .model((context, provider) -> provider.generated(context))
            // .properties(p -> p.stacksTo(16))
            // .build()

            .register();

    public static final ItemEntry<SignItem> GROMBLE_SIGN_ITEM = getRegistrate().object("gromble_sign")
            .item((p) -> new SignItem(p, STANDING_GROMBLE_SIGN.get(), GROMBLE_WALL_SIGN.get()))
            .model((context, provider) -> provider.generated(context))
            .properties(p -> p.stacksTo(16))
            .register();

    public static final BlockEntry<MondroveWallSignBlock> MONDROVE_WALL_SIGN = getRegistrate().object("mondrove_wall_sign")
            .block(MondroveWallSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1f)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, MONDROVE_PLANKS))
            .register();

    public static final BlockEntry<MondroveStandingSignBlock> STANDING_MONDROVE_SIGN = getRegistrate().object("mondrove_sign")
            .block(MondroveStandingSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1.0F)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, MONDROVE_PLANKS))
            .register();

    public static final ItemEntry<SignItem> MONDROVE_SIGN_ITEM = getRegistrate().object("mondrove_sign")
            .item((p) -> new SignItem(p, STANDING_MONDROVE_SIGN.get(), MONDROVE_WALL_SIGN.get()))
            .model((context, provider) -> provider.generated(context))
            .properties(p -> p.stacksTo(16))
            .register();

    public static final BlockEntry<OsminstemWallSignBlock> OSMINSTEM_WALL_SIGN = getRegistrate().object("osminstem_wall_sign")
            .block(OsminstemWallSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1f)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, OSMINSTEM_PLANKS))
            .register();

    public static final BlockEntry<OsminstemStandingSignBlock> STANDING_OSMINSTEM_SIGN = getRegistrate().object("osminstem_sign")
            .block(OsminstemStandingSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1.0F)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, OSMINSTEM_PLANKS))

            // .item((currentBlock, p) -> new SignItem(p, currentBlock, OSMINSTEM_WALL_SIGN.get()))
            // .model((context, provider) -> provider.generated(context))
            // .properties(p -> p.stacksTo(16))
            // .build()

            .register();

    public static final ItemEntry<SignItem> OSMINSTEM_SIGN_ITEM = getRegistrate().object("osminstem_sign")
            .item((p) -> new SignItem(p, STANDING_OSMINSTEM_SIGN.get(), OSMINSTEM_WALL_SIGN.get()))
            .model((context, provider) -> provider.generated(context))
            .properties(p -> p.stacksTo(16))
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
