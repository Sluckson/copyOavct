package com.wowza.gocoder.sdk.api.geometry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: GoCoderSDK */
public class WOWZSize implements Serializable, Comparable<WOWZSize> {
    public int height;
    public int width;

    public static float aspectRatio(int i, int i2) {
        if (i2 != 0) {
            return ((float) i) / ((float) i2);
        }
        return 0.0f;
    }

    public static boolean isLandscape(int i, int i2) {
        return i > i2;
    }

    public static boolean isPortrait(int i, int i2) {
        return i < i2;
    }

    public static boolean isSquare(int i, int i2) {
        return i == i2;
    }

    public static boolean isZero(int i, int i2) {
        return i == 0 && i2 == 0;
    }

    public static int longDimension(int i, int i2) {
        return i >= i2 ? i : i2;
    }

    public double area(int i, int i2) {
        return (double) (i * i2);
    }

    public boolean equals(int i, int i2, int i3, int i4) {
        return i == i3 && i2 == i4;
    }

    public static String aspectRatioLabel(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return null;
        }
        long j = (long) i;
        long j2 = (long) i2;
        long a = m3617a(j, j2);
        return "" + (j / a) + ":" + (j2 / a);
    }

    public static WOWZSize[] filterByAspectRatio(WOWZSize[] wOWZSizeArr, WOWZSize wOWZSize) {
        ArrayList arrayList = new ArrayList();
        int aspectRatio = (int) (wOWZSize.asLandscape().aspectRatio() * 100.0f);
        for (WOWZSize wOWZSize2 : wOWZSizeArr) {
            if (((int) (wOWZSize2.asLandscape().aspectRatio() * 100.0f)) == aspectRatio) {
                arrayList.add(wOWZSize2);
            }
        }
        Collections.sort(arrayList);
        return (WOWZSize[]) arrayList.toArray(new WOWZSize[arrayList.size()]);
    }

    public static WOWZSize[] findContainers(WOWZSize[] wOWZSizeArr, WOWZSize wOWZSize) {
        ArrayList arrayList = new ArrayList();
        for (WOWZSize wOWZSize2 : wOWZSizeArr) {
            if (wOWZSize.asLandscape().fitsWithin(wOWZSize2.asLandscape())) {
                arrayList.add(wOWZSize2);
            }
        }
        Collections.sort(arrayList);
        return (WOWZSize[]) arrayList.toArray(new WOWZSize[arrayList.size()]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        if (r7 < r5) goto L_0x0008;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r3 = r5;
        r5 = r7;
        r7 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r5 = r5 % r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        if (r5 != 0) goto L_0x0005;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        return r7;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long m3617a(long r5, long r7) {
        /*
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0005
            goto L_0x0008
        L_0x0005:
            r3 = r5
            r5 = r7
            r7 = r3
        L_0x0008:
            long r5 = r5 % r7
            r0 = 0
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x0005
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.geometry.WOWZSize.m3617a(long, long):long");
    }

    public static boolean equalsAspect(int i, int i2, int i3, int i4) {
        return ((int) asLandscape(i, i2).aspectRatio()) * 100 == ((int) asLandscape(i3, i4).aspectRatio()) * 100;
    }

    public static boolean equalsAspect(WOWZSize wOWZSize, WOWZSize wOWZSize2) {
        return equalsAspect(wOWZSize.width, wOWZSize.height, wOWZSize2.width, wOWZSize2.height);
    }

    public static WOWZSize offset(int i, int i2, int i3, int i4) {
        return new WOWZSize(Math.round(((float) (i3 - i)) / 2.0f), Math.round(((float) (i4 - i2)) / 2.0f));
    }

    public static WOWZSize absOffset(int i, int i2, int i3, int i4) {
        WOWZSize offset = offset(i, i2, i3, i4);
        offset.width = Math.abs(offset.width);
        offset.height = Math.abs(offset.height);
        return offset;
    }

    public WOWZPoint center(int i, int i2) {
        return new WOWZPoint(Math.round(((float) i) / 2.0f), Math.round(((float) i2) / 2.0f));
    }

    public static WOWZSize asLandscape(int i, int i2) {
        return isLandscape(i, i2) ? new WOWZSize(i, i2) : new WOWZSize(i2, i);
    }

    public static WOWZSize asPortrait(int i, int i2) {
        return isPortrait(i, i2) ? new WOWZSize(i, i2) : new WOWZSize(i2, i);
    }

    public static WOWZSize closestTo(WOWZSize wOWZSize, WOWZSize[] wOWZSizeArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(wOWZSizeArr));
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WOWZSize wOWZSize2 = (WOWZSize) it.next();
            if (wOWZSize2.compareTo(wOWZSize) >= 0) {
                return wOWZSize2;
            }
        }
        return null;
    }

    public static int closestToIndex(WOWZSize wOWZSize, WOWZSize[] wOWZSizeArr) {
        Collections.sort(new ArrayList(Arrays.asList(wOWZSizeArr)));
        for (int i = 0; i < wOWZSizeArr.length; i++) {
            if (wOWZSizeArr[i].compareTo(wOWZSize) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static WOWZSize closestTo(int i, int i2, WOWZSize[] wOWZSizeArr) {
        return closestTo(new WOWZSize(i, i2), wOWZSizeArr);
    }

    public static int closestToIndex(int i, int i2, WOWZSize[] wOWZSizeArr) {
        return closestToIndex(new WOWZSize(i, i2), wOWZSizeArr);
    }

    public static String label(int i, int i2) {
        return String.valueOf(i) + "x" + String.valueOf(i2);
    }

    public WOWZSize() {
        this.width = 0;
        this.height = 0;
    }

    public WOWZSize(int i, int i2) {
        this();
        set(i, i2);
    }

    public WOWZSize(WOWZSize wOWZSize) {
        this();
        set(wOWZSize);
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void set(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public void set(WOWZSize wOWZSize) {
        if (wOWZSize != null) {
            set(wOWZSize.width, wOWZSize.height);
        }
    }

    public boolean equals(int i, int i2) {
        return equals(this.width, this.height, i, i2);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof WOWZSize)) {
            WOWZSize wOWZSize = (WOWZSize) obj;
            if (equals(wOWZSize.width, wOWZSize.height)) {
                return true;
            }
        }
        return false;
    }

    public int compareTo(WOWZSize wOWZSize) {
        return compareTo(wOWZSize.width, wOWZSize.height);
    }

    public int compareTo(int i, int i2) {
        if (equals(i, i2)) {
            return 0;
        }
        return this.width - i;
    }

    public String toString() {
        return label(this.width, this.height);
    }

    public WOWZSize inverted() {
        return new WOWZSize(this.height, this.width);
    }

    public void invert() {
        int i = this.width;
        this.width = this.height;
        this.height = i;
    }

    public float aspectRatio() {
        return aspectRatio(this.width, this.height);
    }

    public String aspectRatioLabel() {
        return aspectRatioLabel(this.width, this.height);
    }

    public boolean equalsAspect(int i, int i2) {
        return ((int) (asLandscape().aspectRatio() * 100.0f)) == ((int) asLandscape(i, i2).aspectRatio()) * 100;
    }

    public boolean equalsAspect(WOWZSize wOWZSize) {
        return equals(wOWZSize.width, wOWZSize.height);
    }

    public boolean isLandscape() {
        return isLandscape(this.width, this.height);
    }

    public boolean isPortrait() {
        return isPortrait(this.width, this.height);
    }

    public boolean isSquare() {
        return isSquare(this.width, this.height);
    }

    public boolean isZero() {
        return isZero(this.width, this.height);
    }

    public int longDimension() {
        return longDimension(this.width, this.height);
    }

    public WOWZSize asLandscape() {
        return asLandscape(this.width, this.height);
    }

    public WOWZSize asPortrait() {
        return asPortrait(this.width, this.height);
    }

    public boolean fitsWithin(WOWZSize wOWZSize) {
        return compareTo(wOWZSize) <= 0;
    }

    public boolean largerThan(WOWZSize wOWZSize) {
        return compareTo(wOWZSize) == 1;
    }

    public WOWZPoint center() {
        return center(this.width, this.height);
    }

    public double area() {
        return area(this.width, this.height);
    }

    public WOWZSize offsetFrom(WOWZSize wOWZSize) {
        return offset(this.width, this.height, wOWZSize.width, wOWZSize.height);
    }

    public WOWZSize absOffsetFrom(WOWZSize wOWZSize) {
        return absOffset(this.width, this.height, wOWZSize.width, wOWZSize.height);
    }

    public ScaledDimensions scaleWithCrop(WOWZSize wOWZSize) {
        return new ScaledDimensions(this, wOWZSize).scaleWithCrop();
    }

    public ScaledDimensions scaleWithFill(WOWZSize wOWZSize) {
        return new ScaledDimensions(this, wOWZSize).scaleWithFill();
    }

    public ScaledDimensions center(WOWZSize wOWZSize) {
        return new ScaledDimensions(this, wOWZSize).center();
    }

    /* compiled from: GoCoderSDK */
    public static class ScaledDimensions {
        public WOWZPoint centerPoint;
        public WOWZSize destSize;
        public WOWZSize offset;
        public float scaleX = 0.0f;
        public float scaleY = 0.0f;
        public WOWZSize scaledSize;
        public WOWZSize srcSize;

        public ScaledDimensions(WOWZSize wOWZSize, WOWZSize wOWZSize2) {
            this.srcSize = new WOWZSize(wOWZSize);
            this.destSize = new WOWZSize(wOWZSize2);
            this.scaledSize = new WOWZSize(wOWZSize);
            this.offset = this.destSize.offsetFrom(wOWZSize);
            this.centerPoint = wOWZSize2.center();
        }

        public void setSrcSize(WOWZSize wOWZSize) {
            this.srcSize.set(wOWZSize);
            this.scaledSize.set(wOWZSize);
            this.offset = this.destSize.offsetFrom(wOWZSize);
            m3618a();
        }

        public void setDestSize(WOWZSize wOWZSize) {
            this.destSize.set(wOWZSize);
            this.scaledSize.set(this.srcSize);
            this.centerPoint = wOWZSize.center();
            this.offset = this.destSize.offsetFrom(this.srcSize);
            m3618a();
        }

        public ScaledDimensions scaleWithCrop() {
            this.scaledSize.set(this.destSize);
            if (this.srcSize.aspectRatio() < this.destSize.aspectRatio()) {
                WOWZSize wOWZSize = this.scaledSize;
                wOWZSize.width = Math.round(((float) wOWZSize.height) * this.srcSize.aspectRatio());
            } else if (this.srcSize.aspectRatio() > this.destSize.aspectRatio()) {
                WOWZSize wOWZSize2 = this.scaledSize;
                wOWZSize2.height = Math.round(((float) wOWZSize2.width) * (1.0f / this.srcSize.aspectRatio()));
            }
            m3618a();
            return this;
        }

        public ScaledDimensions scaleWithFill() {
            this.scaledSize.set(this.destSize);
            if (this.srcSize.aspectRatio() > this.destSize.aspectRatio()) {
                WOWZSize wOWZSize = this.scaledSize;
                wOWZSize.width = Math.round(((float) wOWZSize.height) * this.srcSize.aspectRatio());
            } else if (this.srcSize.aspectRatio() < this.destSize.aspectRatio()) {
                WOWZSize wOWZSize2 = this.scaledSize;
                wOWZSize2.height = Math.round(((float) wOWZSize2.width) * (1.0f / this.srcSize.aspectRatio()));
            }
            m3618a();
            return this;
        }

        public ScaledDimensions center() {
            this.scaledSize.set(this.srcSize);
            m3618a();
            return this;
        }

        /* renamed from: a */
        private void m3618a() {
            this.scaleX = ((float) this.scaledSize.width) / ((float) this.srcSize.width);
            this.scaleY = ((float) this.scaledSize.height) / ((float) this.srcSize.height);
            this.offset = this.destSize.offsetFrom(this.scaledSize);
        }

        public String toString() {
            return "srcSize = " + this.srcSize.toString() + ", destSize = " + this.destSize.toString() + " scaledSize = " + this.scaledSize.toString() + " scaleX,scaleY = " + this.scaleX + "," + this.scaleY + " center = " + this.centerPoint.toString() + " offset = " + this.offset.toString();
        }
    }
}
