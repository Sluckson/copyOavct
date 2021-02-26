package com.medallia.digital.mobilesdk;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class AppRatingContract extends EngagementContract {
    private String appRatingId;
    private String appRatingUrl;
    private String customParams;

    AppRatingContract(String str, InviteData inviteData, JSONObject jSONObject, String str2, String str3, String str4) {
        super(str, inviteData, jSONObject);
        this.appRatingId = str2;
        this.appRatingUrl = str3;
        this.customParams = str4;
    }

    AppRatingContract(JSONObject jSONObject) {
        super(jSONObject);
        String str;
        try {
            if (jSONObject.has("appRatingId") && !jSONObject.isNull("appRatingId")) {
                this.appRatingId = jSONObject.getString("appRatingId");
            }
            if (jSONObject.has("appRatingUrl") && !jSONObject.isNull("appRatingUrl")) {
                this.appRatingUrl = jSONObject.getString("appRatingUrl");
            }
            if (jSONObject.has("customParams")) {
                if (jSONObject.get("customParams") instanceof JSONArray) {
                    str = jSONObject.getJSONArray("customParams").toString();
                } else if (jSONObject.get("customParams") instanceof JSONObject) {
                    str = jSONObject.getJSONObject("customParams").toString();
                } else if (jSONObject.get("customParams") instanceof String) {
                    str = C3770w2.m1828a(jSONObject.getString("customParams"));
                } else {
                    return;
                }
                this.customParams = str;
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public String getAppRatingId() {
        return this.appRatingId;
    }

    /* access modifiers changed from: protected */
    public String getAppRatingUrl() {
        return this.appRatingUrl;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{\"appRatingId\":");
            sb.append(C3770w2.m1830b(this.appRatingId));
            sb.append(",\"inviteData\":");
            String str = "null";
            sb.append(getInviteData() != null ? getInviteData().toJsonString() : str);
            sb.append(",\"triggerData\":");
            if (getTriggerData() != null) {
                str = getTriggerData().toString();
            }
            sb.append(str);
            sb.append(",\"appRatingUrl\":");
            sb.append(C3770w2.m1830b(this.appRatingUrl));
            sb.append(",\"customParams\":");
            sb.append(C3770w2.m1830b(this.customParams));
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
