package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

class ConfigurationContract extends C3455c0 {
    ConfigurationUUID configurationUUID;
    KillStatus killStatus;
    PropertyConfigurationContract propertyConfiguration;
    SDKConfigurationContract sdkConfiguration;
    TargetRuleEngineContract targetRuleEngine;

    protected ConfigurationContract(PropertyConfigurationContract propertyConfigurationContract, ConfigurationUUID configurationUUID2, SDKConfigurationContract sDKConfigurationContract, TargetRuleEngineContract targetRuleEngineContract) {
        this.propertyConfiguration = propertyConfigurationContract;
        this.configurationUUID = configurationUUID2;
        this.sdkConfiguration = sDKConfigurationContract;
        this.targetRuleEngine = targetRuleEngineContract;
    }

    protected ConfigurationContract(PropertyConfigurationContract propertyConfigurationContract, ConfigurationUUID configurationUUID2, SDKConfigurationContract sDKConfigurationContract, TargetRuleEngineContract targetRuleEngineContract, KillStatus killStatus2) {
        this.propertyConfiguration = propertyConfigurationContract;
        this.configurationUUID = configurationUUID2;
        this.sdkConfiguration = sDKConfigurationContract;
        this.targetRuleEngine = targetRuleEngineContract;
        this.killStatus = killStatus2;
    }

    protected ConfigurationContract(PropertyConfigurationContract propertyConfigurationContract, SDKConfigurationContract sDKConfigurationContract, TargetRuleEngineContract targetRuleEngineContract) {
        this.propertyConfiguration = propertyConfigurationContract;
        this.sdkConfiguration = sDKConfigurationContract;
        this.targetRuleEngine = targetRuleEngineContract;
    }

    ConfigurationContract(JSONObject jSONObject) {
        try {
            if (jSONObject.has("propertyConfiguration") && !jSONObject.isNull("propertyConfiguration")) {
                this.propertyConfiguration = new PropertyConfigurationContract(jSONObject.getJSONObject("propertyConfiguration"));
            }
            if (jSONObject.has("configurationUUID") && !jSONObject.isNull("configurationUUID")) {
                this.configurationUUID = new ConfigurationUUID(jSONObject.getJSONObject("configurationUUID"));
            }
            if (jSONObject.has("sdkConfiguration") && !jSONObject.isNull("sdkConfiguration")) {
                this.sdkConfiguration = new SDKConfigurationContract(jSONObject.getJSONObject("sdkConfiguration"));
            }
            if (jSONObject.has("targetRuleEngine") && !jSONObject.isNull("targetRuleEngine")) {
                this.targetRuleEngine = new TargetRuleEngineContract(jSONObject.getJSONObject("targetRuleEngine"));
            }
            if (jSONObject.has("killConfiguration") && !jSONObject.isNull("killConfiguration")) {
                this.killStatus = new KillStatus(jSONObject.getJSONObject("killConfiguration"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public ConfigurationUUID getConfigurationUUID() {
        return this.configurationUUID;
    }

    /* access modifiers changed from: protected */
    public KillStatus getKillStatus() {
        return this.killStatus;
    }

    /* access modifiers changed from: protected */
    public PropertyConfigurationContract getPropertyConfiguration() {
        return this.propertyConfiguration;
    }

    /* access modifiers changed from: protected */
    public SDKConfigurationContract getSdkConfiguration() {
        return this.sdkConfiguration;
    }

    /* access modifiers changed from: protected */
    public TargetRuleEngineContract getTargetRuleEngine() {
        return this.targetRuleEngine;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{\"propertyConfiguration\":");
            String str = "null";
            sb.append(this.propertyConfiguration == null ? str : this.propertyConfiguration.toJsonString());
            sb.append(",\"configurationUUID\":");
            sb.append(this.configurationUUID == null ? str : this.configurationUUID.toJsonString());
            sb.append(",\"sdkConfiguration\":");
            sb.append(this.sdkConfiguration == null ? str : this.sdkConfiguration.toJsonString());
            sb.append(",\"targetRuleEngine\":");
            sb.append(this.targetRuleEngine == null ? str : this.targetRuleEngine.toJsonString());
            sb.append(",\"killConfiguration\":");
            if (this.killStatus != null) {
                str = this.killStatus.toJsonString();
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
