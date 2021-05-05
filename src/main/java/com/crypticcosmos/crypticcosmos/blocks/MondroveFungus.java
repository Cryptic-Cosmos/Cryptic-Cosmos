package com.crypticcosmos.crypticcosmos.blocks;

import com.crypticcosmos.crypticcosmos.registries.EffectRegistries;
import com.crypticcosmos.crypticcosmos.registries.TagRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class MondroveFungus extends BushBlock {
    public static final VoxelShape SHAPE = Block.box(5.0D,
            0.0D,
            5.0D,
            11.0D,
            10.0D,
            11.0D);

    public MondroveFungus() {
        super(Properties.of(Material.PLANT)
                .strength(0)
                .noCollission()
                .sound(SoundType.GRASS));
    }

    @Override
    public boolean mayPlaceOn(BlockState state, @Nonnull IBlockReader worldIn, @Nonnull BlockPos pos) {
        return state.is(TagRegistries.MONDROVE_FUNGUS_PLANTABLE);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void entityInside(@Nonnull BlockState state, World world, @Nonnull BlockPos pos, @Nonnull Entity entity) {
        if (!world.isClientSide() && entity instanceof LivingEntity) {
            ((LivingEntity) entity).addEffect(new EffectInstance(EffectRegistries.CORRUPTION.get(), Integer.MAX_VALUE));
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    @Nonnull
    public VoxelShape getShape(BlockState state,
                               @Nonnull IBlockReader worldIn,
                               @Nonnull BlockPos pos,
                               @Nonnull ISelectionContext context) {
        Vector3d vec3d = state.getOffset(worldIn, pos);
        return SHAPE.move(vec3d.x, vec3d.y, vec3d.z);
    }
}