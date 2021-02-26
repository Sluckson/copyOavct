package com.wowza.gocoder.sdk.api.gles;

import android.opengl.GLES20;
import com.google.android.gms.gcm.Task;
import java.nio.FloatBuffer;

/* compiled from: GoCoderSDK */
public class Texture2dProgram {
    public static final int KERNEL_SIZE = 9;

    /* renamed from: a */
    private static final String f3789a = "GlUtil";

    /* renamed from: b */
    private static final String f3790b = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform vec2 uPosition;\nvoid main() {\n    vec2 texCoord = vTextureCoord.xy;\n    vec2 normCoord = 2.0 * texCoord - 1.0;\n    normCoord.x = normCoord.x * sign(normCoord.x + uPosition.x);\n    texCoord = vec2(texCoord.s, 1.0 - texCoord.t);\n    gl_FragColor = texture2D(sTexture, texCoord);\n}\n";

    /* renamed from: c */
    private static final String f3791c = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: d */
    private static final String f3792d = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";

    /* renamed from: e */
    private static final String f3793e = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";

    /* renamed from: f */
    private static final String f3794f = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n    vec4 tc = texture2D(sTexture, vTextureCoord);\n    float color = tc.r * 0.3 + tc.g * 0.59 + tc.b * 0.11;\n    gl_FragColor = vec4(color, color, color, 1.0);\n}\n";

    /* renamed from: g */
    private static final String f3795g = "#extension GL_OES_EGL_image_external : require\n#define KERNEL_SIZE 9\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uKernel[KERNEL_SIZE];\nuniform vec2 uTexOffset[KERNEL_SIZE];\nuniform float uColorAdjust;\nvoid main() {\n    int i = 0;\n    vec4 sum = vec4(0.0);\n    if (vTextureCoord.x < vTextureCoord.y - 0.005) {\n        for (i = 0; i < KERNEL_SIZE; i++) {\n            vec4 texc = texture2D(sTexture, vTextureCoord + uTexOffset[i]);\n            sum += texc * uKernel[i];\n        }\n    sum += uColorAdjust;\n    } else if (vTextureCoord.x > vTextureCoord.y + 0.005) {\n        sum = texture2D(sTexture, vTextureCoord);\n    } else {\n        sum.r = 1.0;\n    }\n    gl_FragColor = sum;\n}\n";

    /* renamed from: h */
    private ProgramType f3796h;

    /* renamed from: i */
    private int f3797i;

    /* renamed from: j */
    private int f3798j;

    /* renamed from: k */
    private int f3799k;

    /* renamed from: l */
    private int f3800l;

    /* renamed from: m */
    private int f3801m;

    /* renamed from: n */
    private int f3802n;

    /* renamed from: o */
    private int f3803o;

    /* renamed from: p */
    private int f3804p;

    /* renamed from: q */
    private int f3805q;

    /* renamed from: r */
    private float[] f3806r = new float[9];

    /* renamed from: s */
    private float[] f3807s;

    /* renamed from: t */
    private float f3808t;

    /* compiled from: GoCoderSDK */
    public enum ProgramType {
        TEXTURE_2D,
        TEXTURE_EXT,
        TEXTURE_EXT_BW,
        TEXTURE_EXT_FILT,
        TEXTURE_EXT_MIRROR
    }

    public Texture2dProgram(ProgramType programType) {
        this.f3796h = programType;
        int i = C42371.f3809a[programType.ordinal()];
        if (i == 1) {
            this.f3805q = 3553;
            this.f3797i = GlUtil.createProgram(f3791c, f3792d);
        } else if (i == 2) {
            this.f3805q = 36197;
            this.f3797i = GlUtil.createProgram(f3791c, f3793e);
        } else if (i == 3) {
            this.f3805q = 36197;
            this.f3797i = GlUtil.createProgram(f3791c, f3794f);
        } else if (i == 4) {
            this.f3805q = 36197;
            this.f3797i = GlUtil.createProgram(f3791c, f3795g);
        } else if (i == 5) {
            this.f3805q = 36197;
            this.f3797i = GlUtil.createProgram(f3791c, f3790b);
        } else {
            throw new RuntimeException("Unhandled type " + programType);
        }
        int i2 = this.f3797i;
        if (i2 != 0) {
            this.f3803o = GLES20.glGetAttribLocation(i2, "aPosition");
            GlUtil.checkLocation(this.f3803o, "aPosition");
            this.f3804p = GLES20.glGetAttribLocation(this.f3797i, "aTextureCoord");
            GlUtil.checkLocation(this.f3804p, "aTextureCoord");
            this.f3798j = GLES20.glGetUniformLocation(this.f3797i, "uMVPMatrix");
            GlUtil.checkLocation(this.f3798j, "uMVPMatrix");
            this.f3799k = GLES20.glGetUniformLocation(this.f3797i, "uTexMatrix");
            GlUtil.checkLocation(this.f3799k, "uTexMatrix");
            this.f3800l = GLES20.glGetUniformLocation(this.f3797i, "uKernel");
            if (this.f3800l < 0) {
                this.f3800l = -1;
                this.f3801m = -1;
                this.f3802n = -1;
                return;
            }
            this.f3801m = GLES20.glGetUniformLocation(this.f3797i, "uTexOffset");
            GlUtil.checkLocation(this.f3801m, "uTexOffset");
            this.f3802n = GLES20.glGetUniformLocation(this.f3797i, "uColorAdjust");
            GlUtil.checkLocation(this.f3802n, "uColorAdjust");
            setKernel(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0.0f);
            setTexSize(256, 256);
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    /* renamed from: com.wowza.gocoder.sdk.api.gles.Texture2dProgram$1 */
    /* compiled from: GoCoderSDK */
    static /* synthetic */ class C42371 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3809a = new int[ProgramType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.wowza.gocoder.sdk.api.gles.Texture2dProgram$ProgramType[] r0 = com.wowza.gocoder.sdk.api.gles.Texture2dProgram.ProgramType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3809a = r0
                int[] r0 = f3809a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.wowza.gocoder.sdk.api.gles.Texture2dProgram$ProgramType r1 = com.wowza.gocoder.sdk.api.gles.Texture2dProgram.ProgramType.TEXTURE_2D     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f3809a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.wowza.gocoder.sdk.api.gles.Texture2dProgram$ProgramType r1 = com.wowza.gocoder.sdk.api.gles.Texture2dProgram.ProgramType.TEXTURE_EXT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f3809a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.wowza.gocoder.sdk.api.gles.Texture2dProgram$ProgramType r1 = com.wowza.gocoder.sdk.api.gles.Texture2dProgram.ProgramType.TEXTURE_EXT_BW     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f3809a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.wowza.gocoder.sdk.api.gles.Texture2dProgram$ProgramType r1 = com.wowza.gocoder.sdk.api.gles.Texture2dProgram.ProgramType.TEXTURE_EXT_FILT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f3809a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.wowza.gocoder.sdk.api.gles.Texture2dProgram$ProgramType r1 = com.wowza.gocoder.sdk.api.gles.Texture2dProgram.ProgramType.TEXTURE_EXT_MIRROR     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.gles.Texture2dProgram.C42371.<clinit>():void");
        }
    }

    public void release() {
        GLES20.glDeleteProgram(this.f3797i);
        this.f3797i = -1;
    }

    public ProgramType getProgramType() {
        return this.f3796h;
    }

    public int createTextureObject() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GlUtil.checkGlError("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(this.f3805q, i);
        GlUtil.checkGlError("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, Task.EXTRAS_LIMIT_BYTES, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GlUtil.checkGlError("glTexParameter");
        return i;
    }

    public void setKernel(float[] fArr, float f) {
        if (fArr.length == 9) {
            System.arraycopy(fArr, 0, this.f3806r, 0, 9);
            this.f3808t = f;
            return;
        }
        throw new IllegalArgumentException("Kernel size is " + fArr.length + " vs. " + 9);
    }

    public void setTexSize(int i, int i2) {
        float f = 1.0f / ((float) i);
        float f2 = 1.0f / ((float) i2);
        float f3 = -f;
        float f4 = -f2;
        this.f3807s = new float[]{f3, f4, 0.0f, f4, f, f4, f3, 0.0f, 0.0f, 0.0f, f, 0.0f, f3, f2, 0.0f, f2, f, f2};
    }

    public void draw(float[] fArr, FloatBuffer floatBuffer, int i, int i2, int i3, int i4, float[] fArr2, FloatBuffer floatBuffer2, int i5, int i6) {
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.f3797i);
        GlUtil.checkGlError("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.f3805q, i5);
        float[] fArr3 = fArr;
        GLES20.glUniformMatrix4fv(this.f3798j, 1, false, fArr, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glUniformMatrix4fv(this.f3799k, 1, false, fArr2, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        GLES20.glEnableVertexAttribArray(this.f3803o);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f3803o, i3, 5126, false, i4, floatBuffer);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.f3804p);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f3804p, 2, 5126, false, i6, floatBuffer2);
        GlUtil.checkGlError("glVertexAttribPointer");
        int i7 = this.f3800l;
        if (i7 >= 0) {
            GLES20.glUniform1fv(i7, 9, this.f3806r, 0);
            GLES20.glUniform2fv(this.f3801m, 9, this.f3807s, 0);
            GLES20.glUniform1f(this.f3802n, this.f3808t);
        }
        int i8 = i;
        int i9 = i2;
        GLES20.glDrawArrays(5, i, i2);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f3803o);
        GLES20.glDisableVertexAttribArray(this.f3804p);
        GLES20.glBindTexture(this.f3805q, 0);
        GLES20.glUseProgram(0);
    }
}
