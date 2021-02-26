package com.medallia.digital.mobilesdk;

import android.os.Build;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.a4 */
class C3437a4 extends C3493e4<String> {
    protected C3437a4(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m462o() {
        return Build.VERSION.RELEASE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1757k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m465j() {
        String o = m462o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Os version : %s", new Object[]{o}));
        return o;
    }
}
