package com.wowza.gocoder.sdk.api.gles;

import android.opengl.Matrix;

/* compiled from: GoCoderSDK */
public class Sprite2d {

    /* renamed from: a */
    private static final String f3777a = "GlUtil";

    /* renamed from: b */
    private Drawable2d f3778b;

    /* renamed from: c */
    private float[] f3779c;

    /* renamed from: d */
    private int f3780d;

    /* renamed from: e */
    private float f3781e;

    /* renamed from: f */
    private float f3782f;

    /* renamed from: g */
    private float f3783g;

    /* renamed from: h */
    private float f3784h;

    /* renamed from: i */
    private float f3785i;

    /* renamed from: j */
    private float[] f3786j;

    /* renamed from: k */
    private boolean f3787k;

    /* renamed from: l */
    private float[] f3788l = new float[16];

    public Sprite2d(Drawable2d drawable2d) {
        this.f3778b = drawable2d;
        this.f3779c = new float[4];
        this.f3779c[3] = 1.0f;
        this.f3780d = -1;
        this.f3786j = new float[16];
        this.f3787k = false;
    }

    /* renamed from: a */
    private void m3621a() {
        float[] fArr = this.f3786j;
        Matrix.setIdentityM(fArr, 0);
        Matrix.translateM(fArr, 0, this.f3784h, this.f3785i, 0.0f);
        float f = this.f3781e;
        if (f != 0.0f) {
            Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        }
        Matrix.scaleM(fArr, 0, this.f3782f, this.f3783g, 1.0f);
        this.f3787k = true;
    }

    public float getScaleX() {
        return this.f3782f;
    }

    public float getScaleY() {
        return this.f3783g;
    }

    public void setScale(float f, float f2) {
        this.f3782f = f;
        this.f3783g = f2;
        this.f3787k = false;
    }

    public float getRotation() {
        return this.f3781e;
    }

    public void setRotation(float f) {
        while (f >= 360.0f) {
            f -= 360.0f;
        }
        while (f <= -360.0f) {
            f += 360.0f;
        }
        this.f3781e = f;
        this.f3787k = false;
    }

    public float getPositionX() {
        return this.f3784h;
    }

    public float getPositionY() {
        return this.f3785i;
    }

    public void setPosition(float f, float f2) {
        this.f3784h = f;
        this.f3785i = f2;
        this.f3787k = false;
    }

    public float[] getModelViewMatrix() {
        if (!this.f3787k) {
            m3621a();
        }
        return this.f3786j;
    }

    public void setColor(float f, float f2, float f3) {
        float[] fArr = this.f3779c;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
    }

    public void setTexture(int i) {
        this.f3780d = i;
    }

    public float[] getColor() {
        return this.f3779c;
    }

    public void draw(FlatShadedProgram flatShadedProgram, float[] fArr) {
        Matrix.multiplyMM(this.f3788l, 0, fArr, 0, getModelViewMatrix(), 0);
        flatShadedProgram.draw(this.f3788l, this.f3779c, this.f3778b.getVertexArray(), 0, this.f3778b.getVertexCount(), this.f3778b.getCoordsPerVertex(), this.f3778b.getVertexStride());
    }

    public void draw(Texture2dProgram texture2dProgram, float[] fArr) {
        Matrix.multiplyMM(this.f3788l, 0, fArr, 0, getModelViewMatrix(), 0);
        Texture2dProgram texture2dProgram2 = texture2dProgram;
        texture2dProgram2.draw(this.f3788l, this.f3778b.getVertexArray(), 0, this.f3778b.getVertexCount(), this.f3778b.getCoordsPerVertex(), this.f3778b.getVertexStride(), GlUtil.IDENTITY_MATRIX, this.f3778b.getTexCoordArray(), this.f3780d, this.f3778b.getTexCoordStride());
    }

    public void draw(Texture2dProgram texture2dProgram, float[] fArr, float[] fArr2) {
        Matrix.multiplyMM(this.f3788l, 0, fArr, 0, getModelViewMatrix(), 0);
        Texture2dProgram texture2dProgram2 = texture2dProgram;
        float[] fArr3 = fArr2;
        texture2dProgram2.draw(this.f3788l, this.f3778b.getVertexArray(), 0, this.f3778b.getVertexCount(), this.f3778b.getCoordsPerVertex(), this.f3778b.getVertexStride(), fArr3, this.f3778b.getTexCoordArray(), this.f3780d, this.f3778b.getTexCoordStride());
    }

    public String toString() {
        return "[Sprite2d pos=" + this.f3784h + "," + this.f3785i + " scale=" + this.f3782f + "," + this.f3783g + " angle=" + this.f3781e + " color={" + this.f3779c[0] + "," + this.f3779c[1] + "," + this.f3779c[2] + "} drawable=" + this.f3778b + "]";
    }
}
