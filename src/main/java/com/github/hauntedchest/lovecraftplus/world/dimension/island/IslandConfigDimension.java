package com.github.hauntedchest.lovecraftplus.world.dimension.island;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class IslandConfigDimension extends Dimension {
    public IslandConfigDimension(World world, DimensionType type) {
        super(world, type, 0.0f);
    }

    @Override
    @Nonnull
    public IslandChunkGenerator createChunkGenerator() {
        return new IslandChunkGenerator(world, new IslandBiomeProvider(new IslandBiomeProviderSettings(world.getWorldInfo())), new IslandGenSettings());
    }

    @Nullable
    @Override
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
        for (int i = chunkPosIn.getXStart(); i <= chunkPosIn.getXEnd(); ++i) {
            for (int j = chunkPosIn.getZStart(); j <= chunkPosIn.getZEnd(); ++j) {
                BlockPos blockpos = this.findSpawn(i, j, checkValid);

                if (blockpos != null) {
                    return blockpos;
                }
            }
        }

        return null;
    }

    @Nullable
    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable(posX, 0, posZ);
        Biome biome = this.world.getBiome(mutableBlockPos);
        BlockState blockState = biome.getSurfaceBuilderConfig().getTop();

        if (checkValid && !blockState.getBlock().isIn(BlockTags.VALID_SPAWN)) {
            return null;
        } else {
            Chunk chunk = this.world.getChunk(posX >> 4, posZ >> 4);
            int i = chunk.getTopBlockY(Heightmap.Type.MOTION_BLOCKING, posX & 15, posZ & 15);

            if (i < 0) {
                return null;
            } else if (chunk.getTopBlockY(Heightmap.Type.WORLD_SURFACE, posX & 15, posZ & 15) > chunk.getTopBlockY(Heightmap.Type.OCEAN_FLOOR, posX & 15, posZ & 15)) {
                return null;
            } else {
                for (int j = i + 1; j >= 0; --j) {
                    mutableBlockPos.setPos(posX, j, posZ);
                    BlockState blockstate1 = this.world.getBlockState(mutableBlockPos);

                    if (!blockstate1.getFluidState().isEmpty()) {
                        break;
                    }

                    if (blockstate1.equals(blockState)) {
                        return mutableBlockPos.up().toImmutable();
                    }
                }

                return null;
            }
        }
    }

    @Override
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
        return null;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isSkyColored() {
        return false;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        return 0.0F;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    @Nonnull
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return Vec3d.ZERO;
    }

    @Override
    public boolean canRespawnHere() {
        return true;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
        return SleepResult.BED_EXPLODES;
    }

    @Override
    public int getActualHeight() {
        return 256;
    }
}
