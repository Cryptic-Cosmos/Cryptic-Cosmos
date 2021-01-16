package com.github.hauntedchest.lovecraftplus.world.dimension;

public class IslandGenerator {
    private static final int X_NOISE_GEN = 1619;
    private static final int Y_NOISE_GEN = 31337;
    private static final int Z_NOISE_GEN = 6971;
    private static final int SEED_NOISE_GEN = 1013;

    private final static double DEFAULT_ISLAND_DISPLACEMENT = 1.0;
    private final static double DEFAULT_ISLAND_FREQUENCY = 1.0;
    private final static int DEFAULT_ISLAND_SEED = 0;
    //private static final double SQRT_3 = 1.7320508075688772935;

    private int seed = DEFAULT_ISLAND_SEED;

    public static double ValueNoise3D(int x, int y, int z, int seed) {
        return 1.0 - ((double) IntValueNoise3D(x, y, z, seed) / 1073741824.0);
    }

    public static int IntValueNoise3D(int x, int y, int z, int seed) {
        int n = (X_NOISE_GEN * x + Y_NOISE_GEN * y + Z_NOISE_GEN * z + SEED_NOISE_GEN * seed) & 0x7fffffff;
        n = (n >> 13) ^ n;

        return (n * (n * n * 60493 + 19990303) + 1376312589) & 0x7fffffff;
    }

    public double getValue(double x, double y, double z) {
        double frequency = DEFAULT_ISLAND_FREQUENCY;
        x *= frequency;
        y *= frequency;
        z *= frequency;

        int xInt = (x > 0.0 ? (int) x : (int) x - 1);
        int yInt = (y > 0.0 ? (int) y : (int) y - 1);
        int zInt = (z > 0.0 ? (int) z : (int) z - 1);

        double minDist = 2147483647.0;
        double xCandidate = 0;
        double yCandidate = 0;
        double zCandidate = 0;

        for (int zCur = zInt - 2; zCur <= zInt + 2; zCur++) {
            for (int yCur = yInt - 2; yCur <= yInt + 2; yCur++) {
                for (int xCur = xInt - 2; xCur <= xInt + 2; xCur++) {
                    double xPos = xCur + ValueNoise3D(xCur, yCur, zCur, seed);
                    double yPos = yCur + ValueNoise3D(xCur, yCur, zCur, seed + 1);
                    double zPos = zCur + ValueNoise3D(xCur, yCur, zCur, seed + 2);
                    double xDist = xPos - x;
                    double yDist = yPos - y;
                    double zDist = zPos - z;
                    double dist = xDist * xDist + yDist * yDist + zDist * zDist;

                    if (dist < minDist) {
                        minDist = dist;
                        xCandidate = xPos;
                        yCandidate = yPos;
                        zCandidate = zPos;
                    }
                }
            }
        }

        double value;

        //boolean enableDistance = false;

        /*
        if (enableDistance) {
            double xDist = xCandidate - x;
            double yDist = yCandidate - y;
            double zDist = zCandidate - z;
            value = (Math.sqrt(xDist * xDist + yDist * yDist + zDist * zDist)) * SQRT_3 - 1.0;
        } else {
        */
        value = 0.0;
        //}

        return value + (DEFAULT_ISLAND_DISPLACEMENT * ValueNoise3D(
                (int) (Math.floor(xCandidate)),
                (int) (Math.floor(yCandidate)),
                (int) (Math.floor(zCandidate)), seed)
        );
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }
}
