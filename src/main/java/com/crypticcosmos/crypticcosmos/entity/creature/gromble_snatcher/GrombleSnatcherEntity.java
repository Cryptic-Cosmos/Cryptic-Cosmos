package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import com.crypticcosmos.crypticcosmos.register.MondroveRegistries;
import com.crypticcosmos.crypticcosmos.register.SoundEventRegistries;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Lazy;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class GrombleSnatcherEntity extends MonsterEntity implements IAnimatable {

    private static final Lazy<Ingredient> BREEDING_ITEM = Lazy.of(
            () -> Ingredient.of(MondroveRegistries.MONDROVE_SAPLING.get())
    );
    public static AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("Idle");
    public static AnimationBuilder WALK_ANIM = new AnimationBuilder().addAnimation("Walk");
    private final AnimationFactory factory = new AnimationFactory(this);

    public GrombleSnatcherEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);

        this.noCulling = true;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f);
    }

    @Override
    public int getMaxAirSupply() {
        return 900;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, BREEDING_ITEM.get(), false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 5, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationController<?> controller = event.getController();
        controller.setAnimation(event.isMoving() ? WALK_ANIM : IDLE_ANIM);
        return PlayState.CONTINUE;
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
