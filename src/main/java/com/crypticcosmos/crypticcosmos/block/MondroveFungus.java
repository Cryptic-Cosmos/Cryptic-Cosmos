package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.EffectRegistries;
import com.crypticcosmos.crypticcosmos.register.TagRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;

public class MondroveFungus extends BushBlock {
    public static final VoxelShape SHAPE = box(5.0D,
            0.0D,
            5.0D,
            11.0D,
            10.0D,
            11.0D);

    public MondroveFungus(Properties properties) {
        super(properties);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, @Nonnull BlockGetter worldIn, @Nonnull BlockPos pos) {
        return state.is(TagRegistries.MONDROVE_FUNGUS_PLANTABLE);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void entityInside(@Nonnull BlockState state, Level world, @Nonnull BlockPos pos, @Nonnull Entity entity) {
        if (!world.isClientSide() && entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(EffectRegistries.CORRUPTION.get(), Integer.MAX_VALUE));
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    @Nonnull
    public VoxelShape getShape(BlockState state,
                               @Nonnull BlockGetter worldIn,
                               @Nonnull BlockPos pos,
                               @Nonnull CollisionContext context) {
        var vec3d = state.getOffset(worldIn, pos);
        return SHAPE.move(vec3d.x, vec3d.y, vec3d.z);
    }
}