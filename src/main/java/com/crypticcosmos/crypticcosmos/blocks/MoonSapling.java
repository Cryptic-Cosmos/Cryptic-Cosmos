package com.crypticcosmos.crypticcosmos.blocks;

import com.crypticcosmos.crypticcosmos.registries.TagRegistries;
import com.crypticcosmos.crypticcosmos.world.feature.MondroveTree;
import net.minecraft.block.*;
import net.minecraft.block.trees.Tree;
import net.minecraft.item.DebugStickItem;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class MoonSapling extends BushBlock implements IGrowable {
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
    private final Supplier<Tree> tree = MondroveTree::new;

    public MoonSapling() {
        super(Properties.from(Blocks.BIRCH_SAPLING));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Block.makeCuboidShape(
                2.0D, 0.0D, 2.0D,
                14.0D, 12.0D, 14.0D
        );
    }

    @SuppressWarnings("deprecation")
    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);

        if (!worldIn.isAreaLoaded(pos, 1)) {
            return;
        }

        if (worldIn.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0) {
            this.grow(worldIn, rand, pos, state);
        }
    }

    // @Override
    // public PlantType getPlantType(IBlockReader world, BlockPos pos) {
    //     return PlantType.get("lunara");
    // }

    @Override
    public boolean isValidGround(@Nonnull BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(TagRegistries.LUNARA_PLANTABLE_BLOCKS);
    }

    @Override
    public void grow(ServerWorld serverWorld, Random rand, BlockPos pos, BlockState state) {
        if (state.get(STAGE) == 0) {
            serverWorld.setBlockState(pos, DebugStickItem.cycleProperty(state, STAGE, false), 4);
        } else {
            if (!ForgeEventFactory.saplingGrowTree(serverWorld, rand, pos)) return;

            this.tree.get().attemptGrowTree(
                    serverWorld,
                    serverWorld.getChunkProvider().getChunkGenerator(),
                    pos,
                    state,
                    rand
            );
        }
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(@Nonnull World worldIn, Random rand, BlockPos pos, BlockState state) {
        return worldIn.rand.nextFloat() < 0.45f;
    }

    @Override
    protected void fillStateContainer(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}
