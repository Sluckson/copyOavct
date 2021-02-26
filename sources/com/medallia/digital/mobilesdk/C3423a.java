package com.medallia.digital.mobilesdk;

import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.a */
class C3423a extends C3751u2 {

    /* renamed from: b */
    private String f853b;

    /* renamed from: c */
    private long f854c;

    /* renamed from: d */
    private long f855d;

    /* renamed from: e */
    private long f856e;

    protected C3423a(String str) {
        super(str);
        try {
            JSONObject jSONObject = new JSONObject(C3762v2.m1786c(str));
            if (jSONObject.has("getConfigUrl") && !jSONObject.isNull("getConfigUrl")) {
                this.f853b = jSONObject.getString("getConfigUrl");
            }
            if (jSONObject.has("createTime") && !jSONObject.isNull("createTime")) {
                this.f855d = jSONObject.getLong("createTime");
            }
            if (jSONObject.has("ttl") && !jSONObject.isNull("ttl")) {
                this.f856e = jSONObject.getLong("ttl");
            }
            if (jSONObject.has("propertyId") && !jSONObject.isNull("propertyId")) {
                this.f854c = jSONObject.getLong("propertyId");
            }
        } catch (Exception unused) {
        }
    }

    protected C3423a(String str, String str2, long j, long j2, long j3) {
        super(str);
        this.f853b = str2;
        this.f854c = j;
        this.f855d = j2;
        this.f856e = j3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55171a(long j) {
        this.f854c = j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public long mo55172b() {
        return this.f855d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo55173c() {
        return this.f853b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public long mo55174d() {
        return this.f854c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public long mo55175e() {
        return this.f856e;
    }
}
