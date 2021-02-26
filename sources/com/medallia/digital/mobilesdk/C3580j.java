package com.medallia.digital.mobilesdk;

import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.j */
class C3580j extends C3751u2 {

    /* renamed from: b */
    private long f1311b;

    /* renamed from: c */
    private String f1312c;

    protected C3580j(String str) {
        super(str);
        try {
            JSONObject jSONObject = new JSONObject(C3762v2.m1786c(str));
            if (jSONObject.has("propertyId") && !jSONObject.isNull("propertyId")) {
                this.f1311b = jSONObject.getLong("propertyId");
            }
            if (jSONObject.has("authUrl") && !jSONObject.isNull("authUrl")) {
                this.f1312c = jSONObject.getString("authUrl");
            }
        } catch (Exception unused) {
        }
    }

    protected C3580j(String str, long j, String str2) {
        super(str);
        this.f1311b = j;
        this.f1312c = str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo55489b() {
        return this.f1312c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public long mo55490c() {
        return this.f1311b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3580j.class != obj.getClass() || !(obj instanceof C3580j)) {
            return false;
        }
        String a = mo55850a();
        return a != null ? a.equals(((C3580j) obj).mo55850a()) : ((C3580j) obj).mo55850a() == null;
    }

    public int hashCode() {
        if (mo55850a() != null) {
            return mo55850a().hashCode();
        }
        return 0;
    }
}
