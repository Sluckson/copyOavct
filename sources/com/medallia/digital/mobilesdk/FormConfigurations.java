package com.medallia.digital.mobilesdk;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class FormConfigurations {
    private ArrayList<String> feedbackPayloadTypes;
    private boolean inheritOrientation;
    private Long loadFormIndicatorDelay;
    private ArrayList<String> redirectLinks;
    private boolean vulnEnabled;

    protected FormConfigurations(Long l, ArrayList<String> arrayList) {
        this.loadFormIndicatorDelay = l;
        this.feedbackPayloadTypes = arrayList;
    }

    FormConfigurations(JSONObject jSONObject) {
        try {
            if (jSONObject.has("loadFormIndicatorDelay") && !jSONObject.isNull("loadFormIndicatorDelay")) {
                this.loadFormIndicatorDelay = Long.valueOf(jSONObject.getLong("loadFormIndicatorDelay"));
            }
            if (jSONObject.has("feedbackPayloadTypes") && !jSONObject.isNull("feedbackPayloadTypes")) {
                this.feedbackPayloadTypes = ModelFactory.getInstance().getStringArray(jSONObject.getJSONArray("feedbackPayloadTypes"));
            }
            if (jSONObject.has("vulnEnabled") && !jSONObject.isNull("vulnEnabled")) {
                this.vulnEnabled = jSONObject.getBoolean("vulnEnabled");
            }
            if (jSONObject.has("inheritOrientation") && !jSONObject.isNull("inheritOrientation")) {
                this.inheritOrientation = jSONObject.getBoolean("inheritOrientation");
            }
            if (jSONObject.has("redirectLinks") && !jSONObject.isNull("redirectLinks")) {
                this.redirectLinks = ModelFactory.getInstance().getStringArray(jSONObject.getJSONArray("redirectLinks"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public ArrayList<String> getFeedbackPayloadTypes() {
        return this.feedbackPayloadTypes;
    }

    /* access modifiers changed from: protected */
    public Long getLoadFormIndicatorDelay() {
        return this.loadFormIndicatorDelay;
    }

    /* access modifiers changed from: protected */
    public ArrayList<String> getRedirectLinks() {
        return this.redirectLinks;
    }

    /* access modifiers changed from: protected */
    public boolean isInheritOrientation() {
        return this.inheritOrientation;
    }

    /* access modifiers changed from: protected */
    public boolean isVulnEnabled() {
        return this.vulnEnabled;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        return "{\"loadFormIndicatorDelay\":" + this.loadFormIndicatorDelay + ",\"feedbackPayloadTypes\":" + ModelFactory.getInstance().getStringArrayAsJsonString(this.feedbackPayloadTypes) + ",\"vulnEnabled\":" + this.vulnEnabled + ",\"inheritOrientation\":" + this.inheritOrientation + ",\"redirectLinks\":" + ModelFactory.getInstance().getStringArrayAsJsonString(this.redirectLinks) + "}";
    }
}
