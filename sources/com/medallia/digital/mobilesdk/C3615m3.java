package com.medallia.digital.mobilesdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.medallia.digital.mobilesdk.AnalyticsBridge;
import com.medallia.digital.mobilesdk.C3461c3;
import com.medallia.digital.mobilesdk.C3552h2;
import com.medallia.digital.mobilesdk.C3565i0;
import com.medallia.digital.mobilesdk.C3586j3;
import com.medallia.digital.mobilesdk.C3682q4;
import com.medallia.digital.mobilesdk.C3717s2;
import com.medallia.digital.mobilesdk.C3792y;
import com.medallia.digital.mobilesdk.C3815z4;
import com.medallia.digital.mobilesdk.MDExternalError;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.m3 */
class C3615m3 implements C3461c3.C3468g, C3713r5, C3765v5 {

    /* renamed from: l */
    private static final long f1438l = 2000;

    /* renamed from: m */
    private static final long f1439m = 6000;

    /* renamed from: n */
    private static final String f1440n = "events";

    /* renamed from: o */
    private static final String f1441o = "userJourney";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f1442a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f1443b = false;

    /* renamed from: c */
    private C3565i0 f1444c = new C3565i0();

    /* renamed from: d */
    private C3764v4 f1445d = new C3764v4();

    /* renamed from: e */
    private C3768w1 f1446e = new C3768w1();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C3786x2 f1447f = new C3786x2();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public C3510f0 f1448g = new C3510f0();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public MedalliaExceptionHandler f1449h = new MedalliaExceptionHandler(C3595k3.m1060d().mo55511a());

    /* renamed from: i */
    private long f1450i = f1439m;

    /* renamed from: j */
    private MDSdkFrameworkType f1451j = MDSdkFrameworkType.Native;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public long f1452k;

    /* renamed from: com.medallia.digital.mobilesdk.m3$a */
    class C3616a extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ MDResultCallback f1453a;

        /* renamed from: b */
        final /* synthetic */ MDExternalError f1454b;

        C3616a(MDResultCallback mDResultCallback, MDExternalError mDExternalError) {
            this.f1453a = mDResultCallback;
            this.f1454b = mDExternalError;
        }

        /* renamed from: a */
        public void mo55177a() {
            this.f1453a.onError(this.f1454b);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$b */
    class C3617b extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ MDResultCallback f1456a;

        C3617b(MDResultCallback mDResultCallback) {
            this.f1456a = mDResultCallback;
        }

        /* renamed from: a */
        public void mo55177a() {
            this.f1456a.onSuccess();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$c */
    class C3618c implements C3660o4<C3564i> {
        C3618c() {
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55257a(C3564i iVar) {
            C3754u5.m1743f().mo55858a(true, Long.valueOf(iVar.mo55475d()), iVar.mo55468a());
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$d */
    class C3619d implements C3552h2.C3555c {

        /* renamed from: a */
        final /* synthetic */ ConfigurationContract f1459a;

        C3619d(ConfigurationContract configurationContract) {
            this.f1459a = configurationContract;
        }

        /* renamed from: a */
        public void mo55462a() {
            C3615m3.this.f1448g.mo55369a(this.f1459a);
            C3615m3.this.f1448g.mo55371a(C3552h2.m914h().mo55455c());
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$e */
    class C3620e implements C3660o4<ConfigurationContract> {

        /* renamed from: a */
        final /* synthetic */ long f1461a;

        /* renamed from: b */
        final /* synthetic */ long f1462b;

        C3620e(long j, long j2) {
            this.f1461a = j;
            this.f1462b = j2;
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55257a(ConfigurationContract configurationContract) {
            C3490e3.m665e("Refresh session success");
            if (C3615m3.this.mo55577a(configurationContract)) {
                CollectorsInfrastructure.getInstance().stopCollectors();
                C3496e5.m699h().mo55350a(false, true);
                C3490e3.m663c("SDK functionality has been turned off");
                return;
            }
            C3615m3.this.m1148a(configurationContract, this.f1461a, this.f1462b);
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3490e3.m663c("Refresh session failed " + j3Var.getMessage());
            C3615m3.this.m1147a(AnalyticsBridge.C3414c.failure, this.f1461a, this.f1462b);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$f */
    class C3621f implements C3660o4<C3564i> {
        C3621f() {
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55257a(C3564i iVar) {
            C3754u5.m1743f().mo55865b(true, Long.valueOf(iVar.mo55475d()), iVar.mo55468a());
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$g */
    class C3622g implements C3552h2.C3555c {
        C3622g() {
        }

        /* renamed from: a */
        public void mo55462a() {
            C3615m3.this.f1448g.mo55371a(C3552h2.m914h().mo55455c());
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$h */
    class C3623h implements C3660o4<C3564i> {
        C3623h() {
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55257a(C3564i iVar) {
            C3754u5.m1743f().mo55861a(Long.valueOf(iVar.mo55475d()), iVar.mo55468a());
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$i */
    class C3624i extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ MDResultCallback f1467a;

        /* renamed from: b */
        final /* synthetic */ String f1468b;

        C3624i(MDResultCallback mDResultCallback, String str) {
            this.f1467a = mDResultCallback;
            this.f1468b = str;
        }

        /* renamed from: a */
        public void mo55177a() {
            long unused = C3615m3.this.f1452k = System.currentTimeMillis();
            if (C3615m3.this.f1443b) {
                C3615m3.this.m1171c(new MDExternalError(MDExternalError.ExternalError.SDK_INITIALIZATION_IN_PROGRESS), this.f1467a);
            } else if (!C3615m3.this.f1447f.mo55921b() || C3615m3.this.f1447f.mo55918a()) {
                C3615m3.this.f1449h.updateFilePath(C3595k3.m1060d().mo55511a());
                boolean unused2 = C3615m3.this.f1443b = true;
                C3615m3.this.f1448g.mo55372a(C3615m3.this.f1442a, C3615m3.this.f1443b);
                if (C3723s4.m1629b() || C3723s4.m1628a()) {
                    C3490e3.m665e("SDK Upgrade - delete UUID and local configuration storage");
                    C3661o5.m1405a();
                    Pair<String, Boolean> a = C3729t0.m1642a();
                    if (a != null) {
                        AnalyticsBridge.getInstance().reportDeleteStorageEvent((String) a.first, ((Boolean) a.second).booleanValue());
                    }
                }
                C3723s4.m1630c();
                C3615m3.this.m1172c(this.f1467a);
                C3580j createApiToken = ModelFactory.getInstance().createApiToken(this.f1468b);
                if (createApiToken == null) {
                    boolean unused3 = C3615m3.this.f1443b = false;
                    C3615m3.this.f1448g.mo55372a(C3615m3.this.f1442a, C3615m3.this.f1443b);
                    C3615m3.this.m1158a((C3665p2) new C3593k1(C3586j3.C3587a.API_TOKEN_PARSE_ERROR), this.f1467a);
                    C3615m3.this.clearAndDisconnect();
                } else if (!C3615m3.this.f1442a || C3604l2.m1115c().mo55538b() == null || !C3604l2.m1115c().mo55538b().mo55850a().equals(createApiToken.mo55850a())) {
                    C3604l2.m1115c().mo55537a(createApiToken);
                    if (!C3604l2.m1115c().mo55538b().mo55850a().equals(C3659o3.m1391f().mo55687a(C3815z4.C3816a.API_TOKEN))) {
                        C3659o3.m1391f().mo55689a(C3815z4.C3816a.API_TOKEN, C3604l2.m1115c().mo55538b().mo55850a());
                        C3659o3.m1391f().mo55689a(C3815z4.C3816a.ACCESS_TOKEN, (String) null);
                    }
                    C3490e3.m665e("SDK init started");
                    AnalyticsBridge.getInstance().reportInitEvent();
                    C3767w0.m1812b().mo55893a();
                    C3646n3.m1337m().mo55661a(60000, 3, 60000, 0, 512, 3);
                    C3615m3.this.m1150a(this.f1467a);
                } else {
                    boolean unused4 = C3615m3.this.f1443b = false;
                    C3615m3.this.f1448g.mo55372a(C3615m3.this.f1442a, C3615m3.this.f1443b);
                    C3615m3.this.m1163b(new MDExternalError(MDExternalError.ExternalError.SDK_IS_ALREADY_INITIALIZED), this.f1467a);
                }
            } else {
                C3615m3.this.m1163b(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED), this.f1467a);
                C3461c3.m562g().clearAndDisconnect();
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$j */
    class C3625j extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ String f1470a;

        /* renamed from: b */
        final /* synthetic */ Object f1471b;

        C3625j(String str, Object obj) {
            this.f1470a = str;
            this.f1471b = obj;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3767w0.m1812b().mo55894a(this.f1470a, this.f1471b, C3615m3.this.f1442a);
            AnalyticsBridge.getInstance().reportSetCustomParameterEvent(this.f1470a);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$k */
    class C3626k extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ HashMap f1473a;

        C3626k(HashMap hashMap) {
            this.f1473a = hashMap;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3767w0.m1812b().mo55895a((HashMap<String, Object>) this.f1473a, C3615m3.this.f1442a);
            AnalyticsBridge.getInstance().reportSetCustomParametersEvent(this.f1473a);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$l */
    class C3627l extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ boolean f1475a;

        /* renamed from: com.medallia.digital.mobilesdk.m3$l$a */
        class C3628a implements C3660o4<C3564i> {
            C3628a() {
            }

            /* renamed from: a */
            public void mo55254a() {
            }

            /* renamed from: a */
            public void mo55257a(C3564i iVar) {
                C3754u5.m1743f().mo55861a(Long.valueOf(iVar.mo55475d()), iVar.mo55468a());
                if (iVar.mo55474c() >= C3646n3.m1337m().mo55675f() || iVar.mo55471b() < C3646n3.m1337m().mo55673d()) {
                    C3627l lVar = C3627l.this;
                    C3615m3.this.m1177d(lVar.f1475a);
                }
            }

            /* renamed from: a */
            public void mo55256a(C3586j3 j3Var) {
                C3627l lVar = C3627l.this;
                C3615m3.this.m1177d(lVar.f1475a);
            }
        }

        C3627l(boolean z) {
            this.f1475a = z;
        }

        /* renamed from: a */
        public void mo55177a() {
            if (C3815z4.m2010d().mo55979a(C3815z4.C3816a.SDK_STOPPED, false)) {
                C3490e3.m665e("SDK is already stopped");
                return;
            }
            AnalyticsBridge.getInstance().reportStopSDKEventImmidated(this.f1475a);
            new C3547h(C3615m3.this, System.currentTimeMillis(), new C3628a()).mo55437a();
            C3754u5.m1743f().mo55860a(Lifetime.Session);
            if (C3646n3.m1337m().mo55672c() == null || !C3646n3.m1337m().mo55672c().mo55366d()) {
                C3615m3.this.m1177d(this.f1475a);
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$m */
    class C3629m extends C3666p3 {
        C3629m() {
        }

        /* renamed from: a */
        public void mo55177a() {
            if (!C3815z4.m2010d().mo55979a(C3815z4.C3816a.SDK_STOPPED, false)) {
                C3490e3.m665e("SDK is not stopped");
                return;
            }
            if (C3615m3.this.f1449h != null) {
                C3615m3.this.f1449h.register();
            }
            C3490e3.m665e("SDK stop is reverting");
            C3815z4.m2010d().mo55985b(C3815z4.C3816a.SDK_STOPPED, false);
            C3754u5.m1743f().mo55866c(false);
            C3496e5.m699h().mo55349a(false);
            AnalyticsBridge.getInstance().reportRevertStopSdkEvent();
            C3815z4.m2010d().mo55984b(C3815z4.C3816a.MISSING_EVENTS, AnalyticsBridge.getInstance().exportPendingEventsToJson());
            C3815z4.m2010d().mo55984b(C3815z4.C3816a.MISSING_EVENTS_V2, AnalyticsBridge.getInstance().exportPendingV2EventsToJson());
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$n */
    class C3630n implements C3660o4<ConfigurationContract> {

        /* renamed from: a */
        final /* synthetic */ MDResultCallback f1479a;

        C3630n(MDResultCallback mDResultCallback) {
            this.f1479a = mDResultCallback;
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55257a(ConfigurationContract configurationContract) {
            C3490e3.m665e("SDK init finished successfully");
            boolean unused = C3615m3.this.f1443b = false;
            boolean unused2 = C3615m3.this.f1442a = true;
            C3615m3.this.f1448g.mo55372a(C3615m3.this.f1442a, C3615m3.this.f1443b);
            if (C3615m3.this.mo55577a(configurationContract)) {
                C3615m3.this.m1171c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED), this.f1479a);
                return;
            }
            C3615m3.this.m1164b(this.f1479a);
            C3615m3.this.mo55579b(configurationContract);
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3615m3.this.m1158a((C3665p2) j3Var, this.f1479a);
            C3615m3.this.clearAndDisconnect();
            boolean unused = C3615m3.this.f1443b = false;
            C3615m3.this.f1448g.mo55372a(C3615m3.this.f1442a, C3615m3.this.f1443b);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$o */
    class C3631o implements C3660o4<Void> {

        /* renamed from: a */
        final /* synthetic */ C3660o4 f1481a;

        /* renamed from: b */
        final /* synthetic */ C3564i f1482b;

        C3631o(C3660o4 o4Var, C3564i iVar) {
            this.f1481a = o4Var;
            this.f1482b = iVar;
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3490e3.m663c(j3Var.getMessage());
            this.f1481a.mo55256a(j3Var);
        }

        /* renamed from: a */
        public void mo55257a(Void voidR) {
            C3490e3.m665e("Analytics v2 sent successfully");
            this.f1481a.mo55257a(this.f1482b);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$p */
    class C3632p implements C3660o4<Void> {
        C3632p() {
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3490e3.m663c(j3Var.getMessage());
        }

        /* renamed from: a */
        public void mo55257a(Void voidR) {
            C3490e3.m665e("Analytics sent successfully");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$q */
    class C3633q extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ ConfigurationContract f1485a;

        /* renamed from: com.medallia.digital.mobilesdk.m3$q$a */
        class C3634a extends C3666p3 {
            C3634a() {
            }

            /* renamed from: a */
            public void mo55177a() {
                C3496e5.m699h().mo55344a(C3633q.this.f1485a);
            }
        }

        C3633q(ConfigurationContract configurationContract) {
            this.f1485a = configurationContract;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3561h5.m954c().mo55465a().execute(new C3634a());
        }
    }

    @VisibleForTesting
    /* renamed from: com.medallia.digital.mobilesdk.m3$r */
    public enum C3635r {
        CODE,
        NOTIFICATION
    }

    /* renamed from: com.medallia.digital.mobilesdk.m3$s */
    private enum C3636s {
        V1,
        V2
    }

    protected C3615m3() {
        m1151a(this.f1449h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1147a(AnalyticsBridge.C3414c cVar, long j, long j2) {
        try {
            AnalyticsBridge instance = AnalyticsBridge.getInstance();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                instance.reportRefreshSessionEvent(j, currentTimeMillis, j2, this.f1445d.mo55874a(), C3815z4.m2010d().mo55975a(C3815z4.C3816a.PREVIOUS_SESSION_ID, (String) null), cVar);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1148a(ConfigurationContract configurationContract, long j, long j2) {
        ConfigurationContract configurationContract2 = configurationContract;
        try {
            m1170c(configurationContract);
            Boolean valueOf = C3815z4.m2010d().mo55980b().contains(C3815z4.C3816a.PREVIOUS_ANALYTICS_V2.toString()) ? Boolean.valueOf(C3815z4.m2010d().mo55979a(C3815z4.C3816a.PREVIOUS_ANALYTICS_V2, false)) : null;
            Boolean valueOf2 = C3815z4.m2010d().mo55980b().contains(C3815z4.C3816a.PREVIOUS_SEND_USER_JOURNEY.toString()) ? Boolean.valueOf(C3815z4.m2010d().mo55979a(C3815z4.C3816a.PREVIOUS_SEND_USER_JOURNEY, false)) : null;
            long currentTimeMillis = System.currentTimeMillis();
            new C3547h(this, valueOf, valueOf2, currentTimeMillis, new C3621f()).mo55437a();
            C3646n3.m1337m().mo55663a(configurationContract);
            if (configurationContract.getSdkConfiguration() != null) {
                AnalyticsBridge.getInstance().initAnalytics((configurationContract.getSdkConfiguration().getMedalliaDigitalClientConfig() == null || configurationContract.getSdkConfiguration().getMedalliaDigitalClientConfig().getAnalyticsV2ConfigurationContract() == null || !configurationContract.getSdkConfiguration().getMedalliaDigitalClientConfig().getAnalyticsV2ConfigurationContract().mo55366d()) ? false : true, configurationContract.getSdkConfiguration().getEventsConfigurations());
            }
            C3815z4.m2010d().mo55984b(C3815z4.C3816a.MISSING_EVENTS, (String) null);
            C3815z4.m2010d().mo55984b(C3815z4.C3816a.MISSING_EVENTS_V2, (String) null);
            this.f1445d.mo55877b();
            this.f1446e.mo55897a();
            C3552h2.m914h().mo55443a(configurationContract, (C3552h2.C3555c) new C3622g());
            C3754u5.m1743f().mo55865b(false, (Long) null, currentTimeMillis);
            m1176d(configurationContract);
            this.f1445d.mo55878c();
            m1147a(AnalyticsBridge.C3414c.f832a, j, j2);
            C3490e3.m665e("SDK refresh session finished successfully");
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m1149a(MDExternalError mDExternalError, MDResultCallback mDResultCallback) {
        if (mDResultCallback != null) {
            C3561h5.m954c().mo55466b().execute(new C3616a(mDResultCallback, mDExternalError));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1150a(MDResultCallback mDResultCallback) {
        C3646n3.m1337m().mo55667a("2.0.0", (C3660o4<ConfigurationContract>) new C3630n(mDResultCallback));
    }

    /* renamed from: a */
    private void m1151a(MedalliaExceptionHandler medalliaExceptionHandler) {
        if (C3815z4.m2010d().mo55979a(C3815z4.C3816a.IS_BLACKBOX_ENABLED, false) && medalliaExceptionHandler != null) {
            medalliaExceptionHandler.register();
            C3490e3.m665e("Register to Blackbox");
        }
    }

    /* renamed from: a */
    private void m1157a(C3660o4<C3564i> o4Var, long j, Long l, int i) {
        ArrayList<C3485e> a = C3754u5.m1743f().mo55852a(j, l, i);
        JSONObject b = C3754u5.m1743f().mo55864b(a);
        String a2 = C3815z4.m2010d().mo55975a(C3815z4.C3816a.MISSING_EVENTS_V2, (String) null);
        if (a2 != null) {
            try {
                JSONArray jSONArray = b.getJSONArray(f1440n);
                JSONArray jSONArray2 = new JSONArray(a2);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    jSONArray2.put(jSONArray.get(i2));
                }
                b.put(f1440n, jSONArray2);
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        if (b != null) {
            try {
                if (!b.has(f1440n) || !(b.get(f1440n) instanceof JSONArray) || b.getJSONArray(f1440n).length() != 0) {
                    C3564i iVar = new C3564i();
                    iVar.mo55470a(a.get(a.size() - 1).mo55326f());
                    iVar.mo55473b(a.get(0).mo55326f());
                    iVar.mo55469a(a.size());
                    C3646n3.m1337m().mo55671b(new C3631o(o4Var, iVar), b);
                    return;
                }
            } catch (JSONException e2) {
                C3490e3.m663c(e2.getMessage());
                return;
            }
        }
        C3490e3.m665e("Can't submit Analytics V2 - Json is null or empty");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1158a(C3665p2 p2Var, MDResultCallback mDResultCallback) {
        MDExternalError a = p2Var.mo55691a();
        C3490e3.m665e("Failure");
        if (a != null && mDResultCallback != null) {
            C3461c3.m562g().mo55273e();
            C3490e3.m663c(a.getMessage());
            m1149a(a, mDResultCallback);
            AnalyticsBridge.getInstance().reportInitCallbackEvent(AnalyticsBridge.C3414c.failure, Integer.valueOf(a.getErrorCode()), a.getMessage(), System.currentTimeMillis() - this.f1452k);
        }
    }

    /* renamed from: a */
    private void m1159a(File file) {
        Boolean a = C3785x1.m1887a(file);
        if (a != null) {
            AnalyticsBridge.getInstance().reportDeleteStorageEvent(C3785x1.m1897d(".crashes/crash.txt"), a.booleanValue());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1163b(MDExternalError mDExternalError, MDResultCallback mDResultCallback) {
        C3490e3.m665e("Failure");
        C3490e3.m663c("End - " + mDExternalError.getMessage());
        m1149a(mDExternalError, mDResultCallback);
        AnalyticsBridge.getInstance().reportInitCallbackEvent(AnalyticsBridge.C3414c.failure, Integer.valueOf(mDExternalError.getErrorCode()), mDExternalError.getMessage(), System.currentTimeMillis() - this.f1452k);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1164b(MDResultCallback mDResultCallback) {
        if (mDResultCallback != null) {
            C3561h5.m954c().mo55466b().execute(new C3617b(mDResultCallback));
        }
    }

    /* renamed from: c */
    private void m1169c(long j) {
        C3490e3.m665e("Refresh session started");
        C3702r2.m1571c().mo55769a(C3717s2.C3720c.refreshSession);
        C3646n3.m1337m().mo55667a("2.0.0", (C3660o4<ConfigurationContract>) new C3620e(System.currentTimeMillis(), j));
    }

    /* renamed from: c */
    private void m1170c(ConfigurationContract configurationContract) {
        if (configurationContract != null && configurationContract.getSdkConfiguration() != null && configurationContract.getSdkConfiguration().getMedalliaDigitalBrain() != null) {
            this.f1450i = configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().getMaxUserJourneyEventsSize();
            C3815z4.m2010d().mo55985b(C3815z4.C3816a.IS_BLACKBOX_ENABLED, configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().isBlackBoxEnabled());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1171c(MDExternalError mDExternalError, MDResultCallback mDResultCallback) {
        C3490e3.m665e("Failure");
        C3490e3.m666f("End - " + mDExternalError.getMessage());
        m1149a(mDExternalError, mDResultCallback);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m1172c(MDResultCallback mDResultCallback) {
        if (mDResultCallback == null) {
            C3490e3.m666f("Missing listener, however, method will run regardless");
        }
    }

    /* renamed from: c */
    private void m1174c(boolean z) {
        try {
            File file = new File(C3785x1.m1897d(".crashes/crash.txt"));
            String e = C3785x1.m1900e(file);
            if (e != null) {
                if (e.indexOf("com.medallia.digital.mobilesdk") != -1) {
                    JSONObject jSONObject = new JSONObject(e);
                    long j = jSONObject.getLong("timestamp");
                    String string = jSONObject.getString("stacktrace");
                    Long valueOf = Long.valueOf(C3815z4.m2010d().mo55974a(C3815z4.C3816a.PROPERTY_ID, -1));
                    String a = C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, (String) null);
                    boolean reportMedalliaCrashEventImmediate = AnalyticsBridge.getInstance().reportMedalliaCrashEventImmediate(string, j, C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, UUID.randomUUID().toString()), valueOf);
                    if ((!z && (!C3802y5.m1954a() || a == null)) || !reportMedalliaCrashEventImmediate) {
                        return;
                    }
                }
                m1159a(file);
            }
        } catch (Exception e2) {
            C3490e3.m663c(e2.getMessage());
        }
    }

    /* renamed from: d */
    private void m1176d(ConfigurationContract configurationContract) {
        C3715s0.m1612b().mo55793a(configurationContract);
        CollectorsConfigurationContract collectorsConfigurations = (configurationContract == null || configurationContract.getSdkConfiguration() == null) ? null : configurationContract.getSdkConfiguration().getCollectorsConfigurations();
        this.f1445d.mo55875a(configurationContract);
        C3754u5.m1743f().mo55856a(configurationContract);
        CollectorsInfrastructure.getInstance().updateConfiguration(collectorsConfigurations);
        CollectorsInfrastructure.getInstance().pollAll();
        new Handler(Looper.getMainLooper()).postDelayed(new C3633q(configurationContract), 2000);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m1177d(boolean z) {
        C3815z4.m2010d().mo55985b(C3815z4.C3816a.SDK_STOPPED, true);
        C3490e3.m665e("SDK is stopped");
        C3496e5.m699h().mo55349a(true);
        MedalliaExceptionHandler medalliaExceptionHandler = this.f1449h;
        if (medalliaExceptionHandler != null) {
            medalliaExceptionHandler.unregister();
        }
        if (z) {
            C3754u5.m1743f().mo55866c(true);
            C3754u5.m1743f().mo55860a(Lifetime.Forever);
            C3767w0.m1812b().mo55893a();
            C3782x0.m1872d().mo55907a(C3792y.C3793a.Feedback, Long.valueOf(System.currentTimeMillis()));
            m1159a(new File(C3785x1.m1897d(".crashes/crash.txt")));
        }
        C3702r2.m1571c().mo55769a(C3717s2.C3720c.stopApi);
    }

    /* renamed from: d */
    private boolean m1178d() {
        return C3815z4.m2010d().mo55979a(C3815z4.C3816a.SDK_STOPPED, false);
    }

    /* renamed from: e */
    private void m1181e() {
        JSONObject a = C3754u5.m1743f().mo55868d() > this.f1450i ? C3754u5.m1743f().mo55855a(true) : C3754u5.m1743f().mo55855a(false);
        String a2 = C3815z4.m2010d().mo55975a(C3815z4.C3816a.MISSING_EVENTS, (String) null);
        if (a2 != null) {
            try {
                JSONArray jSONArray = a.getJSONArray(f1441o);
                JSONArray jSONArray2 = new JSONArray(a2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    jSONArray2.put(jSONArray.get(i));
                }
                a.put(f1441o, jSONArray2);
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        if (a != null) {
            try {
                if (!a.has(f1441o) || !(a.get(f1441o) instanceof JSONArray) || a.getJSONArray(f1441o).length() != 0) {
                    C3646n3.m1337m().mo55664a((C3660o4<Void>) new C3632p(), a);
                    return;
                }
            } catch (JSONException e2) {
                C3490e3.m663c(e2.getMessage());
                return;
            }
        }
        C3490e3.m665e("Can't submit Analytics - Json is null or empty");
    }

    /* renamed from: e */
    private void m1182e(boolean z) {
        this.f1445d.mo55878c();
        m1183f();
        CollectorsInfrastructure.getInstance().setSDKAnalyticsVersion(C3682q4.C3683a.valueOf(z ? "V2" : "V1"));
        CollectorsInfrastructure.getInstance().setSDKFramework(this.f1451j);
    }

    /* renamed from: f */
    private void m1183f() {
        long d = C3604l2.m1115c().mo55534a().mo55174d();
        CollectorsInfrastructure.getInstance().setPropertyId(Long.valueOf(d));
        C3815z4.m2010d().mo55983b(C3815z4.C3816a.PROPERTY_ID, d);
    }

    /* renamed from: a */
    public void mo55562a() {
        new C3547h(this, System.currentTimeMillis(), new C3623h()).mo55437a();
        C3754u5.m1743f().mo55859a();
    }

    /* renamed from: a */
    public void mo55286a(long j) {
        mo55578b(j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55563a(long j, Long l, Boolean bool, Boolean bool2, C3660o4<C3564i> o4Var, int i) {
        if ((bool != null && bool.booleanValue()) || (bool == null && C3646n3.m1337m().mo55672c() != null && C3646n3.m1337m().mo55672c().mo55366d())) {
            m1157a(o4Var, j, l, C3646n3.m1337m().mo55673d());
            if (i != 0) {
                return;
            }
            if ((bool2 == null || !bool2.booleanValue()) && (bool2 != null || !C3646n3.m1337m().mo55672c().mo55367e())) {
                return;
            }
        }
        m1181e();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55564a(Activity activity) {
        if (activity != null) {
            try {
                Activity activity2 = (Activity) C3595k3.m1060d().mo55514c().getBaseContext();
            } catch (Exception unused) {
                C3595k3.m1058a(activity.getApplication());
                C3595k3.m1060d().mo55512a((Context) activity);
                C3461c3.m562g().mo55262a(activity);
                AnalyticsBridge.getInstance().reportSetActivityEvent(activity);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55565a(MDFeedbackListener mDFeedbackListener) {
        try {
            this.f1444c.mo55477a(C3565i0.C3566a.Feedback, mDFeedbackListener);
            AnalyticsBridge.getInstance().reportSetFeedbackListenerEvent();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55566a(MDFormListener mDFormListener) {
        if (mDFormListener != null) {
            try {
                this.f1444c.mo55477a(C3565i0.C3566a.Form, new C3489e2(mDFormListener).mo55332a());
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
                return;
            }
        }
        AnalyticsBridge.getInstance().reportSetFormListenerEvent(C3636s.V1.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55567a(MDFormListenerV2 mDFormListenerV2) {
        try {
            this.f1444c.mo55477a(C3565i0.C3566a.Form, mDFormListenerV2);
            AnalyticsBridge.getInstance().reportSetFormListenerEvent(C3636s.V2.toString());
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: a */
    public void mo55568a(MDInterceptListener mDInterceptListener) {
        try {
            this.f1444c.mo55477a(C3565i0.C3566a.Intercept, mDInterceptListener);
            AnalyticsBridge.getInstance().reportSetInterceptListenerEvent();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55569a(MDInterceptV3Listener mDInterceptV3Listener) {
        if (mDInterceptV3Listener != null) {
            try {
                this.f1444c.mo55477a(C3565i0.C3566a.Intercept, new C3658o2(mDInterceptV3Listener).mo55686a());
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
                return;
            }
        }
        AnalyticsBridge.getInstance().reportSetInterceptListenerEvent();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: a */
    public void mo55570a(MDInvitationListener mDInvitationListener) {
        if (mDInvitationListener != null) {
            try {
                this.f1444c.mo55477a(C3565i0.C3566a.Intercept, new C3658o2(mDInvitationListener).mo55686a());
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
                return;
            }
        }
        AnalyticsBridge.getInstance().reportSetInvitationListenerEvent();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55571a(MDLogLevel mDLogLevel) {
        if (mDLogLevel != null) {
            try {
                if (!mDLogLevel.equals(MDLogLevel.OFF)) {
                    Log.w("com.medallia.digital", "setLogLevel method is to be used in integration stages only. Remove in app production rollout!");
                }
                C3490e3.m657a().mo55333a(mDLogLevel);
                C3490e3.m665e("Log level was set to " + mDLogLevel);
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
                return;
            }
        }
        AnalyticsBridge.getInstance().reportLoggerEvent(mDLogLevel);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55572a(MDSdkFrameworkType mDSdkFrameworkType) {
        if (this.f1451j != null) {
            this.f1451j = mDSdkFrameworkType;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55573a(String str, MDResultCallback mDResultCallback) {
        this.f1448g.mo55370a(C3635r.NOTIFICATION, str, mDResultCallback);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55574a(String str, Object obj) {
        C3561h5.m954c().mo55465a().execute(new C3625j(str, obj));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55575a(HashMap<String, Object> hashMap) {
        C3561h5.m954c().mo55465a().execute(new C3626k(hashMap));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55576a(boolean z) {
        try {
            if (this.f1442a) {
                if (z) {
                    C3490e3.m665e("Intercept was enabled");
                    CollectorsInfrastructure.getInstance().interceptEnabledCollector.mo55525a((Boolean) true);
                    AnalyticsBridge.getInstance().reportEnableInterceptEvent();
                } else {
                    C3490e3.m665e("Intercept was disabled");
                    CollectorsInfrastructure.getInstance().interceptDisabledCollector.mo55525a((Boolean) true);
                    AnalyticsBridge.getInstance().reportDisableInterceptEvent();
                }
            }
            C3496e5.m699h().mo55350a(z, this.f1442a);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55577a(ConfigurationContract configurationContract) {
        if (!(configurationContract == null || configurationContract.getKillStatus() == null)) {
            if (this.f1447f.mo55919a(configurationContract.getKillStatus())) {
                this.f1447f.mo55920b(configurationContract.getKillStatus());
                Pair<String, Boolean> a = C3729t0.m1642a();
                if (a == null) {
                    return true;
                }
                AnalyticsBridge.getInstance().reportDeleteStorageEvent((String) a.first, ((Boolean) a.second).booleanValue());
                return true;
            } else if (this.f1447f.mo55923c(configurationContract.getKillStatus())) {
                AnalyticsBridge.getInstance().reportRestoreFromKillSDKEvent(System.currentTimeMillis());
            }
        }
        this.f1447f.clear();
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55578b(long j) {
        try {
            if (this.f1445d.mo55876a(j) && !m1178d()) {
                m1169c(j);
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55579b(ConfigurationContract configurationContract) {
        try {
            m1170c(configurationContract);
            if (!this.f1449h.isRegistered()) {
                m1151a(this.f1449h);
            }
            Boolean valueOf = C3815z4.m2010d().mo55980b().contains(C3815z4.C3816a.PREVIOUS_ANALYTICS_V2.toString()) ? Boolean.valueOf(C3815z4.m2010d().mo55979a(C3815z4.C3816a.PREVIOUS_ANALYTICS_V2, false)) : null;
            Boolean valueOf2 = C3815z4.m2010d().mo55980b().contains(C3815z4.C3816a.PREVIOUS_SEND_USER_JOURNEY.toString()) ? Boolean.valueOf(C3815z4.m2010d().mo55979a(C3815z4.C3816a.PREVIOUS_SEND_USER_JOURNEY, false)) : null;
            C3646n3.m1337m().mo55663a(configurationContract);
            AnalyticsBridge.getInstance().reportInitCallbackEvent(AnalyticsBridge.C3414c.f832a, (Integer) null, (String) null, System.currentTimeMillis() - this.f1452k);
            boolean z = configurationContract.getSdkConfiguration().getMedalliaDigitalClientConfig().getAnalyticsV2ConfigurationContract() != null && configurationContract.getSdkConfiguration().getMedalliaDigitalClientConfig().getAnalyticsV2ConfigurationContract().mo55366d();
            AnalyticsBridge.getInstance().initAnalytics(z, configurationContract.getSdkConfiguration().getEventsConfigurations());
            m1174c(z);
            long currentTimeMillis = System.currentTimeMillis();
            new C3547h(this, valueOf, valueOf2, currentTimeMillis, new C3618c()).mo55437a();
            C3815z4.m2010d().mo55984b(C3815z4.C3816a.MISSING_EVENTS, (String) null);
            C3815z4.m2010d().mo55984b(C3815z4.C3816a.MISSING_EVENTS_V2, (String) null);
            this.f1445d.mo55877b();
            this.f1446e.mo55897a();
            C3552h2.m914h().mo55443a(configurationContract, (C3552h2.C3555c) new C3619d(configurationContract));
            AnalyticsBridge.getInstance().reportPreInitEvents();
            CollectorsInfrastructure.getInstance().setInitialized(true);
            C3496e5.m699h().mo55352b();
            C3754u5.m1743f().mo55858a(false, (Long) null, currentTimeMillis);
            C3767w0.m1812b().mo55896a(this.f1442a);
            C3461c3.m562g().mo55264a((C3461c3.C3468g) this);
            m1176d(configurationContract);
            m1182e(z);
            AnalyticsBridge.getInstance().regeneratePreInitV2Events();
            this.f1444c.mo55477a(C3565i0.C3566a.UserJourneyAction, this);
            this.f1444c.mo55476a();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55580b(String str, MDResultCallback mDResultCallback) {
        C3561h5.m954c().mo55465a().execute(new C3624i(mDResultCallback, str));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55581b(boolean z) {
        C3561h5.m954c().mo55465a().execute(new C3627l(z));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo55582b() {
        return this.f1442a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo55583c() {
        C3561h5.m954c().mo55465a().execute(new C3629m());
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo55584c(String str, MDResultCallback mDResultCallback) {
        this.f1448g.mo55370a(C3635r.CODE, str, mDResultCallback);
    }

    public void clearAndDisconnect() {
        if (this.f1442a) {
            C3490e3.m659a("Medallia SDK");
            this.f1442a = false;
            this.f1445d = null;
            this.f1443b = false;
            this.f1448g.mo55372a(this.f1442a, this.f1443b);
            C3461c3.m562g().clearAndDisconnect();
            CollectorsInfrastructure.getInstance().clearAndDisconnect();
            C3785x1.m1889a();
            C3552h2.m914h().clearAndDisconnect();
            C3767w0.m1812b().clearAndDisconnect();
            C3754u5.m1743f().clearAndDisconnect();
            C3646n3.m1337m().clearAndDisconnect();
            C3782x0.m1872d().clearAndDisconnect();
            C3815z4.m2010d().clearAndDisconnect();
            C3659o3.m1391f().clearAndDisconnect();
            AnalyticsBridge.getInstance().clearAndDisconnect();
            C3604l2.m1115c().clearAndDisconnect();
            C3490e3.m665e("Disconnected from Medallia SDK");
            C3490e3.m657a().clearAndDisconnect();
        }
    }
}
