package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.u4 */
class C3753u4 extends C3493e4<String> {
    protected C3753u4(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m1737o() {
        return BuildConfig.VERSION_NAME;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1768v;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m1740j() {
        String o = m1737o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > SDK version : %s", new Object[]{o}));
        return o;
    }
}
