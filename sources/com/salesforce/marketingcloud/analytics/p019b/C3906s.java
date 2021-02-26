package com.salesforce.marketingcloud.analytics.p019b;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import com.google.android.gms.appinvite.PreviewActivity;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.analytics.C3910d;
import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.RegionMessageManager;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.p021c.C3944d;
import com.salesforce.marketingcloud.p021c.C3946e;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.analytics.b.s */
abstract class C3906s {

    /* renamed from: a */
    static final String f2355a = "api_key";

    /* renamed from: b */
    static final String f2356b = "app_id";

    /* renamed from: c */
    static final String f2357c = "app_name";

    /* renamed from: d */
    static final String f2358d = "user_info";

    /* renamed from: e */
    static final String f2359e = "payload";

    /* renamed from: f */
    static final String f2360f = "849f26e2-2df6-11e4-ab12-14109fdc48df";

    /* renamed from: i */
    private static final Map<String, String> f2361i = Collections.unmodifiableMap(new ArrayMap() {
        {
            put("Content-Type", "application/json; charset=utf-8");
            put("Connection", PreviewActivity.ON_CLICK_LISTENER_CLOSE);
        }
    });

    /* renamed from: j */
    private static final String f2362j = "device";

    /* renamed from: k */
    private static final String f2363k = C4039h.m2810a((Class<?>) C3906s.class);

    /* renamed from: l */
    private static final String f2364l = "details";

    /* renamed from: m */
    private static final String f2365m = "manufacturer";

    /* renamed from: n */
    private static final String f2366n = "device_id";

    /* renamed from: o */
    private static final String f2367o = "push_enabled";

    /* renamed from: p */
    private static final String f2368p = "location";

    /* renamed from: q */
    private static final String f2369q = "latitude";

    /* renamed from: r */
    private static final String f2370r = "longitude";

    /* renamed from: s */
    private static final String f2371s = "platform";

    /* renamed from: t */
    private static final String f2372t = "platform_version";

    /* renamed from: u */
    private static final String f2373u = "device_type";

    /* renamed from: v */
    private static final String f2374v = "email";

    /* renamed from: g */
    final C4016h f2375g;

    /* renamed from: h */
    final MarketingCloudConfig f2376h;

    C3906s(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull C4016h hVar) {
        this.f2376h = marketingCloudConfig;
        this.f2375g = hVar;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public C3946e mo56301a(@NonNull RegistrationManager registrationManager, @NonNull PushMessageManager pushMessageManager, @NonNull RegionMessageManager regionMessageManager, @NonNull List<C3910d> list) {
        return C3944d.PI_ANALYTICS.mo56406a(this.f2376h, mo56292a(), mo56302a(mo56291a(mo56305a(registrationManager, pushMessageManager, regionMessageManager)), list), f2361i);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public String mo56302a(JSONObject jSONObject, List<C3910d> list) {
        JSONObject optJSONObject = jSONObject.optJSONObject(f2359e);
        String str = "{}";
        if (optJSONObject != null) {
            JSONArray jSONArray = new JSONArray();
            for (C3910d next : list) {
                try {
                    if (next.mo56318h() != null) {
                        jSONArray.put(new JSONObject(next.mo56318h()));
                    }
                } catch (Exception e) {
                    C4039h.m2830e(f2363k, e, "Failed to add the PI AnalyticItem Event to the event list.", new Object[0]);
                }
            }
            if (jSONArray.length() > 0) {
                try {
                    optJSONObject.put("events", jSONArray);
                    str = jSONObject.toString();
                } catch (Exception e2) {
                    C4039h.m2830e(f2363k, e2, "Failed to add the PI AnalyticItem Events to the payload.", new Object[0]);
                }
                optJSONObject.remove("events");
            }
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    /* renamed from: a */
    public JSONObject mo56303a(@NonNull RegionMessageManager regionMessageManager) {
        LatLon a;
        if ((!regionMessageManager.isGeofenceMessagingEnabled() && !regionMessageManager.isProximityMessagingEnabled()) || (a = this.f2375g.mo56536h().mo56484a(this.f2375g.mo56524a())) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("latitude", a.latitude());
        jSONObject.put("longitude", a.longitude());
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @NonNull
    /* renamed from: a */
    public JSONObject mo56304a(@NonNull PushMessageManager pushMessageManager) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("push_enabled", pushMessageManager.isPushEnabled());
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public JSONObject mo56305a(@NonNull RegistrationManager registrationManager, @NonNull PushMessageManager pushMessageManager, @NonNull RegionMessageManager regionMessageManager) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", registrationManager.getDeviceId());
            String contactKey = registrationManager.getContactKey();
            if (!TextUtils.isEmpty(contactKey)) {
                jSONObject.put("email", contactKey);
            }
            jSONObject.put("details", mo56304a(pushMessageManager));
            JSONObject a = mo56303a(regionMessageManager);
            if (a != null) {
                jSONObject.put("location", a);
            }
            jSONObject.put(f2362j, mo56306b());
        } catch (JSONException e) {
            C4039h.m2830e(f2363k, e, "Could not create our User Info object.", new Object[0]);
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public abstract JSONObject mo56291a(@NonNull JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public abstract Object[] mo56292a();

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: b */
    public JSONObject mo56306b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f2365m, Build.MANUFACTURER);
        jSONObject.put("platform", "Android");
        jSONObject.put("platform_version", Build.VERSION.RELEASE);
        jSONObject.put(f2373u, Build.MODEL);
        return jSONObject;
    }
}
