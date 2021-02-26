package com.salesforce.marketingcloud.p021c;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.p021c.C3946e;
import com.salesforce.marketingcloud.p027e.C4029h;
import com.salesforce.marketingcloud.p027e.C4036i;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.c.d */
public enum C3944d {
    ET_ANALYTICS("POST", 1, "/device/v1/event/analytic", "application/json", "application/json", "et_etanalytic_route_retry_after_time_in_millis"),
    PI_ANALYTICS("POST", 2, "{0}", "application/json", "application/json", "et_piwama_route_retry_after_time_in_millis"),
    INBOX_MESSAGE("GET", 1, "/device/v1/{0}/message/?deviceid={1}&messagetype=8&contenttype=2", "application/json", "application/json", "et_cp_route_retry_after_time_in_millis"),
    INBOX_STATUS("PATCH", 1, "/device/v1/{0}/message", "application/json", "application/json", "et_ims_route_retry_after_time_in_millis"),
    GEOFENCE_MESSAGE("GET", 1, "/device/v1/location/{0}/fence/?latitude={1,number,#.########}&longitude={2,number,#.########}&deviceid={3}", "application/json", "application/json", "et_geofence_route_retry_after_time_in_millis"),
    PROXIMITY_MESSAGES("GET", 1, "/device/v1/location/{0}/proximity/?latitude={1,number,#.########}&longitude={2,number,#.########}&deviceid={3}", "application/json", "application/json", "et_proximity_route_retry_after_time_in_millis"),
    REGISTRATION("POST", 1, "/device/v1/registration", "application/json", "application/json", "et_registration_route_retry_after_time_in_millis"),
    SYNC("POST", 1, "/device/v1/{0}/sync/{1}", "application/json", "application/json", "et_sync_retry_after");
    

    /* renamed from: o */
    private static final String f2526o = "Bearer %s";

    /* renamed from: p */
    private static final String f2527p = null;

    /* renamed from: i */
    public final int f2529i;

    /* renamed from: j */
    public final String f2530j;

    /* renamed from: k */
    public final String f2531k;

    /* renamed from: l */
    public final String f2532l;

    /* renamed from: m */
    public final String f2533m;

    /* renamed from: n */
    public final String f2534n;

    /* renamed from: com.salesforce.marketingcloud.c.d$a */
    private static class C3945a {

        /* renamed from: a */
        static final int f2535a = 1;

        /* renamed from: b */
        static final int f2536b = 2;

        private C3945a() {
        }
    }

    static {
        f2527p = String.format(C4029h.f2926a, "MarketingCloudSdk/%s (Android %s; %%s; %s/%s) %%s/%%s", new Object[]{C4036i.m2803a(), Build.VERSION.RELEASE, Build.MANUFACTURER, Build.MODEL});
    }

    private C3944d(String str, int i, String str2, String str3, String str4, String str5) {
        this.f2534n = str;
        this.f2529i = i;
        this.f2530j = str2;
        this.f2532l = str3;
        this.f2533m = str4;
        this.f2531k = str5;
    }

    /* renamed from: a */
    private C3946e m2381a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Map<String, String> map) {
        try {
            String c = m2388c(str, str2);
            C4039h.m2817a("MCRequest", "Executing %s request ...", c);
            C3946e.C3947a d = C3946e.m2398i().mo56388a(this.f2534n).mo56387a(this).mo56394c(this.f2532l).mo56392b(str3).mo56395d(c);
            d.mo56412a("User-Agent", m2386b(marketingCloudConfig));
            d.mo56412a("Authorization", String.format(C4029h.f2926a, f2526o, new Object[]{marketingCloudConfig.accessToken()}));
            d.mo56412a("Accept", this.f2533m);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry next : map.entrySet()) {
                    d.mo56412a((String) next.getKey(), (String) next.getValue());
                }
            }
            return d.mo56413c();
        } catch (Exception e) {
            C4039h.m2830e("MCRequest", e, "Failed to execute request.", new Object[0]);
            return null;
        }
    }

    @NonNull
    /* renamed from: a */
    private String m2382a(@NonNull MarketingCloudConfig marketingCloudConfig) {
        return this.f2529i == 1 ? marketingCloudConfig.marketingCloudServerUrl() : marketingCloudConfig.predictiveIntelligenceServerUrl();
    }

    /* renamed from: a */
    public static Object[] m2383a(String str) {
        return new Object[]{str};
    }

    /* renamed from: a */
    public static Object[] m2384a(String str, String str2) {
        return new Object[]{str, str2};
    }

    /* renamed from: a */
    public static Object[] m2385a(String str, String str2, LatLon latLon) {
        return new Object[]{str, Double.valueOf(latLon.latitude()), Double.valueOf(latLon.longitude()), str2};
    }

    /* renamed from: b */
    private String m2386b(MarketingCloudConfig marketingCloudConfig) {
        return String.format(C4029h.f2926a, f2527p, new Object[]{Locale.getDefault(), marketingCloudConfig.appPackageName(), marketingCloudConfig.appVersionName()});
    }

    /* renamed from: b */
    public static Object[] m2387b(String str, String str2) {
        return new Object[]{str, str2};
    }

    /* renamed from: c */
    private String m2388c(String str, String str2) {
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        return new URL(String.format(C4029h.f2926a, "%s%s", new Object[]{str, str2})).toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo56402a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getLong(this.f2531k, 0);
    }

    /* renamed from: a */
    public C3946e mo56403a(@NonNull MarketingCloudConfig marketingCloudConfig, String str) {
        return m2381a(marketingCloudConfig, m2382a(marketingCloudConfig), this.f2530j, str, (Map<String, String>) null);
    }

    /* renamed from: a */
    public C3946e mo56404a(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull Object[] objArr) {
        return m2381a(marketingCloudConfig, m2382a(marketingCloudConfig), new MessageFormat(this.f2530j, C4029h.f2926a).format(objArr), (String) null, (Map<String, String>) null);
    }

    /* renamed from: a */
    public C3946e mo56405a(@NonNull MarketingCloudConfig marketingCloudConfig, Object[] objArr, String str) {
        return m2381a(marketingCloudConfig, m2382a(marketingCloudConfig), new MessageFormat(this.f2530j, C4029h.f2926a).format(objArr), str, (Map<String, String>) null);
    }

    /* renamed from: a */
    public C3946e mo56406a(@NonNull MarketingCloudConfig marketingCloudConfig, Object[] objArr, String str, Map<String, String> map) {
        return m2381a(marketingCloudConfig, m2382a(marketingCloudConfig), new MessageFormat(this.f2530j, C4029h.f2926a).format(objArr), str, map);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo56407a(@NonNull SharedPreferences sharedPreferences, @NonNull C3953g gVar) {
        List list;
        if (sharedPreferences != null && gVar != null && gVar.mo56365f() != null && (list = gVar.mo56365f().get("Retry-After")) != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if (TextUtils.isEmpty(str)) {
                C4039h.m2820b("MCRequest", "Expected a digits-only value for %s", str);
                return;
            }
            try {
                long parseLong = Long.parseLong(str) * 1000;
                if (parseLong > 86400000) {
                    parseLong = 86400000;
                }
                sharedPreferences.edit().putLong(this.f2531k, parseLong + gVar.mo56362d()).apply();
            } catch (Exception e) {
                C4039h.m2821b("MCRequest", e, "Unable to get retry after value.", new Object[0]);
            }
        }
    }
}
