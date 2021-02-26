package org.apache.harmony.awt.p062gl.color;

/* renamed from: org.apache.harmony.awt.gl.color.LUTColorConverter */
public class LUTColorConverter {
    private static byte[] from16lRGBtosRGB_LUT;
    private static byte[] from8lRGBtosRGB_LUT;
    private static short[] fromsRGBto16lRGB_LUT;
    private static byte[] fromsRGBto8lRGB_LUT;
    private static byte[][] fromsRGBto8sRGB_LUTs;

    public static byte[] getFrom8lRGBtosRGB_LUT() {
        float f;
        if (from8lRGBtosRGB_LUT == null) {
            from8lRGBtosRGB_LUT = new byte[256];
            for (int i = 0; i < 256; i++) {
                float f2 = ((float) i) / 255.0f;
                if (f2 <= 0.04045f) {
                    f = f2 / 12.92f;
                } else {
                    f = (float) Math.pow((((double) f2) + 0.055d) / 1.055d, 2.4d);
                }
                from8lRGBtosRGB_LUT[i] = (byte) Math.round(f * 255.0f);
            }
        }
        return from8lRGBtosRGB_LUT;
    }

    public static byte[] getFrom16lRGBtosRGB_LUT() {
        float f;
        if (from16lRGBtosRGB_LUT == null) {
            from16lRGBtosRGB_LUT = new byte[65536];
            for (int i = 0; i < 65536; i++) {
                float f2 = ((float) i) / 65535.0f;
                if (f2 <= 0.04045f) {
                    f = f2 / 12.92f;
                } else {
                    f = (float) Math.pow((((double) f2) + 0.055d) / 1.055d, 2.4d);
                }
                from16lRGBtosRGB_LUT[i] = (byte) Math.round(f * 255.0f);
            }
        }
        return from16lRGBtosRGB_LUT;
    }

    public static byte[] getFromsRGBto8lRGB_LUT() {
        float f;
        if (fromsRGBto8lRGB_LUT == null) {
            fromsRGBto8lRGB_LUT = new byte[256];
            for (int i = 0; i < 256; i++) {
                float f2 = ((float) i) / 255.0f;
                if (f2 <= 0.0031308f) {
                    f = f2 * 12.92f;
                } else {
                    f = (((float) Math.pow((double) f2, 0.4166666666666667d)) * 1.055f) - 0.055f;
                }
                fromsRGBto8lRGB_LUT[i] = (byte) Math.round(f * 255.0f);
            }
        }
        return fromsRGBto8lRGB_LUT;
    }

    public static short[] getFromsRGBto16lRGB_LUT() {
        float f;
        if (fromsRGBto16lRGB_LUT == null) {
            fromsRGBto16lRGB_LUT = new short[256];
            for (int i = 0; i < 256; i++) {
                float f2 = ((float) i) / 255.0f;
                if (f2 <= 0.0031308f) {
                    f = f2 * 12.92f;
                } else {
                    f = (((float) Math.pow((double) f2, 0.4166666666666667d)) * 1.055f) - 0.055f;
                }
                fromsRGBto16lRGB_LUT[i] = (short) Math.round(f * 65535.0f);
            }
        }
        return fromsRGBto16lRGB_LUT;
    }

    public static byte[] getsRGBLUT(int i) {
        if (i < 1) {
            return null;
        }
        int i2 = i - 1;
        if (fromsRGBto8sRGB_LUTs == null) {
            fromsRGBto8sRGB_LUTs = new byte[16][];
        }
        byte[][] bArr = fromsRGBto8sRGB_LUTs;
        if (bArr[i2] == null) {
            bArr[i2] = createLUT(i);
        }
        return fromsRGBto8sRGB_LUTs[i2];
    }

    private static byte[] createLUT(int i) {
        int i2 = 1 << i;
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((int) ((255.0f / ((float) (i2 - 1))) + 0.5f));
        }
        return bArr;
    }
}
