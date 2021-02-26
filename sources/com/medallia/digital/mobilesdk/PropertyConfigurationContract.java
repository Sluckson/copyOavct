package com.medallia.digital.mobilesdk;

import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class PropertyConfigurationContract extends C3455c0 {
    private List<AppRatingContract> appRatings;
    private String formFileLocationQueryParam;
    private String formJsonFileLocalUrl;
    private List<SDKConfigurationFormContract> forms;
    private String globalConfigurationFileLocalUrl;
    private List<ResourceContract> globalResources;
    private String preloadFormJsonFileLocalUrl;
    private HashMap<String, Boolean> provisions;

    protected PropertyConfigurationContract(String str, String str2, List<ResourceContract> list, List<SDKConfigurationFormContract> list2, HashMap<String, Boolean> hashMap, List<AppRatingContract> list3) {
        this.formJsonFileLocalUrl = str;
        this.globalConfigurationFileLocalUrl = str2;
        this.globalResources = list;
        this.forms = list2;
        this.provisions = hashMap;
        this.appRatings = list3;
    }

    PropertyConfigurationContract(JSONObject jSONObject) {
        try {
            if (jSONObject.has("formJsonFileLocalUrl") && !jSONObject.isNull("formJsonFileLocalUrl")) {
                this.formJsonFileLocalUrl = jSONObject.getString("formJsonFileLocalUrl");
            }
            if (jSONObject.has("globalConfigurationFileLocalUrl") && !jSONObject.isNull("globalConfigurationFileLocalUrl")) {
                this.globalConfigurationFileLocalUrl = jSONObject.getString("globalConfigurationFileLocalUrl");
            }
            if (jSONObject.has("globalResources") && !jSONObject.isNull("globalResources")) {
                this.globalResources = ModelFactory.getInstance().getResourcesArray(jSONObject.getJSONArray("globalResources"));
            }
            if (jSONObject.has("forms") && !jSONObject.isNull("forms")) {
                this.forms = ModelFactory.getInstance().getFormContractsArray(jSONObject.getJSONArray("forms"));
            }
            if (jSONObject.has("provisions") && !jSONObject.isNull("provisions")) {
                this.provisions = ModelFactory.getInstance().getStringBooleanMap(jSONObject.getJSONObject("provisions"));
            }
            if (jSONObject.has("appRatings") && !jSONObject.isNull("appRatings")) {
                this.appRatings = ModelFactory.getInstance().getAppRatingContractsArray(jSONObject.getJSONArray("appRatings"));
            }
            if (jSONObject.has("preloadFormJsonFileLocalUrl") && !jSONObject.isNull("preloadFormJsonFileLocalUrl")) {
                this.preloadFormJsonFileLocalUrl = jSONObject.getString("preloadFormJsonFileLocalUrl");
            }
            if (jSONObject.has("formFileLocationQueryParam") && !jSONObject.isNull("formFileLocationQueryParam")) {
                this.formFileLocationQueryParam = jSONObject.getString("formFileLocationQueryParam");
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public List<AppRatingContract> getAppRatings() {
        return this.appRatings;
    }

    /* access modifiers changed from: protected */
    public String getFormFileLocationQueryParam() {
        return this.formFileLocationQueryParam;
    }

    /* access modifiers changed from: protected */
    public String getFormJsonFileLocalUrl() {
        return this.formJsonFileLocalUrl;
    }

    /* access modifiers changed from: protected */
    public List<SDKConfigurationFormContract> getForms() {
        return this.forms;
    }

    /* access modifiers changed from: protected */
    public String getGlobalConfigurationFileLocalUrl() {
        return this.globalConfigurationFileLocalUrl;
    }

    /* access modifiers changed from: protected */
    public List<ResourceContract> getGlobalResources() {
        return this.globalResources;
    }

    /* access modifiers changed from: protected */
    public String getPreloadFormJsonFileLocalUrl() {
        return this.preloadFormJsonFileLocalUrl;
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Boolean> getProvisions() {
        return this.provisions;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            return "{\"formJsonFileLocalUrl\":" + C3770w2.m1830b(this.formJsonFileLocalUrl) + ",\"globalConfigurationFileLocalUrl\":" + C3770w2.m1830b(this.globalConfigurationFileLocalUrl) + ",\"formFileLocationQueryParam\":" + C3770w2.m1830b(this.formFileLocationQueryParam) + ",\"preloadFormJsonFileLocalUrl\":" + C3770w2.m1830b(this.preloadFormJsonFileLocalUrl) + ",\"globalResources\":" + ModelFactory.getInstance().getResourcesAsJsonString(this.globalResources) + ",\"forms\":" + ModelFactory.getInstance().getFormsAsJsonString(this.forms) + ",\"provisions\":" + ModelFactory.getInstance().getProvisionsAsJsonString(this.provisions) + ",\"appRatings\":" + ModelFactory.getInstance().getAppRatingsAsJsonString(this.appRatings) + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
