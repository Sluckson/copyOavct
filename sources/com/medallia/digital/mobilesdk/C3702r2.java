package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.AnalyticsBridge;
import com.medallia.digital.mobilesdk.C3461c3;
import com.medallia.digital.mobilesdk.C3706r3;
import com.medallia.digital.mobilesdk.C3717s2;

/* renamed from: com.medallia.digital.mobilesdk.r2 */
class C3702r2 implements C3461c3.C3467f {

    /* renamed from: c */
    private static C3702r2 f1784c;

    /* renamed from: a */
    private final C3732t2 f1785a = new C3732t2();

    /* renamed from: b */
    private long f1786b;

    /* renamed from: com.medallia.digital.mobilesdk.r2$a */
    class C3703a implements C3795y1 {

        /* renamed from: a */
        final /* synthetic */ String f1787a;

        /* renamed from: b */
        final /* synthetic */ MDEngagementType f1788b;

        C3703a(String str, MDEngagementType mDEngagementType) {
            this.f1787a = str;
            this.f1788b = mDEngagementType;
        }

        /* renamed from: a */
        public void mo55373a() {
            C3702r2.this.m1566a(this.f1787a, Reason.formStatusNotAvailable);
        }

        public void onSuccess() {
            if (C3702r2.this.m1568a(this.f1787a)) {
                C3702r2.this.m1572c(this.f1787a, this.f1788b);
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r2$b */
    class C3704b implements C3706r3.C3710d {

        /* renamed from: a */
        final /* synthetic */ String f1790a;

        /* renamed from: b */
        final /* synthetic */ MDEngagementType f1791b;

        C3704b(String str, MDEngagementType mDEngagementType) {
            this.f1790a = str;
            this.f1791b = mDEngagementType;
        }

        /* renamed from: a */
        public void mo55094a() {
            C3702r2.this.m1570b(this.f1790a, this.f1791b);
        }

        /* renamed from: b */
        public void mo55095b() {
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r2$c */
    static /* synthetic */ class C3705c {

        /* renamed from: a */
        static final /* synthetic */ int[] f1793a = new int[MDEngagementType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                com.medallia.digital.mobilesdk.MDEngagementType[] r0 = com.medallia.digital.mobilesdk.MDEngagementType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1793a = r0
                int[] r0 = f1793a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.MDEngagementType r1 = com.medallia.digital.mobilesdk.MDEngagementType.appRating     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1793a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.MDEngagementType r1 = com.medallia.digital.mobilesdk.MDEngagementType.form     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3702r2.C3705c.<clinit>():void");
        }
    }

    private C3702r2() {
        C3461c3.m562g().mo55263a((C3461c3.C3467f) this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1566a(String str, Reason reason) {
        AnalyticsBridge.getInstance().reportInterceptMechanismEvent(this.f1786b, System.currentTimeMillis(), str, reason, AnalyticsBridge.C3414c.failure);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m1568a(String str) {
        Reason reason;
        if (!C3496e5.m699h().mo55356d()) {
            reason = Reason.interceptDisabled;
        } else if (C3461c3.m562g().mo55272d()) {
            reason = Reason.formInBackground;
        } else if (C3461c3.m562g().mo55266a("com.medallia.digital.mobilesdk.MedalliaFullFormActivity") || C3461c3.m562g().mo55266a("com.medallia.digital.mobilesdk.MedalliaModalFormActivity")) {
            reason = Reason.formOpened;
        } else if (!this.f1785a.mo55831d()) {
            return true;
        } else {
            reason = Reason.invitationOpened;
        }
        m1566a(str, reason);
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1570b(String str, MDEngagementType mDEngagementType) {
        if (!C3461c3.m562g().mo55272d() && C3496e5.m699h().mo55354c() && !this.f1785a.mo55831d()) {
            if (MDEngagementType.form.equals(mDEngagementType)) {
                CollectorsInfrastructure.getInstance().invitationDisplayedCollector.mo55525a((Boolean) true);
            } else if (MDEngagementType.appRating.equals(mDEngagementType)) {
                if (!C3802y5.m1954a()) {
                    C3490e3.m665e("Device is offline, App Rating prompt won't be displayed");
                    return;
                }
                CollectorsInfrastructure.getInstance().promptDisplayedCollector.mo55525a(true);
            }
            C3490e3.m661b("Invitation dialog is ready to opened");
            C3490e3.m661b("displayInvitation called");
            this.f1785a.mo55829b(str, mDEngagementType, this.f1786b);
        }
    }

    /* renamed from: c */
    protected static C3702r2 m1571c() {
        if (f1784c == null) {
            f1784c = new C3702r2();
        }
        return f1784c;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1572c(String str, MDEngagementType mDEngagementType) {
        C3433a2 b = C3552h2.m914h().mo55450b(str);
        if (b != null) {
            C3552h2.m914h().mo55451b(b);
            C3817z5.m2029b().mo55989a(b, (C3706r3.C3710d) new C3704b(str, mDEngagementType), C3706r3.C3711e.invitationProducer);
            return;
        }
        C3490e3.m661b("FormId: " + str + " loading failed");
    }

    /* renamed from: d */
    private void m1573d() {
        if (this.f1785a.mo55831d()) {
            C3732t2 t2Var = this.f1785a;
            t2Var.mo55827a(t2Var.mo55830c(), this.f1785a.mo55828b(), this.f1786b);
        }
    }

    /* renamed from: a */
    public void mo55284a() {
        if (this.f1785a.mo55831d()) {
            this.f1785a.mo55825a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55769a(C3717s2.C3720c cVar) {
        this.f1785a.mo55826a(cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55770a(String str, MDEngagementType mDEngagementType) {
        if (mDEngagementType == null) {
            C3490e3.m663c("Can't show invitation because of type is null");
            return;
        }
        this.f1786b = System.currentTimeMillis();
        int i = C3705c.f1793a[mDEngagementType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                C3552h2.m914h().mo55445a(str, (C3795y1) new C3703a(str, mDEngagementType));
            }
        } else if (m1568a(str)) {
            m1570b(str, mDEngagementType);
        }
    }

    /* renamed from: b */
    public void mo55285b() {
        m1573d();
    }
}
