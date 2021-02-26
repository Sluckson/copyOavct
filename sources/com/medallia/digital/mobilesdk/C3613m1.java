package com.medallia.digital.mobilesdk;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.m1 */
class C3613m1 {

    /* renamed from: a */
    private String f1435a;

    /* renamed from: b */
    private boolean f1436b;

    /* renamed from: c */
    private ArrayList<String> f1437c;

    C3613m1(JSONObject jSONObject) {
        try {
            if (jSONObject.has("eventName") && !jSONObject.isNull("eventName")) {
                this.f1435a = jSONObject.getString("eventName");
            }
            if (jSONObject.has("analyticsEnabled") && !jSONObject.isNull("analyticsEnabled")) {
                this.f1436b = jSONObject.getBoolean("analyticsEnabled");
            }
            if (jSONObject.has("extraData") && !jSONObject.isNull("extraData") && (jSONObject.get("extraData") instanceof JSONArray)) {
                this.f1437c = ModelFactory.getInstance().getStringArray(jSONObject.getJSONArray("extraData"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo55557a() {
        return this.f1435a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public ArrayList<String> mo55558b() {
        return this.f1437c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo55559c() {
        return this.f1436b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo55560d() {
        try {
            return "{\"eventName\":" + C3770w2.m1830b(this.f1435a) + ",\"analyticsEnabled\":" + this.f1436b + ",\"extraData\":" + ModelFactory.getInstance().getStringArrayAsJsonString(this.f1437c) + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
