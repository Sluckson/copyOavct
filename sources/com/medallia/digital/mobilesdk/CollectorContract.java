package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

class CollectorContract {
    private Boolean enabled;
    private Integer frequency;
    private Lifetime lifetime;

    protected CollectorContract(Boolean bool, Integer num, Lifetime lifetime2) {
        this.enabled = bool;
        this.frequency = num;
        this.lifetime = lifetime2;
    }

    CollectorContract(JSONObject jSONObject) {
        try {
            if (jSONObject.has("enabled") && !jSONObject.isNull("enabled")) {
                this.enabled = Boolean.valueOf(jSONObject.getBoolean("enabled"));
            }
            if (jSONObject.has("frequency") && !jSONObject.isNull("frequency")) {
                this.frequency = Integer.valueOf(jSONObject.getInt("frequency"));
            }
            if (jSONObject.has("lifetime") && !jSONObject.isNull("lifetime")) {
                this.lifetime = Lifetime.fromString(jSONObject.getString("lifetime"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public Integer getFrequency() {
        return this.frequency;
    }

    /* access modifiers changed from: protected */
    public Lifetime getLifetime() {
        return this.lifetime;
    }

    /* access modifiers changed from: protected */
    public Boolean isEnabled() {
        return this.enabled;
    }

    /* access modifiers changed from: protected */
    public CollectorContract setEnabled(boolean z) {
        this.enabled = Boolean.valueOf(z);
        return this;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        String str;
        String str2;
        try {
            if (this.lifetime == null) {
                str = "null";
            } else {
                str = "\"" + this.lifetime.toString() + "\"";
            }
            if (this.frequency == null) {
                str2 = "";
            } else {
                str2 = ",\"frequency\":" + this.frequency;
            }
            return "{\"enabled\":" + this.enabled + str2 + ",\"lifetime\":" + str + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
