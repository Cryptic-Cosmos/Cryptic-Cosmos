package com.crypticcosmos.crypticcosmos.effects;

import com.crypticcosmos.crypticcosmos.registries.EffectRegistries;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.InstantEffect;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;

public class PurificationEffect extends InstantEffect {
    public PurificationEffect() {
        super(EffectType.BENEFICIAL, Color.WHITE.getRGB());
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity p_180793_1_, @Nullable Entity p_180793_2_, @Nonnull LivingEntity target, int p_180793_4_, double p_180793_5_) {
        target.removeEffect(EffectRegistries.CORRUPTION.get());
    }
}
