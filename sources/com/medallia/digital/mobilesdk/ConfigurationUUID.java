package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

class ConfigurationUUID {
    private String url;
    private String uuid;

    ConfigurationUUID(JSONObject jSONObject) {
        try {
            if (jSONObject.has("url")) {
                this.url = jSONObject.getString("url");
            }
            if (jSONObject.has("uuid")) {
                this.uuid = jSONObject.getString("uuid");
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
    public String getUuid() {
        return this.uuid;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            return "{\"url\":" + C3770w2.m1830b(this.url) + ",\"uuid\":" + C3770w2.m1830b(this.uuid) + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
