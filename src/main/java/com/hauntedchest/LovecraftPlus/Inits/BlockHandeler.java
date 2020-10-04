package com.hauntedchest.LovecraftPlus.Inits;

import com.hauntedchest.LovecraftPlus.Blocks.DreamingSouls;
import com.hauntedchest.LovecraftPlus.Blocks.HummingStone;
import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockHandeler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LovecraftPlusMod.MOD_ID);

    public static void init(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //Blocks
    public static final RegistryObject<Block> HUMMING_STONE = BLOCKS.register("humming_stone", HummingStone::new);
    public static final RegistryObject<Block> DREAMING_SOULS = BLOCKS.register("dreaming_souls", DreamingSouls::new);

}
