package com.hauntedchest.lovecraftplus.registries;

import com.hauntedchest.lovecraftplus.LovecraftPlusMod;
import com.hauntedchest.lovecraftplus.items.CustomSpawnEggItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class ItemHandler {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LovecraftPlusMod.MOD_ID);

    //Items
    public static final RegistryObject<Item> HUMMING_INGOT = ITEMS.register("humming_ingot",
            () -> new Item(LovecraftPlusMod.ITEM_TAB_PROP));

    public static final RegistryObject<Item> NECRONOMICON = ITEMS.register("necronomicon",
            () -> new Item(LovecraftPlusMod.ITEM_TAB_PROP));

    public static final RegistryObject<Item> PAGE_NECRONOMICON = ITEMS.register("page_necro",
            () -> new Item(LovecraftPlusMod.ITEM_TAB_PROP));

    public static final RegistryObject<Item> BUNDLE_NECRONOMICON = ITEMS.register("bundle_necro",
            () -> new Item(LovecraftPlusMod.ITEM_TAB_PROP));

    public static final RegistryObject<Item> CRATERED_BONE = ITEMS.register("cratered_bone",
            () -> new Item(LovecraftPlusMod.ITEM_TAB_PROP));

    public static final RegistryObject<Item> MOON_BEAST_SPAWN_EGG = ITEMS.register("moon_beast_spawn_egg",
            () -> new CustomSpawnEggItem(EntityTypeHandler.MOON_BEAST::get,
                    0x616a65,
                    0x800000,
                    LovecraftPlusMod.ITEM_TAB_PROP));

    public static final RegistryObject<Item> MOON_FROG_SPAWN_EGG = ITEMS.register("moon_frog_spawn_egg",
            () -> new CustomSpawnEggItem(EntityTypeHandler.MOON_FROG::get,
                    0x003dff,
                    0x1a1a1b,
                    LovecraftPlusMod.ITEM_TAB_PROP));

    //Dimension Block Items
    public static final RegistryObject<Item> HUMMING_STONE_ITEM = ITEMS.register("humming_stone",
            () -> new BlockItem(BlockHandler.HUMMING_STONE.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> HUMMING_OBSIDIAN_ITEM = ITEMS.register("humming_obsidian",
            () -> new BlockItem(BlockHandler.HUMMING_OBSIDIAN.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    //Mooncalite items
    public static final RegistryObject<Item> MOONCALITE_ITEM = ITEMS.register("mooncalite",
            () -> new BlockItem(BlockHandler.MOONCALITE.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOONCALITE_SLAB_ITEM = ITEMS.register("mooncalite_slab",
            () -> new BlockItem(BlockHandler.MOONCALITE_SLAB.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOONCALITE_STAIRS_ITEM = ITEMS.register("mooncalite_stairs",
            () -> new BlockItem(BlockHandler.MOONCALITE_STAIRS.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    // Moonstone items
    public static final RegistryObject<Item> MOONSTONE_ITEM = ITEMS.register("moonstone",
            () -> new BlockItem(BlockHandler.MOONSTONE.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOONSTONE_SLAB_ITEM = ITEMS.register("moonstone_slab",
            () -> new BlockItem(BlockHandler.MOONSTONE_SLAB.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOONSTONE_STAIRS_ITEM = ITEMS.register("moonstone_stairs",
            () -> new BlockItem(BlockHandler.MOONSTONE_STAIRS.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOONSTONE_BRICKS_ITEM = ITEMS.register("moonstone_bricks",
            () -> new BlockItem(BlockHandler.MOONSTONE_BRICKS.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOONSTONE_BRICK_SLAB_ITEM = ITEMS.register("moonstone_brick_slab",
            () -> new BlockItem(BlockHandler.MOONSTONE_BRICK_SLAB.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOONSTONE_BRICK_STAIRS_ITEM = ITEMS.register("moonstone_brick_stairs",
            () -> new BlockItem(BlockHandler.MOONSTONE_BRICK_STAIRS.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> SMOOTH_MOONSTONE_ITEM = ITEMS.register("smooth_moonstone",
            () -> new BlockItem(BlockHandler.SMOOTH_MOONSTONE.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> SMOOTH_MOONSTONE_SLAB_ITEM = ITEMS.register("smooth_moonstone_slab",
            () -> new BlockItem(BlockHandler.SMOOTH_MOONSTONE_SLAB.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> SMOOTH_MOONSTONE_STAIRS_ITEM = ITEMS.register("smooth_moonstone_stairs",
            () -> new BlockItem(BlockHandler.SMOOTH_MOONSTONE_STAIRS.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    //Wood Block Items
    public static final RegistryObject<Item> THORN_LOG_ITEM = ITEMS.register("thorn_log",
            () -> new BlockItem(BlockHandler.THORN_LOG.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> THORN_PLANKS_ITEM = ITEMS.register("thorn_planks",
            () -> new BlockItem(BlockHandler.THORN_PLANKS.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> THORN_SLABS_ITEM = ITEMS.register("thorn_slab",
            () -> new BlockItem(BlockHandler.THORN_SLAB.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> THORN_SAPLING_ITEM = ITEMS.register("thorn_sapling",
            () -> new BlockItem(BlockHandler.THORN_SAPLING.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> THORN_LEAVES_ITEM = ITEMS.register("thorn_leaves",
            () -> new BlockItem(BlockHandler.THORN_LEAVES.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> THORN_DOOR_ITEM = ITEMS.register("thorn_door",
            () -> new BlockItem(BlockHandler.THORN_DOOR.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOON_LOG_ITEM = ITEMS.register("moon_log",
            () -> new BlockItem(BlockHandler.MOON_LOG.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOON_PLANKS_ITEM = ITEMS.register("moon_planks",
            () -> new BlockItem(BlockHandler.MOON_PLANKS.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOON_SAPLING_ITEM = ITEMS.register("moon_sapling",
            () -> new BlockItem(BlockHandler.MOON_SAPLING.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOON_LEAVES_ITEM = ITEMS.register("moon_leaves",
            () -> new BlockItem(BlockHandler.MOON_LEAVES.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    //Other Block Items
    public static final RegistryObject<Item> LAVA_SPONGE_ITEM = ITEMS.register("lava_sponge",
            () -> new BlockItem(BlockHandler.LAVA_SPONGE.get(), LovecraftPlusMod.BLOCK_TAB_PROP));

    public static final RegistryObject<Item> MOLTEN_LAVA_SPONGE_ITEM = ITEMS.register("molten_lava_sponge",
            () -> new BlockItem(BlockHandler.MOLTEN_LAVA_SPONGE.get(), LovecraftPlusMod.BLOCK_TAB_PROP));
}
