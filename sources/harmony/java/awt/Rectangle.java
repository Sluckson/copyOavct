package harmony.java.awt;

import harmony.java.awt.geom.Rectangle2D;
import java.io.Serializable;

public class Rectangle extends Rectangle2D implements Shape, Serializable {
    private static final long serialVersionUID = -4345857070255674764L;
    public int height;
    public int width;

    /* renamed from: x */
    public int f4907x;

    /* renamed from: y */
    public int f4908y;

    public Rectangle() {
        setBounds(0, 0, 0, 0);
    }

    public Rectangle(Point point) {
        setBounds(point.f4903x, point.f4904y, 0, 0);
    }

    public Rectangle(Point point, Dimension dimension) {
        setBounds(point.f4903x, point.f4904y, dimension.width, dimension.height);
    }

    public Rectangle(int i, int i2, int i3, int i4) {
        setBounds(i, i2, i3, i4);
    }

    public Rectangle(int i, int i2) {
        setBounds(0, 0, i, i2);
    }

    public Rectangle(Rectangle rectangle) {
        setBounds(rectangle.f4907x, rectangle.f4908y, rectangle.width, rectangle.height);
    }

    public Rectangle(Dimension dimension) {
        setBounds(0, 0, dimension.width, dimension.height);
    }

    public double getX() {
        return (double) this.f4907x;
    }

    public double getY() {
        return (double) this.f4908y;
    }

    public double getHeight() {
        return (double) this.height;
    }

    public double getWidth() {
        return (double) this.width;
    }

    public boolean isEmpty() {
        return this.width <= 0 || this.height <= 0;
    }

    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public void setSize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }

    public Point getLocation() {
        return new Point(this.f4907x, this.f4908y);
    }

    public void setLocation(int i, int i2) {
        this.f4907x = i;
        this.f4908y = i2;
    }

    public void setLocation(Point point) {
        setLocation(point.f4903x, point.f4904y);
    }

    @Deprecated
    public void move(int i, int i2) {
        setLocation(i, i2);
    }

    public void setRect(double d, double d2, double d3, double d4) {
        int floor = (int) Math.floor(d);
        int floor2 = (int) Math.floor(d2);
        setBounds(floor, floor2, ((int) Math.ceil(d + d3)) - floor, ((int) Math.ceil(d2 + d4)) - floor2);
    }

    @Deprecated
    public void resize(int i, int i2) {
        setBounds(this.f4907x, this.f4908y, i, i2);
    }

    @Deprecated
    public void reshape(int i, int i2, int i3, int i4) {
        setBounds(i, i2, i3, i4);
    }

    public Rectangle getBounds() {
        return new Rectangle(this.f4907x, this.f4908y, this.width, this.height);
    }

    public Rectangle2D getBounds2D() {
        return getBounds();
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        this.f4907x = i;
        this.f4908y = i2;
        this.height = i4;
        this.width = i3;
    }

    public void setBounds(Rectangle rectangle) {
        setBounds(rectangle.f4907x, rectangle.f4908y, rectangle.width, rectangle.height);
    }

    public void grow(int i, int i2) {
        this.f4907x -= i;
        this.f4908y -= i2;
        this.width += i + i;
        this.height += i2 + i2;
    }

    public void translate(int i, int i2) {
        this.f4907x += i;
        this.f4908y += i2;
    }

    public void add(int i, int i2) {
        int min = Math.min(this.f4907x, i);
        int max = Math.max(this.f4907x + this.width, i);
        int min2 = Math.min(this.f4908y, i2);
        setBounds(min, min2, max - min, Math.max(this.f4908y + this.height, i2) - min2);
    }

    public void add(Point point) {
        add(point.f4903x, point.f4904y);
    }

    public void add(Rectangle rectangle) {
        int min = Math.min(this.f4907x, rectangle.f4907x);
        int max = Math.max(this.f4907x + this.width, rectangle.f4907x + rectangle.width);
        int min2 = Math.min(this.f4908y, rectangle.f4908y);
        setBounds(min, min2, max - min, Math.max(this.f4908y + this.height, rectangle.f4908y + rectangle.height) - min2);
    }

    public boolean contains(int i, int i2) {
        int i3;
        int i4;
        if (!isEmpty() && i >= (i3 = this.f4907x) && i2 >= (i4 = this.f4908y)) {
            int i5 = i2 - i4;
            if (i - i3 >= this.width || i5 >= this.height) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean contains(Point point) {
        return contains(point.f4903x, point.f4904y);
    }

    public boolean contains(int i, int i2, int i3, int i4) {
        return contains(i, i2) && contains((i + i3) - 1, (i2 + i4) - 1);
    }

    public boolean contains(Rectangle rectangle) {
        return contains(rectangle.f4907x, rectangle.f4908y, rectangle.width, rectangle.height);
    }

    @Deprecated
    public boolean inside(int i, int i2) {
        return contains(i, i2);
    }

    public Rectangle2D createIntersection(Rectangle2D rectangle2D) {
        if (rectangle2D instanceof Rectangle) {
            return intersection((Rectangle) rectangle2D);
        }
        Rectangle2D.Double doubleR = new Rectangle2D.Double();
        Rectangle2D.intersect(this, rectangle2D, doubleR);
        return doubleR;
    }

    public Rectangle intersection(Rectangle rectangle) {
        int max = Math.max(this.f4907x, rectangle.f4907x);
        int max2 = Math.max(this.f4908y, rectangle.f4908y);
        return new Rectangle(max, max2, Math.min(this.f4907x + this.width, rectangle.f4907x + rectangle.width) - max, Math.min(this.f4908y + this.height, rectangle.f4908y + rectangle.height) - max2);
    }

    public boolean intersects(Rectangle rectangle) {
        return !intersection(rectangle).isEmpty();
    }

    public int outcode(double d, double d2) {
        int i;
        int i2 = this.width;
        if (i2 <= 0) {
            i = 5;
        } else {
            int i3 = this.f4907x;
            i = d < ((double) i3) ? 1 : d > ((double) (i3 + i2)) ? 4 : 0;
        }
        int i4 = this.height;
        if (i4 <= 0) {
            return i | 10;
        }
        int i5 = this.f4908y;
        if (d2 < ((double) i5)) {
            return i | 2;
        }
        return d2 > ((double) (i5 + i4)) ? i | 8 : i;
    }

    public Rectangle2D createUnion(Rectangle2D rectangle2D) {
        if (rectangle2D instanceof Rectangle) {
            return union((Rectangle) rectangle2D);
        }
        Rectangle2D.Double doubleR = new Rectangle2D.Double();
        Rectangle2D.union(this, rectangle2D, doubleR);
        return doubleR;
    }

    public Rectangle union(Rectangle rectangle) {
        Rectangle rectangle2 = new Rectangle(this);
        rectangle2.add(rectangle);
        return rectangle2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) obj;
            return rectangle.f4907x == this.f4907x && rectangle.f4908y == this.f4908y && rectangle.width == this.width && rectangle.height == this.height;
        }
    }

    public String toString() {
        return String.valueOf(getClass().getName()) + "[x=" + this.f4907x + ",y=" + this.f4908y + ",width=" + this.width + ",height=" + this.height + "]";
    }
}
