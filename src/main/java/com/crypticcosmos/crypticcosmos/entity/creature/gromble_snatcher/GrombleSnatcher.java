package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;


import com.crypticcosmos.crypticcosmos.register.SoundEventRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;

public class GrombleSnatcher extends Monster implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public GrombleSnatcher(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);

        this.noCulling = true;
    }

    public static AttributeSupplier.Builder setCustomAttributes() {
        return createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50f)
                .add(Attributes.MOVEMENT_SPEED, 0f)
                .add(Attributes.ATTACK_DAMAGE, 1f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 400000f)
                .add(Attributes.FOLLOW_RANGE, 50D);
    }

    @Override
    public int getMaxAirSupply() {
        return 900;
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 100.0F));
        //this.goalSelector.addGoal(3, new SnatchGoal(this, 1.0D, 20, 21, 7.0F));
        //this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(3, new SnatchGoal(this, 1.0D, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true, true));
    }

    @Override
    public void registerControllers(AnimationData data) {
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected float getStandingEyeHeight(@Nonnull Pose poseIn, @Nonnull EntityDimensions sizeIn) {
        return this.isBaby() ? sizeIn.height * 0.95F : 1.3F;
    }

    @Override
    public boolean removeWhenFarAway(double p_213397_1_) {
        return !this.isPersistenceRequired();
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEventRegistries.GROMBLE_FROG_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSource) {
        return SoundEventRegistries.GROMBLE_FROG_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEventRegistries.GROMBLE_FROG_DEATH.get();
    }

    /*@Override
    public void performRangedAttack(LivingEntity victim, float p_82196_2_) {
        CrypticCosmos.LOGGER.info("checkAndPerformAttack");
        double distanceToVictim = this.position().distanceToSqr(victim.position());
        //pulling the victim
        Vector3d delta = this.position().subtract(victim.position());
        victim.push(delta.x(), delta.y(), delta.z());
        //pushing the victim
        victim.push(0, 5, 5);
    }*/
}
