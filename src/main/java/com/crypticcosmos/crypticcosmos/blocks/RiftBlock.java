package com.crypticcosmos.crypticcosmos.blocks;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.CrypticCosmosDimensions;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public class RiftBlock extends Block {
    public RiftBlock() {
        super(Properties.of(Material.STONE)
                .strength(40f, 1200f)
                .sound(SoundType.STONE)
                .noCollission()
                .noDrops()
        );
    }

    public static void riftSpawning(@Nonnull TickEvent.PlayerTickEvent event) {
        // The higher this is, the less likely it is for a rift to spawn (the exact chance is 1/spawning chance)
        final int spawningChance = 15000;
        final int minDistance = 5;
        final int maxDistance = 120;

        PlayerEntity player = event.player;
        final World world = player.getCommandSenderWorld();

        if (ThreadLocalRandom.current().nextInt(spawningChance) == 0) {
            if (!(World.END.equals(world.dimension())
                  || World.NETHER.equals(world.dimension()))) {
                for (Direction direction : Direction.values()) {
                    for (int i = 0; i <= maxDistance; i++) {
                        if (i < minDistance) continue;

                        BlockPos riftPos = player.blockPosition().relative(direction, i);
                        BlockState riftState = world.getBlockState(riftPos);

                        //noinspection deprecation
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

    private static RegistryKey<World> getDestination(World world) {
        final List<RegistryKey<World>> VALID_DIMENSIONS = Lists.newArrayList(World.OVERWORLD,
                CrypticCosmosDimensions.LUNARA_KEY,
                CrypticCosmosDimensions.ABYSS_KEY
        );

        VALID_DIMENSIONS.remove(world.dimension());

        return VALID_DIMENSIONS.get(ThreadLocalRandom.current().nextInt(VALID_DIMENSIONS.size()));
    }

    public static RegistryKey<World> rift(World world, Entity entity, BlockPos pos) {
        final RegistryKey<World> dimension = getDestination(entity.getCommandSenderWorld());
        // noinspection ConstantConditions
        ServerWorld destination = world.getServer().getLevel(dimension);

        //noinspection ConstantConditions
        entity.changeDimension(destination, new ITeleporter() {
            @Override
            public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                Entity repositionedEntity = repositionEntity.apply(false);

                // update the portal cooldown of the entity
                repositionedEntity.setPortalCooldown();

                int x = pos.getX();
                int z = pos.getZ();
                repositionedEntity.moveTo(x,
                        destWorld.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z),
                        z);

                currentWorld.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());

                return repositionedEntity;
            }
        });

        return dimension;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void entityInside(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, @Nonnull Entity entity) {
        if (!entity.isAlive() || entity.getCommandSenderWorld().isClientSide()) return;

        if (entity.isPassenger() || entity.isVehicle() || !entity.canChangeDimensions()) return;

        rift(worldIn, entity, pos);
    }
}
