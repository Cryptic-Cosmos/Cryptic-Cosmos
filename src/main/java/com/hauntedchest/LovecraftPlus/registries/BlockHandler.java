package com.hauntedchest.LovecraftPlus.registries;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.hauntedchest.LovecraftPlus.blocks.*;
import com.hauntedchest.LovecraftPlus.world.feature.MoonTree;
import com.hauntedchest.LovecraftPlus.world.feature.ThornTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.block.Block.Properties;

public class BlockHandler {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, LovecraftPlusMod.MOD_ID);
    //Portal Blocks
    public static final RegistryObject<Block> HUMMING_STONE =
            BLOCKS.register("humming_stone", HummingStone::new);

    public static final RegistryObject<Block> DREAMING_SOULS =
            BLOCKS.register("dreaming_souls", DreamingSouls::new);

    //Moon Blocks
    public static final RegistryObject<Block> MOON_BLOCK =
            BLOCKS.register("moon_block", MoonBlock::new);

    public static final RegistryObject<Block> MOONSTONE_BRICKS =
            BLOCKS.register("moonstone_bricks", MoonStoneBricks::new);

    public static final RegistryObject<Block> MOONSTONE_BRICK_SLAB =
            BLOCKS.register("moonstone_brick_slab",
                    () -> new SlabBlock(Properties.from(Blocks.BRICK_SLAB)));

    public static final RegistryObject<Block> MOONSTONE =
            BLOCKS.register("moonstone", MoonHolesBlock::new);

    public static final RegistryObject<Block> MOONSTONE_SLAB =
            BLOCKS.register("moonstone_slab",
                    () -> new SlabBlock(Properties.from(Blocks.STONE_SLAB)));

    public static final RegistryObject<Block> SMOOTH_MOONSTONE =
            BLOCKS.register("smooth_moonstone", MoonStoneBricks::new);

    public static final RegistryObject<Block> SMOOTH_MOONSTONE_SLAB =
            BLOCKS.register("smooth_moonstone_slab",
                    () -> new SlabBlock(Properties.from(Blocks.SMOOTH_STONE_SLAB)));

    public static final RegistryObject<Block> ADMANTITE_ORE =
            BLOCKS.register("admantite_ore", AdmantiteOre::new);

    //Thorn Wood
    public static final RegistryObject<Block> THORN_LOG =
            BLOCKS.register("thorn_log",
                    () -> new LogBlocks(Properties.create(Material.WOOD)
                            .hardnessAndResistance(1.0F, 1.0F)
                            .sound(SoundType.WOOD)
                            .harvestLevel(0)
                            .harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> THORN_PLANKS =
            BLOCKS.register("thorn_planks",
                    () -> new LogBlocks(Properties.create(Material.WOOD)
                            .hardnessAndResistance(1.0F, 1.0F)
                            .sound(SoundType.WOOD).harvestLevel(0)
                            .harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> THORN_SLAB =
            BLOCKS.register("thorn_slab",
                    () -> new SlabBlock(Properties.from(Blocks.JUNGLE_SLAB)));
    public static final RegistryObject<Block> THORN_SAPLING =
            BLOCKS.register("thorn_sapling",
                    () -> new ThornSapling(ThornTree::new, Properties.from(Blocks.JUNGLE_SAPLING)));

    public static final RegistryObject<Block> THORN_LEAVES =
            BLOCKS.register("thorn_leaves",
                    () -> new LeavesBlock(Properties.create(Material.LEAVES)
                            .hardnessAndResistance(0.2F)
                            .tickRandomly()
                            .sound(SoundType.PLANT)
                            .notSolid()));
    public static final RegistryObject<Block> THORN_DOOR =
            BLOCKS.register("thorn_door",
                    () -> new ThornDoor(Properties.from(Blocks.JUNGLE_DOOR)));

    //Moon Wood
    public static final RegistryObject<Block> MOON_LOG = BLOCKS.register("moon_log",
            () -> new LogBlock(MaterialColor.WOOD, Properties.from(Blocks.BIRCH_LOG)));

    public static final RegistryObject<Block> MOON_PLANKS = BLOCKS.register("moon_planks",
            () -> new Block(Properties.from(Blocks.BIRCH_PLANKS)));

    public static final RegistryObject<Block> MOON_SAPLING = BLOCKS.register("moon_sapling",
            () -> new MoonSapling(MoonTree::new, Properties.from(Blocks.BIRCH_SAPLING)));

    public static final RegistryObject<Block> MOON_LEAVES =
            BLOCKS.register("moon_leaves",
                    () -> new LeavesBlock(Properties.create(Material.LEAVES)
                            .hardnessAndResistance(0.2F)
                            .tickRandomly()
                            .sound(SoundType.PLANT)
                            .notSolid()));

    //Other Blocks
    public static final RegistryObject<Block> LAVA_SPONGE =
            BLOCKS.register("lava_sponge",
                    () -> new LavaSponge(Properties.create(Material.ROCK)
                            .hardnessAndResistance(0.6F)
                            .sound(SoundType.STONE)));

    public static final RegistryObject<Block> MOLTEN_LAVA_SPONGE =
            BLOCKS.register("molten_lava_sponge",
                    () -> new MoltenLavaSponge(Properties.create(Material.ROCK)
                            .hardnessAndResistance(0.6F)
                            .sound(SoundType.STONE)));
}
