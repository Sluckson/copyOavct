package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.medallia.digital.mobilesdk.C3586j3;
import com.medallia.digital.mobilesdk.C3588j4;
import com.medallia.digital.mobilesdk.C3646n3;
import com.medallia.digital.mobilesdk.C3667p4;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.b5 */
class C3451b5 extends C3581j0<Void> {

    /* renamed from: i */
    private static final int f933i = 1024;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final boolean f934g;

    /* renamed from: h */
    private JSONObject f935h;

    /* renamed from: com.medallia.digital.mobilesdk.b5$a */
    class C3452a implements C3667p4.C3668a {
        C3452a() {
        }

        /* renamed from: a */
        public void mo55240a() {
            C3660o4<T> o4Var = C3451b5.this.f1316d;
            if (o4Var != null) {
                o4Var.mo55254a();
            }
        }

        /* renamed from: a */
        public void mo55241a(C3588j4 j4Var) {
            C3451b5.this.mo55496b(j4Var);
        }

        /* renamed from: a */
        public void mo55242a(C3609l4 l4Var) {
            C3490e3.m665e(C3451b5.this.f934g ? "Analytics V2 was submitted successfully" : "Analytics was submitted successfully");
            C3660o4<T> o4Var = C3451b5.this.f1316d;
            if (o4Var != null) {
                o4Var.mo55257a(null);
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.b5$b */
    class C3453b implements C3667p4.C3668a {
        C3453b() {
        }

        /* renamed from: a */
        public void mo55240a() {
            C3660o4<T> o4Var = C3451b5.this.f1316d;
            if (o4Var != null) {
                o4Var.mo55254a();
            }
        }

        /* renamed from: a */
        public void mo55241a(C3588j4 j4Var) {
            C3451b5.this.mo55496b(j4Var);
        }

        /* renamed from: a */
        public void mo55242a(C3609l4 l4Var) {
            C3490e3.m665e(C3451b5.this.f934g ? "Analytics V2 was submitted successfully" : "Analytics was submitted successfully");
            C3660o4<T> o4Var = C3451b5.this.f1316d;
            if (o4Var != null) {
                o4Var.mo55257a(null);
            }
        }
    }

    C3451b5(C3667p4 p4Var, C3592k0 k0Var, JSONObject jSONObject, @Nullable C3660o4<Void> o4Var) {
        super(p4Var, k0Var, o4Var);
        this.f935h = jSONObject;
        this.f934g = false;
    }

    C3451b5(C3667p4 p4Var, C3592k0 k0Var, JSONObject jSONObject, @Nullable C3660o4<Void> o4Var, boolean z) {
        super(p4Var, k0Var, o4Var);
        this.f935h = jSONObject;
        this.f934g = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3586j3 mo55237a(C3588j4 j4Var) {
        C3593k1 k1Var = C3588j4.C3589a.NO_CONNECTION.equals(j4Var.mo55502a()) ? new C3593k1(C3586j3.C3587a.AUTH_NETWORK_ERROR) : C3588j4.C3589a.TIMEOUT.equals(j4Var.mo55502a()) ? new C3593k1(C3586j3.C3587a.SUBMIT_ANALYTICS_ERROR) : new C3593k1(C3586j3.C3587a.SUBMIT_ANALYTICS_ERROR);
        C3490e3.m663c(k1Var.getMessage());
        return k1Var;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55238b() {
        C3490e3.m661b(this.f934g ? "Submit Analytics V2 started" : "Submit Analytics started");
        C3586j3 d = mo55239d();
        if (d != null) {
            C3660o4<T> o4Var = this.f1316d;
            if (o4Var != null) {
                o4Var.mo55256a(d);
            }
        } else if (this.f1314b.mo55509d() != null) {
            this.f1313a.mo55696a(this.f1314b.mo55509d(), this.f1314b.mo55510e(), (HashMap<String, String>) null, this.f1314b.mo55507b(), this.f935h, new C3452a());
        } else {
            this.f1313a.mo55701b(this.f1314b.mo55510e(), (HashMap<String, String>) null, mo55493a(C3646n3.C3648b.ACCESS_TOKEN), this.f935h, new C3453b());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C3586j3 mo55239d() {
        if (C3604l2.m1115c().mo55534a() == null) {
            C3490e3.m663c(C3586j3.C3587a.ACCESS_TOKEN_EMPTY.toString());
            return new C3593k1(C3586j3.C3587a.ACCESS_TOKEN_EMPTY);
        } else if (!TextUtils.isEmpty(this.f1314b.mo55510e())) {
            return null;
        } else {
            C3586j3.C3587a aVar = C3586j3.C3587a.SUBMIT_ANALYTICS_EMPTY_ENDPOINT;
            C3490e3.m663c(aVar.toString());
            return new C3586j3(aVar);
        }
    }
}
