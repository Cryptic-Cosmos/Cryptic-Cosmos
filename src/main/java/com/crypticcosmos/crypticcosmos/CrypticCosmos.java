package com.crypticcosmos.crypticcosmos;

import com.crypticcosmos.crypticcosmos.block.RiftBlock;
import com.crypticcosmos.crypticcosmos.effect.CorruptionEffect.SpawnFrogOnCorruptionKill;
import com.crypticcosmos.crypticcosmos.register.*;
import com.crypticcosmos.crypticcosmos.util.BrewingRecipes;
import com.crypticcosmos.crypticcosmos.util.LanguageGenerator;
import com.crypticcosmos.crypticcosmos.world.structures.StructureConfig;
import com.tterrag.registrate.Registrate;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
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

        forgeBus.addListener(RiftBlock::riftSpawning);
        forgeBus.addListener(SpawnFrogOnCorruptionKill::spawnFrogOnCorruptionKill);
        forgeBus.addListener(EventPriority.HIGH, BiomeRegistries::biomeLoading);

        BlockRegistries.init();
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

        forgeBus.addListener(StructureConfig::addDimensionalSpacing);

        // The comments for BiomeLoadingEvent and StructureSpawnListGatherEvent says to do HIGH for additions.
        forgeBus.addListener(EventPriority.HIGH, StructureConfig::addCustomStructures);
        modEventBus.addListener(BrewingRecipes::registerBrewingRecipes);
        LanguageGenerator.English.addTranslations();

        GeckoLib.initialize();
    }

    public static @Nonnull
    ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static Registrate getRegistrate() {
        return registrate.get();
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            StructureRegistries.setupStructures();
            ConfiguredStructureRegistries.registerConfiguredStructures();
        });
    }
}