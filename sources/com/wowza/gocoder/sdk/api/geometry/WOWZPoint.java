package com.wowza.gocoder.sdk.api.geometry;

import java.io.Serializable;

/* compiled from: GoCoderSDK */
public class WOWZPoint implements Serializable, Comparable<WOWZPoint> {

    /* renamed from: x */
    public int f3734x;

    /* renamed from: y */
    public int f3735y;

    public boolean equals(int i, int i2, int i3, int i4) {
        return i == i3 && i2 == i4;
    }

    public static double distance(int i, int i2, int i3, int i4) {
        int i5 = i - i3;
        int i6 = i2 - i4;
        return Math.sqrt((double) ((i5 * i5) + (i6 * i6)));
    }

    public static String label(int i, int i2) {
        return "(" + String.valueOf(i) + "," + String.valueOf(i2) + ")";
    }

    public WOWZPoint() {
        this.f3734x = 0;
        this.f3735y = 0;
    }

    public WOWZPoint(int i, int i2) {
        this();
        set(i, i2);
    }

    public WOWZPoint(WOWZPoint wOWZPoint) {
        this();
        set(wOWZPoint);
    }

    public int getX() {
        return this.f3734x;
    }

    public void setX(int i) {
        this.f3734x = i;
    }

    public int getY() {
        return this.f3735y;
    }

    public void setY(int i) {
        this.f3735y = i;
    }

    public void set(int i, int i2) {
        this.f3734x = i;
        this.f3735y = i2;
    }

    public void set(WOWZPoint wOWZPoint) {
        if (wOWZPoint != null) {
            set(wOWZPoint.f3734x, wOWZPoint.f3735y);
        }
    }

    public boolean equals(int i, int i2) {
        return equals(this.f3734x, this.f3735y, i, i2);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof WOWZPoint)) {
            WOWZPoint wOWZPoint = (WOWZPoint) obj;
            if (equals(wOWZPoint.f3734x, wOWZPoint.f3735y)) {
                return true;
            }
        }
        return false;
    }

    public int compareTo(int i, int i2) {
        int i3 = this.f3734x;
        return i3 == i ? this.f3735y - i2 : i3 - i;
    }

    public int compareTo(WOWZPoint wOWZPoint) {
        return compareTo(wOWZPoint.f3734x, wOWZPoint.f3735y);
    }

    public String toString() {
        return label(this.f3734x, this.f3735y);
    }

    public WOWZPoint inverted() {
        return new WOWZPoint(this.f3735y, this.f3734x);
    }

    public void invert() {
        int i = this.f3734x;
        this.f3734x = this.f3735y;
        this.f3735y = i;
    }

    public double distanceTo(int i, int i2) {
        return distance(this.f3734x, this.f3735y, i, i2);
    }

    public double distanceTo(WOWZPoint wOWZPoint) {
        return distanceTo(wOWZPoint.f3734x, wOWZPoint.f3735y);
    }
}
