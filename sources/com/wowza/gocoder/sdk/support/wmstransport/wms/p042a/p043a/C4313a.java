package com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p043a;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.wms.a.a.a */
/* compiled from: GoCoderSDK */
public class C4313a {

    /* renamed from: a */
    private int f4442a = 0;

    /* renamed from: b */
    private int f4443b = 0;

    /* renamed from: c */
    private int f4444c = 0;

    /* renamed from: d */
    private int f4445d = 0;

    /* renamed from: e */
    private int f4446e = 0;

    /* renamed from: f */
    private int f4447f = 0;

    /* renamed from: g */
    private int f4448g = 2;

    /* renamed from: h */
    private boolean f4449h = true;

    /* renamed from: a */
    public int mo59285a() {
        return this.f4443b;
    }

    /* renamed from: a */
    public void mo59286a(int i) {
        this.f4443b = i;
    }

    /* renamed from: b */
    public int mo59289b() {
        return this.f4444c;
    }

    /* renamed from: b */
    public void mo59290b(int i) {
        this.f4444c = i;
    }

    /* renamed from: c */
    public int mo59291c() {
        return this.f4446e;
    }

    /* renamed from: c */
    public void mo59292c(int i) {
        this.f4446e = i;
    }

    /* renamed from: d */
    public int mo59293d() {
        return this.f4447f;
    }

    /* renamed from: d */
    public void mo59294d(int i) {
        this.f4447f = i;
    }

    /* renamed from: e */
    public int mo59295e() {
        return (this.f4447f + 1) * 1024;
    }

    /* renamed from: f */
    public int mo59297f() {
        return this.f4442a;
    }

    /* renamed from: e */
    public void mo59296e(int i) {
        this.f4442a = i;
    }

    /* renamed from: g */
    public int mo59299g() {
        return this.f4445d;
    }

    /* renamed from: f */
    public void mo59298f(int i) {
        this.f4445d = i;
    }

    /* renamed from: h */
    public boolean mo59301h() {
        return this.f4449h;
    }

    /* renamed from: a */
    public void mo59287a(boolean z) {
        this.f4449h = z;
    }

    /* renamed from: i */
    public int mo59302i() {
        return this.f4448g;
    }

    /* renamed from: g */
    public void mo59300g(int i) {
        this.f4448g = i;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("{AACFrame: codec:AAC, channels:");
        sb.append(this.f4446e);
        sb.append(", frequency:");
        sb.append(this.f4443b);
        sb.append(", samplesPerFrame:");
        sb.append(mo59295e());
        sb.append(", objectType:");
        sb.append(C4314b.m4372c(this.f4448g));
        if (this.f4444c > 0) {
            str = ", size:" + this.f4444c;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public boolean mo59288a(C4313a aVar) {
        return this.f4442a == aVar.f4442a && this.f4443b == aVar.f4443b && this.f4444c == aVar.f4444c && this.f4445d == aVar.f4445d && this.f4446e == aVar.f4446e && this.f4447f == aVar.f4447f && this.f4448g == aVar.f4448g && this.f4449h == aVar.f4449h;
    }
}
