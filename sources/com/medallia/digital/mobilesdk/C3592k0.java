package com.medallia.digital.mobilesdk;

import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.k0 */
class C3592k0 {

    /* renamed from: a */
    private String f1371a;

    /* renamed from: b */
    private HashMap<String, String> f1372b;

    /* renamed from: c */
    private HashMap<String, String> f1373c;

    /* renamed from: d */
    private JSONObject f1374d;

    /* renamed from: e */
    private String f1375e = null;

    C3592k0() {
    }

    C3592k0(String str) {
        this.f1371a = str;
    }

    C3592k0(String str, HashMap<String, String> hashMap) {
        this.f1371a = str;
        this.f1372b = hashMap;
    }

    C3592k0(String str, HashMap<String, String> hashMap, String str2) {
        this.f1371a = str;
        this.f1372b = hashMap;
        this.f1375e = str2;
    }

    C3592k0(String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2, JSONObject jSONObject) {
        this.f1371a = str;
        this.f1372b = hashMap;
        this.f1373c = hashMap2;
        this.f1374d = jSONObject;
    }

    C3592k0(String str, HashMap<String, String> hashMap, JSONObject jSONObject) {
        this.f1371a = str;
        this.f1372b = hashMap;
        this.f1374d = jSONObject;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo55506a() {
        return this.f1374d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public HashMap<String, String> mo55507b() {
        return this.f1372b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public HashMap<String, String> mo55508c() {
        return this.f1373c;
    }

    /* renamed from: d */
    public String mo55509d() {
        return this.f1375e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public String mo55510e() {
        return this.f1371a;
    }
}
