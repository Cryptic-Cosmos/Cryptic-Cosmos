package com.crypticcosmos.crypticcosmos.datagen;

import com.crypticcosmos.crypticcosmos.CrypticCosmos;
import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.crypticcosmos.crypticcosmos.registries.ItemRegistries;
import com.google.common.collect.Lists;
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
import java.util.List;
import java.util.Objects;

public class ItemModelGenerator extends ItemModelProvider {
    public static final List<Block> CUSTOM_BLOCK_ITEMS = Lists.newArrayList(
            BlockRegistries.MONDROVE_TRAPDOOR.get(),
            BlockRegistries.OSMINSTEM_TRAPDOOR.get()
    );

    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, CrypticCosmos.MOD_ID, helper);
    }

    @Override
    public void registerModels() {
        generatedItem(ItemRegistries.CRATERED_BONE.get());

        // Spawn eggs
        spawnEgg(ItemRegistries.MAKROSSA_RAMBLER_SPAWN_EGG.get());
        spawnEgg(ItemRegistries.GROMBLE_FROG_SPAWN_EGG.get());

        // Block items
        BlockRegistries.BLOCKS.getEntries().stream().map(RegistryObject::get)
                .filter(block -> !(block instanceof BushBlock || CUSTOM_BLOCK_ITEMS.contains(block)))
                .forEach(this::blockItem);

        generatedItem(BlockRegistries.MONDROVE_FUNGUS.get(), "mondrove_fungus");
        generatedItem(BlockRegistries.MONDROVE_SAPLING.get(), "mondrove_sapling");
        generatedItem(BlockRegistries.STINKY_OSMIN.get(), "stinky_osmin");
        generatedItem(BlockRegistries.MONDROVE_DOOR.get());
        generatedItem(BlockRegistries.OSMINSTEM_DOOR.get());
        blockItem(BlockRegistries.MONDROVE_TRAPDOOR.get(), "mondrove_trapdoor_bottom");
        blockItem(BlockRegistries.OSMINSTEM_TRAPDOOR.get(), "osminstem_trapdoor_bottom");
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
                .texture("layer0", CrypticCosmos.id(String.format("block/%s", texture)));
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

    private void blockItem(@Nonnull Block block, String path) {
        ResourceLocation registryName = block.getRegistryName();

        if (registryName != null) {
            getBuilder(registryName.getPath())
                    .parent(new ModelFile.UncheckedModelFile(
                            String.format("%s:block/%s", registryName.getNamespace(), path)
                    ));
        }
    }
}