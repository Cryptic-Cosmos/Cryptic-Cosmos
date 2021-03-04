package com.crypticcosmos.crypticcosmos.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

import javax.annotation.Nonnull;

public class CorruptionEffect extends Effect {
    public CorruptionEffect() {
        super(EffectType.HARMFUL, 0x584033);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        entity.attackEntityFrom(DamageSource.MAGIC, 1.5F);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        int j = 25 >> amplifier;
        if (j > 0) {
            return duration % j == 0;
        } else {
            return true;
        }
    }

    /**
     * returns the name of the potion
     */
    @Nonnull
    @Override
    public String getName() {
        return "Corruption";
    }
}
