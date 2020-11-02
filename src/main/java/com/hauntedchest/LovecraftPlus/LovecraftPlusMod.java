package com.hauntedchest.LovecraftPlus;

import com.hauntedchest.LovecraftPlus.registries.*;
import com.hauntedchest.LovecraftPlus.world.gen.StructureGen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(LovecraftPlusMod.MOD_ID)
public class LovecraftPlusMod {
    public static final Logger LOGGER = LogManager.getLogger();

    // The value here should match an entry in the META-INF/mods.toml file
    public static final String MOD_ID = "lovecraftplus";

    public static final ItemGroup ITEM_TAB = new ItemGroup("itemTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemHandler.HAUNTED_INGOT.get());
        }
    };

    public static final ItemGroup BLOCK_TAB = new ItemGroup("blockTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockHandler.DREAMING_SOULS.get());
        }
    };

    public static final Item.Properties ITEM_TAB_PROP = new Item.Properties().group(ITEM_TAB);
    public static final Item.Properties BLOCK_TAB_PROP = new Item.Properties().group(BLOCK_TAB);

    public LovecraftPlusMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addGenericListener(Biome.class, this::onRegisterBiomes);
        modEventBus.addGenericListener(Feature.class, FeatureHandler::registerStructurePieces);

        MinecraftForge.EVENT_BUS.register(this);

        EntityTypeHandler.ENTITY_TYPES.register(modEventBus);
        ItemHandler.ITEMS.register(modEventBus);
        BlockHandler.BLOCKS.register(modEventBus);
        BiomeHandler.BIOMES.register(modEventBus);
        MoonBiomeHandler.BIOMES.register(modEventBus);
        DimensionHandler.MOD_DIMENSIONS.register(modEventBus);
        FeatureHandler.FEATURE.register(modEventBus);
    }

    public void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        BiomeHandler.registerBiomes();
        MoonBiomeHandler.registerBiomes();
        LOGGER.debug("registered biomes!");
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(StructureGen::generateStructures);
    }
}