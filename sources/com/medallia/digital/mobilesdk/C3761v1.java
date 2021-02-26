package com.medallia.digital.mobilesdk;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.v1 */
class C3761v1 {

    /* renamed from: a */
    private static final String f1952a = "CSAT";

    C3761v1() {
    }

    /* renamed from: a */
    protected static JSONObject m1783a(JSONObject jSONObject, FormConfigurations formConfigurations) {
        if (formConfigurations == null || formConfigurations.getFeedbackPayloadTypes() == null || formConfigurations.getFeedbackPayloadTypes().size() == 0) {
            return new JSONObject();
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("components");
            JSONArray jSONArray2 = new JSONArray();
            ArrayList<String> feedbackPayloadTypes = formConfigurations.getFeedbackPayloadTypes();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.has("type") && feedbackPayloadTypes.contains(jSONObject2.getString("type"))) {
                    if (jSONObject2.has("role")) {
                        if (f1952a.equals(jSONObject2.getString("role"))) {
                            jSONObject2.put("isCsat", true);
                            jSONArray2.put(jSONObject2);
                        }
                    }
                    jSONObject2.put("isCsat", false);
                    jSONArray2.put(jSONObject2);
                }
            }
            jSONObject.put("components", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return null;
        }
    }
}
