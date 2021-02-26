package com.iaai.android.bdt.model.toBePaid.paymentDueList;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/ActiveCCAccountDetails;", "Landroid/os/Parcelable;", "CardExp", "", "CardNumber", "(Ljava/lang/String;Ljava/lang/String;)V", "getCardExp", "()Ljava/lang/String;", "getCardNumber", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: ActiveCCAccountDetails.kt */
public final class ActiveCCAccountDetails implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @NotNull
    private final String CardExp;
    @NotNull
    private final String CardNumber;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new ActiveCCAccountDetails(parcel.readString(), parcel.readString());
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new ActiveCCAccountDetails[i];
        }
    }

    @NotNull
    public static /* synthetic */ ActiveCCAccountDetails copy$default(ActiveCCAccountDetails activeCCAccountDetails, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = activeCCAccountDetails.CardExp;
        }
        if ((i & 2) != 0) {
            str2 = activeCCAccountDetails.CardNumber;
        }
        return activeCCAccountDetails.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.CardExp;
    }

    @NotNull
    public final String component2() {
        return this.CardNumber;
    }

    @NotNull
    public final ActiveCCAccountDetails copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "CardExp");
        Intrinsics.checkParameterIsNotNull(str2, "CardNumber");
        return new ActiveCCAccountDetails(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActiveCCAccountDetails)) {
            return false;
        }
        ActiveCCAccountDetails activeCCAccountDetails = (ActiveCCAccountDetails) obj;
        return Intrinsics.areEqual((Object) this.CardExp, (Object) activeCCAccountDetails.CardExp) && Intrinsics.areEqual((Object) this.CardNumber, (Object) activeCCAccountDetails.CardNumber);
    }

    public int hashCode() {
        String str = this.CardExp;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.CardNumber;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "ActiveCCAccountDetails(CardExp=" + this.CardExp + ", CardNumber=" + this.CardNumber + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.CardExp);
        parcel.writeString(this.CardNumber);
    }

    public ActiveCCAccountDetails(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "CardExp");
        Intrinsics.checkParameterIsNotNull(str2, "CardNumber");
        this.CardExp = str;
        this.CardNumber = str2;
    }

    @NotNull
    public final String getCardExp() {
        return this.CardExp;
    }

    @NotNull
    public final String getCardNumber() {
        return this.CardNumber;
    }
}
