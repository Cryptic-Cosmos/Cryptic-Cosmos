package com.crypticcosmos.crypticcosmos.creatures;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.creatures.moon_beast.MoonBeastEntity;
import com.crypticcosmos.crypticcosmos.creatures.moon_frog.MoonFrogEntity;
import com.crypticcosmos.crypticcosmos.creatures.moon_traploom.TraploomEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeRegistries {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CrypticCosmos.MOD_ID);

    public static final RegistryObject<EntityType<MoonBeastEntity>> MOON_BEAST = ENTITY_TYPES.register(
            "moon_beast",
            () -> EntityType.Builder
                    .of(MoonBeastEntity::new, EntityClassification.MONSTER)
                    .sized(3f, 2f)
                    .build(new ResourceLocation(CrypticCosmos.MOD_ID, "moon_beast").toString())
    );

    public static final RegistryObject<EntityType<MoonFrogEntity>> MOON_FROG = ENTITY_TYPES.register(
            "moon_frog",
            () -> EntityType.Builder
                    .of(MoonFrogEntity::new, EntityClassification.CREATURE)
                    .sized(1f, 1f)
                    .build(new ResourceLocation(CrypticCosmos.MOD_ID, "moon_frog").toString())
    );

    public static final RegistryObject<EntityType<TraploomEntity>> TRAPLOOM = ENTITY_TYPES.register(
            "traploom",
            () -> EntityType.Builder
                    .create(TraploomEntity::new, EntityClassification.WATER_CREATURE)
                    .size(1f, 0.5f)
                    .build(new ResourceLocation(CrypticCosmos.MOD_ID, "traploom").toString())
    );
}
