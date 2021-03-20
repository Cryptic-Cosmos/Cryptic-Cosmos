package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.effects.CorruptionEffect;
import com.crypticcosmos.crypticcosmos.effects.PurificationEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectRegistries {
    public static final DeferredRegister<Effect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.POTIONS, CrypticCosmos.MOD_ID);

    public static final RegistryObject<Effect> CORRUPTION =
            EFFECTS.register("corruption", CorruptionEffect::new);

    public static final RegistryObject<Effect> PURIFICATION =
            EFFECTS.register("purification", PurificationEffect::new);
}
