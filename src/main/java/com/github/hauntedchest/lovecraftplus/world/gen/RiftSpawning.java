package com.github.hauntedchest.lovecraftplus.world.gen;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.registries.BlockRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.TickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RiftSpawning {
    public static void riftSpawning(TickEvent.PlayerTickEvent event) {
        int spawningChance = 5000;
        int range = 120;

        List<BlockState> airStates = new ArrayList<>();
        airStates.add(Blocks.AIR.getDefaultState());
        airStates.add(Blocks.CAVE_AIR.getDefaultState());
        airStates.add(Blocks.VOID_AIR.getDefaultState());

        PlayerEntity player = event.player;

        if (ThreadLocalRandom.current().nextInt(spawningChance) == 1) {
            if (!(player.dimension.equals(DimensionType.THE_END) || player.dimension.equals(DimensionType.THE_NETHER))) {
                for (Direction direction : Direction.values()) {
                    for (int i = 0; i <= range; i++) {
                        LovecraftPlus.LOGGER.debug("Tried to spawn a rift!");

                        BlockPos riftPos = player.getPosition().offset(direction, i);

                        if (airStates.contains(player.getEntityWorld().getBlockState(riftPos)) &&
                            !riftPos.equals(player.getPosition())) {
                            player.getEntityWorld().setBlockState(riftPos, BlockRegistries.RIFT_BLOCK.get().getDefaultState());

                            return;
                        }
                    }
                }
            }
        }
    }
}