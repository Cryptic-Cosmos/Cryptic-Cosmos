package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.vector.Vector3d;

public class SnatchGoal extends MeleeAttackGoal {
    protected final CreatureEntity creatureEntity;

    public SnatchGoal(CreatureEntity creatureEntity, double p_i1636_2_, boolean p_i1636_4_) {
        super(creatureEntity, p_i1636_2_, p_i1636_4_);
        this.creatureEntity = creatureEntity;
    }

    protected void checkAndPerformAttack(LivingEntity victim, double p_190102_2_) {
        //super.checkAndPerformAttack(victim, p_190102_2_);
        double distanceToVictim = this.creatureEntity.position().distanceToSqr(victim.position());

        //pulling the victim
        if (distanceToVictim > 5 && distanceToVictim < 50) {
            victim.hurt(DamageSource.mobAttack(this.creatureEntity), 1);
            victim.push(this.creatureEntity.position().x() - victim.position().x(), 0.1, this.creatureEntity.position().z() - victim.position().z());
            //victim.push(1.0D, 1.0D, 1.0D);
            CrypticCosmos.LOGGER.info("checkAndPerformAttack Pull, distance: " + distanceToVictim);
            this.resetAttackCooldown();
        } else if (distanceToVictim <= 5) {
            victim.hurt(DamageSource.mobAttack(this.creatureEntity), 1);
            Vector3d currentPos = victim.position();
            //victim.moveTo(currentPos.x(), currentPos.y() + 50, currentPos.z() + 50);
            victim.push(0, 0.5D, 0.5D);
            CrypticCosmos.LOGGER.info("checkAndPerformAttack Push, distance: " + distanceToVictim);
            this.resetAttackCooldown();
        }
    }

    @Override
    protected int getAttackInterval() {
        return 100;
    }

    /*@Override
    public boolean canUse() {
        boolean res = super.canUse();
        CrypticCosmos.LOGGER.info("checking distance: " + Boolean.toString(res));
        if (this.mob.getTarget() == null)
        {
            CrypticCosmos.LOGGER.info("why there's no target????");
        }
        return res;
    }

    @Override
    protected double getAttackReachSqr(LivingEntity p_179512_1_) {
        double res = (double)(this.mob.getBbWidth() * 20.0F * this.mob.getBbWidth() * 20.0F + p_179512_1_.getBbWidth());
        CrypticCosmos.LOGGER.info("checking distance: " + Double.toString(res));
        return res;
    }*/
}
