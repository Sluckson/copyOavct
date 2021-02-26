package harmony.java.awt.geom;

import org.apache.harmony.misc.HashCode;

public abstract class Point2D implements Cloneable {
    public static double distanceSq(double d, double d2, double d3, double d4) {
        double d5 = d3 - d;
        double d6 = d4 - d2;
        return (d5 * d5) + (d6 * d6);
    }

    public abstract double getX();

    public abstract double getY();

    public abstract void setLocation(double d, double d2);

    public static class Float extends Point2D {

        /* renamed from: x */
        public float f4959x;

        /* renamed from: y */
        public float f4960y;

        public Float() {
        }

        public Float(float f, float f2) {
            this.f4959x = f;
            this.f4960y = f2;
        }

        public double getX() {
            return (double) this.f4959x;
        }

        public double getY() {
            return (double) this.f4960y;
        }

        public void setLocation(float f, float f2) {
            this.f4959x = f;
            this.f4960y = f2;
        }

        public void setLocation(double d, double d2) {
            this.f4959x = (float) d;
            this.f4960y = (float) d2;
        }

        public String toString() {
            return String.valueOf(getClass().getName()) + "[x=" + this.f4959x + ",y=" + this.f4960y + "]";
        }
    }

    public static class Double extends Point2D {

        /* renamed from: x */
        public double f4957x;

        /* renamed from: y */
        public double f4958y;

        public Double() {
        }

        public Double(double d, double d2) {
            this.f4957x = d;
            this.f4958y = d2;
        }

        public double getX() {
            return this.f4957x;
        }

        public double getY() {
            return this.f4958y;
        }

        public void setLocation(double d, double d2) {
            this.f4957x = d;
            this.f4958y = d2;
        }

        public String toString() {
            return String.valueOf(getClass().getName()) + "[x=" + this.f4957x + ",y=" + this.f4958y + "]";
        }
    }

    protected Point2D() {
    }

    public void setLocation(Point2D point2D) {
        setLocation(point2D.getX(), point2D.getY());
    }

    public double distanceSq(double d, double d2) {
        return distanceSq(getX(), getY(), d, d2);
    }

    public double distanceSq(Point2D point2D) {
        return distanceSq(getX(), getY(), point2D.getX(), point2D.getY());
    }

    public static double distance(double d, double d2, double d3, double d4) {
        return Math.sqrt(distanceSq(d, d2, d3, d4));
    }

    public double distance(double d, double d2) {
        return Math.sqrt(distanceSq(d, d2));
    }

    public double distance(Point2D point2D) {
        return Math.sqrt(distanceSq(point2D));
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int hashCode() {
        HashCode hashCode = new HashCode();
        hashCode.append(getX());
        hashCode.append(getY());
        return hashCode.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Point2D) {
            Point2D point2D = (Point2D) obj;
            return getX() == point2D.getX() && getY() == point2D.getY();
        }
    }
}
