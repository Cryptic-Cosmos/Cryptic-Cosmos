package com.crypticcosmos.crypticcosmos.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
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
}
