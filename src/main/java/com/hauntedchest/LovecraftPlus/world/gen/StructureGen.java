package com.hauntedchest.LovecraftPlus.world.gen;

import com.hauntedchest.LovecraftPlus.Inits.FeatureInit;
import com.hauntedchest.LovecraftPlus.Inits.MoonModBiomes;
import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = LovecraftPlusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StructureGen {

    @SubscribeEvent
    public static void genStruct(FMLLoadCompleteEvent event){
        for (Biome biome: ForgeRegistries.BIOMES){
            if(biome == MoonModBiomes.MOON_PLAINS.get()){
                biome.addStructure(FeatureInit.MOON_PILLAR.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
            }
        }
    }
}
