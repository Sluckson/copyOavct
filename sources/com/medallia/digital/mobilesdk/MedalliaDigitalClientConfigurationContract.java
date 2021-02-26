package com.medallia.digital.mobilesdk;

import org.json.JSONException;
import org.json.JSONObject;

class MedalliaDigitalClientConfigurationContract extends C3455c0 {
    private long accessTokenValidationBufferTime;
    private Boolean analyticsEnabled;
    private String analyticsEndPoint;
    private C3509f analyticsV2ConfigurationContract;
    private Boolean blockNetworkInForm;
    private String getConfigEndPoint;
    private Integer httpRequestTimeout;
    private Integer maxAuthRetryAttempts;
    private Integer maxHttpRequestRetryAttempts;
    private String submitUrlPrefix;
    private String submitUrlSuffix;

    MedalliaDigitalClientConfigurationContract(JSONObject jSONObject) {
        try {
            if (jSONObject.has("maxHttpRequestRetryAttempts") && !jSONObject.isNull("maxHttpRequestRetryAttempts")) {
                this.maxHttpRequestRetryAttempts = Integer.valueOf(jSONObject.getInt("maxHttpRequestRetryAttempts"));
            }
            if (jSONObject.has("maxAuthRetryAttempts") && !jSONObject.isNull("maxAuthRetryAttempts")) {
                this.maxAuthRetryAttempts = Integer.valueOf(jSONObject.getInt("maxAuthRetryAttempts"));
            }
            if (jSONObject.has("httpRequestTimeout") && !jSONObject.isNull("httpRequestTimeout")) {
                this.httpRequestTimeout = Integer.valueOf(jSONObject.getInt("httpRequestTimeout"));
            }
            if (jSONObject.has("getConfigEndPoint") && !jSONObject.isNull("getConfigEndPoint")) {
                this.getConfigEndPoint = jSONObject.getString("getConfigEndPoint");
            }
            if (jSONObject.has("submitUrlPrefix") && !jSONObject.isNull("submitUrlPrefix")) {
                this.submitUrlPrefix = jSONObject.getString("submitUrlPrefix");
            }
            if (jSONObject.has("submitUrlSuffix") && !jSONObject.isNull("submitUrlSuffix")) {
                this.submitUrlSuffix = jSONObject.getString("submitUrlSuffix");
            }
            if (jSONObject.has("blockNetworkInForm") && !jSONObject.isNull("blockNetworkInForm")) {
                this.blockNetworkInForm = Boolean.valueOf(jSONObject.getBoolean("blockNetworkInForm"));
            }
            if (jSONObject.has("analyticsEndPoint") && !jSONObject.isNull("analyticsEndPoint")) {
                this.analyticsEndPoint = jSONObject.getString("analyticsEndPoint");
            }
            if (jSONObject.has("analyticsEnabled") && !jSONObject.isNull("analyticsEnabled")) {
                this.analyticsEnabled = Boolean.valueOf(jSONObject.getBoolean("analyticsEnabled"));
            }
            if (jSONObject.has("accessTokenValidationBufferTime") && !jSONObject.isNull("accessTokenValidationBufferTime")) {
                this.accessTokenValidationBufferTime = jSONObject.getLong("accessTokenValidationBufferTime");
            }
            if (jSONObject.has("analyticsV2ConfigurationContract") && !jSONObject.isNull("analyticsV2ConfigurationContract")) {
                this.analyticsV2ConfigurationContract = new C3509f(jSONObject.getJSONObject("analyticsV2ConfigurationContract"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public long getAccessTokenValidationBufferTime() {
        return this.accessTokenValidationBufferTime;
    }

    /* access modifiers changed from: protected */
    public String getAnalyticsEndPoint() {
        return this.analyticsEndPoint;
    }

    /* access modifiers changed from: package-private */
    public C3509f getAnalyticsV2ConfigurationContract() {
        return this.analyticsV2ConfigurationContract;
    }

    /* access modifiers changed from: protected */
    public Boolean getBlockNetworkInForm() {
        return this.blockNetworkInForm;
    }

    /* access modifiers changed from: protected */
    public String getGetConfigEndPoint() {
        return this.getConfigEndPoint;
    }

    /* access modifiers changed from: protected */
    public Integer getHttpRequestTimeout() {
        return this.httpRequestTimeout;
    }

    /* access modifiers changed from: protected */
    public Integer getMaxAuthRetryAttempts() {
        return this.maxAuthRetryAttempts;
    }

    /* access modifiers changed from: protected */
    public Integer getMaxHttpRequestRetryAttempts() {
        return this.maxHttpRequestRetryAttempts;
    }

    /* access modifiers changed from: protected */
    public String getSubmitUrlPrefix() {
        return this.submitUrlPrefix;
    }

    /* access modifiers changed from: protected */
    public String getSubmitUrlSuffix() {
        return this.submitUrlSuffix;
    }

    public Boolean isAnalyticsEnabled() {
        return this.analyticsEnabled;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{\"maxHttpRequestRetryAttempts\":");
            sb.append(this.maxHttpRequestRetryAttempts);
            sb.append(",\"maxAuthRetryAttempts\":");
            sb.append(this.maxAuthRetryAttempts);
            sb.append(",\"httpRequestTimeout\":");
            sb.append(this.httpRequestTimeout);
            sb.append(",\"getConfigEndPoint\":");
            sb.append(C3770w2.m1830b(this.getConfigEndPoint));
            sb.append(",\"submitUrlPrefix\":");
            sb.append(C3770w2.m1830b(this.submitUrlPrefix));
            sb.append(",\"submitUrlSuffix\":");
            sb.append(C3770w2.m1830b(this.submitUrlSuffix));
            sb.append(",\"blockNetworkInForm\":");
            sb.append(this.blockNetworkInForm);
            sb.append(",\"analyticsEndPoint\":");
            sb.append(C3770w2.m1830b(this.analyticsEndPoint));
            sb.append(",\"analyticsEnabled\":");
            sb.append(this.analyticsEnabled);
            sb.append(",\"accessTokenValidationBufferTime\":");
            sb.append(this.accessTokenValidationBufferTime);
            sb.append(",\"analyticsV2ConfigurationContract\":");
            sb.append(this.analyticsV2ConfigurationContract == null ? "null" : this.analyticsV2ConfigurationContract.mo55368f());
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
