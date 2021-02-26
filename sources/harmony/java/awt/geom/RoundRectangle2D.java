package harmony.java.awt.geom;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import harmony.java.awt.geom.Rectangle2D;
import java.util.NoSuchElementException;
import org.apache.harmony.awt.internal.nls.Messages;

public abstract class RoundRectangle2D extends RectangularShape {
    public abstract double getArcHeight();

    public abstract double getArcWidth();

    public abstract void setRoundRect(double d, double d2, double d3, double d4, double d5, double d6);

    public static class Float extends RoundRectangle2D {
        public float archeight;
        public float arcwidth;
        public float height;
        public float width;

        /* renamed from: x */
        public float f4980x;

        /* renamed from: y */
        public float f4981y;

        public Float() {
        }

        public Float(float f, float f2, float f3, float f4, float f5, float f6) {
            setRoundRect(f, f2, f3, f4, f5, f6);
        }

        public double getX() {
            return (double) this.f4980x;
        }

        public double getY() {
            return (double) this.f4981y;
        }

        public double getWidth() {
            return (double) this.width;
        }

        public double getHeight() {
            return (double) this.height;
        }

        public double getArcWidth() {
            return (double) this.arcwidth;
        }

        public double getArcHeight() {
            return (double) this.archeight;
        }

        public boolean isEmpty() {
            return this.width <= 0.0f || this.height <= 0.0f;
        }

        public void setRoundRect(float f, float f2, float f3, float f4, float f5, float f6) {
            this.f4980x = f;
            this.f4981y = f2;
            this.width = f3;
            this.height = f4;
            this.arcwidth = f5;
            this.archeight = f6;
        }

        public void setRoundRect(double d, double d2, double d3, double d4, double d5, double d6) {
            this.f4980x = (float) d;
            this.f4981y = (float) d2;
            this.width = (float) d3;
            this.height = (float) d4;
            this.arcwidth = (float) d5;
            this.archeight = (float) d6;
        }

        public void setRoundRect(RoundRectangle2D roundRectangle2D) {
            this.f4980x = (float) roundRectangle2D.getX();
            this.f4981y = (float) roundRectangle2D.getY();
            this.width = (float) roundRectangle2D.getWidth();
            this.height = (float) roundRectangle2D.getHeight();
            this.arcwidth = (float) roundRectangle2D.getArcWidth();
            this.archeight = (float) roundRectangle2D.getArcHeight();
        }

        public Rectangle2D getBounds2D() {
            return new Rectangle2D.Float(this.f4980x, this.f4981y, this.width, this.height);
        }
    }

    public static class Double extends RoundRectangle2D {
        public double archeight;
        public double arcwidth;
        public double height;
        public double width;

        /* renamed from: x */
        public double f4978x;

        /* renamed from: y */
        public double f4979y;

        public Double() {
        }

        public Double(double d, double d2, double d3, double d4, double d5, double d6) {
            setRoundRect(d, d2, d3, d4, d5, d6);
        }

        public double getX() {
            return this.f4978x;
        }

        public double getY() {
            return this.f4979y;
        }

        public double getWidth() {
            return this.width;
        }

        public double getHeight() {
            return this.height;
        }

        public double getArcWidth() {
            return this.arcwidth;
        }

        public double getArcHeight() {
            return this.archeight;
        }

        public boolean isEmpty() {
            return this.width <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || this.height <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        public void setRoundRect(double d, double d2, double d3, double d4, double d5, double d6) {
            this.f4978x = d;
            this.f4979y = d2;
            this.width = d3;
            this.height = d4;
            this.arcwidth = d5;
            this.archeight = d6;
        }

        public void setRoundRect(RoundRectangle2D roundRectangle2D) {
            this.f4978x = roundRectangle2D.getX();
            this.f4979y = roundRectangle2D.getY();
            this.width = roundRectangle2D.getWidth();
            this.height = roundRectangle2D.getHeight();
            this.arcwidth = roundRectangle2D.getArcWidth();
            this.archeight = roundRectangle2D.getArcHeight();
        }

        public Rectangle2D getBounds2D() {
            return new Rectangle2D.Double(this.f4978x, this.f4979y, this.width, this.height);
        }
    }

    class Iterator implements PathIterator {

        /* renamed from: ah */
        double f4982ah;

        /* renamed from: aw */
        double f4983aw;
        double height;
        int index;
        double[][] points;

        /* renamed from: t */
        AffineTransform f4984t;
        final /* synthetic */ RoundRectangle2D this$0;
        int[] types;

        /* renamed from: u */
        double f4985u = (0.5d - ((Math.sqrt(2.0d) - 1.0d) * 0.6666666666666666d));
        double width;

        /* renamed from: x */
        double f4986x;

        /* renamed from: y */
        double f4987y;

        public int getWindingRule() {
            return 1;
        }

        Iterator(RoundRectangle2D roundRectangle2D, RoundRectangle2D roundRectangle2D2, AffineTransform affineTransform) {
            this.this$0 = roundRectangle2D;
            double d = this.f4985u;
            this.points = new double[][]{new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0.5d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE}, new double[]{1.0d, -0.5d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE}, new double[]{1.0d, -d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, d, 1.0d, 0.0d, 0.0d, 0.5d}, new double[]{1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, -0.5d}, new double[]{1.0d, 0.0d, 1.0d, -d, 1.0d, -d, 1.0d, 0.0d, 1.0d, -0.5d, 1.0d, 0.0d}, new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0.5d, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE}, new double[]{0.0d, d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, -d, 0.0d, 0.0d, 1.0d, -0.5d}, new double[]{FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0.5d}, new double[]{0.0d, 0.0d, 0.0d, d, 0.0d, d, 0.0d, 0.0d, 0.0d, 0.5d, 0.0d, 0.0d}};
            int[] iArr = new int[9];
            iArr[1] = 1;
            iArr[2] = 3;
            iArr[3] = 1;
            iArr[4] = 3;
            iArr[5] = 1;
            iArr[6] = 3;
            iArr[7] = 1;
            iArr[8] = 3;
            this.types = iArr;
            this.f4986x = roundRectangle2D2.getX();
            this.f4987y = roundRectangle2D2.getY();
            this.width = roundRectangle2D2.getWidth();
            this.height = roundRectangle2D2.getHeight();
            this.f4983aw = Math.min(this.width, roundRectangle2D2.getArcWidth());
            this.f4982ah = Math.min(this.height, roundRectangle2D2.getArcHeight());
            this.f4984t = affineTransform;
            if (this.width < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || this.height < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || this.f4983aw < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || this.f4982ah < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.index = this.points.length;
            }
        }

        public boolean isDone() {
            return this.index > this.points.length;
        }

        public void next() {
            this.index++;
        }

        public int currentSegment(double[] dArr) {
            if (!isDone()) {
                int i = this.index;
                double[][] dArr2 = this.points;
                if (i == dArr2.length) {
                    return 4;
                }
                double[] dArr3 = dArr2[i];
                int i2 = 0;
                for (int i3 = 0; i3 < dArr3.length; i3 += 4) {
                    int i4 = i2 + 1;
                    dArr[i2] = this.f4986x + (dArr3[i3 + 0] * this.width) + (dArr3[i3 + 1] * this.f4983aw);
                    i2 = i4 + 1;
                    dArr[i4] = this.f4987y + (dArr3[i3 + 2] * this.height) + (dArr3[i3 + 3] * this.f4982ah);
                }
                AffineTransform affineTransform = this.f4984t;
                if (affineTransform != null) {
                    affineTransform.transform(dArr, 0, dArr, 0, i2 / 2);
                }
                return this.types[this.index];
            }
            throw new NoSuchElementException(Messages.getString("awt.4B"));
        }

        public int currentSegment(float[] fArr) {
            if (!isDone()) {
                int i = this.index;
                double[][] dArr = this.points;
                if (i == dArr.length) {
                    return 4;
                }
                double[] dArr2 = dArr[i];
                int i2 = 0;
                for (int i3 = 0; i3 < dArr2.length; i3 += 4) {
                    int i4 = i2 + 1;
                    fArr[i2] = (float) (this.f4986x + (dArr2[i3 + 0] * this.width) + (dArr2[i3 + 1] * this.f4983aw));
                    i2 = i4 + 1;
                    fArr[i4] = (float) (this.f4987y + (dArr2[i3 + 2] * this.height) + (dArr2[i3 + 3] * this.f4982ah));
                }
                AffineTransform affineTransform = this.f4984t;
                if (affineTransform != null) {
                    affineTransform.transform(fArr, 0, fArr, 0, i2 / 2);
                }
                return this.types[this.index];
            }
            throw new NoSuchElementException(Messages.getString("awt.4B"));
        }
    }

    protected RoundRectangle2D() {
    }

    public void setRoundRect(RoundRectangle2D roundRectangle2D) {
        setRoundRect(roundRectangle2D.getX(), roundRectangle2D.getY(), roundRectangle2D.getWidth(), roundRectangle2D.getHeight(), roundRectangle2D.getArcWidth(), roundRectangle2D.getArcHeight());
    }

    public void setFrame(double d, double d2, double d3, double d4) {
        setRoundRect(d, d2, d3, d4, getArcWidth(), getArcHeight());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r17 > r2) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r19 > r4) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0063, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean contains(double r17, double r19) {
        /*
            r16 = this;
            boolean r0 = r16.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            double r2 = r16.getX()
            double r4 = r16.getY()
            double r6 = r16.getWidth()
            double r6 = r6 + r2
            double r8 = r16.getHeight()
            double r8 = r8 + r4
            int r0 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0064
            int r0 = (r17 > r6 ? 1 : (r17 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0064
            int r0 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x0064
            int r0 = (r19 > r8 ? 1 : (r19 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x002b
            goto L_0x0064
        L_0x002b:
            double r10 = r16.getArcWidth()
            r12 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r10 = r10 / r12
            double r14 = r16.getArcHeight()
            double r14 = r14 / r12
            double r2 = r2 + r10
            r0 = 1
            int r12 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x003e
            goto L_0x0044
        L_0x003e:
            double r2 = r6 - r10
            int r6 = (r17 > r2 ? 1 : (r17 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0063
        L_0x0044:
            double r4 = r4 + r14
            int r6 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x004a
            goto L_0x0050
        L_0x004a:
            double r4 = r8 - r14
            int r6 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0063
        L_0x0050:
            double r2 = r17 - r2
            double r2 = r2 / r10
            double r4 = r19 - r4
            double r4 = r4 / r14
            double r2 = r2 * r2
            double r4 = r4 * r4
            double r2 = r2 + r4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0062
            return r0
        L_0x0062:
            return r1
        L_0x0063:
            return r0
        L_0x0064:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: harmony.java.awt.geom.RoundRectangle2D.contains(double, double):boolean");
    }

    public boolean intersects(double d, double d2, double d3, double d4) {
        if (isEmpty() || d3 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d4 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return false;
        }
        double x = getX();
        double y = getY();
        double width = getWidth() + x;
        double height = getHeight() + y;
        double d5 = d + d3;
        double d6 = d2 + d4;
        if (d5 < x || width < d || d6 < y || height < d2) {
            return false;
        }
        double d7 = (x + width) / 2.0d;
        double d8 = (y + height) / 2.0d;
        if (d7 < d) {
            d5 = d;
        } else if (d7 <= d5) {
            d5 = d7;
        }
        if (d8 < d2) {
            d6 = d2;
        } else {
            if (d8 <= d6) {
                d6 = d8;
            }
        }
        return contains(d5, d6);
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
