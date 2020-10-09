package com.hauntedchest.LovecraftPlus.client;

import com.hauntedchest.LovecraftPlus.Inits.DimensionHandeler;
import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LovecraftPlusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event){
        if(DimensionType.byName(LovecraftPlusMod.MOON_DIM_TYPE) == null){
            DimensionManager.registerDimension(LovecraftPlusMod.MOON_DIM_TYPE, DimensionHandeler.MOON_DIM.get(), null, true);
        }
        LovecraftPlusMod.LOGGER.debug("Dimensions Registered");

    }
}
