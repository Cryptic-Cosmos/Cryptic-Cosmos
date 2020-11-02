package com.hauntedchest.LovecraftPlus.Entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class MoonBeastEntity extends MonsterEntity {
    protected static final IAttribute SPAWN_REINFORCEMENTS_CHANCE = (new RangedAttribute((IAttribute)null, "moon_beast.spawnReinforcements", 0.0D, 0.0D, 1.0D)).setDescription("Spawn Reinforcements Chance");

    public MoonBeastEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.applyEntityAI();
    }

    protected void applyEntityAI() {
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, EndermanEntity.class, true));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(4D);
    }

    protected int getExperiencePoints(PlayerEntity player) {
        if (this.isChild()) {
            this.experienceValue = (int)((float)this.experienceValue * 4F);
        }

        return super.getExperiencePoints(player);
    }

    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (super.attackEntityFrom(source, amount)) {
            LivingEntity livingentity = this.getAttackTarget();
            if (livingentity == null && source.getTrueSource() instanceof LivingEntity) {
                livingentity = (LivingEntity)source.getTrueSource();
            }

            int i = MathHelper.floor(this.getPosX());
            int j = MathHelper.floor(this.getPosY());
            int k = MathHelper.floor(this.getPosZ());

            net.minecraftforge.event.entity.living.ZombieEvent.SummonAidEvent event = net.minecraftforge.event.ForgeEventFactory.fireZombieSummonAid(this, world, i, j, k, livingentity, this.getAttribute(SPAWN_REINFORCEMENTS_CHANCE).getValue());
            if (event.getResult() == net.minecraftforge.eventbus.api.Event.Result.DENY) return true;
            if (event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW  ||
                    livingentity != null && this.world.getDifficulty() == Difficulty.HARD && (double)this.rand.nextFloat() < this.getAttribute(SPAWN_REINFORCEMENTS_CHANCE).getValue() && this.world.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING)) {
                ZombieEntity zombieentity = event.getCustomSummonedAid() != null && event.getResult() == net.minecraftforge.eventbus.api.Event.Result.ALLOW ? event.getCustomSummonedAid() : EntityType.ZOMBIE.create(this.world);

                for(int l = 0; l < 50; ++l) {
                    int i1 = i + MathHelper.nextInt(this.rand, 7, 40) * MathHelper.nextInt(this.rand, -1, 1);
                    int j1 = j + MathHelper.nextInt(this.rand, 7, 40) * MathHelper.nextInt(this.rand, -1, 1);
                    int k1 = k + MathHelper.nextInt(this.rand, 7, 40) * MathHelper.nextInt(this.rand, -1, 1);
                    BlockPos blockpos = new BlockPos(i1, j1 - 1, k1);
                    if (this.world.getBlockState(blockpos).isTopSolid(this.world, blockpos, zombieentity) && this.world.getLight(new BlockPos(i1, j1, k1)) < 10) {
                        zombieentity.setPosition((double)i1, (double)j1, (double)k1);
                        if (!this.world.isPlayerWithin((double)i1, (double)j1, (double)k1, 7.0D) && this.world.checkNoEntityCollision(zombieentity) && this.world.hasNoCollisions(zombieentity) && !this.world.containsAnyLiquid(zombieentity.getBoundingBox())) {
                            this.world.addEntity(zombieentity);
                            if (livingentity != null)
                                zombieentity.setAttackTarget(livingentity);
                            zombieentity.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(zombieentity)), SpawnReason.REINFORCEMENT, (ILivingEntityData)null, (CompoundNBT)null);
                            this.getAttribute(SPAWN_REINFORCEMENTS_CHANCE).applyModifier(new AttributeModifier("Moon Beast reinforcement caller charge", (double)-0.05F, AttributeModifier.Operation.ADDITION));
                            zombieentity.getAttribute(SPAWN_REINFORCEMENTS_CHANCE).applyModifier(new AttributeModifier("Moon Beast reinforcement callee charge", (double)-0.05F, AttributeModifier.Operation.ADDITION));
                            break;
                        }
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }

    /*static class MoveHelperController extends MovementController {
        private float yRot;
        private int jumpDelay;
        private final MoonBeastEntity moonbeast;
        private boolean isAggressive;

        public MoveHelperController(MoonBeastEntity moonbeastIn) {
            super(moonbeastIn);
            this.moonbeast = moonbeastIn;
            this.yRot = 180.0F * moonbeastIn.rotationYaw / (float)Math.PI;
        }

        public void setDirection(float yRotIn, boolean aggressive) {
            this.yRot = yRotIn;
            this.isAggressive = aggressive;
        }

        public void setSpeed(double speedIn) {
            this.speed = speedIn;
            this.action = MovementController.Action.MOVE_TO;
        }

        public void tick() {
            this.mob.rotationYaw = this.limitAngle(this.mob.rotationYaw, this.yRot, 90.0F);
            this.mob.rotationYawHead = this.mob.rotationYaw;
            this.mob.renderYawOffset = this.mob.rotationYaw;
            if (this.action != MovementController.Action.MOVE_TO) {
                this.mob.setMoveForward(0.0F);
            } else {
                this.action = MovementController.Action.WAIT;
                if (this.mob.onGround) {
                    this.mob.setAIMoveSpeed((float)(this.speed * this.mob.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue()));
                    if (this.jumpDelay-- <= 0) {
                        this.jumpDelay = this.moonbeast.getJumpDelay();
                        if (this.isAggressive) {
                            this.jumpDelay /= 3;
                        }

                        this.moonbeast.getJumpController().setJumping();
                        if (this.moonbeast.makesSoundOnJump()) {
                            this.moonbeast.playSound(this.moonbeast.getJumpSound(), this.moonbeast.getSoundVolume(), ((this.moonbeast.getRNG().nextFloat() - this.moonbeast.getRNG().nextFloat()) * 0.2F + 1.0F) * 0.8F);
                        }
                    } else {
                        this.moonbeast.moveStrafing = 0.0F;
                        this.moonbeast.moveForward = 0.0F;
                        this.mob.setAIMoveSpeed(0.0F);
                    }
                } else {
                    this.mob.setAIMoveSpeed((float)(this.speed * this.mob.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue()));
                }

            }
        }
    }*/

}
