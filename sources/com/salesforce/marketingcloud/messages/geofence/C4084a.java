package com.salesforce.marketingcloud.messages.geofence;

import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Region;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.messages.geofence.a */
final class C4084a extends C$AutoValue_GeofenceMessageResponse {

    /* renamed from: a */
    private static final LatLon.C4043a f3105a = new LatLon.C4043a();

    /* renamed from: b */
    private static final Region.C4073c f3106b = new Region.C4073c();

    C4084a(LatLon latLon, int i, List<Region> list) {
        super(latLon, i, list);
    }

    /* renamed from: a */
    static C4084a m3059a(JSONObject jSONObject) {
        List<Region> emptyList = Collections.emptyList();
        Iterator<String> keys = jSONObject.keys();
        LatLon latLon = null;
        List<Region> list = emptyList;
        int i = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject.isNull(next)) {
                char c = 65535;
                int hashCode = next.hashCode();
                if (hashCode != -1822090419) {
                    if (hashCode != -1278142878) {
                        if (hashCode == 2047441680 && next.equals("refreshCenter")) {
                            c = 0;
                        }
                    } else if (next.equals("fences")) {
                        c = 2;
                    }
                } else if (next.equals("refreshRadius")) {
                    c = 1;
                }
                if (c == 0) {
                    latLon = f3105a.mo56247b(jSONObject, next);
                } else if (c == 1) {
                    i = jSONObject.getInt(next);
                } else if (c == 2) {
                    list = f3106b.mo56247b(jSONObject, next);
                }
            }
        }
        return new C4084a(latLon, i, list);
    }
}
