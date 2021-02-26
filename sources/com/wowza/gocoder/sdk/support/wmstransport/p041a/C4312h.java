package com.wowza.gocoder.sdk.support.wmstransport.p041a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wowza.gocoder.sdk.support.wmstransport.a.h */
/* compiled from: GoCoderSDK */
public class C4312h {

    /* renamed from: a */
    protected List<C4310f> f4438a = new ArrayList();

    /* renamed from: b */
    protected int f4439b = 0;

    /* renamed from: c */
    protected long f4440c = 0;

    /* renamed from: d */
    protected long f4441d = 0;

    /* renamed from: a */
    public void mo59276a(C4312h hVar) {
        synchronized (this.f4438a) {
            this.f4438a.addAll(hVar.f4438a);
            this.f4439b += hVar.mo59278b();
        }
    }

    /* renamed from: a */
    public void mo59275a(C4310f fVar) {
        synchronized (this.f4438a) {
            this.f4438a.add(fVar);
            this.f4439b += fVar.mo59269c();
        }
    }

    /* renamed from: a */
    public void mo59273a(int i, C4310f fVar) {
        synchronized (this.f4438a) {
            this.f4438a.add(i, fVar);
            this.f4439b += fVar.mo59269c();
        }
    }

    /* renamed from: a */
    public C4310f mo59271a(int i) {
        C4310f fVar;
        synchronized (this.f4438a) {
            if (i < this.f4438a.size()) {
                fVar = this.f4438a.get(i);
                this.f4439b -= fVar.mo59269c();
            } else {
                fVar = null;
            }
        }
        return fVar;
    }

    /* renamed from: a */
    public void mo59272a() {
        synchronized (this.f4438a) {
            this.f4438a.clear();
            this.f4439b = 0;
        }
    }

    /* renamed from: b */
    public int mo59278b() {
        int i;
        synchronized (this.f4438a) {
            i = this.f4439b;
        }
        return i;
    }

    /* renamed from: c */
    public List<C4310f> mo59280c() {
        return this.f4438a;
    }

    /* renamed from: d */
    public List<C4310f> mo59281d() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f4438a) {
            arrayList.addAll(this.f4438a);
        }
        return arrayList;
    }

    /* renamed from: e */
    public long mo59282e() {
        return this.f4440c;
    }

    /* renamed from: a */
    public void mo59274a(long j) {
        this.f4440c = j;
    }

    /* renamed from: f */
    public long mo59283f() {
        return this.f4441d;
    }

    /* renamed from: b */
    public void mo59279b(long j) {
        this.f4441d = j;
    }

    /* renamed from: g */
    public byte[] mo59284g() {
        return mo59277a(false);
    }

    /* renamed from: a */
    public byte[] mo59277a(boolean z) {
        int size = this.f4438a.size();
        int i = 0;
        if (this.f4439b <= 0 || size <= 0) {
            return new byte[0];
        }
        if (!z && size == 1) {
            C4310f fVar = this.f4438a.get(0);
            if (fVar.mo59267b() == 0 && fVar.mo59266a().length == fVar.mo59269c()) {
                return fVar.mo59266a();
            }
        }
        byte[] bArr = new byte[this.f4439b];
        for (C4310f next : this.f4438a) {
            System.arraycopy(next.mo59266a(), next.mo59267b(), bArr, i, next.mo59269c());
            i += next.mo59269c();
        }
        return bArr;
    }
}
