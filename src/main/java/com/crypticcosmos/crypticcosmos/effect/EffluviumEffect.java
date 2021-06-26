package com.crypticcosmos.crypticcosmos.effect;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;

public class EffluviumEffect extends Effect {
    public EffluviumEffect() {
        super(EffectType.NEUTRAL, 0x8DBA36);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        double radius = 15.0D;
        AxisAlignedBB range = new AxisAlignedBB(entity.getX() - radius, entity.getY() - radius, entity.getZ() - radius, entity.getX() + radius, entity.getY() + radius, entity.getZ() + radius);
        List<MobEntity> livingEntityList = entity.level.getNearbyEntities(MobEntity.class, new EntityPredicate(), null, range);
        List<PlayerEntity> playerEntityList = entity.level.getNearbyEntities(PlayerEntity.class, new EntityPredicate(), null, range);
        if (!playerEntityList.isEmpty()) {
            for (PlayerEntity playerEntity : playerEntityList) {
                playerEntity.addEffect(new EffectInstance(Effects.CONFUSION, 100, 4));
                if (playerEntity.getHealth() > 1.0f) {
                    playerEntity.hurt(DamageSource.MAGIC, 1.0F);
                }
            }
        }
        if (!livingEntityList.isEmpty()) {
            for (MobEntity livingEntity : livingEntityList) {
                livingEntity.addEffect(new EffectInstance(Effects.CONFUSION));
                if (livingEntity.getHealth() > 1.0F) {
                    livingEntity.hurt(DamageSource.MAGIC, 1.0F);
                    if (livingEntity instanceof CreatureEntity) {
                        CreatureEntity cent = (CreatureEntity) livingEntity;
                        AvoidEntityGoal goal = new AvoidEntityGoal<>(cent, PlayerEntity.class, 16.0F, 1.6D, 1.4D, (p_213497_1_) -> {
                            return p_213497_1_ == entity;
                        });
                        cent.addEffect(new EffectInstance(new FearEffect(goal, cent), 10));
                    }
                }
                CrypticCosmos.LOGGER.info("Entity running for their noses' lives!!!");
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int j = 25 >> amplifier;
        if (j > 0) return duration % j == 0;
        else return true;
    }
}
