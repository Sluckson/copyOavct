package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class SDKConfigurationFormContract extends EngagementContract {
    private String customParams;
    private String formId;
    private JSONObject formJson;
    private FormTriggerType formType;
    private FormViewType formViewType;
    private String isPreloaded;
    private List<ResourceContract> resources;
    private String templateLocalUrl;
    private String templateRemoteUrl;
    private String title;
    private String titleBackgroundColor;
    private String titleTextColor;
    private String transitionType;

    protected SDKConfigurationFormContract() {
    }

    protected SDKConfigurationFormContract(String str, String str2, String str3, String str4, JSONObject jSONObject, List<ResourceContract> list, InviteData inviteData, JSONObject jSONObject2, String str5, FormTriggerType formTriggerType, String str6, String str7, String str8, FormViewType formViewType2, String str9) {
        super(str2, inviteData, jSONObject2);
        this.formId = str;
        this.templateRemoteUrl = str3;
        this.templateLocalUrl = str4;
        this.formJson = jSONObject;
        this.resources = list;
        this.customParams = str5;
        this.formType = formTriggerType;
        this.title = str6;
        this.titleTextColor = str7;
        this.titleBackgroundColor = str8;
        this.formViewType = formViewType2 == null ? FormViewType.none : formViewType2;
        this.isPreloaded = str9;
    }

    SDKConfigurationFormContract(JSONObject jSONObject) {
        super(jSONObject);
        String str;
        try {
            if (jSONObject.has("formId") && !jSONObject.isNull("formId")) {
                this.formId = jSONObject.getString("formId");
            }
            if (jSONObject.has("templateRemoteUrl") && !jSONObject.isNull("templateRemoteUrl")) {
                this.templateRemoteUrl = jSONObject.getString("templateRemoteUrl");
            }
            if (jSONObject.has("templateLocalUrl") && !jSONObject.isNull("templateLocalUrl")) {
                this.templateLocalUrl = jSONObject.getString("templateLocalUrl");
            }
            if (jSONObject.has("formJson") && !jSONObject.isNull("formJson")) {
                this.formJson = jSONObject.getJSONObject("formJson");
            }
            if (jSONObject.has("customParams")) {
                if (jSONObject.get("customParams") instanceof JSONArray) {
                    str = jSONObject.getJSONArray("customParams").toString();
                } else if (jSONObject.get("customParams") instanceof JSONObject) {
                    str = jSONObject.getJSONObject("customParams").toString();
                } else if (jSONObject.get("customParams") instanceof String) {
                    str = C3770w2.m1828a(jSONObject.getString("customParams"));
                }
                this.customParams = str;
            }
            if (jSONObject.has("title") && !jSONObject.isNull("title")) {
                this.title = jSONObject.getString("title");
            }
            if (jSONObject.has("titleTextColor") && !jSONObject.isNull("titleTextColor")) {
                this.titleTextColor = jSONObject.getString("titleTextColor");
            }
            if (jSONObject.has("titleBackgroundColor") && !jSONObject.isNull("titleBackgroundColor")) {
                this.titleBackgroundColor = jSONObject.getString("titleBackgroundColor");
            }
            if (jSONObject.has("transitionType") && !jSONObject.isNull("transitionType")) {
                this.transitionType = jSONObject.getString("transitionType");
            }
            if (jSONObject.has("formType") && !jSONObject.isNull("formType")) {
                this.formType = FormTriggerType.fromString(jSONObject.getString("formType"));
            }
            if (jSONObject.has("formViewType") && !jSONObject.isNull("formViewType")) {
                this.formViewType = FormViewType.fromString(jSONObject.getString("formViewType"));
            }
            if (jSONObject.has("resources") && !jSONObject.isNull("resources")) {
                this.resources = ModelFactory.getInstance().getResourcesArray(jSONObject.getJSONArray("resources"));
            }
            if (jSONObject.has("isPreloaded") && !jSONObject.isNull("isPreloaded")) {
                this.isPreloaded = jSONObject.getString("isPreloaded");
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SDKConfigurationFormContract.class != obj.getClass()) {
            return false;
        }
        SDKConfigurationFormContract sDKConfigurationFormContract = (SDKConfigurationFormContract) obj;
        String str = this.formId;
        return str != null ? str.equals(sDKConfigurationFormContract.formId) : sDKConfigurationFormContract.formId == null;
    }

    /* access modifiers changed from: protected */
    public String getCustomParams() {
        return this.customParams;
    }

    /* access modifiers changed from: protected */
    public String getFormId() {
        return this.formId;
    }

    public JSONObject getFormJson() {
        if (this.formJson == null) {
            this.formJson = new JSONObject();
        }
        return this.formJson;
    }

    /* access modifiers changed from: protected */
    public FormTriggerType getFormType() {
        return this.formType;
    }

    public FormViewType getFormViewType() {
        return this.formViewType;
    }

    public List<ResourceContract> getResources() {
        return this.resources;
    }

    /* access modifiers changed from: protected */
    public String getTemplateLocalUrl() {
        return this.templateLocalUrl;
    }

    /* access modifiers changed from: protected */
    public String getTemplateRemoteUrl() {
        return this.templateRemoteUrl;
    }

    /* access modifiers changed from: protected */
    public String getTitle() {
        return this.title;
    }

    /* access modifiers changed from: protected */
    public String getTitleBackgroundColor() {
        return this.titleBackgroundColor;
    }

    /* access modifiers changed from: protected */
    public String getTitleTextColor() {
        return this.titleTextColor;
    }

    public int hashCode() {
        String str = this.formId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean isPreloaded() {
        if (TextUtils.isEmpty(this.isPreloaded)) {
            return false;
        }
        return Boolean.valueOf(this.isPreloaded).booleanValue();
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        String str;
        try {
            String str2 = "null";
            if (this.formType == null) {
                str = str2;
            } else {
                str = "\"" + this.formType.toString() + "\"";
            }
            if (this.formViewType != null) {
                str2 = "\"" + this.formViewType.toString() + "\"";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("{\"formId\":");
            sb.append(C3770w2.m1830b(this.formId));
            sb.append(",\"templateRemoteUrl\":");
            sb.append(C3770w2.m1830b(this.templateRemoteUrl));
            sb.append(",\"templateLocalUrl\":");
            sb.append(C3770w2.m1830b(this.templateLocalUrl));
            sb.append(",\"formJson\":");
            String str3 = null;
            sb.append(this.formJson == null ? null : this.formJson.toString());
            sb.append(",\"resources\":");
            sb.append(ModelFactory.getInstance().getResourcesAsJsonString(this.resources));
            sb.append(",\"customParams\":");
            sb.append(C3770w2.m1830b(this.customParams));
            sb.append(",\"formType\":");
            sb.append(str);
            sb.append(",\"title\":");
            sb.append(C3770w2.m1830b(this.title));
            sb.append(",\"titleTextColor\":");
            sb.append(C3770w2.m1830b(this.titleTextColor));
            sb.append(",\"titleBackgroundColor\":");
            sb.append(C3770w2.m1830b(this.titleBackgroundColor));
            sb.append(",\"transitionType\":");
            sb.append(C3770w2.m1830b(this.transitionType));
            sb.append(",\"formViewType\":");
            sb.append(str2);
            sb.append(",\"name\":");
            sb.append(C3770w2.m1830b(getName()));
            sb.append(",\"inviteData\":");
            sb.append(getInviteData() != null ? getInviteData().toJsonString() : null);
            sb.append(",\"triggerData\":");
            if (getTriggerData() != null) {
                str3 = getTriggerData().toString();
            }
            sb.append(str3);
            sb.append(",\"isPreloaded\":");
            sb.append(C3770w2.m1830b(this.isPreloaded));
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
