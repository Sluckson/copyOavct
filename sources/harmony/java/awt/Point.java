package harmony.java.awt;

import harmony.java.awt.geom.Point2D;
import java.io.Serializable;

public class Point extends Point2D implements Serializable {
    private static final long serialVersionUID = -5276940640259749850L;

    /* renamed from: x */
    public int f4903x;

    /* renamed from: y */
    public int f4904y;

    public Point() {
        setLocation(0, 0);
    }

    public Point(int i, int i2) {
        setLocation(i, i2);
    }

    public Point(Point point) {
        setLocation(point.f4903x, point.f4904y);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Point) {
            Point point = (Point) obj;
            return this.f4903x == point.f4903x && this.f4904y == point.f4904y;
        }
    }

    public String toString() {
        return String.valueOf(getClass().getName()) + "[x=" + this.f4903x + ",y=" + this.f4904y + "]";
    }

    public double getX() {
        return (double) this.f4903x;
    }

    public double getY() {
        return (double) this.f4904y;
    }

    public Point getLocation() {
        return new Point(this.f4903x, this.f4904y);
    }

    public void setLocation(Point point) {
        setLocation(point.f4903x, point.f4904y);
    }

    public void setLocation(int i, int i2) {
        this.f4903x = i;
        this.f4904y = i2;
    }

    public void setLocation(double d, double d2) {
        if (d < -2.147483648E9d) {
            d = -2.147483648E9d;
        } else if (d > 2.147483647E9d) {
            d = 2.147483647E9d;
        }
        if (d2 < -2.147483648E9d) {
            d2 = -2.147483648E9d;
        } else if (d2 > 2.147483647E9d) {
            d2 = 2.147483647E9d;
        }
        setLocation((int) Math.round(d), (int) Math.round(d2));
    }

    public void move(int i, int i2) {
        setLocation(i, i2);
    }

    public void translate(int i, int i2) {
        this.f4903x += i;
        this.f4904y += i2;
    }
}
