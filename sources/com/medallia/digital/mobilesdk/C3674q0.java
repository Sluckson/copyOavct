package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.medallia.digital.mobilesdk.C3586j3;
import com.medallia.digital.mobilesdk.C3588j4;
import com.medallia.digital.mobilesdk.C3646n3;
import com.medallia.digital.mobilesdk.C3667p4;
import com.medallia.digital.mobilesdk.C3815z4;

/* renamed from: com.medallia.digital.mobilesdk.q0 */
class C3674q0 extends C3581j0<ConfigurationContract> {

    /* renamed from: g */
    private C3676b f1636g;

    /* renamed from: com.medallia.digital.mobilesdk.q0$a */
    class C3675a implements C3667p4.C3668a {
        C3675a() {
        }

        /* renamed from: a */
        public void mo55240a() {
        }

        /* renamed from: a */
        public void mo55241a(C3588j4 j4Var) {
            C3490e3.m661b("Fetch uuid failed fetching remote configuration");
            C3674q0.this.mo55709f();
        }

        /* renamed from: a */
        public void mo55242a(C3609l4 l4Var) {
            if (l4Var.mo55546b() != null ? C3661o5.m1407a(ModelFactory.getInstance().createUUID(l4Var.mo55546b())) : false) {
                C3490e3.m661b("Fetch uuid success - using offline configuration");
                C3815z4.m2010d().mo55983b(C3815z4.C3816a.LOCAL_CONFIGURATION_TIMESTAMP, System.currentTimeMillis());
                C3674q0.this.mo55708e();
                return;
            }
            C3490e3.m661b("Fetch uuid success - Uuid changed generate remote configuration");
            C3674q0.this.mo55709f();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.q0$b */
    protected interface C3676b {
        /* renamed from: a */
        C3592k0 mo55681a();
    }

    C3674q0(C3667p4 p4Var, C3592k0 k0Var, C3676b bVar, C3660o4<ConfigurationContract> o4Var) {
        super(p4Var, k0Var, o4Var);
        this.f1636g = bVar;
    }

    @VisibleForTesting
    /* renamed from: a */
    private void m1451a(boolean z, C3586j3 j3Var) {
        new C3481d3(z, j3Var).mo55309a(this.f1316d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3586j3 mo55237a(C3588j4 j4Var) {
        C3593k1 k1Var = C3588j4.C3589a.NO_CONNECTION.equals(j4Var.mo55502a()) ? new C3593k1(C3586j3.C3587a.AUTH_NETWORK_ERROR) : C3588j4.C3589a.TIMEOUT.equals(j4Var.mo55502a()) ? new C3593k1(C3586j3.C3587a.CONFIGURATION_TIMEOUT) : new C3593k1(C3586j3.C3587a.GET_CONFIG_ERROR);
        C3490e3.m663c(k1Var.getMessage());
        return k1Var;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55238b() {
        if (mo55239d() != null) {
            C3490e3.m661b("Get config - Error trying to fetch offline configuration");
            mo55708e();
        } else if (!C3802y5.m1954a()) {
            C3490e3.m661b("Get config - No network error trying to fetch offline configuration");
            m1451a(true, new C3586j3(C3586j3.C3587a.NO_INTERNET_CONNECTION_AVAILABLE));
        } else {
            new C3670p5(this.f1313a, this.f1314b.mo55510e()).mo55705a((C3667p4.C3668a) new C3675a());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C3586j3 mo55239d() {
        if (C3604l2.m1115c().mo55534a() == null) {
            C3490e3.m663c(C3586j3.C3587a.ACCESS_TOKEN_EMPTY.toString());
            return new C3593k1(C3586j3.C3587a.ACCESS_TOKEN_EMPTY);
        } else if (!TextUtils.isEmpty(C3604l2.m1115c().mo55534a().mo55173c())) {
            return null;
        } else {
            C3490e3.m663c(C3586j3.C3587a.GET_CONFIG_EMPTY_ENDPOINT.toString());
            return new C3593k1(C3586j3.C3587a.GET_CONFIG_EMPTY_ENDPOINT);
        }
    }

    @VisibleForTesting
    /* renamed from: e */
    public void mo55708e() {
        new C3481d3().mo55309a(this.f1316d);
    }

    @VisibleForTesting
    /* renamed from: f */
    public void mo55709f() {
        C3676b bVar = this.f1636g;
        if (bVar != null) {
            this.f1314b = bVar.mo55681a();
        }
        new C3573i4(this.f1313a, this.f1314b.mo55510e(), this.f1314b.mo55508c(), mo55493a(C3646n3.C3648b.ACCESS_TOKEN)).mo55309a((C3660o4<ConfigurationContract>) this.f1316d);
    }
}
