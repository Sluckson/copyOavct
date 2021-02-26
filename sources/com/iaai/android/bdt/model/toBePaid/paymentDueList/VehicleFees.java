package com.iaai.android.bdt.model.toBePaid.paymentDueList;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/VehicleFees;", "Landroid/os/Parcelable;", "displayText", "", "amount", "", "(Ljava/lang/String;Ljava/lang/Double;)V", "getAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDisplayText", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Double;)Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/VehicleFees;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: VehicleFees.kt */
public final class VehicleFees implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @Nullable
    private final Double amount;
    @NotNull
    private final String displayText;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new VehicleFees(parcel.readString(), parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new VehicleFees[i];
        }
    }

    @NotNull
    public static /* synthetic */ VehicleFees copy$default(VehicleFees vehicleFees, String str, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vehicleFees.displayText;
        }
        if ((i & 2) != 0) {
            d = vehicleFees.amount;
        }
        return vehicleFees.copy(str, d);
    }

    @NotNull
    public final String component1() {
        return this.displayText;
    }

    @Nullable
    public final Double component2() {
        return this.amount;
    }

    @NotNull
    public final VehicleFees copy(@NotNull String str, @Nullable Double d) {
        Intrinsics.checkParameterIsNotNull(str, "displayText");
        return new VehicleFees(str, d);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VehicleFees)) {
            return false;
        }
        VehicleFees vehicleFees = (VehicleFees) obj;
        return Intrinsics.areEqual((Object) this.displayText, (Object) vehicleFees.displayText) && Intrinsics.areEqual((Object) this.amount, (Object) vehicleFees.amount);
    }

    public int hashCode() {
        String str = this.displayText;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Double d = this.amount;
        if (d != null) {
            i = d.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "VehicleFees(displayText=" + this.displayText + ", amount=" + this.amount + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.displayText);
        Double d = this.amount;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
            return;
        }
        parcel.writeInt(0);
    }

    public VehicleFees(@NotNull String str, @Nullable Double d) {
        Intrinsics.checkParameterIsNotNull(str, "displayText");
        this.displayText = str;
        this.amount = d;
    }

    @NotNull
    public final String getDisplayText() {
        return this.displayText;
    }

    @Nullable
    public final Double getAmount() {
        return this.amount;
    }
}
