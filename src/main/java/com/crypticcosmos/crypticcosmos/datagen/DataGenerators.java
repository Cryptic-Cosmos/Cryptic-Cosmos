package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new LanguageGenerator.English(generator));
            generator.addProvider(new ItemModelGenerator(generator, existingFileHelper));
        }

        if (event.includeServer()) {
            generator.addProvider(new RecipesGenerator(generator));
            generator.addProvider(new BlockLootTablesGenerator(generator));
            generator.addProvider(new EntityLootTablesGenerator(generator));
            final BlockTagGenerator blockTags = new BlockTagGenerator(generator, existingFileHelper);
            generator.addProvider(blockTags);
            generator.addProvider(new ItemTagGenerator(generator, blockTags, existingFileHelper));
        }
    }

    static void writeLootTables(DataGenerator generator, HashMap<ResourceLocation, LootTable> tables, DirectoryCache cache) {
        Path output = generator.getOutputFolder();

        tables.forEach((key, table) -> {
            Path path = output.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");

            try {
                IDataProvider.save(GSON, cache, LootTableManager.serialize(table), path);
            } catch (IOException e) {
                CrypticCosmos.LOGGER.error("couldn't write loot table" + path, e);
            }
        });
    }
}
