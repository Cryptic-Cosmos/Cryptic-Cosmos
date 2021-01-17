package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.world.feature.structures.MoonPillarPieces;
import com.crypticcosmos.crypticcosmos.world.feature.structures.MoonPillarStructure;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;

public class FeatureRegistries {
    public static final DeferredRegister<Feature<?>> FEATURE = DeferredRegister.create(ForgeRegistries.FEATURES, CrypticCosmos.MOD_ID);

    public static final RegistryObject<MoonPillarStructure> MOON_PILLAR = FEATURE.register(
            "moon_pillar",
            () -> new MoonPillarStructure(NoFeatureConfig::deserialize)
    );

    public static final IStructurePieceType MOON_PILLAR_PIECE = MoonPillarPieces.Piece::new;

    public static void registerStructurePieces(RegistryEvent.Register<Feature<?>> event) {
        Registry.register(
                Registry.STRUCTURE_PIECE,
                "MOON_PILLAR".toLowerCase(Locale.ROOT),
                MOON_PILLAR_PIECE
        );
    }
}
