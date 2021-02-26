package com.medallia.digital.mobilesdk;

import android.util.Pair;
import com.medallia.digital.mobilesdk.C3586j3;
import com.medallia.digital.mobilesdk.C3815z4;
import java.io.File;

/* renamed from: com.medallia.digital.mobilesdk.d3 */
class C3481d3 implements C3663p0 {

    /* renamed from: a */
    private C3586j3 f1015a;

    /* renamed from: b */
    private boolean f1016b = false;

    protected C3481d3() {
    }

    protected C3481d3(boolean z, C3586j3 j3Var) {
        this.f1015a = j3Var;
        this.f1016b = z;
    }

    /* renamed from: a */
    private void m632a() {
        Pair<String, Boolean> a = C3729t0.m1642a();
        if (a != null) {
            AnalyticsBridge.getInstance().reportDeleteStorageEvent((String) a.first, ((Boolean) a.second).booleanValue());
        }
    }

    /* renamed from: b */
    private ConfigurationContract m633b() {
        File b = C3729t0.m1647b();
        ConfigurationContract a = C3729t0.m1644a(b);
        if (C3729t0.m1646a(b, a)) {
            if (this.f1016b) {
                long a2 = C3815z4.m2010d().mo55974a(C3815z4.C3816a.LOCAL_CONFIGURATION_TIMESTAMP, 0);
                if (a2 == 0) {
                    C3490e3.m665e("Offline: local configuration timestamp: is not available");
                    m632a();
                    this.f1015a = new C3593k1(C3586j3.C3587a.LOCAL_CONFIGURATION_TS_IS_NOT_AVAILABLE);
                    return null;
                } else if (C3729t0.m1645a(a)) {
                    C3490e3.m665e("Offline: local configuration is expired. timestamp: " + a2);
                    m632a();
                    this.f1015a = new C3593k1(C3586j3.C3587a.LOCAL_CONFIGURATION_IS_EXPIRED);
                    return null;
                } else {
                    AnalyticsBridge.getInstance().reportInitOfflineMechanismEvent(a2);
                }
            }
            C3490e3.m665e("Local configuration fetched successfully");
            return a;
        }
        if (!this.f1016b) {
            this.f1015a = new C3593k1(C3586j3.C3587a.LOCAL_CONFIGURATION_IS_NOT_AVAILABLE);
            m632a();
        }
        C3490e3.m661b("Local configuration is not available");
        return null;
    }

    /* renamed from: a */
    public void mo55309a(C3660o4<ConfigurationContract> o4Var) {
        ConfigurationContract b = m633b();
        if (b != null) {
            C3490e3.m661b("Offline configuration fetched successfully");
            if (o4Var != null) {
                o4Var.mo55257a(b);
                return;
            }
            return;
        }
        C3490e3.m661b("Offline configuration is not available");
        if (o4Var != null) {
            C3586j3 j3Var = this.f1015a;
            if (j3Var == null) {
                j3Var = new C3593k1(C3586j3.C3587a.GET_CONFIG_ERROR);
            }
            o4Var.mo55256a(j3Var);
        }
    }
}
