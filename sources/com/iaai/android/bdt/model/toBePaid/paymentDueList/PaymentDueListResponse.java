package com.iaai.android.bdt.model.toBePaid.paymentDueList;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDueListResponse;", "Landroid/os/Parcelable;", "ErrorMessage", "", "PaymentDueModel", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDueModel;", "(Ljava/lang/String;Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDueModel;)V", "getErrorMessage", "()Ljava/lang/String;", "getPaymentDueModel", "()Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDueModel;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: PaymentDueListResponse.kt */
public final class PaymentDueListResponse implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @NotNull
    private final String ErrorMessage;
    @NotNull
    private final PaymentDueModel PaymentDueModel;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new PaymentDueListResponse(parcel.readString(), (PaymentDueModel) PaymentDueModel.CREATOR.createFromParcel(parcel));
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new PaymentDueListResponse[i];
        }
    }

    @NotNull
    public static /* synthetic */ PaymentDueListResponse copy$default(PaymentDueListResponse paymentDueListResponse, String str, PaymentDueModel paymentDueModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentDueListResponse.ErrorMessage;
        }
        if ((i & 2) != 0) {
            paymentDueModel = paymentDueListResponse.PaymentDueModel;
        }
        return paymentDueListResponse.copy(str, paymentDueModel);
    }

    @NotNull
    public final String component1() {
        return this.ErrorMessage;
    }

    @NotNull
    public final PaymentDueModel component2() {
        return this.PaymentDueModel;
    }

    @NotNull
    public final PaymentDueListResponse copy(@NotNull String str, @NotNull PaymentDueModel paymentDueModel) {
        Intrinsics.checkParameterIsNotNull(str, "ErrorMessage");
        Intrinsics.checkParameterIsNotNull(paymentDueModel, "PaymentDueModel");
        return new PaymentDueListResponse(str, paymentDueModel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentDueListResponse)) {
            return false;
        }
        PaymentDueListResponse paymentDueListResponse = (PaymentDueListResponse) obj;
        return Intrinsics.areEqual((Object) this.ErrorMessage, (Object) paymentDueListResponse.ErrorMessage) && Intrinsics.areEqual((Object) this.PaymentDueModel, (Object) paymentDueListResponse.PaymentDueModel);
    }

    public int hashCode() {
        String str = this.ErrorMessage;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        PaymentDueModel paymentDueModel = this.PaymentDueModel;
        if (paymentDueModel != null) {
            i = paymentDueModel.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "PaymentDueListResponse(ErrorMessage=" + this.ErrorMessage + ", PaymentDueModel=" + this.PaymentDueModel + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.ErrorMessage);
        this.PaymentDueModel.writeToParcel(parcel, 0);
    }

    public PaymentDueListResponse(@NotNull String str, @NotNull PaymentDueModel paymentDueModel) {
        Intrinsics.checkParameterIsNotNull(str, "ErrorMessage");
        Intrinsics.checkParameterIsNotNull(paymentDueModel, "PaymentDueModel");
        this.ErrorMessage = str;
        this.PaymentDueModel = paymentDueModel;
    }

    @NotNull
    public final String getErrorMessage() {
        return this.ErrorMessage;
    }

    @NotNull
    public final PaymentDueModel getPaymentDueModel() {
        return this.PaymentDueModel;
    }
}
