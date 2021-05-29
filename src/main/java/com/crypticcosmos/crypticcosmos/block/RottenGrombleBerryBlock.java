package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.Random;

public class RottenGrombleBerryBlock extends Block {
    public RottenGrombleBerryBlock(Properties properties) {
        super(properties);

    }

    @Override
    public boolean isRandomlyTicking(@Nonnull BlockState state) {
        return true;
    }

    @Override
    public void randomTick(@Nonnull BlockState state, @Nonnull ServerWorld world, @Nonnull BlockPos position, @Nonnull Random rand) {
        AxisAlignedBB range = new AxisAlignedBB(position.getX(), position.getY(), position.getZ(), position.getX() + 12.0D, position.getY() + 6.0D, position.getZ() + 12.0D);
        if(!world.getLevel().getNearbyEntities(PlayerEntity.class, new EntityPredicate(), null, range).isEmpty()){
            //hello world
            CrypticCosmos.LOGGER.info("Found player!!!");
        }
        CrypticCosmos.LOGGER.info("Ticking y'all!!!");
    }

}
