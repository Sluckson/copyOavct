package com.salesforce.marketingcloud.messages;

/* renamed from: com.salesforce.marketingcloud.messages.d */
final class C4078d extends C4083g {

    /* renamed from: a */
    private final String f3099a;

    /* renamed from: b */
    private final String f3100b;

    C4078d(String str, String str2) {
        if (str != null) {
            this.f3099a = str;
            if (str2 != null) {
                this.f3100b = str2;
                return;
            }
            throw new NullPointerException("Null messageId");
        }
        throw new NullPointerException("Null regionId");
    }

    /* renamed from: a */
    public String mo56709a() {
        return this.f3099a;
    }

    /* renamed from: b */
    public String mo56710b() {
        return this.f3100b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4083g)) {
            return false;
        }
        C4083g gVar = (C4083g) obj;
        return this.f3099a.equals(gVar.mo56709a()) && this.f3100b.equals(gVar.mo56710b());
    }

    public int hashCode() {
        return ((this.f3099a.hashCode() ^ 1000003) * 1000003) ^ this.f3100b.hashCode();
    }

    public String toString() {
        return "RegionMessage{regionId=" + this.f3099a + ", messageId=" + this.f3100b + "}";
    }
}
