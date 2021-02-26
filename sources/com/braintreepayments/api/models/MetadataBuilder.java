package com.braintreepayments.api.models;

import org.json.JSONException;
import org.json.JSONObject;

public class MetadataBuilder {
    private static final String INTEGRATION_KEY = "integration";
    public static final String META_KEY = "_meta";
    private static final String PLATFORM_KEY = "platform";
    private static final String SESSION_ID_KEY = "sessionId";
    private static final String SOURCE_KEY = "source";
    private static final String VERSION_KEY = "version";
    private JSONObject mJson = new JSONObject();

    public MetadataBuilder() {
        try {
            this.mJson.put("platform", "android");
        } catch (JSONException unused) {
        }
    }

    public MetadataBuilder source(String str) {
        try {
            this.mJson.put("source", str);
        } catch (JSONException unused) {
        }
        return this;
    }

    public MetadataBuilder integration(String str) {
        try {
            this.mJson.put(INTEGRATION_KEY, str);
        } catch (JSONException unused) {
        }
        return this;
    }

    public MetadataBuilder sessionId(String str) {
        try {
            this.mJson.put(SESSION_ID_KEY, str);
        } catch (JSONException unused) {
        }
        return this;
    }

    public MetadataBuilder version() {
        try {
            this.mJson.put("version", "3.0.0");
        } catch (JSONException unused) {
        }
        return this;
    }

    public JSONObject build() {
        return this.mJson;
    }

    public String toString() {
        return this.mJson.toString();
    }
}
