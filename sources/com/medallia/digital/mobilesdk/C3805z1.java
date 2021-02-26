package com.medallia.digital.mobilesdk;

import android.content.Intent;
import android.view.accessibility.AccessibilityManager;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iaai.android.old.utils.constants.Constants;
import com.medallia.digital.mobilesdk.C3527g0;
import com.medallia.digital.mobilesdk.C3815z4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.z1 */
class C3805z1 {

    /* renamed from: e */
    private static final String f2080e = "nps";

    /* renamed from: a */
    private final FormViewType f2081a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C3812g f2082b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f2083c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FormTriggerType f2084d;

    /* renamed from: com.medallia.digital.mobilesdk.z1$a */
    class C3806a implements C3660o4<Void> {
        C3806a() {
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3490e3.m663c("Submit feedback failed: " + j3Var.getMessage());
        }

        /* renamed from: a */
        public void mo55257a(Void voidR) {
            C3490e3.m665e("Submit feedback sent successfully");
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(new Intent("com.medallia.digital.mobilesdk.sync_userjourney_action"));
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.z1$b */
    class C3807b extends C3666p3 {
        C3807b() {
        }

        /* renamed from: a */
        public void mo55177a() {
            C3490e3.m661b("FormId: " + C3805z1.this.f2083c + " ready");
            if (C3805z1.this.f2082b != null) {
                C3805z1.this.f2082b.mo55096c();
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.z1$c */
    class C3808c extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ String f2087a;

        C3808c(String str) {
            this.f2087a = str;
        }

        /* renamed from: a */
        public void mo55177a() {
            String str;
            if (C3815z4.m2010d().mo55979a(C3815z4.C3816a.SDK_STOPPED, false)) {
                str = "Feedback can’t be sent because of stop sdk";
            } else if (new C3786x2().mo55921b()) {
                str = "Submit sdk was cancelled by sdk kill";
            } else {
                C3490e3.m665e("FormId: " + C3805z1.this.f2083c + " sendFeedbackToMobileSdk was called - feedbackData = " + this.f2087a);
                C3805z1.this.m1980a();
                String str2 = this.f2087a;
                if (str2 == null || str2.equals("undefined") || this.f2087a.isEmpty()) {
                    str = "Submit feedback data - null";
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(this.f2087a);
                        JSONObject jSONObject2 = new JSONObject();
                        if (jSONObject.has("uuid") && !jSONObject.isNull("uuid")) {
                            jSONObject2.put("uuid", C3770w2.m1827a((Object) jSONObject.getString("uuid")));
                        }
                        if (jSONObject.has("dynamicData") && !jSONObject.isNull("dynamicData")) {
                            jSONObject2.put("dynamicData", C3770w2.m1827a((Object) jSONObject.getJSONObject("dynamicData")));
                        }
                        C3805z1.this.mo55957b(jSONObject2);
                        C3805z1.this.mo55956a(jSONObject);
                        C3805z1.this.mo55958c(jSONObject);
                        C3805z1.this.mo55954a(new C3731t1(jSONObject.toString(), jSONObject2.has("uuid") ? jSONObject2.getString("uuid") : null, C3805z1.this.f2083c, C3805z1.this.f2084d, System.currentTimeMillis(), 0));
                        return;
                    } catch (Exception e) {
                        C3490e3.m663c(e.getMessage());
                        return;
                    }
                }
            }
            C3490e3.m665e(str);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.z1$d */
    class C3809d extends C3666p3 {
        C3809d() {
        }

        /* renamed from: a */
        public void mo55177a() {
            C3490e3.m665e("FormId: " + C3805z1.this.f2083c + " submitSuccess was called");
            C3805z1.this.m1980a();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.z1$e */
    class C3810e extends C3666p3 {
        C3810e() {
        }

        /* renamed from: a */
        public void mo55177a() {
            if (C3805z1.this.f2082b != null) {
                C3805z1.this.f2082b.mo55097d();
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.z1$f */
    public enum C3811f {
        MOBILE_DEVICE_DATA("mobileDeviceData"),
        DEVICE_RESOLUTION("deviceResolution"),
        DEVICE_LOCALE("deviceLocale"),
        DEVICE_VENDOR("deviceVendor");
        

        /* renamed from: a */
        private String f2096a;

        private C3811f(String str) {
            this.f2096a = str;
        }

        /* renamed from: a */
        public String mo55972a() {
            return this.f2096a;
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.z1$g */
    protected interface C3812g {
        /* renamed from: c */
        void mo55096c();

        /* renamed from: d */
        void mo55097d();
    }

    C3805z1(String str, C3812g gVar, FormTriggerType formTriggerType, FormViewType formViewType) {
        this.f2082b = gVar;
        this.f2083c = str;
        this.f2084d = formTriggerType;
        this.f2081a = formViewType;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1980a() {
        Intent intent = new Intent("com.medallia.digital.mobilesdk.LastSubmitTimestampCollectorFilter");
        intent.putExtra("com.medallia.digital.mobilesdk.LastSubmitTimestampCollector", System.currentTimeMillis());
        C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(intent);
        C3527g0.C3531c.m842a(C3527g0.C3531c.C3532a.formSubmitted, this.f2083c, this.f2084d, this.f2081a);
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55954a(C3731t1 t1Var) {
        C3646n3.m1337m().mo55666a(t1Var, (C3660o4<Void>) new C3806a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55955a(C3812g gVar) {
        this.f2082b = gVar;
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55956a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = (!jSONObject.has(C3811f.MOBILE_DEVICE_DATA.mo55972a()) || jSONObject.isNull(C3811f.MOBILE_DEVICE_DATA.mo55972a())) ? null : jSONObject.getJSONObject(C3811f.MOBILE_DEVICE_DATA.mo55972a());
            if (jSONObject2 != null) {
                jSONObject2.put(C3811f.DEVICE_RESOLUTION.mo55972a(), C3770w2.m1827a((Object) CollectorsInfrastructure.getInstance().getDeviceResolution()));
                jSONObject2.put(C3811f.DEVICE_LOCALE.mo55972a(), C3770w2.m1827a((Object) CollectorsInfrastructure.getInstance().getLanguage()));
                jSONObject2.put(C3811f.DEVICE_VENDOR.mo55972a(), C3770w2.m1827a((Object) CollectorsInfrastructure.getInstance().getDeviceVendor()));
                jSONObject.put(C3811f.MOBILE_DEVICE_DATA.mo55972a(), jSONObject2);
            }
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    @VisibleForTesting
    /* renamed from: b */
    public void mo55957b(JSONObject jSONObject) {
        JSONObject a;
        if (jSONObject == null) {
            try {
                C3490e3.m666f("feedbackContract is null");
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
        } else {
            JSONObject jSONObject2 = null;
            if (jSONObject.has("dynamicData") && !jSONObject.isNull("dynamicData")) {
                jSONObject2 = jSONObject.getJSONObject("dynamicData");
            }
            if (jSONObject2 != null && jSONObject2.has("pages")) {
                if (!jSONObject2.isNull("pages")) {
                    if (!jSONObject.has("uuid") || jSONObject.isNull("uuid")) {
                        jSONObject.put("uuid", UUID.randomUUID().toString());
                    }
                    JSONArray jSONArray = new JSONArray();
                    if (jSONObject2.has("pages")) {
                        if (!jSONObject2.isNull("pages")) {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray("pages");
                            for (int i = 0; i < jSONArray2.length(); i++) {
                                JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                                if (jSONObject3 != null && jSONObject3.has("components") && !jSONObject3.isNull("components")) {
                                    JSONArray jSONArray3 = jSONObject3.getJSONArray("components");
                                    for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                                        jSONArray.put(jSONArray3.get(i2));
                                    }
                                }
                            }
                        }
                    }
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("uuid", C3770w2.m1827a(jSONObject.get("uuid")));
                    jSONObject4.put("components", C3770w2.m1827a((Object) jSONArray));
                    if (C3715s0.m1612b().mo55792a() != null && C3715s0.m1612b().mo55792a().getSdkConfiguration() != null && C3715s0.m1612b().mo55792a().getSdkConfiguration().getFormConfigurations() != null && (a = C3761v1.m1783a(jSONObject4, C3715s0.m1612b().mo55792a().getSdkConfiguration().getFormConfigurations())) != null) {
                        mo55960d(a);
                        C3527g0.C3531c.m846a(C3527g0.C3531c.C3532a.feedbackPayload, this.f2083c, this.f2084d, jSONObject.getString("uuid"), a.toString());
                        return;
                    }
                    return;
                }
            }
            C3490e3.m666f("dynamicData is null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo55958c(JSONObject jSONObject) {
        try {
            for (SDKConfigurationFormContract next : C3715s0.m1612b().mo55792a().getPropertyConfiguration().getForms()) {
                if (next.getFormId().equals(this.f2083c)) {
                    if (next.getCustomParams() != null) {
                        JSONArray jSONArray = new JSONArray(C3770w2.m1832d(next.getCustomParams()));
                        HashMap hashMap = new HashMap();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            hashMap.put(jSONObject2.getString("unique_name"), jSONObject2);
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        Iterator<CustomParameter> it = CollectorsInfrastructure.getInstance().getCustomParameters().iterator();
                        while (it.hasNext()) {
                            CustomParameter next2 = it.next();
                            if (hashMap.get(next2.mo54993b()) != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("unique_name", next2.mo54993b());
                                jSONObject3.put("value", next2.mo54994c());
                                jSONArray2.put(jSONObject3);
                            }
                        }
                        JSONObject jSONObject4 = jSONObject.getJSONObject("dynamicData");
                        jSONObject4.put("customParams", jSONArray2);
                        jSONObject.put("dynamicData", jSONObject4);
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    @JavascriptInterface
    public void close() {
        C3561h5.m954c().mo55465a().execute(new C3810e());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo55960d(JSONObject jSONObject) {
        if (jSONObject.has("components") && !jSONObject.isNull("components")) {
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("components");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.has("type")) {
                        if (jSONObject2.has("value")) {
                            if (f2080e.equals(jSONObject2.getString("type")) && !jSONObject2.isNull("value")) {
                                try {
                                    Intent intent = new Intent("com.medallia.digital.mobilesdk.NPSCollectorFilter");
                                    intent.putExtra("com.medallia.digital.mobilesdk.NPSCollector", jSONObject2.getInt("value"));
                                    C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(intent);
                                } catch (Exception e) {
                                    C3490e3.m663c(e.getMessage());
                                }
                            }
                        }
                    }
                    if (jSONObject2.has("isCsat") && jSONObject2.has("value") && !jSONObject2.isNull("isCsat") && jSONObject2.getBoolean("isCsat") && !jSONObject2.isNull("value")) {
                        try {
                            Intent intent2 = new Intent("com.medallia.digital.mobilesdk.CSATCollectorFilter");
                            intent2.putExtra("com.medallia.digital.mobilesdk.CSATCollector", jSONObject2.getInt("value"));
                            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(intent2);
                        } catch (Exception e2) {
                            C3490e3.m663c(e2.getMessage());
                        }
                    }
                }
            } catch (Exception e3) {
                C3490e3.m663c(e3.getMessage());
            }
        }
    }

    @JavascriptInterface
    public String getCustomParams() {
        JSONObject jSONObject = new JSONObject();
        ArrayList<CustomParameter> customParameters = CollectorsInfrastructure.getInstance().getCustomParameters();
        if (customParameters != null) {
            try {
                Iterator<CustomParameter> it = customParameters.iterator();
                while (it.hasNext()) {
                    CustomParameter next = it.next();
                    jSONObject.put(next.mo54993b(), C3770w2.m1827a((Object) String.valueOf(next.mo54994c())));
                }
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        String jSONObject2 = jSONObject.toString();
        C3490e3.m661b("FormId: " + this.f2083c + " getCustomParams was called " + jSONObject2);
        return jSONObject2;
    }

    @JavascriptInterface
    public String getDeviceData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("osVersion", C3770w2.m1827a((Object) CollectorsInfrastructure.getInstance().getOSVersion()));
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, C3770w2.m1827a((Object) CollectorsInfrastructure.getInstance().getSDKVersion()));
            jSONObject.put("appVersion", C3770w2.m1827a((Object) CollectorsInfrastructure.getInstance().getAppVersion()));
            jSONObject.put("osType", "Android");
            jSONObject.put(Constants.DEVICEID_HEADER, C3770w2.m1827a((Object) CollectorsInfrastructure.getInstance().getDeviceId()));
            jSONObject.put("deviceModel", C3770w2.m1827a((Object) CollectorsInfrastructure.getInstance().getDeviceModel()));
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.APP_ID, C3770w2.m1827a((Object) CollectorsInfrastructure.getInstance().getAppId()));
        } catch (JSONException e) {
            C3490e3.m663c(e.getMessage());
        }
        String jSONObject2 = jSONObject.toString();
        C3490e3.m661b("FormId: " + this.f2083c + " getDeviceData was called " + jSONObject2);
        return jSONObject2;
    }

    @JavascriptInterface
    public String getProvisions() {
        HashMap<String, Boolean> d = C3552h2.m914h().mo55457d();
        JSONObject jSONObject = new JSONObject();
        if (d != null) {
            try {
                for (Map.Entry next : d.entrySet()) {
                    jSONObject.put((String) next.getKey(), C3770w2.m1827a(next.getValue()));
                }
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
        }
        String jSONObject2 = jSONObject.toString();
        C3490e3.m661b("FormId: " + this.f2083c + " getProvisions was called " + jSONObject2);
        return jSONObject2;
    }

    @JavascriptInterface
    public String getSecretToken() {
        C3423a a = C3604l2.m1115c().mo55534a();
        if (a != null) {
            return a.mo55850a();
        }
        return null;
    }

    @JavascriptInterface
    public void ready() {
        C3561h5.m954c().mo55465a().execute(new C3807b());
    }

    @JavascriptInterface
    public void sendFeedbackToMobileSdk(String str) {
        C3561h5.m954c().mo55465a().execute(new C3808c(str));
    }

    @JavascriptInterface
    public void submitFailed() {
        C3490e3.m665e("FormId: " + this.f2083c + " submitFailed was called");
    }

    @JavascriptInterface
    public void submitPending() {
        submitPending(true);
    }

    @JavascriptInterface
    public void submitPending(boolean z) {
        C3812g gVar;
        C3490e3.m665e("FormId: " + this.f2083c + " submitPending was called - shouldClose = " + z);
        if (z && (gVar = this.f2082b) != null) {
            gVar.mo55097d();
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) C3595k3.m1060d().mo55513b().getSystemService("accessibility");
            if (accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                Toast.makeText(C3595k3.m1060d().mo55513b(), "Feedback Submitted Successfully", 0).show();
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    @JavascriptInterface
    public void submitSuccess() {
        C3561h5.m954c().mo55465a().execute(new C3809d());
    }
}
