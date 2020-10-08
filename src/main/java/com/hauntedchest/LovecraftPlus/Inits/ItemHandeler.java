package com.hauntedchest.LovecraftPlus.Inits;

import com.hauntedchest.LovecraftPlus.Blocks.BlockItemBase;
import com.hauntedchest.LovecraftPlus.Items.ItemBase;
import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemHandeler {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister(ForgeRegistries.ITEMS, LovecraftPlusMod.MOD_ID);
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister(ForgeRegistries.ENCHANTMENTS, LovecraftPlusMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENCHANTMENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    //Items
    public static final RegistryObject<Item> HAUNTED_INGOT = ITEMS.register("haunted_ingot", ItemBase::new);
    public static final RegistryObject<Item> NECRONOMICON = ITEMS.register("necronomicon", ItemBase::new);

    //Dimension Block Items
    public static final RegistryObject<Item> HUMMING_STONE_ITEM = ITEMS.register("humming_stone", () -> new BlockItemBase(BlockHandeler.HUMMING_STONE.get()));
    public static final RegistryObject<Item> DREAMING_SOULS_ITEM = ITEMS.register("dreaming_souls", () -> new BlockItemBase(BlockHandeler.DREAMING_SOULS.get()));

    //Moon Block Items
    public static final RegistryObject<Item> MOON_BLOCK_ITEM = ITEMS.register("moon_block", () -> new BlockItemBase(BlockHandeler.MOON_BLOCK.get()));
    public static final RegistryObject<Item> MOONSTONE_BRICKS_ITEM = ITEMS.register("moonstone_bricks", () -> new BlockItemBase(BlockHandeler.MOONSTONE_BRICKS.get()));
    public static final RegistryObject<Item> SMOOTH_MOONSTONE_ITEM = ITEMS.register("smooth_moonstone", () -> new BlockItemBase(BlockHandeler.SMOOTH_MOONSTONE.get()));
    public static final RegistryObject<Item> MOONSTONE_ITEM = ITEMS.register("moonstone", () -> new BlockItemBase(BlockHandeler.MOONSTONE.get()));

    //Wood Block Items
    public static final RegistryObject<Item> THORN_LOG_ITEM = ITEMS.register("thorn_log", () -> new BlockItemBase(BlockHandeler.THORN_LOG.get()));
    public static final RegistryObject<Item> THORN_PLANKS_ITEM = ITEMS.register("thorn_planks", () -> new BlockItemBase(BlockHandeler.THORN_PLANKS.get()));
    public static final RegistryObject<Item> THORN_SAPLING_ITEM = ITEMS.register("thorn_sapling", () -> new BlockItemBase(BlockHandeler.THORN_SAPLING.get()));
    public static final RegistryObject<Item> THORN_LEAVES_ITEM = ITEMS.register("thorn_leaves", () -> new BlockItemBase(BlockHandeler.THORN_LEAVES.get()));
    public static final RegistryObject<Item> THORN_DOOR_ITEM = ITEMS.register("thorn_door", () -> new BlockItemBase(BlockHandeler.THORN_DOOR.get()));

    //Other Block Items
    public static final RegistryObject<Item> LAVA_SPONGE_ITEM = ITEMS.register("lava_sponge", () -> new BlockItemBase(BlockHandeler.LAVA_SPONGE.get()));
    public static final RegistryObject<Item> MOLTEN_LAVA_SPONGE_ITEM = ITEMS.register("molten_lava_sponge", () -> new BlockItemBase(BlockHandeler.MOLTEN_LAVA_SPONGE.get()));

    //Sea Lanterns




}
