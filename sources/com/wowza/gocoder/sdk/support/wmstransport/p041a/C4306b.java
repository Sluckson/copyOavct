package com.wowza.gocoder.sdk.support.wmstransport.p041a;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.a.b */
/* compiled from: GoCoderSDK */
public class C4306b implements C4309e {

    /* renamed from: a */
    private byte[] f4410a = null;

    /* renamed from: b */
    private int f4411b = 0;

    /* renamed from: c */
    private int f4412c = 0;

    /* renamed from: d */
    private int f4413d = -1;

    /* renamed from: e */
    private int f4414e = 8;

    /* renamed from: f */
    private int f4415f = 0;

    public C4306b(byte[] bArr) {
        this.f4410a = bArr;
        this.f4411b = this.f4410a.length;
    }

    public C4306b(byte[] bArr, int i) {
        this.f4410a = bArr;
        this.f4411b = i;
    }

    public C4306b(byte[] bArr, int i, int i2) {
        this.f4410a = bArr;
        this.f4411b = i2 + i;
        this.f4413d = i - 1;
    }

    /* renamed from: a */
    public int mo59252a() {
        int i = this.f4413d;
        if (i == -1) {
            return this.f4411b * 8;
        }
        return (8 - this.f4414e) + (((this.f4411b - i) - 1) * 8);
    }

    /* renamed from: b */
    public int mo59254b() {
        return this.f4415f;
    }

    /* renamed from: c */
    public int mo59256c() {
        int i = 0;
        if (this.f4414e >= 8) {
            this.f4413d++;
            this.f4412c = this.f4410a[this.f4413d];
            this.f4414e = 0;
        }
        if ((this.f4412c & 128) == 128) {
            i = 1;
        }
        this.f4415f++;
        this.f4414e++;
        this.f4412c <<= 1;
        return i;
    }

    /* renamed from: d */
    public void mo59259d() {
        mo59256c();
    }

    /* renamed from: a */
    public void mo59253a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            mo59256c();
        }
    }

    /* renamed from: b */
    public int mo59255b(int i) {
        int i2 = this.f4413d;
        int i3 = this.f4412c;
        int i4 = this.f4414e;
        int i5 = this.f4415f;
        int i6 = 0;
        for (int i7 = 0; i7 < i; i7++) {
            i6 = (i6 << 1) + mo59256c();
        }
        this.f4413d = i2;
        this.f4412c = i3;
        this.f4414e = i4;
        this.f4415f = i5;
        return i6;
    }

    /* renamed from: c */
    public int mo59257c(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 << 1) + mo59256c();
        }
        return i2;
    }

    /* renamed from: d */
    public long mo59258d(int i) {
        int i2 = this.f4413d;
        int i3 = this.f4412c;
        int i4 = this.f4414e;
        int i5 = this.f4415f;
        long j = 0;
        for (int i6 = 0; i6 < i; i6++) {
            j = (j << 1) + ((long) mo59256c());
        }
        this.f4413d = i2;
        this.f4412c = i3;
        this.f4414e = i4;
        this.f4415f = i5;
        return j;
    }

    /* renamed from: e */
    public long mo59261e(int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 1) + ((long) mo59256c());
        }
        return j;
    }

    /* renamed from: f */
    public int mo59263f(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 << 1) + mo59256c();
            if (i3 == 0 && i2 == 1) {
                i2 = -1;
            }
        }
        return i2;
    }

    /* renamed from: e */
    public int mo59260e() {
        int f = mo59262f();
        return (f & 1) == 1 ? (f + 1) / 2 : -(f / 2);
    }

    /* renamed from: f */
    public int mo59262f() {
        int i = 0;
        while (mo59256c() == 0 && i < 32) {
            i++;
        }
        return ((1 << i) - 1) + mo59257c(i);
    }
}
