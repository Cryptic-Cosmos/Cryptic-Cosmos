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
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LovecraftPlusMod.MOD_ID);
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, LovecraftPlusMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENCHANTMENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    //Items
    public static final RegistryObject<Item> HAUNTED_INGOT = ITEMS.register("haunted_ingot", ItemBase::new);

    //Block Items
    public static final RegistryObject<Item> HUMMING_STONE_ITEM = ITEMS.register("humming_stone", () -> new BlockItemBase(BlockHandeler.HUMMING_STONE.get()));
    public static final RegistryObject<Item> DREAMING_SOULS_ITEM = ITEMS.register("dreaming_souls", () -> new BlockItemBase(BlockHandeler.DREAMING_SOULS.get()));
}
