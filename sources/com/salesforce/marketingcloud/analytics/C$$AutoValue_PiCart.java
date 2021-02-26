package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;
import com.salesforce.marketingcloud.MCKeep;
import java.util.List;

/* renamed from: com.salesforce.marketingcloud.analytics.$$AutoValue_PiCart  reason: invalid class name */
abstract class C$$AutoValue_PiCart extends PiCart {

    /* renamed from: a */
    private final List<PiCartItem> f2256a;

    C$$AutoValue_PiCart(List<PiCartItem> list) {
        if (list != null) {
            this.f2256a = list;
            return;
        }
        throw new NullPointerException("Null cartItems");
    }

    @NonNull
    @MCKeep
    public List<PiCartItem> cartItems() {
        return this.f2256a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PiCart) {
            return this.f2256a.equals(((PiCart) obj).cartItems());
        }
        return false;
    }

    public int hashCode() {
        return this.f2256a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "PiCart{cartItems=" + this.f2256a + "}";
    }
}
