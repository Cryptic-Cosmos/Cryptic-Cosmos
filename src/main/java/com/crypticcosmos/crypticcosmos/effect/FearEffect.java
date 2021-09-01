package com.crypticcosmos.crypticcosmos.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;

public class FearEffect extends MobEffect {
    AvoidEntityGoal<?> goal;
    PathfinderMob entity;

    public FearEffect(AvoidEntityGoal<?> goal, PathfinderMob entity) {
        super(MobEffectCategory.NEUTRAL, 0x8DBA36);
        this.goal = goal;
        entity.goalSelector.addGoal(1, goal);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        if (duration > 1)
            return true;
        else if (duration == 0) {
            entity.goalSelector.removeGoal(goal);
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == this.getClass();
    }
}
