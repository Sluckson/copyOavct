package com.medallia.digital.mobilesdk;

import android.app.ActivityManager;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.c1 */
class C3456c1 extends C3493e4<String> {
    protected C3456c1(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private double m528o() {
        ActivityManager.MemoryInfo h = this.f1041g.mo55607h();
        if (h != null) {
            long j = h.availMem;
            return j == 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : (double) j;
        }
        C3490e3.m663c("MemoryInfo is null");
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1748b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m531j() {
        String b = C3488e1.m655b(m528o());
        C3490e3.m661b(String.format(Locale.US, "Collectors > Device free memory: %s", new Object[]{b}));
        return b;
    }
}
