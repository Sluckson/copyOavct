package com.salesforce.marketingcloud.location;

import android.annotation.SuppressLint;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MCKeep;
import org.json.JSONException;
import org.json.JSONObject;
import p011io.sethclark.auto.value.json.JsonTypeAdapter;

@AutoValue
public abstract class LatLon {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f2958a = C4039h.m2810a((Class<?>) LatLon.class);

    @SuppressLint({"UnknownNullness"})
    /* renamed from: com.salesforce.marketingcloud.location.LatLon$a */
    public static class C4043a implements JsonTypeAdapter<LatLon> {
        /* renamed from: a */
        public final LatLon mo56247b(JSONObject jSONObject, String str) {
            try {
                return LatLon.m2845b(jSONObject.getJSONObject(str));
            } catch (JSONException e) {
                C4039h.m2830e(LatLon.f2958a, e, "Failed to read %s from json", str);
                return null;
            }
        }

        /* renamed from: a */
        public final void mo56245a(JSONObject jSONObject, String str, LatLon latLon) {
        }
    }

    @SuppressLint({"UnknownNullness"})
    /* renamed from: a */
    public static LatLon m2843a(double d, double d2) {
        return new C4045b(d, d2);
    }

    @SuppressLint({"UnknownNullness"})
    /* renamed from: b */
    public static LatLon m2845b(JSONObject jSONObject) {
        return C4045b.m2861a(jSONObject);
    }

    @MCKeep
    public abstract double latitude();

    @MCKeep
    public abstract double longitude();
}
