package com.crypticcosmos.crypticcosmos.effect;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.register.EffectRegistries;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;

import javax.annotation.Nullable;
import java.util.List;

public class EffluviumEffect extends Effect {
    public EffluviumEffect() {
        super(EffectType.NEUTRAL, 0x8DBA36);
        ;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        double radius = 15.0D;
        AxisAlignedBB range = new AxisAlignedBB(entity.getX() - radius, entity.getY() - radius, entity.getZ() - radius, entity.getX() + radius, entity.getY() + radius, entity.getZ() + radius);
        List<LivingEntity> livingEntityList = entity.level.getNearbyEntities(MobEntity.class, new EntityPredicate(), null, range);
        if (!livingEntityList.isEmpty()) {
            for (LivingEntity livingEntity : livingEntityList) {
                if (livingEntity.getHealth() > 1.0F) {
                    livingEntity.hurt(DamageSource.MAGIC, 1.0F);
                    livingEntity.push(livingEntity.position().x() - entity.position().x() - 8.0D, 0.1D, livingEntity.position().z() - entity.position().z() - 8.0D);
                    CrypticCosmos.LOGGER.info("The smell is so bad...");
                }
                CrypticCosmos.LOGGER.info("Entity running for their noses' lives!!!");
            }

        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
