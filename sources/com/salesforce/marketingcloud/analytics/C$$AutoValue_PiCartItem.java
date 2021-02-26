package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.MCKeep;

/* renamed from: com.salesforce.marketingcloud.analytics.$$AutoValue_PiCartItem  reason: invalid class name */
abstract class C$$AutoValue_PiCartItem extends PiCartItem {

    /* renamed from: a */
    private final String f2257a;

    /* renamed from: b */
    private final int f2258b;

    /* renamed from: c */
    private final double f2259c;

    /* renamed from: d */
    private final String f2260d;

    C$$AutoValue_PiCartItem(String str, int i, double d, @Nullable String str2) {
        if (str != null) {
            this.f2257a = str;
            this.f2258b = i;
            this.f2259c = d;
            this.f2260d = str2;
            return;
        }
        throw new NullPointerException("Null item");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PiCartItem)) {
            return false;
        }
        PiCartItem piCartItem = (PiCartItem) obj;
        if (this.f2257a.equals(piCartItem.item()) && this.f2258b == piCartItem.quantity() && Double.doubleToLongBits(this.f2259c) == Double.doubleToLongBits(piCartItem.price())) {
            String str = this.f2260d;
            if (str == null) {
                if (piCartItem.uniqueId() == null) {
                    return true;
                }
            } else if (str.equals(piCartItem.uniqueId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((this.f2257a.hashCode() ^ 1000003) * 1000003) ^ this.f2258b) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.f2259c) >>> 32) ^ Double.doubleToLongBits(this.f2259c)))) * 1000003;
        String str = this.f2260d;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    @NonNull
    @MCKeep
    public String item() {
        return this.f2257a;
    }

    @NonNull
    @MCKeep
    public double price() {
        return this.f2259c;
    }

    @NonNull
    @MCKeep
    public int quantity() {
        return this.f2258b;
    }

    public String toString() {
        return "PiCartItem{item=" + this.f2257a + ", quantity=" + this.f2258b + ", price=" + this.f2259c + ", uniqueId=" + this.f2260d + "}";
    }

    @Nullable
    @MCKeep
    public String uniqueId() {
        return this.f2260d;
    }
}
