package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.ItemRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemModelGenerator extends ItemModelProvider {
    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, CrypticCosmos.MOD_ID, helper);
    }

    @Override
    public void registerModels() {
        generatedItem(ItemRegistries.CRATERED_BONE.get());

        // Spawn eggs
        spawnEgg(ItemRegistries.MOON_FROG_SPAWN_EGG.get());
        spawnEgg(ItemRegistries.MOON_BEAST_SPAWN_EGG.get());

        // Block items
        BlockRegistries.BLOCKS.getEntries().stream().map(RegistryObject::get)
                .filter(block -> !(block instanceof BushBlock))
                .forEach(this::blockItem);
        generatedItem(BlockRegistries.MONDROVE_FUNGUS.get(), "block/mondrove_fungus");
        generatedItem(BlockRegistries.MONDROVE_SAPLING.get(), "block/mondrove_sapling");
    }

    private void generatedItem(@Nonnull IItemProvider item) {
        ResourceLocation resourceLocation = Objects.requireNonNull(item.asItem().getRegistryName());
        String path = String.format("%s:item/%s", resourceLocation.getNamespace(), resourceLocation.getPath());

        try {
            getBuilder(resourceLocation.getPath())
                    .parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .texture("layer0", path);
        } catch (IllegalArgumentException e) {
            CrypticCosmos.LOGGER.error("No such texture exists: " + path);
        }
    }

    private void generatedItem(@Nonnull IItemProvider item, String texture) {
        ResourceLocation resourceLocation = Objects.requireNonNull(item.asItem().getRegistryName());
        getBuilder(resourceLocation.getPath())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", CrypticCosmos.id(texture));
    }

    private void spawnEgg(@Nonnull Item egg) {
        getBuilder(Objects.requireNonNull(egg.getRegistryName()).getPath())
                .parent(new ModelFile.UncheckedModelFile("item/template_spawn_egg"));
    }

    private void blockItem(@Nonnull Block block) {
        ResourceLocation registryName = block.getRegistryName();

        if (registryName != null) {
            getBuilder(registryName.getPath())
                    .parent(new ModelFile.UncheckedModelFile(
                            String.format("%s:block/%s", registryName.getNamespace(), registryName.getPath())
                    ));
        }
    }
}