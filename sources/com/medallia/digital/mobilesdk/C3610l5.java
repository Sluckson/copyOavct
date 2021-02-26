package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.l5 */
class C3610l5 extends C3493e4<String> {
    protected C3610l5(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m1131o() {
        try {
            return this.f1041g.mo55601b().getTimeZone().getDisplayName(false, 0);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1761o;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m1134j() {
        String o = m1131o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Timezone : %s", new Object[]{o}));
        return o;
    }
}
