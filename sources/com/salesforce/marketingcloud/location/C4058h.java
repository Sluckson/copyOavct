package com.salesforce.marketingcloud.location;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.C4038g;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.p027e.C4024c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.location.h */
public abstract class C4058h extends C4038g {

    /* renamed from: a */
    public static final String f2986a = "NO_GPS_HARDWARE";

    /* renamed from: b */
    public static final String f2987b = "RECEIVER_NOT_DECLARED_IN_MANIFEST";

    /* renamed from: c */
    public static final int f2988c = -1;

    /* renamed from: d */
    protected static final String f2989d = C4039h.m2810a((Class<?>) C4058h.class);

    /* renamed from: e */
    protected static final String f2990e = "com.salesforce.marketingcloud.location.LOCATION_UPDATE";

    /* renamed from: f */
    protected static final String f2991f = "com.salesforce.marketingcloud.location.GEOFENCE_ERROR";

    /* renamed from: g */
    protected static final String f2992g = "com.salesforce.marketingcloud.location.GEOFENCE_EVENT";

    /* renamed from: h */
    protected static final String f2993h = "extra_location";

    /* renamed from: i */
    protected static final String f2994i = "extra_transition";

    /* renamed from: j */
    protected static final String f2995j = "extra_fence_ids";

    /* renamed from: k */
    protected static final String f2996k = "extra_error_code";

    /* renamed from: l */
    protected static final String f2997l = "extra_error_message";

    /* renamed from: m */
    private static final String f2998m = "LocationManager";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static Intent m2901a(int i, String str) {
        return new Intent(f2991f).putExtra(f2996k, i).putExtra(f2997l, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static Intent m2902a(int i, @NonNull List<String> list) {
        Intent intent = new Intent(f2992g);
        intent.putExtra(f2994i, i);
        if (list instanceof ArrayList) {
            intent.putStringArrayListExtra(f2995j, (ArrayList) list);
        } else {
            intent.putStringArrayListExtra(f2995j, new ArrayList(list));
        }
        return intent;
    }

    /* renamed from: a */
    public static Intent m2903a(@NonNull Location location) {
        return new Intent(f2990e).putExtra(f2993h, location);
    }

    /* renamed from: a */
    public static C4058h m2904a(Context context, MarketingCloudConfig marketingCloudConfig) {
        Boolean bool;
        boolean b = C4024c.m2754b();
        Exception exc = null;
        if (b) {
            bool = Boolean.valueOf(LocationReceiver.m2853a(context));
            if (bool.booleanValue() && (marketingCloudConfig.geofencingEnabled() || marketingCloudConfig.proximityEnabled())) {
                try {
                    return new C4060j(context, marketingCloudConfig);
                } catch (Exception e) {
                    exc = e;
                    C4039h.m2830e(f2989d, exc, "Unable to create real instance of %s", f2998m);
                }
            }
        } else {
            C4039h.m2826d(f2989d, "GooglePlayServices Location dependency missing from build.", new Object[0]);
            bool = null;
        }
        return new C4046c(marketingCloudConfig, bool, b, exc);
    }

    /* renamed from: a */
    static JSONObject m2905a(MarketingCloudConfig marketingCloudConfig, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = m2907a(jSONObject, marketingCloudConfig);
            jSONObject.put("apiCode", i);
            jSONObject.put("apiMessage", str);
            return jSONObject;
        } catch (Exception e) {
            C4039h.m2830e(f2989d, e, "Error creating LocationManager state.", new Object[0]);
            return jSONObject;
        }
    }

    /* renamed from: a */
    static JSONObject m2906a(MarketingCloudConfig marketingCloudConfig, Boolean bool, boolean z, Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = m2907a(jSONObject, marketingCloudConfig);
            jSONObject.put("serviceAvailable", bool);
            jSONObject.put("gmsLocationDependencyAvailable", z);
            if (exc != null) {
                jSONObject.put("exceptionMessage", exc.getMessage());
            }
        } catch (Exception e) {
            C4039h.m2830e(f2989d, e, "Error creating fake LocationManager state.", new Object[0]);
        }
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONObject m2907a(JSONObject jSONObject, MarketingCloudConfig marketingCloudConfig) {
        jSONObject.put("geofencingEnabled", marketingCloudConfig.geofencingEnabled());
        jSONObject.put("proximityEnabled", marketingCloudConfig.proximityEnabled());
        return jSONObject;
    }

    /* renamed from: a */
    public abstract void mo56571a(C4050e eVar);

    @RequiresPermission("android.permission.ACCESS_FINE_LOCATION")
    /* renamed from: a */
    public abstract void mo56572a(C4057g gVar);

    /* renamed from: a */
    public abstract void mo56573a(C4047d... dVarArr);

    /* renamed from: a */
    public abstract void mo56574a(String... strArr);

    @NonNull
    /* renamed from: b */
    public final String mo56210b() {
        return f2998m;
    }

    /* renamed from: b */
    public abstract void mo56575b(C4050e eVar);

    /* renamed from: b */
    public abstract void mo56576b(C4057g gVar);

    /* renamed from: c */
    public abstract void mo56577c();

    /* renamed from: d */
    public boolean mo56595d() {
        return false;
    }
}
