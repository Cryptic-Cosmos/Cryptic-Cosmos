package com.crypticcosmos.crypticcosmos;

import com.crypticcosmos.crypticcosmos.blocks.RiftBlock;
import com.crypticcosmos.crypticcosmos.creatures.moon_beast.MoonBeastEntity;
import com.crypticcosmos.crypticcosmos.creatures.moon_beast.MoonBeastRender;
import com.crypticcosmos.crypticcosmos.creatures.moon_frog.MoonFrogEntity;
import com.crypticcosmos.crypticcosmos.creatures.moon_frog.MoonFrogRender;
import com.crypticcosmos.crypticcosmos.items.CustomSpawnEggItem;
import com.crypticcosmos.crypticcosmos.registries.*;
import net.minecraft.block.CropsBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.Objects;

@Mod(CrypticCosmos.MOD_ID)
public class CrypticCosmos {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "crypticcosmos";

    public static final ItemGroup ITEM_ITEM_GROUP = new ItemGroup("item_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ItemRegistries.HUMMING_INGOT.get());
        }
    };

    public static final ItemGroup BLOCK_ITEM_GROUP = new ItemGroup("block_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(BlockRegistries.LUNON.get());
        }
    };

    public static final Item.Properties ITEM_GROUP_PROPERTY = new Item.Properties().group(ITEM_ITEM_GROUP);
    public static final Item.Properties BLOCK_GROUP_PROPERTY = new Item.Properties().group(BLOCK_ITEM_GROUP);

    public CrypticCosmos() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(RiftBlock::riftSpawning);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, BiomeRegistries::biomeLoading);

        BlockRegistries.BLOCKS.register(modEventBus);
        ItemRegistries.ITEMS.register(modEventBus);
        EntityTypeRegistries.ENTITY_TYPES.register(modEventBus);
        BiomeRegistries.BIOMES.register(modEventBus);
        EffectRegistries.EFFECTS.register(modEventBus);
        SoundEventRegistries.SOUND_EVENTS.register(modEventBus);

        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::registerEntityAttributes);
        modEventBus.addGenericListener(Item.class, this::registerBlockItems);
        modEventBus.addGenericListener(EntityType.class, this::createSpawnEggs);

        GeckoLib.initialize();
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockRegistries.MONDROVE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.MONDROVE_FUNGUS.get(), RenderType.getCutout());

        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeRegistries.MOON_BEAST.get(),
                MoonBeastRender::new
        );

        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeRegistries.MOON_FROG.get(),
                MoonFrogRender::new
        );
    }

    private void registerBlockItems(final RegistryEvent.Register<Item> event) {
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

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityTypeRegistries.MOON_BEAST.get(), MoonBeastEntity.setCustomAttributes());
        event.put(EntityTypeRegistries.MOON_FROG.get(), MoonFrogEntity.setCustomAttributes());
    }

    private void createSpawnEggs(RegistryEvent.Register<EntityType<?>> event) {
        CustomSpawnEggItem.initSpawnEggs();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}