package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.f */
class C3509f {

    /* renamed from: a */
    private boolean f1100a;

    /* renamed from: b */
    private boolean f1101b;

    /* renamed from: c */
    private C3454c f1102c;

    /* renamed from: d */
    private Integer f1103d;

    /* renamed from: e */
    private Integer f1104e;

    C3509f(JSONObject jSONObject) {
        try {
            if (jSONObject.has("analyticsV2Enabled") && !jSONObject.isNull("analyticsV2Enabled")) {
                this.f1100a = jSONObject.getBoolean("analyticsV2Enabled");
            }
            if (jSONObject.has("sendUserJourneyEnabled") && !jSONObject.isNull("sendUserJourneyEnabled")) {
                this.f1101b = jSONObject.getBoolean("sendUserJourneyEnabled");
            }
            if (jSONObject.has("analyticsEndpointConfigurationContract") && !jSONObject.isNull("analyticsEndpointConfigurationContract")) {
                this.f1102c = new C3454c(jSONObject.getJSONObject("analyticsEndpointConfigurationContract"));
            }
            if (jSONObject.has("maxRecordsToSubmit") && !jSONObject.isNull("maxRecordsToSubmit")) {
                this.f1103d = Integer.valueOf(jSONObject.getInt("maxRecordsToSubmit"));
            }
            if (jSONObject.has("maxRecursiveSubmits") && !jSONObject.isNull("maxRecursiveSubmits")) {
                this.f1104e = Integer.valueOf(jSONObject.getInt("maxRecursiveSubmits"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    C3509f(boolean z, boolean z2) {
        this.f1100a = z;
        this.f1101b = z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3454c mo55363a() {
        return this.f1102c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Integer mo55364b() {
        return this.f1103d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Integer mo55365c() {
        return this.f1104e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo55366d() {
        return this.f1100a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo55367e() {
        return this.f1101b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo55368f() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{\"analyticsV2Enabled\":");
            sb.append(this.f1100a);
            sb.append(",\"sendUserJourneyEnabled\":");
            sb.append(this.f1101b);
            sb.append(",\"analyticsEndpointConfigurationContract\":");
            sb.append(this.f1102c == null ? "null" : this.f1102c.mo55246d());
            sb.append(",\"maxRecordsToSubmit\":");
            sb.append(this.f1103d);
            sb.append(",\"maxRecursiveSubmits\":");
            sb.append(this.f1104e);
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
