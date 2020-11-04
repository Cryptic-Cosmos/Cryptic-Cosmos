package com.hauntedchest.lovecraftplus.registries;

import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import com.hauntedchest.lovecraftplus.entities.MoonBeastEntity;
import com.hauntedchest.lovecraftplus.entities.MoonFrogEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeHandler {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, LovecraftPlusMod.MOD_ID);

    public static final RegistryObject<EntityType<MoonBeastEntity>> MOON_BEAST =
            ENTITY_TYPES.register("moon_beast",
                    () -> EntityType.Builder
                            .create(MoonBeastEntity::new, EntityClassification.MONSTER)
                            .size(3f, 2.5f)
                            .build(new ResourceLocation(LovecraftPlusMod.MOD_ID, "moon_beast")
                                    .toString()));

    public static final RegistryObject<EntityType<MoonFrogEntity>> MOON_FROG =
            ENTITY_TYPES.register("moon_frog",
                    () -> EntityType.Builder
                            .create(MoonFrogEntity::new, EntityClassification.CREATURE)
                            .size(1f, 1f)
                            .build(new ResourceLocation(LovecraftPlusMod.MOD_ID, "moon_frog")
                                    .toString()));
}
