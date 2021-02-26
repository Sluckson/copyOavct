package com.salesforce.marketingcloud.analytics;

import com.salesforce.marketingcloud.analytics.PiCart;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.analytics.a */
abstract class C3878a extends C$$AutoValue_PiCart {

    /* renamed from: a */
    private static final PiCart.C3876a f2267a = new PiCart.C3876a();

    C3878a(List<PiCartItem> list) {
        super(list);
    }

    /* renamed from: a */
    public JSONObject mo56243a() {
        JSONObject jSONObject = new JSONObject();
        f2267a.mo56245a(jSONObject, "cart", cartItems());
        return jSONObject;
    }
}
