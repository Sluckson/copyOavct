package com.medallia.digital.mobilesdk;

import org.json.JSONObject;

abstract class EngagementContract extends C3455c0 {
    private InviteData inviteData;
    private String name;
    private JSONObject triggerData;

    EngagementContract() {
    }

    EngagementContract(String str, InviteData inviteData2, JSONObject jSONObject) {
        this.name = str;
        this.inviteData = inviteData2;
        this.triggerData = jSONObject;
    }

    EngagementContract(JSONObject jSONObject) {
        try {
            if (jSONObject.has("name") && !jSONObject.isNull("name")) {
                this.name = jSONObject.getString("name");
            }
            if (jSONObject.has("inviteData") && !jSONObject.isNull("inviteData")) {
                this.inviteData = new InviteData(jSONObject.getJSONObject("inviteData"));
            }
            if (jSONObject.has("triggerData") && !jSONObject.isNull("triggerData")) {
                this.triggerData = jSONObject.getJSONObject("triggerData");
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public InviteData getInviteData() {
        return this.inviteData;
    }

    /* access modifiers changed from: protected */
    public String getName() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    public JSONObject getTriggerData() {
        return this.triggerData;
    }
}
