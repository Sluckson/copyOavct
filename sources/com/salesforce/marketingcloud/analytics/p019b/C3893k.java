package com.salesforce.marketingcloud.analytics.p019b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MarketingCloudConfig;
import com.salesforce.marketingcloud.p022d.C4007c;
import com.salesforce.marketingcloud.p022d.C4016h;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.salesforce.marketingcloud.analytics.b.k */
class C3893k extends C3906s {

    /* renamed from: i */
    private static final String f2306i = C4039h.m2810a((Class<?>) C3893k.class);

    /* renamed from: j */
    private static final Object[] f2307j = {""};

    C3893k(@NonNull MarketingCloudConfig marketingCloudConfig, @NonNull C4016h hVar) {
        super(marketingCloudConfig, hVar);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public JSONObject mo56291a(@NonNull JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("api_key", "849f26e2-2df6-11e4-ab12-14109fdc48df");
            jSONObject2.put("app_id", this.f2376h.applicationId());
            String b = this.f2375g.mo56531d().mo56523b(C4007c.f2880g, (String) null);
            if (!TextUtils.isEmpty(b)) {
                jSONObject2.put("user_id", b);
            }
            String b2 = this.f2375g.mo56531d().mo56523b(C4007c.f2879f, (String) null);
            if (!TextUtils.isEmpty(b2)) {
                jSONObject2.put("session_id", b2);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("app_name", this.f2376h.appPackageName());
            jSONObject3.put("user_info", jSONObject);
            jSONObject2.put("payload", jSONObject3);
            return jSONObject2;
        } catch (JSONException e) {
            C4039h.m2830e(f2306i, e, "Failed to construct PiWama payload JSON Object.", new Object[0]);
            return new JSONObject();
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public Object[] mo56292a() {
        return f2307j;
    }
}
