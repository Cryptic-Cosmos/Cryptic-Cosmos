package com.hauntedchest.LovecraftPlus.Inits;

import com.hauntedchest.LovecraftPlus.Entities.MoonBeastEntity;
import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, LovecraftPlusMod.MOD_ID);

    public static final RegistryObject<EntityType<MoonBeastEntity>> MOON_BEAST = ENTITY_TYPES.register("moon_beast",
            () -> EntityType.Builder.<MoonBeastEntity>create(MoonBeastEntity::new, EntityClassification.MONSTER).size(3f, 4.2f)
                    .build(new ResourceLocation(LovecraftPlusMod.MOD_ID, "moon_beast").toString()));
}
