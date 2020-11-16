package com.github.hauntedchest.lovecraftplus.registries;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.world.dimension.MoonDimension;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionRegistries {
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, LovecraftPlus.MOD_ID);

    public static final ResourceLocation MOON_DIM_TYPE = new ResourceLocation(LovecraftPlus.MOD_ID, "moon");

    public static final RegistryObject<ModDimension> MOON_DIM = MOD_DIMENSIONS.register("moon_dim", MoonDimension::new);
}
