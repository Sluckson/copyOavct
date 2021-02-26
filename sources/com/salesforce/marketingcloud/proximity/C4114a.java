package com.salesforce.marketingcloud.proximity;

/* renamed from: com.salesforce.marketingcloud.proximity.a */
abstract class C4114a extends C4122e {

    /* renamed from: a */
    private final String f3327a;

    /* renamed from: b */
    private final String f3328b;

    /* renamed from: c */
    private final int f3329c;

    /* renamed from: d */
    private final int f3330d;

    C4114a(String str, String str2, int i, int i2) {
        if (str != null) {
            this.f3327a = str;
            if (str2 != null) {
                this.f3328b = str2;
                this.f3329c = i;
                this.f3330d = i2;
                return;
            }
            throw new NullPointerException("Null guid");
        }
        throw new NullPointerException("Null id");
    }

    /* renamed from: a */
    public String mo56901a() {
        return this.f3327a;
    }

    /* renamed from: b */
    public String mo56902b() {
        return this.f3328b;
    }

    /* renamed from: c */
    public int mo56903c() {
        return this.f3329c;
    }

    /* renamed from: d */
    public int mo56904d() {
        return this.f3330d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4122e)) {
            return false;
        }
        C4122e eVar = (C4122e) obj;
        return this.f3327a.equals(eVar.mo56901a()) && this.f3328b.equals(eVar.mo56902b()) && this.f3329c == eVar.mo56903c() && this.f3330d == eVar.mo56904d();
    }

    public int hashCode() {
        return ((((((this.f3327a.hashCode() ^ 1000003) * 1000003) ^ this.f3328b.hashCode()) * 1000003) ^ this.f3329c) * 1000003) ^ this.f3330d;
    }

    public String toString() {
        return "BeaconRegion{id=" + this.f3327a + ", guid=" + this.f3328b + ", major=" + this.f3329c + ", minor=" + this.f3330d + "}";
    }
}
