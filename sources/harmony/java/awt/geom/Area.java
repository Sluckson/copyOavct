package harmony.java.awt.geom;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import harmony.java.awt.Rectangle;
import harmony.java.awt.Shape;
import harmony.java.awt.geom.Rectangle2D;
import org.apache.harmony.awt.geom.CrossingHelper;
import org.apache.harmony.awt.geom.CurveCrossingHelper;
import org.apache.harmony.awt.geom.GeometryUtil;
import org.apache.harmony.awt.geom.IntersectPoint;
import org.apache.harmony.awt.p062gl.Crossing;

public class Area implements Shape, Cloneable {
    /* access modifiers changed from: private */
    public double[] coords = new double[20];
    private int coordsSize = 0;
    private boolean isPolygonal = true;
    private int moveToCount = 0;
    private int[] offsets = new int[10];
    /* access modifiers changed from: private */
    public int[] rules = new int[10];
    /* access modifiers changed from: private */
    public int rulesSize = 0;

    public Area() {
    }

    public Area(Shape shape) {
        double[] dArr = new double[6];
        PathIterator pathIterator = shape.getPathIterator((AffineTransform) null);
        double d = 0.0d;
        double d2 = 0.0d;
        int i = 0;
        int i2 = 0;
        while (!pathIterator.isDone()) {
            int i3 = i + 6;
            this.coords = adjustSize(this.coords, i3);
            int i4 = i2 + 1;
            this.rules = adjustSize(this.rules, i4);
            this.offsets = adjustSize(this.offsets, i4);
            this.rules[i2] = pathIterator.currentSegment(dArr);
            this.offsets[i2] = i;
            int i5 = this.rules[i2];
            if (i5 == 0) {
                double[] dArr2 = this.coords;
                int i6 = i + 1;
                dArr2[i] = dArr[0];
                i = i6 + 1;
                dArr2[i6] = dArr[1];
                d = dArr[0];
                d2 = dArr[1];
                this.moveToCount++;
            } else if (i5 != 1) {
                if (i5 == 2) {
                    System.arraycopy(dArr, 0, this.coords, i, 4);
                    i += 4;
                    this.isPolygonal = false;
                } else if (i5 == 3) {
                    System.arraycopy(dArr, 0, this.coords, i, 6);
                    this.isPolygonal = false;
                    i = i3;
                }
            } else if (dArr[0] == d && dArr[1] == d2) {
                i2--;
            } else {
                double[] dArr3 = this.coords;
                int i7 = i + 1;
                dArr3[i] = dArr[0];
                i = i7 + 1;
                dArr3[i7] = dArr[1];
            }
            i2++;
            pathIterator.next();
        }
        if (i2 != 0) {
            int[] iArr = this.rules;
            if (iArr[i2 - 1] != 4) {
                iArr[i2] = 4;
                this.offsets[i2] = this.coordsSize;
            }
        }
        this.rulesSize = i2;
        this.coordsSize = i;
    }

    public boolean contains(double d, double d2) {
        return !isEmpty() && containsExact(d, d2) > 0;
    }

    public boolean contains(double d, double d2, double d3, double d4) {
        int intersectPath = Crossing.intersectPath(getPathIterator((AffineTransform) null), d, d2, d3, d4);
        return intersectPath != 255 && Crossing.isInsideEvenOdd(intersectPath);
    }

    public boolean contains(Point2D point2D) {
        return contains(point2D.getX(), point2D.getY());
    }

    public boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public boolean equals(Area area) {
        if (this == area) {
            return true;
        }
        if (area == null) {
            return false;
        }
        Area area2 = (Area) clone();
        area2.subtract(area);
        return area2.isEmpty();
    }

    public boolean intersects(double d, double d2, double d3, double d4) {
        if (d3 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d4 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || !getBounds2D().intersects(d, d2, d3, d4)) {
            return false;
        }
        return Crossing.isInsideEvenOdd(Crossing.intersectShape(this, d, d2, d3, d4));
    }

    public boolean intersects(Rectangle2D rectangle2D) {
        return intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public Rectangle getBounds() {
        return getBounds2D().getBounds();
    }

    public Rectangle2D getBounds2D() {
        double[] dArr = this.coords;
        int i = 0;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[0];
        double d4 = dArr[1];
        double d5 = d3;
        double d6 = d2;
        double d7 = d;
        while (i < this.coordsSize) {
            d5 = Math.min(d5, this.coords[i]);
            int i2 = i + 1;
            d7 = Math.max(d7, this.coords[i]);
            d4 = Math.min(d4, this.coords[i2]);
            i = i2 + 1;
            d6 = Math.max(d6, this.coords[i2]);
        }
        return new Rectangle2D.Double(d5, d4, d7 - d5, d6 - d4);
    }

    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new AreaPathIterator(this, affineTransform);
    }

    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new FlatteningPathIterator(getPathIterator(affineTransform), d);
    }

    public boolean isEmpty() {
        return this.rulesSize == 0 && this.coordsSize == 0;
    }

    public boolean isPolygonal() {
        return this.isPolygonal;
    }

    public boolean isRectangular() {
        if (this.isPolygonal && this.rulesSize <= 5 && this.coordsSize <= 8) {
            double[] dArr = this.coords;
            return dArr[1] == dArr[3] && dArr[7] == dArr[5] && dArr[0] == dArr[6] && dArr[2] == dArr[4];
        }
    }

    public boolean isSingular() {
        return this.moveToCount <= 1;
    }

    public void reset() {
        this.coordsSize = 0;
        this.rulesSize = 0;
    }

    public void transform(AffineTransform affineTransform) {
        copy(new Area(affineTransform.createTransformedShape(this)), this);
    }

    public Area createTransformedArea(AffineTransform affineTransform) {
        return new Area(affineTransform.createTransformedShape(this));
    }

    public Object clone() {
        Area area = new Area();
        copy(this, area);
        return area;
    }

    public void add(Area area) {
        if (area != null && !area.isEmpty()) {
            if (isEmpty()) {
                copy(area, this);
                return;
            }
            if (!isPolygonal() || !area.isPolygonal()) {
                addCurvePolygon(area);
            } else {
                addPolygon(area);
            }
            if (getAreaBoundsSquare() < GeometryUtil.EPSILON) {
                reset();
            }
        }
    }

    public void intersect(Area area) {
        if (area != null) {
            if (isEmpty() || area.isEmpty()) {
                reset();
                return;
            }
            if (!isPolygonal() || !area.isPolygonal()) {
                intersectCurvePolygon(area);
            } else {
                intersectPolygon(area);
            }
            if (getAreaBoundsSquare() < GeometryUtil.EPSILON) {
                reset();
            }
        }
    }

    public void subtract(Area area) {
        if (area != null && !isEmpty() && !area.isEmpty()) {
            if (!isPolygonal() || !area.isPolygonal()) {
                subtractCurvePolygon(area);
            } else {
                subtractPolygon(area);
            }
            if (getAreaBoundsSquare() < GeometryUtil.EPSILON) {
                reset();
            }
        }
    }

    public void exclusiveOr(Area area) {
        Area area2 = (Area) clone();
        area2.intersect(area);
        add(area);
        subtract(area2);
    }

    private void addCurvePolygon(Area area) {
        boolean z;
        char c;
        IntersectPoint[] intersectPointArr;
        double[] dArr;
        int[] iArr;
        int[] iArr2;
        IntersectPoint intersectPoint;
        boolean z2;
        IntersectPoint intersectPoint2;
        int i;
        boolean z3;
        Area area2 = this;
        Area area3 = area;
        boolean z4 = true;
        IntersectPoint[] findCrossing = new CurveCrossingHelper(new double[][]{area2.coords, area3.coords}, new int[]{area2.coordsSize, area3.coordsSize}, new int[][]{area2.rules, area3.rules}, new int[]{area2.rulesSize, area3.rulesSize}, new int[][]{area2.offsets, area3.offsets}).findCrossing();
        if (findCrossing.length != 0) {
            double[] dArr2 = new double[(area2.coordsSize + area3.coordsSize + findCrossing.length)];
            int i2 = area2.rulesSize;
            int i3 = area3.rulesSize;
            int[] iArr3 = new int[(i2 + i3 + findCrossing.length)];
            int[] iArr4 = new int[(i2 + i3 + findCrossing.length)];
            IntersectPoint intersectPoint3 = findCrossing[0];
            iArr3[0] = 0;
            iArr4[0] = 0;
            IntersectPoint intersectPoint4 = intersectPoint3;
            int i4 = 0;
            boolean z5 = true;
            int i5 = 1;
            while (true) {
                int i6 = i4 + 1;
                dArr2[i4] = intersectPoint4.getX();
                int i7 = i6 + 1;
                dArr2[i6] = intersectPoint4.getY();
                int endIndex = intersectPoint4.getEndIndex(z4);
                if (endIndex < 0) {
                    z = !z5;
                } else {
                    double[] dArr3 = area2.coords;
                    int i8 = endIndex * 2;
                    z = area3.containsExact(dArr3[i8], dArr3[i8 + (z4 ? 1 : 0)]) <= 0;
                }
                IntersectPoint nextIntersectPoint = area2.getNextIntersectPoint(findCrossing, intersectPoint4, z);
                double[] dArr4 = z ? area2.coords : area3.coords;
                int[] iArr5 = z ? area2.offsets : area3.offsets;
                int[] iArr6 = z ? area2.rules : area3.rules;
                int ruleIndex = intersectPoint4.getRuleIndex(z);
                if (intersectPoint4.getRuleIndex(z) > nextIntersectPoint.getRuleIndex(z)) {
                    int i9 = z ? area2.rulesSize : area3.rulesSize;
                    boolean z6 = z;
                    intersectPoint = intersectPoint4;
                    iArr2 = iArr4;
                    iArr = iArr3;
                    dArr = dArr2;
                    intersectPointArr = findCrossing;
                    c = 0;
                    i5 += (i9 - ruleIndex) - 1;
                    i = includeCoordsAndRules(ruleIndex + 1, i9, iArr6, iArr5, iArr3, iArr4, dArr2, dArr4, i5, i7, intersectPoint, z6, false, 0);
                    intersectPoint2 = nextIntersectPoint;
                    z2 = z6;
                    z3 = true;
                    ruleIndex = 1;
                } else {
                    intersectPoint = intersectPoint4;
                    iArr2 = iArr4;
                    iArr = iArr3;
                    dArr = dArr2;
                    intersectPointArr = findCrossing;
                    c = 0;
                    intersectPoint2 = nextIntersectPoint;
                    z2 = z;
                    i = i7;
                    z3 = false;
                }
                int ruleIndex2 = (intersectPoint2.getRuleIndex(z2) - ruleIndex) + 1;
                if (z3) {
                    ruleIndex = 0;
                }
                IntersectPoint intersectPoint5 = intersectPoint2;
                boolean z7 = z2;
                i4 = includeCoordsAndRules(ruleIndex, ruleIndex2, iArr6, iArr5, iArr, iArr2, dArr, dArr4, i5, i, intersectPoint, z2, true, 0);
                i5 += ruleIndex2 - ruleIndex;
                if (intersectPoint5 == intersectPointArr[c]) {
                    int i10 = i5 + 1;
                    int[] iArr7 = iArr;
                    iArr7[i5] = 4;
                    int[] iArr8 = iArr2;
                    iArr8[i10 - 1] = i4;
                    this.coords = dArr;
                    this.rules = iArr7;
                    this.offsets = iArr8;
                    this.coordsSize = i4;
                    this.rulesSize = i10;
                    return;
                }
                IntersectPoint intersectPoint6 = intersectPoint5;
                area2 = this;
                area3 = area;
                intersectPoint4 = intersectPoint6;
                z5 = z7;
                iArr4 = iArr2;
                iArr3 = iArr;
                dArr2 = dArr;
                findCrossing = intersectPointArr;
                z4 = true;
            }
        } else if (area3.contains(getBounds2D())) {
            area2.copy(area3, area2);
        } else if (!area2.contains(area.getBounds2D())) {
            area2.coords = adjustSize(area2.coords, area2.coordsSize + area3.coordsSize);
            System.arraycopy(area3.coords, 0, area2.coords, area2.coordsSize, area3.coordsSize);
            area2.coordsSize += area3.coordsSize;
            area2.rules = adjustSize(area2.rules, area2.rulesSize + area3.rulesSize);
            System.arraycopy(area3.rules, 0, area2.rules, area2.rulesSize, area3.rulesSize);
            area2.rulesSize += area3.rulesSize;
            area2.offsets = adjustSize(area2.offsets, area2.rulesSize + area3.rulesSize);
            System.arraycopy(area3.offsets, 0, area2.offsets, area2.rulesSize, area3.rulesSize);
        }
    }

    private void addPolygon(Area area) {
        Area area2 = area;
        IntersectPoint[] findCrossing = new CrossingHelper(new double[][]{this.coords, area2.coords}, new int[]{this.coordsSize, area2.coordsSize}).findCrossing();
        if (findCrossing.length != 0) {
            double[] dArr = new double[(this.coordsSize + area2.coordsSize + findCrossing.length)];
            int i = this.rulesSize;
            int i2 = area2.rulesSize;
            int[] iArr = new int[(i + i2 + findCrossing.length)];
            int[] iArr2 = new int[(i + i2 + findCrossing.length)];
            IntersectPoint intersectPoint = findCrossing[0];
            iArr[0] = 0;
            iArr2[0] = 0;
            IntersectPoint intersectPoint2 = intersectPoint;
            int i3 = 0;
            int i4 = 1;
            boolean z = true;
            while (true) {
                int i5 = i3 + 1;
                dArr[i3] = intersectPoint2.getX();
                i3 = i5 + 1;
                dArr[i5] = intersectPoint2.getY();
                iArr[i4] = 1;
                int i6 = i4 + 1;
                iArr2[i4] = i3 - 2;
                int endIndex = intersectPoint2.getEndIndex(true);
                if (endIndex < 0) {
                    z = !z;
                } else {
                    double[] dArr2 = this.coords;
                    int i7 = endIndex * 2;
                    z = area2.containsExact(dArr2[i7], dArr2[i7 + 1]) <= 0;
                }
                IntersectPoint nextIntersectPoint = getNextIntersectPoint(findCrossing, intersectPoint2, z);
                double[] dArr3 = z ? this.coords : area2.coords;
                int endIndex2 = intersectPoint2.getEndIndex(z) * 2;
                if (endIndex2 >= 0 && nextIntersectPoint.getBegIndex(z) < intersectPoint2.getEndIndex(z)) {
                    int i8 = (z ? this.coordsSize : area2.coordsSize) - endIndex2;
                    System.arraycopy(dArr3, endIndex2, dArr, i3, i8);
                    int i9 = i3;
                    int i10 = 0;
                    while (i10 < i8 / 2) {
                        iArr[i6] = 1;
                        iArr2[i6] = i9;
                        i9 += 2;
                        i10++;
                        i6++;
                    }
                    i3 = i9;
                    endIndex2 = 0;
                }
                if (endIndex2 >= 0) {
                    int begIndex = ((nextIntersectPoint.getBegIndex(z) * 2) - endIndex2) + 2;
                    System.arraycopy(dArr3, endIndex2, dArr, i3, begIndex);
                    int i11 = i3;
                    int i12 = 0;
                    while (i12 < begIndex / 2) {
                        iArr[i6] = 1;
                        iArr2[i6] = i11;
                        i11 += 2;
                        i12++;
                        i6++;
                    }
                    i3 = i11;
                }
                if (nextIntersectPoint == findCrossing[0]) {
                    int i13 = i6 - 1;
                    iArr[i13] = 4;
                    iArr2[i13] = i3;
                    this.coords = dArr;
                    this.rules = iArr;
                    this.offsets = iArr2;
                    this.coordsSize = i3;
                    this.rulesSize = i6;
                    return;
                }
                intersectPoint2 = nextIntersectPoint;
                i4 = i6;
            }
        } else if (area2.contains(getBounds2D())) {
            copy(area2, this);
        } else if (!contains(area.getBounds2D())) {
            this.coords = adjustSize(this.coords, this.coordsSize + area2.coordsSize);
            System.arraycopy(area2.coords, 0, this.coords, this.coordsSize, area2.coordsSize);
            this.coordsSize += area2.coordsSize;
            this.rules = adjustSize(this.rules, this.rulesSize + area2.rulesSize);
            System.arraycopy(area2.rules, 0, this.rules, this.rulesSize, area2.rulesSize);
            this.rulesSize += area2.rulesSize;
            this.offsets = adjustSize(this.offsets, this.rulesSize + area2.rulesSize);
            System.arraycopy(area2.offsets, 0, this.offsets, this.rulesSize, area2.rulesSize);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01ab A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01f2 A[LOOP:0: B:9:0x0088->B:66:0x01f2, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01b9 A[EDGE_INSN: B:67:0x01b9->B:60:0x01b9 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void intersectCurvePolygon(harmony.java.awt.geom.Area r35) {
        /*
            r34 = this;
            r15 = r34
            r14 = r35
            org.apache.harmony.awt.geom.CurveCrossingHelper r6 = new org.apache.harmony.awt.geom.CurveCrossingHelper
            r0 = 2
            double[][] r1 = new double[r0][]
            double[] r2 = r15.coords
            r16 = 0
            r1[r16] = r2
            double[] r2 = r14.coords
            r13 = 1
            r1[r13] = r2
            int[] r2 = new int[r0]
            int r3 = r15.coordsSize
            r2[r16] = r3
            int r3 = r14.coordsSize
            r2[r13] = r3
            int[][] r3 = new int[r0][]
            int[] r4 = r15.rules
            r3[r16] = r4
            int[] r4 = r14.rules
            r3[r13] = r4
            int[] r4 = new int[r0]
            int r5 = r15.rulesSize
            r4[r16] = r5
            int r5 = r14.rulesSize
            r4[r13] = r5
            int[][] r5 = new int[r0][]
            int[] r0 = r15.offsets
            r5[r16] = r0
            int[] r0 = r14.offsets
            r5[r13] = r0
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            org.apache.harmony.awt.geom.IntersectPoint[] r12 = r6.findCrossing()
            int r0 = r12.length
            if (r0 != 0) goto L_0x0063
            harmony.java.awt.geom.Rectangle2D r0 = r35.getBounds2D()
            boolean r0 = r15.contains((harmony.java.awt.geom.Rectangle2D) r0)
            if (r0 == 0) goto L_0x0055
            r15.copy(r14, r15)
            goto L_0x0062
        L_0x0055:
            harmony.java.awt.geom.Rectangle2D r0 = r34.getBounds2D()
            boolean r0 = r14.contains((harmony.java.awt.geom.Rectangle2D) r0)
            if (r0 != 0) goto L_0x0062
            r34.reset()
        L_0x0062:
            return
        L_0x0063:
            int r0 = r15.coordsSize
            int r1 = r14.coordsSize
            int r0 = r0 + r1
            int r1 = r12.length
            int r0 = r0 + r1
            double[] r11 = new double[r0]
            int r0 = r15.rulesSize
            int r1 = r14.rulesSize
            int r2 = r0 + r1
            int r3 = r12.length
            int r2 = r2 + r3
            int[] r10 = new int[r2]
            int r0 = r0 + r1
            int r1 = r12.length
            int r0 = r0 + r1
            int[] r9 = new int[r0]
            r0 = r12[r16]
            r1 = r12[r16]
            r10[r16] = r16
            r9[r16] = r16
            r8 = r0
            r0 = 0
            r1 = 1
            r17 = 1
        L_0x0088:
            int r2 = r0 + 1
            double r3 = r8.getX()
            r11[r0] = r3
            int r18 = r2 + 1
            double r3 = r8.getY()
            r11[r2] = r3
            int r0 = r8.getEndIndex(r13)
            if (r0 < 0) goto L_0x00bf
            double[] r2 = r15.coords
            int r0 = r0 * 2
            r3 = r2[r0]
            int r5 = r0 + 1
            r6 = r2[r5]
            int r2 = r14.containsExact(r3, r6)
            if (r2 != 0) goto L_0x00af
            goto L_0x00bf
        L_0x00af:
            double[] r1 = r15.coords
            r2 = r1[r0]
            r0 = r1[r5]
            int r0 = r14.containsExact(r2, r0)
            if (r0 <= 0) goto L_0x00bd
            r7 = 1
            goto L_0x00c2
        L_0x00bd:
            r7 = 0
            goto L_0x00c2
        L_0x00bf:
            r0 = r1 ^ 1
            r7 = r0
        L_0x00c2:
            org.apache.harmony.awt.geom.IntersectPoint r6 = r15.getNextIntersectPoint(r12, r8, r7)
            if (r7 == 0) goto L_0x00cb
            double[] r0 = r15.coords
            goto L_0x00cd
        L_0x00cb:
            double[] r0 = r14.coords
        L_0x00cd:
            r19 = r0
            if (r7 == 0) goto L_0x00d4
            int[] r0 = r15.offsets
            goto L_0x00d6
        L_0x00d4:
            int[] r0 = r14.offsets
        L_0x00d6:
            r20 = r0
            if (r7 == 0) goto L_0x00dd
            int[] r0 = r15.rules
            goto L_0x00df
        L_0x00dd:
            int[] r0 = r14.rules
        L_0x00df:
            r21 = r0
            int r22 = r8.getRuleIndex(r7)
            int r0 = r8.getRuleIndex(r7)
            int r1 = r6.getRuleIndex(r7)
            if (r0 <= r1) goto L_0x0139
            if (r7 == 0) goto L_0x00f4
            int r0 = r15.rulesSize
            goto L_0x00f6
        L_0x00f4:
            int r0 = r14.rulesSize
        L_0x00f6:
            r23 = r0
            int r1 = r22 + 1
            r24 = 0
            r25 = 1
            r0 = r34
            r2 = r23
            r3 = r21
            r4 = r20
            r5 = r10
            r26 = r6
            r6 = r9
            r27 = r7
            r7 = r11
            r28 = r8
            r8 = r19
            r29 = r9
            r9 = r17
            r30 = r10
            r10 = r18
            r31 = r11
            r11 = r28
            r32 = r12
            r12 = r27
            r15 = 1
            r13 = r24
            r14 = r25
            int r0 = r0.includeCoordsAndRules(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            int r23 = r23 - r22
            int r23 = r23 + -1
            int r17 = r17 + r23
            r10 = r0
            r13 = r26
            r14 = r27
            r0 = 1
            r22 = 1
            goto L_0x0149
        L_0x0139:
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r32 = r12
            r15 = 1
            r13 = r6
            r14 = r7
            r10 = r18
            r0 = 0
        L_0x0149:
            int r1 = r13.getRuleIndex(r14)
            int r1 = r1 - r22
            int r1 = r1 + r15
            if (r0 == 0) goto L_0x0155
            r0 = 0
            r12 = 0
            goto L_0x0157
        L_0x0155:
            r12 = r22
        L_0x0157:
            r11 = 4
            if (r1 != r12) goto L_0x017a
            int r2 = r13.getRule(r14)
            if (r2 == r15) goto L_0x017a
            int r2 = r13.getRule(r14)
            if (r2 == r11) goto L_0x017a
            r2 = r28
            int r3 = r2.getRule(r14)
            if (r3 == r15) goto L_0x017a
            int r2 = r2.getRule(r14)
            if (r2 == r11) goto L_0x017a
            int r1 = r1 + 1
            r9 = r1
            r18 = 1
            goto L_0x017d
        L_0x017a:
            r18 = r0
            r9 = r1
        L_0x017d:
            r22 = 1
            r23 = 1
            r0 = r34
            r1 = r12
            r2 = r9
            r3 = r21
            r4 = r20
            r5 = r30
            r6 = r29
            r7 = r31
            r8 = r19
            r15 = r9
            r9 = r17
            r20 = 4
            r11 = r13
            r21 = r15
            r15 = r12
            r12 = r14
            r33 = r13
            r13 = r22
            r22 = r14
            r14 = r23
            int r0 = r0.includeCoordsAndRules(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = r21
            if (r1 <= r15) goto L_0x01b1
            if (r18 == 0) goto L_0x01ae
            goto L_0x01b1
        L_0x01ae:
            int r17 = r17 + r1
            goto L_0x01b3
        L_0x01b1:
            int r17 = r17 + 1
        L_0x01b3:
            r1 = r32[r16]
            r2 = r33
            if (r2 != r1) goto L_0x01f2
            int r1 = r17 + -1
            r3 = r30
            r4 = r3[r1]
            r5 = 1
            if (r4 != r5) goto L_0x01c9
            r3[r1] = r20
            r1 = r17
            r6 = r31
            goto L_0x01df
        L_0x01c9:
            int r1 = r0 + 1
            double r4 = r2.getX()
            r6 = r31
            r6[r0] = r4
            int r0 = r1 + 1
            double r4 = r2.getY()
            r6[r1] = r4
            int r1 = r17 + 1
            r3[r17] = r20
        L_0x01df:
            int r2 = r1 + -1
            r4 = r29
            r4[r2] = r0
            r5 = r34
            r5.coords = r6
            r5.rules = r3
            r5.offsets = r4
            r5.coordsSize = r0
            r5.rulesSize = r1
            return
        L_0x01f2:
            r15 = r34
            r14 = r35
            r8 = r2
            r1 = r22
            r9 = r29
            r10 = r30
            r11 = r31
            r12 = r32
            r13 = 1
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: harmony.java.awt.geom.Area.intersectCurvePolygon(harmony.java.awt.geom.Area):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: int[]} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0129 A[LOOP:0: B:9:0x0065->B:47:0x0129, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0117 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void intersectPolygon(harmony.java.awt.geom.Area r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            org.apache.harmony.awt.geom.CrossingHelper r2 = new org.apache.harmony.awt.geom.CrossingHelper
            r3 = 2
            double[][] r4 = new double[r3][]
            double[] r5 = r0.coords
            r6 = 0
            r4[r6] = r5
            double[] r5 = r1.coords
            r7 = 1
            r4[r7] = r5
            int[] r5 = new int[r3]
            int r8 = r0.coordsSize
            r5[r6] = r8
            int r8 = r1.coordsSize
            r5[r7] = r8
            r2.<init>(r4, r5)
            org.apache.harmony.awt.geom.IntersectPoint[] r2 = r2.findCrossing()
            int r4 = r2.length
            if (r4 != 0) goto L_0x0043
            harmony.java.awt.geom.Rectangle2D r2 = r19.getBounds2D()
            boolean r2 = r0.contains((harmony.java.awt.geom.Rectangle2D) r2)
            if (r2 == 0) goto L_0x0035
            r0.copy(r1, r0)
            goto L_0x0042
        L_0x0035:
            harmony.java.awt.geom.Rectangle2D r2 = r18.getBounds2D()
            boolean r1 = r1.contains((harmony.java.awt.geom.Rectangle2D) r2)
            if (r1 != 0) goto L_0x0042
            r18.reset()
        L_0x0042:
            return
        L_0x0043:
            int r4 = r0.coordsSize
            int r5 = r1.coordsSize
            int r4 = r4 + r5
            int r5 = r2.length
            int r4 = r4 + r5
            double[] r4 = new double[r4]
            int r5 = r0.rulesSize
            int r8 = r1.rulesSize
            int r9 = r5 + r8
            int r10 = r2.length
            int r9 = r9 + r10
            int[] r9 = new int[r9]
            int r5 = r5 + r8
            int r8 = r2.length
            int r5 = r5 + r8
            int[] r5 = new int[r5]
            r8 = r2[r6]
            r9[r6] = r6
            r5[r6] = r6
            r10 = r8
            r8 = 0
            r11 = 1
            r12 = 1
        L_0x0065:
            int r13 = r8 + 1
            double r14 = r10.getX()
            r4[r8] = r14
            int r8 = r13 + 1
            double r14 = r10.getY()
            r4[r13] = r14
            r9[r11] = r7
            int r13 = r11 + 1
            int r14 = r8 + -2
            r5[r11] = r14
            int r11 = r10.getEndIndex(r7)
            if (r11 < 0) goto L_0x00a6
            double[] r14 = r0.coords
            int r11 = r11 * 2
            r16 = r4
            r3 = r14[r11]
            int r17 = r11 + 1
            r6 = r14[r17]
            int r3 = r1.containsExact(r3, r6)
            if (r3 != 0) goto L_0x0096
            goto L_0x00a8
        L_0x0096:
            double[] r3 = r0.coords
            r6 = r3[r11]
            r11 = r3[r17]
            int r3 = r1.containsExact(r6, r11)
            if (r3 <= 0) goto L_0x00a4
            r12 = 1
            goto L_0x00ac
        L_0x00a4:
            r12 = 0
            goto L_0x00ac
        L_0x00a6:
            r16 = r4
        L_0x00a8:
            r3 = 1
            r6 = r12 ^ 1
            r12 = r6
        L_0x00ac:
            org.apache.harmony.awt.geom.IntersectPoint r3 = r0.getNextIntersectPoint(r2, r10, r12)
            if (r12 == 0) goto L_0x00b5
            double[] r4 = r0.coords
            goto L_0x00b7
        L_0x00b5:
            double[] r4 = r1.coords
        L_0x00b7:
            int r6 = r10.getEndIndex(r12)
            r7 = 2
            int r6 = r6 * 2
            if (r6 < 0) goto L_0x00eb
            int r7 = r3.getBegIndex(r12)
            int r10 = r10.getEndIndex(r12)
            if (r7 >= r10) goto L_0x00eb
            if (r12 == 0) goto L_0x00cf
            int r7 = r0.coordsSize
            goto L_0x00d1
        L_0x00cf:
            int r7 = r1.coordsSize
        L_0x00d1:
            int r7 = r7 - r6
            r10 = r16
            java.lang.System.arraycopy(r4, r6, r10, r8, r7)
            r6 = 0
        L_0x00d8:
            int r11 = r7 / 2
            if (r6 < r11) goto L_0x00de
            r6 = 0
            goto L_0x00ed
        L_0x00de:
            r11 = 1
            r9[r13] = r11
            int r11 = r13 + 1
            r5[r13] = r8
            int r8 = r8 + 2
            int r6 = r6 + 1
            r13 = r11
            goto L_0x00d8
        L_0x00eb:
            r10 = r16
        L_0x00ed:
            if (r6 < 0) goto L_0x0110
            int r7 = r3.getBegIndex(r12)
            r11 = 2
            int r7 = r7 * 2
            int r7 = r7 - r6
            int r7 = r7 + r11
            java.lang.System.arraycopy(r4, r6, r10, r8, r7)
            r4 = 0
        L_0x00fc:
            int r6 = r7 / 2
            if (r4 < r6) goto L_0x0103
            r4 = 0
            r6 = 1
            goto L_0x0113
        L_0x0103:
            r6 = 1
            r9[r13] = r6
            int r14 = r13 + 1
            r5[r13] = r8
            int r8 = r8 + 2
            int r4 = r4 + 1
            r13 = r14
            goto L_0x00fc
        L_0x0110:
            r6 = 1
            r11 = 2
            r4 = 0
        L_0x0113:
            r7 = r2[r4]
            if (r3 != r7) goto L_0x0129
            int r1 = r13 + -1
            r2 = 4
            r9[r1] = r2
            r5[r1] = r8
            r0.coords = r10
            r0.rules = r9
            r0.offsets = r5
            r0.coordsSize = r8
            r0.rulesSize = r13
            return
        L_0x0129:
            r4 = r10
            r11 = r13
            r6 = 0
            r7 = 1
            r10 = r3
            r3 = 2
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: harmony.java.awt.geom.Area.intersectPolygon(harmony.java.awt.geom.Area):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01a3, code lost:
        if (r22[r1] != 3) goto L_0x01a9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01d4 A[LOOP:0: B:7:0x0078->B:64:0x01d4, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01b8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void subtractCurvePolygon(harmony.java.awt.geom.Area r37) {
        /*
            r36 = this;
            r15 = r36
            r14 = r37
            org.apache.harmony.awt.geom.CurveCrossingHelper r6 = new org.apache.harmony.awt.geom.CurveCrossingHelper
            r13 = 2
            double[][] r1 = new double[r13][]
            double[] r0 = r15.coords
            r16 = 0
            r1[r16] = r0
            double[] r0 = r14.coords
            r12 = 1
            r1[r12] = r0
            int[] r2 = new int[r13]
            int r0 = r15.coordsSize
            r2[r16] = r0
            int r0 = r14.coordsSize
            r2[r12] = r0
            int[][] r3 = new int[r13][]
            int[] r0 = r15.rules
            r3[r16] = r0
            int[] r0 = r14.rules
            r3[r12] = r0
            int[] r4 = new int[r13]
            int r0 = r15.rulesSize
            r4[r16] = r0
            int r0 = r14.rulesSize
            r4[r12] = r0
            int[][] r5 = new int[r13][]
            int[] r0 = r15.offsets
            r5[r16] = r0
            int[] r0 = r14.offsets
            r5[r12] = r0
            r0 = r6
            r0.<init>(r1, r2, r3, r4, r5)
            org.apache.harmony.awt.geom.IntersectPoint[] r11 = r6.findCrossing()
            int r0 = r11.length
            if (r0 != 0) goto L_0x0055
            harmony.java.awt.geom.Rectangle2D r0 = r37.getBounds2D()
            boolean r0 = r15.contains((harmony.java.awt.geom.Rectangle2D) r0)
            if (r0 == 0) goto L_0x0055
            r15.copy(r14, r15)
            return
        L_0x0055:
            int r0 = r15.coordsSize
            int r1 = r14.coordsSize
            int r0 = r0 + r1
            int r1 = r11.length
            int r0 = r0 + r1
            double[] r10 = new double[r0]
            int r0 = r15.rulesSize
            int r1 = r14.rulesSize
            int r2 = r0 + r1
            int r3 = r11.length
            int r2 = r2 + r3
            int[] r9 = new int[r2]
            int r0 = r0 + r1
            int r1 = r11.length
            int r0 = r0 + r1
            int[] r8 = new int[r0]
            r0 = r11[r16]
            r9[r16] = r16
            r8[r16] = r16
            r7 = r0
            r0 = 0
            r1 = 1
            r17 = 1
        L_0x0078:
            int r2 = r0 + 1
            double r3 = r7.getX()
            r10[r0] = r3
            int r18 = r2 + 1
            double r3 = r7.getY()
            r10[r2] = r3
            int[] r0 = r15.offsets
            int r2 = r7.getRuleIndex(r12)
            r0 = r0[r2]
            int r2 = r15.coordsSize
            int r0 = r0 % r2
            double[] r2 = r15.coords
            r3 = r2[r0]
            int r5 = r0 + 1
            r12 = r2[r5]
            int r2 = r14.containsExact(r3, r12)
            if (r2 != 0) goto L_0x00a6
            r12 = 1
            r0 = r1 ^ 1
            r13 = r0
            goto L_0x00b6
        L_0x00a6:
            r12 = 1
            double[] r1 = r15.coords
            r2 = r1[r0]
            r0 = r1[r5]
            int r0 = r14.containsExact(r2, r0)
            if (r0 <= 0) goto L_0x00b5
            r13 = 0
            goto L_0x00b6
        L_0x00b5:
            r13 = 1
        L_0x00b6:
            if (r13 == 0) goto L_0x00bd
            org.apache.harmony.awt.geom.IntersectPoint r0 = r15.getNextIntersectPoint(r11, r7, r13)
            goto L_0x00c1
        L_0x00bd:
            org.apache.harmony.awt.geom.IntersectPoint r0 = r15.getPrevIntersectPoint(r11, r7, r13)
        L_0x00c1:
            r6 = r0
            if (r13 == 0) goto L_0x00c7
            double[] r0 = r15.coords
            goto L_0x00c9
        L_0x00c7:
            double[] r0 = r14.coords
        L_0x00c9:
            r20 = r0
            if (r13 == 0) goto L_0x00d0
            int[] r0 = r15.offsets
            goto L_0x00d2
        L_0x00d0:
            int[] r0 = r14.offsets
        L_0x00d2:
            r21 = r0
            if (r13 == 0) goto L_0x00d9
            int[] r0 = r15.rules
            goto L_0x00db
        L_0x00d9:
            int[] r0 = r14.rules
        L_0x00db:
            r22 = r0
            if (r13 == 0) goto L_0x00e4
            int r0 = r7.getRuleIndex(r13)
            goto L_0x00e8
        L_0x00e4:
            int r0 = r6.getRuleIndex(r13)
        L_0x00e8:
            r23 = r0
            if (r13 == 0) goto L_0x00f6
            int r0 = r7.getRuleIndex(r13)
            int r1 = r6.getRuleIndex(r13)
            if (r0 > r1) goto L_0x0102
        L_0x00f6:
            if (r13 != 0) goto L_0x0149
            int r0 = r6.getRuleIndex(r13)
            int r1 = r6.getRuleIndex(r13)
            if (r0 <= r1) goto L_0x0149
        L_0x0102:
            if (r13 == 0) goto L_0x0107
            int r0 = r15.rulesSize
            goto L_0x0109
        L_0x0107:
            int r0 = r14.rulesSize
        L_0x0109:
            r24 = r0
            int r1 = r23 + 1
            r25 = 0
            r26 = 2
            r0 = r36
            r2 = r24
            r3 = r22
            r4 = r21
            r5 = r9
            r27 = r6
            r6 = r8
            r28 = r7
            r7 = r10
            r29 = r8
            r8 = r20
            r30 = r9
            r9 = r17
            r31 = r10
            r10 = r18
            r32 = r11
            r11 = r28
            r33 = 1
            r12 = r13
            r15 = r13
            r13 = r25
            r14 = r26
            int r0 = r0.includeCoordsAndRules(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            int r24 = r24 - r23
            int r24 = r24 + -1
            int r17 = r17 + r24
            r10 = r0
            r14 = r27
            r0 = 1
            r23 = 1
            goto L_0x015d
        L_0x0149:
            r27 = r6
            r28 = r7
            r29 = r8
            r30 = r9
            r31 = r10
            r32 = r11
            r15 = r13
            r33 = 1
            r10 = r18
            r14 = r27
            r0 = 0
        L_0x015d:
            int r1 = r14.getRuleIndex(r15)
            int r1 = r1 - r23
            int r13 = r1 + 1
            if (r0 == 0) goto L_0x016b
            r12 = 0
            r18 = 0
            goto L_0x016f
        L_0x016b:
            r18 = r0
            r12 = r23
        L_0x016f:
            r19 = 1
            r23 = 2
            r0 = r36
            r1 = r12
            r2 = r13
            r3 = r22
            r4 = r21
            r5 = r30
            r6 = r29
            r7 = r31
            r8 = r20
            r9 = r17
            r11 = r28
            r34 = r12
            r12 = r15
            r20 = r15
            r15 = r13
            r13 = r19
            r35 = r14
            r14 = r23
            int r0 = r0.includeCoordsAndRules(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r1 = r34
            if (r15 != r1) goto L_0x01a8
            r2 = r22[r1]
            r3 = 2
            if (r2 == r3) goto L_0x01a5
            r2 = r22[r1]
            r4 = 3
            if (r2 != r4) goto L_0x01a9
        L_0x01a5:
            int r17 = r17 + 1
            goto L_0x01b2
        L_0x01a8:
            r3 = 2
        L_0x01a9:
            if (r15 < r1) goto L_0x01a5
            if (r18 == 0) goto L_0x01ae
            goto L_0x01a5
        L_0x01ae:
            int r17 = r17 + r15
            int r17 = r17 - r1
        L_0x01b2:
            r1 = r32[r16]
            r2 = r35
            if (r2 != r1) goto L_0x01d4
            int r1 = r17 + 1
            r2 = 4
            r4 = r30
            r4[r17] = r2
            int r2 = r1 + -1
            r5 = r29
            r5[r2] = r0
            r6 = r36
            r7 = r31
            r6.coords = r7
            r6.rules = r4
            r6.offsets = r5
            r6.coordsSize = r0
            r6.rulesSize = r1
            return
        L_0x01d4:
            r15 = r20
            r14 = r37
            r7 = r2
            r1 = r15
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r12 = 1
            r13 = 2
            r15 = r36
            goto L_0x0078
        */
        throw new UnsupportedOperationException("Method not decompiled: harmony.java.awt.geom.Area.subtractCurvePolygon(harmony.java.awt.geom.Area):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: int[]} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00bf, code lost:
        if (r0.coords[r21] != r11.getY()) goto L_0x00dd;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x019c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void subtractPolygon(harmony.java.awt.geom.Area r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            org.apache.harmony.awt.geom.CrossingHelper r2 = new org.apache.harmony.awt.geom.CrossingHelper
            r3 = 2
            double[][] r4 = new double[r3][]
            double[] r5 = r0.coords
            r6 = 0
            r4[r6] = r5
            double[] r5 = r1.coords
            r7 = 1
            r4[r7] = r5
            int[] r5 = new int[r3]
            int r8 = r0.coordsSize
            r5[r6] = r8
            int r8 = r1.coordsSize
            r5[r7] = r8
            r2.<init>(r4, r5)
            org.apache.harmony.awt.geom.IntersectPoint[] r4 = r2.findCrossing()
            int r5 = r4.length
            if (r5 != 0) goto L_0x0035
            harmony.java.awt.geom.Rectangle2D r2 = r26.getBounds2D()
            boolean r2 = r0.contains((harmony.java.awt.geom.Rectangle2D) r2)
            if (r2 == 0) goto L_0x0034
            r0.copy(r1, r0)
        L_0x0034:
            return
        L_0x0035:
            int r5 = r0.coordsSize
            int r8 = r1.coordsSize
            int r5 = r5 + r8
            int r8 = r4.length
            int r5 = r5 + r8
            int r5 = r5 * 2
            double[] r5 = new double[r5]
            int r8 = r0.rulesSize
            int r9 = r1.rulesSize
            int r10 = r8 + r9
            int r11 = r4.length
            int r10 = r10 + r11
            int r10 = r10 * 2
            int[] r10 = new int[r10]
            int r8 = r8 + r9
            int r9 = r4.length
            int r8 = r8 + r9
            int r8 = r8 * 2
            int[] r8 = new int[r8]
            r9 = r4[r6]
            r10[r6] = r6
            r8[r6] = r6
            r11 = r9
            r9 = 0
            r12 = 1
            r13 = 0
            r14 = 1
            r15 = 0
            r16 = 0
        L_0x0061:
            int r17 = r9 + 1
            double r18 = r11.getX()
            r5[r9] = r18
            int r9 = r17 + 1
            double r18 = r11.getY()
            r5[r17] = r18
            r10[r12] = r7
            int r17 = r12 + 1
            int r18 = r9 + -2
            r8[r12] = r18
            int r12 = r11.getEndIndex(r7)
            if (r12 < 0) goto L_0x00d7
            double[] r7 = r0.coords
            int r12 = r12 * 2
            r20 = r4
            r3 = r7[r12]
            int r21 = r12 + 1
            r22 = r8
            r23 = r9
            r8 = r7[r21]
            boolean r3 = r1.isVertex(r3, r8)
            if (r3 == 0) goto L_0x00c2
            r3 = 2
            double[] r4 = new double[r3]
            double[] r3 = r0.coords
            r7 = r3[r12]
            r4[r6] = r7
            r7 = r3[r21]
            r3 = 1
            r4[r3] = r7
            boolean r3 = r2.containsPoint(r4)
            if (r3 == 0) goto L_0x00c2
            double[] r3 = r0.coords
            r7 = r3[r12]
            double r3 = r11.getX()
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x00dd
            double[] r3 = r0.coords
            r7 = r3[r21]
            double r3 = r11.getY()
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 == 0) goto L_0x00c2
            goto L_0x00dd
        L_0x00c2:
            double[] r3 = r0.coords
            r7 = r3[r12]
            r4 = r2
            r2 = r3[r21]
            int r2 = r1.containsExact(r7, r2)
            if (r2 <= 0) goto L_0x00d3
            r2 = r20
            r3 = 0
            goto L_0x00e3
        L_0x00d3:
            r2 = r20
            r3 = 1
            goto L_0x00e3
        L_0x00d7:
            r20 = r4
            r22 = r8
            r23 = r9
        L_0x00dd:
            r4 = r2
            r2 = 1
            r3 = r14 ^ 1
            r2 = r20
        L_0x00e3:
            int r7 = r2.length
            if (r13 < r7) goto L_0x00eb
            if (r3 == 0) goto L_0x00ea
            r3 = 0
            goto L_0x00eb
        L_0x00ea:
            r3 = 1
        L_0x00eb:
            r14 = r3
            if (r14 == 0) goto L_0x00f0
            r15 = 1
            goto L_0x00f2
        L_0x00f0:
            r16 = 1
        L_0x00f2:
            if (r14 == 0) goto L_0x00f9
            org.apache.harmony.awt.geom.IntersectPoint r3 = r0.getNextIntersectPoint(r2, r11, r14)
            goto L_0x00fd
        L_0x00f9:
            org.apache.harmony.awt.geom.IntersectPoint r3 = r0.getPrevIntersectPoint(r2, r11, r14)
        L_0x00fd:
            if (r14 == 0) goto L_0x0102
            double[] r7 = r0.coords
            goto L_0x0104
        L_0x0102:
            double[] r7 = r1.coords
        L_0x0104:
            if (r14 == 0) goto L_0x010c
            int r8 = r11.getEndIndex(r14)
            r9 = 2
            goto L_0x0111
        L_0x010c:
            r9 = 2
            int r8 = r3.getEndIndex(r14)
        L_0x0111:
            int r8 = r8 * 2
            if (r8 <= 0) goto L_0x015f
            if (r14 == 0) goto L_0x0121
            int r9 = r3.getBegIndex(r14)
            int r12 = r11.getEndIndex(r14)
            if (r9 < r12) goto L_0x012d
        L_0x0121:
            if (r14 != 0) goto L_0x015f
            int r9 = r3.getEndIndex(r14)
            int r12 = r3.getBegIndex(r14)
            if (r9 >= r12) goto L_0x015f
        L_0x012d:
            if (r14 == 0) goto L_0x0132
            int r9 = r0.coordsSize
            goto L_0x0134
        L_0x0132:
            int r9 = r1.coordsSize
        L_0x0134:
            int r9 = r9 - r8
            if (r14 == 0) goto L_0x013d
            r12 = r23
            java.lang.System.arraycopy(r7, r8, r5, r12, r9)
            goto L_0x014a
        L_0x013d:
            r12 = r23
            double[] r1 = new double[r9]
            java.lang.System.arraycopy(r7, r8, r1, r6, r9)
            r0.reverseCopy(r1)
            java.lang.System.arraycopy(r1, r6, r5, r12, r9)
        L_0x014a:
            r1 = 0
        L_0x014b:
            int r8 = r9 / 2
            if (r1 < r8) goto L_0x0151
            r8 = 0
            goto L_0x0161
        L_0x0151:
            r8 = 1
            r10[r17] = r8
            int r8 = r17 + 1
            r22[r17] = r12
            int r12 = r12 + 2
            int r1 = r1 + 1
            r17 = r8
            goto L_0x014b
        L_0x015f:
            r12 = r23
        L_0x0161:
            if (r8 < 0) goto L_0x019c
            if (r14 == 0) goto L_0x016b
            int r1 = r3.getBegIndex(r14)
            r9 = 2
            goto L_0x0170
        L_0x016b:
            r9 = 2
            int r1 = r11.getBegIndex(r14)
        L_0x0170:
            int r1 = r1 * 2
            int r1 = r1 - r8
            int r1 = r1 + r9
            if (r14 == 0) goto L_0x017a
            java.lang.System.arraycopy(r7, r8, r5, r12, r1)
            goto L_0x0185
        L_0x017a:
            double[] r11 = new double[r1]
            java.lang.System.arraycopy(r7, r8, r11, r6, r1)
            r0.reverseCopy(r11)
            java.lang.System.arraycopy(r11, r6, r5, r12, r1)
        L_0x0185:
            r7 = 0
        L_0x0186:
            int r8 = r1 / 2
            if (r7 < r8) goto L_0x018e
            r1 = r17
            r8 = 1
            goto L_0x01a0
        L_0x018e:
            r8 = 1
            r10[r17] = r8
            int r11 = r17 + 1
            r22[r17] = r12
            int r12 = r12 + 2
            int r7 = r7 + 1
            r17 = r11
            goto L_0x0186
        L_0x019c:
            r8 = 1
            r9 = 2
            r1 = r17
        L_0x01a0:
            int r13 = r13 + 1
            r7 = r2[r6]
            if (r3 != r7) goto L_0x01be
            if (r15 == 0) goto L_0x01be
            if (r16 == 0) goto L_0x01be
            int r2 = r1 + -1
            r3 = 4
            r10[r2] = r3
            r22[r2] = r12
            r0.coords = r5
            r0.rules = r10
            r7 = r22
            r0.offsets = r7
            r0.coordsSize = r12
            r0.rulesSize = r1
            return
        L_0x01be:
            r7 = r22
            r11 = r3
            r8 = r7
            r9 = r12
            r3 = 2
            r7 = 1
            r12 = r1
            r1 = r26
            r24 = r4
            r4 = r2
            r2 = r24
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: harmony.java.awt.geom.Area.subtractPolygon(harmony.java.awt.geom.Area):void");
    }

    private IntersectPoint getNextIntersectPoint(IntersectPoint[] intersectPointArr, IntersectPoint intersectPoint, boolean z) {
        int endIndex = intersectPoint.getEndIndex(z);
        if (endIndex < 0) {
            return intersectPointArr[Math.abs(endIndex) - 1];
        }
        IntersectPoint intersectPoint2 = null;
        IntersectPoint intersectPoint3 = null;
        for (IntersectPoint intersectPoint4 : intersectPointArr) {
            int begIndex = intersectPoint4.getBegIndex(z);
            if (begIndex >= 0 && (intersectPoint3 == null || begIndex < intersectPoint3.getBegIndex(z))) {
                intersectPoint3 = intersectPoint4;
            }
            if (endIndex <= begIndex && (intersectPoint2 == null || begIndex < intersectPoint2.getBegIndex(z))) {
                intersectPoint2 = intersectPoint4;
            }
        }
        return intersectPoint2 != null ? intersectPoint2 : intersectPoint3;
    }

    private IntersectPoint getPrevIntersectPoint(IntersectPoint[] intersectPointArr, IntersectPoint intersectPoint, boolean z) {
        int begIndex = intersectPoint.getBegIndex(z);
        if (begIndex < 0) {
            return intersectPointArr[Math.abs(begIndex) - 1];
        }
        IntersectPoint intersectPoint2 = null;
        IntersectPoint intersectPoint3 = null;
        for (IntersectPoint intersectPoint4 : intersectPointArr) {
            int endIndex = intersectPoint4.getEndIndex(z);
            if (endIndex >= 0 && (intersectPoint3 == null || endIndex < intersectPoint3.getEndIndex(z))) {
                intersectPoint3 = intersectPoint4;
            }
            if (endIndex <= begIndex && (intersectPoint2 == null || endIndex > intersectPoint2.getEndIndex(z))) {
                intersectPoint2 = intersectPoint4;
            }
        }
        return intersectPoint2 != null ? intersectPoint2 : intersectPoint3;
    }

    private int includeCoordsAndRules(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, double[] dArr, double[] dArr2, int i3, int i4, IntersectPoint intersectPoint, boolean z, boolean z2, int i5) {
        boolean z3;
        boolean z4;
        int i6;
        int i7;
        boolean z5;
        int i8;
        boolean z6;
        int i9 = i;
        int i10 = i2;
        double[] dArr3 = dArr;
        int i11 = i4;
        int i12 = i5;
        double[] dArr4 = new double[(i10 * 8)];
        int i13 = 1;
        if (i10 <= i9) {
            for (int i14 = i3; i14 < i3 + 1; i14++) {
                iArr3[i14] = 1;
            }
        } else {
            int i15 = i3;
            int i16 = i9;
            while (i16 < i10) {
                iArr3[i15] = 1;
                i16++;
                i15++;
                i13 = 1;
            }
        }
        int i17 = 3;
        int i18 = 0;
        int i19 = 2;
        if (i10 == i9 && (iArr[i9] == 2 || iArr[i9] == 3)) {
            i10++;
            z3 = true;
        } else {
            z3 = false;
        }
        int i20 = i3;
        boolean z7 = z2;
        boolean z8 = true;
        boolean z9 = true;
        int i21 = 0;
        while (i9 < i10) {
            int i22 = iArr2[i9];
            if (!z8) {
                i22 -= 2;
            }
            if (!z9) {
                i10++;
                z9 = true;
            }
            int i23 = iArr[i9];
            if (i23 != 0) {
                if (i23 == i13) {
                    z5 = z3;
                } else if (i23 != i19) {
                    if (i23 == i17) {
                        iArr3[i20] = i17;
                        int i24 = i20 + 1;
                        iArr4[i20] = i11 + 6;
                        double[] dArr5 = new double[8];
                        int i25 = i22 - 2;
                        dArr5[0] = dArr2[i25];
                        int i26 = i22 - 1;
                        dArr5[1] = dArr2[i26];
                        dArr5[i19] = dArr2[i22];
                        dArr5[i17] = dArr2[i22 + 1];
                        dArr5[4] = dArr2[i22 + 2];
                        dArr5[5] = dArr2[i22 + 3];
                        dArr5[6] = dArr2[i22 + 4];
                        dArr5[7] = dArr2[i22 + 5];
                        if (CrossingHelper.compare(dArr2[i25], dArr2[i26], intersectPoint.getX(), intersectPoint.getY()) > 0) {
                            i8 = i24;
                            z6 = true;
                        } else {
                            i8 = i24;
                            z6 = false;
                        }
                        GeometryUtil.subCubic(dArr5, intersectPoint.getParam(z), !z6);
                        if (z6) {
                            System.arraycopy(dArr5, i19, dArr4, i21, 6);
                            i21 += 6;
                        } else {
                            System.arraycopy(dArr5, i19, dArr4, i21, 4);
                            i21 += 4;
                        }
                        i20 = i8;
                    } else if (i23 == 4) {
                        z5 = z3;
                        i13 = 1;
                    }
                    z4 = z3;
                } else {
                    iArr3[i20] = i19;
                    i7 = i20 + 1;
                    iArr4[i20] = i11 + 4;
                    double[] dArr6 = new double[6];
                    int i27 = i22 - 2;
                    dArr6[0] = dArr2[i27];
                    int i28 = i22 - 1;
                    dArr6[1] = dArr2[i28];
                    dArr6[i19] = dArr2[i22];
                    dArr6[3] = dArr2[i22 + 1];
                    dArr6[4] = dArr2[i22 + 2];
                    dArr6[5] = dArr2[i22 + 3];
                    boolean z10 = CrossingHelper.compare(dArr2[i27], dArr2[i28], intersectPoint.getX(), intersectPoint.getY()) > 0;
                    if (z3 || !(i12 == 0 || i12 == i19)) {
                        z4 = z3;
                    } else {
                        z10 = !z10;
                        z4 = z3;
                        z7 = false;
                    }
                    GeometryUtil.subQuad(dArr6, intersectPoint.getParam(z), z10);
                    if (z7 || z10) {
                        i19 = 2;
                        int i29 = i21 + 1;
                        dArr4[i21] = dArr6[2];
                        i6 = i29 + 1;
                        dArr4[i29] = dArr6[3];
                        i20 = i7;
                        i21 = i6;
                    } else {
                        i19 = 2;
                        System.arraycopy(dArr6, 2, dArr4, i21, 4);
                        i21 += 4;
                        i20 = i7;
                    }
                }
                iArr3[i20] = i13;
                i7 = i20 + 1;
                iArr4[i20] = i11 + 2;
                int i30 = i22 + 1;
                boolean z11 = CrossingHelper.compare(dArr2[i22], dArr2[i30], intersectPoint.getX(), intersectPoint.getY()) > 0;
                if (z7 || !z11) {
                    int i31 = i21 + 1;
                    dArr4[i21] = dArr2[i22];
                    i6 = i31 + 1;
                    dArr4[i31] = dArr2[i30];
                    i20 = i7;
                    i21 = i6;
                } else {
                    i20 = i7;
                }
            } else {
                z4 = z3;
                z8 = false;
                z9 = false;
            }
            i9++;
            z3 = z4;
            i13 = 1;
            i17 = 3;
            i18 = 0;
        }
        if (i12 != i19 || z || i21 <= i19) {
            System.arraycopy(dArr4, i18, dArr3, i11, i21);
        } else {
            reverseCopy(dArr4);
            System.arraycopy(dArr4, i18, dArr3, i11, i21);
        }
        return i11 + i21;
    }

    private static double[] adjustSize(double[] dArr, int i) {
        if (i <= dArr.length) {
            return dArr;
        }
        double[] dArr2 = new double[(i * 2)];
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
        return dArr2;
    }

    private static int[] adjustSize(int[] iArr, int i) {
        if (i <= iArr.length) {
            return iArr;
        }
        int[] iArr2 = new int[(i * 2)];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    private void copy(Area area, Area area2) {
        area2.coordsSize = area.coordsSize;
        area2.coords = (double[]) area.coords.clone();
        area2.rulesSize = area.rulesSize;
        area2.rules = (int[]) area.rules.clone();
        area2.moveToCount = area.moveToCount;
        area2.offsets = (int[]) area.offsets.clone();
    }

    private int containsExact(double d, double d2) {
        double[] dArr;
        int i = 1;
        if (Crossing.isInsideEvenOdd(Crossing.crossPath(getPathIterator((AffineTransform) null), d, d2))) {
            return 1;
        }
        double[] dArr2 = new double[6];
        double[] dArr3 = new double[6];
        PathIterator pathIterator = getPathIterator((AffineTransform) null);
        double d3 = -1.0d;
        double d4 = -1.0d;
        double d5 = -1.0d;
        double d6 = -1.0d;
        while (!pathIterator.isDone()) {
            int currentSegment = pathIterator.currentSegment(dArr2);
            if (currentSegment == 0) {
                dArr = dArr2;
                d3 = dArr[0];
                d4 = dArr[1];
                d5 = d3;
                d6 = d4;
            } else if (currentSegment == i) {
                dArr = dArr2;
                if (GeometryUtil.intersectLines(d3, d4, dArr[0], dArr[1], d, d2, d, d2, dArr3) != 0) {
                    return 0;
                }
                d3 = dArr[0];
                d4 = dArr[1];
            } else if (currentSegment == 2) {
                dArr = dArr2;
                if (GeometryUtil.intersectLineAndQuad(d, d2, d, d2, d3, d4, dArr[0], dArr[1], dArr[2], dArr[3], dArr3) > 0) {
                    return 0;
                }
                d3 = dArr[2];
                d4 = dArr[3];
            } else if (currentSegment == 3) {
                dArr = dArr2;
                if (GeometryUtil.intersectLineAndCubic(d, d2, d, d2, d3, d4, dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], dArr3) > 0) {
                    return 0;
                }
                d3 = dArr[4];
                d4 = dArr[5];
            } else if (currentSegment != 4) {
                dArr = dArr2;
            } else {
                dArr = dArr2;
                if (GeometryUtil.intersectLines(d3, d4, d5, d6, d, d2, d, d2, dArr3) != 0) {
                    return 0;
                }
                d3 = d5;
                d4 = d6;
            }
            pathIterator.next();
            double d7 = d;
            double d8 = d2;
            dArr2 = dArr;
            i = 1;
        }
        return -1;
    }

    private void reverseCopy(double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        System.arraycopy(dArr, 0, dArr2, 0, dArr.length);
        for (int i = 0; i < dArr.length; i += 2) {
            dArr[i] = dArr2[(dArr.length - i) - 2];
            dArr[i + 1] = dArr2[(dArr.length - i) - 1];
        }
    }

    private double getAreaBoundsSquare() {
        Rectangle2D bounds2D = getBounds2D();
        return bounds2D.getHeight() * bounds2D.getWidth();
    }

    private boolean isVertex(double d, double d2) {
        int i = 0;
        while (i < this.coordsSize) {
            double[] dArr = this.coords;
            int i2 = i + 1;
            if (d == dArr[i]) {
                i = i2 + 1;
                if (d2 == dArr[i2]) {
                    return true;
                }
            } else {
                i = i2;
            }
        }
        return false;
    }

    private class AreaPathIterator implements PathIterator {
        Area area;
        int curCoordIndex;
        int curRuleIndex;
        AffineTransform transform;

        public int getWindingRule() {
            return 0;
        }

        AreaPathIterator(Area area2, Area area3) {
            this(area3, (AffineTransform) null);
        }

        AreaPathIterator(Area area2, AffineTransform affineTransform) {
            this.curRuleIndex = 0;
            this.curCoordIndex = 0;
            this.area = area2;
            this.transform = affineTransform;
        }

        public boolean isDone() {
            return this.curRuleIndex >= Area.this.rulesSize;
        }

        public void next() {
            int i = Area.this.rules[this.curRuleIndex];
            if (i == 0 || i == 1) {
                this.curCoordIndex += 2;
            } else if (i == 2) {
                this.curCoordIndex += 4;
            } else if (i == 3) {
                this.curCoordIndex += 6;
            }
            this.curRuleIndex++;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x007a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int currentSegment(double[] r10) {
            /*
                r9 = this;
                boolean r0 = r9.isDone()
                if (r0 != 0) goto L_0x008c
                harmony.java.awt.geom.Area r0 = harmony.java.awt.geom.Area.this
                int[] r0 = r0.rules
                int r1 = r9.curRuleIndex
                r0 = r0[r1]
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x0059
                if (r0 == r2) goto L_0x0059
                r3 = 3
                r4 = 2
                if (r0 == r4) goto L_0x003c
                if (r0 == r3) goto L_0x001e
                r7 = 0
                goto L_0x0076
            L_0x001e:
                harmony.java.awt.geom.Area r0 = harmony.java.awt.geom.Area.this
                double[] r0 = r0.coords
                int r5 = r9.curCoordIndex
                r6 = 4
                int r5 = r5 + r6
                r7 = r0[r5]
                r10[r6] = r7
                harmony.java.awt.geom.Area r0 = harmony.java.awt.geom.Area.this
                double[] r0 = r0.coords
                int r5 = r9.curCoordIndex
                r6 = 5
                int r5 = r5 + r6
                r7 = r0[r5]
                r10[r6] = r7
                r0 = 1
                goto L_0x003d
            L_0x003c:
                r0 = 0
            L_0x003d:
                harmony.java.awt.geom.Area r5 = harmony.java.awt.geom.Area.this
                double[] r5 = r5.coords
                int r6 = r9.curCoordIndex
                int r6 = r6 + r4
                r6 = r5[r6]
                r10[r4] = r6
                harmony.java.awt.geom.Area r4 = harmony.java.awt.geom.Area.this
                double[] r4 = r4.coords
                int r5 = r9.curCoordIndex
                int r5 = r5 + r3
                r5 = r4[r5]
                r10[r3] = r5
                int r0 = r0 + r2
                goto L_0x005a
            L_0x0059:
                r0 = 0
            L_0x005a:
                harmony.java.awt.geom.Area r3 = harmony.java.awt.geom.Area.this
                double[] r3 = r3.coords
                int r4 = r9.curCoordIndex
                r4 = r3[r4]
                r10[r1] = r4
                harmony.java.awt.geom.Area r1 = harmony.java.awt.geom.Area.this
                double[] r1 = r1.coords
                int r3 = r9.curCoordIndex
                int r3 = r3 + r2
                r3 = r1[r3]
                r10[r2] = r3
                int r1 = r0 + 1
                r7 = r1
            L_0x0076:
                harmony.java.awt.geom.AffineTransform r2 = r9.transform
                if (r2 == 0) goto L_0x0081
                r4 = 0
                r6 = 0
                r3 = r10
                r5 = r10
                r2.transform((double[]) r3, (int) r4, (double[]) r5, (int) r6, (int) r7)
            L_0x0081:
                harmony.java.awt.geom.Area r10 = harmony.java.awt.geom.Area.this
                int[] r10 = r10.rules
                int r0 = r9.curRuleIndex
                r10 = r10[r0]
                return r10
            L_0x008c:
                java.util.NoSuchElementException r10 = new java.util.NoSuchElementException
                java.lang.String r0 = "awt.4B"
                java.lang.String r0 = org.apache.harmony.awt.internal.nls.Messages.getString(r0)
                r10.<init>(r0)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: harmony.java.awt.geom.Area.AreaPathIterator.currentSegment(double[]):int");
        }

        public int currentSegment(float[] fArr) {
            double[] dArr = new double[6];
            int currentSegment = currentSegment(dArr);
            for (int i = 0; i < 6; i++) {
                fArr[i] = (float) dArr[i];
            }
            return currentSegment;
        }
    }
}
