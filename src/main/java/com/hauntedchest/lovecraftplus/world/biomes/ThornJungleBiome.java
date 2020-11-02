package com.hauntedchest.lovecraftplus.world.biomes;

import com.google.common.collect.ImmutableList;
import com.hauntedchest.lovecraftplus.registries.BiomeHandler;
import com.hauntedchest.lovecraftplus.registries.BlockHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;

public class ThornJungleBiome extends Biome {
    private static final BlockState WATER = Blocks.WATER.getDefaultState();
    private static final BlockState JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();
    private static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.getDefaultState();
    public static final TreeFeatureConfig JUNGLE_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(JUNGLE_LEAVES), new AcaciaFoliagePlacer(2, 0))).baseHeight(6).setSapling((net.minecraftforge.common.IPlantable) BlockHandler.THORN_SAPLING.get()).build();
    private static final BlockState THORN_LOG = BlockHandler.THORN_LOG.get().getDefaultState();
    private static final BlockState THORN_LEAVES = BlockHandler.THORN_LEAVES.get().getDefaultState();
    public static final TreeFeatureConfig FANCY_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(THORN_LOG), new SimpleBlockStateProvider(THORN_LEAVES), new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable) Blocks.OAK_SAPLING).build();
    public static final TreeFeatureConfig THORN_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(THORN_LOG), new SimpleBlockStateProvider(THORN_LEAVES), new AcaciaFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).heightRandB(2).trunkHeight(0).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) BlockHandler.THORN_SAPLING.get()).build();
    public static final BaseTreeFeatureConfig JUNGLE_GROUND_BUSH_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(THORN_LOG), new SimpleBlockStateProvider(THORN_LEAVES))).baseHeight(4).setSapling((net.minecraftforge.common.IPlantable) BlockHandler.THORN_SAPLING.get()).build();
    public static final HugeTreeFeatureConfig MEGA_JUNGLE_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(THORN_LOG), new SimpleBlockStateProvider(THORN_LEAVES))).baseHeight(10).heightInterval(20).decorators(ImmutableList.of(new TrunkVineTreeDecorator(), new LeaveVineTreeDecorator())).setSapling((net.minecraftforge.common.IPlantable) BlockHandler.THORN_SAPLING.get()).build();

    public ThornJungleBiome() {
        super(new Biome.Builder()
                .scale(1f)
                .temperature(0.2f)
                .waterColor(0x465623)
                .waterFogColor(0x88ba40)
                .surfaceBuilder(SurfaceBuilder.DEFAULT,
                        BiomeHandler.GRASS_STONE_SAND)
                .category(Biome.Category.JUNGLE)
                .downfall(0.0001f)
                .depth(0.125f)
                .parent(null)
                .precipitation(Biome.RainType.RAIN));

        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addStructures(this);
        DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSedimentDisks(this);
        DefaultBiomeFeatures.addBamboo(this);

        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR
                        .withConfiguration(new MultipleRandomFeatureConfig(
                                ImmutableList.of(Feature.FANCY_TREE
                                                .withConfiguration(FANCY_TREE_CONFIG)
                                                .withChance(0.1F),
                                        Feature.JUNGLE_GROUND_BUSH
                                                .withConfiguration(JUNGLE_GROUND_BUSH_CONFIG)
                                                .withChance(0.5F),
                                        Feature.MEGA_JUNGLE_TREE
                                                .withConfiguration(MEGA_JUNGLE_TREE_CONFIG)
                                                .withChance(0.33333334F)),
                                Feature.NORMAL_TREE
                                        .withConfiguration(JUNGLE_TREE_CONFIG)))
                        .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
                                .configure(new AtSurfaceWithExtraConfig(
                                        50, 0.1F, 1))));

        DefaultBiomeFeatures.addExtraDefaultFlowers(this);
        DefaultBiomeFeatures.addJungleGrass(this);
        DefaultBiomeFeatures.addMushrooms(this);
        DefaultBiomeFeatures.addReedsAndPumpkins(this);
        DefaultBiomeFeatures.addSprings(this);
        DefaultBiomeFeatures.addJunglePlants(this);
        DefaultBiomeFeatures.addFreezeTopLayer(this);

        //All stuff found in DefaultBiomeFeatures Class
        //Spawning Entities
        addSpawn(EntityClassification.CREATURE,
                new SpawnListEntry(EntityType.BEE, 1, 1, 2));

        //Mineshaft
        addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES,
                Feature.MINESHAFT.withConfiguration(
                        new MineshaftConfig(0.004F, MineshaftStructure.Type.NORMAL))
                        .withPlacement(Placement.NOPE.configure(
                                IPlacementConfig.NO_PLACEMENT_CONFIG)));


        //Lakes
        addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS,
                Feature.LAKE.withConfiguration(
                        new BlockStateFeatureConfig(WATER))
                        .withPlacement(Placement.LAVA_LAKE.configure(new ChanceConfig(80))));

        //Monster Rooms
        addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES,
                Feature.MONSTER_ROOM
                        .withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                        .withPlacement(Placement.DUNGEONS.configure(new ChanceConfig(8))));

        //Trees
        addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(
                        new MultipleRandomFeatureConfig(
                                ImmutableList.of(
                                        Feature.FANCY_TREE
                                                .withConfiguration(THORN_TREE_CONFIG)
                                                .withChance(0.8F)),
                                Feature.NORMAL_TREE.withConfiguration(JUNGLE_TREE_CONFIG)))
                        .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
                                .configure(new AtSurfaceWithExtraConfig(
                                        2, 0.1F, 1))));
    }
}
