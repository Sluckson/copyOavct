package com.salesforce.marketingcloud.analytics.p019b;

import com.salesforce.marketingcloud.analytics.PiCart;
import java.util.Date;

/* renamed from: com.salesforce.marketingcloud.analytics.b.e */
abstract class C3887e extends C3901p {

    /* renamed from: A */
    private final double f2292A;

    /* renamed from: B */
    private final double f2293B;

    /* renamed from: w */
    private final String f2294w;

    /* renamed from: x */
    private final Date f2295x;

    /* renamed from: y */
    private final PiCart f2296y;

    /* renamed from: z */
    private final String f2297z;

    C3887e(String str, Date date, PiCart piCart, String str2, double d, double d2) {
        if (str != null) {
            this.f2294w = str;
            if (date != null) {
                this.f2295x = date;
                if (piCart != null) {
                    this.f2296y = piCart;
                    if (str2 != null) {
                        this.f2297z = str2;
                        this.f2292A = d;
                        this.f2293B = d2;
                        return;
                    }
                    throw new NullPointerException("Null orderNumber");
                }
                throw new NullPointerException("Null cart");
            }
            throw new NullPointerException("Null timestamp");
        }
        throw new NullPointerException("Null apiEndpoint");
    }

    /* renamed from: a */
    public String mo56263a() {
        return this.f2294w;
    }

    /* renamed from: b_ */
    public String mo56282b_() {
        return this.f2297z;
    }

    /* renamed from: c */
    public Date mo56265c() {
        return this.f2295x;
    }

    /* renamed from: d */
    public PiCart mo56283d() {
        return this.f2296y;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3901p)) {
            return false;
        }
        C3901p pVar = (C3901p) obj;
        return this.f2294w.equals(pVar.mo56263a()) && this.f2295x.equals(pVar.mo56265c()) && this.f2296y.equals(pVar.mo56283d()) && this.f2297z.equals(pVar.mo56282b_()) && Double.doubleToLongBits(this.f2292A) == Double.doubleToLongBits(pVar.mo56285f()) && Double.doubleToLongBits(this.f2293B) == Double.doubleToLongBits(pVar.mo56286g());
    }

    /* renamed from: f */
    public double mo56285f() {
        return this.f2292A;
    }

    /* renamed from: g */
    public double mo56286g() {
        return this.f2293B;
    }

    public int hashCode() {
        return ((((((((((this.f2294w.hashCode() ^ 1000003) * 1000003) ^ this.f2295x.hashCode()) * 1000003) ^ this.f2296y.hashCode()) * 1000003) ^ this.f2297z.hashCode()) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2292A) >>> 32) ^ Double.doubleToLongBits(this.f2292A)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2293B) >>> 32) ^ Double.doubleToLongBits(this.f2293B)));
    }

    public String toString() {
        return "PiTrackConversionEvent{apiEndpoint=" + this.f2294w + ", timestamp=" + this.f2295x + ", cart=" + this.f2296y + ", orderNumber=" + this.f2297z + ", shipping=" + this.f2292A + ", discount=" + this.f2293B + "}";
    }
}
