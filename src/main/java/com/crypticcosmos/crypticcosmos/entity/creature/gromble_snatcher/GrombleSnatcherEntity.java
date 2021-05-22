package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import com.crypticcosmos.crypticcosmos.register.SoundEventRegistries;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class GrombleSnatcherEntity extends MonsterEntity implements IAnimatable {


    private final AnimationFactory factory = new AnimationFactory(this);

    public GrombleSnatcherEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);

        this.noCulling = true;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50f)
                .add(Attributes.MOVEMENT_SPEED, 0f)
                .add(Attributes.ATTACK_DAMAGE, 0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 400000f);
    }

    @Override
    public int getMaxAirSupply() {
        return 900;
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
    }

    @Override
    public void registerControllers(AnimationData data) {
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isBaby() ? sizeIn.height * 0.95F : 1.3F;
    }

    @Override
    public boolean removeWhenFarAway(double p_213397_1_) {
        return !this.isPersistenceRequired();
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEventRegistries.GROMBLE_FROG_AMBIENCE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEventRegistries.GROMBLE_FROG_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEventRegistries.GROMBLE_FROG_DEATH.get();
    }
}
