package com.medallia.digital.mobilesdk;

import androidx.annotation.NonNull;

/* renamed from: com.medallia.digital.mobilesdk.j4 */
class C3588j4 {

    /* renamed from: a */
    private int f1365a;

    /* renamed from: b */
    private C3589a f1366b;

    /* renamed from: com.medallia.digital.mobilesdk.j4$a */
    enum C3589a {
        NO_CONNECTION,
        TIMEOUT,
        OTHER;

        /* renamed from: a */
        public static C3589a m1035a(int i) {
            return (i == 408 || i == 504 || i == -46) ? TIMEOUT : i == -45 ? NO_CONNECTION : OTHER;
        }
    }

    protected C3588j4(int i) {
        this.f1365a = i;
        this.f1366b = C3589a.m1035a(i);
    }

    /* access modifiers changed from: protected */
    @NonNull
    /* renamed from: a */
    public C3589a mo55502a() {
        return this.f1366b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public int mo55503b() {
        return this.f1365a;
    }
}
