package org.apache.harmony.awt.geom;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import org.apache.harmony.awt.p062gl.Crossing;

public class GeometryUtil {
    public static final double EPSILON = Math.pow(10.0d, -14.0d);

    public static double cubic(double d, double d2, double d3, double d4, double d5) {
        double d6 = 1.0d - d;
        return (d2 * d6 * d6 * d6) + (d3 * 3.0d * d6 * d6 * d) + (d4 * 3.0d * d6 * d * d) + (d5 * d * d * d);
    }

    public static double line(double d, double d2, double d3) {
        return (d2 * (1.0d - d)) + (d3 * d);
    }

    public static double quad(double d, double d2, double d3, double d4) {
        double d5 = 1.0d - d;
        return (d2 * d5 * d5) + (d3 * 2.0d * d * d5) + (d4 * d * d);
    }

    public static int intersectLinesWithParams(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double[] dArr) {
        double d9 = d7 - d5;
        double d10 = d8 - d6;
        double d11 = ((d4 - d2) * d9) - ((d3 - d) * d10);
        if (Math.abs(d11) < EPSILON) {
            return 0;
        }
        dArr[0] = (((-d9) * (d2 - d6)) + ((d - d5) * d10)) / d11;
        if (d9 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            dArr[1] = (line(dArr[0], d, d3) - d5) / d9;
        } else if (d10 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            dArr[1] = (line(dArr[0], d2, d4) - d6) / d10;
        } else {
            dArr[1] = 0.0d;
        }
        if (dArr[0] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr[0] > 1.0d || dArr[1] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr[1] > 1.0d) {
            return 0;
        }
        return 1;
    }

    public static int intersectLines(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double[] dArr) {
        double d9;
        double d10;
        double d11;
        double d12 = d;
        double d13 = d2;
        double d14 = d3;
        double d15 = d4;
        double d16 = d5;
        double d17 = d6;
        double d18 = d7;
        double d19 = d8;
        double d20 = -(d15 - d13);
        double d21 = d14 - d12;
        double d22 = (d12 * d15) - (d14 * d13);
        double d23 = -(d19 - d17);
        double d24 = d5;
        double d25 = d18 - d24;
        double d26 = (d24 * d19) - (d18 * d17);
        double d27 = (d20 * d25) - (d23 * d21);
        if (d24 == d18 && d17 == d19 && (d20 * d24) + (d21 * d17) + d22 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d24 >= Math.min(d12, d14) && d24 <= Math.max(d12, d14)) {
            d9 = d4;
            d10 = d24;
            d11 = d2;
            if (d17 >= Math.min(d11, d9) && d17 <= Math.max(d11, d9)) {
                return 1;
            }
        } else {
            d9 = d4;
            d10 = d24;
            d11 = d2;
        }
        if (Math.abs(d27) < EPSILON) {
            return 0;
        }
        dArr[0] = ((d21 * d26) - (d25 * d22)) / d27;
        dArr[1] = ((d23 * d22) - (d20 * d26)) / d27;
        if (dArr[0] >= Math.min(d12, d14)) {
            double d28 = d10;
            double d29 = d7;
            if (dArr[0] >= Math.min(d28, d29) && dArr[0] <= Math.max(d12, d14) && dArr[0] <= Math.max(d28, d29) && dArr[1] >= Math.min(d11, d9)) {
                double d30 = d8;
                double d31 = d9;
                if (dArr[1] < Math.min(d17, d30) || dArr[1] > Math.max(d11, d31) || dArr[1] > Math.max(d17, d30)) {
                    return 0;
                }
                return 1;
            }
        }
        return 0;
    }

    public static int intersectLineAndQuad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double[] dArr) {
        int i;
        double[] dArr2 = new double[2];
        double[] dArr3 = new double[2];
        double d11 = d4 - d2;
        double d12 = d3 - d;
        int solveQuad = Crossing.solveQuad(new double[]{((d5 - d) * d11) - ((d6 - d2) * d12), ((d11 * 2.0d) * (d7 - d5)) - ((d12 * 2.0d) * (d8 - d6)), (((d5 - (d7 * 2.0d)) + d9) * d11) - (((d6 - (2.0d * d8)) + d10) * d12)}, dArr2);
        if (solveQuad == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < solveQuad; i3 = i + 1) {
            if (d12 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                i = i3;
                dArr3[i] = (quad(dArr2[i3], d5, d7, d9) - d) / d12;
            } else {
                i = i3;
                if (d11 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    dArr3[i] = (quad(dArr2[i], d6, d8, d10) - d2) / d11;
                } else {
                    dArr3[i] = 0.0d;
                }
            }
            if (dArr2[i] >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dArr2[i] <= 1.0d && dArr3[i] >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dArr3[i] <= 1.0d) {
                int i4 = i2 * 2;
                dArr[i4] = dArr2[i];
                dArr[i4 + 1] = dArr3[i];
                i2++;
            }
        }
        return i2;
    }

    public static int intersectLineAndCubic(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double[] dArr) {
        int i;
        int i2;
        double[] dArr2 = new double[3];
        double[] dArr3 = new double[3];
        double d13 = d4 - d2;
        double d14 = d3 - d;
        double d15 = d10 * 3.0d;
        double d16 = d5 * 3.0d;
        double d17 = d9 * 3.0d;
        int solveCubic = Crossing.solveCubic(new double[]{((d6 - d2) * d14) + ((d - d5) * d13), ((d6 - d8) * -3.0d * d14) + ((d5 - d7) * 3.0d * d13), ((((d6 * 3.0d) - (d8 * 6.0d)) + d15) * d14) - (((d16 - (6.0d * d7)) + d17) * d13), (((((d6 * -3.0d) + (d8 * 3.0d)) - d15) + d12) * d14) + ((((d16 - (d7 * 3.0d)) + d17) - d11) * d13)}, dArr2);
        if (solveCubic == 0) {
            return 0;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < solveCubic) {
            if (d14 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                i2 = solveCubic;
                i = i3;
                dArr3[i] = (cubic(dArr2[i3], d5, d7, d9, d11) - d) / d14;
            } else {
                i2 = solveCubic;
                i = i3;
                if (d13 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    dArr3[i] = (cubic(dArr2[i], d6, d8, d10, d12) - d2) / d13;
                } else {
                    dArr3[i] = 0.0d;
                }
            }
            if (dArr2[i] >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dArr2[i] <= 1.0d && dArr3[i] >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dArr3[i] <= 1.0d) {
                int i5 = i4 * 2;
                dArr[i5] = dArr2[i];
                dArr[i5 + 1] = dArr3[i];
                i4++;
            }
            i3 = i + 1;
            solveCubic = i2;
        }
        return i4;
    }

    public static int intersectQuads(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double[] dArr) {
        int i;
        double[] dArr2 = dArr;
        double[] dArr3 = new double[2];
        double d13 = d3 * 2.0d;
        double[] dArr4 = {(d - d13) + d5, (d * -2.0d) + d13, d};
        double d14 = d4 * 2.0d;
        double[] dArr5 = {(d2 - d14) + d6, (d2 * -2.0d) + d14, d2};
        double d15 = d9 * 2.0d;
        double[] dArr6 = {(d7 - d15) + d11, (d7 * -2.0d) + d15, d7};
        double d16 = 2.0d * d10;
        double[] dArr7 = {(d8 - d16) + d12, (d8 * -2.0d) + d16, d8};
        dArr2[1] = 0.25d;
        dArr2[0] = 0.25d;
        quadNewton(dArr4, dArr5, dArr6, dArr7, dArr3);
        if (dArr3[0] > 1.0d || dArr3[0] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr3[1] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr3[1] > 1.0d) {
            i = 0;
        } else {
            dArr2[0] = dArr3[0];
            dArr2[1] = dArr3[1];
            i = 1;
        }
        dArr2[1] = 0.75d;
        dArr2[0] = 0.75d;
        quadNewton(dArr4, dArr5, dArr6, dArr7, dArr2);
        if (dArr3[0] > 1.0d || dArr3[0] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr3[1] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr3[1] > 1.0d) {
            return i;
        }
        int i2 = i * 2;
        dArr2[i2] = dArr3[0];
        dArr2[i2 + 1] = dArr3[1];
        return i + 1;
    }

    public static int intersectQuadAndCubic(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double[] dArr) {
        int i;
        double d15 = d7;
        double d16 = d8;
        double[] dArr2 = dArr;
        double[] dArr3 = new double[3];
        double d17 = d3 * 2.0d;
        double[] dArr4 = {(d - d17) + d5, d17 - (d * 2.0d), d};
        double d18 = d4 * 2.0d;
        double[] dArr5 = {(d2 - d18) + d6, d18 - (2.0d * d2), d2};
        double d19 = d9 * 3.0d;
        double d20 = d11 * 3.0d;
        double[] dArr6 = {(((-d15) + d19) - d20) + d13, ((d15 * 3.0d) - (d9 * 6.0d)) + d20, (d15 * -3.0d) + d19, d15};
        double d21 = d10 * 3.0d;
        double d22 = d12 * 3.0d;
        double[] dArr7 = {(((-d16) + d21) - d22) + d14, ((d16 * 3.0d) - (d10 * 6.0d)) + d22, (d16 * -3.0d) + d21, d16};
        dArr2[1] = 0.25d;
        dArr2[0] = 0.25d;
        quadAndCubicNewton(dArr4, dArr5, dArr6, dArr7, dArr3);
        if (dArr3[0] > 1.0d || dArr3[0] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr3[1] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr3[1] > 1.0d) {
            i = 0;
        } else {
            dArr2[0] = dArr3[0];
            dArr2[1] = dArr3[1];
            i = 1;
        }
        dArr2[1] = 0.5d;
        dArr2[0] = 0.5d;
        quadAndCubicNewton(dArr4, dArr5, dArr6, dArr7, dArr2);
        if (dArr3[0] <= 1.0d && dArr3[0] >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dArr3[1] >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dArr3[1] <= 1.0d) {
            int i2 = i * 2;
            dArr2[i2] = dArr3[0];
            dArr2[i2 + 1] = dArr3[1];
            i++;
        }
        dArr2[1] = 0.75d;
        dArr2[0] = 0.75d;
        quadAndCubicNewton(dArr4, dArr5, dArr6, dArr7, dArr2);
        if (dArr3[0] > 1.0d || dArr3[0] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr3[1] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr3[1] > 1.0d) {
            return i;
        }
        int i3 = i * 2;
        dArr2[i3] = dArr3[0];
        dArr2[i3 + 1] = dArr3[1];
        return i + 1;
    }

    public static int intersectCubics(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double[] dArr) {
        int i;
        double d17 = d;
        double d18 = d2;
        double d19 = d9;
        double d20 = d10;
        double[] dArr2 = dArr;
        double d21 = d3 * 3.0d;
        double d22 = d5 * 3.0d;
        double[] dArr3 = {(((-d17) + d21) - d22) + d7, ((d17 * 3.0d) - (d3 * 6.0d)) + d22, (d17 * -3.0d) + d21, d17};
        double d23 = d4 * 3.0d;
        double d24 = d6 * 3.0d;
        double[] dArr4 = {(((-d18) + d23) - d24) + d8, ((d18 * 3.0d) - (d4 * 6.0d)) + d24, (d18 * -3.0d) + d23, d18};
        double d25 = d11 * 3.0d;
        double d26 = d13 * 3.0d;
        double[] dArr5 = {(((-d19) + d25) - d26) + d15, ((d19 * 3.0d) - (d11 * 6.0d)) + d26, (d19 * -3.0d) + d25, d19};
        double d27 = d12 * 3.0d;
        double d28 = d14 * 3.0d;
        double[] dArr6 = {(((-d20) + d27) - d28) + d16, ((d20 * 3.0d) - (d12 * 6.0d)) + d28, (d20 * -3.0d) + d27, d20};
        dArr2[1] = 0.25d;
        dArr2[0] = 0.25d;
        double[] dArr7 = new double[3];
        cubicNewton(dArr3, dArr4, dArr5, dArr6, dArr7);
        if (dArr7[0] > 1.0d || dArr7[0] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr7[1] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr7[1] > 1.0d) {
            i = 0;
        } else {
            dArr2[0] = dArr7[0];
            dArr2[1] = dArr7[1];
            i = 1;
        }
        dArr2[1] = 0.5d;
        dArr2[0] = 0.5d;
        cubicNewton(dArr3, dArr4, dArr5, dArr6, dArr2);
        if (dArr7[0] <= 1.0d && dArr7[0] >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dArr7[1] >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && dArr7[1] <= 1.0d) {
            int i2 = i * 2;
            dArr2[i2] = dArr7[0];
            dArr2[i2 + 1] = dArr7[1];
            i++;
        }
        dArr2[1] = 0.75d;
        dArr2[0] = 0.75d;
        cubicNewton(dArr3, dArr4, dArr5, dArr6, dArr2);
        if (dArr7[0] > 1.0d || dArr7[0] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr7[1] < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || dArr7[1] > 1.0d) {
            return i;
        }
        int i3 = i * 2;
        dArr2[i3] = dArr7[0];
        dArr2[i3 + 1] = dArr7[1];
        return i + 1;
    }

    public static void subQuad(double[] dArr, double d, boolean z) {
        if (z) {
            double d2 = 1.0d - d;
            dArr[2] = (dArr[0] * d2) + (dArr[2] * d);
            dArr[3] = (d2 * dArr[1]) + (d * dArr[3]);
            return;
        }
        double d3 = 1.0d - d;
        dArr[2] = (dArr[2] * d3) + (dArr[4] * d);
        dArr[3] = (d3 * dArr[3]) + (d * dArr[5]);
    }

    public static void subCubic(double[] dArr, double d, boolean z) {
        if (z) {
            double d2 = 1.0d - d;
            dArr[2] = (dArr[0] * d2) + (dArr[2] * d);
            dArr[3] = (d2 * dArr[1]) + (d * dArr[3]);
            return;
        }
        double d3 = 1.0d - d;
        dArr[4] = (dArr[4] * d3) + (dArr[6] * d);
        dArr[5] = (d3 * dArr[5]) + (d * dArr[7]);
    }

    private static void cubicNewton(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
        double d = dArr5[0];
        double d2 = dArr5[1];
        while (true) {
            double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE - d;
            double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE - d2;
            if (Math.sqrt((d3 * d3) + (d4 * d4)) <= EPSILON) {
                dArr5[0] = d;
                dArr5[1] = d2;
                return;
            }
            double d5 = ((-((dArr[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + dArr[2])) * ((dArr4[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr4[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + dArr4[2])) + (((dArr2[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr2[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + dArr2[2]) * ((dArr3[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr3[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + dArr3[2]));
            double d6 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE - (((((((((((dArr[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + (dArr[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr[3]) - (dArr3[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr3[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr3[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - dArr3[3]) * (((-0.0d * dArr4[0]) - (dArr4[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - dArr4[2])) + (((((((((dArr2[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr2[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + (dArr2[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr2[3]) - (dArr4[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr4[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr4[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - dArr4[3]) * (((dArr3[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr3[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr3[2]))) / d5);
            double d7 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE - ((((((dArr[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr[2]) * ((((((((dArr2[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr2[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + (dArr2[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr2[3]) - (dArr4[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr4[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr4[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - dArr4[3])) - ((((dArr2[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr2[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr2[2]) * ((((((((dArr[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + (dArr[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr[3]) - (dArr3[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr3[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr3[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - dArr3[3]))) / d5);
            d = d6;
            d2 = d7;
        }
    }

    private static void quadAndCubicNewton(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
        double d = dArr5[0];
        double d2 = dArr5[1];
        while (true) {
            double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE - d;
            double d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE - d2;
            if (Math.sqrt((d3 * d3) + (d4 * d4)) <= EPSILON) {
                dArr5[0] = d;
                dArr5[1] = d2;
                return;
            }
            double d5 = ((-((dArr[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + dArr[1])) * ((dArr4[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr4[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + dArr4[2])) + (((dArr2[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + dArr2[1]) * ((dArr3[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr3[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + dArr3[2]));
            double d6 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE - ((((((((((dArr[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr[2]) + (dArr3[0] * -0.0d)) - (dArr3[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr3[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - dArr3[3]) * (((-0.0d * dArr4[0]) - (dArr4[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - dArr4[2])) + ((((((((dArr2[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr2[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr2[2]) - (dArr4[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr4[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr4[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - dArr4[3]) * (((dArr3[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr3[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr3[2]))) / d5);
            double d7 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE - (((((dArr[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + dArr[1]) * (((((((dArr2[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr2[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr2[2]) - (dArr4[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr4[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr4[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - dArr4[3])) - (((dArr2[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + dArr2[1]) * (((((((dArr[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) + (dArr[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) + dArr[2]) - (dArr3[0] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr3[1] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - (dArr3[2] * FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) - dArr3[3]))) / d5);
            d = d6;
            d2 = d7;
        }
    }

    private static void quadNewton(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
        double d = dArr5[0];
        double d2 = dArr5[1];
        double d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d4 = d2;
        double d5 = 0.0d;
        while (true) {
            double d6 = d3 - d;
            double d7 = d5 - d4;
            if (Math.sqrt((d6 * d6) + (d7 * d7)) <= EPSILON) {
                dArr5[0] = d;
                dArr5[1] = d4;
                return;
            }
            double d8 = d * 2.0d;
            double d9 = 2.0d * d4;
            double d10 = ((-((dArr[0] * d8) + dArr[1])) * ((dArr4[0] * d9) + dArr4[1])) + (((dArr3[0] * d9) + dArr3[1]) * ((dArr2[0] * d8) + dArr2[1]));
            double d11 = d * d;
            double d12 = d4 * d4;
            double d13 = ((-((((((dArr[0] * d11) + (dArr[1] * d)) + dArr[1]) - (dArr3[0] * d12)) - (dArr3[1] * d4)) - dArr3[2])) * ((dArr4[0] * d9) + dArr4[1])) + (((d9 * dArr3[0]) + dArr3[1]) * ((((((dArr2[0] * d11) + (dArr2[1] * d)) + dArr2[2]) - (dArr4[0] * d12)) - (dArr4[1] * d4)) - dArr4[2]));
            d5 = d4;
            d4 -= ((((dArr[0] * d8) + dArr[1]) * ((((((dArr2[0] * d11) + (dArr2[1] * d)) + dArr2[2]) - (dArr4[0] * d12)) - (dArr4[1] * d4)) - dArr4[2])) - (((d8 * dArr2[0]) + dArr2[1]) * ((((((d11 * dArr[0]) + (dArr[1] * d)) + dArr[2]) - (d12 * dArr3[0])) - (dArr3[1] * d4)) - dArr3[2]))) / d10;
            double d14 = d;
            d -= d13 / d10;
            d3 = d14;
        }
    }
}
