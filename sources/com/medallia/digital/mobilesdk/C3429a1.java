package com.medallia.digital.mobilesdk;

/* renamed from: com.medallia.digital.mobilesdk.a1 */
class C3429a1 {

    /* renamed from: c */
    protected static final int f870c = -1;

    /* renamed from: d */
    private static final long f871d = 5000;

    /* renamed from: e */
    protected static final C3429a1 f872e = new C3431b().mo55180a((Long) 5000L).mo55181a();

    /* renamed from: a */
    final long f873a;

    /* renamed from: b */
    final C3432c f874b;

    /* renamed from: com.medallia.digital.mobilesdk.a1$b */
    protected static class C3431b {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public long f875a = 5000;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public C3432c f876b = C3432c.TOP;

        protected C3431b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C3431b mo55179a(C3432c cVar) {
            this.f876b = cVar;
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C3431b mo55180a(Long l) {
            if (l != null) {
                this.f875a = l.longValue();
            }
            return this;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C3429a1 mo55181a() {
            return new C3429a1(this);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.a1$c */
    enum C3432c {
        TOP,
        BOTTOM;

        static C3432c getPosition(String str) {
            return (str == null || !str.equalsIgnoreCase(BOTTOM.toString())) ? TOP : BOTTOM;
        }
    }

    private C3429a1(C3431b bVar) {
        this.f873a = bVar.f875a;
        this.f874b = bVar.f876b;
    }

    public String toString() {
        return "DefaultBannerConfigurations{durationInMilliseconds=" + this.f873a + '}';
    }
}
