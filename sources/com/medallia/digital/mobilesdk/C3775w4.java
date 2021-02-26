package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Random;

/* renamed from: com.medallia.digital.mobilesdk.w4 */
class C3775w4 extends C3493e4<Integer> {

    /* renamed from: k */
    private static final int f1992k = 100;

    protected C3775w4(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private int m1842o() {
        return new Random().nextInt(100);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1769w;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Integer m1845j() {
        return Integer.valueOf(m1842o());
    }
}
