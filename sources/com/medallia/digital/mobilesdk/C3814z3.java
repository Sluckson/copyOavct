package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.z3 */
class C3814z3 extends C3493e4<String> {

    /* renamed from: k */
    private static final String f2097k = "Android";

    protected C3814z3(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m2005o() {
        return "Android";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1756j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m2008j() {
        String o = m2005o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Os name: %s", new Object[]{o}));
        return o;
    }
}
