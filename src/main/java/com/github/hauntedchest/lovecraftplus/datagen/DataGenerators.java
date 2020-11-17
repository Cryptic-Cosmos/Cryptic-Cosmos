package com.github.hauntedchest.lovecraftplus.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        if (event.includeClient()) {
            generator.addProvider(new LanguageGenerator.English(generator));
        }

        if (event.includeServer()) {
            generator.addProvider(new RecipesGenerator(generator));
            generator.addProvider(new BlockLootTablesGenerator(generator));
            generator.addProvider(new EntityLootTablesGenerator(generator));
            generator.addProvider(new StructureLootTablesGenerator(generator));
        }
    }
}
