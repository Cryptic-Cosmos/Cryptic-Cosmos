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
import static com.tterrag.registrate.providers.ProviderType.LANG;
import static com.tterrag.registrate.util.nullness.NonNullBiConsumer.noop;

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
            .setData(LANG, noop())
            .register();

    public static final BlockEntry<GrombleStandingSignBlock> GROMBLE_SIGN = getRegistrate().object("gromble_sign")
            .block(GrombleStandingSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1.0F)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, GROMBLE_PLANKS))

            .item((currentBlock, p) -> new SignItem(p, currentBlock, GROMBLE_WALL_SIGN.get()))
            .model((context, provider) -> provider.generated(context))
            .properties(p -> p.stacksTo(16))
            .build()

            .tileEntity(GrombleSignTileEntity::new)
            .validBlocks(GROMBLE_WALL_SIGN)
            .renderer(() -> SignTileEntityRenderer::new)
            .build()

            .register();

    public static final BlockEntry<MondroveWallSignBlock> MONDROVE_WALL_SIGN = getRegistrate().object("mondrove_wall_sign")
            .block(MondroveWallSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1f)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, MONDROVE_PLANKS))
            .setData(LANG, noop())
            .register();

    public static final BlockEntry<MondroveStandingSignBlock> MONDROVE_SIGN = getRegistrate().object("mondrove_sign")
            .block(MondroveStandingSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1.0F)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, MONDROVE_PLANKS))

            .item((currentBlock, p) -> new SignItem(p, currentBlock, MONDROVE_WALL_SIGN.get()))
            .model((context, provider) -> provider.generated(context))
            .properties(p -> p.stacksTo(16))
            .build()

            .tileEntity(MondroveSignTileEntity::new)
            .validBlocks(MONDROVE_WALL_SIGN)
            .renderer(() -> SignTileEntityRenderer::new)
            .build()

            .register();

    public static final BlockEntry<OsminstemWallSignBlock> OSMINSTEM_WALL_SIGN = getRegistrate().object("osminstem_wall_sign")
            .block(OsminstemWallSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1f)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, OSMINSTEM_PLANKS))
            .setData(LANG, noop())
            .register();

    public static final BlockEntry<OsminstemStandingSignBlock> OSMINSTEM_SIGN = getRegistrate().object("osminstem_sign")
            .block(OsminstemStandingSignBlock::new)
            .initialProperties(Material.WOOD)
            .properties(p -> p.noCollission()
                    .strength(1.0F)
                    .sound(SoundType.WOOD))
            .blockstate((context, provider) -> particleModel(context, provider, OSMINSTEM_PLANKS))

            .item((currentBlock, p) -> new SignItem(p, currentBlock, OSMINSTEM_WALL_SIGN.get()))
            .model((context, provider) -> provider.generated(context))
            .properties(p -> p.stacksTo(16))
            .build()

            .tileEntity(OsminstemSignTileEntity::new)
            .validBlocks(OSMINSTEM_WALL_SIGN)
            .renderer(() -> SignTileEntityRenderer::new)
            .build()

            .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("SignRegistries initialized");
    }
}
