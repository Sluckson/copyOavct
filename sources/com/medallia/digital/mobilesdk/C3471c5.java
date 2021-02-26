package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.medallia.digital.mobilesdk.AnalyticsBridge;
import com.medallia.digital.mobilesdk.C3586j3;
import com.medallia.digital.mobilesdk.C3588j4;
import com.medallia.digital.mobilesdk.C3646n3;
import com.medallia.digital.mobilesdk.C3667p4;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.c5 */
class C3471c5 extends C3581j0<Void> {
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C3731t1 f972g;

    /* renamed from: com.medallia.digital.mobilesdk.c5$a */
    class C3472a implements C3667p4.C3668a {

        /* renamed from: a */
        final /* synthetic */ boolean f973a;

        C3472a(boolean z) {
            this.f973a = z;
        }

        /* renamed from: a */
        public void mo55240a() {
        }

        /* renamed from: a */
        public void mo55241a(C3588j4 j4Var) {
            C3471c5 c5Var = C3471c5.this;
            c5Var.m593a(c5Var.f972g, this.f973a);
            C3471c5.this.mo55496b(j4Var);
        }

        /* renamed from: a */
        public void mo55242a(C3609l4 l4Var) {
            C3490e3.m665e("Submit Feedback - success " + l4Var.mo55546b());
            C3471c5.this.mo55290e();
            AnalyticsBridge.getInstance().reportSubmitFeedbackEvent(C3471c5.this.f972g, System.currentTimeMillis(), AnalyticsBridge.C3414c.f832a);
            C3660o4<T> o4Var = C3471c5.this.f1316d;
            if (o4Var != null) {
                o4Var.mo55257a(null);
            }
        }
    }

    C3471c5(C3667p4 p4Var, C3592k0 k0Var, C3731t1 t1Var, @Nullable C3660o4<Void> o4Var) {
        super(p4Var, k0Var, o4Var);
        this.f972g = t1Var;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m593a(C3731t1 t1Var, boolean z) {
        AnalyticsBridge analyticsBridge;
        AnalyticsBridge.C3414c cVar;
        if (z) {
            analyticsBridge = AnalyticsBridge.getInstance();
            cVar = AnalyticsBridge.C3414c.pending;
        } else {
            analyticsBridge = AnalyticsBridge.getInstance();
            cVar = AnalyticsBridge.C3414c.failure;
        }
        analyticsBridge.reportSubmitFeedbackEvent(t1Var, 0, cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3586j3 mo55237a(C3588j4 j4Var) {
        C3593k1 k1Var = C3588j4.C3589a.NO_CONNECTION.equals(j4Var.mo55502a()) ? new C3593k1(C3586j3.C3587a.AUTH_NETWORK_ERROR) : C3588j4.C3589a.TIMEOUT.equals(j4Var.mo55502a()) ? new C3593k1(C3586j3.C3587a.FEEDBACK_TIMEOUT) : new C3593k1(C3586j3.C3587a.SUBMIT_FEEDBACK_ERROR);
        C3490e3.m663c(k1Var.getMessage());
        return k1Var;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55238b() {
        JSONObject jSONObject;
        C3586j3 d = mo55239d();
        if (d != null) {
            C3660o4<T> o4Var = this.f1316d;
            if (o4Var != null) {
                o4Var.mo55256a(d);
                return;
            }
            return;
        }
        boolean f = mo55291f();
        try {
            jSONObject = new JSONObject(this.f972g.mo55815a());
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
            jSONObject = null;
        }
        this.f1313a.mo55701b(this.f1314b.mo55510e(), (HashMap<String, String>) null, mo55493a(C3646n3.C3648b.ACCESS_TOKEN), jSONObject, new C3472a(f));
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C3586j3 mo55239d() {
        if (C3604l2.m1115c().mo55534a() == null) {
            C3490e3.m663c(C3586j3.C3587a.ACCESS_TOKEN_EMPTY.toString());
            return new C3593k1(C3586j3.C3587a.ACCESS_TOKEN_EMPTY);
        } else if (TextUtils.isEmpty(this.f1314b.mo55510e())) {
            C3490e3.m663c(C3586j3.C3587a.SUBMIT_FEEDBACK_EMPTY_ENDPOINT.toString());
            return new C3593k1(C3586j3.C3587a.SUBMIT_FEEDBACK_EMPTY_ENDPOINT);
        } else {
            C3731t1 t1Var = this.f972g;
            if (t1Var != null && !TextUtils.isEmpty(t1Var.mo55815a())) {
                return null;
            }
            C3490e3.m663c(C3586j3.C3587a.EMPTY_FEEDBACK.toString());
            return new C3593k1(C3586j3.C3587a.EMPTY_FEEDBACK);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo55290e() {
        if (this.f972g != null) {
            C3782x0.m1872d().mo55908a((C3792y) this.f972g);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo55291f() {
        if (this.f972g == null) {
            return false;
        }
        return C3782x0.m1872d().mo55915c((C3792y) this.f972g);
    }
}
