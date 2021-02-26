package com.medallia.digital.mobilesdk;

import android.content.pm.ApplicationInfo;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.k */
class C3591k extends C3493e4<String> {
    protected C3591k(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m1045o() {
        ApplicationInfo a = this.f1041g.mo55600a();
        if (a != null) {
            return a.packageName;
        }
        C3490e3.m663c("ApplicationInfo is null");
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1766t;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m1048j() {
        String o = m1045o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > App id : %s", new Object[]{o}));
        return o;
    }
}
