package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.r1 */
class C3701r1 {

    /* renamed from: a */
    private String f1783a;

    protected C3701r1(String str) {
        this.f1783a = str;
    }

    protected C3701r1(JSONObject jSONObject) {
        try {
            if (jSONObject.has("feedback") && !jSONObject.isNull("feedback")) {
                this.f1783a = jSONObject.getString("feedback");
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55767a() {
        return this.f1783a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55768a(String str) {
        this.f1783a = str;
    }
}
