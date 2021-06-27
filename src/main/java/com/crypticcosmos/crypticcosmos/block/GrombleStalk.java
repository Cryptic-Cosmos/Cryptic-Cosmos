package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;

import javax.annotation.Nonnull;

public class GrombleStalk extends AbstractBodyPlantBlock {
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public GrombleStalk(Properties p) {
        super(p, Direction.UP, SHAPE, false);
    }

    @Nonnull
    public AbstractTopPlantBlock getHeadBlock() {
        return BlockRegistries.GROMBLE_STALK.get();
    }
}
