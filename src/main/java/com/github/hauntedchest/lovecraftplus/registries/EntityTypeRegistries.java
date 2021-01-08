package com.github.hauntedchest.lovecraftplus.registries;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.entities.MoonBeastEntity;
import com.github.hauntedchest.lovecraftplus.entities.MoonFrogEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeRegistries {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, LovecraftPlus.MOD_ID);

    public static final RegistryObject<EntityType<MoonFrogEntity>> MOON_FROG = ENTITY_TYPES.register(
            "moon_frog",
            () -> EntityType.Builder
                    .create(MoonFrogEntity::new, EntityClassification.CREATURE)
                    .size(1f, 1f)
                    .build(new ResourceLocation(LovecraftPlus.MOD_ID, "moon_frog").toString())
    );

    public static final RegistryObject<EntityType<MoonBeastEntity>> MOON_BEAST = ENTITY_TYPES.register("moon_beast", () -> EntityType.Builder.create(MoonBeastEntity::new,
            EntityClassification.CREATURE)
            .size(2.5f, 3f)
            .setShouldReceiveVelocityUpdates(false)
            .build("moon_beast"));
}
