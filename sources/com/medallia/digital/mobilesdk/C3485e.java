package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3792y;
import com.medallia.digital.mobilesdk.C3815z4;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.e */
class C3485e extends C3792y {

    /* renamed from: g */
    private static final int f1023g = 6;

    /* renamed from: a */
    private String f1024a;

    /* renamed from: b */
    private String f1025b;

    /* renamed from: c */
    private long f1026c;

    /* renamed from: d */
    private JSONObject f1027d;

    /* renamed from: e */
    private Lifetime f1028e;

    /* renamed from: f */
    private GroupType f1029f;

    C3485e(String str, GroupType groupType, Lifetime lifetime, String str2, long j, String str3) {
        try {
            this.f1024a = str2;
            this.f1028e = lifetime;
            this.f1029f = groupType;
            this.f1026c = j;
            this.f1025b = str3;
            this.f1027d = new JSONObject(str);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    C3485e(String str, JSONObject jSONObject, GroupType groupType, Lifetime lifetime) {
        this.f1025b = C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, "");
        this.f1024a = str;
        this.f1026c = System.currentTimeMillis();
        this.f1028e = lifetime;
        this.f1029f = groupType;
        this.f1027d = jSONObject;
    }

    C3485e(JSONObject jSONObject, GroupType groupType, Lifetime lifetime, String str, String str2, long j) {
        try {
            this.f1024a = str;
            this.f1028e = lifetime;
            this.f1029f = groupType;
            this.f1026c = j;
            this.f1025b = str2;
            this.f1027d = jSONObject;
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo55320a() {
        return this.f1024a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55321a(String str) {
        this.f1025b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public GroupType mo55322b() {
        return this.f1029f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Lifetime mo55323c() {
        return this.f1028e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public JSONObject mo55324d() {
        return this.f1027d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo55325e() {
        return this.f1025b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public long mo55326f() {
        return this.f1026c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo55327g() {
        this.f1025b = C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, "");
        JSONObject jSONObject = this.f1027d;
        if (jSONObject != null) {
            try {
                jSONObject.put("sessionId", this.f1025b != null ? this.f1025b : JSONObject.NULL);
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public C3792y.C3793a getDataTableObjectType() {
        return C3792y.C3793a.AnalyticsData;
    }

    public String toJsonString() {
        try {
            return "{\"eventName\":" + C3770w2.m1830b(this.f1024a) + ",\"lifetime\":" + C3770w2.m1830b(this.f1028e.toString()) + ",\"groupType\":" + C3770w2.m1830b(this.f1029f.toString()) + ",\"timestamp\":" + this.f1026c + ",\"sessionId\":" + C3770w2.m1830b(this.f1025b) + ",\"payload\":" + this.f1027d.toString() + "}";
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(C3684q5.m1500a(this.f1026c));
        sb.append("]");
        JSONObject jSONObject = this.f1027d;
        sb.append(jSONObject != null ? jSONObject.toString() : "null");
        return sb.toString();
    }
}
