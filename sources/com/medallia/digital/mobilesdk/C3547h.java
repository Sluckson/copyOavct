package com.medallia.digital.mobilesdk;

/* renamed from: com.medallia.digital.mobilesdk.h */
class C3547h {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C3660o4<C3564i> f1225a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C3660o4<C3564i> f1226b;

    /* renamed from: c */
    private final C3615m3 f1227c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final long f1228d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Boolean f1229e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Boolean f1230f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f1231g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f1232h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f1233i;

    /* renamed from: com.medallia.digital.mobilesdk.h$a */
    class C3548a implements C3660o4<C3564i> {
        C3548a() {
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55257a(C3564i iVar) {
            C3547h.m879c(C3547h.this);
            iVar.mo55472b(C3547h.this.f1231g);
            C3490e3.m665e("Analytics V2 submitted successfully " + C3547h.this.f1231g + "/" + C3646n3.m1337m().mo55673d());
            C3547h.this.f1226b.mo55257a(iVar);
            if (C3547h.this.f1231g < C3547h.this.f1232h && iVar.mo55471b() == C3547h.this.f1233i) {
                C3547h hVar = C3547h.this;
                hVar.m876a(hVar.f1229e, C3547h.this.f1230f, C3547h.this.f1228d, Long.valueOf(iVar.mo55468a()), C3547h.this.f1225a, C3547h.this.f1231g);
            }
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3547h.this.f1226b.mo55256a(j3Var);
        }
    }

    C3547h(C3615m3 m3Var, long j, C3660o4<C3564i> o4Var) {
        this.f1227c = m3Var;
        this.f1226b = o4Var;
        this.f1228d = j;
        m878b();
    }

    C3547h(C3615m3 m3Var, Boolean bool, Boolean bool2, long j, C3660o4<C3564i> o4Var) {
        this.f1227c = m3Var;
        this.f1229e = bool;
        this.f1230f = bool2;
        this.f1226b = o4Var;
        this.f1228d = j;
        m878b();
    }

    C3547h(C3615m3 m3Var, Boolean bool, Boolean bool2, long j, C3660o4<C3564i> o4Var, int i, int i2) {
        this.f1227c = m3Var;
        this.f1229e = bool;
        this.f1230f = bool2;
        this.f1226b = o4Var;
        this.f1228d = j;
        this.f1232h = i;
        this.f1233i = i2;
        m880c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m876a(Boolean bool, Boolean bool2, long j, Long l, C3660o4<C3564i> o4Var, int i) {
        this.f1227c.mo55563a(j, l, bool, bool2, o4Var, i);
    }

    /* renamed from: b */
    private void m878b() {
        this.f1232h = C3646n3.m1337m().mo55674e();
        this.f1233i = C3646n3.m1337m().mo55673d();
        m880c();
    }

    /* renamed from: c */
    static /* synthetic */ int m879c(C3547h hVar) {
        int i = hVar.f1231g;
        hVar.f1231g = i + 1;
        return i;
    }

    /* renamed from: c */
    private void m880c() {
        this.f1225a = new C3548a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55437a() {
        m876a(this.f1229e, this.f1230f, this.f1228d, (Long) null, this.f1225a, this.f1231g);
    }
}
