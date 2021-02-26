package harmony.java.awt.geom;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import harmony.java.awt.geom.Rectangle2D;
import java.util.NoSuchElementException;
import org.apache.harmony.awt.internal.nls.Messages;

public abstract class Ellipse2D extends RectangularShape {

    public static class Float extends Ellipse2D {
        public float height;
        public float width;

        /* renamed from: x */
        public float f4933x;

        /* renamed from: y */
        public float f4934y;

        public Float() {
        }

        public Float(float f, float f2, float f3, float f4) {
            setFrame(f, f2, f3, f4);
        }

        public double getX() {
            return (double) this.f4933x;
        }

        public double getY() {
            return (double) this.f4934y;
        }

        public double getWidth() {
            return (double) this.width;
        }

        public double getHeight() {
            return (double) this.height;
        }

        public boolean isEmpty() {
            return ((double) this.width) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || ((double) this.height) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        public void setFrame(float f, float f2, float f3, float f4) {
            this.f4933x = f;
            this.f4934y = f2;
            this.width = f3;
            this.height = f4;
        }

        public void setFrame(double d, double d2, double d3, double d4) {
            this.f4933x = (float) d;
            this.f4934y = (float) d2;
            this.width = (float) d3;
            this.height = (float) d4;
        }

        public Rectangle2D getBounds2D() {
            return new Rectangle2D.Float(this.f4933x, this.f4934y, this.width, this.height);
        }
    }

    public static class Double extends Ellipse2D {
        public double height;
        public double width;

        /* renamed from: x */
        public double f4931x;

        /* renamed from: y */
        public double f4932y;

        public Double() {
        }

        public Double(double d, double d2, double d3, double d4) {
            setFrame(d, d2, d3, d4);
        }

        public double getX() {
            return this.f4931x;
        }

        public double getY() {
            return this.f4932y;
        }

        public double getWidth() {
            return this.width;
        }

        public double getHeight() {
            return this.height;
        }

        public boolean isEmpty() {
            return this.width <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || this.height <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        public void setFrame(double d, double d2, double d3, double d4) {
            this.f4931x = d;
            this.f4932y = d2;
            this.width = d3;
            this.height = d4;
        }

        public Rectangle2D getBounds2D() {
            return new Rectangle2D.Double(this.f4931x, this.f4932y, this.width, this.height);
        }
    }

    class Iterator implements PathIterator {
        double height;
        int index;
        final double[][] points;

        /* renamed from: t */
        AffineTransform f4935t;
        final /* synthetic */ Ellipse2D this$0;

        /* renamed from: u */
        final double f4936u = ((Math.sqrt(2.0d) - 1.0d) * 0.6666666666666666d);
        double width;

        /* renamed from: x */
        double f4937x;

        /* renamed from: y */
        double f4938y;

        public int getWindingRule() {
            return 1;
        }

        Iterator(Ellipse2D ellipse2D, Ellipse2D ellipse2D2, AffineTransform affineTransform) {
            this.this$0 = ellipse2D;
            double d = this.f4936u;
            this.points = new double[][]{new double[]{1.0d, d + 0.5d, d + 0.5d, 1.0d, 0.5d, 1.0d}, new double[]{0.5d - d, 1.0d, 0.0d, d + 0.5d, 0.0d, 0.5d}, new double[]{0.0d, 0.5d - d, 0.5d - d, 0.0d, 0.5d, 0.0d}, new double[]{d + 0.5d, 0.0d, 1.0d, 0.5d - d, 1.0d, 0.5d}};
            this.f4937x = ellipse2D2.getX();
            this.f4938y = ellipse2D2.getY();
            this.width = ellipse2D2.getWidth();
            this.height = ellipse2D2.getHeight();
            this.f4935t = affineTransform;
            if (this.width < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || this.height < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.index = 6;
            }
        }

        public boolean isDone() {
            return this.index > 5;
        }

        public void next() {
            this.index++;
        }

        public int currentSegment(double[] dArr) {
            int i;
            if (!isDone()) {
                int i2 = this.index;
                if (i2 == 5) {
                    return 4;
                }
                int i3 = 0;
                if (i2 == 0) {
                    double[] dArr2 = this.points[3];
                    dArr[0] = this.f4937x + (dArr2[4] * this.width);
                    dArr[1] = this.f4938y + (dArr2[5] * this.height);
                    i = 1;
                } else {
                    double[] dArr3 = this.points[i2 - 1];
                    int i4 = 0;
                    while (i3 < 3) {
                        int i5 = i4 + 1;
                        dArr[i4] = this.f4937x + (dArr3[i4] * this.width);
                        i4 = i5 + 1;
                        dArr[i5] = this.f4938y + (dArr3[i5] * this.height);
                        i3++;
                    }
                    i3 = 3;
                    i = 3;
                }
                AffineTransform affineTransform = this.f4935t;
                if (affineTransform != null) {
                    affineTransform.transform(dArr, 0, dArr, 0, i);
                }
                return i3;
            }
            throw new NoSuchElementException(Messages.getString("awt.4B"));
        }

        public int currentSegment(float[] fArr) {
            int i;
            if (!isDone()) {
                int i2 = this.index;
                if (i2 == 5) {
                    return 4;
                }
                int i3 = 0;
                if (i2 == 0) {
                    double[] dArr = this.points[3];
                    fArr[0] = (float) (this.f4937x + (dArr[4] * this.width));
                    fArr[1] = (float) (this.f4938y + (dArr[5] * this.height));
                    i = 1;
                } else {
                    double[] dArr2 = this.points[i2 - 1];
                    int i4 = 0;
                    while (i3 < 3) {
                        int i5 = i4 + 1;
                        fArr[i4] = (float) (this.f4937x + (dArr2[i4] * this.width));
                        i4 = i5 + 1;
                        fArr[i5] = (float) (this.f4938y + (dArr2[i5] * this.height));
                        i3++;
                    }
                    i3 = 3;
                    i = 3;
                }
                AffineTransform affineTransform = this.f4935t;
                if (affineTransform != null) {
                    affineTransform.transform(fArr, 0, fArr, 0, i);
                }
                return i3;
            }
            throw new NoSuchElementException(Messages.getString("awt.4B"));
        }
    }

    protected Ellipse2D() {
    }

    public boolean contains(double d, double d2) {
        if (isEmpty()) {
            return false;
        }
        double x = ((d - getX()) / getWidth()) - 0.5d;
        double y = ((d2 - getY()) / getHeight()) - 0.5d;
        if ((x * x) + (y * y) < 0.25d) {
            return true;
        }
        return false;
    }

    public boolean intersects(double d, double d2, double d3, double d4) {
        if (isEmpty() || d3 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d4 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return false;
        }
        double x = getX() + (getWidth() / 2.0d);
        double y = getY() + (getHeight() / 2.0d);
        double d5 = d + d3;
        double d6 = d2 + d4;
        if (x < d) {
            x = d;
        } else if (x > d5) {
            x = d5;
        }
        if (y < d2) {
            d6 = d2;
        } else {
            if (y <= d6) {
                d6 = y;
            }
        }
        return contains(x, d6);
    }

    public boolean contains(double d, double d2, double d3, double d4) {
        if (!isEmpty() && d3 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            double d5 = d3 + d;
            double d6 = d4 + d2;
            if (!contains(d, d2) || !contains(d5, d2) || !contains(d5, d6) || !contains(d, d6)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new Iterator(this, this, affineTransform);
    }
}
