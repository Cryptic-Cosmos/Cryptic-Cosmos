package com.crypticcosmos.crypticcosmos.util;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public interface Strippable {
    default InteractionResult strip(Block strippedBlock, @Nonnull ItemStack stack, Level world, BlockPos pos, BlockState state, Player playerEntity, InteractionHand hand) {
        if (stack.getItem() instanceof AxeItem || stack.getItem() instanceof PickaxeItem) {
            world.playSound(playerEntity, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1f, 1f);

            if (!world.isClientSide) {
                world.setBlock(pos, strippedBlock.defaultBlockState()
                        .setValue(RotatedPillarBlock.AXIS, state.getValue(RotatedPillarBlock.AXIS)), 11);

                stack.hurtAndBreak(1, playerEntity, player -> player.broadcastBreakEvent(hand));
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
