package com.medallia.digital.mobilesdk;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.p */
class C3662p extends C3493e4<String> {
    protected C3662p(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m1410o() {
        try {
            PackageManager i = this.f1041g.mo55608i();
            PackageInfo packageInfo = i != null ? i.getPackageInfo(C3595k3.m1060d().mo55513b().getPackageName(), 0) : null;
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException e) {
            C3490e3.m663c(e.getMessage());
        }
        C3490e3.m663c("Context is null");
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1767u;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m1413j() {
        String o = m1410o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > App version : %s", new Object[]{o}));
        return o;
    }
}
