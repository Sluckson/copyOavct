package com.wowza.gocoder.sdk.api.android.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.gms.gcm.Task;
import com.wowza.gocoder.sdk.api.android.opengl.WOWZGLES;
import com.wowza.gocoder.sdk.api.geometry.WOWZPoint;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.gles.GlUtil;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.render.WOWZRenderAPI;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* compiled from: GoCoderSDK */
public class WOWZBitmap implements WOWZRenderAPI.VideoFrameRenderer {
    public static final int BOTTOM = -5;
    public static final int CENTER = -1;
    public static final int CURRENT_SIZE = -9;
    public static final int FRAME_HEIGHT = -7;
    public static final int FRAME_WIDTH = -6;
    public static final int LEFT = -2;
    public static final int ORIGINAL_SIZE = -8;
    public static final int RIGHT = -3;
    public static final int SURFACE_HEIGHT = -7;
    public static final int SURFACE_WIDTH = -6;
    public static final int TOP = -4;

    /* renamed from: c */
    private static final String f3483c = "WOWZBitmap";

    /* renamed from: d */
    private static final int f3484d = 4;

    /* renamed from: e */
    private static final float[] f3485e = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};

    /* renamed from: f */
    private static final float[] f3486f = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: g */
    private static final FloatBuffer f3487g = GlUtil.createFloatBuffer(f3485e);

    /* renamed from: h */
    private static final FloatBuffer f3488h = GlUtil.createFloatBuffer(f3486f);

    /* renamed from: q */
    private static final int f3489q = 9;

    /* renamed from: r */
    private static final String f3490r = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: s */
    private static final String f3491s = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";

    /* renamed from: A */
    private int f3492A;

    /* renamed from: B */
    private int f3493B;

    /* renamed from: C */
    private float[] f3494C = new float[9];

    /* renamed from: D */
    private float[] f3495D;

    /* renamed from: E */
    private float f3496E;

    /* renamed from: a */
    private WOWZSize f3497a;

    /* renamed from: b */
    private ByteBuffer f3498b;

    /* renamed from: i */
    private FloatBuffer f3499i;

    /* renamed from: j */
    private FloatBuffer f3500j;

    /* renamed from: k */
    private int f3501k;

    /* renamed from: l */
    private int f3502l;

    /* renamed from: m */
    private int f3503m;
    protected Bitmap mBitmap;
    protected float[] mDisplayProjectionMatrix;
    protected WOWZSize mDisplaySize;
    protected WOWZPoint mPosition;
    protected int mRotationAngle;
    protected float mScale;
    protected int mScaleBasis;
    protected WOWZSize mSourceSize;
    protected int[] mTextures;
    protected boolean mViewMatrixReady;
    protected boolean mVisible;

    /* renamed from: n */
    private int f3504n;

    /* renamed from: o */
    private float[] f3505o;

    /* renamed from: p */
    private float[] f3506p = new float[16];

    /* renamed from: t */
    private int f3507t;

    /* renamed from: u */
    private int f3508u;

    /* renamed from: v */
    private int f3509v;

    /* renamed from: w */
    private int f3510w;

    /* renamed from: x */
    private int f3511x;

    /* renamed from: y */
    private int f3512y;

    /* renamed from: z */
    private int f3513z;

    public WOWZBitmap() {
        init();
    }

    public WOWZBitmap(Bitmap bitmap) {
        init();
        setBitmap(bitmap);
    }

    public WOWZBitmap(byte[] bArr) {
        init();
        setBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
    }

    /* access modifiers changed from: protected */
    public void init() {
        this.mBitmap = null;
        this.mSourceSize = new WOWZSize(0, 0);
        this.mDisplaySize = new WOWZSize(0, 0);
        this.f3497a = new WOWZSize(0, 0);
        this.mScaleBasis = -8;
        this.mScale = 1.0f;
        this.mRotationAngle = 0;
        this.mPosition = new WOWZPoint(-1, -1);
        this.mViewMatrixReady = false;
        this.f3499i = f3487g;
        this.f3500j = f3488h;
        this.f3502l = 2;
        int i = this.f3502l;
        this.f3503m = i * 4;
        this.f3501k = f3485e.length / i;
        this.mTextures = null;
        this.f3504n = 8;
        this.mVisible = true;
    }

    public synchronized void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        this.mSourceSize.set(0, 0);
        m3481c(this.mSourceSize);
        if (this.mBitmap != null) {
            this.mSourceSize.set(this.mBitmap.getWidth(), this.mBitmap.getHeight());
            m3481c(this.mSourceSize);
        }
        if (this.mTextures != null) {
            m3475a(this.mBitmap);
        }
    }

    public synchronized WOWZSize getSourceSize() {
        return this.mSourceSize;
    }

    public synchronized WOWZSize getDisplaySize() {
        return this.mDisplaySize;
    }

    public synchronized int getScaleBasis() {
        return this.mScaleBasis;
    }

    public synchronized float getScale() {
        return this.mScale;
    }

    public synchronized WOWZPoint getPosition() {
        return this.mPosition;
    }

    public synchronized int getRotationAngle() {
        return this.mRotationAngle;
    }

    public synchronized void setWidth(int i) {
        setScale(1.0f);
        m3474a(i, Math.round(((float) i) * this.mDisplaySize.inverted().aspectRatio()));
    }

    public synchronized void setHeight(int i) {
        setScale(1.0f);
        m3474a(Math.round(((float) i) * this.mDisplaySize.aspectRatio()), i);
    }

    public synchronized void setScale(float f) {
        setScale(f, -8);
    }

    public synchronized void setScale(float f, int i) {
        this.mScale = f;
        this.mScaleBasis = i;
        this.mViewMatrixReady = false;
    }

    public synchronized void setPosition(WOWZPoint wOWZPoint) {
        setPosition(wOWZPoint.f3734x, wOWZPoint.f3735y);
    }

    public synchronized void setPosition(int i, int i2) {
        this.mPosition.f3734x = i;
        this.mPosition.f3735y = i2;
        this.mViewMatrixReady = false;
    }

    public synchronized void setRotation(int i) {
        this.mRotationAngle = i;
        this.mViewMatrixReady = false;
    }

    public synchronized void setVisible(boolean z) {
        this.mVisible = z;
    }

    public synchronized boolean isVisible() {
        return this.mVisible;
    }

    public boolean isWZVideoFrameRendererActive() {
        return this.mBitmap != null && this.mVisible;
    }

    public void onWZVideoFrameRendererInit(WOWZGLES.EglEnv eglEnv) {
        m3475a(this.mBitmap);
        m3473a();
        m3483e(this.mSourceSize);
        this.f3497a.set(0, 0);
        this.mDisplayProjectionMatrix = new float[16];
        Matrix.setIdentityM(this.mDisplayProjectionMatrix, 0);
    }

    public void onWZVideoFrameRendererDraw(WOWZGLES.EglEnv eglEnv, WOWZSize wOWZSize, int i) {
        if (this.mTextures == null) {
            this.mTextures = new int[1];
            this.mTextures[0] = m3472a(this.f3498b, this.mSourceSize.getWidth(), this.mSourceSize.getHeight(), 6408);
        }
        if (!this.mViewMatrixReady || !this.f3497a.equals(wOWZSize)) {
            m3476a(wOWZSize);
        }
        this.f3497a.set(wOWZSize);
        Matrix.multiplyMM(this.f3506p, 0, this.mDisplayProjectionMatrix, 0, this.f3505o, 0);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        m3478a(this.f3506p, this.f3499i, 0, this.f3501k, this.f3502l, this.f3503m, GlUtil.IDENTITY_MATRIX, this.f3500j, this.mTextures[0], this.f3504n);
        GLES20.glDisable(3042);
    }

    public void onWZVideoFrameRendererRelease(WOWZGLES.EglEnv eglEnv) {
        int i = this.f3507t;
        if (i != -1) {
            GLES20.glDeleteProgram(i);
        }
        int[] iArr = this.mTextures;
        if (iArr != null) {
            GLES20.glDeleteTextures(1, iArr, 0);
        }
        this.mTextures = null;
        this.f3507t = -1;
        this.mViewMatrixReady = false;
    }

    /* renamed from: a */
    private void m3475a(Bitmap bitmap) {
        int[] iArr = this.mTextures;
        if (iArr != null) {
            GLES20.glDeleteTextures(1, iArr, 0);
            this.mTextures = null;
        }
        if (bitmap != null) {
            this.f3498b = ByteBuffer.allocateDirect(bitmap.getHeight() * bitmap.getRowBytes());
            bitmap.copyPixelsToBuffer(this.f3498b);
            this.f3498b.position(0);
        }
    }

    /* renamed from: a */
    private synchronized void m3476a(WOWZSize wOWZSize) {
        WOWZSize wOWZSize2 = wOWZSize;
        synchronized (this) {
            float[] fArr = this.f3505o;
            Matrix.setIdentityM(fArr, 0);
            m3480b(wOWZSize);
            WOWZPoint d = m3482d(wOWZSize);
            Matrix.translateM(fArr, 0, (float) d.f3734x, (float) d.f3735y, 0.0f);
            if (((float) this.mRotationAngle) != 0.0f) {
                Matrix.rotateM(fArr, 0, (float) this.mRotationAngle, 0.0f, 0.0f, 1.0f);
            }
            Matrix.scaleM(fArr, 0, (float) this.mDisplaySize.width, (float) this.mDisplaySize.height, 1.0f);
            Matrix.setIdentityM(this.mDisplayProjectionMatrix, 0);
            Matrix.orthoM(this.mDisplayProjectionMatrix, 0, 0.0f, (float) wOWZSize2.width, 0.0f, (float) wOWZSize2.height, -1.0f, 1.0f);
            this.mViewMatrixReady = true;
        }
    }

    /* renamed from: b */
    private synchronized void m3480b(WOWZSize wOWZSize) {
        int i = this.mDisplaySize.width;
        int i2 = this.mDisplaySize.height;
        int i3 = this.mScaleBasis;
        if (i3 == -9) {
            i = Math.round(((float) this.mDisplaySize.width) * this.mScale);
            i2 = Math.round(((float) this.mDisplaySize.height) * this.mScale);
        } else if (i3 == -8) {
            i = Math.round(((float) this.mSourceSize.width) * this.mScale);
            i2 = Math.round(((float) this.mSourceSize.height) * this.mScale);
        } else if (i3 == -7) {
            float aspectRatio = this.mSourceSize.aspectRatio();
            i2 = Math.round(((float) wOWZSize.height) * this.mScale);
            i = Math.round(((float) i2) * aspectRatio);
        } else if (i3 == -6) {
            float aspectRatio2 = this.mSourceSize.inverted().aspectRatio();
            int round = Math.round(((float) wOWZSize.width) * this.mScale);
            i2 = Math.round(((float) round) * aspectRatio2);
            i = round;
        }
        m3474a(i, i2);
    }

    /* renamed from: a */
    private synchronized void m3474a(int i, int i2) {
        this.mDisplaySize.width = i;
        this.mDisplaySize.height = i2;
        this.mViewMatrixReady = false;
    }

    /* renamed from: c */
    private synchronized void m3481c(WOWZSize wOWZSize) {
        m3474a(wOWZSize.width, wOWZSize.height);
    }

    /* renamed from: d */
    private synchronized WOWZPoint m3482d(WOWZSize wOWZSize) {
        WOWZPoint wOWZPoint;
        wOWZPoint = new WOWZPoint(this.mPosition);
        int i = this.mPosition.f3734x;
        if (i == -3) {
            wOWZPoint.f3734x = Math.round(((float) wOWZSize.width) - (((float) this.mDisplaySize.width) / 2.0f));
        } else if (i == -2) {
            wOWZPoint.f3734x = Math.round(((float) this.mDisplaySize.width) / 2.0f);
        } else if (i == -1) {
            wOWZPoint.f3734x = Math.round(((float) wOWZSize.width) / 2.0f);
        }
        int i2 = this.mPosition.f3735y;
        if (i2 == -5) {
            wOWZPoint.f3735y = Math.round(((float) this.mDisplaySize.height) / 2.0f);
        } else if (i2 == -4) {
            wOWZPoint.f3735y = Math.round(((float) wOWZSize.height) - (((float) this.mDisplaySize.height) / 2.0f));
        } else if (i2 == -1) {
            wOWZPoint.f3735y = Math.round(((float) wOWZSize.height) / 2.0f);
        }
        return wOWZPoint;
    }

    /* renamed from: a */
    private void m3473a() {
        this.f3505o = new float[16];
        Matrix.setIdentityM(this.f3505o, 0);
    }

    /* renamed from: a */
    private int m3472a(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] == 0) {
            WOWZLog.error(f3483c, "glGenTextures failed. Cannot create texture handler");
            return 0;
        }
        int i4 = iArr[0];
        WOWZGLES.checkForEglError("glGenTextures");
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, Task.EXTRAS_LIMIT_BYTES, 9729);
        WOWZGLES.checkForEglError("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, byteBuffer);
        WOWZGLES.checkForEglError("loadImageTexture");
        return i4;
    }

    /* renamed from: e */
    private void m3483e(WOWZSize wOWZSize) {
        this.f3493B = 3553;
        this.f3507t = GlUtil.createProgram(f3490r, f3491s);
        this.f3513z = GLES20.glGetAttribLocation(this.f3507t, "aPosition");
        GlUtil.checkLocation(this.f3513z, "aPosition");
        this.f3492A = GLES20.glGetAttribLocation(this.f3507t, "aTextureCoord");
        GlUtil.checkLocation(this.f3492A, "aTextureCoord");
        this.f3508u = GLES20.glGetUniformLocation(this.f3507t, "uMVPMatrix");
        GlUtil.checkLocation(this.f3508u, "uMVPMatrix");
        this.f3509v = GLES20.glGetUniformLocation(this.f3507t, "uTexMatrix");
        GlUtil.checkLocation(this.f3509v, "uTexMatrix");
        this.f3510w = GLES20.glGetUniformLocation(this.f3507t, "uKernel");
        if (this.f3510w < 0) {
            this.f3510w = -1;
            this.f3511x = -1;
            this.f3512y = -1;
            return;
        }
        this.f3511x = GLES20.glGetUniformLocation(this.f3507t, "uTexOffset");
        GlUtil.checkLocation(this.f3511x, "uTexOffset");
        this.f3512y = GLES20.glGetUniformLocation(this.f3507t, "uColorAdjust");
        GlUtil.checkLocation(this.f3512y, "uColorAdjust");
        m3477a(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
        m3479b(wOWZSize.width, wOWZSize.height);
    }

    /* renamed from: a */
    private void m3477a(float[] fArr, float f) {
        if (fArr.length == 9) {
            System.arraycopy(fArr, 0, this.f3494C, 0, 9);
            this.f3496E = f;
            return;
        }
        throw new IllegalArgumentException("Kernel size is " + fArr.length + " vs. " + 9);
    }

    /* renamed from: b */
    private void m3479b(int i, int i2) {
        float f = 1.0f / ((float) i);
        float f2 = 1.0f / ((float) i2);
        float f3 = -f;
        float f4 = -f2;
        this.f3495D = new float[]{f3, f4, 0.0f, f4, f, f4, f3, 0.0f, 0.0f, 0.0f, f, 0.0f, f3, f2, 0.0f, f2, f, f2};
    }

    /* renamed from: a */
    private void m3478a(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        WOWZGLES.checkForEglError("WOWZBitmap.draw()");
        GLES20.glUseProgram(this.f3507t);
        WOWZGLES.checkForEglError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f3493B, i5);
        float[] fArr3 = fArr;
        GLES20.glUniformMatrix4fv(this.f3508u, 1, false, fArr, 0);
        WOWZGLES.checkForEglError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.f3509v, 1, false, fArr2, 0);
        WOWZGLES.checkForEglError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f3513z);
        WOWZGLES.checkForEglError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f3513z, i3, 5126, false, i4, floatBuffer);
        WOWZGLES.checkForEglError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f3492A);
        WOWZGLES.checkForEglError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f3492A, 2, 5126, false, i6, floatBuffer2);
        WOWZGLES.checkForEglError("glVertexAttribPointer");
        int i7 = this.f3510w;
        if (i7 >= 0) {
            GLES20.glUniform1fv(i7, 9, this.f3494C, 0);
            GLES20.glUniform2fv(this.f3511x, 9, this.f3495D, 0);
            GLES20.glUniform1f(this.f3512y, this.f3496E);
        }
        int i8 = i;
        int i9 = i2;
        GLES20.glDrawArrays(5, i, i2);
        WOWZGLES.checkForEglError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f3513z);
        GLES20.glDisableVertexAttribArray(this.f3492A);
        GLES20.glBindTexture(this.f3493B, 0);
        GLES20.glUseProgram(0);
    }
}
