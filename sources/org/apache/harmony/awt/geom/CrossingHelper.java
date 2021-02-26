package org.apache.harmony.awt.geom;

import java.util.ArrayList;
import java.util.List;

public class CrossingHelper {
    private double[][] coords;
    private List<IntersectPoint> isectPoints = new ArrayList();
    private int[] sizes;

    public static int compare(double d, double d2, double d3, double d4) {
        if (d < d3) {
            return 1;
        }
        int i = (d > d3 ? 1 : (d == d3 ? 0 : -1));
        if (i != 0 || d2 >= d4) {
            return (i == 0 && d2 == d4) ? 0 : -1;
        }
        return 1;
    }

    public CrossingHelper(double[][] dArr, int[] iArr) {
        this.coords = dArr;
        this.sizes = iArr;
    }

    public IntersectPoint[] findCrossing() {
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr = this.sizes;
        int i5 = iArr[0] / 2;
        int i6 = iArr[1] / 2;
        int i7 = i5 + i6;
        int[] iArr2 = new int[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            iArr2[i8] = i8;
        }
        double[][] dArr = this.coords;
        sort(dArr[0], i5, dArr[1], i6, iArr2);
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < iArr2.length; i9++) {
            if (iArr2[i9] < i5) {
                i3 = iArr2[i9];
                i2 = iArr2[i9] - 1;
                if (i2 < 0) {
                    i2 = i5 - 1;
                }
                i = 0;
            } else if (iArr2[i9] < i7) {
                i3 = iArr2[i9] - i5;
                int i10 = (iArr2[i9] - 1) - i5;
                if (i10 < 0) {
                    i10 = i6 - 1;
                }
                i = 1;
            } else {
                throw new IndexOutOfBoundsException();
            }
            if (!removeEdge(arrayList, i3, i2)) {
                Edge edge = new Edge(i3, i2, i);
                double[][] dArr2 = this.coords;
                intersectShape(arrayList, dArr2[0], i5, dArr2[1], i6, edge);
                arrayList.add(edge);
            }
            int i11 = iArr2[i9];
            int i12 = iArr2[i9] + 1;
            if (i11 < i5 && i12 == i5) {
                i12 = 0;
            } else if (i11 >= i5 && i12 == i7) {
                i12 = i5;
            }
            if (i12 < i5) {
                i4 = 0;
            } else {
                i12 -= i5;
                i11 -= i5;
                i4 = 1;
            }
            if (!removeEdge(arrayList, i11, i12)) {
                Edge edge2 = new Edge(i11, i12, i4);
                double[][] dArr3 = this.coords;
                intersectShape(arrayList, dArr3[0], i5, dArr3[1], i6, edge2);
                arrayList.add(edge2);
            }
        }
        List<IntersectPoint> list = this.isectPoints;
        return (IntersectPoint[]) list.toArray(new IntersectPoint[list.size()]);
    }

    private boolean removeEdge(List<Edge> list, int i, int i2) {
        for (Edge next : list) {
            if (next.reverseCompare(i, i2)) {
                list.remove(next);
                return true;
            }
        }
        return false;
    }

    private void intersectShape(List<Edge> list, double[] dArr, int i, double[] dArr2, int i2, Edge edge) {
        double d;
        double d2;
        double d3;
        double d4;
        boolean z;
        double d5;
        double d6;
        double d7;
        double d8;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        int i6;
        Edge edge2 = edge;
        double[] dArr3 = new double[2];
        int i7 = 1;
        if (edge2.areaNumber == 0) {
            double d9 = dArr[edge2.begIndex * 2];
            d4 = d9;
            d3 = dArr[(edge2.begIndex * 2) + 1];
            d2 = dArr[edge2.endIndex * 2];
            d = dArr[(edge2.endIndex * 2) + 1];
            z = false;
        } else {
            double d10 = dArr2[edge2.begIndex * 2];
            d4 = d10;
            d3 = dArr2[(edge2.begIndex * 2) + 1];
            d2 = dArr2[edge2.endIndex * 2];
            d = dArr2[(edge2.endIndex * 2) + 1];
            z = true;
        }
        for (Edge next : list) {
            if (next.areaNumber == 0) {
                double d11 = dArr[next.begIndex * 2];
                d8 = d11;
                d7 = dArr[(next.begIndex * 2) + i7];
                d6 = dArr[next.endIndex * 2];
                d5 = dArr[(next.endIndex * 2) + i7];
                z2 = false;
            } else {
                double d12 = dArr2[next.begIndex * 2];
                d8 = d12;
                d7 = dArr2[(next.begIndex * 2) + i7];
                d6 = dArr2[next.endIndex * 2];
                d5 = dArr2[(next.endIndex * 2) + i7];
                z2 = true;
            }
            if (z != z2) {
                boolean z4 = z;
                Edge edge3 = next;
                double[] dArr4 = dArr3;
                if (GeometryUtil.intersectLines(d4, d3, d2, d, d8, d7, d6, d5, dArr4) == 1) {
                    double[] dArr5 = dArr4;
                    if (!containsPoint(dArr5)) {
                        if (edge2.areaNumber == 0) {
                            i6 = edge2.begIndex;
                            i5 = edge2.endIndex;
                            Edge edge4 = edge3;
                            i3 = edge4.begIndex;
                            i4 = edge4.endIndex;
                        } else {
                            Edge edge5 = edge3;
                            i6 = edge5.begIndex;
                            i5 = edge5.endIndex;
                            i3 = edge2.begIndex;
                            i4 = edge2.endIndex;
                        }
                        int i8 = i - 1;
                        if ((i5 == i8 && i6 == 0 && i5 > i6) || (!(i5 == i8 && i6 == 0) && (!(i6 == i8 && i5 == 0) && i6 > i5))) {
                            int i9 = i5;
                            i5 = i6;
                            i6 = i9;
                        }
                        int i10 = i2 - 1;
                        if (!(i4 == i10 && i3 == 0 && i4 > i3) && ((i4 == i10 && i3 == 0) || ((i3 == i10 && i4 == 0) || i3 <= i4))) {
                            int i11 = i3;
                            i3 = i4;
                            i4 = i11;
                        }
                        int i12 = i6;
                        int i13 = i5;
                        int i14 = i4;
                        int i15 = i3;
                        for (IntersectPoint next2 : this.isectPoints) {
                            if (i12 == next2.getBegIndex(true) && i13 == next2.getEndIndex(true)) {
                                if (compare(next2.getX(), next2.getY(), dArr5[0], dArr5[1]) > 0) {
                                    next2.setBegIndex1(-(this.isectPoints.size() + 1));
                                    i13 = -(this.isectPoints.indexOf(next2) + 1);
                                } else {
                                    next2.setEndIndex1(-(this.isectPoints.size() + 1));
                                    i12 = -(this.isectPoints.indexOf(next2) + 1);
                                }
                            }
                            if (i14 == next2.getBegIndex(false) && i15 == next2.getEndIndex(false)) {
                                if (compare(next2.getX(), next2.getY(), dArr5[0], dArr5[1]) > 0) {
                                    i15 = -(this.isectPoints.indexOf(next2) + 1);
                                    next2.setBegIndex2(-(this.isectPoints.size() + 1));
                                } else {
                                    i14 = -(this.isectPoints.indexOf(next2) + 1);
                                    next2.setEndIndex2(-(this.isectPoints.size() + 1));
                                }
                            }
                        }
                        this.isectPoints.add(new IntersectPoint(i12, i13, i14, i15, dArr5[0], dArr5[1]));
                    }
                    dArr3 = dArr5;
                    z3 = z4;
                } else {
                    z3 = z4;
                    dArr3 = dArr4;
                }
                i7 = 1;
            }
        }
    }

    private static void sort(double[] dArr, int i, double[] dArr2, int i2, int[] iArr) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        int i3 = i;
        int i4 = i3 + i2;
        for (int i5 = 1; i5 < i4; i5++) {
            int i6 = i5 - 1;
            if (iArr[i6] < i3) {
                d2 = dArr[iArr[i6] * 2];
                d = dArr[(iArr[i6] * 2) + 1];
            } else {
                d2 = dArr2[(iArr[i6] - i3) * 2];
                d = dArr2[((iArr[i6] - i3) * 2) + 1];
            }
            if (iArr[i5] < i3) {
                d4 = dArr[iArr[i5] * 2];
                d3 = dArr[(iArr[i5] * 2) + 1];
            } else {
                d4 = dArr2[(iArr[i5] - i3) * 2];
                d3 = dArr2[((iArr[i5] - i3) * 2) + 1];
            }
            int i7 = i5;
            double d7 = d2;
            double d8 = d;
            double d9 = d4;
            double d10 = d3;
            while (i7 > 0 && compare(d7, d8, d9, d10) <= 0) {
                int i8 = iArr[i7];
                int i9 = i7 - 1;
                iArr[i7] = iArr[i9];
                iArr[i9] = i8;
                i7--;
                if (i7 > 0) {
                    int i10 = i7 - 1;
                    if (iArr[i10] < i3) {
                        d6 = dArr[iArr[i10] * 2];
                        d5 = dArr[(iArr[i10] * 2) + 1];
                    } else {
                        d6 = dArr2[(iArr[i10] - i3) * 2];
                        d5 = dArr2[((iArr[i10] - i3) * 2) + 1];
                    }
                    d7 = d6;
                    d8 = d5;
                    if (iArr[i7] < i3) {
                        d9 = dArr[iArr[i7] * 2];
                        d10 = dArr[(iArr[i7] * 2) + 1];
                    } else {
                        d9 = dArr2[(iArr[i7] - i3) * 2];
                        d10 = dArr2[((iArr[i7] - i3) * 2) + 1];
                    }
                }
            }
        }
    }

    public boolean containsPoint(double[] dArr) {
        for (IntersectPoint next : this.isectPoints) {
            if (next.getX() == dArr[0] && next.getY() == dArr[1]) {
                return true;
            }
        }
        return false;
    }

    private static final class Edge {
        final int areaNumber;
        final int begIndex;
        final int endIndex;

        Edge(int i, int i2, int i3) {
            this.begIndex = i;
            this.endIndex = i2;
            this.areaNumber = i3;
        }

        /* access modifiers changed from: package-private */
        public boolean reverseCompare(int i, int i2) {
            return this.begIndex == i2 && this.endIndex == i;
        }
    }
}
