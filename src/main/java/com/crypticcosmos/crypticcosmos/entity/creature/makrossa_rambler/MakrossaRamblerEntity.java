package com.crypticcosmos.crypticcosmos.entity.creature.makrossa_rambler;

import com.crypticcosmos.crypticcosmos.entity.creature.gromble_frog.GrombleFrogEntity;
import com.crypticcosmos.crypticcosmos.register.SoundEventRegistries;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nonnull;

public class MakrossaRamblerEntity extends MonsterEntity implements IAnimatable {
    public static AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("idle");
    public static AnimationBuilder WALK_ANIM = new AnimationBuilder().addAnimation("walk");
    public static AnimationBuilder RUN_ANIM = new AnimationBuilder().addAnimation("run");

    private final AnimationFactory factory = new AnimationFactory(this);

    public MakrossaRamblerEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.applyEntityAI();
    }

    @Nonnull
    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return createMobAttributes()
                .add(Attributes.MAX_HEALTH, 25.5f)
                .add(Attributes.MOVEMENT_SPEED, 0.5f)
                .add(Attributes.ATTACK_DAMAGE, 6f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 4f);
    }

    protected void applyEntityAI() {
        this.goalSelector.addGoal(4, new SwimGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers());
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, EndermanEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, HuskEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, ZombieEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, DrownedEntity.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, GrombleFrogEntity.class, true));
    }

    @Override
    protected int getExperienceReward(@Nonnull PlayerEntity player) {
        if (this.isBaby()) this.xpReward = (int) ((float) this.xpReward * 4f);

        return super.getExperienceReward(player);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(
                new AnimationController<>(this, "controller", 5, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationController<?> controller = event.getController();
        boolean isMoving = !(event.getLimbSwingAmount() > -0.10F) || !(event.getLimbSwingAmount() < 0.10F);
        boolean isRunning = isMoving && !(event.getLimbSwingAmount() > -0.9F) || !(event.getLimbSwingAmount() < 0.9F);

        if (isRunning) {
            controller.setAnimation(RUN_ANIM);
            return PlayState.CONTINUE;
        } else if(isMoving) {
            controller.setAnimation(WALK_ANIM);
            return PlayState.CONTINUE;
        } else {
            controller.setAnimation(IDLE_ANIM);
            return PlayState.CONTINUE;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEventRegistries.MAKROSSA_RAMBLER_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(@Nonnull DamageSource damageSource) {
        return SoundEventRegistries.MAKROSSA_RAMBLER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEventRegistries.MAKROSSA_RAMBLER_DEATH.get();
    }
}
