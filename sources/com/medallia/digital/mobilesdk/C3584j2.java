package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.medallia.digital.mobilesdk.C3586j3;
import com.medallia.digital.mobilesdk.C3588j4;
import com.medallia.digital.mobilesdk.C3646n3;
import com.medallia.digital.mobilesdk.C3667p4;
import java.io.File;

/* renamed from: com.medallia.digital.mobilesdk.j2 */
class C3584j2 extends C3581j0<File> {

    /* renamed from: g */
    private boolean f1320g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f1321h;

    /* renamed from: com.medallia.digital.mobilesdk.j2$a */
    class C3585a implements C3667p4.C3668a {
        C3585a() {
        }

        /* renamed from: a */
        public void mo55240a() {
            C3660o4<T> o4Var = C3584j2.this.f1316d;
            if (o4Var != null) {
                o4Var.mo55254a();
            }
        }

        /* renamed from: a */
        public void mo55241a(C3588j4 j4Var) {
            C3584j2.this.mo55496b(j4Var);
        }

        /* renamed from: a */
        public void mo55242a(C3609l4 l4Var) {
            C3490e3.m665e("getResource - success");
            File a = C3785x1.m1886a(C3584j2.this.f1321h, l4Var.mo55545a());
            C3660o4<T> o4Var = C3584j2.this.f1316d;
            if (o4Var != null) {
                o4Var.mo55257a(a);
            }
        }
    }

    C3584j2(C3667p4 p4Var, C3592k0 k0Var, String str, @Nullable C3660o4<File> o4Var, boolean z) {
        super(p4Var, k0Var, o4Var);
        this.f1321h = str;
        this.f1320g = z;
        mo55495a(z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3586j3 mo55237a(C3588j4 j4Var) {
        C3593k1 k1Var = C3588j4.C3589a.NO_CONNECTION.equals(j4Var.mo55502a()) ? new C3593k1(C3586j3.C3587a.AUTH_NETWORK_ERROR) : C3588j4.C3589a.TIMEOUT.equals(j4Var.mo55502a()) ? new C3593k1(C3586j3.C3587a.GET_RESOURCE_TIMEOUT) : new C3593k1(C3586j3.C3587a.GET_RESOURCE_ERROR);
        C3490e3.m663c(k1Var.getMessage());
        return k1Var;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55238b() {
        C3586j3 d = mo55239d();
        if (d != null) {
            C3660o4<T> o4Var = this.f1316d;
            if (o4Var != null) {
                o4Var.mo55256a(d);
                return;
            }
            return;
        }
        this.f1313a.mo55697a(C3770w2.m1829a(this.f1314b.mo55510e(), true), this.f1320g ? mo55493a(C3646n3.C3648b.ACCESS_TOKEN) : null, (C3667p4.C3668a) new C3585a());
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
            C3490e3.m663c(C3586j3.C3587a.RESOURCE_EMPTY_ENDPOINT.toString());
            return new C3593k1(C3586j3.C3587a.RESOURCE_EMPTY_ENDPOINT);
        }
    }
}
