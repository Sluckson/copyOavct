package com.medallia.digital.mobilesdk;

import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.medallia.digital.mobilesdk.C3586j3;
import com.medallia.digital.mobilesdk.C3667p4;
import com.medallia.digital.mobilesdk.C3815z4;
import java.net.URLEncoder;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.i4 */
class C3573i4 implements C3663p0 {

    /* renamed from: h */
    private static final String f1292h = "uuid";

    /* renamed from: a */
    private C3672q f1293a;

    /* renamed from: b */
    private C3667p4 f1294b;

    /* renamed from: c */
    private String f1295c;

    /* renamed from: d */
    private HashMap<String, String> f1296d;

    /* renamed from: e */
    private HashMap<String, String> f1297e;

    /* renamed from: f */
    private int f1298f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C3660o4<ConfigurationContract> f1299g;

    /* renamed from: com.medallia.digital.mobilesdk.i4$a */
    class C3574a implements C3667p4.C3668a {
        C3574a() {
        }

        /* renamed from: a */
        public void mo55240a() {
        }

        /* renamed from: a */
        public void mo55241a(C3588j4 j4Var) {
            if (j4Var == null || j4Var.mo55503b() != 401) {
                C3490e3.m661b("Remote configuration error trying to fetch offline");
                C3573i4.this.mo55485a();
                return;
            }
            C3490e3.m661b("Remote configuration auth error");
            C3573i4.this.mo55486a(j4Var);
        }

        /* renamed from: a */
        public void mo55242a(C3609l4 l4Var) {
            if (l4Var == null) {
                C3490e3.m663c("Configuration response is null");
                C3573i4.this.mo55485a();
                return;
            }
            String b = l4Var.mo55546b();
            ConfigurationContract createConfiguration = ModelFactory.getInstance().createConfiguration(b);
            if (createConfiguration != null) {
                Pair<String, Boolean> a = C3729t0.m1643a(b);
                if (a != null) {
                    AnalyticsBridge.getInstance().reportDeleteStorageEvent((String) a.first, ((Boolean) a.second).booleanValue());
                }
                if (createConfiguration.getConfigurationUUID() != null) {
                    C3490e3.m665e("Saving UUID and UUID url");
                    C3815z4.m2010d().mo55984b(C3815z4.C3816a.UUID, createConfiguration.getConfigurationUUID().getUuid());
                    C3815z4.m2010d().mo55984b(C3815z4.C3816a.UUID_URL, createConfiguration.getConfigurationUUID().getUrl());
                }
                C3490e3.m665e("Configuration updated successfully");
                C3573i4.this.f1299g.mo55257a(createConfiguration);
                return;
            }
            C3490e3.m661b("Remote configuration is broken trying to fetch offline");
            C3490e3.m663c(C3586j3.C3587a.REMOTE_CONFIGURATION_IS_CORRUPTED.toString());
            C3573i4.this.mo55485a();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.i4$b */
    class C3575b implements C3660o4<Void> {

        /* renamed from: a */
        final /* synthetic */ C3588j4 f1301a;

        C3575b(C3588j4 j4Var) {
            this.f1301a = j4Var;
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3573i4.this.mo55486a(this.f1301a);
        }

        /* renamed from: a */
        public void mo55257a(Void voidR) {
            C3573i4 i4Var = C3573i4.this;
            i4Var.mo55309a((C3660o4<ConfigurationContract>) i4Var.f1299g);
        }
    }

    C3573i4(C3667p4 p4Var, String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        this.f1294b = p4Var;
        this.f1293a = new C3672q(p4Var);
        this.f1295c = str;
        this.f1296d = hashMap;
        this.f1297e = hashMap2;
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55485a() {
        new C3481d3().mo55309a(this.f1299g);
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55486a(C3588j4 j4Var) {
        int i;
        if (j4Var.mo55503b() != 401 || (i = this.f1298f) >= 2) {
            C3660o4<ConfigurationContract> o4Var = this.f1299g;
            if (o4Var != null) {
                o4Var.mo55256a(new C3586j3(C3586j3.C3587a.REMOTE_CONFIGURATION_AUTH_FAILED));
                return;
            }
            return;
        }
        this.f1298f = i + 1;
        this.f1293a.mo55707a((C3660o4<Void>) new C3575b(j4Var));
    }

    /* renamed from: a */
    public void mo55309a(C3660o4<ConfigurationContract> o4Var) {
        this.f1299g = o4Var;
        if (C3661o5.m1408b() != null) {
            try {
                this.f1296d.put(f1292h, URLEncoder.encode(C3661o5.m1408b(), "UTF-8"));
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        this.f1294b.mo55698a(this.f1295c, this.f1296d, this.f1297e, new C3574a());
    }
}
