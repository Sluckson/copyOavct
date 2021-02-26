package harmony.java.awt.geom;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import harmony.java.awt.geom.Line2D;
import harmony.java.awt.geom.Point2D;
import harmony.java.awt.geom.Rectangle2D;
import org.apache.harmony.awt.internal.nls.Messages;

public abstract class Arc2D extends RectangularShape {
    public static final int CHORD = 1;
    public static final int OPEN = 0;
    public static final int PIE = 2;
    private int type;

    public abstract double getAngleExtent();

    public abstract double getAngleStart();

    /* access modifiers changed from: protected */
    public abstract Rectangle2D makeBounds(double d, double d2, double d3, double d4);

    public abstract void setAngleExtent(double d);

    public abstract void setAngleStart(double d);

    public abstract void setArc(double d, double d2, double d3, double d4, double d5, double d6, int i);

    public static class Float extends Arc2D {
        public float extent;
        public float height;
        public float start;
        public float width;

        /* renamed from: x */
        public float f4911x;

        /* renamed from: y */
        public float f4912y;

        public Float() {
            super(0);
        }

        public Float(int i) {
            super(i);
        }

        public Float(float f, float f2, float f3, float f4, float f5, float f6, int i) {
            super(i);
            this.f4911x = f;
            this.f4912y = f2;
            this.width = f3;
            this.height = f4;
            this.start = f5;
            this.extent = f6;
        }

        public Float(Rectangle2D rectangle2D, float f, float f2, int i) {
            super(i);
            this.f4911x = (float) rectangle2D.getX();
            this.f4912y = (float) rectangle2D.getY();
            this.width = (float) rectangle2D.getWidth();
            this.height = (float) rectangle2D.getHeight();
            this.start = f;
            this.extent = f2;
        }

        public double getX() {
            return (double) this.f4911x;
        }

        public double getY() {
            return (double) this.f4912y;
        }

        public double getWidth() {
            return (double) this.width;
        }

        public double getHeight() {
            return (double) this.height;
        }

        public double getAngleStart() {
            return (double) this.start;
        }

        public double getAngleExtent() {
            return (double) this.extent;
        }

        public boolean isEmpty() {
            return this.width <= 0.0f || this.height <= 0.0f;
        }

        public void setArc(double d, double d2, double d3, double d4, double d5, double d6, int i) {
            setArcType(i);
            this.f4911x = (float) d;
            this.f4912y = (float) d2;
            this.width = (float) d3;
            this.height = (float) d4;
            this.start = (float) d5;
            this.extent = (float) d6;
        }

        public void setAngleStart(double d) {
            this.start = (float) d;
        }

        public void setAngleExtent(double d) {
            this.extent = (float) d;
        }

        /* access modifiers changed from: protected */
        public Rectangle2D makeBounds(double d, double d2, double d3, double d4) {
            return new Rectangle2D.Float((float) d, (float) d2, (float) d3, (float) d4);
        }
    }

    public static class Double extends Arc2D {
        public double extent;
        public double height;
        public double start;
        public double width;

        /* renamed from: x */
        public double f4909x;

        /* renamed from: y */
        public double f4910y;

        public Double() {
            super(0);
        }

        public Double(int i) {
            super(i);
        }

        public Double(double d, double d2, double d3, double d4, double d5, double d6, int i) {
            super(i);
            this.f4909x = d;
            this.f4910y = d2;
            this.width = d3;
            this.height = d4;
            this.start = d5;
            this.extent = d6;
        }

        public Double(Rectangle2D rectangle2D, double d, double d2, int i) {
            super(i);
            this.f4909x = rectangle2D.getX();
            this.f4910y = rectangle2D.getY();
            this.width = rectangle2D.getWidth();
            this.height = rectangle2D.getHeight();
            this.start = d;
            this.extent = d2;
        }

        public double getX() {
            return this.f4909x;
        }

        public double getY() {
            return this.f4910y;
        }

        public double getWidth() {
            return this.width;
        }

        public double getHeight() {
            return this.height;
        }

        public double getAngleStart() {
            return this.start;
        }

        public double getAngleExtent() {
            return this.extent;
        }

        public boolean isEmpty() {
            return this.width <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || this.height <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        public void setArc(double d, double d2, double d3, double d4, double d5, double d6, int i) {
            setArcType(i);
            this.f4909x = d;
            this.f4910y = d2;
            this.width = d3;
            this.height = d4;
            this.start = d5;
            this.extent = d6;
        }

        public void setAngleStart(double d) {
            this.start = d;
        }

        public void setAngleExtent(double d) {
            this.extent = d;
        }

        /* access modifiers changed from: protected */
        public Rectangle2D makeBounds(double d, double d2, double d3, double d4) {
            return new Rectangle2D.Double(d, d2, d3, d4);
        }
    }

    class Iterator implements PathIterator {
        double angle;
        int arcCount;
        double cos;
        double extent;
        double height;
        int index;

        /* renamed from: k */
        double f4913k;

        /* renamed from: kx */
        double f4914kx;

        /* renamed from: ky */
        double f4915ky;
        int lineCount;

        /* renamed from: mx */
        double f4916mx;

        /* renamed from: my */
        double f4917my;
        double sin;
        double step;

        /* renamed from: t */
        AffineTransform f4918t;
        int type;
        double width;

        /* renamed from: x */
        double f4919x;

        /* renamed from: y */
        double f4920y;

        public int getWindingRule() {
            return 1;
        }

        Iterator(Arc2D arc2D, AffineTransform affineTransform) {
            if (this.width < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || this.height < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.arcCount = 0;
                this.lineCount = 0;
                this.index = 1;
                return;
            }
            this.width = arc2D.getWidth() / 2.0d;
            this.height = arc2D.getHeight() / 2.0d;
            this.f4919x = arc2D.getX() + this.width;
            this.f4920y = arc2D.getY() + this.height;
            this.angle = -Math.toRadians(arc2D.getAngleStart());
            this.extent = -arc2D.getAngleExtent();
            this.type = arc2D.getArcType();
            this.f4918t = affineTransform;
            if (Math.abs(this.extent) >= 360.0d) {
                this.arcCount = 4;
                this.f4913k = (Math.sqrt(2.0d) - 1.0d) * 1.3333333333333333d;
                this.step = 1.5707963267948966d;
                if (this.extent < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    this.step = -this.step;
                    this.f4913k = -this.f4913k;
                }
            } else {
                this.arcCount = (int) Math.rint(Math.abs(this.extent) / 90.0d);
                this.step = Math.toRadians(this.extent / ((double) this.arcCount));
                this.f4913k = ((1.0d - Math.cos(this.step / 2.0d)) * 1.3333333333333333d) / Math.sin(this.step / 2.0d);
            }
            this.lineCount = 0;
            int i = this.type;
            if (i == 1) {
                this.lineCount++;
            } else if (i == 2) {
                this.lineCount += 2;
            }
        }

        public boolean isDone() {
            return this.index > this.arcCount + this.lineCount;
        }

        public void next() {
            this.index++;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x00c3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int currentSegment(double[] r14) {
            /*
                r13 = this;
                boolean r0 = r13.isDone()
                if (r0 != 0) goto L_0x00cb
                int r0 = r13.index
                r1 = 4
                r2 = 3
                r3 = 0
                r4 = 1
                if (r0 != 0) goto L_0x004a
                double r0 = r13.angle
                double r0 = java.lang.Math.cos(r0)
                r13.cos = r0
                double r0 = r13.angle
                double r0 = java.lang.Math.sin(r0)
                r13.sin = r0
                double r0 = r13.f4913k
                double r5 = r13.width
                double r7 = r0 * r5
                double r9 = r13.sin
                double r7 = r7 * r9
                r13.f4914kx = r7
                double r7 = r13.height
                double r0 = r0 * r7
                double r11 = r13.cos
                double r0 = r0 * r11
                r13.f4915ky = r0
                double r0 = r13.f4919x
                double r11 = r11 * r5
                double r0 = r0 + r11
                r13.f4916mx = r0
                r14[r3] = r0
                double r0 = r13.f4920y
                double r9 = r9 * r7
                double r0 = r0 + r9
                r13.f4917my = r0
                r14[r4] = r0
                r1 = 0
            L_0x0047:
                r10 = 1
                goto L_0x00bf
            L_0x004a:
                int r5 = r13.arcCount
                if (r0 > r5) goto L_0x00ae
                double r5 = r13.f4916mx
                double r7 = r13.f4914kx
                double r5 = r5 - r7
                r14[r3] = r5
                double r5 = r13.f4917my
                double r7 = r13.f4915ky
                double r5 = r5 + r7
                r14[r4] = r5
                double r3 = r13.angle
                double r5 = r13.step
                double r3 = r3 + r5
                r13.angle = r3
                double r3 = r13.angle
                double r3 = java.lang.Math.cos(r3)
                r13.cos = r3
                double r3 = r13.angle
                double r3 = java.lang.Math.sin(r3)
                r13.sin = r3
                double r3 = r13.f4913k
                double r5 = r13.width
                double r7 = r3 * r5
                double r9 = r13.sin
                double r7 = r7 * r9
                r13.f4914kx = r7
                double r7 = r13.height
                double r3 = r3 * r7
                double r11 = r13.cos
                double r3 = r3 * r11
                r13.f4915ky = r3
                double r3 = r13.f4919x
                double r11 = r11 * r5
                double r3 = r3 + r11
                r13.f4916mx = r3
                r14[r1] = r3
                r0 = 5
                double r3 = r13.f4920y
                double r9 = r9 * r7
                double r3 = r3 + r9
                r13.f4917my = r3
                r14[r0] = r3
                r0 = 2
                double r3 = r13.f4916mx
                double r5 = r13.f4914kx
                double r3 = r3 + r5
                r14[r0] = r3
                double r0 = r13.f4917my
                double r3 = r13.f4915ky
                double r0 = r0 - r3
                r14[r2] = r0
                r1 = 3
                r10 = 3
                goto L_0x00bf
            L_0x00ae:
                int r2 = r13.lineCount
                int r5 = r5 + r2
                if (r0 != r5) goto L_0x00b5
                r10 = 0
                goto L_0x00bf
            L_0x00b5:
                double r0 = r13.f4919x
                r14[r3] = r0
                double r0 = r13.f4920y
                r14[r4] = r0
                r1 = 1
                goto L_0x0047
            L_0x00bf:
                harmony.java.awt.geom.AffineTransform r5 = r13.f4918t
                if (r5 == 0) goto L_0x00ca
                r7 = 0
                r9 = 0
                r6 = r14
                r8 = r14
                r5.transform((double[]) r6, (int) r7, (double[]) r8, (int) r9, (int) r10)
            L_0x00ca:
                return r1
            L_0x00cb:
                java.util.NoSuchElementException r14 = new java.util.NoSuchElementException
                java.lang.String r0 = "awt.4B"
                java.lang.String r0 = org.apache.harmony.awt.internal.nls.Messages.getString(r0)
                r14.<init>(r0)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: harmony.java.awt.geom.Arc2D.Iterator.currentSegment(double[]):int");
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x00cd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int currentSegment(float[] r14) {
            /*
                r13 = this;
                boolean r0 = r13.isDone()
                if (r0 != 0) goto L_0x00d5
                int r0 = r13.index
                r1 = 4
                r2 = 3
                r3 = 0
                r4 = 1
                if (r0 != 0) goto L_0x004c
                double r0 = r13.angle
                double r0 = java.lang.Math.cos(r0)
                r13.cos = r0
                double r0 = r13.angle
                double r0 = java.lang.Math.sin(r0)
                r13.sin = r0
                double r0 = r13.f4913k
                double r5 = r13.width
                double r7 = r0 * r5
                double r9 = r13.sin
                double r7 = r7 * r9
                r13.f4914kx = r7
                double r7 = r13.height
                double r0 = r0 * r7
                double r11 = r13.cos
                double r0 = r0 * r11
                r13.f4915ky = r0
                double r0 = r13.f4919x
                double r11 = r11 * r5
                double r0 = r0 + r11
                r13.f4916mx = r0
                float r0 = (float) r0
                r14[r3] = r0
                double r0 = r13.f4920y
                double r9 = r9 * r7
                double r0 = r0 + r9
                r13.f4917my = r0
                float r0 = (float) r0
                r14[r4] = r0
                r1 = 0
            L_0x0049:
                r10 = 1
                goto L_0x00c9
            L_0x004c:
                int r5 = r13.arcCount
                if (r0 > r5) goto L_0x00b6
                double r5 = r13.f4916mx
                double r7 = r13.f4914kx
                double r5 = r5 - r7
                float r0 = (float) r5
                r14[r3] = r0
                double r5 = r13.f4917my
                double r7 = r13.f4915ky
                double r5 = r5 + r7
                float r0 = (float) r5
                r14[r4] = r0
                double r3 = r13.angle
                double r5 = r13.step
                double r3 = r3 + r5
                r13.angle = r3
                double r3 = r13.angle
                double r3 = java.lang.Math.cos(r3)
                r13.cos = r3
                double r3 = r13.angle
                double r3 = java.lang.Math.sin(r3)
                r13.sin = r3
                double r3 = r13.f4913k
                double r5 = r13.width
                double r7 = r3 * r5
                double r9 = r13.sin
                double r7 = r7 * r9
                r13.f4914kx = r7
                double r7 = r13.height
                double r3 = r3 * r7
                double r11 = r13.cos
                double r3 = r3 * r11
                r13.f4915ky = r3
                double r3 = r13.f4919x
                double r11 = r11 * r5
                double r3 = r3 + r11
                r13.f4916mx = r3
                float r0 = (float) r3
                r14[r1] = r0
                r0 = 5
                double r3 = r13.f4920y
                double r9 = r9 * r7
                double r3 = r3 + r9
                r13.f4917my = r3
                float r1 = (float) r3
                r14[r0] = r1
                r0 = 2
                double r3 = r13.f4916mx
                double r5 = r13.f4914kx
                double r3 = r3 + r5
                float r1 = (float) r3
                r14[r0] = r1
                double r0 = r13.f4917my
                double r3 = r13.f4915ky
                double r0 = r0 - r3
                float r0 = (float) r0
                r14[r2] = r0
                r1 = 3
                r10 = 3
                goto L_0x00c9
            L_0x00b6:
                int r2 = r13.lineCount
                int r5 = r5 + r2
                if (r0 != r5) goto L_0x00bd
                r10 = 0
                goto L_0x00c9
            L_0x00bd:
                double r0 = r13.f4919x
                float r0 = (float) r0
                r14[r3] = r0
                double r0 = r13.f4920y
                float r0 = (float) r0
                r14[r4] = r0
                r1 = 1
                goto L_0x0049
            L_0x00c9:
                harmony.java.awt.geom.AffineTransform r5 = r13.f4918t
                if (r5 == 0) goto L_0x00d4
                r7 = 0
                r9 = 0
                r6 = r14
                r8 = r14
                r5.transform((float[]) r6, (int) r7, (float[]) r8, (int) r9, (int) r10)
            L_0x00d4:
                return r1
            L_0x00d5:
                java.util.NoSuchElementException r14 = new java.util.NoSuchElementException
                java.lang.String r0 = "awt.4B"
                java.lang.String r0 = org.apache.harmony.awt.internal.nls.Messages.getString(r0)
                r14.<init>(r0)
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: harmony.java.awt.geom.Arc2D.Iterator.currentSegment(float[]):int");
        }
    }

    protected Arc2D(int i) {
        setArcType(i);
    }

    public int getArcType() {
        return this.type;
    }

    public void setArcType(int i) {
        if (i == 0 || i == 1 || i == 2) {
            this.type = i;
            return;
        }
        throw new IllegalArgumentException(Messages.getString("awt.205", i));
    }

    public Point2D getStartPoint() {
        double radians = Math.toRadians(getAngleStart());
        return new Point2D.Double(getX() + (((Math.cos(radians) + 1.0d) * getWidth()) / 2.0d), getY() + (((1.0d - Math.sin(radians)) * getHeight()) / 2.0d));
    }

    public Point2D getEndPoint() {
        double radians = Math.toRadians(getAngleStart() + getAngleExtent());
        return new Point2D.Double(getX() + (((Math.cos(radians) + 1.0d) * getWidth()) / 2.0d), getY() + (((1.0d - Math.sin(radians)) * getHeight()) / 2.0d));
    }

    public Rectangle2D getBounds2D() {
        if (isEmpty()) {
            return makeBounds(getX(), getY(), getWidth(), getHeight());
        }
        double x = getX();
        double y = getY();
        double width = getWidth() + x;
        double height = getHeight() + y;
        Point2D startPoint = getStartPoint();
        Point2D endPoint = getEndPoint();
        if (!containsAngle(180.0d)) {
            x = Math.min(startPoint.getX(), endPoint.getX());
        }
        if (!containsAngle(90.0d)) {
            y = Math.min(startPoint.getY(), endPoint.getY());
        }
        if (!containsAngle(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) {
            width = Math.max(startPoint.getX(), endPoint.getX());
        }
        if (!containsAngle(270.0d)) {
            height = Math.max(startPoint.getY(), endPoint.getY());
        }
        if (this.type == 2) {
            double centerX = getCenterX();
            double centerY = getCenterY();
            x = Math.min(x, centerX);
            y = Math.min(y, centerY);
            width = Math.max(width, centerX);
            height = Math.max(height, centerY);
        }
        double d = y;
        double d2 = x;
        return makeBounds(d2, d, width - d2, height - d);
    }

    public void setFrame(double d, double d2, double d3, double d4) {
        setArc(d, d2, d3, d4, getAngleStart(), getAngleExtent(), this.type);
    }

    public void setArc(Point2D point2D, Dimension2D dimension2D, double d, double d2, int i) {
        setArc(point2D.getX(), point2D.getY(), dimension2D.getWidth(), dimension2D.getHeight(), d, d2, i);
    }

    public void setArc(Rectangle2D rectangle2D, double d, double d2, int i) {
        setArc(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight(), d, d2, i);
    }

    public void setArc(Arc2D arc2D) {
        setArc(arc2D.getX(), arc2D.getY(), arc2D.getWidth(), arc2D.getHeight(), arc2D.getAngleStart(), arc2D.getAngleExtent(), arc2D.getArcType());
    }

    public void setArcByCenter(double d, double d2, double d3, double d4, double d5, int i) {
        double d6 = d3 * 2.0d;
        setArc(d - d3, d2 - d3, d6, d6, d4, d5, i);
    }

    public void setArcByTangent(Point2D point2D, Point2D point2D2, Point2D point2D3, double d) {
        double d2 = -Math.atan2(point2D.getY() - point2D2.getY(), point2D.getX() - point2D2.getX());
        double d3 = ((-Math.atan2(point2D3.getY() - point2D2.getY(), point2D3.getX() - point2D2.getX())) + d2) / 2.0d;
        double d4 = d2 - d3;
        double abs = d / Math.abs(Math.sin(d4));
        double x = point2D2.getX() + (Math.cos(d3) * abs);
        double y = point2D2.getY() - (abs * Math.sin(d3));
        double d5 = (d4 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 4.71238898038469d : 1.5707963267948966d) - d4;
        double normAngle = getNormAngle(Math.toDegrees(d3 - d5));
        double normAngle2 = getNormAngle(Math.toDegrees(d3 + d5)) - normAngle;
        if (normAngle2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            normAngle2 += 360.0d;
        }
        setArcByCenter(x, y, d, normAngle, normAngle2, this.type);
    }

    public void setAngleStart(Point2D point2D) {
        setAngleStart(getNormAngle(-Math.toDegrees(Math.atan2(point2D.getY() - getCenterY(), point2D.getX() - getCenterX()))));
    }

    public void setAngles(double d, double d2, double d3, double d4) {
        double centerX = getCenterX();
        double centerY = getCenterY();
        double normAngle = getNormAngle(-Math.toDegrees(Math.atan2(d2 - centerY, d - centerX)));
        double normAngle2 = getNormAngle(-Math.toDegrees(Math.atan2(d4 - centerY, d3 - centerX))) - normAngle;
        if (normAngle2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            normAngle2 += 360.0d;
        }
        setAngleStart(normAngle);
        setAngleExtent(normAngle2);
    }

    public void setAngles(Point2D point2D, Point2D point2D2) {
        setAngles(point2D.getX(), point2D.getY(), point2D2.getX(), point2D2.getY());
    }

    /* access modifiers changed from: package-private */
    public double getNormAngle(double d) {
        return d - (Math.floor(d / 360.0d) * 360.0d);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0054 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsAngle(double r14) {
        /*
            r13 = this;
            double r0 = r13.getAngleExtent()
            r2 = 4645040803167600640(0x4076800000000000, double:360.0)
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x000f
            return r4
        L_0x000f:
            double r14 = r13.getNormAngle(r14)
            double r5 = r13.getAngleStart()
            double r5 = r13.getNormAngle(r5)
            double r7 = r5 + r0
            r9 = 0
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 <= 0) goto L_0x002d
            int r0 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x002c
            double r7 = r7 - r2
            int r0 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x002c
            return r9
        L_0x002c:
            return r4
        L_0x002d:
            r10 = 0
            int r12 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x003e
            double r7 = r7 + r2
            int r0 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x003d
            int r0 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x003d
            return r9
        L_0x003d:
            return r4
        L_0x003e:
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x004b
            int r0 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x0054
            int r0 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x0054
            goto L_0x0055
        L_0x004b:
            int r0 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x0054
            int r0 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r4 = 0
        L_0x0055:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: harmony.java.awt.geom.Arc2D.containsAngle(double):boolean");
    }

    public boolean contains(double d, double d2) {
        double x = ((d - getX()) / getWidth()) - 0.5d;
        double y = ((d2 - getY()) / getHeight()) - 0.5d;
        if ((x * x) + (y * y) > 0.25d) {
            return false;
        }
        double abs = Math.abs(getAngleExtent());
        if (abs >= 360.0d) {
            return true;
        }
        boolean containsAngle = containsAngle(Math.toDegrees(-Math.atan2(y, x)));
        if (this.type == 2) {
            return containsAngle;
        }
        if (abs <= 180.0d && !containsAngle) {
            return false;
        }
        Line2D.Double doubleR = new Line2D.Double(getStartPoint(), getEndPoint());
        int relativeCCW = doubleR.relativeCCW(d, d2);
        int relativeCCW2 = doubleR.relativeCCW(getCenterX(), getCenterY());
        if (!(relativeCCW == 0 || relativeCCW2 == 0)) {
            if (!((relativeCCW + relativeCCW2 == 0) ^ (abs > 180.0d))) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(double d, double d2, double d3, double d4) {
        double d5 = d;
        double d6 = d2;
        if (contains(d, d2)) {
            double d7 = d5 + d3;
            if (contains(d7, d6)) {
                double d8 = d6 + d4;
                if (contains(d7, d8) && contains(d5, d8)) {
                    double abs = Math.abs(getAngleExtent());
                    if (this.type != 2 || abs <= 180.0d || abs >= 360.0d) {
                        return true;
                    }
                    Rectangle2D.Double doubleR = new Rectangle2D.Double(d, d2, d3, d4);
                    double centerX = getCenterX();
                    double centerY = getCenterY();
                    if (doubleR.contains(centerX, centerY)) {
                        return false;
                    }
                    Point2D startPoint = getStartPoint();
                    Point2D endPoint = getEndPoint();
                    double x = startPoint.getX();
                    double y = startPoint.getY();
                    Rectangle2D.Double doubleR2 = doubleR;
                    if (!doubleR.intersectsLine(centerX, centerY, x, y)) {
                        if (!doubleR2.intersectsLine(centerX, centerY, endPoint.getX(), endPoint.getY())) {
                            return true;
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public boolean contains(Rectangle2D rectangle2D) {
        return contains(rectangle2D.getX(), rectangle2D.getY(), rectangle2D.getWidth(), rectangle2D.getHeight());
    }

    public boolean intersects(double d, double d2, double d3, double d4) {
        double d5;
        double d6 = d;
        double d7 = d2;
        if (isEmpty() || d3 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d4 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return false;
        }
        if (contains(d, d2)) {
            return true;
        }
        double d8 = d6 + d3;
        if (contains(d8, d7)) {
            return true;
        }
        double d9 = d7 + d4;
        if (contains(d6, d9) || contains(d8, d9)) {
            return true;
        }
        double centerX = getCenterX();
        double centerY = getCenterY();
        Point2D startPoint = getStartPoint();
        Point2D endPoint = getEndPoint();
        double d10 = centerY;
        double d11 = centerX;
        double d12 = d9;
        double d13 = d8;
        Rectangle2D.Double doubleR = new Rectangle2D.Double(d, d2, d3, d4);
        if (doubleR.contains(startPoint) || doubleR.contains(endPoint)) {
            return true;
        }
        if (this.type == 2) {
            d5 = d10;
            if (doubleR.contains(d11, d5)) {
                return true;
            }
        } else {
            d5 = d10;
        }
        if (this.type == 2) {
            if (doubleR.intersectsLine(startPoint.getX(), startPoint.getY(), d11, d5)) {
                return true;
            }
            if (doubleR.intersectsLine(endPoint.getX(), endPoint.getY(), d11, d5)) {
                return true;
            }
        } else {
            if (doubleR.intersectsLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY())) {
                return true;
            }
        }
        double d14 = d5;
        if (d11 < d) {
            d11 = d;
        } else if (d11 > d13) {
            d11 = d13;
        }
        if (d14 < d2) {
            d14 = d2;
        } else if (d14 > d12) {
            d14 = d12;
        }
        return contains(d11, d14);
    }

    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new Iterator(this, affineTransform);
    }
}
