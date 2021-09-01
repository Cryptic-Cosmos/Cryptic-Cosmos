package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.EffectRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nonnull;
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
    public void tick(@Nonnull BlockState state, @Nonnull ServerLevel world, @Nonnull BlockPos position, @Nonnull Random rand) {
        var range = new AABB(position.getX(), position.getY(), position.getZ(), position.getX() + 15.0D, position.getY() + 15.0D, position.getZ() + 15.0D);
        var playerEntityList = world.getLevel().getNearbyEntities(Player.class, TargetingConditions.DEFAULT, null, range);

        if (!playerEntityList.isEmpty()) {
            for (var player : playerEntityList) {
                player.addEffect(new MobEffectInstance(EffectRegistries.EFFLUVIUM.get(), 300));
            }
            Player p;
            //p.addEffect(EffluviumEffect::new);
        }
    }

}
