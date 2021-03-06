package com.crypticcosmos.crypticcosmos.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

@SuppressWarnings("NullableProblems")
public class ThornLog extends RotatedPillarBlock {
    private static final VoxelShape COLLISION_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 18.0D, 17.0D, 18.0D);

    public ThornLog() {
        super(Properties.create(Material.WOOD,
                state -> state.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.DIRT : MaterialColor.OBSIDIAN)
                .hardnessAndResistance(1.0F, 1.0F)
                .sound(SoundType.WOOD)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE));
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        entityIn.attackEntityFrom(DamageSource.CACTUS, 2.0F);
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return COLLISION_SHAPE;
    }
}