package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.sun.org.apache.xpath.internal.operations.Bool;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.util.math.vector.Vector3d;

public class SnatchGoal extends MeleeAttackGoal
{
    protected final CreatureEntity mob;

    public SnatchGoal(CreatureEntity p_i1636_1_, double p_i1636_2_, boolean p_i1636_4_) {
        super(p_i1636_1_, p_i1636_2_, p_i1636_4_);
        mob = p_i1636_1_;
    }

    protected void checkAndPerformAttack(LivingEntity victim, double p_190102_2_) {
        super.checkAndPerformAttack(victim, p_190102_2_);
        double distanceToVictim = this.mob.position().distanceToSqr(victim.position());
        //pulling the victim
        if (distanceToVictim > 0 && distanceToVictim < 14 && this.getTicksUntilNextAttack() <= 0) {
            victim.moveTo(this.mob.position());
            CrypticCosmos.LOGGER.info("checkAndPerformAttack Pull, distance: " + Double.toString(distanceToVictim));
        }
        else if (this.getTicksUntilNextAttack() <= 0 && distanceToVictim < 2) {
            //Vector3d currentPos = victim.position();
            //victim.moveTo(currentPos.x(), currentPos.y() + 50, currentPos.z());
            victim.push(0, 5.0, 5.0);
            CrypticCosmos.LOGGER.info("checkAndPerformAttack Push, distance: " + Double.toString(distanceToVictim));
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
