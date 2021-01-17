package com.crypticcosmos.crypticcosmos.entities;

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

import javax.annotation.Nullable;

@SuppressWarnings("NullableProblems")
public class MoonFrogEntity extends TameableEntity {
    private static final Lazy<Ingredient> BREEDING_ITEM = Lazy.of(
            () -> Ingredient.fromItems(BlockRegistries.MOON_SAPLING.get())
    );

    public MoonFrogEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);

        this.ignoreFrustumCheck = true;
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
