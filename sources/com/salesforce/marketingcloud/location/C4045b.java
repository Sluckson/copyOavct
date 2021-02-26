package com.salesforce.marketingcloud.location;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.location.b */
final class C4045b extends C$AutoValue_LatLon {
    C4045b(double d, double d2) {
        super(d, d2);
    }

    /* renamed from: a */
    static C4045b m2861a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d2 = 0.0d;
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject.isNull(next)) {
                char c = 65535;
                int hashCode = next.hashCode();
                if (hashCode != -1439978388) {
                    if (hashCode == 137365935 && next.equals("longitude")) {
                        c = 1;
                    }
                } else if (next.equals("latitude")) {
                    c = 0;
                }
                if (c == 0) {
                    d = jSONObject.getDouble(next);
                } else if (c == 1) {
                    d2 = jSONObject.getDouble(next);
                }
            }
        }
        return new C4045b(d, d2);
    }
}
