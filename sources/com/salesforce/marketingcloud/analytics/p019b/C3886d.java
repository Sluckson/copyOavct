package com.salesforce.marketingcloud.analytics.p019b;

import com.salesforce.marketingcloud.analytics.PiCartItem;
import java.util.Date;
import java.util.List;

/* renamed from: com.salesforce.marketingcloud.analytics.b.d */
abstract class C3886d extends C3899o {

    /* renamed from: w */
    private final String f2289w;

    /* renamed from: x */
    private final Date f2290x;

    /* renamed from: y */
    private final List<PiCartItem> f2291y;

    C3886d(String str, Date date, List<PiCartItem> list) {
        if (str != null) {
            this.f2289w = str;
            if (date != null) {
                this.f2290x = date;
                if (list != null) {
                    this.f2291y = list;
                    return;
                }
                throw new NullPointerException("Null cartItems");
            }
            throw new NullPointerException("Null timestamp");
        }
        throw new NullPointerException("Null apiEndpoint");
    }

    /* renamed from: a */
    public String mo56263a() {
        return this.f2289w;
    }

    /* renamed from: c */
    public Date mo56265c() {
        return this.f2290x;
    }

    /* renamed from: d */
    public List<PiCartItem> mo56278d() {
        return this.f2291y;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3899o)) {
            return false;
        }
        C3899o oVar = (C3899o) obj;
        return this.f2289w.equals(oVar.mo56263a()) && this.f2290x.equals(oVar.mo56265c()) && this.f2291y.equals(oVar.mo56278d());
    }

    public int hashCode() {
        return ((((this.f2289w.hashCode() ^ 1000003) * 1000003) ^ this.f2290x.hashCode()) * 1000003) ^ this.f2291y.hashCode();
    }

    public String toString() {
        return "PiTrackCartContentsEvent{apiEndpoint=" + this.f2289w + ", timestamp=" + this.f2290x + ", cartItems=" + this.f2291y + "}";
    }
}
