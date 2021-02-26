package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

class KillStatus {
    private Boolean isKilled;
    private Long restorePollingInterval;
    private Boolean shouldCheckRestoreOnOsChange;

    KillStatus() {
    }

    KillStatus(Boolean bool, Long l, Boolean bool2) {
        this.isKilled = bool;
        this.restorePollingInterval = l;
        this.shouldCheckRestoreOnOsChange = bool2;
    }

    KillStatus(JSONObject jSONObject) {
        try {
            if (jSONObject.has("isKilled") && !jSONObject.isNull("isKilled")) {
                this.isKilled = Boolean.valueOf(jSONObject.getBoolean("isKilled"));
            }
            if (jSONObject.has("restorePollingInterval") && !jSONObject.isNull("restorePollingInterval")) {
                this.restorePollingInterval = Long.valueOf(jSONObject.getLong("restorePollingInterval"));
            }
            if (jSONObject.has("shouldCheckRestoreOnOsChange") && !jSONObject.isNull("shouldCheckRestoreOnOsChange")) {
                this.shouldCheckRestoreOnOsChange = Boolean.valueOf(jSONObject.getBoolean("shouldCheckRestoreOnOsChange"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public Long getRestorePollingInterval() {
        return this.restorePollingInterval;
    }

    /* access modifiers changed from: protected */
    public Boolean getShouldCheckRestoreOnOsChange() {
        return this.shouldCheckRestoreOnOsChange;
    }

    /* access modifiers changed from: protected */
    public Boolean isKilled() {
        return this.isKilled;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            return "{\"isKilled\":" + this.isKilled + ",\"restorePollingInterval\":" + this.restorePollingInterval + ",\"shouldCheckRestoreOnOsChange\":" + this.shouldCheckRestoreOnOsChange + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
