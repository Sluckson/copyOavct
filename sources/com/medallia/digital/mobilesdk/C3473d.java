package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.d */
class C3473d {

    /* renamed from: a */
    private C3644n1 f975a;

    /* renamed from: b */
    private JSONObject f976b;

    /* renamed from: c */
    private JSONObject f977c;

    /* renamed from: d */
    private JSONObject f978d;

    C3473d(JSONObject jSONObject) {
        try {
            if (jSONObject.has("extraData") && !jSONObject.isNull("extraData")) {
                this.f976b = jSONObject.getJSONObject("extraData");
            }
            if (jSONObject.has("eventDynamicStructure") && !jSONObject.isNull("eventDynamicStructure")) {
                this.f977c = jSONObject.getJSONObject("eventDynamicStructure");
            }
            if (jSONObject.has("events") && !jSONObject.isNull("events")) {
                this.f975a = new C3644n1(jSONObject.getJSONObject("events"));
            }
            if (jSONObject.has("externalData") && !jSONObject.isNull("externalData")) {
                this.f978d = jSONObject.getJSONObject("externalData");
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo55292a() {
        return this.f977c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C3644n1 mo55293b() {
        return this.f975a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public JSONObject mo55294c() {
        return this.f978d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public JSONObject mo55295d() {
        return this.f976b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo55296e() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{\"events\":");
            String str = "null";
            sb.append(this.f975a == null ? str : this.f975a.mo55632V());
            sb.append(",\"extraData\":");
            sb.append(this.f976b == null ? str : this.f976b.toString());
            sb.append(",\"externalData\":");
            sb.append(this.f978d == null ? str : this.f978d.toString());
            sb.append(",\"eventDynamicStructure\":");
            if (this.f977c != null) {
                str = this.f977c.toString();
            }
            sb.append(str);
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
