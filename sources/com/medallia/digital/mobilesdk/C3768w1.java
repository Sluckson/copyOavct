package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3792y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.medallia.digital.mobilesdk.w1 */
class C3768w1 {

    /* renamed from: b */
    private static final int f1971b = 90;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Queue<C3731t1> f1972a = new LinkedList();

    /* renamed from: com.medallia.digital.mobilesdk.w1$a */
    class C3769a implements C3660o4<Void> {

        /* renamed from: a */
        final /* synthetic */ C3731t1 f1973a;

        C3769a(C3731t1 t1Var) {
            this.f1973a = t1Var;
        }

        /* renamed from: a */
        private void m1822a(C3731t1 t1Var) {
            C3768w1.this.f1972a.remove(t1Var);
            C3768w1 w1Var = C3768w1.this;
            w1Var.m1819a(w1Var.f1972a.isEmpty() ? null : (C3731t1) C3768w1.this.f1972a.poll());
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3490e3.m663c("Stored feedback failed to submit. Feedback UUID: " + this.f1973a.mo55817b());
            m1822a(this.f1973a);
        }

        /* renamed from: a */
        public void mo55257a(Void voidR) {
            C3490e3.m661b("Stored feedback was submitted successfully. Feedback UUID: " + this.f1973a.mo55817b());
            m1822a(this.f1973a);
        }
    }

    C3768w1() {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1819a(C3731t1 t1Var) {
        if (t1Var != null) {
            C3782x0.m1872d().mo55908a((C3792y) t1Var);
            t1Var.mo55822f();
            C3646n3.m1337m().mo55666a(t1Var, (C3660o4<Void>) new C3769a(t1Var));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55897a() {
        ArrayList<? extends C3792y> c = C3782x0.m1872d().mo55913c(C3792y.C3793a.Feedback, new Object[0]);
        if (c != null && !c.isEmpty()) {
            AnalyticsBridge.getInstance().reportFeedbackRetryMechanismEvent(c.size());
            this.f1972a.addAll(c);
            m1819a(this.f1972a.poll());
            C3782x0.m1872d().mo55907a(C3792y.C3793a.Feedback, Long.valueOf(System.currentTimeMillis() - 7776000000L));
        }
    }
}
