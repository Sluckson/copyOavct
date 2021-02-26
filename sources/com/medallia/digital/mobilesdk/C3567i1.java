package com.medallia.digital.mobilesdk;

import android.app.ActivityManager;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.i1 */
class C3567i1 extends C3493e4<Long> {

    /* renamed from: k */
    private static final int f1282k = 100;

    protected C3567i1(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private long m967o() {
        ActivityManager.MemoryInfo h = this.f1041g.mo55607h();
        if (h != null) {
            long j = h.totalMem;
            long j2 = j - h.availMem;
            if (j2 == 0) {
                return 0;
            }
            return (long) ((((double) j2) / ((double) j)) * 100.0d);
        }
        C3490e3.m663c("MemoryInfo is null");
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1752f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Long m970j() {
        long o = m967o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Used memory: %d%%", new Object[]{Long.valueOf(o)}));
        return Long.valueOf(o);
    }
}
