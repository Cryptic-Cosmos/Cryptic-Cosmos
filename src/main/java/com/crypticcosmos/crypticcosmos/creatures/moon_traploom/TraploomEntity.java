package com.crypticcosmos.crypticcosmos.creatures.moon_traploom;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
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

import javax.annotation.Nullable;

@SuppressWarnings("NullableProblems")
public class TraploomEntity extends AbstractGroupFishEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    public static AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("Idle");
    public static AnimationBuilder IDLE_SWIM_ANIM = new AnimationBuilder().addAnimation("IdleSwim");
    public static AnimationBuilder SWIM_ANIM = new AnimationBuilder().addAnimation("Swim");
    public static AnimationBuilder WALK_ANIM = new AnimationBuilder().addAnimation("Walk");

    private static final Lazy<Ingredient> BREEDING_ITEM = Lazy.of(
            () -> Ingredient.of(BlockRegistries.MONDROVE_SAPLING.get())
    );

    public TraploomEntity(EntityType<? extends TraploomEntity> type, World worldIn) {
        super(type, worldIn);

        this.noCulling = true;
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        // TODO: make this work, or make a new goal that works in water.
        // this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, BREEDING_ITEM.get(), false));
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
        // TODO: Come up with alternative moving predicate?
        //       The default one doesn't seen to work with slow movement speeds.
        boolean isInWater = isInWater();
        boolean isMoving = isInWater ? !(animationSpeed > -0.02) || !(animationSpeed < 0.02) : !(animationSpeed > -0.10F) || !(animationSpeed < 0.10F);
        AnimationBuilder anim = isInWater ? IDLE_SWIM_ANIM : IDLE_ANIM;

        return PlayState.CONTINUE;
    }


    @Nullable
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isBaby() ? sizeIn.height * 0.95F : 1.3F;
    }

    @Override
    protected ItemStack getBucketItemStack() {
        return null;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }
}