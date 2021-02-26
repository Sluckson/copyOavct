package com.iaai.android.bdt.model.toBePaid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/PayPalCreateCustomerResponse;", "", "IsCustomerCreated", "", "CustomerCreateResponseText", "", "(ZLjava/lang/String;)V", "getCustomerCreateResponseText", "()Ljava/lang/String;", "getIsCustomerCreated", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PayPalCreateCustomerResponse.kt */
public final class PayPalCreateCustomerResponse {
    @NotNull
    private final String CustomerCreateResponseText;
    private final boolean IsCustomerCreated;

    @NotNull
    public static /* synthetic */ PayPalCreateCustomerResponse copy$default(PayPalCreateCustomerResponse payPalCreateCustomerResponse, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = payPalCreateCustomerResponse.IsCustomerCreated;
        }
        if ((i & 2) != 0) {
            str = payPalCreateCustomerResponse.CustomerCreateResponseText;
        }
        return payPalCreateCustomerResponse.copy(z, str);
    }

    public final boolean component1() {
        return this.IsCustomerCreated;
    }

    @NotNull
    public final String component2() {
        return this.CustomerCreateResponseText;
    }

    @NotNull
    public final PayPalCreateCustomerResponse copy(boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "CustomerCreateResponseText");
        return new PayPalCreateCustomerResponse(z, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PayPalCreateCustomerResponse) {
                PayPalCreateCustomerResponse payPalCreateCustomerResponse = (PayPalCreateCustomerResponse) obj;
                if (!(this.IsCustomerCreated == payPalCreateCustomerResponse.IsCustomerCreated) || !Intrinsics.areEqual((Object) this.CustomerCreateResponseText, (Object) payPalCreateCustomerResponse.CustomerCreateResponseText)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.IsCustomerCreated;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.CustomerCreateResponseText;
        return i + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PayPalCreateCustomerResponse(IsCustomerCreated=" + this.IsCustomerCreated + ", CustomerCreateResponseText=" + this.CustomerCreateResponseText + ")";
    }

    public PayPalCreateCustomerResponse(boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "CustomerCreateResponseText");
        this.IsCustomerCreated = z;
        this.CustomerCreateResponseText = str;
    }

    public final boolean getIsCustomerCreated() {
        return this.IsCustomerCreated;
    }

    @NotNull
    public final String getCustomerCreateResponseText() {
        return this.CustomerCreateResponseText;
    }
}
