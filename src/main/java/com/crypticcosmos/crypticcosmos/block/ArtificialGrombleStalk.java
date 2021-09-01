package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nonnull;

public class ArtificialGrombleStalk extends GrowingPlantBodyBlock {
    public static final VoxelShape SHAPE = box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public ArtificialGrombleStalk(Properties p) {
        super(p, Direction.UP, SHAPE, false);
    }

    @Nonnull
    public GrowingPlantHeadBlock getHeadBlock() {
        return BlockRegistries.ARTIFICIAL_GROMBLE_STALK.get();
    }
}
