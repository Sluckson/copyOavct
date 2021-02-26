package org.apache.harmony.awt.p062gl;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import harmony.java.awt.Shape;
import harmony.java.awt.geom.AffineTransform;
import harmony.java.awt.geom.PathIterator;

/* renamed from: org.apache.harmony.awt.gl.Crossing */
public class Crossing {
    public static final int CROSSING = 255;
    static final double DELTA = 1.0E-5d;
    static final double ROOT_DELTA = 1.0E-10d;
    static final int UNKNOWN = 254;

    public static int crossLine(double d, double d2, double d3, double d4, double d5, double d6) {
        int i;
        if ((d5 < d && d5 < d3) || ((d5 > d && d5 > d3) || ((d6 > d2 && d6 > d4) || d == d3))) {
            return 0;
        }
        if ((d6 >= d2 || d6 >= d4) && ((d4 - d2) * (d5 - d)) / (d3 - d) <= d6 - d2) {
            return 0;
        }
        return i == 0 ? d < d3 ? 0 : -1 : d5 == d3 ? d < d3 ? 1 : 0 : d < d3 ? 1 : -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0060 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int intersectLine(double r11, double r13, double r15, double r17, double r19, double r21, double r23, double r25) {
        /*
            r0 = 0
            int r1 = (r23 > r11 ? 1 : (r23 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x0009
            int r1 = (r23 > r15 ? 1 : (r23 == r15 ? 0 : -1))
            if (r1 < 0) goto L_0x0019
        L_0x0009:
            int r1 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0011
            int r2 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r2 > 0) goto L_0x0019
        L_0x0011:
            int r2 = (r21 > r13 ? 1 : (r21 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
            int r2 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r2 <= 0) goto L_0x001a
        L_0x0019:
            return r0
        L_0x001a:
            int r2 = (r25 > r13 ? 1 : (r25 == r13 ? 0 : -1))
            if (r2 >= 0) goto L_0x0022
            int r2 = (r25 > r17 ? 1 : (r25 == r17 ? 0 : -1))
            if (r2 < 0) goto L_0x006a
        L_0x0022:
            r2 = 255(0xff, float:3.57E-43)
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x0029
            return r2
        L_0x0029:
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x003e
            int r3 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r3 >= 0) goto L_0x0034
            r3 = r19
            goto L_0x0035
        L_0x0034:
            r3 = r11
        L_0x0035:
            int r5 = (r15 > r23 ? 1 : (r15 == r23 ? 0 : -1))
            if (r5 >= 0) goto L_0x003b
            r5 = r15
            goto L_0x004b
        L_0x003b:
            r5 = r23
            goto L_0x004b
        L_0x003e:
            int r3 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r3 >= 0) goto L_0x0045
            r3 = r19
            goto L_0x0046
        L_0x0045:
            r3 = r15
        L_0x0046:
            int r5 = (r11 > r23 ? 1 : (r11 == r23 ? 0 : -1))
            if (r5 >= 0) goto L_0x003b
            r5 = r11
        L_0x004b:
            double r7 = r17 - r13
            double r9 = r15 - r11
            double r7 = r7 / r9
            double r3 = r3 - r11
            double r3 = r3 * r7
            double r3 = r3 + r13
            double r5 = r5 - r11
            double r7 = r7 * r5
            double r7 = r7 + r13
            int r5 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r5 >= 0) goto L_0x0061
            int r5 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r5 >= 0) goto L_0x0061
            return r0
        L_0x0061:
            int r5 = (r3 > r25 ? 1 : (r3 == r25 ? 0 : -1))
            if (r5 <= 0) goto L_0x009c
            int r3 = (r7 > r25 ? 1 : (r7 == r25 ? 0 : -1))
            if (r3 > 0) goto L_0x006a
            goto L_0x009c
        L_0x006a:
            int r2 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x006f
            return r0
        L_0x006f:
            r2 = -1
            if (r1 != 0) goto L_0x0079
            int r1 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r1 >= 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r0 = -1
        L_0x0078:
            return r0
        L_0x0079:
            r1 = 1
            int r3 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x0084
            int r2 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r2 >= 0) goto L_0x0083
            r0 = 1
        L_0x0083:
            return r0
        L_0x0084:
            int r3 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x0092
            int r2 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r2 >= 0) goto L_0x0091
            int r2 = (r19 > r15 ? 1 : (r19 == r15 ? 0 : -1))
            if (r2 >= 0) goto L_0x0091
            r0 = 1
        L_0x0091:
            return r0
        L_0x0092:
            int r1 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
            if (r1 >= 0) goto L_0x009b
            int r1 = (r19 > r11 ? 1 : (r19 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x009b
            r0 = -1
        L_0x009b:
            return r0
        L_0x009c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.awt.p062gl.Crossing.intersectLine(double, double, double, double, double, double, double, double):int");
    }

    public static boolean isInsideEvenOdd(int i) {
        return (i & 1) != 0;
    }

    public static boolean isInsideNonZero(int i) {
        return i != 0;
    }

    public static boolean isZero(double d) {
        return -1.0E-5d < d && d < 1.0E-5d;
    }

    public static int solveQuad(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr2;
        double d = dArr[2];
        int i = 1;
        double d2 = dArr[1];
        double d3 = dArr[0];
        if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double d4 = (d2 * d2) - ((4.0d * d) * d3);
            if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return 0;
            }
            double sqrt = Math.sqrt(d4);
            double d5 = -d2;
            double d6 = d * 2.0d;
            dArr3[0] = (d5 + sqrt) / d6;
            if (sqrt != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                dArr3[1] = (d5 - sqrt) / d6;
                i = 2;
            }
        } else if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return -1;
        } else {
            dArr3[0] = (-d3) / d2;
        }
        return fixRoots(dArr3, i);
    }

    public static int solveCubic(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr2;
        int i = 3;
        double d = dArr[3];
        if (d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return solveQuad(dArr, dArr2);
        }
        double d2 = dArr[2] / d;
        double d3 = dArr[1] / d;
        double d4 = dArr[0] / d;
        double d5 = ((d2 * d2) - (d3 * 3.0d)) / 9.0d;
        double d6 = (((((d2 * 2.0d) * d2) * d2) - ((9.0d * d2) * d3)) + (d4 * 27.0d)) / 54.0d;
        double d7 = d5 * d5 * d5;
        double d8 = d6 * d6;
        double d9 = (-d2) / 3.0d;
        if (d8 < d7) {
            double acos = Math.acos(d6 / Math.sqrt(d7)) / 3.0d;
            double sqrt = Math.sqrt(d5) * -2.0d;
            dArr3[0] = (Math.cos(acos) * sqrt) + d9;
            dArr3[1] = (Math.cos(acos + 2.0943951023931953d) * sqrt) + d9;
            dArr3[2] = (sqrt * Math.cos(acos - 2.0943951023931953d)) + d9;
        } else {
            double d10 = d8 - d7;
            double sqrt2 = Math.sqrt(d10) + Math.abs(d6);
            double d11 = d9;
            double pow = Math.pow(sqrt2, 0.3333333333333333d);
            if (d6 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                pow = -pow;
            }
            if (-1.0E-10d >= pow || pow >= ROOT_DELTA) {
                double d12 = pow + (d5 / pow);
                dArr3[0] = d12 + d11;
                if (-1.0E-10d < d10 && d10 < ROOT_DELTA) {
                    dArr3[1] = ((-d12) / 2.0d) + d11;
                    i = 2;
                }
            } else {
                dArr3[0] = d11;
            }
            i = 1;
        }
        return fixRoots(dArr3, i);
    }

    static int fixRoots(double[] dArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int i4 = i2 + 1;
            int i5 = i4;
            while (true) {
                if (i5 >= i) {
                    dArr[i3] = dArr[i2];
                    i3++;
                    break;
                } else if (isZero(dArr[i2] - dArr[i5])) {
                    break;
                } else {
                    i5++;
                }
            }
            i2 = i4;
        }
        return i3;
    }

    /* renamed from: org.apache.harmony.awt.gl.Crossing$QuadCurve */
    public static class QuadCurve {

        /* renamed from: Ax */
        double f5817Ax = (this.f5821ax - this.f5819Bx);

        /* renamed from: Ay */
        double f5818Ay;

        /* renamed from: Bx */
        double f5819Bx;

        /* renamed from: By */
        double f5820By;

        /* renamed from: ax */
        double f5821ax;

        /* renamed from: ay */
        double f5822ay;

        /* renamed from: bx */
        double f5823bx;

        /* renamed from: by */
        double f5824by;

        public QuadCurve(double d, double d2, double d3, double d4, double d5, double d6) {
            this.f5821ax = d5 - d;
            this.f5822ay = d6 - d2;
            this.f5823bx = d3 - d;
            this.f5824by = d4 - d2;
            double d7 = this.f5823bx;
            this.f5819Bx = d7 + d7;
            double d8 = this.f5824by;
            this.f5820By = d8 + d8;
            this.f5818Ay = this.f5822ay - this.f5820By;
        }

        /* access modifiers changed from: package-private */
        public int cross(double[] dArr, int i, double d, double d2) {
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                double d3 = dArr[i4];
                if (d3 >= -1.0E-5d && d3 <= 1.00001d) {
                    if (d3 < 1.0E-5d) {
                        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            double d4 = this.f5823bx;
                            if (d4 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                d4 = this.f5821ax - d4;
                            }
                            if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                i3--;
                            }
                        }
                    } else if (d3 > 0.99999d) {
                        if (d < this.f5822ay) {
                            double d5 = this.f5821ax;
                            double d6 = this.f5823bx;
                            if (d5 != d6) {
                                d6 = d5 - d6;
                            }
                            if (d6 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                i3++;
                            }
                        }
                    } else if (((this.f5818Ay * d3) + this.f5820By) * d3 > d2) {
                        double d7 = (d3 * this.f5817Ax) + this.f5823bx;
                        if (d7 <= -1.0E-5d || d7 >= 1.0E-5d) {
                            i3 += d7 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : -1;
                        }
                    }
                }
            }
            return i3;
        }

        /* access modifiers changed from: package-private */
        public int solvePoint(double[] dArr, double d) {
            return Crossing.solveQuad(new double[]{-d, this.f5819Bx, this.f5817Ax}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int solveExtrem(double[] dArr) {
            double d = this.f5817Ax;
            int i = 0;
            if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                dArr[0] = (-this.f5819Bx) / (d + d);
                i = 1;
            }
            double d2 = this.f5818Ay;
            if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return i;
            }
            int i2 = i + 1;
            dArr[i] = (-this.f5820By) / (d2 + d2);
            return i2;
        }

        /* access modifiers changed from: package-private */
        public int addBound(double[] dArr, int i, double[] dArr2, int i2, double d, double d2, boolean z, int i3) {
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            for (int i7 = 0; i7 < i5; i7++) {
                double d3 = dArr2[i7];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((this.f5817Ax * d3) + this.f5819Bx) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i8 = i4 + 1;
                        dArr[i4] = d3;
                        int i9 = i8 + 1;
                        dArr[i8] = d4;
                        int i10 = i9 + 1;
                        dArr[i9] = d3 * ((this.f5818Ay * d3) + this.f5820By);
                        i4 = i10 + 1;
                        dArr[i10] = (double) i6;
                        if (z) {
                            i6++;
                        }
                    }
                }
            }
            return i4;
        }
    }

    /* renamed from: org.apache.harmony.awt.gl.Crossing$CubicCurve */
    public static class CubicCurve {

        /* renamed from: Ax */
        double f5805Ax;
        double Ax3;

        /* renamed from: Ay */
        double f5806Ay;

        /* renamed from: Bx */
        double f5807Bx;
        double Bx2;

        /* renamed from: By */
        double f5808By;

        /* renamed from: Cx */
        double f5809Cx;

        /* renamed from: Cy */
        double f5810Cy;

        /* renamed from: ax */
        double f5811ax;

        /* renamed from: ay */
        double f5812ay;

        /* renamed from: bx */
        double f5813bx;

        /* renamed from: by */
        double f5814by;

        /* renamed from: cx */
        double f5815cx;

        /* renamed from: cy */
        double f5816cy;

        public CubicCurve(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
            this.f5811ax = d7 - d;
            this.f5812ay = d8 - d2;
            this.f5813bx = d3 - d;
            this.f5814by = d4 - d2;
            this.f5815cx = d5 - d;
            this.f5816cy = d6 - d2;
            double d9 = this.f5813bx;
            this.f5809Cx = d9 + d9 + d9;
            double d10 = this.f5815cx;
            double d11 = d10 + d10 + d10;
            double d12 = this.f5809Cx;
            this.f5807Bx = (d11 - d12) - d12;
            double d13 = this.f5811ax;
            double d14 = this.f5807Bx;
            this.f5805Ax = (d13 - d14) - d12;
            double d15 = this.f5814by;
            this.f5810Cy = d15 + d15 + d15;
            double d16 = this.f5816cy;
            double d17 = d16 + d16 + d16;
            double d18 = this.f5810Cy;
            this.f5808By = (d17 - d18) - d18;
            this.f5806Ay = (this.f5812ay - this.f5808By) - d18;
            double d19 = this.f5805Ax;
            this.Ax3 = d19 + d19 + d19;
            this.Bx2 = d14 + d14;
        }

        /* access modifiers changed from: package-private */
        public int cross(double[] dArr, int i, double d, double d2) {
            double d3;
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                double d4 = dArr[i4];
                if (d4 >= -1.0E-5d && d4 <= 1.00001d) {
                    if (d4 < 1.0E-5d) {
                        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                            double d5 = this.f5813bx;
                            if (d5 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                double d6 = this.f5815cx;
                                d5 = d6 != d5 ? d6 - d5 : this.f5811ax - d6;
                            }
                            if (d5 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                i3--;
                            }
                        }
                    } else if (d4 > 0.99999d) {
                        if (d < this.f5812ay) {
                            double d7 = this.f5811ax;
                            double d8 = this.f5815cx;
                            if (d7 != d8) {
                                d3 = d7 - d8;
                            } else {
                                d3 = this.f5813bx;
                                if (d8 != d3) {
                                    d3 = d8 - d3;
                                }
                            }
                            if (d3 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                i3++;
                            }
                        }
                    } else if (((((this.f5806Ay * d4) + this.f5808By) * d4) + this.f5810Cy) * d4 > d2) {
                        double d9 = this.Ax3;
                        double d10 = this.Bx2;
                        double d11 = (((d4 * d9) + d10) * d4) + this.f5809Cx;
                        if (d11 > -1.0E-5d && d11 < 1.0E-5d) {
                            double d12 = (d4 * (d9 + d9)) + d10;
                            if (d12 >= -1.0E-5d && d12 <= 1.0E-5d) {
                                d11 = this.f5811ax;
                            }
                        }
                        i3 += d11 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : -1;
                    }
                }
            }
            return i3;
        }

        /* access modifiers changed from: package-private */
        public int solvePoint(double[] dArr, double d) {
            return Crossing.solveCubic(new double[]{-d, this.f5809Cx, this.f5807Bx, this.f5805Ax}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int solveExtremX(double[] dArr) {
            return Crossing.solveQuad(new double[]{this.f5809Cx, this.Bx2, this.Ax3}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int solveExtremY(double[] dArr) {
            double d = this.f5808By;
            double d2 = this.f5806Ay;
            return Crossing.solveQuad(new double[]{this.f5810Cy, d + d, d2 + d2 + d2}, dArr);
        }

        /* access modifiers changed from: package-private */
        public int addBound(double[] dArr, int i, double[] dArr2, int i2, double d, double d2, boolean z, int i3) {
            int i4 = i;
            int i5 = i2;
            int i6 = i3;
            for (int i7 = 0; i7 < i5; i7++) {
                double d3 = dArr2[i7];
                if (d3 > -1.0E-5d && d3 < 1.00001d) {
                    double d4 = ((((this.f5805Ax * d3) + this.f5807Bx) * d3) + this.f5809Cx) * d3;
                    if (d <= d4 && d4 <= d2) {
                        int i8 = i4 + 1;
                        dArr[i4] = d3;
                        int i9 = i8 + 1;
                        dArr[i8] = d4;
                        int i10 = i9 + 1;
                        dArr[i9] = d3 * ((((this.f5806Ay * d3) + this.f5808By) * d3) + this.f5810Cy);
                        i4 = i10 + 1;
                        dArr[i10] = (double) i6;
                        if (z) {
                            i6++;
                        }
                    }
                }
            }
            return i4;
        }
    }

    public static int crossQuad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        int i;
        int i2 = (d7 > d ? 1 : (d7 == d ? 0 : -1));
        if ((i2 < 0 && d7 < d3 && d7 < d5) || ((d7 > d && d7 > d3 && d7 > d5) || ((d8 > d2 && d8 > d4 && d8 > d6) || (d == d3 && d3 == d5)))) {
            return 0;
        }
        if (d8 < d2 && d8 < d4 && d8 < d6 && i != 0 && d7 != d5) {
            return d < d5 ? (d >= d7 || d7 >= d5) ? 0 : 1 : (d5 >= d7 || i2 >= 0) ? 0 : -1;
        }
        QuadCurve quadCurve = new QuadCurve(d, d2, d3, d4, d5, d6);
        double d9 = d8 - d2;
        double[] dArr = new double[3];
        return quadCurve.cross(dArr, quadCurve.solvePoint(dArr, d7 - d), d9, d9);
    }

    public static int crossCubic(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        int i;
        int i2 = (d9 > d ? 1 : (d9 == d ? 0 : -1));
        if ((i2 < 0 && d9 < d3 && d9 < d5 && d9 < d7) || ((d9 > d && d9 > d3 && d9 > d5 && d9 > d7) || ((d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8) || (d == d3 && d3 == d5 && d5 == d7)))) {
            return 0;
        }
        if (d10 < d2 && d10 < d4 && d10 < d6 && d10 < d8 && i != 0 && d9 != d7) {
            return d < d7 ? (d >= d9 || d9 >= d7) ? 0 : 1 : (d7 >= d9 || i2 >= 0) ? 0 : -1;
        }
        CubicCurve cubicCurve = r0;
        CubicCurve cubicCurve2 = new CubicCurve(d, d2, d3, d4, d5, d6, d7, d8);
        double d11 = d10 - d2;
        double[] dArr = new double[3];
        CubicCurve cubicCurve3 = cubicCurve;
        return cubicCurve3.cross(dArr, cubicCurve3.solvePoint(dArr, d9 - d), d11, d11);
    }

    public static int crossPath(PathIterator pathIterator, double d, double d2) {
        double d3;
        double d4;
        double d5;
        double d6;
        char c;
        double[] dArr = new double[6];
        int i = 0;
        double d7 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d8 = 0.0d;
        double d9 = 0.0d;
        double d10 = 0.0d;
        int i2 = 0;
        while (true) {
            if (!pathIterator.isDone()) {
                int currentSegment = pathIterator.currentSegment(dArr);
                if (currentSegment == 0) {
                    if (d8 == d7 && d9 == d10) {
                        c = 1;
                    } else {
                        c = 1;
                        i2 += crossLine(d8, d9, d7, d10, d, d2);
                    }
                    double d11 = dArr[0];
                    d10 = dArr[c];
                    d9 = d10;
                    d8 = d11;
                    d7 = d8;
                } else if (currentSegment == 1) {
                    double d12 = dArr[0];
                    double d13 = dArr[1];
                    i2 += crossLine(d8, d9, d12, d13, d, d2);
                    d8 = d12;
                    d9 = d13;
                } else if (currentSegment == 2) {
                    double d14 = dArr[0];
                    double d15 = dArr[1];
                    double d16 = dArr[2];
                    double d17 = dArr[3];
                    i2 += crossQuad(d8, d9, d14, d15, d16, d17, d, d2);
                    d8 = d16;
                    d9 = d17;
                } else if (currentSegment == 3) {
                    double d18 = dArr[3];
                    double d19 = dArr[4];
                    double d20 = dArr[5];
                    i2 += crossCubic(d8, d9, dArr[0], dArr[1], dArr[2], d18, d19, d20, d, d2);
                    d8 = d19;
                    d9 = d20;
                } else if (currentSegment == 4 && !(d9 == d10 && d8 == d7)) {
                    i2 += crossLine(d8, d9, d7, d10, d, d2);
                    d8 = d7;
                    d9 = d10;
                }
                if (d == d8 && d2 == d9) {
                    d3 = d7;
                    d6 = d8;
                    d4 = d10;
                    d5 = d4;
                    break;
                }
                pathIterator.next();
            } else {
                d3 = d7;
                d4 = d9;
                i = i2;
                d5 = d10;
                d6 = d8;
                break;
            }
        }
        return d4 != d5 ? i + crossLine(d6, d4, d3, d5, d, d2) : i;
    }

    public static int crossShape(Shape shape, double d, double d2) {
        if (!shape.getBounds2D().contains(d, d2)) {
            return 0;
        }
        return crossPath(shape.getPathIterator((AffineTransform) null), d, d2);
    }

    static void sortBound(double[] dArr, int i) {
        int i2 = 0;
        while (i2 < i - 4) {
            int i3 = i2 + 4;
            int i4 = i2;
            for (int i5 = i3; i5 < i; i5 += 4) {
                if (dArr[i4] > dArr[i5]) {
                    i4 = i5;
                }
            }
            if (i4 != i2) {
                double d = dArr[i2];
                dArr[i2] = dArr[i4];
                dArr[i4] = d;
                int i6 = i2 + 1;
                double d2 = dArr[i6];
                int i7 = i4 + 1;
                dArr[i6] = dArr[i7];
                dArr[i7] = d2;
                int i8 = i2 + 2;
                double d3 = dArr[i8];
                int i9 = i4 + 2;
                dArr[i8] = dArr[i9];
                dArr[i9] = d3;
                int i10 = i2 + 3;
                double d4 = dArr[i10];
                int i11 = i4 + 3;
                dArr[i10] = dArr[i11];
                dArr[i11] = d4;
            }
            i2 = i3;
        }
    }

    static int crossBound(double[] dArr, int i, double d, double d2) {
        if (i == 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 2; i4 < i; i4 += 4) {
            if (dArr[i4] < d) {
                i3++;
            } else if (dArr[i4] <= d2) {
                return 255;
            } else {
                i2++;
            }
        }
        if (i2 == 0) {
            return 0;
        }
        if (i3 == 0) {
            return 254;
        }
        sortBound(dArr, i);
        boolean z = dArr[2] > d2;
        int i5 = 6;
        while (i5 < i) {
            boolean z2 = dArr[i5] > d2;
            if (z != z2 && dArr[i5 + 1] != dArr[i5 - 3]) {
                return 255;
            }
            i5 += 4;
            z = z2;
        }
        return 254;
    }

    public static int intersectQuad(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        int i;
        if ((d9 < d && d9 < d3 && d9 < d5) || ((d7 > d && d7 > d3 && d7 > d5) || (d8 > d2 && d8 > d4 && d8 > d6))) {
            return 0;
        }
        if (d10 < d2 && d10 < d4 && d10 < d6 && i != 0 && d7 != d5) {
            return d < d5 ? (d >= d7 || d7 >= d5) ? 0 : 1 : (d5 >= d7 || d7 >= d) ? 0 : -1;
        }
        QuadCurve quadCurve = new QuadCurve(d, d2, d3, d4, d5, d6);
        double d11 = d7 - d;
        double d12 = d8 - d2;
        double d13 = d9 - d;
        double d14 = d10 - d2;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        int solvePoint = quadCurve.solvePoint(dArr, d11);
        int solvePoint2 = quadCurve.solvePoint(dArr2, d13);
        if (solvePoint == 0 && solvePoint2 == 0) {
            return 0;
        }
        double d15 = d11 - 1.0E-5d;
        double[] dArr3 = new double[28];
        QuadCurve quadCurve2 = quadCurve;
        double[] dArr4 = dArr3;
        double d16 = d15;
        double d17 = d13 + 1.0E-5d;
        double[] dArr5 = dArr;
        double[] dArr6 = dArr2;
        int addBound = quadCurve2.addBound(dArr4, quadCurve2.addBound(dArr4, quadCurve2.addBound(dArr4, 0, dArr, solvePoint, d16, d17, false, 0), dArr6, solvePoint2, d16, d17, false, 1), dArr6, quadCurve.solveExtrem(dArr6), d16, d17, true, 2);
        if (d7 < d && d < d9) {
            int i2 = addBound + 1;
            dArr3[addBound] = 0.0d;
            int i3 = i2 + 1;
            dArr3[i2] = 0.0d;
            int i4 = i3 + 1;
            dArr3[i3] = 0.0d;
            addBound = i4 + 1;
            dArr3[i4] = 4.0d;
        }
        if (d7 < d5 && d5 < d9) {
            int i5 = addBound + 1;
            dArr3[addBound] = 1.0d;
            int i6 = i5 + 1;
            dArr3[i5] = quadCurve.f5821ax;
            int i7 = i6 + 1;
            dArr3[i6] = quadCurve.f5822ay;
            addBound = i7 + 1;
            dArr3[i7] = 5.0d;
        }
        int crossBound = crossBound(dArr3, addBound, d12, d14);
        if (crossBound != 254) {
            return crossBound;
        }
        return quadCurve.cross(dArr5, solvePoint, d12, d14);
    }

    public static int intersectCubic(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12) {
        int i;
        if ((d11 < d && d11 < d3 && d11 < d5 && d11 < d7) || ((d9 > d && d9 > d3 && d9 > d5 && d9 > d7) || (d10 > d2 && d10 > d4 && d10 > d6 && d10 > d8))) {
            return 0;
        }
        if (d12 < d2 && d12 < d4 && d12 < d6 && d12 < d8 && i != 0 && d9 != d7) {
            return d < d7 ? (d >= d9 || d9 >= d7) ? 0 : 1 : (d7 >= d9 || d9 >= d) ? 0 : -1;
        }
        CubicCurve cubicCurve = r0;
        CubicCurve cubicCurve2 = new CubicCurve(d, d2, d3, d4, d5, d6, d7, d8);
        double d13 = d9 - d;
        double d14 = d10 - d2;
        double d15 = d11 - d;
        double d16 = d12 - d2;
        double[] dArr = new double[3];
        double[] dArr2 = new double[3];
        CubicCurve cubicCurve3 = cubicCurve;
        int solvePoint = cubicCurve3.solvePoint(dArr, d13);
        int solvePoint2 = cubicCurve3.solvePoint(dArr2, d15);
        if (solvePoint == 0 && solvePoint2 == 0) {
            return 0;
        }
        double[] dArr3 = new double[40];
        double d17 = d13 - 1.0E-5d;
        double[] dArr4 = dArr3;
        double d18 = d15 + 1.0E-5d;
        CubicCurve cubicCurve4 = cubicCurve3;
        double[] dArr5 = dArr2;
        int addBound = cubicCurve3.addBound(dArr3, 0, dArr, solvePoint, d17, d18, false, 0);
        double[] dArr6 = dArr4;
        double[] dArr7 = dArr5;
        CubicCurve cubicCurve5 = cubicCurve4;
        double[] dArr8 = dArr;
        double[] dArr9 = dArr7;
        double d19 = d16;
        CubicCurve cubicCurve6 = cubicCurve5;
        int addBound2 = cubicCurve6.addBound(dArr6, cubicCurve5.addBound(dArr6, cubicCurve4.addBound(dArr6, addBound, dArr5, solvePoint2, d17, d18, false, 1), dArr7, cubicCurve5.solveExtremX(dArr7), d17, d18, true, 2), dArr9, cubicCurve6.solveExtremY(dArr9), d17, d18, true, 4);
        if (d9 < d && d < d11) {
            int i2 = addBound2 + 1;
            dArr4[addBound2] = 0.0d;
            int i3 = i2 + 1;
            dArr4[i2] = 0.0d;
            int i4 = i3 + 1;
            dArr4[i3] = 0.0d;
            addBound2 = i4 + 1;
            dArr4[i4] = 6.0d;
        }
        if (d9 < d7 && d7 < d11) {
            int i5 = addBound2 + 1;
            dArr4[addBound2] = 1.0d;
            int i6 = i5 + 1;
            dArr4[i5] = cubicCurve6.f5811ax;
            int i7 = i6 + 1;
            dArr4[i6] = cubicCurve6.f5812ay;
            addBound2 = i7 + 1;
            dArr4[i7] = 7.0d;
        }
        int crossBound = crossBound(dArr4, addBound2, d14, d19);
        if (crossBound != 254) {
            return crossBound;
        }
        return cubicCurve6.cross(dArr8, solvePoint, d14, d19);
    }

    public static int intersectPath(PathIterator pathIterator, double d, double d2, double d3, double d4) {
        double d5;
        int i;
        int i2;
        char c;
        int intersectLine;
        double[] dArr = new double[6];
        double d6 = d + d3;
        double d7 = d2 + d4;
        double d8 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d9 = 0.0d;
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i3 = 0;
        while (!pathIterator.isDone()) {
            int currentSegment = pathIterator.currentSegment(dArr);
            if (currentSegment == 0) {
                if (d8 == d11 && d9 == d10) {
                    intersectLine = 0;
                    c = 1;
                } else {
                    c = 1;
                    intersectLine = intersectLine(d8, d9, d11, d10, d, d2, d6, d7);
                }
                d11 = dArr[0];
                d10 = dArr[c];
                d9 = d10;
                i = 255;
                d5 = d11;
            } else if (currentSegment == 1) {
                double d12 = dArr[0];
                double d13 = dArr[1];
                i2 = intersectLine(d8, d9, d12, d13, d, d2, d6, d7);
                d9 = d13;
                d5 = d11;
                i = 255;
                d11 = d12;
            } else if (currentSegment != 2) {
                if (currentSegment == 3) {
                    double d14 = dArr[4];
                    double d15 = dArr[5];
                    i2 = intersectCubic(d8, d9, dArr[0], dArr[1], dArr[2], dArr[3], d14, d15, d, d2, d6, d7);
                    d5 = d11;
                    d11 = d14;
                    d9 = d15;
                } else if (currentSegment != 4) {
                    d5 = d11;
                    d11 = d8;
                    i2 = 0;
                } else {
                    i2 = (d9 == d10 && d8 == d11) ? 0 : intersectLine(d8, d9, d11, d10, d, d2, d6, d7);
                    d9 = d10;
                    d5 = d11;
                }
                i = 255;
            } else {
                double d16 = dArr[0];
                double d17 = dArr[1];
                double d18 = dArr[2];
                double d19 = dArr[3];
                i2 = intersectQuad(d8, d9, d16, d17, d18, d19, d, d2, d6, d7);
                d9 = d19;
                d5 = d11;
                i = 255;
                d11 = d18;
            }
            if (i2 == i) {
                return i;
            }
            i3 += i2;
            pathIterator.next();
            d8 = d11;
            d11 = d5;
        }
        if (d9 == d10) {
            return i3;
        }
        int intersectLine2 = intersectLine(d8, d9, d11, d10, d, d2, d6, d7);
        if (intersectLine2 == 255) {
            return 255;
        }
        return i3 + intersectLine2;
    }

    public static int intersectShape(Shape shape, double d, double d2, double d3, double d4) {
        if (!shape.getBounds2D().intersects(d, d2, d3, d4)) {
            return 0;
        }
        Shape shape2 = shape;
        return intersectPath(shape.getPathIterator((AffineTransform) null), d, d2, d3, d4);
    }
}
