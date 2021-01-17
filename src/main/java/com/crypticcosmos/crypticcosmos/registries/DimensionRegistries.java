package com.crypticcosmos.crypticcosmos.registries;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.world.dimension.AbyssDimension;
import com.crypticcosmos.crypticcosmos.world.dimension.IslandDimension;
import com.crypticcosmos.crypticcosmos.world.dimension.LunaraDimension;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionRegistries {
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, CrypticCosmos.MOD_ID);

    public static final ResourceLocation LUNARA_DIM_TYPE = new ResourceLocation(CrypticCosmos.MOD_ID, "lunara");
    public static final ResourceLocation ABYSS_DIM_TYPE = new ResourceLocation(CrypticCosmos.MOD_ID, "abyss");
    public static final ResourceLocation ISLAND_DIM_TYPE = new ResourceLocation(CrypticCosmos.MOD_ID, "island");

    public static final RegistryObject<ModDimension> LUNARA_DIM = MOD_DIMENSIONS.register("lunara_dim", LunaraDimension::new);
    public static final RegistryObject<ModDimension> ABYSS_DIM = MOD_DIMENSIONS.register("abyss_dim", AbyssDimension::new);
    public static final RegistryObject<ModDimension> ISLAND_DIM = MOD_DIMENSIONS.register("island_dim", IslandDimension::new);
}
