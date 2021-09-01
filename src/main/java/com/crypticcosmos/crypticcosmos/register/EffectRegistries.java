package com.crypticcosmos.crypticcosmos.register;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.effect.CorruptionEffect;
import com.crypticcosmos.crypticcosmos.effect.EffluviumEffect;
import com.crypticcosmos.crypticcosmos.effect.PurificationEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectRegistries {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.POTIONS, CrypticCosmos.MOD_ID);

    public static final RegistryObject<MobEffect> CORRUPTION = EFFECTS.register("corruption", CorruptionEffect::new);

    public static final RegistryObject<MobEffect> PURIFICATION =
            EFFECTS.register("purification", PurificationEffect::new);

    public static final RegistryObject<MobEffect> EFFLUVIUM =
            EFFECTS.register("effluvium", EffluviumEffect::new);
}
