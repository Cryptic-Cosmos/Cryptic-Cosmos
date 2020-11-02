package com.hauntedchest.LovecraftPlus.registries;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.world.dimension.MoonDimension;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionHandler {
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, LovecraftPlusMod.MOD_ID);

    public static final ResourceLocation MOON_DIM_TYPE = new ResourceLocation(LovecraftPlusMod.MOD_ID, "moon");

    public static final RegistryObject<ModDimension> MOON_DIM = MOD_DIMENSIONS.register("moon_dim", MoonDimension::new);
}
