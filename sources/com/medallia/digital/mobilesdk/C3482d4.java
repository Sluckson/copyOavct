package com.medallia.digital.mobilesdk;

/* renamed from: com.medallia.digital.mobilesdk.d4 */
class C3482d4 {

    /* renamed from: a */
    private C3483a f1017a;

    /* renamed from: b */
    private long f1018b;

    /* renamed from: com.medallia.digital.mobilesdk.d4$a */
    enum C3483a {
        ONCE,
        FREQUENCY
    }

    C3482d4() {
        this.f1017a = C3483a.ONCE;
    }

    C3482d4(long j) {
        this.f1018b = j;
        this.f1017a = j == 0 ? C3483a.ONCE : C3483a.FREQUENCY;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo55310a() {
        return this.f1018b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55311a(long j) {
        this.f1018b = j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3483a mo55312b() {
        if (this.f1017a == null) {
            this.f1017a = C3483a.ONCE;
        }
        return this.f1017a;
    }
}
