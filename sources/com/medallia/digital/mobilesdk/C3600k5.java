package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3461c3;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.k5 */
class C3600k5 extends C3603l1<Long> implements C3461c3.C3469h, C3461c3.C3468g {

    /* renamed from: g */
    private Long f1399g = Long.valueOf(System.currentTimeMillis());

    protected C3600k5(C3612m0 m0Var) {
        super(m0Var);
    }

    /* renamed from: p */
    private Long m1082p() {
        if (this.f1399g != null) {
            return Long.valueOf(System.currentTimeMillis() - this.f1399g.longValue());
        }
        return null;
    }

    /* renamed from: a */
    public void mo55286a(long j) {
        this.f1399g = Long.valueOf(this.f1399g.longValue() + j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1737M;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Long m1086f() {
        Long p = m1082p();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Time in foreground: %d", new Object[]{p}));
        return p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public Long m1088j() {
        return m1086f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        try {
            C3461c3.m562g().mo55264a((C3461c3.C3468g) this);
            C3461c3.m562g().mo55265a((C3461c3.C3469h) this);
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
            C3461c3.m562g().mo55270b((C3461c3.C3469h) this);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public C3803z mo55521n() {
        return new C3803z(m1086f().toString(), GroupType.collector, mo55527d(), mo55529g(), mo55528e());
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo55522o() {
        this.f1399g = Long.valueOf(System.currentTimeMillis());
    }

    public void onBackground() {
        mo55525a(m1086f());
    }

    public void onForeground() {
    }
}
