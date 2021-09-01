package com.crypticcosmos.crypticcosmos.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;

import java.util.stream.Collectors;

public class EffluviumEffect extends MobEffect {
    public EffluviumEffect() {
        super(MobEffectCategory.NEUTRAL, 0x8DBA36);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        final var alignedAxis = new AABB(entity.blockPosition());

        final var nearbyEntities = entity.level.getNearbyEntities(PathfinderMob.class,
                TargetingConditions.DEFAULT,
                entity,
                alignedAxis);

        final var nearbyMonsters = nearbyEntities.stream()
                .filter(Monster.class::isInstance)
                .map(Monster.class::cast)
                .collect(Collectors.toList());

        // make all non-hostile entities run away from you
        nearbyEntities.stream()
                .filter(it -> !nearbyMonsters.contains(it))
                .forEach(creature -> creature.goalSelector.addGoal(0, new AvoidEntityGoal<>(creature,
                        Player.class, 6.0F, 1.0D, 1.2D)
                ));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        int j = 25 >> amplifier;
        if (j > 0) return duration % j == 0;
        else return true;
    }
}
