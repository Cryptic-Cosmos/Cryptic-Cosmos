package com.hauntedchest.LovecraftPlus.Inits;

import com.hauntedchest.LovecraftPlus.Blocks.*;
import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockHandeler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LovecraftPlusMod.MOD_ID);

    public static void init(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    //Portal Blocks
    public static final RegistryObject<Block> HUMMING_STONE = BLOCKS.register("humming_stone", HummingStone::new);
    public static final RegistryObject<Block> DREAMING_SOULS = BLOCKS.register("dreaming_souls", DreamingSouls::new);

    //Moon Blocks
    public static final RegistryObject<Block> MOON_BLOCK = BLOCKS.register("moon_block", MoonBlock::new);
    public static final RegistryObject<Block> MOONSTONE_BRICKS = BLOCKS.register("moonstone_bricks", MoonStoneBricks::new);
    public static final RegistryObject<Block> MOONSTONE = BLOCKS.register("moonstone", MoonHolesBlock::new);
    public static final RegistryObject<Block> SMOOTH_MOONSTONE = BLOCKS.register("smooth_moonstone", MoonStoneBricks::new);
    public static final RegistryObject<Block> SMOOTH_MOONSTONE_SLABS = BLOCKS.register("smooth_moonstone_slabs",
            () -> new SlabBlock(Block.Properties.from(BlockHandeler.SMOOTH_MOONSTONE.get())));

}
