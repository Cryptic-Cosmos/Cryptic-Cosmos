package com.crypticcosmos.crypticcosmos.blocks;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RiftBlock extends Block {
    public RiftBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(40f, 1200f)
                .sound(SoundType.STONE)
                .doesNotBlockMovement()
                .noDrops()
        );
    }

    private static RegistryKey<World> getDestination(Entity entity, World world) {
        RegistryKey<World> randomDimension;

        // Adds all of the dimensions to a regular list
        List<RegistryKey<World>> allDimensions = world.func_241828_r()
                .getRegistry(Registry.WORLD_KEY).getEntries()
                .stream().map(Map.Entry::getKey).collect(Collectors.toList());

        // We don't want people teleporting to the end, the nether or the dimensions they're currently in
        allDimensions.removeAll(Lists.newArrayList(
                World.THE_END,
                World.THE_NETHER,
                entity.getEntityWorld().getDimensionKey()
        ));

        randomDimension = allDimensions.get(ThreadLocalRandom.current().nextInt(allDimensions.size()));

        return randomDimension;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, Entity entity) {
        if (!entity.isAlive() || entity.world.isRemote) return;

        if (entity.isPassenger() || entity.isBeingRidden() || !entity.isNonBoss()) return;

        if (entity.getPortalCooldown() > 0) return;

        // if (!(entity instanceof PlayerEntity)) {
        //     return;
        // }

        // update the portal cooldown of the entity
        entity.func_242279_ag();
        //noinspection ConstantConditions
        ServerWorld destination = worldIn.getServer().getWorld(getDestination(entity, worldIn));

        //noinspection ConstantConditions
        entity.changeDimension(destination, new ITeleporter() {
            @Override
            public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                Entity repositionedEntity = repositionEntity.apply(false);

                repositionedEntity.setPositionAndUpdate(pos.getX(),
                        destWorld.getHeight(Heightmap.Type.MOTION_BLOCKING, pos).getY(),
                        pos.getZ());

                return repositionedEntity;
            }
        });
    }
}
