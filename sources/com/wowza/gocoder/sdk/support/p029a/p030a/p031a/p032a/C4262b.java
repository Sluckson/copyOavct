package com.wowza.gocoder.sdk.support.p029a.p030a.p031a.p032a;

import android.opengl.GLES20;
import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.C4260a;
import com.wowza.gocoder.sdk.support.p029a.p030a.p031a.C4268g;

/* renamed from: com.wowza.gocoder.sdk.support.a.a.a.a.b */
/* compiled from: GoCoderSDK */
public abstract class C4262b {

    /* renamed from: a */
    private int f3921a;

    /* renamed from: b */
    private int f3922b;

    /* renamed from: c */
    private int f3923c;

    /* renamed from: d */
    private boolean f3924d = false;

    /* renamed from: a */
    public void mo58978a() {
        mo58979a((String) null, (String) null, (C4260a[]) null);
    }

    /* renamed from: a */
    public void mo58979a(String str, String str2, C4260a[] aVarArr) {
        this.f3922b = C4268g.m3747a(35633, str);
        this.f3923c = C4268g.m3747a(35632, str2);
        this.f3921a = C4268g.m3746a(this.f3922b, this.f3923c, aVarArr);
        this.f3924d = true;
    }

    /* renamed from: b */
    public int mo58980b() {
        return this.f3921a;
    }

    /* renamed from: c */
    public void mo58981c() {
        GLES20.glDeleteShader(this.f3922b);
        GLES20.glDeleteShader(this.f3923c);
        GLES20.glDeleteProgram(this.f3921a);
        this.f3924d = false;
    }

    /* renamed from: d */
    public boolean mo58982d() {
        return this.f3924d;
    }
}
