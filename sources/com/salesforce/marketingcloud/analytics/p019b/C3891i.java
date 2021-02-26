package com.salesforce.marketingcloud.analytics.p019b;

import com.salesforce.marketingcloud.analytics.PiCartItem;
import com.salesforce.marketingcloud.analytics.p019b.C3899o;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.analytics.b.i */
final class C3891i extends C3886d {

    /* renamed from: w */
    private static final C4029h.C4030a f2302w = new C4029h.C4030a();

    /* renamed from: x */
    private static final C3899o.C3900a f2303x = new C3899o.C3900a();

    C3891i(String str, Date date, List<PiCartItem> list) {
        super(str, date, list);
    }

    /* renamed from: a_ */
    public JSONObject mo56289a_() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("api_endpoint", mo56263a());
        } catch (JSONException unused) {
        }
        f2302w.mo56245a(jSONObject, "timestamp", mo56265c());
        f2303x.mo56245a(jSONObject, "cart", mo56278d());
        return jSONObject;
    }
}
