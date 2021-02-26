package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.s1 */
class C3716s1 {

    /* renamed from: a */
    private String f1825a;

    /* renamed from: b */
    private DynamicData f1826b;

    protected C3716s1(JSONObject jSONObject) {
        try {
            if (jSONObject.has("uuid") && !jSONObject.isNull("uuid")) {
                this.f1825a = jSONObject.getString("uuid");
            }
            if (jSONObject.has("dynamicData") && !jSONObject.isNull("dynamicData")) {
                this.f1826b = new DynamicData(jSONObject.getJSONObject("dynamicData"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public DynamicData mo55794a() {
        return this.f1826b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55795a(String str) {
        this.f1825a = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo55796b() {
        return this.f1825a;
    }
}
