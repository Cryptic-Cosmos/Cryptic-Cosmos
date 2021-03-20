package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PotionRegistries {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTION_TYPES, CrypticCosmos.MOD_ID);

    // Corruption
    public static final RegistryObject<Potion> CORRUPTION = POTIONS.register("corruption", () ->
            new Potion("corruption",
                    new EffectInstance(EffectRegistries.CORRUPTION.get(), 90 * 20))
    );

    public static final RegistryObject<Potion> LONG_CORRUPTION = POTIONS.register("long_corruption", () ->
            new Potion("corruption",
                    new EffectInstance(EffectRegistries.CORRUPTION.get(), 240 * 20))
    );

    public static final RegistryObject<Potion> STRONG_CORRUPTION = POTIONS.register("strong_corruption", () ->
            new Potion("corruption",
                    new EffectInstance(EffectRegistries.CORRUPTION.get(), 90 * 20, 1))
    );

    // Purification
    public static final RegistryObject<Potion> PURIFICATION = POTIONS.register("purification", () ->
            new Potion("purification",
                    new EffectInstance(EffectRegistries.PURIFICATION.get(), 1))
    );
}
