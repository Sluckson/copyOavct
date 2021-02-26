package com.wowza.gocoder.sdk.api.gles;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.FloatBuffer;

/* compiled from: GoCoderSDK */
public class FlatShadedProgram {

    /* renamed from: a */
    private static final String f3767a = "GlUtil";

    /* renamed from: b */
    private static final String f3768b = "uniform mat4 uMVPMatrix;attribute vec4 aPosition;void main() {    gl_Position = uMVPMatrix * aPosition;}";

    /* renamed from: c */
    private static final String f3769c = "precision mediump float;uniform vec4 uColor;void main() {    gl_FragColor = uColor;}";

    /* renamed from: d */
    private int f3770d;

    /* renamed from: e */
    private int f3771e;

    /* renamed from: f */
    private int f3772f;

    /* renamed from: g */
    private int f3773g;

    public FlatShadedProgram() {
        this.f3770d = -1;
        this.f3771e = -1;
        this.f3772f = -1;
        this.f3773g = -1;
        this.f3770d = GlUtil.createProgram(f3768b, f3769c);
        if (this.f3770d != 0) {
            Log.d("GlUtil", "Created program " + this.f3770d);
            this.f3773g = GLES20.glGetAttribLocation(this.f3770d, "aPosition");
            GlUtil.checkLocation(this.f3773g, "aPosition");
            this.f3772f = GLES20.glGetUniformLocation(this.f3770d, "uMVPMatrix");
            GlUtil.checkLocation(this.f3772f, "uMVPMatrix");
            this.f3771e = GLES20.glGetUniformLocation(this.f3770d, "uColor");
            GlUtil.checkLocation(this.f3771e, "uColor");
            return;
        }
        throw new RuntimeException("Unable to create program.");
    }

    public void release() {
        GLES20.glDeleteProgram(this.f3770d);
        this.f3770d = -1;
    }

    public void draw(float[] fArr, float[] fArr2, FloatBuffer floatBuffer, int i, int i2, int i3, int i4) {
        GlUtil.checkGlError("draw start");
        GLES20.glUseProgram(this.f3770d);
        GlUtil.checkGlError("glUseProgram");
        float[] fArr3 = fArr;
        GLES20.glUniformMatrix4fv(this.f3772f, 1, false, fArr, 0);
        GlUtil.checkGlError("glUniformMatrix4fv");
        float[] fArr4 = fArr2;
        GLES20.glUniform4fv(this.f3771e, 1, fArr2, 0);
        GlUtil.checkGlError("glUniform4fv ");
        GLES20.glEnableVertexAttribArray(this.f3773g);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.f3773g, i3, 5126, false, i4, floatBuffer);
        GlUtil.checkGlError("glVertexAttribPointer");
        int i5 = i;
        int i6 = i2;
        GLES20.glDrawArrays(5, i, i2);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.f3773g);
        GLES20.glUseProgram(0);
    }
}
