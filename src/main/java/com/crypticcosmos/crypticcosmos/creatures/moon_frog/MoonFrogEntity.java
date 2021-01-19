package com.crypticcosmos.crypticcosmos.creatures.moon_frog;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.EntityTypeRegistries;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
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
public class MoonFrogEntity extends TameableEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    public static AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("Idle");
    public static AnimationBuilder WALK_ANIM = new AnimationBuilder().addAnimation("Walk");

    private static final Lazy<Ingredient> BREEDING_ITEM = Lazy.of(
            () -> Ingredient.fromItems(BlockRegistries.MONDROVE_SAPLING.get())
    );

    public MoonFrogEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);

        this.ignoreFrustumCheck = true;
    }

    @Override
    public int getMaxAir() {
        return 900;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, BREEDING_ITEM.get(), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();

        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2F);
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


    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return EntityTypeRegistries.MOON_FROG.get().create(this.world);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isChild() ? sizeIn.height * 0.95F : 1.3F;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_ITEM.get().test(stack);
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return !this.isTamed() && this.ticksExisted > 2400;
    }

    @Override
    protected void setupTamedAI() {
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 0.5f, 10f, 5f, false));
    }
}
