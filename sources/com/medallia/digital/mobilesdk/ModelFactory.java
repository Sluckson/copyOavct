package com.medallia.digital.mobilesdk;

import android.text.TextUtils;
import com.medallia.digital.mobilesdk.C3586j3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ModelFactory {
    private static ModelFactory modelFactory;

    ModelFactory() {
    }

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private boolean validate(C3423a aVar) {
        C3586j3.C3587a aVar2;
        if (aVar.mo55173c() == null) {
            aVar2 = C3586j3.C3587a.GET_CONFIG_EMPTY_ENDPOINT;
        } else if (aVar.mo55174d() == -1) {
            aVar2 = C3586j3.C3587a.ACCESS_PROPERTY_ID_NO_DATA;
        } else if (aVar.mo55172b() == -1) {
            aVar2 = C3586j3.C3587a.CREATION_DATE_NO_DATA;
        } else if (aVar.mo55175e() == -1) {
            aVar2 = C3586j3.C3587a.TTL_NO_DATA;
        } else if (aVar.mo55850a() != null) {
            return true;
        } else {
            aVar2 = C3586j3.C3587a.ACCESS_TOKEN_TOKEN_FIELD_NO_DATA;
        }
        C3490e3.m666f(aVar2.toString());
        return false;
    }

    private boolean validate(C3580j jVar) {
        C3586j3.C3587a aVar;
        if (TextUtils.isEmpty(jVar.mo55489b())) {
            aVar = C3586j3.C3587a.EMPTY_AUTH_GW;
        } else if (jVar.mo55490c() == -1) {
            aVar = C3586j3.C3587a.API_TOKEN_PROPERTY_ID_NO_DATA;
        } else if (!TextUtils.isEmpty(jVar.mo55850a())) {
            return true;
        } else {
            aVar = C3586j3.C3587a.API_TOKEN_TOKEN_FIELD_NO_DATA;
        }
        C3490e3.m666f(aVar.toString());
        return false;
    }

    private void validateConfiguration(ConfigurationContract configurationContract) {
        if (configurationContract != null) {
            configurationContract.validateFields();
        } else {
            C3490e3.m666f(C3586j3.C3587a.CONFIGURATION.toString());
        }
    }

    private void validateFeedback(C3701r1 r1Var) {
        if (r1Var == null || r1Var.mo55767a() == null) {
            C3490e3.m666f(C3586j3.C3587a.FEEDBACK_PARSE_ERROR.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.medallia.digital.mobilesdk.C3423a createAccessToken(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "accessToken"
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            r2 = 0
            if (r1 == 0) goto L_0x0013
        L_0x0009:
            com.medallia.digital.mobilesdk.j3$a r5 = com.medallia.digital.mobilesdk.C3586j3.C3587a.ACCESS_TOKEN_PARSE
            java.lang.String r5 = r5.toString()
            com.medallia.digital.mobilesdk.C3490e3.m663c(r5)
            return r2
        L_0x0013:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0046, NullPointerException -> 0x0027 }
            r1.<init>(r5)     // Catch:{ JSONException -> 0x0046, NullPointerException -> 0x0027 }
            boolean r3 = r1.has(r0)     // Catch:{ JSONException -> 0x0046, NullPointerException -> 0x0027 }
            if (r3 == 0) goto L_0x0044
            java.lang.Object r0 = r1.get(r0)     // Catch:{ JSONException -> 0x0046, NullPointerException -> 0x0027 }
            java.lang.String r5 = r0.toString()     // Catch:{ JSONException -> 0x0046, NullPointerException -> 0x0027 }
            goto L_0x0047
        L_0x0027:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.medallia.digital.mobilesdk.j3$a r1 = com.medallia.digital.mobilesdk.C3586j3.C3587a.ACCESS_TOKEN_PARSE
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            java.lang.String r5 = r5.getMessage()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            com.medallia.digital.mobilesdk.C3490e3.m663c(r5)
        L_0x0044:
            r5 = r2
            goto L_0x0047
        L_0x0046:
        L_0x0047:
            com.medallia.digital.mobilesdk.a r0 = new com.medallia.digital.mobilesdk.a
            r0.<init>(r5)
            r0.mo55851a(r5)
            boolean r5 = r4.validate((com.medallia.digital.mobilesdk.C3423a) r0)
            if (r5 != 0) goto L_0x0056
            goto L_0x0009
        L_0x0056:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.ModelFactory.createAccessToken(java.lang.String):com.medallia.digital.mobilesdk.a");
    }

    /* access modifiers changed from: protected */
    public C3580j createApiToken(String str) {
        if (TextUtils.isEmpty(str)) {
            C3490e3.m666f(C3586j3.C3587a.API_TOKEN_PARSE_ERROR.toString());
        } else {
            try {
                C3580j jVar = new C3580j(str);
                jVar.mo55851a(str);
                if (validate(jVar)) {
                    return jVar;
                }
                return null;
            } catch (Exception e) {
                C3490e3.m663c(C3586j3.C3587a.API_TOKEN_PARSE_ERROR.toString() + e.getMessage());
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public ConfigurationContract createConfiguration(String str) {
        try {
            ConfigurationContract configurationContract = new ConfigurationContract(new JSONObject(str));
            validateConfiguration(configurationContract);
            return configurationContract;
        } catch (Exception e) {
            C3490e3.m663c(C3586j3.C3587a.CONFIGURATION.toString() + e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public EvaluationResult createEvaluationResult(String str) {
        if (str != null && !str.equals("null")) {
            try {
                return new EvaluationResult(new JSONObject(str));
            } catch (Exception e) {
                C3490e3.m666f(e.getMessage());
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public C3701r1 createFeedback(String str) {
        try {
            C3701r1 r1Var = new C3701r1(new JSONObject(str));
            validateFeedback(r1Var);
            return r1Var;
        } catch (Exception e) {
            C3490e3.m663c(C3586j3.C3587a.FEEDBACK_PARSE_ERROR.toString() + e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public C3716s1 createFeedbackContract(String str) {
        try {
            return new C3716s1(new JSONObject(str));
        } catch (Exception e) {
            C3490e3.m663c(C3586j3.C3587a.DESERIALIZE_FEEDBACK_PAYLOAD.toString() + e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public TargetRuleEngineContract createTargetRuleEngine(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new TargetRuleEngineContract(new JSONObject(str));
        } catch (Exception e) {
            C3490e3.m666f(e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public C3640m5 createTransitionType(String str) {
        String str2;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getJSONObject("settings").getJSONObject("formBasicSettings").getString("transitionType");
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
            return C3640m5.m1268a(str2);
        }
        str2 = null;
        return C3640m5.m1268a(str2);
    }

    /* access modifiers changed from: protected */
    public ConfigurationUUID createUUID(String str) {
        try {
            return new ConfigurationUUID(new JSONObject(str));
        } catch (Exception e) {
            C3490e3.m663c(C3586j3.C3587a.UUID_EMPTY.toString() + e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public JSONArray customParametersToJsonArray(ArrayList<CustomParameter> arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<CustomParameter> it = arrayList.iterator();
        while (it.hasNext()) {
            JSONObject d = it.next().mo54996d();
            if (d != null) {
                jSONArray.put(d);
            }
        }
        return jSONArray;
    }

    /* access modifiers changed from: protected */
    public String getAnalyticsAsJsonString(List<C3485e> list) {
        if (list == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).toJsonString());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public List<AppRatingContract> getAppRatingContractsArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(new AppRatingContract(jSONArray.getJSONObject(i)));
                i++;
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String getAppRatingsAsJsonString(List<AppRatingContract> list) {
        if (list == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).toJsonString());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public ArrayList<Component> getComponentsArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<Component> arrayList = new ArrayList<>();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(new Component(jSONArray.getJSONObject(i)));
                i++;
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public ArrayList<CustomParameter> getCustomParameterArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<CustomParameter> arrayList = new ArrayList<>();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(new CustomParameter(jSONArray.getJSONObject(i)));
                i++;
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public List<SDKConfigurationFormContract> getFormContractsArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(new SDKConfigurationFormContract(jSONArray.getJSONObject(i)));
                i++;
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String getFormsAsJsonString(List<SDKConfigurationFormContract> list) {
        if (list == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).toJsonString());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public ArrayList<C3450b4> getPageArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<C3450b4> arrayList = new ArrayList<>();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(new C3450b4(jSONArray.getJSONObject(i)));
                i++;
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String getProvisionsAsJsonString(HashMap<String, Boolean> hashMap) {
        if (hashMap == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int i = 0;
        while (i < arrayList.size()) {
            try {
                sb.append("\"");
                sb.append((String) arrayList.get(i));
                sb.append("\":");
                sb.append(hashMap.get(arrayList.get(i)));
                if (i < arrayList.size() - 1) {
                    sb.append(',');
                }
                i++;
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
                return "{}";
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public List<ResourceContract> getResourcesArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(new ResourceContract(jSONArray.getJSONObject(i)));
                i++;
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String getResourcesAsJsonString(List<ResourceContract> list) {
        if (list == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).toJsonString());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public ArrayList<String> getStringArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(jSONArray.getString(i));
                i++;
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String getStringArrayAsJsonString(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == null) {
                sb.append("null");
            } else {
                sb.append("\"");
                sb.append(arrayList.get(i));
                sb.append("\"");
            }
            if (i < arrayList.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Boolean> getStringBooleanMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, Boolean> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                hashMap.put(next, jSONObject.isNull(next) ? null : Boolean.valueOf(jSONObject.getBoolean(next)));
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public HashMap<String, String> getStringMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.getString(next));
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public String getStringMapAsJsonString(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int i = 0;
        while (i < arrayList.size()) {
            try {
                sb.append("\"");
                sb.append((String) arrayList.get(i));
                sb.append("\":\"");
                sb.append(hashMap.get(arrayList.get(i)));
                sb.append("\"");
                if (i < arrayList.size() - 1) {
                    sb.append(',');
                }
                i++;
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
                return "{}";
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
