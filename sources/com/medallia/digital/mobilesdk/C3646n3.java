package com.medallia.digital.mobilesdk;

import android.os.Build;
import androidx.annotation.NonNull;
import com.medallia.digital.mobilesdk.C3674q0;
import com.medallia.digital.mobilesdk.C3815z4;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.n3 */
class C3646n3 implements C3713r5 {

    /* renamed from: n */
    private static final String f1560n = "tre-version";

    /* renamed from: o */
    private static final String f1561o = "deviceModel";

    /* renamed from: p */
    private static final String f1562p = "osVersion";

    /* renamed from: q */
    private static final String f1563q = "sdkVersion";

    /* renamed from: r */
    private static final String f1564r = "osType";

    /* renamed from: s */
    private static final String f1565s = "deviceVendor";

    /* renamed from: t */
    private static C3646n3 f1566t;

    /* renamed from: a */
    private C3667p4 f1567a = new C3667p4(this.f1569c, this.f1568b);

    /* renamed from: b */
    private int f1568b;

    /* renamed from: c */
    private int f1569c;

    /* renamed from: d */
    private String f1570d;

    /* renamed from: e */
    private String f1571e;

    /* renamed from: f */
    private String f1572f;

    /* renamed from: g */
    private long f1573g;

    /* renamed from: h */
    private long f1574h;

    /* renamed from: i */
    private C3509f f1575i = new C3509f(C3815z4.m2010d().mo55979a(C3815z4.C3816a.PREVIOUS_ANALYTICS_V2, false), C3815z4.m2010d().mo55979a(C3815z4.C3816a.PREVIOUS_SEND_USER_JOURNEY, false));

    /* renamed from: j */
    private C3454c f1576j;

    /* renamed from: k */
    private Boolean f1577k;

    /* renamed from: l */
    private int f1578l;

    /* renamed from: m */
    private int f1579m;

    /* renamed from: com.medallia.digital.mobilesdk.n3$a */
    class C3647a implements C3674q0.C3676b {

        /* renamed from: a */
        final /* synthetic */ HashMap f1580a;

        C3647a(HashMap hashMap) {
            this.f1580a = hashMap;
        }

        /* renamed from: a */
        public C3592k0 mo55681a() {
            return new C3592k0(C3604l2.m1115c().mo55534a().mo55173c(), (HashMap<String, String>) null, this.f1580a, (JSONObject) null);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.n3$b */
    enum C3648b {
        API_TOKEN,
        ACCESS_TOKEN
    }

    private C3646n3() {
    }

    /* renamed from: a */
    private void m1335a(MedalliaDigitalClientConfigurationContract medalliaDigitalClientConfigurationContract) {
        if (medalliaDigitalClientConfigurationContract == null) {
            C3490e3.m666f("MedalliaDigitalClientConfigurationContract is null");
            return;
        }
        if (medalliaDigitalClientConfigurationContract.getHttpRequestTimeout() != null) {
            this.f1568b = medalliaDigitalClientConfigurationContract.getHttpRequestTimeout().intValue();
        }
        if (medalliaDigitalClientConfigurationContract.getMaxHttpRequestRetryAttempts() != null) {
            this.f1569c = medalliaDigitalClientConfigurationContract.getMaxHttpRequestRetryAttempts().intValue();
        }
        boolean z = true;
        if (!(medalliaDigitalClientConfigurationContract.getSubmitUrlPrefix() == null || medalliaDigitalClientConfigurationContract.getSubmitUrlSuffix() == null)) {
            this.f1570d = String.format("%s%s", new Object[]{medalliaDigitalClientConfigurationContract.getSubmitUrlPrefix(), medalliaDigitalClientConfigurationContract.getSubmitUrlSuffix()});
        }
        this.f1577k = medalliaDigitalClientConfigurationContract.isAnalyticsEnabled();
        Boolean bool = this.f1577k;
        if (bool != null) {
            z = bool.booleanValue();
        }
        this.f1577k = Boolean.valueOf(z);
        C3454c cVar = null;
        this.f1571e = this.f1577k.booleanValue() ? medalliaDigitalClientConfigurationContract.getAnalyticsEndPoint() : null;
        if (this.f1577k.booleanValue() && medalliaDigitalClientConfigurationContract.getAnalyticsV2ConfigurationContract() != null) {
            cVar = medalliaDigitalClientConfigurationContract.getAnalyticsV2ConfigurationContract().mo55363a();
        }
        this.f1576j = cVar;
        if (medalliaDigitalClientConfigurationContract.getAnalyticsV2ConfigurationContract() != null) {
            this.f1575i = medalliaDigitalClientConfigurationContract.getAnalyticsV2ConfigurationContract();
            C3815z4.m2010d().mo55985b(C3815z4.C3816a.PREVIOUS_ANALYTICS_V2, this.f1575i.mo55366d());
            C3815z4.m2010d().mo55985b(C3815z4.C3816a.PREVIOUS_SEND_USER_JOURNEY, this.f1575i.mo55367e());
        }
        C3490e3.m661b("MedalliaDigitalClientConfiguration updated");
    }

    /* renamed from: l */
    private HashMap<String, String> m1336l() {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("sdkVersion", URLEncoder.encode(BuildConfig.VERSION_NAME, "UTF-8"));
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        try {
            hashMap.put(f1564r, URLEncoder.encode("android", "UTF-8"));
        } catch (Exception e2) {
            C3490e3.m663c(e2.getMessage());
        }
        return hashMap;
    }

    /* renamed from: m */
    protected static C3646n3 m1337m() {
        if (f1566t == null) {
            f1566t = new C3646n3();
        }
        return f1566t;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo55660a() {
        return this.f1573g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55661a(int i, int i2, long j, long j2, int i3, int i4) {
        C3490e3.m661b(m1337m().getClass().getSimpleName() + " initialized");
        mo55662a(i, i2, (String) null, j, j2, i3, i4);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55662a(int i, int i2, String str, long j, long j2, int i3, int i4) {
        this.f1568b = i;
        this.f1569c = i2;
        this.f1570d = str;
        this.f1572f = C3815z4.m2010d().mo55975a(C3815z4.C3816a.UUID_URL, (String) null);
        this.f1574h = j;
        this.f1573g = j2;
        this.f1578l = i3;
        this.f1579m = i4;
        C3667p4 p4Var = this.f1567a;
        if (p4Var != null) {
            p4Var.mo55695a(i2, i, j);
        }
        C3490e3.m661b("MedalliaDigitalClient updated configuration");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55663a(ConfigurationContract configurationContract) {
        if (configurationContract != null && configurationContract.getSdkConfiguration() != null && configurationContract.getSdkConfiguration().getMedalliaDigitalBrain() != null && configurationContract.getSdkConfiguration().getMedalliaDigitalClientConfig() != null) {
            this.f1574h = (configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().getSessionInactivityTime() == null || configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().getSessionInactivityTime().longValue() <= 0) ? 60000 : configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().getSessionInactivityTime().longValue();
            MedalliaDigitalClientConfigurationContract medalliaDigitalClientConfig = configurationContract.getSdkConfiguration().getMedalliaDigitalClientConfig();
            if (medalliaDigitalClientConfig.getHttpRequestTimeout() != null) {
                this.f1568b = medalliaDigitalClientConfig.getHttpRequestTimeout().intValue();
            }
            if (medalliaDigitalClientConfig.getMaxHttpRequestRetryAttempts() != null) {
                this.f1569c = medalliaDigitalClientConfig.getMaxHttpRequestRetryAttempts().intValue();
            }
            if (!(medalliaDigitalClientConfig.getSubmitUrlPrefix() == null || medalliaDigitalClientConfig.getSubmitUrlSuffix() == null)) {
                this.f1570d = String.format("%s%s", new Object[]{medalliaDigitalClientConfig.getSubmitUrlPrefix(), medalliaDigitalClientConfig.getSubmitUrlSuffix()});
            }
            if (configurationContract.getConfigurationUUID() != null) {
                this.f1572f = configurationContract.getConfigurationUUID().getUrl();
            }
            this.f1573g = medalliaDigitalClientConfig.getAccessTokenValidationBufferTime();
            if (!(medalliaDigitalClientConfig.getAnalyticsV2ConfigurationContract() == null || medalliaDigitalClientConfig.getAnalyticsV2ConfigurationContract().mo55364b() == null)) {
                this.f1578l = medalliaDigitalClientConfig.getAnalyticsV2ConfigurationContract().mo55364b().intValue();
            }
            if (!(medalliaDigitalClientConfig.getAnalyticsV2ConfigurationContract() == null || medalliaDigitalClientConfig.getAnalyticsV2ConfigurationContract().mo55365c() == null)) {
                this.f1579m = medalliaDigitalClientConfig.getAnalyticsV2ConfigurationContract().mo55365c().intValue();
            }
            mo55662a(this.f1568b, this.f1569c, this.f1570d, this.f1574h, this.f1573g, this.f1578l, this.f1579m);
            m1335a(medalliaDigitalClientConfig);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55664a(@NonNull C3660o4<Void> o4Var, JSONObject jSONObject) {
        Boolean bool = this.f1577k;
        if (bool != null && bool.booleanValue()) {
            new C3451b5(this.f1567a, new C3592k0(this.f1571e, (HashMap<String, String>) null, m1336l(), (JSONObject) null), jSONObject, o4Var).mo55497c();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55665a(C3667p4 p4Var) {
        this.f1567a = p4Var;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55666a(C3731t1 t1Var, @NonNull C3660o4<Void> o4Var) {
        C3490e3.m661b("Submit Feedback called");
        new C3471c5(this.f1567a, new C3592k0(this.f1570d, (HashMap<String, String>) null, m1336l(), (JSONObject) null), t1Var, o4Var).mo55497c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55667a(String str, @NonNull C3660o4<ConfigurationContract> o4Var) {
        C3490e3.m661b("getConfiguration called");
        HashMap hashMap = new HashMap();
        try {
            hashMap.put(f1560n, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            C3490e3.m663c(e.getMessage());
        }
        String str2 = Build.MANUFACTURER;
        if (str2 != null) {
            try {
                hashMap.put(f1565s, URLEncoder.encode(str2, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                C3490e3.m663c(e2.getMessage());
            }
        }
        String str3 = Build.MODEL;
        if (str3 != null) {
            try {
                hashMap.put(f1561o, URLEncoder.encode(str3, "UTF-8"));
            } catch (Exception e3) {
                C3490e3.m663c(e3.getMessage());
            }
        }
        String str4 = Build.VERSION.RELEASE;
        if (str4 != null) {
            try {
                hashMap.put(f1562p, URLEncoder.encode(str4, "UTF-8"));
            } catch (Exception e4) {
                C3490e3.m663c(e4.getMessage());
            }
        }
        try {
            hashMap.put("sdkVersion", URLEncoder.encode(BuildConfig.VERSION_NAME, "UTF-8"));
        } catch (Exception e5) {
            C3490e3.m663c(e5.getMessage());
        }
        hashMap.putAll(m1336l());
        new C3674q0(this.f1567a, new C3592k0(this.f1572f, (HashMap<String, String>) null, m1336l(), (JSONObject) null), new C3647a(hashMap), o4Var).mo55497c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55668a(String str, String str2, @NonNull C3660o4<File> o4Var) {
        mo55669a(false, str, str2, o4Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55669a(boolean z, String str, String str2, @NonNull C3660o4<File> o4Var) {
        new C3584j2(this.f1567a, new C3592k0(str), str2, o4Var, z).mo55497c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo55670b() {
        return this.f1571e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55671b(@NonNull C3660o4<Void> o4Var, JSONObject jSONObject) {
        Boolean bool = this.f1577k;
        if (bool != null && bool.booleanValue()) {
            new C3451b5(this.f1567a, new C3592k0(this.f1576j.mo55245c(), this.f1576j.mo55243a(), this.f1576j.mo55244b()), jSONObject, o4Var, true).mo55497c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C3509f mo55672c() {
        return this.f1575i;
    }

    public void clearAndDisconnect() {
        C3490e3.m659a(C3646n3.class.getSimpleName());
        this.f1567a = null;
        f1566t = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo55673d() {
        return this.f1578l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo55674e() {
        return this.f1579m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo55675f() {
        return this.f1569c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public long mo55676g() {
        return this.f1574h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C3667p4 mo55677h() {
        return this.f1567a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public String mo55678i() {
        return this.f1570d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public int mo55679j() {
        return this.f1568b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public String mo55680k() {
        return this.f1572f;
    }
}
