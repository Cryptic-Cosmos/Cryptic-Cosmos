package com.hauntedchest.LovecraftPlus.world.feature.structures;

import com.hauntedchest.LovecraftPlus.LovecraftPlusMod;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Function;

public class MoonPillarStructure extends Structure<NoFeatureConfig> {
    public MoonPillarStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    // canBeGenerated
    @Override
    public boolean canBeGenerated(@Nonnull BiomeManager manager,
                                  @Nonnull ChunkGenerator<?> generator,
                                  @Nonnull Random rand,
                                  int chunkX,
                                  int chunkZ,
                                  @Nonnull Biome biome) {
        ChunkPos pos = this.getStartPositionForPosition(generator, rand, chunkX, chunkZ, 0, 0);

        if (chunkX == pos.x && chunkZ == pos.z) {
            return generator.hasStructure(biome, this);
        }

        return false;
    }

    // unused
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public @Nonnull
    IStartFactory getStartFactory() {
        return MoonPillarStructure.Start::new;
    }

    @Override
    public @Nonnull
    String getStructureName() {
        return LovecraftPlusMod.MOD_ID + ":moon_pillar";
    }

    @Override
    protected @Nonnull
    ChunkPos getStartPositionForPosition(ChunkGenerator<?> generator, Random rand, int x, int z, int offsetX,
                                         int offsetZ) {
        int maxDistance = 10;
        int minDistance = 3;

        int xTemp = x + maxDistance * offsetX;
        int ztemp = z + maxDistance * offsetZ;
        int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
        int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
        int validChunkX = xTemp2 / maxDistance;
        int validChunkZ = zTemp2 / maxDistance;

        ((SharedSeedRandom) rand).setLargeFeatureSeedWithSalt(generator.getSeed(), validChunkX, validChunkZ,
                this.getSeedModifier());
        validChunkX = validChunkX * maxDistance;
        validChunkZ = validChunkZ * maxDistance;
        validChunkX = validChunkX + rand.nextInt(maxDistance - minDistance);
        validChunkZ = validChunkZ + rand.nextInt(maxDistance - minDistance);

        return new ChunkPos(validChunkX, validChunkZ);
    }

    protected int getSeedModifier() {
        return 547837340;
    }

    public static class Start extends StructureStart {

        public Start(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference,
                     long seed) {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
        }

        @Override
        public void init(ChunkGenerator<?> generator, @Nonnull TemplateManager templateManagerIn, int chunkX, int chunkZ,
                         @Nonnull Biome biomeIn) {
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];

            int x = (chunkX << 4) + 7;
            int z = (chunkX << 4) + 7;
            int y = generator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
            BlockPos pos = new BlockPos(x, y, z);

            MoonPillarPieces.start(templateManagerIn, pos, rotation, this.components);

            this.recalculateStructureSize();

            LovecraftPlusMod.LOGGER.info("We can find a moon pillar at: " + pos);
        }
    }
}
