package com.salesforce.marketingcloud.analytics.p019b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.analytics.PiCart;
import com.salesforce.marketingcloud.analytics.p019b.C3901p;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.analytics.b.j */
final class C3892j extends C3887e {

    /* renamed from: w */
    private static final C4029h.C4030a f2304w = new C4029h.C4030a();

    /* renamed from: x */
    private static final C3901p.C3902a f2305x = new C3901p.C3902a();

    C3892j(String str, Date date, PiCart piCart, String str2, double d, double d2) {
        super(str, date, piCart, str2, d, d2);
    }

    /* renamed from: a_ */
    public JSONObject mo56289a_() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("api_endpoint", mo56263a());
        } catch (JSONException unused) {
        }
        f2304w.mo56245a(jSONObject, "timestamp", mo56265c());
        f2305x.mo56245a(jSONObject, "cart", mo56283d());
        try {
            jSONObject.put("order_number", mo56282b_());
        } catch (JSONException unused2) {
        }
        try {
            jSONObject.put(FirebaseAnalytics.Param.SHIPPING, mo56285f());
        } catch (JSONException unused3) {
        }
        try {
            jSONObject.put(FirebaseAnalytics.Param.DISCOUNT, mo56286g());
        } catch (JSONException unused4) {
        }
        return jSONObject;
    }
}
