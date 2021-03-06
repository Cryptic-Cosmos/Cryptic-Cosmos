package com.crypticcosmos.crypticcosmos.world.biomes;

import com.crypticcosmos.crypticcosmos.registries.BlockRegistries;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FancyFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.FancyTrunkPlacer;
import net.minecraftforge.common.IPlantable;

import java.util.OptionalInt;

public class ThornJungleBiome extends Biome {
    public static final BaseTreeFeatureConfig FANCY_THORN_TREE_CONFIG = Feature.TREE.withConfiguration(
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Features.States.OAK_LOG),
                    new SimpleBlockStateProvider(Features.States.OAK_LEAVES),
                    new FancyFoliagePlacer(FeatureSpread.func_242252_a(2),
                            FeatureSpread.func_242252_a(4), 4),
                    new FancyTrunkPlacer(3, 11, 0),
                    new TwoLayerFeature(0, 0, 0, OptionalInt.of(4)))
                    .setIgnoreVines()
                    .func_236702_a_(Heightmap.Type.MOTION_BLOCKING)
                    .build()
    );
    public static final BaseTreeFeatureConfig THORN_TREE_CONFIG = new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockRegistries.THORN_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockRegistries.THORN_LEAVES.get().getDefaultState()),
            new AcaciaFoliagePlacer(2, 0))
            .baseHeight(5)
            .heightRandA(2)
            .heightRandB(2)
            .trunkHeight(0)
            .ignoreVines()
            .setSapling((IPlantable) BlockRegistries.THORN_SAPLING.get())
            .build();
    public static final BaseTreeFeatureConfig THORN_GROUND_BUSH_CONFIG = new BaseTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockRegistries.THORN_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockRegistries.THORN_LEAVES.get().getDefaultState()))
            .baseHeight(4)
            .setSapling((IPlantable) BlockRegistries.THORN_SAPLING.get())
            .build();
    public static final HugeTreeFeatureConfig MEGA_THORN_TREE_CONFIG = new HugeTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(BlockRegistries.THORN_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(BlockRegistries.THORN_LEAVES.get().getDefaultState()))
            .baseHeight(10)
            .heightInterval(20)
            .decorators(ImmutableList.of(new TrunkVineTreeDecorator(), new LeaveVineTreeDecorator()))
            .setSapling((IPlantable) BlockRegistries.THORN_SAPLING.get())
            .build();

    public ThornJungleBiome(Biome.Builder builder) {

        this.addFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR
                        .withConfiguration(new MultipleRandomFeatureConfig(
                                ImmutableList.of(
                                        Feature.TREE
                                                .withConfiguration(FANCY_THORN_TREE_CONFIG)
                                                .withChance(0.1F),
                                        Features.JUNGLE_BUSH,
                                        Feature.TREE
                                                .withConfiguration(MEGA_THORN_TREE_CONFIG)
                                                .withChance(0.33333334F)
                                ),
                                Features.JUNGLE_TREE
                        ))
                        .withPlacement(Placement.COUNT_EXTRA
                                .configure(new AtSurfaceWithExtraConfig(50, 0.1F, 1))));

        //Trees
        this.addFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(
                        ImmutableList.of(Feature.TREE
                                .withConfiguration(THORN_TREE_CONFIG)
                                .withChance(0.8F)),
                        Features.JUNGLE_TREE
                )).withPlacement(Placement.COUNT_EXTRA
                        .configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1)))
        );
    }
}
