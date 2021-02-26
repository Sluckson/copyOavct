package com.salesforce.marketingcloud.analytics.p019b;

import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.analytics.C3910d;
import com.salesforce.marketingcloud.analytics.PiCart;
import com.salesforce.marketingcloud.analytics.PiCartItem;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p011io.sethclark.auto.value.json.JsonTypeAdapter;

@AutoValue
/* renamed from: com.salesforce.marketingcloud.analytics.b.o */
abstract class C3899o extends C3895m {
    /* access modifiers changed from: private */

    /* renamed from: w */
    public static final String f2333w = C4039h.m2810a((Class<?>) C3899o.class);

    /* renamed from: com.salesforce.marketingcloud.analytics.b.o$a */
    static class C3900a implements JsonTypeAdapter<List<PiCartItem>> {
        C3900a() {
        }

        /* renamed from: a */
        public List<PiCartItem> mo56247b(JSONObject jSONObject, String str) {
            return null;
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, List<PiCartItem> list) {
            try {
                if (!list.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (PiCartItem a : list) {
                        jSONArray.put(a.mo56248a());
                    }
                    jSONObject.put(str, jSONArray);
                    return;
                }
                jSONObject.put("clear_cart", true);
            } catch (JSONException e) {
                C4039h.m2830e(C3899o.f2333w, e, "Could not add the clear cart property.", new Object[0]);
            }
        }
    }

    C3899o() {
    }

    /* renamed from: a */
    public static C3899o m2228a(PiCart piCart, Date date) {
        return new C3891i("track_cart", date, piCart.cartItems());
    }

    /* renamed from: a_ */
    public abstract JSONObject mo56289a_();

    /* renamed from: b */
    public String mo56264b() {
        return "";
    }

    /* renamed from: d */
    public abstract List<PiCartItem> mo56278d();

    /* renamed from: e */
    public int mo56293e() {
        return C3910d.f2394p;
    }
}
