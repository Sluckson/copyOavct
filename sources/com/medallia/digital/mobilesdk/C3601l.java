package com.medallia.digital.mobilesdk;

import android.content.pm.ApplicationInfo;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.l */
class C3601l extends C3493e4<String> {
    protected C3601l(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m1093o() {
        ApplicationInfo a = this.f1041g.mo55600a();
        if (a != null) {
            int i = a.labelRes;
            if (i != 0) {
                return C3595k3.m1060d().mo55513b().getString(i);
            }
            if (a.nonLocalizedLabel != null) {
                return a.nonLocalizedLabel.toString();
            }
            return null;
        }
        C3490e3.m663c("Context is null");
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1765s;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m1096j() {
        String o = m1093o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > App name : %s", new Object[]{o}));
        return o;
    }
}
