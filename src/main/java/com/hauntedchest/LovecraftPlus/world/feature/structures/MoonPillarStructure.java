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

import java.util.Random;
import java.util.function.Function;

public class MoonPillarStructure extends Structure<NoFeatureConfig> {
    public MoonPillarStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean canBeGenerated(BiomeManager biomeManagerIn, ChunkGenerator<?> generatorIn, Random randIn, int chunkX, int chunkZ, Biome biomeIn) {
        ChunkPos pos = getStartPositionForPosition(generatorIn,randIn,chunkX, chunkZ, 0, 0);

        if (chunkX == pos.x && chunkZ == pos.z){
            if (generatorIn.hasStructure(biomeIn, this)){
                return true;
            }
        }

        return false;
    }

    @Override
    public IStartFactory getStartFactory() {
        return MoonPillarStructure.Start::new;
    }

    @Override
    public String getStructureName() {
        return LovecraftPlusMod.MOD_ID + ":moon_pillar";
    }

    //unused
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> chunkGenerator, Random random, int x, int z, int spacingOffsetsX, int spacingOffsetsZ) {
        int maxDistance = 18;
        int minDistance = 8;

        int xTemp = x + maxDistance * spacingOffsetsX;
        int ztemp = z + maxDistance * spacingOffsetsZ;
        int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
        int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
        int validChunkX = xTemp2 / maxDistance;
        int validChunkZ = zTemp2 / maxDistance;

        ((SharedSeedRandom) random).setLargeFeatureSeedWithSalt(chunkGenerator.getSeed(), validChunkX, validChunkZ, this.getSeedModifier());
        validChunkX = validChunkX * maxDistance;
        validChunkZ = validChunkZ * maxDistance;
        validChunkX = validChunkX + random.nextInt(maxDistance - minDistance);
        validChunkZ = validChunkZ + random.nextInt(maxDistance - minDistance);

        return new ChunkPos(validChunkX,validChunkZ);
    }

    protected int getSeedModifier() {
        return 123809834;
    }

    public static class Start extends StructureStart {

        public Start(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
        }

        @Override
        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];

            int x = (chunkX << 4) + 7;
            int z = (chunkX << 4) + 7;
            int y = generator.func_222531_c(x,z, Heightmap.Type.WORLD_SURFACE_WG);
            BlockPos pos = new BlockPos(x,y,z);

            MoonPillarPieces.start(templateManagerIn,pos,rotation,this.components,this.rand);

            this.recalculateStructureSize();

            LovecraftPlusMod.LOGGER.info("You can find a Moon Pillar at:" + pos);
        }
    }
}
