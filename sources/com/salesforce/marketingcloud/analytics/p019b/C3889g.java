package com.salesforce.marketingcloud.analytics.p019b;

import com.salesforce.marketingcloud.analytics.p019b.C3896n;
import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import repack.org.bouncycastle.i18n.ErrorBundle;

/* renamed from: com.salesforce.marketingcloud.analytics.b.g */
final class C3889g extends C3884b {

    /* renamed from: w */
    private static final C4029h.C4030a f2299w = new C4029h.C4030a();

    /* renamed from: x */
    private static final C3896n.C3898b f2300x = new C3896n.C3898b();

    C3889g(String str, String str2, Date date, C3896n.C3897a aVar) {
        super(str, str2, date, aVar);
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
        f2299w.mo56245a(jSONObject, "timestamp", mo56265c());
        f2300x.mo56245a(jSONObject, ErrorBundle.DETAIL_ENTRY, mo56269d());
        return jSONObject;
    }
}
