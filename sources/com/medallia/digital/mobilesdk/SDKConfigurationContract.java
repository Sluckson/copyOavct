package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

class SDKConfigurationContract extends C3455c0 {
    private CollectorsConfigurationContract collectorsConfigurations;
    private C3473d eventsConfigurations;
    private FormConfigurations formConfigurations;
    private MedalliaDigitalBrainConfigurationContract medalliaDigitalBrain;
    private MedalliaDigitalClientConfigurationContract medalliaDigitalClientConfig;

    SDKConfigurationContract(CollectorsConfigurationContract collectorsConfigurationContract, MedalliaDigitalClientConfigurationContract medalliaDigitalClientConfigurationContract, MedalliaDigitalBrainConfigurationContract medalliaDigitalBrainConfigurationContract) {
        this.collectorsConfigurations = collectorsConfigurationContract;
        this.medalliaDigitalClientConfig = medalliaDigitalClientConfigurationContract;
        this.medalliaDigitalBrain = medalliaDigitalBrainConfigurationContract;
    }

    SDKConfigurationContract(JSONObject jSONObject) {
        try {
            if (jSONObject.has("collectorsConfigurations") && !jSONObject.isNull("collectorsConfigurations")) {
                this.collectorsConfigurations = new CollectorsConfigurationContract(jSONObject.getJSONObject("collectorsConfigurations"));
            }
            if (jSONObject.has("medalliaDigitalClientConfig") && !jSONObject.isNull("medalliaDigitalClientConfig")) {
                this.medalliaDigitalClientConfig = new MedalliaDigitalClientConfigurationContract(jSONObject.getJSONObject("medalliaDigitalClientConfig"));
            }
            if (jSONObject.has("medalliaDigitalBrain") && !jSONObject.isNull("medalliaDigitalBrain")) {
                this.medalliaDigitalBrain = new MedalliaDigitalBrainConfigurationContract(jSONObject.getJSONObject("medalliaDigitalBrain"));
            }
            if (jSONObject.has("formConfigurations") && !jSONObject.isNull("formConfigurations")) {
                this.formConfigurations = new FormConfigurations(jSONObject.getJSONObject("formConfigurations"));
            }
            if (jSONObject.has("analyticsEventsConfigurationContract") && !jSONObject.isNull("analyticsEventsConfigurationContract")) {
                this.eventsConfigurations = new C3473d(jSONObject.getJSONObject("analyticsEventsConfigurationContract"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public CollectorsConfigurationContract getCollectorsConfigurations() {
        return this.collectorsConfigurations;
    }

    /* access modifiers changed from: package-private */
    public C3473d getEventsConfigurations() {
        return this.eventsConfigurations;
    }

    /* access modifiers changed from: protected */
    public FormConfigurations getFormConfigurations() {
        return this.formConfigurations;
    }

    /* access modifiers changed from: protected */
    public MedalliaDigitalBrainConfigurationContract getMedalliaDigitalBrain() {
        return this.medalliaDigitalBrain;
    }

    /* access modifiers changed from: protected */
    public MedalliaDigitalClientConfigurationContract getMedalliaDigitalClientConfig() {
        return this.medalliaDigitalClientConfig;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{\"collectorsConfigurations\":");
            String str = "null";
            sb.append(this.collectorsConfigurations == null ? str : this.collectorsConfigurations.toJsonString());
            sb.append(",\"medalliaDigitalClientConfig\":");
            sb.append(this.medalliaDigitalClientConfig == null ? str : this.medalliaDigitalClientConfig.toJsonString());
            sb.append(",\"medalliaDigitalBrain\":");
            sb.append(this.medalliaDigitalBrain == null ? str : this.medalliaDigitalBrain.toJsonString());
            sb.append(",\"formConfigurations\":");
            sb.append(this.formConfigurations == null ? str : this.formConfigurations.toJsonString());
            sb.append(",\"analyticsEventsConfigurationContract\":");
            if (this.eventsConfigurations != null) {
                str = this.eventsConfigurations.mo55296e();
            }
            sb.append(str);
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
