package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.MCKeep;

/* renamed from: com.salesforce.marketingcloud.analytics.$$AutoValue_PiOrder  reason: invalid class name */
abstract class C$$AutoValue_PiOrder extends PiOrder {

    /* renamed from: a */
    private final PiCart f2261a;

    /* renamed from: b */
    private final String f2262b;

    /* renamed from: c */
    private final double f2263c;

    /* renamed from: d */
    private final double f2264d;

    C$$AutoValue_PiOrder(PiCart piCart, String str, double d, double d2) {
        if (piCart != null) {
            this.f2261a = piCart;
            if (str != null) {
                this.f2262b = str;
                this.f2263c = d;
                this.f2264d = d2;
                return;
            }
            throw new NullPointerException("Null orderNumber");
        }
        throw new NullPointerException("Null cart");
    }

    @NonNull
    @MCKeep
    public PiCart cart() {
        return this.f2261a;
    }

    @MCKeep
    public double discount() {
        return this.f2264d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PiOrder)) {
            return false;
        }
        PiOrder piOrder = (PiOrder) obj;
        return this.f2261a.equals(piOrder.cart()) && this.f2262b.equals(piOrder.orderNumber()) && Double.doubleToLongBits(this.f2263c) == Double.doubleToLongBits(piOrder.shipping()) && Double.doubleToLongBits(this.f2264d) == Double.doubleToLongBits(piOrder.discount());
    }

    public int hashCode() {
        return ((((((this.f2261a.hashCode() ^ 1000003) * 1000003) ^ this.f2262b.hashCode()) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2263c) >>> 32) ^ Double.doubleToLongBits(this.f2263c)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2264d) >>> 32) ^ Double.doubleToLongBits(this.f2264d)));
    }

    @NonNull
    @MCKeep
    public String orderNumber() {
        return this.f2262b;
    }

    @MCKeep
    public double shipping() {
        return this.f2263c;
    }

    public String toString() {
        return "PiOrder{cart=" + this.f2261a + ", orderNumber=" + this.f2262b + ", shipping=" + this.f2263c + ", discount=" + this.f2264d + "}";
    }
}
