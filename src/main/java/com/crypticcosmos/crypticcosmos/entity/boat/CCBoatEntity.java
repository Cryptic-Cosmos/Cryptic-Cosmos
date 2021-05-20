package com.crypticcosmos.crypticcosmos.entity.boat;

import com.crypticcosmos.crypticcosmos.register.EntityTypeRegistries;
import com.crypticcosmos.crypticcosmos.register.GrombleRegistries;
import com.crypticcosmos.crypticcosmos.register.MondroveRegistries;
import com.crypticcosmos.crypticcosmos.register.OsminstemRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

@SuppressWarnings("EntityConstructor")
public class CCBoatEntity extends BoatEntity {
    private static final DataParameter<Integer> CC_BOAT_TYPE = EntityDataManager.defineId(CCBoatEntity.class, DataSerializers.INT);


    public CCBoatEntity(World worldIn, double x, double y, double z) {
        this(EntityTypeRegistries.BOAT, worldIn);
        this.setPos(x, y, z);
        this.setDeltaMovement(Vector3d.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public CCBoatEntity(EntityType<? extends BoatEntity> boatEntityType, World worldType) {
        super(boatEntityType, worldType);
    }

    public CCBoatEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        super(EntityTypeRegistries.BOAT, world);
    }

    @Override
    public Item getDropItem() {
        switch (this.getCCBoatType()) {
            default:
                return GrombleRegistries.GROMBLE_BOAT.get();
            case MONDROVE_BOAT:
                return MondroveRegistries.MONDROVE_BOAT.get();
            case OSMINSTEM_BOAT:
                return OsminstemRegistries.OSMINSTEM_BOAT.get();
        }
    }

    public Block getPlanks() {
        switch (this.getCCBoatType()) {
            default:
                return GrombleRegistries.GROMBLE_PLANKS.get();
            case MONDROVE_BOAT:
                return MondroveRegistries.MONDROVE_PLANKS.get();
            case OSMINSTEM_BOAT:
                return OsminstemRegistries.OSMINSTEM_PLANKS.get();
        }
    }

    public CCType getCCBoatType() {
        return CCType.byId(this.entityData.get(CC_BOAT_TYPE));
    }

    public void setCCBoatType(CCType boatCCType) {
        this.entityData.set(CC_BOAT_TYPE, boatCCType.ordinal());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CC_BOAT_TYPE, CCType.GROMBLE_BOAT.ordinal());
    }


    @Override
    protected void addAdditionalSaveData(CompoundNBT compound) {
        compound.putString("CCType", this.getCCBoatType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundNBT compound) {
        if (compound.contains("CCType", 8)) {
            this.setCCBoatType(CCType.getTypeFromString(compound.getString("CCType")));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void animateHurt() {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }


    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        this.lastYd = this.getDeltaMovement().y;
        if (!this.isPassenger()) {
            if (onGroundIn) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != BoatEntity.Status.ON_LAND) {
                        this.fallDistance = 0.0F;
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F);
                    if (!this.level.isClientSide && !this.removed) {
                        this.remove();
                        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                this.spawnAtLocation(this.getPlanks());
                            }

                            for (int j = 0; j < 2; ++j) {
                                this.spawnAtLocation(Items.STICK);
                            }

                            this.spawnAtLocation(Blocks.AIR);
                        }
                    }
                }

                this.fallDistance = 0.0F;
            } else if (!this.level.getFluidState((new BlockPos(this.getX(), this.getY(), this.getZ()).below())).is(FluidTags.WATER) && y < 0.0D) {
                this.fallDistance = (float) ((double) this.fallDistance - y);
            }

        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.level.isClientSide && !this.removed) {
            if (source instanceof IndirectEntityDamageSource && source.getEntity() != null && this.hasPassenger(source.getEntity())) {
                return false;
            } else {
                this.setHurtDir(-this.getHurtDir());
                this.setHurtTime(10);
                this.setDamage(this.getDamage() + amount * 10.0F);
                this.markHurt();
                boolean flag = source.getEntity() instanceof PlayerEntity && ((PlayerEntity) source.getEntity()).abilities.instabuild;
                if (flag || this.getDamage() > 40.0F) {
                    if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                        this.spawnAtLocation(this.getDropItem());
                    }

                    this.remove();
                }

                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public enum CCType {
        GROMBLE_BOAT("gromble_boat"),
        MONDROVE_BOAT("mondrove_boat"),
        OSMINSTEM_BOAT("osminstem_boat");


        private final String name;

        CCType(String string) {
            this.name = string;
        }

        /**
         * Get a boat type by it's enum ordinal
         */
        public static CCType byId(int id) {
            CCType[] aCCBoatEntity$CCType = values();
            if (id < 0 || id >= aCCBoatEntity$CCType.length) {
                id = 0;
            }

            return aCCBoatEntity$CCType[id];
        }

        public static CCType getTypeFromString(String nameIn) {
            CCType[] aCCBoatEntity$CCType = values();

            for (CCType CCType : aCCBoatEntity$CCType) {
                if (CCType.getName().equals(nameIn)) {
                    return CCType;
                }
            }

            return aCCBoatEntity$CCType[0];
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }
}
