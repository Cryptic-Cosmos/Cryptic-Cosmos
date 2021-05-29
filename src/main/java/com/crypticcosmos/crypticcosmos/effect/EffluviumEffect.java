package com.crypticcosmos.crypticcosmos.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffluviumEffect extends Effect {
    public EffluviumEffect() {
        super(EffectType.NEUTRAL, 0x8DBA36);;
    }
    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {


    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int i = 40 >> amplifier;
        if (i > 0) {
            return amplifier % i == 0;
        } else {
            return true;
        }
    }
}
