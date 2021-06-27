package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.EffectRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class EffluviumBlock extends Block {
    public EffluviumBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(@Nonnull BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void tick(@Nonnull BlockState state, @Nonnull ServerWorld world, @Nonnull BlockPos position, @Nonnull Random rand) {
        AxisAlignedBB range = new AxisAlignedBB(position.getX(), position.getY(), position.getZ(), position.getX() + 15.0D, position.getY() + 15.0D, position.getZ() + 15.0D);
        List<PlayerEntity> playerEntityList = world.getLevel().getNearbyEntities(PlayerEntity.class, new EntityPredicate(), null, range);
        if (!playerEntityList.isEmpty()) {
            for (PlayerEntity playerEntity : playerEntityList) {
                playerEntity.addEffect(new EffectInstance(EffectRegistries.EFFLUVIUM.get(), 300));
            }
            PlayerEntity p;
            //p.addEffect(EffluviumEffect::new);
        }
    }

}
