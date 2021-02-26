package com.salesforce.marketingcloud.analytics.p019b;

import java.util.Date;

/* renamed from: com.salesforce.marketingcloud.analytics.b.a */
abstract class C3883a extends C3894l {

    /* renamed from: w */
    private final String f2280w;

    /* renamed from: x */
    private final String f2281x;

    /* renamed from: y */
    private final Date f2282y;

    C3883a(String str, String str2, Date date) {
        if (str != null) {
            this.f2280w = str;
            if (str2 != null) {
                this.f2281x = str2;
                if (date != null) {
                    this.f2282y = date;
                    return;
                }
                throw new NullPointerException("Null timestamp");
            }
            throw new NullPointerException("Null eventName");
        }
        throw new NullPointerException("Null apiEndpoint");
    }

    /* renamed from: a */
    public String mo56263a() {
        return this.f2280w;
    }

    /* renamed from: b */
    public String mo56264b() {
        return this.f2281x;
    }

    /* renamed from: c */
    public Date mo56265c() {
        return this.f2282y;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3894l)) {
            return false;
        }
        C3894l lVar = (C3894l) obj;
        return this.f2280w.equals(lVar.mo56263a()) && this.f2281x.equals(lVar.mo56264b()) && this.f2282y.equals(lVar.mo56265c());
    }

    public int hashCode() {
        return ((((this.f2280w.hashCode() ^ 1000003) * 1000003) ^ this.f2281x.hashCode()) * 1000003) ^ this.f2282y.hashCode();
    }

    public String toString() {
        return "PiCloseEvent{apiEndpoint=" + this.f2280w + ", eventName=" + this.f2281x + ", timestamp=" + this.f2282y + "}";
    }
}
