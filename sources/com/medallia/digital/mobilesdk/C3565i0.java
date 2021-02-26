package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3461c3;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.i0 */
class C3565i0 implements C3713r5, C3461c3.C3469h {

    /* renamed from: a */
    private HashMap<C3566a, C3443b0> f1276a = new HashMap<>();

    /* renamed from: com.medallia.digital.mobilesdk.i0$a */
    protected enum C3566a {
        Form,
        Intercept,
        UserJourneyAction,
        Feedback
    }

    C3565i0() {
        this.f1276a.put(C3566a.Form, new C3540g3());
        this.f1276a.put(C3566a.Feedback, new C3520f3());
        this.f1276a.put(C3566a.Intercept, new C3556h3());
        this.f1276a.put(C3566a.UserJourneyAction, new C3570i3());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55476a() {
        C3461c3.m562g().mo55265a((C3461c3.C3469h) this);
        this.f1276a.get(C3566a.Form).mo55229d();
        this.f1276a.get(C3566a.Feedback).mo55229d();
        this.f1276a.get(C3566a.Intercept).mo55229d();
        this.f1276a.get(C3566a.UserJourneyAction).mo55229d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55477a(C3566a aVar, Object obj) {
        this.f1276a.get(aVar).mo55226a(obj);
    }

    public void clearAndDisconnect() {
        this.f1276a.get(C3566a.Form).mo55230e();
        this.f1276a.get(C3566a.Feedback).mo55230e();
        this.f1276a.get(C3566a.Intercept).mo55230e();
        this.f1276a.get(C3566a.UserJourneyAction).mo55230e();
    }

    public void onBackground() {
        clearAndDisconnect();
    }

    public void onForeground() {
        mo55476a();
    }
}
