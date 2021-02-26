package com.wowza.gocoder.sdk.support.p029a.p030a.p031a;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.p032a.C4261a;
import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.p032a.C4262b;

/* renamed from: com.wowza.gocoder.sdk.support.a.a.a.b */
/* compiled from: GoCoderSDK */
public class C4263b {

    /* renamed from: D */
    private static final String f3925D = "b";

    /* renamed from: a */
    public static final int f3926a = 32;

    /* renamed from: b */
    public static final int f3927b = 126;

    /* renamed from: c */
    public static final int f3928c = 96;

    /* renamed from: d */
    public static final int f3929d = 32;

    /* renamed from: e */
    public static final int f3930e = 95;

    /* renamed from: f */
    public static final int f3931f = 6;

    /* renamed from: g */
    public static final int f3932g = 180;

    /* renamed from: h */
    public static final int f3933h = 24;

    /* renamed from: A */
    float f3934A;

    /* renamed from: B */
    float f3935B;

    /* renamed from: C */
    float f3936C;

    /* renamed from: E */
    private C4262b f3937E;

    /* renamed from: F */
    private int f3938F;

    /* renamed from: G */
    private int f3939G;

    /* renamed from: i */
    AssetManager f3940i;

    /* renamed from: j */
    C4264c f3941j;

    /* renamed from: k */
    int f3942k;

    /* renamed from: l */
    int f3943l;

    /* renamed from: m */
    float f3944m;

    /* renamed from: n */
    float f3945n;

    /* renamed from: o */
    float f3946o;

    /* renamed from: p */
    int f3947p;

    /* renamed from: q */
    int f3948q;

    /* renamed from: r */
    C4266e f3949r;

    /* renamed from: s */
    float f3950s;

    /* renamed from: t */
    float f3951t;

    /* renamed from: u */
    final float[] f3952u;

    /* renamed from: v */
    C4266e[] f3953v;

    /* renamed from: w */
    int f3954w;

    /* renamed from: x */
    int f3955x;

    /* renamed from: y */
    int f3956y;

    /* renamed from: z */
    int f3957z;

    public C4263b(C4262b bVar, AssetManager assetManager) {
        if (bVar == null) {
            bVar = new C4261a();
            bVar.mo58978a();
        }
        this.f3940i = assetManager;
        this.f3941j = new C4264c(24, bVar);
        this.f3952u = new float[96];
        this.f3953v = new C4266e[96];
        this.f3942k = 0;
        this.f3943l = 0;
        this.f3944m = 0.0f;
        this.f3945n = 0.0f;
        this.f3946o = 0.0f;
        this.f3947p = -1;
        this.f3948q = 0;
        this.f3950s = 0.0f;
        this.f3951t = 0.0f;
        this.f3954w = 0;
        this.f3955x = 0;
        this.f3956y = 0;
        this.f3957z = 0;
        this.f3934A = 1.0f;
        this.f3935B = 1.0f;
        this.f3936C = 0.0f;
        this.f3937E = bVar;
        this.f3938F = GLES20.glGetUniformLocation(this.f3937E.mo58980b(), "u_Color");
        this.f3939G = GLES20.glGetUniformLocation(this.f3937E.mo58980b(), "u_Texture");
    }

    public C4263b(AssetManager assetManager) {
        this((C4262b) null, assetManager);
    }

    /* renamed from: a */
    public boolean mo58997a(String str, int i, int i2, int i3) {
        this.f3942k = i2;
        this.f3943l = i3;
        Typeface createFromAsset = Typeface.createFromAsset(this.f3940i, str);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize((float) i);
        paint.setColor(-1);
        paint.setTypeface(createFromAsset);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.f3944m = (float) Math.ceil((double) (Math.abs(fontMetrics.bottom) + Math.abs(fontMetrics.top)));
        this.f3945n = (float) Math.ceil((double) Math.abs(fontMetrics.ascent));
        this.f3946o = (float) Math.ceil((double) Math.abs(fontMetrics.descent));
        char[] cArr = new char[2];
        this.f3951t = 0.0f;
        this.f3950s = 0.0f;
        float[] fArr = new float[2];
        int i4 = 0;
        for (char c = ' '; c <= '~'; c = (char) (c + 1)) {
            cArr[0] = c;
            paint.getTextWidths(cArr, 0, 1, fArr);
            float[] fArr2 = this.f3952u;
            fArr2[i4] = fArr[0];
            if (fArr2[i4] > this.f3950s) {
                this.f3950s = fArr2[i4];
            }
            i4++;
        }
        cArr[0] = ' ';
        paint.getTextWidths(cArr, 0, 1, fArr);
        float[] fArr3 = this.f3952u;
        fArr3[i4] = fArr[0];
        if (fArr3[i4] > this.f3950s) {
            this.f3950s = fArr3[i4];
        }
        this.f3951t = this.f3944m;
        this.f3954w = ((int) this.f3950s) + (this.f3942k * 2);
        this.f3955x = ((int) this.f3951t) + (this.f3943l * 2);
        int i5 = this.f3954w;
        int i6 = this.f3955x;
        if (i5 <= i6) {
            i5 = i6;
        }
        if (i5 < 6 || i5 > 180) {
            return false;
        }
        if (i5 <= 24) {
            this.f3948q = 256;
        } else if (i5 <= 40) {
            this.f3948q = 512;
        } else if (i5 <= 80) {
            this.f3948q = 1024;
        } else {
            this.f3948q = 2048;
        }
        int i7 = this.f3948q;
        Bitmap createBitmap = Bitmap.createBitmap(i7, i7, Bitmap.Config.ALPHA_8);
        Canvas canvas = new Canvas(createBitmap);
        createBitmap.eraseColor(0);
        this.f3957z = this.f3948q / this.f3954w;
        this.f3956y = (int) Math.ceil((double) (96.0f / ((float) this.f3957z)));
        float f = (float) this.f3942k;
        float f2 = (((float) (this.f3955x - 1)) - this.f3946o) - ((float) this.f3943l);
        char c2 = ' ';
        while (c2 <= '~') {
            cArr[0] = c2;
            char c3 = c2;
            Canvas canvas2 = canvas;
            canvas.drawText(cArr, 0, 1, f, f2, paint);
            int i8 = this.f3954w;
            f += (float) i8;
            int i9 = this.f3942k;
            if ((f + ((float) i8)) - ((float) i9) > ((float) this.f3948q)) {
                f2 += (float) this.f3955x;
                f = (float) i9;
            }
            c2 = (char) (c3 + 1);
            canvas = canvas2;
        }
        cArr[0] = ' ';
        canvas.drawText(cArr, 0, 1, f, f2, paint);
        this.f3947p = C4265d.m3743a(createBitmap);
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i10 = 0; i10 < 96; i10++) {
            C4266e[] eVarArr = this.f3953v;
            int i11 = this.f3948q;
            eVarArr[i10] = new C4266e((float) i11, (float) i11, f3, f4, (float) (this.f3954w - 1), (float) (this.f3955x - 1));
            int i12 = this.f3954w;
            f3 += (float) i12;
            if (((float) i12) + f3 > ((float) this.f3948q)) {
                f4 += (float) this.f3955x;
                f3 = 0.0f;
            }
        }
        int i13 = this.f3948q;
        this.f3949r = new C4266e((float) i13, (float) i13, 0.0f, 0.0f, (float) i13, (float) i13);
        return true;
    }

    /* renamed from: a */
    public void mo58996a(float[] fArr) {
        mo58989a(1.0f, 1.0f, 1.0f, 1.0f, fArr);
    }

    /* renamed from: a */
    public void mo58990a(float f, float[] fArr) {
        mo58989a(1.0f, 1.0f, 1.0f, f, fArr);
    }

    /* renamed from: a */
    public void mo58989a(float f, float f2, float f3, float f4, float[] fArr) {
        mo58988a(f, f2, f3, f4);
        this.f3941j.mo59015a(fArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo58988a(float f, float f2, float f3, float f4) {
        GLES20.glUseProgram(this.f3937E.mo58980b());
        GLES20.glUniform4fv(this.f3938F, 1, new float[]{f, f2, f3, f4}, 0);
        GLES20.glEnableVertexAttribArray(this.f3938F);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f3947p);
        GLES20.glUniform1i(this.f3939G, 0);
    }

    /* renamed from: a */
    public void mo58985a() {
        this.f3941j.mo59013a();
        GLES20.glDisableVertexAttribArray(this.f3938F);
    }

    /* renamed from: a */
    public void mo58995a(String str, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = ((float) this.f3955x) * this.f3935B;
        float f8 = ((float) this.f3954w) * this.f3934A;
        int length = str.length();
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.translateM(fArr, 0, f + ((f8 / 2.0f) - (((float) this.f3942k) * this.f3934A)), f2 + ((f7 / 2.0f) - (((float) this.f3943l) * this.f3935B)), f3);
        float[] fArr2 = fArr;
        Matrix.rotateM(fArr2, 0, f6, 0.0f, 0.0f, 1.0f);
        Matrix.rotateM(fArr2, 0, f4, 1.0f, 0.0f, 0.0f);
        Matrix.rotateM(fArr2, 0, f5, 0.0f, 1.0f, 0.0f);
        float f9 = 0.0f;
        for (int i = 0; i < length; i++) {
            int charAt = str.charAt(i) - ' ';
            int i2 = (charAt < 0 || charAt >= 96) ? 95 : charAt;
            float[] fArr3 = fArr;
            this.f3941j.mo59014a(f9, 0.0f, f8, f7, this.f3953v[i2], fArr);
            f9 += (this.f3952u[i2] + this.f3936C) * this.f3934A;
        }
    }

    /* renamed from: a */
    public void mo58994a(String str, float f, float f2, float f3, float f4) {
        mo58995a(str, f, f2, f3, 0.0f, 0.0f, f4);
    }

    /* renamed from: a */
    public void mo58993a(String str, float f, float f2, float f3) {
        mo58994a(str, f, f2, 0.0f, f3);
    }

    /* renamed from: a */
    public void mo58992a(String str, float f, float f2) {
        mo58994a(str, f, f2, 0.0f, 0.0f);
    }

    /* renamed from: b */
    public float mo59002b(String str, float f, float f2, float f3, float f4, float f5, float f6) {
        float a = mo58984a(str);
        mo58995a(str, f - (a / 2.0f), f2 - (mo59009f() / 2.0f), f3, f4, f5, f6);
        return a;
    }

    /* renamed from: b */
    public float mo59001b(String str, float f, float f2, float f3, float f4) {
        return mo59002b(str, f, f2, f3, 0.0f, 0.0f, f4);
    }

    /* renamed from: b */
    public float mo59000b(String str, float f, float f2, float f3) {
        return mo59001b(str, f, f2, 0.0f, f3);
    }

    /* renamed from: b */
    public float mo58999b(String str, float f, float f2) {
        return mo59000b(str, f - (mo58984a(str) / 2.0f), f2 - (mo59009f() / 2.0f), 0.0f);
    }

    /* renamed from: c */
    public float mo59005c(String str, float f, float f2) {
        float a = mo58984a(str);
        mo58992a(str, f - (a / 2.0f), f2);
        return a;
    }

    /* renamed from: d */
    public void mo59007d(String str, float f, float f2) {
        mo58992a(str, f, f2 - (mo59009f() / 2.0f));
    }

    /* renamed from: a */
    public void mo58986a(float f) {
        this.f3935B = f;
        this.f3934A = f;
    }

    /* renamed from: a */
    public void mo58987a(float f, float f2) {
        this.f3934A = f;
        this.f3935B = f2;
    }

    /* renamed from: b */
    public float mo58998b() {
        return this.f3934A;
    }

    /* renamed from: c */
    public float mo59004c() {
        return this.f3935B;
    }

    /* renamed from: b */
    public void mo59003b(float f) {
        this.f3936C = f;
    }

    /* renamed from: d */
    public float mo59006d() {
        return this.f3936C;
    }

    /* renamed from: a */
    public float mo58984a(String str) {
        int length = str.length();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < length; i++) {
            f2 += this.f3952u[str.charAt(i) - ' '] * this.f3934A;
        }
        if (length > 1) {
            f = ((float) (length - 1)) * this.f3936C * this.f3934A;
        }
        return f2 + f;
    }

    /* renamed from: a */
    public float mo58983a(char c) {
        return this.f3952u[c - ' '] * this.f3934A;
    }

    /* renamed from: e */
    public float mo59008e() {
        return this.f3950s * this.f3934A;
    }

    /* renamed from: f */
    public float mo59009f() {
        return this.f3951t * this.f3935B;
    }

    /* renamed from: g */
    public float mo59010g() {
        return this.f3945n * this.f3935B;
    }

    /* renamed from: h */
    public float mo59011h() {
        return this.f3946o * this.f3935B;
    }

    /* renamed from: i */
    public float mo59012i() {
        return this.f3944m * this.f3935B;
    }

    /* renamed from: a */
    public void mo58991a(int i, int i2, float[] fArr) {
        mo58988a(1.0f, 1.0f, 1.0f, 1.0f);
        this.f3941j.mo59015a(fArr);
        float[] fArr2 = new float[16];
        Matrix.setIdentityM(fArr2, 0);
        C4264c cVar = this.f3941j;
        int i3 = this.f3948q;
        cVar.mo59014a((float) (i - (i3 / 2)), (float) (i2 - (i3 / 2)), (float) i3, (float) i3, this.f3949r, fArr2);
        this.f3941j.mo59013a();
    }
}
