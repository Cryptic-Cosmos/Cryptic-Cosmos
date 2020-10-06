package com.hauntedchest.LovecraftPlus;

import com.hauntedchest.LovecraftPlus.Inits.BlockHandeler;
import com.hauntedchest.LovecraftPlus.Inits.ItemHandeler;
import com.hauntedchest.LovecraftPlus.Inits.ModBiomes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("lovecraftplus")
@Mod.EventBusSubscriber(modid = LovecraftPlusMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LovecraftPlusMod
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "lovecraftplus";

    public LovecraftPlusMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        ItemHandeler.init();
        BlockHandeler.init();

        MinecraftForge.EVENT_BUS.register(this);
        ModBiomes.BIOMES.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        ModBiomes.registerBiomes();
        LOGGER.debug("registered biomes!");

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }
    public static final ItemGroup ITEMTAB = new ItemGroup("itemTab"){
        @Override
        public ItemStack createIcon(){
            return new ItemStack(ItemHandeler.HAUNTED_INGOT.get());
        }
    };
    public static final ItemGroup BLOCKTAB = new ItemGroup("blockTab"){
        @Override
        public ItemStack createIcon(){
            return new ItemStack(BlockHandeler.DREAMING_SOULS.get());
        }
    };
}
