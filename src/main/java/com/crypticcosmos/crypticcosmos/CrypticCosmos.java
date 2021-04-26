package com.crypticcosmos.crypticcosmos;

import com.crypticcosmos.crypticcosmos.blocks.RiftBlock;
import com.crypticcosmos.crypticcosmos.creatures.moon_beast.MoonBeastEntity;
import com.crypticcosmos.crypticcosmos.creatures.moon_beast.MoonBeastRender;
import com.crypticcosmos.crypticcosmos.creatures.moon_frog.MoonFrogEntity;
import com.crypticcosmos.crypticcosmos.creatures.moon_frog.MoonFrogRender;
import com.crypticcosmos.crypticcosmos.effects.CorruptionEffect.SpawnFrogOnCorruptionKill;
import com.crypticcosmos.crypticcosmos.items.CustomSpawnEggItem;
import com.crypticcosmos.crypticcosmos.registries.StrippingRegistries;
import com.crypticcosmos.crypticcosmos.registries.*;
import com.crypticcosmos.crypticcosmos.util.BrewingRecipes;
import com.mojang.serialization.Codec;
import net.minecraft.block.CropsBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
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


        EffectRegistries.EFFECTS.register(modEventBus);
        BlockRegistries.BLOCKS.register(modEventBus);
        ItemRegistries.ITEMS.register(modEventBus);
        EntityTypeRegistries.ENTITY_TYPES.register(modEventBus);
        StructureRegestries.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        BiomeRegistries.BIOMES.register(modEventBus);
        SoundEventRegistries.SOUND_EVENTS.register(modEventBus);
        PotionRegistries.POTIONS.register(modEventBus);
        MinecraftForge.EVENT_BUS.addListener(CommandRegistries::registerCommands);


        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);

        // The comments for BiomeLoadingEvent and StructureSpawnListGatherEvent says to do HIGH for additions.
        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);

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

        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeRegistries.MOON_BEAST.get(),
                MoonBeastRender::new
        );

        RenderingRegistry.registerEntityRenderingHandler(
                EntityTypeRegistries.MOON_FROG.get(),
                MoonFrogRender::new
        );
    }

    public void setup(final FMLCommonSetupEvent event)
    {
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
        event.put(EntityTypeRegistries.MOON_BEAST.get(), MoonBeastEntity.setCustomAttributes());
        event.put(EntityTypeRegistries.MOON_FROG.get(), MoonFrogEntity.setCustomAttributes());
    }

    private void createSpawnEggs(RegistryEvent.Register<EntityType<?>> event) {
        CustomSpawnEggItem.initSpawnEggs();
    }

    public void biomeModification(final BiomeLoadingEvent event) {
        /*
         * Add our structure to all biomes including other modded biomes.
         * You can skip or add only to certain biomes based on stuff like biome category,
         * temperature, scale, precipitation, mod id, etc. All kinds of options!
         *
         * You can even use the BiomeDictionary as well! To use BiomeDictionary, do
         * RegistryKey.getOrCreateKey(Registry.BIOME_KEY, event.getName()) to get the biome's
         * registrykey. Then that can be fed into the dictionary to get the biome's types.
         */
        event.getGeneration().getStructures().add(() -> ConfiguredStructureRegistries.CONFIGURED_MONDROVE_BUNDLE);
    }

    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld)event.getWorld();

            /*
             * Skip Terraforged's chunk generator as they are a special case of a mod locking down their chunkgenerator.
             * They will handle your structure spacing for your if you add to WorldGenRegistries.NOISE_GENERATOR_SETTINGS in your structure's registration.
             * This here is done with reflection as this tutorial is not about setting up and using Mixins.
             * If you are using mixins, you can call the codec method with an invoker mixin instead of using reflection.
             */
            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "codec");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch(Exception e){
                CrypticCosmos.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }

            /*
             * Prevent spawning our structure in Vanilla's superflat world as
             * people seem to want their superflat worlds free of modded structures.
             * Also that vanilla superflat is really tricky and buggy to work with in my experience.
             */
            if(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator &&
                    serverWorld.dimension().equals(World.OVERWORLD)){
                return;
            }

            /*
             * putIfAbsent so people can override the spacing with dimension datapacks themselves if they wish to customize spacing more precisely per dimension.
             * Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
             *
             * NOTE: if you add per-dimension spacing configs, you can't use putIfAbsent as WorldGenRegistries.NOISE_GENERATOR_SETTINGS in FMLCommonSetupEvent
             * already added your default structure spacing to some dimensions. You would need to override the spacing with .put(...)
             * And if you want to do dimension blacklisting, you need to remove the spacing entry entirely from the map below to prevent generation safely.
             */
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(StructureRegestries.MONDROVE_BUNDLE.get(), DimensionStructuresSettings.DEFAULTS.get(StructureRegestries.MONDROVE_BUNDLE.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
        }
    }
}