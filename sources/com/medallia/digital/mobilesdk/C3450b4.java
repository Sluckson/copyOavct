package com.medallia.digital.mobilesdk;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.b4 */
class C3450b4 {

    /* renamed from: a */
    private ArrayList<Component> f932a = new ArrayList<>();

    protected C3450b4(JSONObject jSONObject) {
        try {
            if (jSONObject.has("components") && !jSONObject.isNull("components")) {
                this.f932a = ModelFactory.getInstance().getComponentsArray(jSONObject.getJSONArray("components"));
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ArrayList<Component> mo55236a() {
        return this.f932a;
    }
}
