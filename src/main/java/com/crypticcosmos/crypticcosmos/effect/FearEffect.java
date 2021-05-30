package com.crypticcosmos.crypticcosmos.effect;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class FearEffect extends Effect {
    AvoidEntityGoal goal;
    CreatureEntity entity;

    public FearEffect(AvoidEntityGoal goal, CreatureEntity entity) {
        super(EffectType.NEUTRAL, 0x8DBA36);
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
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }
        return true;
    }
}
