package com.crypticcosmos.crypticcosmos.registries;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

import static com.crypticcosmos.crypticcosmos.registries.MondroveRegistries.*;
import static com.crypticcosmos.crypticcosmos.registries.OsminstemRegistries.*;

public class StrippingRegistries {
    public static final Map<Block, Block> BLOCK_STRIPPING_MAP = new HashMap<>();

    static {
        BLOCK_STRIPPING_MAP.put(MONDROVE_LOG.get().getBlock(), STRIPPED_MONDROVE_LOG.get().getBlock());
        BLOCK_STRIPPING_MAP.put(MONDROVE_WOOD.get().getBlock(), STRIPPED_MONDROVE_WOOD.get().getBlock());
        BLOCK_STRIPPING_MAP.put(OSMINSTEM_LOG.get().getBlock(), STRIPPED_OSMINSTEM_LOG.get().getBlock());
        BLOCK_STRIPPING_MAP.put(OSMINSTEM_WOOD.get().getBlock(), STRIPPED_OSMINSTEM_WOOD.get().getBlock());
    }

    @SubscribeEvent
    public static void onStripped(@Nonnull PlayerInteractEvent.RightClickBlock event) {
        final ItemStack stack = event.getItemStack();

        if (stack.getItem() instanceof AxeItem || stack.getItem() instanceof PickaxeItem) {
            World world = event.getWorld();
            BlockPos blockPos = event.getPos();
            BlockState blockState = world.getBlockState(blockPos);
            PlayerEntity playerEntity = event.getPlayer();

            Block block = BLOCK_STRIPPING_MAP.get(blockState.getBlock());

            world.playSound(playerEntity, blockPos, SoundEvents.AXE_STRIP, SoundCategory.BLOCKS, 1f, 1f);

            if (!world.isClientSide) {
                world.setBlock(blockPos, block.defaultBlockState()
                        .setValue(RotatedPillarBlock.AXIS, blockState.getValue(RotatedPillarBlock.AXIS)), 11);

                stack.hurtAndBreak(1, playerEntity, player -> player.broadcastBreakEvent(event.getHand()));
            }
        }
    }
}
