package com.wowza.gocoder.sdk.api.android.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.graphics.WOWZColor;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.render.WOWZRenderAPI;
import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.C4264c;
import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.C4265d;
import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.C4266e;
import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.p032a.C4261a;
import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.p032a.C4262b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.UUID;

/* compiled from: GoCoderSDK */
public final class WOWZTextManager implements WOWZRenderAPI.VideoFrameRenderer {
    public static final int SCALE_BASIS_BASE_SIZE = -8;
    public static final int SCALE_BASIS_CURRENT_SIZE = -9;
    public static final int SCALE_BASIS_FRAME_HEIGHT = -7;
    public static final int SCALE_BASIS_FRAME_WIDTH = -6;

    /* renamed from: a */
    private static final String f3514a = "WOWZTextManager";

    /* renamed from: b */
    private static volatile WOWZTextManager f3515b = new WOWZTextManager();

    /* renamed from: c */
    private WOWZSize f3516c = new WOWZSize();
    protected AssetManager mAssetManager = null;
    protected float[] mDisplayProjectionMatrix = new float[16];
    protected ArrayList<Font> mFonts = new ArrayList<>();
    protected float[] mModelViewMatrix = new float[16];
    protected float[] mScratchMatrix = new float[16];
    protected ArrayList<WOWZText> mTextObjects = new ArrayList<>();
    protected boolean mTextVisible = true;
    protected boolean mViewMatrixReady = false;

    public static WOWZTextManager getInstance() {
        return f3515b;
    }

    WOWZTextManager() {
    }

    public void init(Context context) {
        this.mAssetManager = context.getAssets();
    }

    public void release() {
        this.mTextObjects.clear();
        Iterator<Font> it = this.mFonts.iterator();
        while (it.hasNext()) {
            it.next().release();
        }
        this.mFonts.clear();
    }

    public UUID loadFont(String str, int i, int i2, int i3) {
        AssetManager assetManager = this.mAssetManager;
        if (assetManager == null) {
            WOWZLog.error(f3514a, "The TextManager hasn't been initialized.");
            return null;
        }
        Font font = new Font(assetManager, str, i, i2, i3);
        this.mFonts.add(font);
        if (font.f3519b != null) {
            return font.f3519b;
        }
        return null;
    }

    public Font getFontById(UUID uuid) {
        Iterator<Font> it = this.mFonts.iterator();
        while (it.hasNext()) {
            Font next = it.next();
            if (next.f3519b == uuid) {
                return next;
            }
        }
        return null;
    }

    public WOWZText createTextObject(UUID uuid) {
        if (getFontById(uuid) == null) {
            WOWZLog.error(f3514a, "Invalid font ID.");
            return null;
        }
        WOWZText wOWZText = new WOWZText(uuid);
        this.mTextObjects.add(wOWZText);
        return wOWZText;
    }

    public WOWZText createTextObject(UUID uuid, String str) {
        WOWZText createTextObject = createTextObject(uuid);
        if (createTextObject != null) {
            createTextObject.setText(str);
        }
        return createTextObject;
    }

    public WOWZText createTextObject(UUID uuid, String str, WOWZColor wOWZColor) {
        WOWZText createTextObject = createTextObject(uuid, str);
        if (createTextObject != null) {
            createTextObject.setColor(wOWZColor);
        }
        return createTextObject;
    }

    public WOWZText createTextObject(UUID uuid, String str, float f, float f2, float f3, float f4) {
        WOWZText createTextObject = createTextObject(uuid, str);
        if (createTextObject != null) {
            createTextObject.setColor(f, f2, f3, f4);
        }
        return createTextObject;
    }

    public WOWZText createTextObject(UUID uuid, String str, float f, float f2, float f3) {
        WOWZText createTextObject = createTextObject(uuid, str);
        if (createTextObject != null) {
            createTextObject.setColor(f, f2, f3);
        }
        return createTextObject;
    }

    public synchronized void releaseTextObject(WOWZText wOWZText) {
        if (this.mTextObjects.contains(wOWZText)) {
            this.mTextObjects.remove(wOWZText);
        }
    }

    public synchronized void clear() {
        release();
    }

    public void setTextVisible(boolean z) {
        this.mTextVisible = z;
    }

    public boolean isTextVisible() {
        return this.mTextVisible;
    }

    public boolean isWZVideoFrameRendererActive() {
        if (!this.mTextVisible) {
            return false;
        }
        Iterator<WOWZText> it = this.mTextObjects.iterator();
        while (it.hasNext()) {
            WOWZText next = it.next();
            if (next.isVisible() && next.getText() != null && next.getText().trim().length() > 0) {
                return true;
            }
        }
        return false;
    }

    public void onWZVideoFrameRendererInit(WOWZGLES.EglEnv eglEnv) {
        this.f3516c.set(0, 0);
        this.mDisplayProjectionMatrix = new float[16];
        Matrix.setIdentityM(this.mDisplayProjectionMatrix, 0);
        Iterator<Font> it = this.mFonts.iterator();
        while (it.hasNext()) {
            Font next = it.next();
            if (!next.load()) {
                Iterator<WOWZText> it2 = this.mTextObjects.iterator();
                while (it2.hasNext()) {
                    WOWZText next2 = it2.next();
                    if (next2.getFontId() == next.getFontId()) {
                        this.mTextObjects.remove(next2);
                    }
                }
                this.mFonts.remove(next);
            }
        }
    }

    public void onWZVideoFrameRendererDraw(WOWZGLES.EglEnv eglEnv, WOWZSize wOWZSize, int i) {
        if (!this.mViewMatrixReady || !this.f3516c.equals(wOWZSize)) {
            m3486a(wOWZSize);
        }
        this.f3516c.set(wOWZSize);
        m3485a(eglEnv, wOWZSize, i);
    }

    public void onWZVideoFrameRendererRelease(WOWZGLES.EglEnv eglEnv) {
        this.mViewMatrixReady = false;
    }

    /* renamed from: a */
    private WOWZText[] m3487a(UUID uuid) {
        ArrayList arrayList = new ArrayList();
        Iterator<WOWZText> it = this.mTextObjects.iterator();
        while (it.hasNext()) {
            WOWZText next = it.next();
            if (next.getFontId() == uuid) {
                arrayList.add(next);
            }
        }
        WOWZText[] wOWZTextArr = (WOWZText[]) arrayList.toArray(new WOWZText[arrayList.size()]);
        Arrays.sort(wOWZTextArr, new Comparator<WOWZText>() {
            public int compare(WOWZText wOWZText, WOWZText wOWZText2) {
                return wOWZText.getColor().compareTo(wOWZText2.getColor());
            }
        });
        return wOWZTextArr;
    }

    /* renamed from: a */
    private synchronized void m3485a(WOWZGLES.EglEnv eglEnv, WOWZSize wOWZSize, int i) {
        if (this.mTextVisible) {
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(1, 771);
            Iterator<Font> it = this.mFonts.iterator();
            Font font = null;
            WOWZColor wOWZColor = null;
            while (it.hasNext()) {
                Font next = it.next();
                for (WOWZText wOWZText : m3487a(next.f3519b)) {
                    if (wOWZText.isVisible() && wOWZText.getText() != null && wOWZText.getText().trim().length() > 0) {
                        if (font == null || font.getFontId() != wOWZText.getFontId() || wOWZColor == null || !wOWZColor.equals(wOWZText.getColor())) {
                            if (font != null) {
                                font.deactivate();
                            }
                            next.activate(wOWZText.getColor(), this.mDisplayProjectionMatrix);
                            wOWZColor = wOWZText.getColor();
                            font = next;
                        }
                        m3484a(wOWZText, eglEnv, wOWZSize, i);
                    }
                }
            }
            if (font != null) {
                font.deactivate();
            }
            GLES20.glDisable(3042);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0096  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m3484a(com.wowza.gocoder.sdk.api.android.graphics.WOWZText r29, com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES.EglEnv r30, com.wowza.gocoder.sdk.api.geometry.WOWZSize r31, int r32) {
        /*
            r28 = this;
            r1 = r28
            monitor-enter(r28)
            r0 = r29
            r2 = r31
            r0.setFrameSize(r2)     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = r29.getText()     // Catch:{ all -> 0x00d8 }
            com.wowza.gocoder.sdk.api.android.graphics.WOWZTextManager$Font r3 = r29.getFont()     // Catch:{ all -> 0x00d8 }
            float r4 = r29.getScale()     // Catch:{ all -> 0x00d8 }
            com.wowza.gocoder.sdk.api.geometry.WOWZPoint r5 = r29.getPosition()     // Catch:{ all -> 0x00d8 }
            int r6 = r3.f3533p     // Catch:{ all -> 0x00d8 }
            float r6 = (float) r6     // Catch:{ all -> 0x00d8 }
            float r6 = r6 * r4
            int r7 = r3.f3532o     // Catch:{ all -> 0x00d8 }
            float r7 = (float) r7     // Catch:{ all -> 0x00d8 }
            float r14 = r7 * r4
            int r15 = r2.length()     // Catch:{ all -> 0x00d8 }
            int r7 = r5.f3734x     // Catch:{ all -> 0x00d8 }
            float r7 = (float) r7     // Catch:{ all -> 0x00d8 }
            int r5 = r5.f3735y     // Catch:{ all -> 0x00d8 }
            float r5 = (float) r5     // Catch:{ all -> 0x00d8 }
            int r8 = r29.getAlignment()     // Catch:{ all -> 0x00d8 }
            r9 = -3
            if (r8 == r9) goto L_0x0046
            r9 = -1
            if (r8 == r9) goto L_0x003d
            goto L_0x004c
        L_0x003d:
            int r8 = r29.getWidth()     // Catch:{ all -> 0x00d8 }
            float r8 = (float) r8     // Catch:{ all -> 0x00d8 }
            r9 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 / r9
            goto L_0x004b
        L_0x0046:
            int r8 = r29.getWidth()     // Catch:{ all -> 0x00d8 }
            float r8 = (float) r8     // Catch:{ all -> 0x00d8 }
        L_0x004b:
            float r7 = r7 - r8
        L_0x004c:
            float[] r8 = r1.mModelViewMatrix     // Catch:{ all -> 0x00d8 }
            r9 = 0
            android.opengl.Matrix.setIdentityM(r8, r9)     // Catch:{ all -> 0x00d8 }
            float[] r8 = r1.mModelViewMatrix     // Catch:{ all -> 0x00d8 }
            r10 = 0
            android.opengl.Matrix.translateM(r8, r9, r7, r5, r10)     // Catch:{ all -> 0x00d8 }
            float[] r5 = r1.mModelViewMatrix     // Catch:{ all -> 0x00d8 }
            r17 = 0
            int r7 = r29.getRotationAngle()     // Catch:{ all -> 0x00d8 }
            float r7 = (float) r7     // Catch:{ all -> 0x00d8 }
            r19 = 0
            r20 = 0
            r21 = 1065353216(0x3f800000, float:1.0)
            r16 = r5
            r18 = r7
            android.opengl.Matrix.rotateM(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x00d8 }
            float[] r5 = r1.mModelViewMatrix     // Catch:{ all -> 0x00d8 }
            r23 = 0
            r24 = 0
            r25 = 1065353216(0x3f800000, float:1.0)
            r26 = 0
            r27 = 0
            r22 = r5
            android.opengl.Matrix.rotateM(r22, r23, r24, r25, r26, r27)     // Catch:{ all -> 0x00d8 }
            float[] r5 = r1.mModelViewMatrix     // Catch:{ all -> 0x00d8 }
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 1065353216(0x3f800000, float:1.0)
            r21 = 0
            r16 = r5
            android.opengl.Matrix.rotateM(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x00d8 }
            r5 = 0
            r13 = 0
            r16 = 0
        L_0x0094:
            if (r13 >= r15) goto L_0x00d6
            char r7 = r2.charAt(r13)     // Catch:{ all -> 0x00d8 }
            int r7 = r7 + -32
            if (r7 < 0) goto L_0x00a6
            r8 = 96
            if (r7 < r8) goto L_0x00a3
            goto L_0x00a6
        L_0x00a3:
            r17 = r7
            goto L_0x00aa
        L_0x00a6:
            r7 = 95
            r17 = 95
        L_0x00aa:
            com.wowza.gocoder.sdk.support.a.a.a.c r7 = r3.f3540w     // Catch:{ all -> 0x00d8 }
            com.wowza.gocoder.sdk.support.a.a.a.e[] r8 = r3.f3531n     // Catch:{ all -> 0x00d8 }
            r12 = r8[r17]     // Catch:{ all -> 0x00d8 }
            float[] r11 = r1.mModelViewMatrix     // Catch:{ all -> 0x00d8 }
            r8 = r16
            r9 = r5
            r10 = r14
            r18 = r11
            r11 = r6
            r19 = r13
            r13 = r18
            r7.mo59014a(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00d8 }
            float[] r7 = r3.f3530m     // Catch:{ all -> 0x00d8 }
            r7 = r7[r17]     // Catch:{ all -> 0x00d8 }
            float r8 = r29.getSpacing()     // Catch:{ all -> 0x00d8 }
            float r7 = r7 + r8
            float r7 = r7 * r4
            float r16 = r16 + r7
            int r13 = r19 + 1
            goto L_0x0094
        L_0x00d6:
            monitor-exit(r28)
            return
        L_0x00d8:
            r0 = move-exception
            monitor-exit(r28)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.android.graphics.WOWZTextManager.m3484a(com.wowza.gocoder.sdk.api.android.graphics.WOWZText, com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES$EglEnv, com.wowza.gocoder.sdk.api.geometry.WOWZSize, int):void");
    }

    /* renamed from: a */
    private synchronized void m3486a(WOWZSize wOWZSize) {
        Matrix.setIdentityM(this.mModelViewMatrix, 0);
        Matrix.setIdentityM(this.mDisplayProjectionMatrix, 0);
        Matrix.orthoM(this.mDisplayProjectionMatrix, 0, 0.0f, (float) wOWZSize.width, 0.0f, (float) wOWZSize.height, -1.0f, 1.0f);
        Iterator<WOWZText> it = this.mTextObjects.iterator();
        while (it.hasNext()) {
            it.next().setFrameSize(wOWZSize);
        }
        Matrix.multiplyMM(this.mScratchMatrix, 0, this.mDisplayProjectionMatrix, 0, this.mModelViewMatrix, 0);
        this.mViewMatrixReady = true;
    }

    /* compiled from: GoCoderSDK */
    public static class Font {
        public static final int CHAR_BATCH_SIZE = 24;
        public static final int CHAR_CNT = 96;
        public static final int CHAR_END = 126;
        public static final int CHAR_NONE = 32;
        public static final int CHAR_START = 32;
        public static final int CHAR_UNKNOWN = 95;
        public static final int FONT_SIZE_MAX = 180;
        public static final int FONT_SIZE_MIN = 6;

        /* renamed from: a */
        private static final String f3518a = "Font";
        /* access modifiers changed from: private */

        /* renamed from: b */
        public UUID f3519b = null;

        /* renamed from: c */
        private AssetManager f3520c;

        /* renamed from: d */
        private String f3521d;

        /* renamed from: e */
        private int f3522e;

        /* renamed from: f */
        private int f3523f;

        /* renamed from: g */
        private int f3524g;

        /* renamed from: h */
        private float f3525h;

        /* renamed from: i */
        private float f3526i;

        /* renamed from: j */
        private float f3527j;

        /* renamed from: k */
        private float f3528k;

        /* renamed from: l */
        private float f3529l;
        /* access modifiers changed from: private */

        /* renamed from: m */
        public float[] f3530m;
        /* access modifiers changed from: private */

        /* renamed from: n */
        public C4266e[] f3531n;
        /* access modifiers changed from: private */

        /* renamed from: o */
        public int f3532o;
        /* access modifiers changed from: private */

        /* renamed from: p */
        public int f3533p;

        /* renamed from: q */
        private int f3534q;

        /* renamed from: r */
        private int f3535r;

        /* renamed from: s */
        private int f3536s;

        /* renamed from: t */
        private int f3537t;

        /* renamed from: u */
        private C4266e f3538u;

        /* renamed from: v */
        private C4262b f3539v;
        /* access modifiers changed from: private */

        /* renamed from: w */
        public C4264c f3540w;

        /* renamed from: x */
        private int f3541x;

        /* renamed from: y */
        private int f3542y;

        /* renamed from: z */
        private boolean f3543z;

        Font(AssetManager assetManager, String str, int i, int i2, int i3) {
            m3489a(assetManager, str, i, i2, i3);
        }

        public UUID getFontId() {
            return this.f3519b;
        }

        public String getFileName() {
            return this.f3521d;
        }

        public int getFontSize() {
            return this.f3522e;
        }

        public float getFontHeight() {
            return this.f3525h;
        }

        public int getFontPadX() {
            return this.f3523f;
        }

        public int getFontPadY() {
            return this.f3524g;
        }

        public float getFontAscent() {
            return this.f3526i;
        }

        public float getFontDescent() {
            return this.f3527j;
        }

        public float getCharWidthMax() {
            return this.f3528k;
        }

        public float[] getCharWidths() {
            return this.f3530m;
        }

        public float getCharHeight() {
            return this.f3529l;
        }

        public int getCellWidth() {
            return this.f3532o;
        }

        public int getCellHeight() {
            return this.f3533p;
        }

        public float getLength(String str, float f) {
            int length = str.length();
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i = 0; i < length; i++) {
                f3 += this.f3530m[str.charAt(i) - ' '] * f;
            }
            if (length > 1) {
                f2 = ((float) (length - 1)) * f * f;
            }
            return f3 + f2;
        }

        public float getCharWidth(char c, float f) {
            return this.f3530m[c - ' '] * f;
        }

        public float getCharWidthMax(float f) {
            return this.f3528k * f;
        }

        public float getCharHeight(float f) {
            return this.f3529l * f;
        }

        public float getFontAscent(float f) {
            return this.f3526i * f;
        }

        public float getFontDescent(float f) {
            return this.f3527j * f;
        }

        /* renamed from: a */
        private void m3489a(AssetManager assetManager, String str, int i, int i2, int i3) {
            this.f3519b = UUID.randomUUID();
            this.f3520c = assetManager;
            this.f3521d = str;
            this.f3522e = i;
            this.f3523f = i2;
            this.f3524g = i3;
            this.f3525h = 0.0f;
            this.f3526i = 0.0f;
            this.f3527j = 0.0f;
            this.f3536s = -1;
            this.f3537t = 0;
            this.f3528k = 0.0f;
            this.f3529l = 0.0f;
            this.f3530m = new float[96];
            this.f3531n = new C4266e[96];
            this.f3532o = 0;
            this.f3533p = 0;
            this.f3534q = 0;
            this.f3535r = 0;
            this.f3539v = null;
            this.f3540w = null;
            this.f3541x = -1;
            this.f3542y = -1;
            this.f3543z = false;
        }

        /* access modifiers changed from: protected */
        public boolean load() {
            Typeface createFromAsset = Typeface.createFromAsset(this.f3520c, this.f3521d);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setTextSize((float) this.f3522e);
            paint.setColor(-1);
            paint.setTypeface(createFromAsset);
            this.f3539v = new C4261a();
            this.f3539v.mo58978a();
            this.f3540w = new C4264c(24, this.f3539v);
            this.f3530m = new float[96];
            this.f3531n = new C4266e[96];
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            this.f3525h = (float) Math.ceil((double) (Math.abs(fontMetrics.bottom) + Math.abs(fontMetrics.top)));
            this.f3526i = (float) Math.ceil((double) Math.abs(fontMetrics.ascent));
            this.f3527j = (float) Math.ceil((double) Math.abs(fontMetrics.descent));
            char[] cArr = new char[2];
            this.f3529l = 0.0f;
            this.f3528k = 0.0f;
            float[] fArr = new float[2];
            int i = 0;
            for (char c = ' '; c <= '~'; c = (char) (c + 1)) {
                cArr[0] = c;
                paint.getTextWidths(cArr, 0, 1, fArr);
                float[] fArr2 = this.f3530m;
                fArr2[i] = fArr[0];
                if (fArr2[i] > this.f3528k) {
                    this.f3528k = fArr2[i];
                }
                i++;
            }
            cArr[0] = ' ';
            paint.getTextWidths(cArr, 0, 1, fArr);
            float[] fArr3 = this.f3530m;
            fArr3[i] = fArr[0];
            if (fArr3[i] > this.f3528k) {
                this.f3528k = fArr3[i];
            }
            this.f3529l = this.f3525h;
            this.f3532o = ((int) this.f3528k) + (this.f3523f * 2);
            this.f3533p = ((int) this.f3529l) + (this.f3524g * 2);
            int i2 = this.f3532o;
            int i3 = this.f3533p;
            if (i2 <= i3) {
                i2 = i3;
            }
            if (i2 < 6 || i2 > 180) {
                return false;
            }
            if (i2 <= 24) {
                this.f3537t = 256;
            } else if (i2 <= 40) {
                this.f3537t = 512;
            } else if (i2 <= 80) {
                this.f3537t = 1024;
            } else {
                this.f3537t = 2048;
            }
            int i4 = this.f3537t;
            Bitmap createBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ALPHA_8);
            Canvas canvas = new Canvas(createBitmap);
            createBitmap.eraseColor(0);
            this.f3535r = this.f3537t / this.f3532o;
            this.f3534q = (int) Math.ceil((double) (96.0f / ((float) this.f3535r)));
            float f = (float) this.f3523f;
            float f2 = (((float) (this.f3533p - 1)) - this.f3527j) - ((float) this.f3524g);
            char c2 = ' ';
            while (c2 <= '~') {
                cArr[0] = c2;
                char c3 = c2;
                Canvas canvas2 = canvas;
                Bitmap bitmap = createBitmap;
                canvas.drawText(cArr, 0, 1, f, f2, paint);
                int i5 = this.f3532o;
                f += (float) i5;
                int i6 = this.f3523f;
                if ((f + ((float) i5)) - ((float) i6) > ((float) this.f3537t)) {
                    f2 += (float) this.f3533p;
                    f = (float) i6;
                }
                c2 = (char) (c3 + 1);
                canvas = canvas2;
                createBitmap = bitmap;
            }
            cArr[0] = ' ';
            canvas.drawText(cArr, 0, 1, f, f2, paint);
            this.f3536s = C4265d.m3743a(createBitmap);
            float f3 = 0.0f;
            float f4 = 0.0f;
            for (int i7 = 0; i7 < 96; i7++) {
                C4266e[] eVarArr = this.f3531n;
                int i8 = this.f3537t;
                eVarArr[i7] = new C4266e((float) i8, (float) i8, f3, f4, (float) (this.f3532o - 1), (float) (this.f3533p - 1));
                int i9 = this.f3532o;
                f3 += (float) i9;
                if (((float) i9) + f3 > ((float) this.f3537t)) {
                    f4 += (float) this.f3533p;
                    f3 = 0.0f;
                }
            }
            int i10 = this.f3537t;
            this.f3538u = new C4266e((float) i10, (float) i10, 0.0f, 0.0f, (float) i10, (float) i10);
            this.f3541x = GLES20.glGetUniformLocation(this.f3539v.mo58980b(), "u_Color");
            this.f3542y = GLES20.glGetUniformLocation(this.f3539v.mo58980b(), "u_Texture");
            this.f3543z = true;
            return true;
        }

        /* access modifiers changed from: protected */
        public void release() {
            GLES20.glDeleteTextures(1, new int[]{this.f3536s}, 0);
            this.f3536s = -1;
            this.f3539v.mo58981c();
            this.f3539v = null;
        }

        /* access modifiers changed from: protected */
        public void activate(WOWZColor wOWZColor, float[] fArr) {
            GLES20.glUseProgram(this.f3539v.mo58980b());
            setColor(wOWZColor);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.f3536s);
            GLES20.glUniform1i(this.f3542y, 0);
            this.f3540w.mo59015a(fArr);
        }

        /* access modifiers changed from: protected */
        public void setColor(WOWZColor wOWZColor) {
            GLES20.glUniform4fv(this.f3541x, 1, wOWZColor.toArray(), 0);
            GLES20.glEnableVertexAttribArray(this.f3541x);
        }

        /* access modifiers changed from: protected */
        public void deactivate() {
            this.f3540w.mo59013a();
            GLES20.glDisableVertexAttribArray(this.f3541x);
        }
    }
}
