package com.crypticcosmos.crypticcosmos.world.feature;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureRegistries {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, CrypticCosmos.MOD_ID);
    //just words
    public static final RegistryObject<GrombleStalkFeature> GROMBLE_STALK_FEATURE = FEATURES.register("gromble_stalk", () ->
            new GrombleStalkFeature(ProbabilityFeatureConfiguration.CODEC)
    );
}
