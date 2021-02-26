package org.apache.harmony.awt.geom;

import java.util.ArrayList;
import java.util.List;

public class CurveCrossingHelper {
    private double[][] coords;
    private List<IntersectPoint> isectPoints = new ArrayList();
    private int[][] offsets;
    private int[][] rules;
    private int[] rulesSizes;
    private int[] sizes;

    public CurveCrossingHelper(double[][] dArr, int[] iArr, int[][] iArr2, int[] iArr3, int[][] iArr4) {
        this.coords = dArr;
        this.rules = iArr2;
        this.sizes = iArr;
        this.rulesSizes = iArr3;
        this.offsets = iArr4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x040d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.harmony.awt.geom.IntersectPoint[] findCrossing() {
        /*
            r50 = this;
            r6 = r50
            r0 = 8
            double[] r7 = new double[r0]
            double[] r8 = new double[r0]
            r9 = 6
            double[] r10 = new double[r9]
            double[] r15 = new double[r9]
            r13 = 2
            double[] r14 = new double[r13]
            double[] r11 = new double[r13]
            double[] r12 = new double[r13]
            double[] r5 = new double[r13]
            r4 = 0
            r3 = 0
        L_0x0018:
            int[] r0 = r6.rulesSizes
            r0 = r0[r4]
            if (r3 < r0) goto L_0x002d
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r0 = r6.isectPoints
            int r1 = r0.size()
            org.apache.harmony.awt.geom.IntersectPoint[] r1 = new org.apache.harmony.awt.geom.IntersectPoint[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            org.apache.harmony.awt.geom.IntersectPoint[] r0 = (org.apache.harmony.awt.geom.IntersectPoint[]) r0
            return r0
        L_0x002d:
            int[][] r0 = r6.rules
            r0 = r0[r4]
            r16 = r0[r3]
            r1 = 0
            r0 = r50
            r2 = r3
            r44 = r3
            r3 = r7
            r9 = 0
            r4 = r14
            r45 = r5
            r5 = r11
            r0.getCurrentEdge(r1, r2, r3, r4, r5)
            r4 = r16
            r5 = 0
        L_0x0045:
            int[] r0 = r6.rulesSizes
            r3 = 1
            r0 = r0[r3]
            if (r5 < r0) goto L_0x0053
            int r3 = r44 + 1
            r5 = r45
            r4 = 0
            r9 = 6
            goto L_0x0018
        L_0x0053:
            int[][] r0 = r6.rules
            r0 = r0[r3]
            r2 = r0[r5]
            r1 = 1
            r0 = r50
            r9 = r2
            r2 = r5
            r13 = 1
            r3 = r8
            r13 = r4
            r4 = r12
            r46 = r5
            r5 = r45
            r0.getCurrentEdge(r1, r2, r3, r4, r5)
            r0 = 4
            r1 = 3
            r2 = 1
            if (r13 == r2) goto L_0x0070
            if (r13 != r0) goto L_0x0083
        L_0x0070:
            if (r9 == r2) goto L_0x03b6
            if (r9 != r0) goto L_0x0083
            r47 = r11
            r48 = r12
            r4 = r13
            r2 = r14
            r49 = r15
            r0 = 1
            r3 = 2
            r5 = 0
            r33 = 6
            goto L_0x03c3
        L_0x0083:
            if (r13 == r2) goto L_0x0087
            if (r13 != r0) goto L_0x00e3
        L_0x0087:
            r4 = 2
            if (r9 != r4) goto L_0x00e3
            r5 = 0
            r16 = r7[r5]
            r47 = r11
            r48 = r12
            r11 = r16
            r16 = r7[r2]
            r4 = r13
            r2 = r14
            r0 = 1
            r3 = 2
            r13 = r16
            r16 = r7[r3]
            r49 = r15
            r15 = r16
            r17 = r7[r1]
            r19 = r8[r5]
            r21 = r8[r0]
            r23 = r8[r3]
            r25 = r8[r1]
            r5 = 4
            r27 = r8[r5]
            r5 = 5
            r29 = r8[r5]
            r31 = r49
            int r5 = org.apache.harmony.awt.geom.GeometryUtil.intersectLineAndQuad(r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31)
            r11 = 0
        L_0x00b8:
            if (r11 < r5) goto L_0x00bf
        L_0x00ba:
            r11 = r5
        L_0x00bb:
            r33 = 6
            goto L_0x03f3
        L_0x00bf:
            int r12 = r11 * 2
            r13 = r49[r12]
            r15 = 0
            r16 = r7[r15]
            r18 = r7[r3]
            r15 = r16
            r17 = r18
            double r13 = org.apache.harmony.awt.geom.GeometryUtil.line(r13, r15, r17)
            r10[r12] = r13
            int r13 = r12 + 1
            r14 = r49[r12]
            r16 = r7[r0]
            r18 = r7[r1]
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.line(r14, r16, r18)
            r10[r13] = r14
            int r11 = r11 + 1
            goto L_0x00b8
        L_0x00e3:
            r47 = r11
            r48 = r12
            r4 = r13
            r2 = r14
            r49 = r15
            r0 = 1
            r3 = 2
            if (r4 != r3) goto L_0x013a
            if (r9 == r0) goto L_0x00f4
            r5 = 4
            if (r9 != r5) goto L_0x013a
        L_0x00f4:
            r5 = 0
            r11 = r8[r5]
            r13 = r8[r0]
            r15 = r8[r3]
            r17 = r8[r1]
            r19 = r7[r5]
            r21 = r7[r0]
            r23 = r7[r3]
            r25 = r7[r1]
            r5 = 4
            r27 = r7[r5]
            r5 = 5
            r29 = r7[r5]
            r31 = r49
            int r5 = org.apache.harmony.awt.geom.GeometryUtil.intersectLineAndQuad(r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31)
            r11 = 0
        L_0x0112:
            if (r11 < r5) goto L_0x0115
            goto L_0x00ba
        L_0x0115:
            int r12 = r11 * 2
            int r13 = r12 + 1
            r14 = r49[r13]
            r16 = 0
            r17 = r8[r16]
            r19 = r8[r3]
            r16 = r17
            r18 = r19
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.line(r14, r16, r18)
            r10[r12] = r14
            r16 = r49[r13]
            r18 = r8[r0]
            r20 = r8[r1]
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.line(r16, r18, r20)
            r10[r13] = r14
            int r11 = r11 + 1
            goto L_0x0112
        L_0x013a:
            r5 = 7
            if (r4 != r1) goto L_0x0197
            if (r9 == r0) goto L_0x0142
            r11 = 4
            if (r9 != r11) goto L_0x0197
        L_0x0142:
            r11 = 0
            r12 = r7[r11]
            r11 = r12
            r13 = r7[r0]
            r15 = r7[r3]
            r17 = r7[r1]
            r19 = 4
            r20 = r7[r19]
            r19 = r20
            r21 = 5
            r21 = r7[r21]
            r23 = 6
            r24 = r7[r23]
            r23 = r24
            r25 = r7[r5]
            r5 = 0
            r27 = r8[r5]
            r29 = r8[r0]
            r31 = r8[r3]
            r33 = r8[r1]
            r35 = r49
            int r11 = org.apache.harmony.awt.geom.GeometryUtil.intersectLineAndCubic(r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35)
            r5 = 0
        L_0x016e:
            if (r5 < r11) goto L_0x0172
        L_0x0170:
            goto L_0x00bb
        L_0x0172:
            int r12 = r5 * 2
            int r13 = r12 + 1
            r14 = r49[r13]
            r16 = 0
            r17 = r8[r16]
            r19 = r8[r3]
            r16 = r17
            r18 = r19
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.line(r14, r16, r18)
            r10[r12] = r14
            r16 = r49[r13]
            r18 = r8[r0]
            r20 = r8[r1]
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.line(r16, r18, r20)
            r10[r13] = r14
            int r5 = r5 + 1
            goto L_0x016e
        L_0x0197:
            if (r4 == r0) goto L_0x019c
            r11 = 4
            if (r4 != r11) goto L_0x01f2
        L_0x019c:
            if (r9 != r1) goto L_0x01f2
            r19 = 0
            r11 = r7[r19]
            r13 = r7[r0]
            r15 = r7[r3]
            r17 = r7[r1]
            r20 = r8[r19]
            r19 = r20
            r21 = r8[r0]
            r23 = r8[r3]
            r25 = r8[r1]
            r27 = 4
            r28 = r8[r27]
            r27 = r28
            r29 = 5
            r29 = r8[r29]
            r31 = 6
            r32 = r8[r31]
            r31 = r32
            r33 = r8[r5]
            r35 = r49
            int r11 = org.apache.harmony.awt.geom.GeometryUtil.intersectLineAndCubic(r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35)
            r5 = 0
        L_0x01cb:
            if (r5 < r11) goto L_0x01ce
        L_0x01cd:
            goto L_0x0170
        L_0x01ce:
            int r12 = r5 * 2
            r13 = r49[r12]
            r15 = 0
            r16 = r7[r15]
            r18 = r7[r3]
            r15 = r16
            r17 = r18
            double r13 = org.apache.harmony.awt.geom.GeometryUtil.line(r13, r15, r17)
            r10[r12] = r13
            int r13 = r12 + 1
            r14 = r49[r12]
            r16 = r7[r0]
            r18 = r7[r1]
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.line(r14, r16, r18)
            r10[r13] = r14
            int r5 = r5 + 1
            goto L_0x01cb
        L_0x01f2:
            if (r4 != r3) goto L_0x024b
            if (r9 != r3) goto L_0x024b
            r11 = 0
            r12 = r7[r11]
            r11 = r12
            r13 = r7[r0]
            r15 = r7[r3]
            r17 = r7[r1]
            r5 = 4
            r19 = r7[r5]
            r5 = 5
            r21 = r7[r5]
            r5 = 0
            r23 = r8[r5]
            r25 = r8[r0]
            r27 = r8[r3]
            r29 = r8[r1]
            r5 = 4
            r31 = r8[r5]
            r5 = 5
            r33 = r8[r5]
            r35 = r49
            int r11 = org.apache.harmony.awt.geom.GeometryUtil.intersectQuads(r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35)
            r5 = 0
        L_0x021c:
            if (r5 < r11) goto L_0x021f
            goto L_0x01cd
        L_0x021f:
            int r12 = r5 * 2
            r13 = r49[r12]
            r15 = 0
            r16 = r7[r15]
            r18 = r7[r3]
            r15 = 4
            r20 = r7[r15]
            r15 = r16
            r17 = r18
            r19 = r20
            double r13 = org.apache.harmony.awt.geom.GeometryUtil.quad(r13, r15, r17, r19)
            r10[r12] = r13
            int r13 = r12 + 1
            r14 = r49[r12]
            r16 = r7[r0]
            r18 = r7[r1]
            r12 = 5
            r20 = r7[r12]
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.quad(r14, r16, r18, r20)
            r10[r13] = r14
            int r5 = r5 + 1
            goto L_0x021c
        L_0x024b:
            if (r4 != r3) goto L_0x02bc
            if (r9 != r1) goto L_0x02bc
            r11 = 0
            r12 = r7[r11]
            r11 = r12
            r13 = r7[r0]
            r15 = r7[r3]
            r17 = r7[r1]
            r19 = 4
            r20 = r7[r19]
            r19 = r20
            r21 = 5
            r22 = r7[r21]
            r21 = r22
            r23 = 0
            r24 = r8[r23]
            r23 = r24
            r25 = r8[r0]
            r27 = r8[r3]
            r29 = r8[r1]
            r31 = 4
            r32 = r8[r31]
            r31 = r32
            r33 = 5
            r34 = r8[r33]
            r33 = r34
            r35 = 6
            r36 = r8[r35]
            r35 = r36
            r37 = r8[r5]
            r39 = r49
            int r11 = org.apache.harmony.awt.geom.GeometryUtil.intersectQuadAndCubic(r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39)
            r5 = 0
        L_0x028c:
            if (r5 < r11) goto L_0x0290
            goto L_0x0170
        L_0x0290:
            int r12 = r5 * 2
            r13 = r49[r12]
            r15 = 0
            r16 = r7[r15]
            r18 = r7[r3]
            r15 = 4
            r20 = r7[r15]
            r15 = r16
            r17 = r18
            r19 = r20
            double r13 = org.apache.harmony.awt.geom.GeometryUtil.quad(r13, r15, r17, r19)
            r10[r12] = r13
            int r13 = r12 + 1
            r14 = r49[r12]
            r16 = r7[r0]
            r18 = r7[r1]
            r12 = 5
            r20 = r7[r12]
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.quad(r14, r16, r18, r20)
            r10[r13] = r14
            int r5 = r5 + 1
            goto L_0x028c
        L_0x02bc:
            if (r4 != r1) goto L_0x032f
            if (r9 != r3) goto L_0x032f
            r11 = 0
            r12 = r8[r11]
            r11 = r12
            r13 = r8[r0]
            r15 = r8[r3]
            r17 = r8[r1]
            r19 = 4
            r20 = r8[r19]
            r19 = r20
            r21 = 5
            r22 = r8[r21]
            r21 = r22
            r23 = 0
            r24 = r7[r23]
            r23 = r24
            r25 = r7[r0]
            r27 = r7[r3]
            r29 = r7[r1]
            r31 = 4
            r32 = r7[r31]
            r31 = r32
            r33 = 5
            r34 = r7[r33]
            r33 = r34
            r35 = 6
            r36 = r8[r35]
            r35 = r36
            r37 = r8[r5]
            r39 = r49
            int r11 = org.apache.harmony.awt.geom.GeometryUtil.intersectQuadAndCubic(r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39)
            r5 = 0
        L_0x02fd:
            if (r5 < r11) goto L_0x0301
            goto L_0x0170
        L_0x0301:
            int r12 = r5 * 2
            int r13 = r12 + 1
            r14 = r49[r13]
            r16 = 0
            r17 = r8[r16]
            r19 = r8[r3]
            r16 = 4
            r21 = r8[r16]
            r16 = r17
            r18 = r19
            r20 = r21
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.quad(r14, r16, r18, r20)
            r10[r12] = r14
            r16 = r49[r13]
            r18 = r8[r0]
            r20 = r8[r1]
            r12 = 5
            r22 = r8[r12]
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.quad(r16, r18, r20, r22)
            r10[r13] = r14
            int r5 = r5 + 1
            goto L_0x02fd
        L_0x032f:
            if (r4 != r1) goto L_0x03b2
            if (r9 != r1) goto L_0x03b2
            r11 = 0
            r12 = r7[r11]
            r11 = r12
            r13 = r7[r0]
            r15 = r7[r3]
            r17 = r7[r1]
            r19 = 4
            r20 = r7[r19]
            r19 = r20
            r21 = 5
            r22 = r7[r21]
            r21 = r22
            r23 = 6
            r24 = r7[r23]
            r23 = r24
            r25 = r7[r5]
            r27 = 0
            r28 = r8[r27]
            r27 = r28
            r29 = r8[r0]
            r31 = r8[r3]
            r33 = r8[r1]
            r35 = 4
            r36 = r8[r35]
            r35 = r36
            r37 = 5
            r38 = r8[r37]
            r37 = r38
            r39 = 6
            r40 = r8[r39]
            r39 = r40
            r41 = r8[r5]
            r43 = r49
            int r11 = org.apache.harmony.awt.geom.GeometryUtil.intersectCubics(r11, r13, r15, r17, r19, r21, r23, r25, r27, r29, r31, r33, r35, r37, r39, r41, r43)
            r12 = 0
        L_0x0378:
            if (r12 < r11) goto L_0x037c
            goto L_0x01cd
        L_0x037c:
            int r13 = r12 * 2
            r14 = r49[r13]
            r16 = 0
            r17 = r7[r16]
            r19 = r7[r3]
            r16 = 4
            r21 = r7[r16]
            r33 = 6
            r23 = r7[r33]
            r16 = r17
            r18 = r19
            r20 = r21
            r22 = r23
            double r14 = org.apache.harmony.awt.geom.GeometryUtil.cubic(r14, r16, r18, r20, r22)
            r10[r13] = r14
            int r14 = r13 + 1
            r15 = r49[r13]
            r17 = r7[r0]
            r19 = r7[r1]
            r13 = 5
            r21 = r7[r13]
            r23 = r7[r5]
            double r15 = org.apache.harmony.awt.geom.GeometryUtil.cubic(r15, r17, r19, r21, r23)
            r10[r14] = r15
            int r12 = r12 + 1
            goto L_0x0378
        L_0x03b2:
            r33 = 6
            r11 = 0
            goto L_0x03f3
        L_0x03b6:
            r47 = r11
            r48 = r12
            r4 = r13
            r2 = r14
            r49 = r15
            r0 = 1
            r3 = 2
            r33 = 6
            r5 = 0
        L_0x03c3:
            r11 = r7[r5]
            r13 = r7[r0]
            r15 = r7[r3]
            r17 = r7[r1]
            r19 = r8[r5]
            r21 = r8[r0]
            r23 = r8[r3]
            r25 = r8[r1]
            r27 = r49
            int r11 = org.apache.harmony.awt.geom.GeometryUtil.intersectLinesWithParams(r11, r13, r15, r17, r19, r21, r23, r25, r27)
            if (r11 == 0) goto L_0x03f3
            r12 = r49[r5]
            r14 = r7[r5]
            r16 = r7[r3]
            double r12 = org.apache.harmony.awt.geom.GeometryUtil.line(r12, r14, r16)
            r10[r5] = r12
            r14 = r49[r5]
            r16 = r7[r0]
            r18 = r7[r1]
            double r12 = org.apache.harmony.awt.geom.GeometryUtil.line(r14, r16, r18)
            r10[r0] = r12
        L_0x03f3:
            int r1 = r44 + -1
            int r5 = r46 + -1
            r13 = r1
            r14 = r5
            r5 = r44
            r12 = r46
            r1 = 0
        L_0x03fe:
            if (r1 < r11) goto L_0x040d
            int r5 = r46 + 1
            r14 = r2
            r11 = r47
            r12 = r48
            r15 = r49
            r9 = 0
            r13 = 2
            goto L_0x0045
        L_0x040d:
            int r15 = r1 * 2
            r35 = r1
            r0 = r10[r15]
            int r17 = r15 + 1
            r16 = r4
            r3 = r10[r17]
            boolean r0 = r6.containsPoint(r0, r3)
            if (r0 != 0) goto L_0x04f2
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r0 = r6.isectPoints
            java.util.Iterator r0 = r0.iterator()
        L_0x0425:
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x045a
            r4 = r16
            r1 = 4
            if (r4 != r1) goto L_0x0431
            r4 = 1
        L_0x0431:
            if (r9 != r1) goto L_0x0434
            r9 = 1
        L_0x0434:
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r0 = r6.isectPoints
            org.apache.harmony.awt.geom.IntersectPoint r3 = new org.apache.harmony.awt.geom.IntersectPoint
            r16 = r3
            r25 = r10[r15]
            r27 = r10[r17]
            r29 = r49[r15]
            r31 = r49[r17]
            r17 = r13
            r18 = r5
            r19 = r4
            r20 = r44
            r21 = r14
            r22 = r12
            r23 = r9
            r24 = r46
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r27, r29, r31)
            r0.add(r3)
            goto L_0x04f4
        L_0x045a:
            r4 = r16
            r1 = 4
            java.lang.Object r3 = r0.next()
            org.apache.harmony.awt.geom.IntersectPoint r3 = (org.apache.harmony.awt.geom.IntersectPoint) r3
            r16 = r0
            r1 = 1
            int r0 = r3.getBegIndex(r1)
            if (r13 != r0) goto L_0x04a3
            int r0 = r3.getEndIndex(r1)
            if (r5 != r0) goto L_0x04a3
            double r18 = r3.getParam(r1)
            r20 = r49[r15]
            int r0 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x0490
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r0 = r6.isectPoints
            int r0 = r0.indexOf(r3)
            int r0 = r0 + r1
            int r5 = -r0
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r0 = r6.isectPoints
            int r0 = r0.size()
            int r0 = r0 + r1
            int r0 = -r0
            r3.setBegIndex1(r0)
            goto L_0x04a3
        L_0x0490:
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r0 = r6.isectPoints
            int r0 = r0.indexOf(r3)
            int r0 = r0 + r1
            int r13 = -r0
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r0 = r6.isectPoints
            int r0 = r0.size()
            int r0 = r0 + r1
            int r0 = -r0
            r3.setEndIndex1(r0)
        L_0x04a3:
            r0 = 0
            int r1 = r3.getBegIndex(r0)
            if (r14 != r1) goto L_0x04ea
            int r1 = r3.getEndIndex(r0)
            if (r12 != r1) goto L_0x04ea
            double r18 = r3.getParam(r0)
            r20 = r49[r17]
            int r1 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r1 <= 0) goto L_0x04d2
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r1 = r6.isectPoints
            int r1 = r1.indexOf(r3)
            r18 = 1
            int r1 = r1 + 1
            int r12 = -r1
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r1 = r6.isectPoints
            int r1 = r1.size()
            int r1 = r1 + 1
            int r1 = -r1
            r3.setBegIndex2(r1)
            goto L_0x04ec
        L_0x04d2:
            r18 = 1
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r1 = r6.isectPoints
            int r1 = r1.indexOf(r3)
            int r1 = r1 + 1
            int r14 = -r1
            java.util.List<org.apache.harmony.awt.geom.IntersectPoint> r1 = r6.isectPoints
            int r1 = r1.size()
            int r1 = r1 + 1
            int r1 = -r1
            r3.setEndIndex2(r1)
            goto L_0x04ec
        L_0x04ea:
            r18 = 1
        L_0x04ec:
            r0 = r16
            r16 = r4
            goto L_0x0425
        L_0x04f2:
            r4 = r16
        L_0x04f4:
            r0 = 0
            r18 = 1
            int r1 = r35 + 1
            r0 = 1
            r3 = 2
            goto L_0x03fe
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.harmony.awt.geom.CurveCrossingHelper.findCrossing():org.apache.harmony.awt.geom.IntersectPoint[]");
    }

    private int getCurrentEdge(int i, int i2, double[] dArr, double[] dArr2, double[] dArr3) {
        int i3 = this.rules[i][i2];
        int i4 = 0;
        if (i3 == 0) {
            double[][] dArr4 = this.coords;
            double[] dArr5 = dArr4[i];
            int[][] iArr = this.offsets;
            double d = dArr5[iArr[i][i2]];
            dArr2[0] = d;
            dArr3[0] = d;
            double d2 = dArr4[i][iArr[i][i2] + 1];
            dArr2[1] = d2;
            dArr3[1] = d2;
        } else if (i3 == 1) {
            dArr[0] = dArr3[0];
            dArr[1] = dArr3[1];
            double[][] dArr6 = this.coords;
            double[] dArr7 = dArr6[i];
            int[][] iArr2 = this.offsets;
            double d3 = dArr7[iArr2[i][i2]];
            dArr[2] = d3;
            dArr3[0] = d3;
            double d4 = dArr6[i][iArr2[i][i2] + 1];
            dArr[3] = d4;
            dArr3[1] = d4;
        } else if (i3 == 2) {
            dArr[0] = dArr3[0];
            dArr[1] = dArr3[1];
            double[][] dArr8 = this.coords;
            double[] dArr9 = dArr8[i];
            int[][] iArr3 = this.offsets;
            dArr[2] = dArr9[iArr3[i][i2]];
            dArr[3] = dArr8[i][iArr3[i][i2] + 1];
            double d5 = dArr8[i][iArr3[i][i2] + 2];
            dArr[4] = d5;
            dArr3[0] = d5;
            double d6 = dArr8[i][iArr3[i][i2] + 3];
            dArr[5] = d6;
            dArr3[1] = d6;
            i4 = 2;
        } else if (i3 == 3) {
            dArr[0] = dArr3[0];
            dArr[1] = dArr3[1];
            double[][] dArr10 = this.coords;
            double[] dArr11 = dArr10[i];
            int[][] iArr4 = this.offsets;
            dArr[2] = dArr11[iArr4[i][i2]];
            dArr[3] = dArr10[i][iArr4[i][i2] + 1];
            dArr[4] = dArr10[i][iArr4[i][i2] + 2];
            dArr[5] = dArr10[i][iArr4[i][i2] + 3];
            double d7 = dArr10[i][iArr4[i][i2] + 4];
            dArr[6] = d7;
            dArr3[0] = d7;
            double d8 = dArr10[i][iArr4[i][i2] + 5];
            dArr[7] = d8;
            dArr3[1] = d8;
            i4 = 4;
        } else if (i3 == 4) {
            dArr[0] = dArr3[0];
            dArr[1] = dArr3[1];
            double d9 = dArr2[0];
            dArr[2] = d9;
            dArr3[0] = d9;
            double d10 = dArr2[1];
            dArr[3] = d10;
            dArr3[1] = d10;
            int i5 = this.offsets[i][i2];
            int[] iArr5 = this.sizes;
            if (i5 >= iArr5[i]) {
                i4 = -iArr5[i];
            }
        }
        return this.offsets[i][i2] + i4;
    }

    private boolean containsPoint(double d, double d2) {
        for (IntersectPoint next : this.isectPoints) {
            if (Math.abs(next.getX() - d) < Math.pow(10.0d, -6.0d) && Math.abs(next.getY() - d2) < Math.pow(10.0d, -6.0d)) {
                return true;
            }
        }
        return false;
    }
}
