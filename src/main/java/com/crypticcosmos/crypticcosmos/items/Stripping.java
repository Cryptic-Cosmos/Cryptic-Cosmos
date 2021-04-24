package com.crypticcosmos.crypticcosmos.items;


import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

public class Stripping {

    public static Map<Block, Block> BLOCK_STRIPPING_MAP = new HashMap<>();

    static {
        BLOCK_STRIPPING_MAP.put(BlockRegistries.MONDROVE_LOG.get().getBlock(), BlockRegistries.STRIPPED_MONDROVE_LOG.get().getBlock());
        BLOCK_STRIPPING_MAP.put(BlockRegistries.MONDROVE_WOOD.get().getBlock(), BlockRegistries.STRIPPED_MONDROVE_WOOD.get().getBlock());
        BLOCK_STRIPPING_MAP.put(BlockRegistries.OSMINSTEM_LOG.get().getBlock(), BlockRegistries.STRIPPED_OSMINSTEM_LOG.get().getBlock());
        BLOCK_STRIPPING_MAP.put(BlockRegistries.OSMINSTEM_WOOD.get().getBlock(), BlockRegistries.STRIPPED_OSMINSTEM_WOOD.get().getBlock());
    }

    @SubscribeEvent
    public static void onBlockClicked(PlayerInteractEvent.RightClickBlock event) {
        if (event.getItemStack().getItem() instanceof AxeItem || event.getItemStack().getItem() instanceof PickaxeItem) {
            World world = event.getWorld();
            BlockPos blockPos = event.getPos();
            BlockState blockState = world.getBlockState(blockPos);
            Block block = BLOCK_STRIPPING_MAP.get(blockState.getBlock());
            if (block != null) {
                PlayerEntity playerEntity = event.getPlayer();
                world.playSound(playerEntity, blockPos, SoundEvents.AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!world.isClientSide) {
                    world.setBlock(blockPos, block.defaultBlockState()
                            .setValue(RotatedPillarBlock.AXIS, blockState.getValue(RotatedPillarBlock.AXIS)), 11);
                    if (playerEntity != null) {
                        event.getItemStack().hurtAndBreak(1, playerEntity, (p_220040_1_) -> {
                            p_220040_1_.broadcastBreakEvent(event.getHand());
                        });
                    }
                }
            }
        }
    }
}
