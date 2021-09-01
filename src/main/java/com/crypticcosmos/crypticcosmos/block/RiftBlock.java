package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import com.crypticcosmos.crypticcosmos.register.CrypticCosmosDimensions;
import com.google.common.collect.Lists;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public class RiftBlock extends Block {
    public RiftBlock(Properties properties) {
        super(properties);
    }

    public static void riftSpawning(@Nonnull TickEvent.PlayerTickEvent event) {
        // The higher this is, the less likely it is for a rift to spawn (the exact chance is 1/spawning chance)
        final var spawningChance = 150000;
        final var minDistance = 5;
        final var maxDistance = 120;

        var player = event.player;
        final var world = player.getCommandSenderWorld();

        if (ThreadLocalRandom.current().nextInt(spawningChance) == 0) {
            if (!(Level.END.equals(world.dimension())
                  || Level.NETHER.equals(world.dimension()))) {
                for (var direction : Direction.values()) {
                    for (int i = 0; i <= maxDistance; i++) {
                        if (i < minDistance) continue;

                        var riftPos = player.blockPosition().relative(direction, i);
                        var riftState = world.getBlockState(riftPos);

                        if (riftState.isAir() && !riftPos.equals(player.blockPosition())) {
                            if (world.getBlockState(riftPos.relative(direction))
                                    .getBlock().equals(BlockRegistries.RIFT_BLOCK.get())) return;

                            world.setBlockAndUpdate(riftPos, BlockRegistries.RIFT_BLOCK.get().defaultBlockState());

                            return;
                        }
                    }
                }
            }
        }
    }

    private static ResourceKey<Level> getDestination(Level world) {
        final var VALID_DIMENSIONS = Lists.newArrayList(Level.OVERWORLD,
                CrypticCosmosDimensions.MAKROSSA_KEY,
                CrypticCosmosDimensions.UMBRAL_DAWN_KEY
        );

        VALID_DIMENSIONS.remove(world.dimension());

        return VALID_DIMENSIONS.get(ThreadLocalRandom.current().nextInt(VALID_DIMENSIONS.size()));
    }

    public static ServerLevel rift(Level world, Entity entity, BlockPos pos) {
        final ResourceKey<Level> dimension = getDestination(entity.getCommandSenderWorld());
        // noinspection ConstantConditions
        ServerLevel destination = world.getServer().getLevel(dimension);

        //noinspection ConstantConditions
        entity.changeDimension(destination, new ITeleporter() {
            @Override
            public Entity placeEntity(Entity entity, ServerLevel currentLevel, ServerLevel destLevel, float yaw, Function<Boolean, Entity> repositionEntity) {
                // Runs the teleportation mechanics
                Entity repositionedEntity = repositionEntity.apply(false);

                // update the portal cool down of the entity
                repositionedEntity.setPortalCooldown();

                // Get the positions
                int x = pos.getX();
                int z = pos.getZ();
                int surfaceY = destLevel.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);
                int y = surfaceY < 1 ? 70 : surfaceY;

                repositionedEntity.moveTo(x, y, z);

                // Destroy the rift once it's used
                currentLevel.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());

                return repositionedEntity;
            }
        });

        return destination;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull Level worldIn, @Nonnull BlockPos pos, @Nonnull Entity entity) {
        // Make some checks before teleporting
        if (!entity.isAlive() || entity.getCommandSenderWorld().isClientSide()) return;
        if (entity.isPassenger() || entity.isVehicle() || !entity.canChangeDimensions()) return;

        rift(worldIn, entity, pos);
    }
}
