package com.crypticcosmos.crypticcosmos.util;

public class MathUtils {
    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }
}
