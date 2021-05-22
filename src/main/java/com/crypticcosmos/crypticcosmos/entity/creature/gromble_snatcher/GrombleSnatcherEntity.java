package com.crypticcosmos.crypticcosmos.entity.creature.gromble_snatcher;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.register.MondroveRegistries;
import com.crypticcosmos.crypticcosmos.register.SoundEventRegistries;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Lazy;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.function.Predicate;

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
                .add(Attributes.MAX_HEALTH, 40f)
                .add(Attributes.MOVEMENT_SPEED, 0.03f);
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

    public class TruePredicate extends EntityPredicate {
        @Override
        public boolean test(@Nullable LivingEntity p_221015_1_, LivingEntity p_221015_2_) {
            if (p_221015_1_ instanceof PlayerEntity || (p_221015_2_ instanceof PlayerEntity)) {
                return true;
            }
            return false;
        }
    }

    @Override
    public void tick(){
        //
        for(Entity ent: this.level.getNearbyEntities(LivingEntity.class,
                                        new TruePredicate(),
                              GrombleSnatcherEntity.this,
                                        GrombleSnatcherEntity.this.getBoundingBox().inflate(2.0D, 2.0D, 2.0D))){
            CrypticCosmos.LOGGER.info(ent.getClass().toString() + " Exploding!!!");
            Explosion.Mode explosion = Explosion.Mode.NONE;
            float explosionRadius = 10.0F;
            this.level.explode(this, this.getX(), this.getY(), this.getZ(), explosionRadius, explosion);
        }
        super.tick();
    }
}
