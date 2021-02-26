package com.wowza.gocoder.sdk.api.graphics;

import java.nio.ByteOrder;

/* compiled from: GoCoderSDK */
public class WOWZColor implements Comparable<WOWZColor> {
    public static final WOWZColor BLACK = new WOWZColor(0, 0, 0, 1);
    public static final WOWZColor BLUE = new WOWZColor(0, 0, 1, 1);
    public static final WOWZColor CYAN = new WOWZColor(0, 1, 1, 1);
    public static final WOWZColor DARKGREY = new WOWZColor(0.25f, 0.25f, 0.25f, 1.0f);
    public static final WOWZColor GREEN = new WOWZColor(0, 1, 0, 1);
    public static final WOWZColor GREY = new WOWZColor(0.5f, 0.5f, 0.5f, 1.0f);
    public static final WOWZColor LIGHTGREY = new WOWZColor(0.75f, 0.75f, 0.75f, 1.0f);
    public static final WOWZColor MAGENTA = new WOWZColor(1, 0, 1, 1);
    public static final WOWZColor ORANGE = new WOWZColor(1.0f, 0.5f, 0.0f, 1.0f);
    public static final WOWZColor RED = new WOWZColor(1, 0, 0, 1);
    public static final WOWZColor WHITE = new WOWZColor(1, 1, 1, 1);
    public static final WOWZColor YELLOW = new WOWZColor(1, 1, 0, 1);

    /* renamed from: a */
    private static final int f3813a;

    /* renamed from: b */
    private static final int f3814b;

    /* renamed from: c */
    private static final int f3815c;

    /* renamed from: d */
    private static final int f3816d;

    /* renamed from: e */
    private static int f3817e = (255 << f3816d);

    /* renamed from: f */
    private static int f3818f = (~f3817e);
    public float alpha;
    public float blue;
    public float green;
    public float red;

    public static boolean validateColor(float f, float f2, float f3, float f4) {
        return f >= 0.0f && f <= 1.0f && f2 >= 0.0f && f2 <= 1.0f && f3 >= 0.0f && f3 <= 1.0f && f4 >= 0.0f && f4 <= 1.0f;
    }

    static {
        boolean z = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        int i = 24;
        f3813a = z ? 24 : 0;
        int i2 = 16;
        f3814b = z ? 16 : 8;
        if (z) {
            i2 = 8;
        }
        f3815c = i2;
        if (z) {
            i = 0;
        }
        f3816d = i;
    }

    /* renamed from: a */
    private static int m3622a(int i) {
        return m3634j(i) | (m3631g(i) << 24) | (m3632h(i) << 16) | (m3633i(i) << 8);
    }

    /* renamed from: b */
    private static int m3626b(int i) {
        return m3624a((i >> 24) & 255, (i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    /* renamed from: a */
    private static int m3624a(int i, int i2, int i3, int i4) {
        int i5 = (i & 255) << f3813a;
        int i6 = (i2 & 255) << f3814b;
        return i5 | i6 | ((i3 & 255) << f3815c) | ((i4 & 255) << f3816d);
    }

    /* renamed from: c */
    private static float m3627c(int i) {
        return ((float) m3631g(i)) / 255.0f;
    }

    /* renamed from: d */
    private static float m3628d(int i) {
        return ((float) m3632h(i)) / 255.0f;
    }

    /* renamed from: e */
    private static float m3629e(int i) {
        return ((float) m3633i(i)) / 255.0f;
    }

    /* renamed from: f */
    private static float m3630f(int i) {
        return ((float) m3634j(i)) / 255.0f;
    }

    /* renamed from: g */
    private static int m3631g(int i) {
        return (i >> f3813a) & 255;
    }

    /* renamed from: h */
    private static int m3632h(int i) {
        return (i >> f3814b) & 255;
    }

    /* renamed from: i */
    private static int m3633i(int i) {
        return (i >> f3815c) & 255;
    }

    /* renamed from: j */
    private static int m3634j(int i) {
        return (i >> f3816d) & 255;
    }

    /* renamed from: a */
    private static int m3623a(int i, int i2) {
        return (i & f3818f) | ((i2 & 255) << f3816d);
    }

    /* renamed from: a */
    private static void m3625a(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = m3623a(iArr[i2], i);
        }
    }

    public static int packedColor(float f, float f2, float f3, float f4) {
        return m3624a((int) (f * 255.0f), (int) (f2 * 255.0f), (int) (f3 * 255.0f), (int) (f4 * 255.0f));
    }

    public static WOWZColor fromPacked(int i) {
        WOWZColor wOWZColor = new WOWZColor();
        wOWZColor.set(i);
        return wOWZColor;
    }

    public WOWZColor(float f, float f2, float f3, float f4) {
        this.red = 1.0f;
        this.green = 1.0f;
        this.blue = 1.0f;
        this.alpha = 1.0f;
        set(f, f2, f3, f4);
    }

    public WOWZColor(float f, float f2, float f3) {
        this.red = 1.0f;
        this.green = 1.0f;
        this.blue = 1.0f;
        this.alpha = 1.0f;
        set(f, f2, f3);
    }

    public WOWZColor(int i, int i2, int i3, int i4) {
        this.red = 1.0f;
        this.green = 1.0f;
        this.blue = 1.0f;
        this.alpha = 1.0f;
        set(((float) i) / 255.0f, ((float) i2) / 255.0f, ((float) i3) / 255.0f, ((float) i4) / 255.0f);
    }

    public WOWZColor(int i, int i2, int i3) {
        this.red = 1.0f;
        this.green = 1.0f;
        this.blue = 1.0f;
        this.alpha = 1.0f;
        set(((float) i) / 255.0f, ((float) i2) / 255.0f, ((float) i3) / 255.0f);
    }

    public WOWZColor() {
        this.red = 1.0f;
        this.green = 1.0f;
        this.blue = 1.0f;
        this.alpha = 1.0f;
    }

    public WOWZColor(WOWZColor wOWZColor) {
        this();
        set(wOWZColor);
    }

    public void set(WOWZColor wOWZColor) {
        if (wOWZColor != null) {
            this.red = wOWZColor.red;
            this.blue = wOWZColor.blue;
            this.green = wOWZColor.green;
            this.alpha = wOWZColor.alpha;
        }
    }

    public void set(float f, float f2, float f3, float f4) {
        this.red = f;
        this.green = f2;
        this.blue = f3;
        this.alpha = f4;
    }

    public void set(float f, float f2, float f3) {
        this.red = f;
        this.green = f2;
        this.blue = f3;
    }

    public void set(int i) {
        this.red = m3627c(i);
        this.green = m3628d(i);
        this.blue = m3629e(i);
        this.alpha = m3630f(i);
    }

    public float[] toArray() {
        return new float[]{this.red, this.green, this.blue, this.alpha};
    }

    public int toPacked() {
        return packedColor(this.red, this.green, this.blue, this.alpha);
    }

    public boolean validate() {
        return validateColor(this.red, this.green, this.blue, this.alpha);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WOWZColor) || compareTo((WOWZColor) obj) != 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "(r: " + String.format("%4.2f", new Object[]{Float.valueOf(this.red)}) + ", g: " + String.format("%4.2f", new Object[]{Float.valueOf(this.green)}) + ", b: " + String.format("%4.2f", new Object[]{Float.valueOf(this.blue)}) + ", a: " + String.format("%4.2f", new Object[]{Float.valueOf(this.alpha)}) + ")";
    }

    public int compareTo(WOWZColor wOWZColor) {
        int i;
        if (wOWZColor != null && ((long) toPacked()) <= ((long) wOWZColor.toPacked())) {
            return i < 0 ? -1 : 0;
        }
        return 1;
    }
}
