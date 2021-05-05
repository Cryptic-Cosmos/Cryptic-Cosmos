package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.creatures.makrossa_rambler.MakrossaRamblerEntity;
import com.crypticcosmos.crypticcosmos.creatures.gromble_frog.GrombleFrogEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeRegistries {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CrypticCosmos.MOD_ID);

    public static final RegistryObject<EntityType<MakrossaRamblerEntity>> MAKROSSA_RAMBLER = ENTITY_TYPES.register(
            "makrossa_rambler",
            () -> EntityType.Builder
                    .of(MakrossaRamblerEntity::new, EntityClassification.MONSTER)
                    .sized(3f, 2f)
                    .build(new ResourceLocation(CrypticCosmos.MOD_ID, "makrossa_rambler").toString())
    );

    public static final RegistryObject<EntityType<GrombleFrogEntity>> GROMBLE_FROG = ENTITY_TYPES.register(
            "gromble_frog",
            () -> EntityType.Builder
                    .of(GrombleFrogEntity::new, EntityClassification.CREATURE)
                    .sized(1f, 1f)
                    .build(new ResourceLocation(CrypticCosmos.MOD_ID, "gromble_frog").toString())
    );
}
