package com.medallia.digital.mobilesdk;

import org.json.JSONObject;

class EvaluationResult {
    private String engagementId;
    private MDEngagementType engagementType;
    private Long nextEvaluationTime;

    protected EvaluationResult(String str, Long l, MDEngagementType mDEngagementType) {
        this.engagementId = str;
        this.nextEvaluationTime = l;
        this.engagementType = mDEngagementType;
    }

    protected EvaluationResult(JSONObject jSONObject) {
        try {
            if (jSONObject.has("engagementId") && !jSONObject.isNull("engagementId")) {
                this.engagementId = jSONObject.getString("engagementId");
            }
            if (jSONObject.has("nextEvaluationTime") && !jSONObject.isNull("nextEvaluationTime")) {
                this.nextEvaluationTime = Long.valueOf(jSONObject.getLong("nextEvaluationTime"));
            }
            if (jSONObject.has("engagementType") && !jSONObject.isNull("engagementType")) {
                this.engagementType = MDEngagementType.fromString(jSONObject.getString("engagementType"));
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    public String getEngagementId() {
        return this.engagementId;
    }

    public MDEngagementType getEngagementType() {
        return this.engagementType;
    }

    /* access modifiers changed from: package-private */
    public Long getNextEvaluationTime() {
        return this.nextEvaluationTime;
    }
}
