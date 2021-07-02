package com.crypticcosmos.crypticcosmos.world.feature;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureRegistries {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CrypticCosmos.MOD_ID);

    public static final RegistryObject<GrombleStalkFeature> GROMBLE_STALK_FEATURE = FEATURES.register("gromble_stalk", () ->
            new GrombleStalkFeature(ProbabilityConfig.CODEC)
    );
}
