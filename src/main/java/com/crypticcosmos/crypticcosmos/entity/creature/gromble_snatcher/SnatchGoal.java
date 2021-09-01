package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class SnatchGoal extends MeleeAttackGoal {
    protected final PathfinderMob pathfinderMob;

    public SnatchGoal(PathfinderMob pathfinderMob, double p_i1636_2_, boolean p_i1636_4_) {
        super(pathfinderMob, p_i1636_2_, p_i1636_4_);
        this.pathfinderMob = pathfinderMob;
    }

    protected void checkAndPerformAttack(LivingEntity target, double p_190102_2_) {
        //super.checkAndPerformAttack(target, p_190102_2_);
        double distanceToVictim = this.pathfinderMob.position().distanceToSqr(target.position());

        //pulling the target
        if (distanceToVictim > 5 && distanceToVictim < 50) {
            target.hurt(EntityDamageSource.mobAttack(this.pathfinderMob), 1);
            target.push(this.pathfinderMob.position().x() - target.position().x(), 0.1, this.pathfinderMob.position().z() - target.position().z());
            //target.push(1.0D, 1.0D, 1.0D);
            CrypticCosmos.LOGGER.info("checkAndPerformAttack Pull, distance: " + distanceToVictim);
            this.resetAttackCooldown();
        } else if (distanceToVictim <= 5) {
            target.hurt(EntityDamageSource.mobAttack(this.pathfinderMob), 1);
            var currentPos = target.position();
            //target.moveTo(currentPos.x(), currentPos.y() + 50, currentPos.z() + 50);
            target.push(0, 0.5D, 0.5D);
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
