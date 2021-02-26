package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;
import p052cz.msebera.android.httpclient.cookie.ClientCookie;

class TargetRuleEngineContract extends C3455c0 {
    private String url;
    private String version;

    protected TargetRuleEngineContract(String str, String str2) {
        this.url = str;
        this.version = str2;
    }

    protected TargetRuleEngineContract(JSONObject jSONObject) {
        try {
            if (jSONObject.has("url") && !jSONObject.isNull("url")) {
                this.url = jSONObject.getString("url");
            }
            if (jSONObject.has(ClientCookie.VERSION_ATTR) && !jSONObject.isNull(ClientCookie.VERSION_ATTR)) {
                this.version = jSONObject.getString(ClientCookie.VERSION_ATTR);
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public String getUrl() {
        return this.url;
    }

    /* access modifiers changed from: protected */
    public String getVersion() {
        return this.version;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            return "{\"url\":" + C3770w2.m1830b(this.url) + ",\"version\":" + C3770w2.m1830b(this.version) + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
