package com.medallia.digital.mobilesdk;

import android.telephony.TelephonyManager;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.t3 */
class C3742t3 extends C3493e4<String> {

    /* renamed from: k */
    private static final String f1910k = "UNKNOWN";

    protected C3742t3(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m1698o() {
        TelephonyManager k = this.f1041g.mo55610k();
        if (k != null) {
            return k.getSimOperatorName() == null ? f1910k : k.getSimOperatorName();
        }
        C3490e3.m663c("TelephonyManager memory is not available");
        return f1910k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1759m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m1701j() {
        String o = m1698o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Network carrier : %s", new Object[]{o}));
        return o;
    }
}
