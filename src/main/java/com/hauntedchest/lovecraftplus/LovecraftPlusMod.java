package com.hauntedchest.lovecraftplus;

import com.hauntedchest.lovecraftplus.client.entity.model.render.MoonBeastRender;
<<<<<<< Updated upstream
import com.hauntedchest.lovecraftplus.items.CustomSpawnEggItem;
=======
import com.hauntedchest.lovecraftplus.client.entity.model.render.MoonFrogRender;
>>>>>>> Stashed changes
import com.hauntedchest.lovecraftplus.registries.*;
import com.hauntedchest.lovecraftplus.world.gen.StructureGen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(LovecraftPlusMod.MOD_ID)
public class LovecraftPlusMod {
    public static final Logger LOGGER = LogManager.getLogger();

    // The value here should match an entry in the META-INF/mods.toml file
    public static final String MOD_ID = "lovecraftplus";

    public static final ItemGroup ITEM_TAB = new ItemGroup("item_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemHandler.HUMMING_INGOT.get());
        }
    };

    public static final ItemGroup BLOCK_TAB = new ItemGroup("block_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockHandler.HUMMING_OBSIDIAN.get());
        }
    };

    public static final Item.Properties ITEM_TAB_PROP = new Item.Properties().group(ITEM_TAB);
    public static final Item.Properties BLOCK_TAB_PROP = new Item.Properties().group(BLOCK_TAB);

    public LovecraftPlusMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        BlockHandler.BLOCKS.register(modEventBus);
        ItemHandler.ITEMS.register(modEventBus);
        EntityTypeHandler.ENTITY_TYPES.register(modEventBus);
        BiomeHandler.BIOMES.register(modEventBus);
        MoonBiomeHandler.BIOMES.register(modEventBus);
        DimensionHandler.MOD_DIMENSIONS.register(modEventBus);
        FeatureHandler.FEATURE.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        modEventBus.addGenericListener(Biome.class, this::onRegisterBiomes);
        modEventBus.addGenericListener(Feature.class, FeatureHandler::registerStructurePieces);
        modEventBus.addGenericListener(EntityType.class, this::onRegisterEntities);
    }

    public void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        BiomeHandler.registerBiomes();
        MoonBiomeHandler.registerBiomes();
        LOGGER.debug("registered biomes!");
    }

    @SuppressWarnings("deprecation")
    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(StructureGen::generateStructures);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockHandler.THORN_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandler.THORN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandler.MOON_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockHandler.THORN_DOOR.get(), RenderType.getCutout());
        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeHandler.MOON_BEAST.get(),
                MoonBeastRender::new);
<<<<<<< Updated upstream
    }
=======
        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeHandler.MOON_FROG.get(),
                MoonFrogRender::new);
>>>>>>> Stashed changes

    private void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        CustomSpawnEggItem.initSpawnEggs();
    }
}