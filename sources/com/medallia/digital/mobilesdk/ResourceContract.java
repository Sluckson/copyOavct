package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3792y;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

class ResourceContract extends C3792y implements Serializable {
    private static final int HASH_CODE_MULT = 31;
    private String checksum;
    private String formId;
    private Boolean isGlobal = false;
    private String localUrl;
    private String remoteUrl;

    protected ResourceContract() {
    }

    protected ResourceContract(String str, String str2, String str3, String str4) {
        this.formId = str;
        this.remoteUrl = str2;
        this.localUrl = str3;
        this.checksum = str4;
        this.isGlobal = false;
    }

    protected ResourceContract(String str, String str2, String str3, String str4, boolean z) {
        this.formId = str;
        this.remoteUrl = str2;
        this.localUrl = str3;
        this.checksum = str4;
        this.isGlobal = Boolean.valueOf(z);
    }

    ResourceContract(JSONObject jSONObject) {
        try {
            if (jSONObject.has("remoteUrl") && !jSONObject.isNull("remoteUrl")) {
                this.remoteUrl = jSONObject.getString("remoteUrl");
            }
            if (jSONObject.has("localUrl") && !jSONObject.isNull("localUrl")) {
                this.localUrl = jSONObject.getString("localUrl");
            }
            if (jSONObject.has("checksum") && !jSONObject.isNull("checksum")) {
                this.checksum = jSONObject.getString("checksum");
            }
            if (jSONObject.has("isGlobal") && !jSONObject.isNull("isGlobal")) {
                this.isGlobal = Boolean.valueOf(jSONObject.getBoolean("isGlobal"));
            }
            if (jSONObject.has("formId") && !jSONObject.isNull("formId")) {
                this.formId = jSONObject.getString("formId");
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ResourceContract.class != obj.getClass()) {
            return false;
        }
        ResourceContract resourceContract = (ResourceContract) obj;
        String str = this.formId;
        if (str == null ? resourceContract.formId != null : !str.equals(resourceContract.formId)) {
            return false;
        }
        String str2 = this.remoteUrl;
        if (str2 == null ? resourceContract.remoteUrl != null : !str2.equals(resourceContract.remoteUrl)) {
            return false;
        }
        String str3 = this.localUrl;
        if (str3 == null ? resourceContract.localUrl != null : !str3.equals(resourceContract.localUrl)) {
            return false;
        }
        Boolean bool = this.isGlobal;
        if (bool == null ? resourceContract.isGlobal != null : !bool.equals(resourceContract.isGlobal)) {
            return false;
        }
        String str4 = this.checksum;
        return str4 != null ? str4.equals(resourceContract.checksum) : resourceContract.checksum == null;
    }

    /* access modifiers changed from: protected */
    public String getChecksum() {
        return this.checksum;
    }

    /* access modifiers changed from: protected */
    public C3792y.C3793a getDataTableObjectType() {
        return C3792y.C3793a.Resource;
    }

    /* access modifiers changed from: protected */
    public String getFormId() {
        return this.formId;
    }

    /* access modifiers changed from: protected */
    public String getLocalUrl() {
        return this.localUrl;
    }

    /* access modifiers changed from: protected */
    public String getRemoteUrl() {
        return this.remoteUrl;
    }

    public int hashCode() {
        String str = this.formId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.remoteUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.localUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.checksum;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool = this.isGlobal;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode4 + i;
    }

    /* access modifiers changed from: protected */
    public Boolean isGlobal() {
        Boolean bool = this.isGlobal;
        if (bool == null) {
            return false;
        }
        return bool;
    }

    /* access modifiers changed from: protected */
    public void setFormId(String str) {
        this.formId = str;
    }

    /* access modifiers changed from: protected */
    public String toJsonString() {
        try {
            return "{\"formId\":" + C3770w2.m1830b(this.formId) + ",\"remoteUrl\":" + C3770w2.m1830b(this.remoteUrl) + ",\"localUrl\":" + C3770w2.m1830b(this.localUrl) + ",\"checksum\":" + C3770w2.m1830b(this.checksum) + ",\"isGlobal\":" + this.isGlobal + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }
}
