package com.crypticcosmos.crypticcosmos.creatures.moon_tadpole;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
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
public class MoonTadpoleEntity extends WaterMobEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);
    public static AnimationBuilder IDLE_ANIM = new AnimationBuilder().addAnimation("Idle");
    public static AnimationBuilder IDLE_SWIM_ANIM = new AnimationBuilder().addAnimation("IdleSwim");
    public static AnimationBuilder SWIM_ANIM = new AnimationBuilder().addAnimation("Swim");
    public static AnimationBuilder WALK_ANIM = new AnimationBuilder().addAnimation("Walk");

    private static final Lazy<Ingredient> BREEDING_ITEM = Lazy.of(
            () -> Ingredient.fromItems(BlockRegistries.MONDROVE_SAPLING.get())
    );

    public MoonTadpoleEntity(EntityType<? extends WaterMobEntity> type, World worldIn) {
        super(type, worldIn);

        this.ignoreFrustumCheck = true;
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0D));
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
        AnimationController controller = event.getController();
        // TODO: Come up with alternative moving predicate?
        //       The default one doesn't seen to work with slow movement speeds.
        boolean isInWater = isInWater();
        boolean isMoving = isInWater ? !(limbSwingAmount > -0.02) || !(limbSwingAmount < 0.02) : !(limbSwingAmount > -0.10F) || !(limbSwingAmount < 0.10F);
        AnimationBuilder anim = isInWater ? IDLE_SWIM_ANIM : IDLE_ANIM;
        if (isMoving) {
            anim = isInWater ? SWIM_ANIM : WALK_ANIM;
        }
        controller.setAnimation(anim);

        return PlayState.CONTINUE;
    }


    @Nullable

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return this.isChild() ? sizeIn.height * 0.95F : 1.3F;
    }
}
