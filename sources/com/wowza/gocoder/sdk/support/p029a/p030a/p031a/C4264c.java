package com.wowza.gocoder.sdk.support.p029a.p030a.p031a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.p032a.C4262b;

/* renamed from: com.wowza.gocoder.sdk.support.a.a.a.c */
/* compiled from: GoCoderSDK */
public class C4264c {

    /* renamed from: a */
    static final int f3958a = 5;

    /* renamed from: b */
    static final int f3959b = 4;

    /* renamed from: c */
    static final int f3960c = 6;

    /* renamed from: i */
    private static final String f3961i = "SpriteBatch";

    /* renamed from: d */
    C4269h f3962d;

    /* renamed from: e */
    float[] f3963e;

    /* renamed from: f */
    int f3964f;

    /* renamed from: g */
    int f3965g;

    /* renamed from: h */
    int f3966h;

    /* renamed from: j */
    private float[] f3967j;

    /* renamed from: k */
    private float[] f3968k = new float[384];

    /* renamed from: l */
    private int f3969l;

    /* renamed from: m */
    private float[] f3970m = new float[16];

    public C4264c(int i, C4262b bVar) {
        int i2 = i * 4;
        this.f3963e = new float[(i2 * 5)];
        int i3 = i * 6;
        this.f3962d = new C4269h(i2, i3);
        this.f3964f = 0;
        this.f3965g = i;
        this.f3966h = 0;
        short[] sArr = new short[i3];
        int length = sArr.length;
        int i4 = 0;
        short s = 0;
        while (i4 < length) {
            short s2 = (short) (s + 0);
            sArr[i4 + 0] = s2;
            sArr[i4 + 1] = (short) (s + 1);
            short s3 = (short) (s + 2);
            sArr[i4 + 2] = s3;
            sArr[i4 + 3] = s3;
            sArr[i4 + 4] = (short) (s + 3);
            sArr[i4 + 5] = s2;
            i4 += 6;
            s = (short) (s + 4);
        }
        this.f3962d.mo59020a(sArr, 0, length);
        this.f3969l = GLES20.glGetUniformLocation(bVar.mo58980b(), "u_MVPMatrix");
    }

    /* renamed from: a */
    public void mo59015a(float[] fArr) {
        this.f3966h = 0;
        this.f3964f = 0;
        this.f3967j = fArr;
    }

    /* renamed from: a */
    public void mo59013a() {
        int i = this.f3966h;
        if (i > 0) {
            GLES20.glUniformMatrix4fv(this.f3969l, i, false, this.f3968k, 0);
            GLES20.glEnableVertexAttribArray(this.f3969l);
            this.f3962d.mo59019a(this.f3963e, 0, this.f3964f);
            this.f3962d.mo59017a();
            this.f3962d.mo59018a(4, 0, this.f3966h * 6);
            this.f3962d.mo59021b();
        }
    }

    /* renamed from: a */
    public void mo59014a(float f, float f2, float f3, float f4, C4266e eVar, float[] fArr) {
        if (this.f3966h == this.f3965g) {
            mo59013a();
            this.f3966h = 0;
            this.f3964f = 0;
        }
        float f5 = f3 / 2.0f;
        float f6 = f4 / 2.0f;
        float f7 = f - f5;
        float f8 = f2 - f6;
        float f9 = f + f5;
        float f10 = f2 + f6;
        float[] fArr2 = this.f3963e;
        int i = this.f3964f;
        this.f3964f = i + 1;
        fArr2[i] = f7;
        int i2 = this.f3964f;
        this.f3964f = i2 + 1;
        fArr2[i2] = f8;
        int i3 = this.f3964f;
        this.f3964f = i3 + 1;
        fArr2[i3] = eVar.f3971a;
        float[] fArr3 = this.f3963e;
        int i4 = this.f3964f;
        this.f3964f = i4 + 1;
        fArr3[i4] = eVar.f3974d;
        float[] fArr4 = this.f3963e;
        int i5 = this.f3964f;
        this.f3964f = i5 + 1;
        fArr4[i5] = (float) this.f3966h;
        int i6 = this.f3964f;
        this.f3964f = i6 + 1;
        fArr4[i6] = f9;
        int i7 = this.f3964f;
        this.f3964f = i7 + 1;
        fArr4[i7] = f8;
        int i8 = this.f3964f;
        this.f3964f = i8 + 1;
        fArr4[i8] = eVar.f3973c;
        float[] fArr5 = this.f3963e;
        int i9 = this.f3964f;
        this.f3964f = i9 + 1;
        fArr5[i9] = eVar.f3974d;
        float[] fArr6 = this.f3963e;
        int i10 = this.f3964f;
        this.f3964f = i10 + 1;
        fArr6[i10] = (float) this.f3966h;
        int i11 = this.f3964f;
        this.f3964f = i11 + 1;
        fArr6[i11] = f9;
        int i12 = this.f3964f;
        this.f3964f = i12 + 1;
        fArr6[i12] = f10;
        int i13 = this.f3964f;
        this.f3964f = i13 + 1;
        fArr6[i13] = eVar.f3973c;
        float[] fArr7 = this.f3963e;
        int i14 = this.f3964f;
        this.f3964f = i14 + 1;
        fArr7[i14] = eVar.f3972b;
        float[] fArr8 = this.f3963e;
        int i15 = this.f3964f;
        this.f3964f = i15 + 1;
        fArr8[i15] = (float) this.f3966h;
        int i16 = this.f3964f;
        this.f3964f = i16 + 1;
        fArr8[i16] = f7;
        int i17 = this.f3964f;
        this.f3964f = i17 + 1;
        fArr8[i17] = f10;
        int i18 = this.f3964f;
        this.f3964f = i18 + 1;
        fArr8[i18] = eVar.f3971a;
        float[] fArr9 = this.f3963e;
        int i19 = this.f3964f;
        this.f3964f = i19 + 1;
        fArr9[i19] = eVar.f3972b;
        float[] fArr10 = this.f3963e;
        int i20 = this.f3964f;
        this.f3964f = i20 + 1;
        fArr10[i20] = (float) this.f3966h;
        Matrix.multiplyMM(this.f3970m, 0, this.f3967j, 0, fArr, 0);
        for (int i21 = 0; i21 < 16; i21++) {
            this.f3968k[(this.f3966h * 16) + i21] = this.f3970m[i21];
        }
        this.f3966h++;
    }
}
