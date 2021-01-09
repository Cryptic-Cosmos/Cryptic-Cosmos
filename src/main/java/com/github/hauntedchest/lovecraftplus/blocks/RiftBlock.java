package com.github.hauntedchest.lovecraftplus.blocks;

import com.github.hauntedchest.lovecraftplus.registries.DimensionRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// TODO: add generation
public class RiftBlock extends Block {
    public RiftBlock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(18000000)
                .sound(SoundType.STONE)
                .doesNotBlockMovement());
    }

    @Override
    public void onEntityCollision(@Nonnull BlockState state,
                                  @Nonnull World worldIn,
                                  @Nonnull BlockPos pos,
                                  @Nonnull Entity entityIn) {
        List<ModDimension> dimensions = new ArrayList<>();
        ForgeRegistries.MOD_DIMENSIONS.forEach(dimensions::add);

        // TODO: randomize the dimension
        //noinspection ConstantConditions
        entityIn.changeDimension(DimensionType.byName(DimensionRegistries.MOON_DIM_TYPE),
                new ITeleporter() {
                    @Override
                    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destWorld, float yaw,
                                              Function<Boolean, Entity> repositionEntity) {
                        PlayerEntity playerIn = (PlayerEntity) repositionEntity.apply(false);
                        playerIn.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());

                        return playerIn;
                    }
                });

    }
}
