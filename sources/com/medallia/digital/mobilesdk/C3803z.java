package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3792y;
import com.medallia.digital.mobilesdk.C3815z4;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.medallia.digital.mobilesdk.z */
class C3803z extends C3792y {

    /* renamed from: i */
    private static final int f2066i = 6;

    /* renamed from: a */
    private String f2067a;

    /* renamed from: b */
    private Object f2068b;

    /* renamed from: c */
    private ValueType f2069c;

    /* renamed from: d */
    private Lifetime f2070d;

    /* renamed from: e */
    private GroupType f2071e;

    /* renamed from: f */
    private String f2072f;

    /* renamed from: g */
    private long f2073g;

    /* renamed from: h */
    private JSONObject f2074h;

    protected C3803z() {
    }

    protected C3803z(Object obj, GroupType groupType, Lifetime lifetime, ValueType valueType, String str) {
        try {
            this.f2072f = C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, "");
            this.f2073g = System.currentTimeMillis();
            this.f2067a = str;
            this.f2068b = obj != null ? obj.toString() : null;
            this.f2069c = valueType;
            this.f2070d = lifetime;
            this.f2071e = groupType;
            m1956l();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    protected C3803z(Object obj, GroupType groupType, Lifetime lifetime, ValueType valueType, String str, long j, String str2) {
        try {
            this.f2072f = str2;
            this.f2073g = j;
            this.f2067a = str;
            this.f2068b = obj != null ? obj.toString() : null;
            this.f2069c = valueType;
            this.f2070d = lifetime;
            this.f2071e = groupType;
            m1956l();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    protected C3803z(JSONObject jSONObject, GroupType groupType, Lifetime lifetime, String str) {
        try {
            this.f2072f = C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, "");
            this.f2073g = System.currentTimeMillis();
            this.f2067a = str;
            ValueType valueType = null;
            this.f2068b = jSONObject != null ? jSONObject.toString() : null;
            if (this.f2068b != null) {
                valueType = ValueType.TypeString;
            }
            this.f2069c = valueType;
            this.f2070d = lifetime;
            this.f2071e = groupType;
            m1956l();
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* renamed from: a */
    private String m1955a(Object obj) {
        return "[" + obj + "]";
    }

    /* renamed from: l */
    private void m1956l() {
        this.f2074h = new JSONObject();
        this.f2074h.put("sessionId", C3770w2.m1827a((Object) this.f2072f));
        this.f2074h.put("value", C3770w2.m1827a(this.f2068b));
        this.f2074h.put("name", C3770w2.m1827a((Object) this.f2067a));
        this.f2074h.put("valueType", C3770w2.m1827a((Object) this.f2069c));
        this.f2074h.put("lifetime", C3770w2.m1827a((Object) this.f2070d));
        this.f2074h.put("groupType", C3770w2.m1827a((Object) this.f2071e));
        this.f2074h.put("timestamp", C3770w2.m1827a((Object) Long.valueOf(this.f2073g)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo55935a() {
        return m1955a(Long.valueOf(mo55943h())) + m1955a(mo55941g()) + m1955a(getName()) + "=" + m1955a(mo55944i()) + "\n";
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo55936b() {
        return m1955a(C3684q5.m1502b(mo55943h())) + m1955a(Long.valueOf(mo55943h())) + m1955a(mo55941g().substring(0, 6) + "..") + m1955a(getName()) + "=" + m1955a(mo55944i()) + "\n";
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo55937c() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public JSONObject mo55938d() {
        return this.f2074h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public GroupType mo55939e() {
        return this.f2071e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Lifetime mo55940f() {
        return this.f2070d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public String mo55941g() {
        return this.f2072f;
    }

    /* access modifiers changed from: protected */
    public C3792y.C3793a getDataTableObjectType() {
        return C3792y.C3793a.UserJourneyData;
    }

    /* access modifiers changed from: protected */
    public String getName() {
        return this.f2067a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public long mo55943h() {
        return this.f2073g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public Object mo55944i() {
        return this.f2068b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public ValueType mo55945j() {
        return this.f2069c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public void mo55946k() {
        this.f2072f = C3815z4.m2010d().mo55975a(C3815z4.C3816a.SESSION_ID, "");
        JSONObject jSONObject = this.f2074h;
        if (jSONObject != null) {
            try {
                jSONObject.put("sessionId", this.f2072f != null ? this.f2072f : JSONObject.NULL);
            } catch (JSONException e) {
                C3490e3.m663c(e.getMessage());
            }
        }
    }

    public String toString() {
        return "[" + C3684q5.m1500a(this.f2073g) + "]" + this.f2074h.toString();
    }
}
