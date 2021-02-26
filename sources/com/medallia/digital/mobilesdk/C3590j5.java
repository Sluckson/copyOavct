package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3461c3;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.j5 */
class C3590j5 extends C3603l1<Long> implements C3461c3.C3468g {
    protected C3590j5(C3612m0 m0Var) {
        super(m0Var);
    }

    /* renamed from: a */
    public void mo55286a(long j) {
        mo55525a(Long.valueOf(j));
        C3490e3.m661b(String.format(Locale.US, "Collectors > Time in background was: %d", new Object[]{Long.valueOf(j)}));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1736L;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Long m1039f() {
        if (super.mo55504f() == null) {
            return 0L;
        }
        return (Long) super.mo55504f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Long m1041j() {
        return m1039f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        try {
            C3461c3.m562g().mo55264a((C3461c3.C3468g) this);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3461c3.m562g().mo55269b((C3461c3.C3468g) this);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo55505n() {
        mo55525a(0L);
    }
}
