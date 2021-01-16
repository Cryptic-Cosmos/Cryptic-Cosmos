package com.github.hauntedchest.lovecraftplus.registries;

import com.github.hauntedchest.lovecraftplus.LovecraftPlus;
import com.github.hauntedchest.lovecraftplus.blocks.*;
import com.github.hauntedchest.lovecraftplus.world.feature.MoonTree;
import com.github.hauntedchest.lovecraftplus.world.feature.ThornTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.block.Block.Properties;

public class BlockRegistries {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LovecraftPlus.MOD_ID);

    //Portal Blocks
    public static final RegistryObject<Block> HUMMING_STONE = BLOCKS.register(
            "humming_stone",
            () -> new ExpDroppingOreBlock(
                    Properties.create(Material.ROCK)
                            .hardnessAndResistance(6.0f, 34)
                            .sound(SoundType.STONE)
                            .harvestLevel(3)
                            .harvestTool(ToolType.PICKAXE),
                    3
            )
    );

    public static final RegistryObject<Block> HUMMING_OBSIDIAN = BLOCKS.register(
            "humming_obsidian",
            () -> new Block(Properties.create(Material.ROCK)
                    .hardnessAndResistance(50.0F, 1200.0F)
                    .sound(SoundType.STONE)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE))
    );

    // Mooncalite
    public static final RegistryObject<Block> MOONCALITE = BLOCKS.register(
            "mooncalite",
            () -> new Block(Properties.create(Material.ROCK)
                    .hardnessAndResistance(2.0f, 6)
                    .sound(SoundType.STONE)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE))
    );

    public static final RegistryObject<Block> MOONCALITE_SLAB = BLOCKS.register(
            "mooncalite_slab",
            () -> new SlabBlock(Properties.from(MOONCALITE.get()))
    );

    public static final RegistryObject<Block> MOONCALITE_STAIRS = BLOCKS.register(
            "mooncalite_stairs",
            () -> new StairsBlock(() -> MOONCALITE.get().getDefaultState(), Properties.from(MOONCALITE.get()))
    );

    // Moonstone
    public static final RegistryObject<Block> MOONSTONE = BLOCKS.register(
            "moonstone",
            () -> new Block(Properties.create(Material.ROCK)
                    .hardnessAndResistance(4.0f, 12)
                    .sound(SoundType.STONE)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE))
    );

    public static final RegistryObject<Block> MOONSTONE_SLAB = BLOCKS.register(
            "moonstone_slab",
            () -> new SlabBlock(Properties.from(MOONSTONE.get()))
    );

    public static final RegistryObject<Block> MOONSTONE_STAIRS = BLOCKS.register(
            "moonstone_stairs",
            () -> new StairsBlock(() -> MOONSTONE.get().getDefaultState(), Properties.from(MOONSTONE.get()))
    );

    public static final RegistryObject<Block> MOONSTONE_BRICKS = BLOCKS.register(
            "moonstone_bricks",
            () -> new Block(Properties.create(Material.ROCK)
                    .hardnessAndResistance(4.0f, 15)
                    .sound(SoundType.STONE)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE))
    );

    public static final RegistryObject<Block> MOONSTONE_BRICK_SLAB = BLOCKS.register(
            "moonstone_brick_slab",
            () -> new SlabBlock(Properties.from(MOONSTONE_BRICKS.get()))
    );

    public static final RegistryObject<Block> MOONSTONE_BRICK_STAIRS = BLOCKS.register(
            "moonstone_brick_stairs",
            () -> new StairsBlock(() -> MOONSTONE_BRICKS.get().getDefaultState(), Properties.from(MOONSTONE_BRICKS.get()))
    );

    public static final RegistryObject<Block> SMOOTH_MOONSTONE = BLOCKS.register(
            "smooth_moonstone",
            () -> new Block(Properties.create(Material.ROCK)
                    .hardnessAndResistance(4.0f, 15)
                    .sound(SoundType.STONE)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE))
    );

    public static final RegistryObject<Block> SMOOTH_MOONSTONE_SLAB = BLOCKS.register(
            "smooth_moonstone_slab",
            () -> new SlabBlock(Properties.from(SMOOTH_MOONSTONE.get()))
    );

    public static final RegistryObject<Block> SMOOTH_MOONSTONE_STAIRS = BLOCKS.register(
            "smooth_moonstone_stairs",
            () -> new StairsBlock(() -> SMOOTH_MOONSTONE.get().getDefaultState(), Properties.from(SMOOTH_MOONSTONE.get()))
    );

    //Thorn Wood
    public static final RegistryObject<Block> THORN_LOG = BLOCKS.register(
            "thorn_log",
            () -> new ThornLog(MaterialColor.WOOD, Properties.create(Material.WOOD)
                    .hardnessAndResistance(1.0F, 1.0F)
                    .sound(SoundType.WOOD)
                    .harvestLevel(0)
                    .harvestTool(ToolType.AXE))
    );

    public static final RegistryObject<Block> THORN_PLANKS = BLOCKS.register(
            "thorn_planks",
            () -> new ThornLog(MaterialColor.WOOD, Properties.create(Material.WOOD)
                    .hardnessAndResistance(1.0F, 1.0F)
                    .sound(SoundType.WOOD)
                    .harvestLevel(0)
                    .harvestTool(ToolType.AXE))
    );

    public static final RegistryObject<Block> THORN_SLAB = BLOCKS.register(
            "thorn_slab",
            () -> new SlabBlock(Properties.from(Blocks.JUNGLE_SLAB))
    );
    public static final RegistryObject<Block> THORN_SAPLING = BLOCKS.register(
            "thorn_sapling",
            () -> new ThornSapling(ThornTree::new, Properties.from(Blocks.JUNGLE_SAPLING))
    );

    public static final RegistryObject<Block> THORN_LEAVES = BLOCKS.register(
            "thorn_leaves",
            () -> new LeavesBlock(Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F)
                    .tickRandomly()
                    .sound(SoundType.PLANT)
                    .notSolid())
    );
    public static final RegistryObject<Block> THORN_DOOR = BLOCKS.register(
            "thorn_door",
            () -> new ModdedDoorBlock(Properties.from(Blocks.JUNGLE_DOOR))
    );

    //Moon Wood
    public static final RegistryObject<Block> MOON_LOG = BLOCKS.register("moon_log", MoonLog::new);

    public static final RegistryObject<Block> MOON_PLANKS = BLOCKS.register("moon_planks", MoonPlanks::new);

    public static final RegistryObject<Block> MOON_SAPLING = BLOCKS.register(
            "moon_sapling",
            () -> new MoonSapling(MoonTree::new, Properties.from(Blocks.BIRCH_SAPLING))
    );

    public static final RegistryObject<Block> MOON_LEAVES = BLOCKS.register(
            "moon_leaves",
            () -> new LeavesBlock(Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2F)
                    .tickRandomly()
                    .sound(SoundType.PLANT)
                    .notSolid())
    );

    //Other Blocks
    public static final RegistryObject<Block> LAVA_SPONGE = BLOCKS.register(
            "lava_sponge",
            () -> new LavaSponge(Properties.create(Material.ROCK)
                    .hardnessAndResistance(0.6F)
                    .sound(SoundType.STONE))
    );

    public static final RegistryObject<Block> MOLTEN_LAVA_SPONGE = BLOCKS.register(
            "molten_lava_sponge",
            () -> new MoltenLavaSponge(Properties.create(Material.ROCK)
                    .hardnessAndResistance(0.6F)
                    .sound(SoundType.STONE))
    );

    public static final RegistryObject<Block> RIFT_BLOCK = BLOCKS.register(
            "rift_block",
            () -> new RiftBlock(Properties.create(Material.ROCK)
            .hardnessAndResistance(18000000)
            .sound(SoundType.STONE)));

    // Umbral Plains
    public static final RegistryObject<Block> UMBRAL_DUNE = BLOCKS.register(
            "umbral_dune",
            () -> new SandBlock(22,
                    Properties.create(Material.SAND)
                            .hardnessAndResistance(0.5F)
                            .sound(SoundType.SAND)));
}
