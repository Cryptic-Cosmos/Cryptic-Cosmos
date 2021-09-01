package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;

import static com.crypticcosmos.crypticcosmos.CrypticCosmos.getRegistrate;

public class AlloyniumRegistries {
    public static final BlockEntry<Block> ALLOYNIUM_ORE = getRegistrate().object("alloynium_ore")
            .block(Material.STONE, Block::new)
            .properties(AlloyniumRegistries::alloyniumProperties)
            .simpleItem()
            .register();

    public static final ItemEntry<Item> ALLOYNIUM_SCRAP = getRegistrate().object("alloynium_scrap")
            .item(Item::new)
            .register();

    @Nonnull
    private static BlockBehaviour.Properties alloyniumProperties(BlockBehaviour.Properties p) {
        return p.strength(3.0F, 3.0F)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops();
    }

    public static void init() {
        CrypticCosmos.LOGGER.info("Alloynium Registries initialized");
    }
}
