package com.salesforce.marketingcloud.analytics.p019b;

import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.analytics.C3910d;
import com.salesforce.marketingcloud.analytics.PiCart;
import com.salesforce.marketingcloud.analytics.PiCartItem;
import com.salesforce.marketingcloud.analytics.PiOrder;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p011io.sethclark.auto.value.json.JsonTypeAdapter;

@AutoValue
/* renamed from: com.salesforce.marketingcloud.analytics.b.p */
abstract class C3901p extends C3895m {
    /* access modifiers changed from: private */

    /* renamed from: w */
    public static final String f2334w = C4039h.m2810a((Class<?>) C3901p.class);

    /* renamed from: com.salesforce.marketingcloud.analytics.b.p$a */
    static class C3902a implements JsonTypeAdapter<PiCart> {
        C3902a() {
        }

        /* renamed from: a */
        public PiCart mo56247b(JSONObject jSONObject, String str) {
            return null;
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, PiCart piCart) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (PiCartItem a : piCart.cartItems()) {
                    jSONArray.put(a.mo56248a());
                }
                jSONObject.put(str, jSONArray);
            } catch (JSONException e) {
                C4039h.m2830e(C3901p.f2334w, e, "Failed to all our PiCart to the PiTrackConversionEvent.", new Object[0]);
            }
        }
    }

    C3901p() {
    }

    /* renamed from: a */
    public static C3901p m2238a(PiOrder piOrder, Date date) {
        return new C3892j("track_conversion", date, piOrder.cart(), piOrder.orderNumber(), piOrder.shipping(), piOrder.discount());
    }

    /* renamed from: a_ */
    public abstract JSONObject mo56289a_();

    /* renamed from: b */
    public String mo56264b() {
        return "";
    }

    /* renamed from: b_ */
    public abstract String mo56282b_();

    /* renamed from: d */
    public abstract PiCart mo56283d();

    /* renamed from: e */
    public int mo56293e() {
        return C3910d.f2393o;
    }

    /* renamed from: f */
    public abstract double mo56285f();

    /* renamed from: g */
    public abstract double mo56286g();
}
