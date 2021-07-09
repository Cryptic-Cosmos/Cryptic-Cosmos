package com.crypticcosmos.crypticcosmos.block;

import com.crypticcosmos.crypticcosmos.register.BlockRegistries;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractBodyPlantBlock;
import net.minecraft.block.AbstractTopPlantBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;

import javax.annotation.Nonnull;

public class ArtificialGrombleStalk extends AbstractBodyPlantBlock {
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public ArtificialGrombleStalk(AbstractBlock.Properties p) {
        super(p, Direction.UP, SHAPE, false);
    }

    @Nonnull
    public AbstractTopPlantBlock getHeadBlock() {
        return BlockRegistries.ARTIFICIAL_GROMBLE_STALK.get();
    }
}
