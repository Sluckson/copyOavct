package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import com.medallia.digital.mobilesdk.C3586j3;
import com.medallia.digital.mobilesdk.C3588j4;
import com.medallia.digital.mobilesdk.C3646n3;
import com.medallia.digital.mobilesdk.C3667p4;
import com.medallia.digital.mobilesdk.C3815z4;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.q */
class C3672q {

    /* renamed from: b */
    private static final String f1631b = "sdkVersion";

    /* renamed from: c */
    private static final String f1632c = "osType";

    /* renamed from: a */
    private C3667p4 f1633a;

    /* renamed from: com.medallia.digital.mobilesdk.q$a */
    class C3673a implements C3667p4.C3668a {

        /* renamed from: a */
        final /* synthetic */ C3660o4 f1634a;

        C3673a(C3660o4 o4Var) {
            this.f1634a = o4Var;
        }

        /* renamed from: a */
        public void mo55240a() {
            C3660o4 o4Var = this.f1634a;
            if (o4Var != null) {
                o4Var.mo55254a();
            }
        }

        /* renamed from: a */
        public void mo55241a(C3588j4 j4Var) {
            C3586j3 a = C3672q.this.m1442a(j4Var, C3586j3.C3587a.AUTH_TIMEOUT, C3586j3.C3587a.EMPTY_AUTH_GW);
            C3490e3.m663c("Get access token error = " + j4Var.mo55502a());
            C3660o4 o4Var = this.f1634a;
            if (o4Var != null) {
                o4Var.mo55256a(a);
            }
        }

        /* renamed from: a */
        public void mo55242a(C3609l4 l4Var) {
            C3586j3.C3587a a = C3604l2.m1115c().mo55535a(l4Var != null ? l4Var.mo55546b() : null);
            if (a != null) {
                C3490e3.m663c("Could not parse access token");
                C3660o4 o4Var = this.f1634a;
                if (o4Var != null) {
                    o4Var.mo55256a((C3586j3) new C3593k1(a));
                    return;
                }
                return;
            }
            C3490e3.m665e("Access Token updated successfully");
            C3659o3.m1391f().mo55689a(C3815z4.C3816a.ACCESS_TOKEN, C3604l2.m1115c().mo55534a() != null ? C3604l2.m1115c().mo55534a().mo55850a() : null);
            this.f1634a.mo55257a(null);
        }
    }

    C3672q(C3667p4 p4Var) {
        this.f1633a = p4Var;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C3586j3 m1442a(C3588j4 j4Var, C3586j3.C3587a aVar, C3586j3.C3587a aVar2) {
        C3593k1 k1Var = C3588j4.C3589a.NO_CONNECTION.equals(j4Var.mo55502a()) ? new C3593k1(C3586j3.C3587a.AUTH_NETWORK_ERROR) : C3588j4.C3589a.TIMEOUT.equals(j4Var.mo55502a()) ? new C3593k1(aVar) : new C3593k1(aVar2);
        C3490e3.m663c(k1Var.getMessage());
        return k1Var;
    }

    /* renamed from: a */
    private HashMap<String, String> m1444a() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("sdkVersion", URLEncoder.encode(BuildConfig.VERSION_NAME, "UTF-8"));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        try {
            hashMap.put(f1632c, URLEncoder.encode("android", "UTF-8"));
        } catch (Exception e2) {
            C3490e3.m663c(e2.getMessage());
        }
        return hashMap;
    }

    /* renamed from: b */
    private boolean m1445b() {
        return System.currentTimeMillis() - C3604l2.m1115c().mo55534a().mo55172b() > C3604l2.m1115c().mo55534a().mo55175e() - C3646n3.m1337m().mo55660a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HashMap<String, String> mo55706a(C3646n3.C3648b bVar) {
        String format;
        HashMap<String, String> hashMap = new HashMap<>();
        if (bVar == C3646n3.C3648b.ACCESS_TOKEN && C3604l2.m1115c().mo55534a() != null && !TextUtils.isEmpty(C3604l2.m1115c().mo55534a().mo55850a())) {
            format = String.format("%s%s", new Object[]{"Bearer_", C3604l2.m1115c().mo55534a().mo55850a()});
        } else if (bVar != C3646n3.C3648b.API_TOKEN || C3604l2.m1115c().mo55538b() == null || TextUtils.isEmpty(C3604l2.m1115c().mo55538b().mo55850a())) {
            return hashMap;
        } else {
            format = String.format("%s%s", new Object[]{"Bearer_", C3604l2.m1115c().mo55538b().mo55850a()});
        }
        hashMap.put("Authorization", format);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55707a(C3660o4<Void> o4Var) {
        if (C3604l2.m1115c().mo55538b() != null) {
            if (C3604l2.m1115c().mo55534a() == null) {
                String a = C3659o3.m1391f().mo55687a(C3815z4.C3816a.ACCESS_TOKEN);
                if (!TextUtils.isEmpty(a)) {
                    C3604l2.m1115c().mo55536a(ModelFactory.getInstance().createAccessToken(a));
                    if (C3604l2.m1115c().mo55534a() == null) {
                        if (o4Var != null) {
                            o4Var.mo55256a((C3586j3) new C3593k1(C3586j3.C3587a.ACCESS_TOKEN_PARSE));
                            return;
                        }
                        return;
                    }
                }
            }
            if (C3604l2.m1115c().mo55534a() != null && !m1445b()) {
                o4Var.mo55257a(null);
            } else if (!TextUtils.isEmpty(C3604l2.m1115c().mo55538b().mo55489b())) {
                C3490e3.m661b("Get access token started");
                this.f1633a.mo55701b(C3604l2.m1115c().mo55538b().mo55489b(), m1444a(), mo55706a(C3646n3.C3648b.API_TOKEN), (JSONObject) null, new C3673a(o4Var));
            } else if (o4Var != null) {
                o4Var.mo55256a((C3586j3) new C3593k1(C3586j3.C3587a.EMPTY_AUTH_GW));
            }
        } else if (o4Var != null) {
            o4Var.mo55256a((C3586j3) new C3593k1(C3586j3.C3587a.API_TOKEN_EMPTY));
        }
    }
}
