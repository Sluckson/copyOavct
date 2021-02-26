package com.salesforce.marketingcloud.analytics.p019b;

import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.analytics.b.f */
final class C3888f extends C3883a {

    /* renamed from: w */
    private static final C4029h.C4030a f2298w = new C4029h.C4030a();

    C3888f(String str, String str2, Date date) {
        super(str, str2, date);
    }

    /* renamed from: a_ */
    public JSONObject mo56289a_() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("api_endpoint", mo56263a());
        } catch (JSONException unused) {
        }
        try {
            jSONObject.put("event_name", mo56264b());
        } catch (JSONException unused2) {
        }
        f2298w.mo56245a(jSONObject, "timestamp", mo56265c());
        return jSONObject;
    }
}
