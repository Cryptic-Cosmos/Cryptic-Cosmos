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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import javax.annotation.Nonnull;
import java.util.Objects;

@Mod(CrypticCosmos.MOD_ID)
public class CrypticCosmos {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "crypticcosmos";

    public static final ItemGroup CRYPTIC_COSMOS_ITEM_GROUP = new ItemGroup("cryptic_cosmos_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockRegistries.OVERGROWN_LUNON.get());
        }
    };

    public static final Item.Properties DEFAULT_PROPERTY = new Item.Properties().tab(CRYPTIC_COSMOS_ITEM_GROUP);

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
        RenderTypeLookup.setRenderLayer(BlockRegistries.MONDROVE_SAPLING.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.MONDROVE_FUNGUS.get(), RenderType.cutout());

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
        BlockRegistries.BLOCKS.getEntries().stream().map(RegistryObject::get)
                .filter(block -> !(block instanceof CropsBlock))
                .forEach(block -> {
                    BlockItem blockItem;

                    // this makes sure you can't get a rift from the creative menu.
                    if (!(block instanceof RiftBlock)) blockItem = new BlockItem(block, DEFAULT_PROPERTY);
                    else blockItem = new BlockItem(block, new Item.Properties());

                    blockItem.setRegistryName(Objects.requireNonNull(block.getRegistryName()));

                    event.getRegistry().register(blockItem);
                });
    }

    private void registerEntityAttributes(@Nonnull EntityAttributeCreationEvent event) {
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