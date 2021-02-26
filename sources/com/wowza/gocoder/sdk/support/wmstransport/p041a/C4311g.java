package com.wowza.gocoder.sdk.support.wmstransport.p041a;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.a.g */
/* compiled from: GoCoderSDK */
public class C4311g implements C4310f {

    /* renamed from: a */
    protected byte[] f4435a = null;

    /* renamed from: b */
    protected int f4436b = 0;

    /* renamed from: c */
    protected int f4437c = 0;

    public C4311g(byte[] bArr, int i, int i2) {
        this.f4435a = bArr;
        this.f4436b = i;
        this.f4437c = i2;
    }

    public C4311g(byte[] bArr) {
        this.f4435a = bArr;
        this.f4436b = 0;
        this.f4437c = bArr.length;
    }

    public C4311g() {
    }

    /* renamed from: d */
    public int mo59270d() {
        return this.f4437c;
    }

    /* renamed from: a */
    public byte[] mo59266a() {
        return this.f4435a;
    }

    /* renamed from: a */
    public void mo59265a(byte[] bArr) {
        this.f4435a = bArr;
    }

    /* renamed from: b */
    public int mo59267b() {
        return this.f4436b;
    }

    /* renamed from: a */
    public void mo59264a(int i) {
        this.f4436b = i;
    }

    /* renamed from: c */
    public int mo59269c() {
        return this.f4437c;
    }

    /* renamed from: b */
    public void mo59268b(int i) {
        this.f4437c = i;
    }
}
