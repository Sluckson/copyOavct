package com.iaai.android.bdt.model.toBePaid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/PayPalCheckOutResponse;", "", "TransactionId", "", "IsPaymentSuccess", "", "PayPalPaymentResponseText", "BuyerId", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getBuyerId", "()Ljava/lang/Integer;", "setBuyerId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIsPaymentSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPayPalPaymentResponseText", "()Ljava/lang/String;", "getTransactionId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/iaai/android/bdt/model/toBePaid/PayPalCheckOutResponse;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PayPalCheckOutResponse.kt */
public final class PayPalCheckOutResponse {
    @Nullable
    private Integer BuyerId;
    @Nullable
    private final Boolean IsPaymentSuccess;
    @Nullable
    private final String PayPalPaymentResponseText;
    @Nullable
    private final String TransactionId;

    @NotNull
    public static /* synthetic */ PayPalCheckOutResponse copy$default(PayPalCheckOutResponse payPalCheckOutResponse, String str, Boolean bool, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payPalCheckOutResponse.TransactionId;
        }
        if ((i & 2) != 0) {
            bool = payPalCheckOutResponse.IsPaymentSuccess;
        }
        if ((i & 4) != 0) {
            str2 = payPalCheckOutResponse.PayPalPaymentResponseText;
        }
        if ((i & 8) != 0) {
            num = payPalCheckOutResponse.BuyerId;
        }
        return payPalCheckOutResponse.copy(str, bool, str2, num);
    }

    @Nullable
    public final String component1() {
        return this.TransactionId;
    }

    @Nullable
    public final Boolean component2() {
        return this.IsPaymentSuccess;
    }

    @Nullable
    public final String component3() {
        return this.PayPalPaymentResponseText;
    }

    @Nullable
    public final Integer component4() {
        return this.BuyerId;
    }

    @NotNull
    public final PayPalCheckOutResponse copy(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable Integer num) {
        return new PayPalCheckOutResponse(str, bool, str2, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayPalCheckOutResponse)) {
            return false;
        }
        PayPalCheckOutResponse payPalCheckOutResponse = (PayPalCheckOutResponse) obj;
        return Intrinsics.areEqual((Object) this.TransactionId, (Object) payPalCheckOutResponse.TransactionId) && Intrinsics.areEqual((Object) this.IsPaymentSuccess, (Object) payPalCheckOutResponse.IsPaymentSuccess) && Intrinsics.areEqual((Object) this.PayPalPaymentResponseText, (Object) payPalCheckOutResponse.PayPalPaymentResponseText) && Intrinsics.areEqual((Object) this.BuyerId, (Object) payPalCheckOutResponse.BuyerId);
    }

    public int hashCode() {
        String str = this.TransactionId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.IsPaymentSuccess;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        String str2 = this.PayPalPaymentResponseText;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.BuyerId;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "PayPalCheckOutResponse(TransactionId=" + this.TransactionId + ", IsPaymentSuccess=" + this.IsPaymentSuccess + ", PayPalPaymentResponseText=" + this.PayPalPaymentResponseText + ", BuyerId=" + this.BuyerId + ")";
    }

    public PayPalCheckOutResponse(@Nullable String str, @Nullable Boolean bool, @Nullable String str2, @Nullable Integer num) {
        this.TransactionId = str;
        this.IsPaymentSuccess = bool;
        this.PayPalPaymentResponseText = str2;
        this.BuyerId = num;
    }

    @Nullable
    public final String getTransactionId() {
        return this.TransactionId;
    }

    @Nullable
    public final Boolean getIsPaymentSuccess() {
        return this.IsPaymentSuccess;
    }

    @Nullable
    public final String getPayPalPaymentResponseText() {
        return this.PayPalPaymentResponseText;
    }

    @Nullable
    public final Integer getBuyerId() {
        return this.BuyerId;
    }

    public final void setBuyerId(@Nullable Integer num) {
        this.BuyerId = num;
    }
}
