package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.GrombleRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import java.util.Random;

public class GiantGrombleBerry extends Block {
    public GiantGrombleBerry(Properties properties) {
        super(Properties.of(Material.VEGETABLE).strength(1.0F)
                .sound(SoundType.SHROOMLIGHT)
                .lightLevel(state -> 15)
                .harvestTool(ToolType.HOE)
                .requiresCorrectToolForDrops()
        );
    }

    @Override
    public boolean isRandomlyTicking(@Nonnull BlockState state) {
        return true;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void randomTick(@Nonnull BlockState state,
                           @Nonnull ServerWorld world,
                           @Nonnull BlockPos pos,
                           @Nonnull Random random) {
        super.randomTick(state, world, pos, random);

        world.setBlockAndUpdate(pos,
                GrombleRegistries.GIANT_ROTTEN_GROMBLE_BERRY.get().defaultBlockState());
    }
}
