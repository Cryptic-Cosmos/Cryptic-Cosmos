package com.hauntedchest.LovecraftPlus.Inits;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.world.feature.structures.MoonPillarPieces;
import com.hauntedchest.LovecraftPlus.world.feature.structures.MoonPillarStructure;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = LovecraftPlusMod.MOD_ID)
public class FeatureInit {
    public static final DeferredRegister<Feature<?>> FEATURE = new DeferredRegister<Feature<?>>(ForgeRegistries.FEATURES, LovecraftPlusMod.MOD_ID);

    public static IStructurePieceType MPP = MoonPillarPieces.Piece::new;

    public static final RegistryObject<MoonPillarStructure> MOON_PILLAR = FEATURE.register("moon_pillar",() -> new MoonPillarStructure(NoFeatureConfig::deserialize));

    @SubscribeEvent
    public static void registerStructurePieces(RegistryEvent.Register<Feature<?>> event) {
        Registry.register(Registry.STRUCTURE_PIECE, "MOON_PILLAR".toLowerCase(Locale.ROOT), MPP);
    }
}
