package com.crypticcosmos.crypticcosmos.world.gen;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RiftSpawning {
    public static void riftSpawning(TickEvent.PlayerTickEvent event) {
        int spawningChance = 20000;
        int range = 120;

        List<BlockState> airStates = new ArrayList<>();
        airStates.add(Blocks.AIR.getDefaultState());
        airStates.add(Blocks.CAVE_AIR.getDefaultState());
        airStates.add(Blocks.VOID_AIR.getDefaultState());

        PlayerEntity player = event.player;
        final World world = player.getEntityWorld();

        if (ThreadLocalRandom.current().nextInt(spawningChance) == 0) {
            if (!(World.THE_END.equals(world.getDimensionKey())
                  || World.THE_NETHER.equals(world.getDimensionKey()))) {
                for (Direction direction : Direction.values()) {
                    for (int i = 0; i <= range; i++) {
                        if (i < 5) continue;

                        BlockPos riftPos = player.getPosition().offset(direction, i);

                        if (airStates.contains(world.getBlockState(riftPos)) &&
                            !riftPos.equals(player.getPosition())) {
                            if (world.getBlockState(riftPos.offset(direction))
                                    .getBlock().equals(BlockRegistries.RIFT_BLOCK.get())) return;

                            world.setBlockState(riftPos, BlockRegistries.RIFT_BLOCK.get().getDefaultState());

                            return;
                        }
                    }
                }
            }
        }
    }
}