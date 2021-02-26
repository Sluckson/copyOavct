package com.wowza.gocoder.sdk.api.gles;

import java.nio.FloatBuffer;

/* compiled from: GoCoderSDK */
public class Drawable2d {

    /* renamed from: a */
    private static final int f3736a = 4;

    /* renamed from: b */
    private static final float[] f3737b = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};

    /* renamed from: c */
    private static final float[] f3738c = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: d */
    private static final FloatBuffer f3739d = GlUtil.createFloatBuffer(f3737b);

    /* renamed from: e */
    private static final FloatBuffer f3740e = GlUtil.createFloatBuffer(f3738c);

    /* renamed from: f */
    private static final float[] f3741f = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};

    /* renamed from: g */
    private static final float[] f3742g = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: h */
    private static final FloatBuffer f3743h = GlUtil.createFloatBuffer(f3741f);

    /* renamed from: i */
    private static final FloatBuffer f3744i = GlUtil.createFloatBuffer(f3742g);

    /* renamed from: j */
    private static final float[] f3745j = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: k */
    private static final float[] f3746k = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: l */
    private static final FloatBuffer f3747l = GlUtil.createFloatBuffer(f3745j);

    /* renamed from: m */
    private static final FloatBuffer f3748m = GlUtil.createFloatBuffer(f3746k);

    /* renamed from: n */
    private FloatBuffer f3749n;

    /* renamed from: o */
    private FloatBuffer f3750o;

    /* renamed from: p */
    private int f3751p;

    /* renamed from: q */
    private int f3752q;

    /* renamed from: r */
    private int f3753r;

    /* renamed from: s */
    private int f3754s;

    /* renamed from: t */
    private Prefab f3755t;

    /* compiled from: GoCoderSDK */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    /* renamed from: com.wowza.gocoder.sdk.api.gles.Drawable2d$1 */
    /* compiled from: GoCoderSDK */
    static /* synthetic */ class C42361 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3756a = new int[Prefab.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.wowza.gocoder.sdk.api.gles.Drawable2d$Prefab[] r0 = com.wowza.gocoder.sdk.api.gles.Drawable2d.Prefab.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3756a = r0
                int[] r0 = f3756a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.wowza.gocoder.sdk.api.gles.Drawable2d$Prefab r1 = com.wowza.gocoder.sdk.api.gles.Drawable2d.Prefab.TRIANGLE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3756a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.wowza.gocoder.sdk.api.gles.Drawable2d$Prefab r1 = com.wowza.gocoder.sdk.api.gles.Drawable2d.Prefab.RECTANGLE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3756a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.wowza.gocoder.sdk.api.gles.Drawable2d$Prefab r1 = com.wowza.gocoder.sdk.api.gles.Drawable2d.Prefab.FULL_RECTANGLE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.gles.Drawable2d.C42361.<clinit>():void");
        }
    }

    public Drawable2d(Prefab prefab) {
        int i = C42361.f3756a[prefab.ordinal()];
        if (i == 1) {
            this.f3749n = f3739d;
            this.f3750o = f3740e;
            this.f3752q = 2;
            int i2 = this.f3752q;
            this.f3753r = i2 * 4;
            this.f3751p = f3737b.length / i2;
        } else if (i == 2) {
            this.f3749n = f3743h;
            this.f3750o = f3744i;
            this.f3752q = 2;
            int i3 = this.f3752q;
            this.f3753r = i3 * 4;
            this.f3751p = f3741f.length / i3;
        } else if (i == 3) {
            this.f3749n = f3747l;
            this.f3750o = f3748m;
            this.f3752q = 2;
            int i4 = this.f3752q;
            this.f3753r = i4 * 4;
            this.f3751p = f3745j.length / i4;
        } else {
            throw new RuntimeException("Unknown shape " + prefab);
        }
        this.f3754s = 8;
        this.f3755t = prefab;
    }

    public FloatBuffer getVertexArray() {
        return this.f3749n;
    }

    public FloatBuffer getTexCoordArray() {
        return this.f3750o;
    }

    public int getVertexCount() {
        return this.f3751p;
    }

    public int getVertexStride() {
        return this.f3753r;
    }

    public int getTexCoordStride() {
        return this.f3754s;
    }

    public int getCoordsPerVertex() {
        return this.f3752q;
    }

    public String toString() {
        if (this.f3755t == null) {
            return "[Drawable2d: ...]";
        }
        return "[Drawable2d: " + this.f3755t + "]";
    }
}
