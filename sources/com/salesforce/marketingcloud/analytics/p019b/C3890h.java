package com.salesforce.marketingcloud.analytics.p019b;

import com.salesforce.marketingcloud.p027e.C4029h;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.analytics.b.h */
final class C3890h extends C3885c {

    /* renamed from: a */
    private static final C4029h.C4034e f2301a = new C4029h.C4034e();

    C3890h(boolean z, List<String> list) {
        super(z, list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public JSONObject mo56290c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("open_from_push", mo56273a());
        } catch (JSONException unused) {
        }
        f2301a.mo56245a(jSONObject, "message_ids", mo56274b());
        return jSONObject;
    }
}
