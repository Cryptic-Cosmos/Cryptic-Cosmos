package com.github.hauntedchest.lovecraftplus;

import com.github.hauntedchest.lovecraftplus.client.entity.model.render.MoonBeastRender;
import com.github.hauntedchest.lovecraftplus.client.entity.model.render.MoonFrogRender;
import com.github.hauntedchest.lovecraftplus.items.CustomSpawnEggItem;
import com.github.hauntedchest.lovecraftplus.registries.*;
import com.github.hauntedchest.lovecraftplus.world.gen.StructureGen;
import net.minecraft.block.CropsBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

import static net.minecraft.world.biome.Biome.SpawnListEntry;

@Mod(LovecraftPlus.MOD_ID)
public class LovecraftPlus {
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "lovecraftplus";

    public static final ItemGroup ITEM_ITEM_GROUP = new ItemGroup("item_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistries.HUMMING_INGOT.get());
        }
    };

    public static final ItemGroup BLOCK_ITEM_GROUP = new ItemGroup("block_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockRegistries.HUMMING_OBSIDIAN.get());
        }
    };

    public static final Item.Properties ITEM_GROUP_PROPERTY = new Item.Properties().group(ITEM_ITEM_GROUP);
    public static final Item.Properties BLOCK_GROUP_PROPERTY = new Item.Properties().group(BLOCK_ITEM_GROUP);

    public LovecraftPlus() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);

        BlockRegistries.BLOCKS.register(modEventBus);
        ItemRegistries.ITEMS.register(modEventBus);
        EntityTypeRegistries.ENTITY_TYPES.register(modEventBus);
        BiomeRegistries.BIOMES.register(modEventBus);
        DimensionRegistries.MOD_DIMENSIONS.register(modEventBus);
        FeatureRegistries.FEATURE.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);
        modEventBus.addGenericListener(Item.class, this::onRegisterItems);
        modEventBus.addGenericListener(Biome.class, this::onRegisterBiomes);
        modEventBus.addGenericListener(Feature.class, FeatureRegistries::registerStructurePieces);
        modEventBus.addGenericListener(EntityType.class, this::onRegisterEntities);
    }

    public void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        BiomeRegistries.registerBiomes();
        LOGGER.debug("Registered biomes!");
    }

    @SuppressWarnings("deprecation")
    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            StructureGen.generateStructures();

            BiomeRegistries.MONDROVE_GROVE.get().addSpawn(
                    EntityClassification.CREATURE,
                    new SpawnListEntry(EntityTypeRegistries.MOON_FROG.get(), 8, 1, 2)
            );

            BiomeRegistries.MOON_MOUNTAINS.get().addSpawn(
                    EntityClassification.MONSTER,
                    new SpawnListEntry(EntityTypeRegistries.MOON_BEAST.get(), 8, 1, 2)
            );

            BiomeRegistries.MOON_MOUNTAINS.get().addSpawn(
                    EntityClassification.MONSTER,
                    new SpawnListEntry(EntityType.ENDERMAN, 4, 1, 4)
            );

            BiomeRegistries.VULVON_PLAINS.get().addSpawn(
                    EntityClassification.MONSTER,
                    new SpawnListEntry(EntityType.ENDERMAN, 4, 1, 4)
            );

            BiomeRegistries.VULVON_PLAINS.get().addSpawn(
                    EntityClassification.CREATURE,
                    new SpawnListEntry(EntityTypeRegistries.MOON_BEAST.get(), 8, 1, 2)
            );
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockRegistries.THORN_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.THORN_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.MOON_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.CORRUPTED_VINESWORD.get(),RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.THORN_DOOR.get(), RenderType.getCutout());

        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeRegistries.MOON_BEAST.get(),
                MoonBeastRender::new
        );

        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeRegistries.MOON_FROG.get(),
                MoonFrogRender::new
        );
    }

    private void onRegisterItems(final RegistryEvent.Register<Item> event) {
        // automatically register block items
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockRegistries.BLOCKS
                .getEntries()
                .stream()
                .map(RegistryObject::get)
                .filter(it -> !(it instanceof CropsBlock))
                .forEach(block -> {
                    final BlockItem blockItem = new BlockItem(block, BLOCK_GROUP_PROPERTY);
                    blockItem.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
                    registry.register(blockItem);
                });
    }

    private void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        CustomSpawnEggItem.initSpawnEggs();
    }
}