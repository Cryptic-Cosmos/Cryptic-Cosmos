package com.hauntedchest.LovecraftPlus.Inits;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.world.biomes.MoonBiome;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeHandeler {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, LovecraftPlusMod.MOD_ID);

    public static void init(){
        BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Biome> MOON_BIOME = BIOMES.register("moon_biome"
            , () -> new MoonBiome(new Biome.Builder().surfaceBuilder(SurfaceBuilder.DEFAULT,
                    new SurfaceBuilderConfig(BlockHandeler.MOON_BLOCK.get().getDefaultState(),
                            BlockHandeler.MOON_HOLES_BLOCK.get().getDefaultState(), Blocks.OBSIDIAN.getDefaultState())).category(Biome.Category.PLAINS).depth(0.1F).parent(null)));

}
