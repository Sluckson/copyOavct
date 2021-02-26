package com.salesforce.marketingcloud.messages.proximity;

import com.salesforce.marketingcloud.location.LatLon;
import com.salesforce.marketingcloud.messages.Region;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.messages.proximity.a */
final class C4097a extends C$AutoValue_ProximityMessageResponse {

    /* renamed from: a */
    private static final LatLon.C4043a f3221a = new LatLon.C4043a();

    /* renamed from: b */
    private static final Region.C4073c f3222b = new Region.C4073c();

    C4097a(LatLon latLon, int i, List<Region> list) {
        super(latLon, i, list);
    }

    /* renamed from: a */
    static C4097a m3188a(JSONObject jSONObject) {
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
                    if (hashCode != -234767185) {
                        if (hashCode == 2047441680 && next.equals("refreshCenter")) {
                            c = 0;
                        }
                    } else if (next.equals("beacons")) {
                        c = 2;
                    }
                } else if (next.equals("refreshRadius")) {
                    c = 1;
                }
                if (c == 0) {
                    latLon = f3221a.mo56247b(jSONObject, next);
                } else if (c == 1) {
                    i = jSONObject.getInt(next);
                } else if (c == 2) {
                    list = f3222b.mo56247b(jSONObject, next);
                }
            }
        }
        return new C4097a(latLon, i, list);
    }
}
