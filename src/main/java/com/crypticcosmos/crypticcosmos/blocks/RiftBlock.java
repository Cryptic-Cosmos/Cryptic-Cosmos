package com.crypticcosmos.crypticcosmos.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

public class RiftBlock extends Block {
    public RiftBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(40f, 1200f)
                .sound(SoundType.STONE)
                .doesNotBlockMovement()
                .noDrops()
        );
    }

    private static DimensionType getDestination(Entity entity) {
        List<World> allDimensions = new ArrayList<>();
        RegistryKey<World> randomDimension;

        // Adds all of the dimensions to a regular list

        // We don't want people teleporting to the end, the nether or the dimensions they're currently in
        allDimensions.remove(DimensionType.THE_END);
        allDimensions.remove(DimensionType.THE_NETHER);
        allDimensions.remove(entity.dimension);

        randomDimension = allDimensions.get(ThreadLocalRandom.current().nextInt(allDimensions.size()));

        return randomDimension;
    }

    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, Entity entity) {
        if (!entity.isAlive() || entity.world.isRemote) {
            return;
        }

        if (entity.isPassenger() || entity.isBeingRidden() || !entity.isNonBoss()) {
            return;
        }

        if (entity.getPortalCooldown() > 0) {
            return;
        }

        if (!(entity instanceof PlayerEntity)) {
            return;
        }

        // set a cooldown before this can run again
        entity.timeUntilPortal = 10;

        DimensionType destination = getDestination(entity);

        entity.changeDimension(destination, new ITeleporter() {
            @Override
            public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                PlayerEntity playerIn = (PlayerEntity) repositionEntity.apply(false);

                playerIn.setPositionAndUpdate(pos.getX(),
                        destWorld.getHeight(Heightmap.Type.MOTION_BLOCKING, pos).getY(),
                        pos.getZ());

                return playerIn;
            }
        });
    }

}
