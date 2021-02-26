package com.iaai.android.old.models;

import com.iaai.android.old.utils.ParcelUtils;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;

public class ScopeDetail {
    @JsonIgnore
    public int count;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("Name")
    public String name;

    @JsonSetter("Count")
    public void setCountString(String str) {
        this.count = ParcelUtils.toInt(str);
    }

    public String toString() {
        int i = this.count;
        if (i > 2000) {
            return String.format("%s (2000+)", new Object[]{this.localizedName});
        }
        return String.format("%s (%d)", new Object[]{this.localizedName, Integer.valueOf(i)});
    }
}
