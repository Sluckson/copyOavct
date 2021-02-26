package com.iaai.android.bdt.model.toBePaid;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006&"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;", "Landroid/os/Parcelable;", "PayPalCustomerID", "", "PaymentCode", "PaymentMethodNonce", "Amount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)V", "getAmount", "()Ljava/lang/Double;", "setAmount", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getPayPalCustomerID", "()Ljava/lang/String;", "getPaymentCode", "getPaymentMethodNonce", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;)Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: PayPalPaymentRequest.kt */
public final class PayPalPaymentRequest implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DiffUtil.ItemCallback<PayPalPaymentRequest> DIFF_CALLBACK = new PayPalPaymentRequest$Companion$DIFF_CALLBACK$1();
    @Nullable
    private Double Amount;
    @Nullable
    private final String PayPalCustomerID;
    @Nullable
    private final String PaymentCode;
    @Nullable
    private final String PaymentMethodNonce;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new PayPalPaymentRequest(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new PayPalPaymentRequest[i];
        }
    }

    @NotNull
    public static /* synthetic */ PayPalPaymentRequest copy$default(PayPalPaymentRequest payPalPaymentRequest, String str, String str2, String str3, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = payPalPaymentRequest.PayPalCustomerID;
        }
        if ((i & 2) != 0) {
            str2 = payPalPaymentRequest.PaymentCode;
        }
        if ((i & 4) != 0) {
            str3 = payPalPaymentRequest.PaymentMethodNonce;
        }
        if ((i & 8) != 0) {
            d = payPalPaymentRequest.Amount;
        }
        return payPalPaymentRequest.copy(str, str2, str3, d);
    }

    @Nullable
    public final String component1() {
        return this.PayPalCustomerID;
    }

    @Nullable
    public final String component2() {
        return this.PaymentCode;
    }

    @Nullable
    public final String component3() {
        return this.PaymentMethodNonce;
    }

    @Nullable
    public final Double component4() {
        return this.Amount;
    }

    @NotNull
    public final PayPalPaymentRequest copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Double d) {
        return new PayPalPaymentRequest(str, str2, str3, d);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayPalPaymentRequest)) {
            return false;
        }
        PayPalPaymentRequest payPalPaymentRequest = (PayPalPaymentRequest) obj;
        return Intrinsics.areEqual((Object) this.PayPalCustomerID, (Object) payPalPaymentRequest.PayPalCustomerID) && Intrinsics.areEqual((Object) this.PaymentCode, (Object) payPalPaymentRequest.PaymentCode) && Intrinsics.areEqual((Object) this.PaymentMethodNonce, (Object) payPalPaymentRequest.PaymentMethodNonce) && Intrinsics.areEqual((Object) this.Amount, (Object) payPalPaymentRequest.Amount);
    }

    public int hashCode() {
        String str = this.PayPalCustomerID;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.PaymentCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.PaymentMethodNonce;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Double d = this.Amount;
        if (d != null) {
            i = d.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "PayPalPaymentRequest(PayPalCustomerID=" + this.PayPalCustomerID + ", PaymentCode=" + this.PaymentCode + ", PaymentMethodNonce=" + this.PaymentMethodNonce + ", Amount=" + this.Amount + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.PayPalCustomerID);
        parcel.writeString(this.PaymentCode);
        parcel.writeString(this.PaymentMethodNonce);
        Double d = this.Amount;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
            return;
        }
        parcel.writeInt(0);
    }

    public PayPalPaymentRequest(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Double d) {
        this.PayPalCustomerID = str;
        this.PaymentCode = str2;
        this.PaymentMethodNonce = str3;
        this.Amount = d;
    }

    @Nullable
    public final String getPayPalCustomerID() {
        return this.PayPalCustomerID;
    }

    @Nullable
    public final String getPaymentCode() {
        return this.PaymentCode;
    }

    @Nullable
    public final String getPaymentMethodNonce() {
        return this.PaymentMethodNonce;
    }

    @Nullable
    public final Double getAmount() {
        return this.Amount;
    }

    public final void setAmount(@Nullable Double d) {
        this.Amount = d;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;", "getDIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDIFF_CALLBACK", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PayPalPaymentRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<PayPalPaymentRequest> getDIFF_CALLBACK() {
            return PayPalPaymentRequest.DIFF_CALLBACK;
        }

        public final void setDIFF_CALLBACK(@NotNull DiffUtil.ItemCallback<PayPalPaymentRequest> itemCallback) {
            Intrinsics.checkParameterIsNotNull(itemCallback, "<set-?>");
            PayPalPaymentRequest.DIFF_CALLBACK = itemCallback;
        }
    }
}
