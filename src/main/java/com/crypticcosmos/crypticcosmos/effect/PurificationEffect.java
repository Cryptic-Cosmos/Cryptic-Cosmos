package com.crypticcosmos.crypticcosmos.effect;

import com.crypticcosmos.crypticcosmos.register.EffectRegistries;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;

public class PurificationEffect extends InstantenousMobEffect {
    public PurificationEffect() {
        super(MobEffectCategory.BENEFICIAL, Color.WHITE.getRGB());
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity p_180793_1_, @Nullable Entity p_180793_2_, @Nonnull LivingEntity target, int p_180793_4_, double p_180793_5_) {
        target.removeEffect(EffectRegistries.CORRUPTION.get());
    }
}
