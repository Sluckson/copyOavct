package com.salesforce.marketingcloud.analytics;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.salesforce.marketingcloud.analytics.PiOrder;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.analytics.c */
abstract class C3909c extends C$$AutoValue_PiOrder {

    /* renamed from: a */
    private static final PiOrder.C3877a f2378a = new PiOrder.C3877a();

    C3909c(PiCart piCart, String str, double d, double d2) {
        super(piCart, str, d, d2);
    }

    /* renamed from: a */
    public JSONObject mo56249a() {
        JSONObject jSONObject = new JSONObject();
        f2378a.mo56245a(jSONObject, "cart", cart());
        try {
            jSONObject.put("order_number", orderNumber());
        } catch (JSONException unused) {
        }
        try {
            jSONObject.put(FirebaseAnalytics.Param.SHIPPING, shipping());
        } catch (JSONException unused2) {
        }
        try {
            jSONObject.put(FirebaseAnalytics.Param.DISCOUNT, discount());
        } catch (JSONException unused3) {
        }
        return jSONObject;
    }
}
