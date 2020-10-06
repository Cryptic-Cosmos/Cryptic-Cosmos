package com.hauntedchest.LovecraftPlus.Inits;

import com.hauntedchest.LovecraftPlus.Blocks.*;
import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.world.feature.ThornTree;
import net.minecraft.block.*;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockHandeler {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister(ForgeRegistries.BLOCKS, LovecraftPlusMod.MOD_ID);

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

    //Tree Blocks
    public static final RegistryObject<Block> THORN_LOG = BLOCKS.register("thorn_log",() -> new LogBlock(MaterialColor.WOOD,Block.Properties.from(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> THORN_PLANKS = BLOCKS.register("thorn_planks",() -> new Block(Block.Properties.from(Blocks.JUNGLE_PLANKS)));
    public static final RegistryObject<Block> THORN_SAPLING = BLOCKS.register("thorn_sapling",
            () -> new ThornSapling(ThornTree::new, Block.Properties.from(Blocks.JUNGLE_SAPLING)));
    public static final RegistryObject<Block> THORN_LEAVES = BLOCKS.register("thorn_leaves",  ModLeaves::new);

}
