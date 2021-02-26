package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

class MedalliaDigitalBrainConfigurationContract extends C3455c0 {
    private boolean canBlockAfterOneSuccess;
    private boolean enableBannerForAccessibility;
    private boolean evaluateWithConfigurationFile;
    private Long formDisplayTimeout;
    private boolean isBlackBoxEnabled = true;
    private boolean isDistinct;
    private long maxUserJourneyEventsSize;
    private Long offlineConfigurationExpirationTime;
    private Long sessionInactivityTime;

    MedalliaDigitalBrainConfigurationContract(long j) {
        this.sessionInactivityTime = Long.valueOf(j);
    }

    MedalliaDigitalBrainConfigurationContract(long j, boolean z, boolean z2) {
        this.sessionInactivityTime = Long.valueOf(j);
        this.isDistinct = z;
        this.canBlockAfterOneSuccess = z2;
    }

    MedalliaDigitalBrainConfigurationContract(JSONObject jSONObject) {
        try {
            if (jSONObject.has("sessionInactivityTime") && !jSONObject.isNull("sessionInactivityTime")) {
                this.sessionInactivityTime = Long.valueOf(jSONObject.getLong("sessionInactivityTime"));
            }
            if (jSONObject.has("formDisplayTimeout") && !jSONObject.isNull("formDisplayTimeout")) {
                this.formDisplayTimeout = Long.valueOf(jSONObject.getLong("formDisplayTimeout"));
            }
            if (jSONObject.has("offlineConfigurationExpirationTime") && !jSONObject.isNull("offlineConfigurationExpirationTime")) {
                this.offlineConfigurationExpirationTime = Long.valueOf(jSONObject.getLong("offlineConfigurationExpirationTime"));
            }
            if (jSONObject.has("enableBannerForAccessibility") && !jSONObject.isNull("enableBannerForAccessibility")) {
                this.enableBannerForAccessibility = jSONObject.getBoolean("enableBannerForAccessibility");
            }
            if (jSONObject.has("isDistinct") && !jSONObject.isNull("isDistinct")) {
                this.isDistinct = jSONObject.getBoolean("isDistinct");
            }
            if (jSONObject.has("canBlockAfterOneSuccess") && !jSONObject.isNull("canBlockAfterOneSuccess")) {
                this.canBlockAfterOneSuccess = jSONObject.getBoolean("canBlockAfterOneSuccess");
            }
            if (jSONObject.has("maxUserJourneyEventsSize") && !jSONObject.isNull("maxUserJourneyEventsSize")) {
                this.maxUserJourneyEventsSize = jSONObject.getLong("maxUserJourneyEventsSize");
            }
            if (jSONObject.has("isBlackBoxEnabled") && !jSONObject.isNull("isBlackBoxEnabled")) {
                this.isBlackBoxEnabled = jSONObject.getBoolean("isBlackBoxEnabled");
            }
            if (jSONObject.has("evaluateWithConfigurationFile") && !jSONObject.isNull("evaluateWithConfigurationFile")) {
                this.evaluateWithConfigurationFile = jSONObject.getBoolean("evaluateWithConfigurationFile");
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public boolean getEnableBannerForAccessibility() {
        return this.enableBannerForAccessibility;
    }

    /* access modifiers changed from: protected */
    public Long getFormDisplayTimeout() {
        return this.formDisplayTimeout;
    }

    /* access modifiers changed from: protected */
    public long getMaxUserJourneyEventsSize() {
        return this.maxUserJourneyEventsSize;
    }

    /* access modifiers changed from: protected */
    public Long getOfflineConfigurationExpirationTime() {
        return this.offlineConfigurationExpirationTime;
    }

    /* access modifiers changed from: protected */
    public Long getSessionInactivityTime() {
        return this.sessionInactivityTime;
    }

    /* access modifiers changed from: protected */
    public boolean isBlackBoxEnabled() {
        return this.isBlackBoxEnabled;
    }

    /* access modifiers changed from: protected */
    public boolean isCanBlockAfterOneSuccess() {
        return this.canBlockAfterOneSuccess;
    }

    /* access modifiers changed from: protected */
    public boolean isDistinct() {
        return this.isDistinct;
    }

    /* access modifiers changed from: protected */
    public boolean isEvaluateWithConfigurationFile() {
        return this.evaluateWithConfigurationFile;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            return "{\"sessionInactivityTime\":" + this.sessionInactivityTime + ",\"formDisplayTimeout\":" + this.formDisplayTimeout + ",\"offlineConfigurationExpirationTime\":" + this.offlineConfigurationExpirationTime + ",\"enableBannerForAccessibility\":" + this.enableBannerForAccessibility + ",\"isDistinct\":" + this.isDistinct + ",\"canBlockAfterOneSuccess\":" + this.canBlockAfterOneSuccess + ",\"maxUserJourneyEventsSize\":" + this.maxUserJourneyEventsSize + ",\"isBlackBoxEnabled\":" + this.isBlackBoxEnabled + ",\"evaluateWithConfigurationFile\":" + this.evaluateWithConfigurationFile + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
