package net.minecraft.src;

public class MathHelper {
    private static float[] SIN_TABLE = new float[65536];

    public static final float sin(float var0) {
        return SIN_TABLE[(int)(var0 * 10430.378F) & '\uffff'];
    }

    public static final float cos(float var0) {
        return SIN_TABLE[(int)(var0 * 10430.378F + 16384.0F) & '\uffff'];
    }

    public static final float sqrt_float(float var0) {
        return (float)Math.sqrt((double)var0);
    }

    public static final float sqrt_double(double var0) {
        return (float)Math.sqrt(var0);
    }

    public static int floor_float(float var0) {
        int var1 = (int)var0;
        return var0 < (float)var1 ? var1 - 1 : var1;
    }

    public static int floor_double(double var0) {
        int var2 = (int)var0;
        return var0 < (double)var2 ? var2 - 1 : var2;
    }

    public static float abs(float var0) {
        return var0 >= 0.0F ? var0 : -var0;
    }

    public static double abs_max(double var0, double var2) {
        if (var0 < 0.0D) {
            var0 = -var0;
        }

        if (var2 < 0.0D) {
            var2 = -var2;
        }

        return var0 > var2 ? var0 : var2;
    }

    public static int bucketInt(int var0, int var1) {
        return var0 < 0 ? -((-var0 - 1) / var1) - 1 : var0 / var1;
    }

    public static boolean stringNullOrLengthZero(String var0) {
        return var0 == null || var0.length() == 0;
    }
    
    public static float lerp(float var0, float var1, float var2) {
		return var0 + (var1 - var0) * var2;
	}

	public static double lerp(double var0, double var2, double var4) {
		return var0 + (var2 - var0) * var4;
	}

    public static String formatFloat(float f0) {
        return String.valueOf(Math.floor((double)(f0 * 100.0F)) / 100.0D);
    }

    public static String formatDouble(double d0) {
        return String.valueOf(Math.floor(d0 * 100.0D) / 100.0D);
    }

    public static float floorMod(float f0, float f1) {
        float var2 = f0 % f1;
        if(var2 < 0.0F) {
            var2 += f1;
        }

        return var2;
    }
    static {
        for(int var0 = 0; var0 < 65536; ++var0) {
            SIN_TABLE[var0] = (float)Math.sin((double)var0 * 3.141592653589793D * 2.0D / 65536.0D);
        }

    }
}
