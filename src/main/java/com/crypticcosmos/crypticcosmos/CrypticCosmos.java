package com.crypticcosmos.crypticcosmos;

import com.crypticcosmos.crypticcosmos.blocks.RiftBlock;
import com.crypticcosmos.crypticcosmos.creatures.gromble_frog.GrombleFrogEntity;
import com.crypticcosmos.crypticcosmos.creatures.gromble_frog.GrombleFrogRender;
import com.crypticcosmos.crypticcosmos.creatures.makrossa_rambler.MakrossaRamblerEntity;
import com.crypticcosmos.crypticcosmos.creatures.makrossa_rambler.MakrossaRamblerRender;
import com.crypticcosmos.crypticcosmos.effects.CorruptionEffect.SpawnFrogOnCorruptionKill;
import com.crypticcosmos.crypticcosmos.items.CustomSpawnEggItem;
import com.crypticcosmos.crypticcosmos.registries.*;
import com.crypticcosmos.crypticcosmos.util.BrewingRecipes;
import com.crypticcosmos.crypticcosmos.world.structures.StructureConfig;
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
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
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
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockRegistries.OVERGROWN_LUNON.get());
        }
    };

    public static final Item.Properties DEFAULT_PROPERTY = new Item.Properties().tab(CRYPTIC_COSMOS_ITEM_GROUP);

    public CrypticCosmos() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        modEventBus.addListener(this::setup);

        forgeBus.register(this);
        forgeBus.addListener(RiftBlock::riftSpawning);
        forgeBus.addListener(SpawnFrogOnCorruptionKill::spawnFrogOnCorruptionKill);
        forgeBus.addListener(EventPriority.HIGH, BiomeRegistries::biomeLoading);
        forgeBus.addListener(EventPriority.HIGH, StrippingRegistries::onBlockClicked);

        BlockRegistries.BLOCKS.register(modEventBus);
        ItemRegistries.ITEMS.register(modEventBus);
        EntityTypeRegistries.ENTITY_TYPES.register(modEventBus);
        StructureRegestries.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        BiomeRegistries.BIOMES.register(modEventBus);
        EffectRegistries.EFFECTS.register(modEventBus);
        SoundEventRegistries.SOUND_EVENTS.register(modEventBus);
        PotionRegistries.POTIONS.register(modEventBus);
        MinecraftForge.EVENT_BUS.addListener(CommandRegistries::registerCommands);

        forgeBus.addListener(EventPriority.NORMAL, StructureConfig::addDimensionalSpacing);

        // The comments for BiomeLoadingEvent and StructureSpawnListGatherEvent says to do HIGH for additions.
        forgeBus.addListener(EventPriority.HIGH, StructureConfig::addCustomStructures);

        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(BrewingRecipes::registerBrewingRecipes);
        modEventBus.addListener(this::registerEntityAttributes);
        modEventBus.addGenericListener(Item.class, this::registerBlockItems);
        modEventBus.addGenericListener(EntityType.class, this::createSpawnEggs);

        GeckoLib.initialize();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(BlockRegistries.MONDROVE_SAPLING.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.MONDROVE_FUNGUS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.MONDROVE_LEAVES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.STINKY_OSMIN.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.OSMINSTEM_TRAPDOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.OSMINSTEM_DOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.MONDROVE_TRAPDOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.MONDROVE_DOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.GROMBLE_DOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.GROMBLE_SAPLING.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(BlockRegistries.GROMBLE_LEAVES.get(), RenderType.cutout());


        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeRegistries.MAKROSSA_RAMBLER.get(),
                MakrossaRamblerRender::new
        );

        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeRegistries.GROMBLE_FROG.get(),
                GrombleFrogRender::new
        );
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            StructureRegestries.setupStructures();
            ConfiguredStructureRegistries.registerConfiguredStructures();
        });
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
        event.put(EntityTypeRegistries.MAKROSSA_RAMBLER.get(), MakrossaRamblerEntity.setCustomAttributes());
        event.put(EntityTypeRegistries.GROMBLE_FROG.get(), GrombleFrogEntity.setCustomAttributes());
    }

    private void createSpawnEggs(RegistryEvent.Register<EntityType<?>> event) {
        CustomSpawnEggItem.initSpawnEggs();
    }
}