package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.block.MondroveFungus;
import com.crypticcosmos.crypticcosmos.block.RiftBlock;
import com.crypticcosmos.crypticcosmos.util.RegistrationUtils;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.block.AbstractBlock.Properties;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;

@SuppressWarnings("unused")
public class BlockRegistries {
    public static final BlockEntry<RiftBlock> RIFT_BLOCK = getRegistrate().object("rift_block")
            .block(Material.STONE, RiftBlock::new)
            .properties(p -> p.strength(40f, 1200f)
                    .sound(SoundType.STONE)
                    .noCollission()
                    .noDrops())
            .register();

    // Umbral Plains
    public static final BlockEntry<SandBlock> UMBRAL_DUNE = getRegistrate().object("umbral_dune")
            .block(Material.SAND, p -> new SandBlock(0x16, p))
            .properties(p -> p.strength(0.5F).sound(SoundType.SAND))
            .simpleItem()
            .register();

    // mondrove fungus set
    public static final BlockEntry<MondroveFungus> MONDROVE_FUNGUS = getRegistrate().object("mondrove_fungus")
            .block(Material.PLANT, MondroveFungus::new)
            .properties(p -> p.strength(0)
                    .noCollission()
                    .sound(SoundType.GRASS))
            .addLayer(() -> RenderType::cutout)
            .blockstate(RegistrationUtils::crossModel)

            .item()
            .model((context, provider) -> provider.generated(context,
                    provider.modLoc("block/" + provider.name(context)))
            )
            .build()

            .register();

    public static final BlockEntry<Block> MONDROVE_FUNGUS_BLOCK = getRegistrate().object("mondrove_fungus_block")
            .block(Block::new)
            .properties(p -> Properties.copy(Blocks.BROWN_MUSHROOM_BLOCK))
            .tag(TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
            .recipe((context, provider) -> provider.storage(MONDROVE_FUNGUS, context))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> MONDROVE_FUNGUS_SPORE_BLOCK = getRegistrate().object("mondrove_fungus_spore_block")
            .block(Block::new)
            .properties(p -> Properties.copy(MONDROVE_FUNGUS_BLOCK.get()))
            .tag(TagRegistries.MONDROVE_FUNGUS_PLANTABLE)
            .simpleItem()
            .register();

    public static final BlockEntry<Block> SMOOTH_MONDROVE_FUNGUS_BLOCK = getRegistrate().object("smooth_mondrove_fungus_block")
            .block(Block::new)
            .properties(p -> Properties.copy(MONDROVE_FUNGUS_BLOCK.get()))
            .recipe((context, provider) ->
                    provider.square(DataIngredient.items(MONDROVE_FUNGUS_BLOCK), context, true)
            )
            .simpleItem()
            .register();

    public static final BlockEntry<Block> SMOOTH_MONDROVE_FUNGUS_BRICKS = getRegistrate().object("smooth_mondrove_fungus_bricks")
            .block(Block::new)
            .properties(p -> Properties.copy(MONDROVE_FUNGUS_BLOCK.get()))
            .simpleItem()
            .register();

    public static void init() {
        CrypticCosmos.LOGGER.info("BlockRegistries initialized");
    }
}