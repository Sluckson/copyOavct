package com.wowza.gocoder.sdk.support.p029a.p030a.p031a;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.wowza.gocoder.sdk.support.a.a.a.f */
/* compiled from: GoCoderSDK */
class C4267f {

    /* renamed from: a */
    static final int f3975a = 3;

    /* renamed from: b */
    static float[] f3976b = {0.0f, 31.100422f, 0.0f, -25.0f, -15.550213f, 0.0f, 25.0f, -15.550213f, 0.0f};

    /* renamed from: c */
    float[] f3977c;

    /* renamed from: d */
    private final String f3978d = "uniform mat4 uMVPMatrix;attribute vec4 vPosition;void main() {  gl_Position = vPosition * uMVPMatrix;}";

    /* renamed from: e */
    private final String f3979e = "precision mediump float;uniform vec4 vColor;void main() {  gl_FragColor = vColor;}";

    /* renamed from: f */
    private final FloatBuffer f3980f;

    /* renamed from: g */
    private final int f3981g;

    /* renamed from: h */
    private int f3982h;

    /* renamed from: i */
    private int f3983i;

    /* renamed from: j */
    private int f3984j;

    /* renamed from: k */
    private final int f3985k;

    /* renamed from: l */
    private final int f3986l;

    /* renamed from: a */
    public static int m3744a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    public C4267f() {
        float[] fArr = f3976b;
        this.f3985k = fArr.length / 3;
        this.f3986l = 12;
        this.f3977c = new float[]{0.63671875f, 0.76953125f, 0.22265625f, 1.0f};
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.f3980f = allocateDirect.asFloatBuffer();
        this.f3980f.put(f3976b);
        this.f3980f.position(0);
        int a = m3744a(35633, "uniform mat4 uMVPMatrix;attribute vec4 vPosition;void main() {  gl_Position = vPosition * uMVPMatrix;}");
        int a2 = m3744a(35632, "precision mediump float;uniform vec4 vColor;void main() {  gl_FragColor = vColor;}");
        this.f3981g = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.f3981g, a);
        GLES20.glAttachShader(this.f3981g, a2);
        GLES20.glLinkProgram(this.f3981g);
    }

    /* renamed from: a */
    public void mo59016a(float[] fArr) {
        GLES20.glUseProgram(this.f3981g);
        this.f3982h = GLES20.glGetAttribLocation(this.f3981g, "vPosition");
        GLES20.glEnableVertexAttribArray(this.f3982h);
        GLES20.glVertexAttribPointer(this.f3982h, 3, 5126, false, 12, this.f3980f);
        this.f3983i = GLES20.glGetUniformLocation(this.f3981g, "vColor");
        GLES20.glUniform4fv(this.f3983i, 1, this.f3977c, 0);
        this.f3984j = GLES20.glGetUniformLocation(this.f3981g, "uMVPMatrix");
        GLES20.glUniformMatrix4fv(this.f3984j, 1, false, fArr, 0);
        GLES20.glDrawArrays(4, 0, this.f3985k);
        GLES20.glDisableVertexAttribArray(this.f3982h);
    }
}
