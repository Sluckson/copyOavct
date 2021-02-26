package com.salesforce.marketingcloud.analytics.p019b;

import com.salesforce.marketingcloud.analytics.p019b.C3896n;
import java.util.Date;

/* renamed from: com.salesforce.marketingcloud.analytics.b.b */
abstract class C3884b extends C3896n {

    /* renamed from: w */
    private final String f2283w;

    /* renamed from: x */
    private final String f2284x;

    /* renamed from: y */
    private final Date f2285y;

    /* renamed from: z */
    private final C3896n.C3897a f2286z;

    C3884b(String str, String str2, Date date, C3896n.C3897a aVar) {
        if (str != null) {
            this.f2283w = str;
            if (str2 != null) {
                this.f2284x = str2;
                if (date != null) {
                    this.f2285y = date;
                    if (aVar != null) {
                        this.f2286z = aVar;
                        return;
                    }
                    throw new NullPointerException("Null details");
                }
                throw new NullPointerException("Null timestamp");
            }
            throw new NullPointerException("Null eventName");
        }
        throw new NullPointerException("Null apiEndpoint");
    }

    /* renamed from: a */
    public String mo56263a() {
        return this.f2283w;
    }

    /* renamed from: b */
    public String mo56264b() {
        return this.f2284x;
    }

    /* renamed from: c */
    public Date mo56265c() {
        return this.f2285y;
    }

    /* renamed from: d */
    public C3896n.C3897a mo56269d() {
        return this.f2286z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3896n)) {
            return false;
        }
        C3896n nVar = (C3896n) obj;
        return this.f2283w.equals(nVar.mo56263a()) && this.f2284x.equals(nVar.mo56264b()) && this.f2285y.equals(nVar.mo56265c()) && this.f2286z.equals(nVar.mo56269d());
    }

    public int hashCode() {
        return ((((((this.f2283w.hashCode() ^ 1000003) * 1000003) ^ this.f2284x.hashCode()) * 1000003) ^ this.f2285y.hashCode()) * 1000003) ^ this.f2286z.hashCode();
    }

    public String toString() {
        return "PiOpenEvent{apiEndpoint=" + this.f2283w + ", eventName=" + this.f2284x + ", timestamp=" + this.f2285y + ", details=" + this.f2286z + "}";
    }
}
