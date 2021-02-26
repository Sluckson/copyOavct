package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

class Component {

    /* renamed from: id */
    private String f836id;
    private boolean isCsat;
    private String role;
    private String type;
    private String uniqueName;
    private String value;

    protected Component() {
    }

    protected Component(String str, String str2, String str3, String str4, boolean z, String str5) {
        this.f836id = str;
        this.uniqueName = str2;
        this.type = str3;
        this.value = str4;
        this.isCsat = z;
        this.role = str5;
    }

    protected Component(JSONObject jSONObject) {
        try {
            if (jSONObject.has("id") && !jSONObject.isNull("id")) {
                this.f836id = jSONObject.getString("id");
            }
            if (jSONObject.has("uniqueName") && !jSONObject.isNull("uniqueName")) {
                this.uniqueName = jSONObject.getString("uniqueName");
            }
            if (jSONObject.has("type") && !jSONObject.isNull("type")) {
                this.type = jSONObject.getString("type");
            }
            if (jSONObject.has("value") && !jSONObject.isNull("value")) {
                this.value = jSONObject.getString("value");
            }
            if (jSONObject.has("isCsat") && !jSONObject.isNull("isCsat")) {
                this.isCsat = jSONObject.getBoolean("isCsat");
            }
            if (jSONObject.has("role") && !jSONObject.isNull("role")) {
                this.role = jSONObject.getString("role");
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public String getId() {
        return this.f836id;
    }

    /* access modifiers changed from: protected */
    public String getRole() {
        return this.role;
    }

    /* access modifiers changed from: protected */
    public String getType() {
        return this.type;
    }

    /* access modifiers changed from: protected */
    public String getUniqueName() {
        return this.uniqueName;
    }

    /* access modifiers changed from: protected */
    public String getValue() {
        return this.value;
    }

    /* access modifiers changed from: protected */
    public boolean isCsat() {
        return this.isCsat;
    }

    /* access modifiers changed from: protected */
    public void setCsat(boolean z) {
        this.isCsat = z;
    }

    /* access modifiers changed from: protected */
    public void setId(String str) {
        this.f836id = str;
    }

    /* access modifiers changed from: protected */
    public void setRole(String str) {
        this.role = str;
    }

    /* access modifiers changed from: protected */
    public void setType(String str) {
        this.type = str;
    }

    /* access modifiers changed from: protected */
    public void setUniqueName(String str) {
        this.uniqueName = str;
    }

    /* access modifiers changed from: protected */
    public void setValue(String str) {
        this.value = str;
    }
}
