package com.crypticcosmos.crypticcosmos.blocks;

import com.crypticcosmos.crypticcosmos.registries.TagRegistries;
import com.crypticcosmos.crypticcosmos.world.feature.MondroveTree;
import net.minecraft.block.*;
import net.minecraft.block.trees.Tree;
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
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    private final Supplier<Tree> tree = MondroveTree::new;

    public MoonSapling() {
        super(Properties.copy(Blocks.BIRCH_SAPLING));
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return Block.box(
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

        if (worldIn.getLightEmission(pos.above()) >= 9 && rand.nextInt(7) == 0) {
            this.performBonemeal(worldIn, rand, pos, state);
        }
    }

    @Override
    public boolean mayPlaceOn(@Nonnull BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.is(TagRegistries.LUNARA_PLANTABLE_BLOCKS);
    }

    @Override
    public void performBonemeal(ServerWorld serverWorld, Random rand, BlockPos pos, BlockState state) {
        if (state.getValue(STAGE) == 0) {
            serverWorld.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            if (!ForgeEventFactory.saplingGrowTree(serverWorld, rand, pos)) return;

            this.tree.get().growTree(
                    serverWorld,
                    serverWorld.getChunkSource().getGenerator(),
                    pos,
                    state,
                    rand
            );
        }
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(@Nonnull World worldIn, Random rand, BlockPos pos, BlockState state) {
        return worldIn.random.nextFloat() < 0.45f;
    }

    @Override
    protected void createBlockStateDefinition(@Nonnull StateContainer.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}
