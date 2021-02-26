package com.medallia.digital.mobilesdk;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.c */
class C3454c {

    /* renamed from: a */
    private String f938a;

    /* renamed from: b */
    private String f939b;

    /* renamed from: c */
    private HashMap<String, String> f940c;

    C3454c(JSONObject jSONObject) {
        try {
            if (jSONObject.has("url") && !jSONObject.isNull("url")) {
                this.f938a = jSONObject.getString("url");
            }
            if (jSONObject.has("requestType") && !jSONObject.isNull("requestType")) {
                this.f939b = jSONObject.getString("requestType");
            }
            if (jSONObject.has("headers") && !jSONObject.isNull("headers")) {
                this.f940c = ModelFactory.getInstance().getStringMap(jSONObject.getJSONObject("headers"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public HashMap<String, String> mo55243a() {
        return this.f940c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo55244b() {
        return this.f939b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo55245c() {
        return this.f938a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo55246d() {
        try {
            return "{\"url\":" + C3770w2.m1830b(this.f938a) + ",\"requestType\":" + C3770w2.m1830b(this.f939b) + ",\"headers\":" + ModelFactory.getInstance().getStringMapAsJsonString(this.f940c) + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
