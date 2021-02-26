package com.medallia.digital.mobilesdk;

import android.os.Handler;
import android.os.Looper;
import com.medallia.digital.mobilesdk.C3482d4;

/* renamed from: com.medallia.digital.mobilesdk.e4 */
abstract class C3493e4<T> extends C3602l0<T> {

    /* renamed from: f */
    private long f1040f;

    /* renamed from: g */
    protected C3643n0 f1041g;

    /* renamed from: h */
    private C3482d4 f1042h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Handler f1043i = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Runnable f1044j = new C3494a();

    /* renamed from: com.medallia.digital.mobilesdk.e4$a */
    class C3494a extends C3666p3 {

        /* renamed from: com.medallia.digital.mobilesdk.e4$a$a */
        class C3495a extends C3666p3 {
            C3495a() {
            }

            /* renamed from: a */
            public void mo55177a() {
                C3493e4 e4Var = C3493e4.this;
                e4Var.mo55525a(e4Var.mo55208j());
                C3493e4.this.f1043i.postDelayed(C3493e4.this.f1044j, C3493e4.this.mo55339k().mo55310a());
            }
        }

        C3494a() {
        }

        /* renamed from: a */
        public void mo55177a() {
            C3561h5.m954c().mo55465a().execute(new C3495a());
        }
    }

    protected C3493e4(C3482d4 d4Var, C3612m0 m0Var) {
        super(m0Var);
        this.f1042h = d4Var == null ? new C3482d4() : d4Var;
        this.f1041g = new C3643n0();
    }

    /* renamed from: o */
    private boolean m672o() {
        return System.currentTimeMillis() - this.f1040f >= this.f1042h.mo55310a();
    }

    /* renamed from: p */
    private void m673p() {
        if (mo55339k().mo55312b() == C3482d4.C3483a.ONCE) {
            mo55525a(mo55208j());
        } else {
            mo55341m();
        }
    }

    /* renamed from: q */
    private void m674q() {
        this.f1043i.removeCallbacks(this.f1044j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55336a(C3482d4 d4Var) {
        this.f1042h = d4Var;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55337a(C3643n0 n0Var) {
        this.f1041g = n0Var;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55338a(boolean z) {
        super.mo55338a(z);
        if (z) {
            m673p();
        } else {
            m674q();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public T mo55208j() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public C3482d4 mo55339k() {
        return this.f1042h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55340l() {
        if (mo55530h()) {
            mo55525a(mo55208j());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55341m() {
        if (mo55530h() && this.f1042h.mo55312b() == C3482d4.C3483a.FREQUENCY) {
            m674q();
            if (m672o()) {
                this.f1043i.post(this.f1044j);
            } else {
                this.f1043i.postDelayed(this.f1044j, this.f1042h.mo55310a());
            }
            this.f1040f = System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo55342n() {
        m674q();
    }
}
