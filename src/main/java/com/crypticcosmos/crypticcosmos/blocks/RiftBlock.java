package com.crypticcosmos.crypticcosmos.blocks;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.CrypticCosmosDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import javax.annotation.Nonnull;
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

    private static RegistryKey<World> getDestination() {
        return CrypticCosmosDimensions.DIMENSIONS.get(ThreadLocalRandom.current().nextInt(CrypticCosmosDimensions.DIMENSIONS.size()));
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onEntityCollision(@Nonnull BlockState state, @Nonnull World worldIn, @Nonnull BlockPos pos, Entity entity) {
        if (!entity.isAlive() || entity.world.isRemote) return;

        if (entity.isPassenger() || entity.isBeingRidden() || !entity.isNonBoss()) return;

        // if (entity.getPortalCooldown() > 0) return;

        // noinspection ConstantConditions
        ServerWorld destination = worldIn.getServer().getWorld(getDestination());

        //noinspection ConstantConditions
        entity.changeDimension(destination, new ITeleporter() {
            @Override
            public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
                Entity repositionedEntity = repositionEntity.apply(false);

                // update the portal cooldown of the entity
                repositionedEntity.func_242279_ag();

                CrypticCosmos.LOGGER.debug("tried to teleport with the rift");

                repositionedEntity.setPositionAndUpdate(pos.getX(),
                        destWorld.getHeight(Heightmap.Type.MOTION_BLOCKING, pos).getY(),
                        pos.getZ());

                return repositionedEntity;
            }
        });
    }
}
