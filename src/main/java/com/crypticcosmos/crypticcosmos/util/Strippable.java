package com.crypticcosmos.crypticcosmos.util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public interface Strippable {
    default ActionResultType strip(Block strippedBlock, @Nonnull ItemStack stack, World world, BlockPos pos, BlockState state, PlayerEntity playerEntity, Hand hand) {
        if (stack.getItem() instanceof AxeItem || stack.getItem() instanceof PickaxeItem) {
            world.playSound(playerEntity, pos, SoundEvents.AXE_STRIP, SoundCategory.BLOCKS, 1f, 1f);

            if (!world.isClientSide) {
                world.setBlock(pos, strippedBlock.defaultBlockState()
                        .setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)), 11);

                stack.hurtAndBreak(1, playerEntity, player -> player.broadcastBreakEvent(hand));
            }

            return ActionResultType.SUCCESS;
        }

        return ActionResultType.PASS;
    }
}
