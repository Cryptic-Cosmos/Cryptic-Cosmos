package com.crypticcosmos.crypticcosmos.creatures;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.creatures.moon_beast.MoonBeastEntity;
import com.crypticcosmos.crypticcosmos.creatures.moon_frog.MoonFrogEntity;
import com.crypticcosmos.crypticcosmos.creatures.moon_tadpole.MoonTadpoleEntity;
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
                    .create(MoonBeastEntity::new, EntityClassification.MONSTER)
                    .size(3f, 2f)
                    .build(new ResourceLocation(CrypticCosmos.MOD_ID, "moon_beast").toString())
    );

    public static final RegistryObject<EntityType<MoonFrogEntity>> MOON_FROG = ENTITY_TYPES.register(
            "moon_frog",
            () -> EntityType.Builder
                    .create(MoonFrogEntity::new, EntityClassification.CREATURE)
                    .size(1f, 1f)
                    .build(new ResourceLocation(CrypticCosmos.MOD_ID, "moon_frog").toString())
    );

    public static final RegistryObject<EntityType<MoonTadpoleEntity>> MOON_TADPOLE = ENTITY_TYPES.register(
            "moon_tadpole",
            () -> EntityType.Builder
                    .create(MoonTadpoleEntity::new, EntityClassification.CREATURE)
                    .size(1f, 0.5f)
                    .build(new ResourceLocation(CrypticCosmos.MOD_ID, "moon_tadpole").toString())
    );
}
