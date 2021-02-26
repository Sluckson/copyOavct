package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.z2 */
class C3813z2 extends C3493e4<String> {
    protected C3813z2(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m2001o() {
        C3643n0 n0Var = this.f1041g;
        if (n0Var != null) {
            return n0Var.mo55606g().toString();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1760n;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m2004j() {
        String o = m2001o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Language : %s", new Object[]{o}));
        return o;
    }
}
