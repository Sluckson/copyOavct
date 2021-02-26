package harmony.java.awt;

import harmony.java.awt.geom.AffineTransform;
import harmony.java.awt.geom.PathIterator;
import harmony.java.awt.geom.Point2D;
import harmony.java.awt.geom.Rectangle2D;
import java.io.Serializable;
import java.util.NoSuchElementException;
import org.apache.harmony.awt.internal.nls.Messages;
import org.apache.harmony.awt.p062gl.Crossing;

public class Polygon implements Shape, Serializable {
    private static final int BUFFER_CAPACITY = 4;
    private static final long serialVersionUID = -6460061437900069969L;
    protected Rectangle bounds;
    public int npoints;
    public int[] xpoints;
    public int[] ypoints;

    class Iterator implements PathIterator {
        public int index;

        /* renamed from: p */
        public Polygon f4905p;

        /* renamed from: t */
        public AffineTransform f4906t;

        public int getWindingRule() {
            return 0;
        }

        public Iterator(AffineTransform affineTransform, Polygon polygon) {
            this.f4905p = polygon;
            this.f4906t = affineTransform;
            if (polygon.npoints == 0) {
                this.index = 1;
            }
        }

        public boolean isDone() {
            return this.index > this.f4905p.npoints;
        }

        public void next() {
            this.index++;
        }

        public int currentSegment(double[] dArr) {
            if (isDone()) {
                throw new NoSuchElementException(Messages.getString("awt.110"));
            } else if (this.index == this.f4905p.npoints) {
                return 4;
            } else {
                dArr[0] = (double) this.f4905p.xpoints[this.index];
                dArr[1] = (double) this.f4905p.ypoints[this.index];
                AffineTransform affineTransform = this.f4906t;
                if (affineTransform != null) {
                    affineTransform.transform(dArr, 0, dArr, 0, 1);
                }
                if (this.index == 0) {
                    return 0;
                }
                return 1;
            }
        }

        public int currentSegment(float[] fArr) {
            if (isDone()) {
                throw new NoSuchElementException(Messages.getString("awt.110"));
            } else if (this.index == this.f4905p.npoints) {
                return 4;
            } else {
                fArr[0] = (float) this.f4905p.xpoints[this.index];
                fArr[1] = (float) this.f4905p.ypoints[this.index];
                AffineTransform affineTransform = this.f4906t;
                if (affineTransform != null) {
                    affineTransform.transform(fArr, 0, fArr, 0, 1);
                }
                if (this.index == 0) {
                    return 0;
                }
                return 1;
            }
        }
    }

    public Polygon() {
        this.xpoints = new int[4];
        this.ypoints = new int[4];
    }

    public Polygon(int[] iArr, int[] iArr2, int i) {
        if (i > iArr.length || i > iArr2.length) {
            throw new IndexOutOfBoundsException(Messages.getString("awt.111"));
        } else if (i >= 0) {
            this.npoints = i;
            this.xpoints = new int[i];
            this.ypoints = new int[i];
            System.arraycopy(iArr, 0, this.xpoints, 0, i);
            System.arraycopy(iArr2, 0, this.ypoints, 0, i);
        } else {
            throw new NegativeArraySizeException(Messages.getString("awt.112"));
        }
    }

    public void reset() {
        this.npoints = 0;
        this.bounds = null;
    }

    public void invalidate() {
        this.bounds = null;
    }

    public void addPoint(int i, int i2) {
        int i3 = this.npoints;
        int[] iArr = this.xpoints;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(iArr.length + 4)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.xpoints = iArr2;
            int[] iArr3 = this.ypoints;
            int[] iArr4 = new int[(iArr3.length + 4)];
            System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
            this.ypoints = iArr4;
        }
        int[] iArr5 = this.xpoints;
        int i4 = this.npoints;
        iArr5[i4] = i;
        this.ypoints[i4] = i2;
        this.npoints = i4 + 1;
        Rectangle rectangle = this.bounds;
        if (rectangle != null) {
            double d = (double) i;
            double d2 = (double) i2;
            rectangle.setFrameFromDiagonal(Math.min(rectangle.getMinX(), d), Math.min(this.bounds.getMinY(), d2), Math.max(this.bounds.getMaxX(), d), Math.max(this.bounds.getMaxY(), d2));
        }
    }

    public Rectangle getBounds() {
        Rectangle rectangle = this.bounds;
        if (rectangle != null) {
            return rectangle;
        }
        if (this.npoints == 0) {
            return new Rectangle();
        }
        int i = this.xpoints[0];
        int i2 = this.ypoints[0];
        int i3 = i;
        int i4 = i2;
        for (int i5 = 1; i5 < this.npoints; i5++) {
            int i6 = this.xpoints[i5];
            int i7 = this.ypoints[i5];
            if (i6 < i) {
                i = i6;
            } else if (i6 > i3) {
                i3 = i6;
            }
            if (i7 < i2) {
                i2 = i7;
            } else if (i7 > i4) {
                i4 = i7;
            }
        }
        Rectangle rectangle2 = new Rectangle(i, i2, i3 - i, i4 - i2);
        this.bounds = rectangle2;
        return rectangle2;
    }

    @Deprecated
    public Rectangle getBoundingBox() {
        return getBounds();
    }

    public Rectangle2D getBounds2D() {
        return getBounds().getBounds2D();
    }

    public void translate(int i, int i2) {
        for (int i3 = 0; i3 < this.npoints; i3++) {
            int[] iArr = this.xpoints;
            iArr[i3] = iArr[i3] + i;
            int[] iArr2 = this.ypoints;
            iArr2[i3] = iArr2[i3] + i2;
        }
        Rectangle rectangle = this.bounds;
        if (rectangle != null) {
            rectangle.translate(i, i2);
        }
    }

    @Deprecated
    public boolean inside(int i, int i2) {
        return contains((double) i, (double) i2);
    }

    public boolean contains(int i, int i2) {
        return contains((double) i, (double) i2);
    }

    public boolean contains(double d, double d2) {
        return Crossing.isInsideEvenOdd(Crossing.crossShape(this, d, d2));
    }

    public boolean contains(double d, double d2, double d3, double d4) {
        int intersectShape = Crossing.intersectShape(this, d, d2, d3, d4);
        return intersectShape != 255 && Crossing.isInsideEvenOdd(intersectShape);
    }

    public boolean intersects(double d, double d2, double d3, double d4) {
        int intersectShape = Crossing.intersectShape(this, d, d2, d3, d4);
        return intersectShape == 255 || Crossing.isInsideEvenOdd(intersectShape);
    }

    public boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public boolean contains(Point point) {
        return contains(point.getX(), point.getY());
    }

    public boolean contains(Point2D point2D) {
        return contains(point2D.getX(), point2D.getY());
    }

    public boolean intersects(Rectangle2D rectangle2D) {
        return intersects(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new Iterator(affineTransform, this);
    }

    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new Iterator(affineTransform, this);
    }
}
