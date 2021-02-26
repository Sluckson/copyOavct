package com.lowagie.text.pdf.internal;

import harmony.java.awt.Rectangle;
import harmony.java.awt.Shape;
import harmony.java.awt.geom.AffineTransform;
import harmony.java.awt.geom.Line2D;
import harmony.java.awt.geom.PathIterator;
import harmony.java.awt.geom.Point2D;
import harmony.java.awt.geom.Rectangle2D;

public class PolylineShape implements Shape {

    /* renamed from: np */
    protected int f806np;

    /* renamed from: x */
    protected int[] f807x;

    /* renamed from: y */
    protected int[] f808y;

    public boolean contains(double d, double d2) {
        return false;
    }

    public boolean contains(double d, double d2, double d3, double d4) {
        return false;
    }

    public boolean contains(Point2D point2D) {
        return false;
    }

    public boolean contains(Rectangle2D rectangle2D) {
        return false;
    }

    public PolylineShape(int[] iArr, int[] iArr2, int i) {
        this.f806np = i;
        int i2 = this.f806np;
        this.f807x = new int[i2];
        this.f808y = new int[i2];
        System.arraycopy(iArr, 0, this.f807x, 0, i2);
        System.arraycopy(iArr2, 0, this.f808y, 0, this.f806np);
    }

    public Rectangle2D getBounds2D() {
        int[] rect = rect();
        if (rect == null) {
            return null;
        }
        return new Rectangle2D.Double((double) rect[0], (double) rect[1], (double) rect[2], (double) rect[3]);
    }

    public Rectangle getBounds() {
        return getBounds2D().getBounds();
    }

    private int[] rect() {
        if (this.f806np == 0) {
            return null;
        }
        int[] iArr = this.f807x;
        int i = iArr[0];
        int[] iArr2 = this.f808y;
        int i2 = iArr2[0];
        int i3 = iArr[0];
        int i4 = iArr2[0];
        int i5 = i3;
        for (int i6 = 1; i6 < this.f806np; i6++) {
            int[] iArr3 = this.f807x;
            if (iArr3[i6] < i) {
                i = iArr3[i6];
            } else if (iArr3[i6] > i5) {
                i5 = iArr3[i6];
            }
            int[] iArr4 = this.f808y;
            if (iArr4[i6] < i2) {
                i2 = iArr4[i6];
            } else if (iArr4[i6] > i4) {
                i4 = iArr4[i6];
            }
        }
        return new int[]{i, i2, i5 - i, i4 - i2};
    }

    public boolean intersects(double d, double d2, double d3, double d4) {
        return intersects(new Rectangle2D.Double(d, d2, d3, d4));
    }

    public boolean intersects(Rectangle2D rectangle2D) {
        if (this.f806np == 0) {
            return false;
        }
        int[] iArr = this.f807x;
        int[] iArr2 = this.f808y;
        Line2D.Double doubleR = new Line2D.Double((double) iArr[0], (double) iArr2[0], (double) iArr[0], (double) iArr2[0]);
        for (int i = 1; i < this.f806np; i++) {
            int[] iArr3 = this.f807x;
            int i2 = i - 1;
            int[] iArr4 = this.f808y;
            doubleR.setLine((double) iArr3[i2], (double) iArr4[i2], (double) iArr3[i], (double) iArr4[i]);
            if (doubleR.intersects(rectangle2D)) {
                return true;
            }
        }
        return false;
    }

    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new PolylineShapeIterator(this, affineTransform);
    }

    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new PolylineShapeIterator(this, affineTransform);
    }
}
