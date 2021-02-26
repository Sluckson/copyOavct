package com.medallia.digital.mobilesdk;

import android.os.Build;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.j1 */
class C3583j1 extends C3493e4<String> {
    protected C3583j1(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m1017o() {
        return Build.MANUFACTURER;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1753g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m1020j() {
        String o = m1017o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Device vendor : %s", new Object[]{o}));
        return o;
    }
}
