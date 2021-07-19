package com.crypticcosmos.crypticcosmos;

import com.crypticcosmos.crypticcosmos.block.RiftBlock;
import com.crypticcosmos.crypticcosmos.effect.CorruptionEffect.SpawnFrogOnCorruptionKill;
import com.crypticcosmos.crypticcosmos.register.*;
import com.crypticcosmos.crypticcosmos.util.BrewingRecipes;
import com.crypticcosmos.crypticcosmos.util.ExtraAssetGenerator;
import com.crypticcosmos.crypticcosmos.util.SoundsGenerator;
import com.crypticcosmos.crypticcosmos.world.feature.ConfiguredFeatureRegistries;
import com.crypticcosmos.crypticcosmos.world.feature.FeatureRegistries;
import com.crypticcosmos.crypticcosmos.world.structures.StructureConfig;
import com.tterrag.registrate.Registrate;
import net.minecraft.block.WoodType;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.tileentity.SignTileEntityRenderer;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import javax.annotation.Nonnull;

@Mod(CrypticCosmos.MOD_ID)
public class CrypticCosmos {
    public static final Logger LOGGER = LogManager.getLogger(CrypticCosmos.class);
    public static final String MOD_ID = "crypticcosmos";
    public static final ItemGroup CRYPTIC_COSMOS_ITEM_GROUP = new ItemGroup("cryptic_cosmos_tab") {
        @Nonnull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CerantRegistries.CERANT.get());
        }
    };

    public static final Lazy<Registrate> registrate = Lazy.of(() ->
            Registrate.create(MOD_ID).itemGroup(() -> CRYPTIC_COSMOS_ITEM_GROUP, "Cryptic Cosmos Materials")
    );

    public CrypticCosmos() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::datagen);
        modEventBus.addListener(this::clientSetup);

        forgeBus.addListener(RiftBlock::riftSpawning);
        forgeBus.addListener(SpawnFrogOnCorruptionKill::spawnFrogOnCorruptionKill);
        forgeBus.addListener(EventPriority.HIGH, BiomeRegistries::biomeLoading);

        BlockRegistries.init();
        SignRegistry.init();
        ItemRegistries.init();
        AlloyniumRegistries.init();
        LunonRegistries.init();
        CerantRegistries.init();
        MondroveRegistries.init();
        OsminstemRegistries.init();
        GrombleRegistries.init();
        EntityTypeRegistries.init();

        StructureRegistries.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
        BiomeRegistries.BIOMES.register(modEventBus);
        EffectRegistries.EFFECTS.register(modEventBus);
        SoundEventRegistries.SOUND_EVENTS.register(modEventBus);
        PotionRegistries.POTIONS.register(modEventBus);
        MinecraftForge.EVENT_BUS.addListener(CommandRegistries::registerCommands);
        FeatureRegistries.FEATURES.register(modEventBus);

        forgeBus.addListener(StructureConfig::addDimensionalSpacing);

        // The comments for BiomeLoadingEvent and StructureSpawnListGatherEvent says to do HIGH for additions.
        forgeBus.addListener(EventPriority.HIGH, ConfiguredFeatureRegistries::addFeaturesToBiomes);
        forgeBus.addListener(EventPriority.HIGH, StructureConfig::addCustomStructures);
        modEventBus.addListener(BrewingRecipes::registerBrewingRecipes);
        ExtraAssetGenerator.English.addTranslations();

        GeckoLib.initialize();
    }

    public static @Nonnull ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
    private void clientSetup(final FMLClientSetupEvent event)
    {
        ClientRegistry.bindTileEntityRenderer(SignRegistry.GROMBLE_SIGN.get(), SignTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(SignRegistry.OSMINSTEM_SIGN.get(), SignTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(SignRegistry.MONDROVE_SIGN.get(), SignTileEntityRenderer::new);
        event.enqueueWork(() -> {
            Atlases.addWoodType(SignRegistry.GROMBLE_WOOD_TYPE);
            Atlases.addWoodType(SignRegistry.OSMINSTEM_WOOD_TYPE);
            Atlases.addWoodType(SignRegistry.MONDROVE_WOOD_TYPE);
        });
    }

    public static Registrate getRegistrate() {
        return registrate.get();
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            WoodType.register(SignRegistry.GROMBLE_WOOD_TYPE);
            WoodType.register(SignRegistry.OSMINSTEM_WOOD_TYPE);
            WoodType.register(SignRegistry.MONDROVE_WOOD_TYPE);
            ConfiguredFeatureRegistries.registerFeatures();
            StructureRegistries.setupStructures();
            ConfiguredStructureRegistries.registerConfiguredStructures();
        });
    }

    public void datagen(final GatherDataEvent event) {
        final DataGenerator generator = event.getGenerator();
        final ExistingFileHelper helper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new SoundsGenerator(generator, helper));
        }
    }
}