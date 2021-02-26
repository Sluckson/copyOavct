package com.iaai.android.bdt.model.toBePaid.paymentDueList;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsIpayEligibleAndDailyAllowance;", "Landroid/os/Parcelable;", "AllowanceUsedIPay", "", "DailyAllowanceIPay", "IsIPayEligible", "", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;)V", "getAllowanceUsedIPay", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDailyAllowanceIPay", "getIsIPayEligible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;)Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsIpayEligibleAndDailyAllowance;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: IsIpayEligibleAndDailyAllowance.kt */
public final class IsIpayEligibleAndDailyAllowance implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @Nullable
    private final Double AllowanceUsedIPay;
    @Nullable
    private final Double DailyAllowanceIPay;
    @Nullable
    private final Boolean IsIPayEligible;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            Boolean bool = null;
            Double valueOf = parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null;
            Double valueOf2 = parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new IsIpayEligibleAndDailyAllowance(valueOf, valueOf2, bool);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new IsIpayEligibleAndDailyAllowance[i];
        }
    }

    @NotNull
    public static /* synthetic */ IsIpayEligibleAndDailyAllowance copy$default(IsIpayEligibleAndDailyAllowance isIpayEligibleAndDailyAllowance, Double d, Double d2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            d = isIpayEligibleAndDailyAllowance.AllowanceUsedIPay;
        }
        if ((i & 2) != 0) {
            d2 = isIpayEligibleAndDailyAllowance.DailyAllowanceIPay;
        }
        if ((i & 4) != 0) {
            bool = isIpayEligibleAndDailyAllowance.IsIPayEligible;
        }
        return isIpayEligibleAndDailyAllowance.copy(d, d2, bool);
    }

    @Nullable
    public final Double component1() {
        return this.AllowanceUsedIPay;
    }

    @Nullable
    public final Double component2() {
        return this.DailyAllowanceIPay;
    }

    @Nullable
    public final Boolean component3() {
        return this.IsIPayEligible;
    }

    @NotNull
    public final IsIpayEligibleAndDailyAllowance copy(@Nullable Double d, @Nullable Double d2, @Nullable Boolean bool) {
        return new IsIpayEligibleAndDailyAllowance(d, d2, bool);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IsIpayEligibleAndDailyAllowance)) {
            return false;
        }
        IsIpayEligibleAndDailyAllowance isIpayEligibleAndDailyAllowance = (IsIpayEligibleAndDailyAllowance) obj;
        return Intrinsics.areEqual((Object) this.AllowanceUsedIPay, (Object) isIpayEligibleAndDailyAllowance.AllowanceUsedIPay) && Intrinsics.areEqual((Object) this.DailyAllowanceIPay, (Object) isIpayEligibleAndDailyAllowance.DailyAllowanceIPay) && Intrinsics.areEqual((Object) this.IsIPayEligible, (Object) isIpayEligibleAndDailyAllowance.IsIPayEligible);
    }

    public int hashCode() {
        Double d = this.AllowanceUsedIPay;
        int i = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 31;
        Double d2 = this.DailyAllowanceIPay;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
        Boolean bool = this.IsIPayEligible;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "IsIpayEligibleAndDailyAllowance(AllowanceUsedIPay=" + this.AllowanceUsedIPay + ", DailyAllowanceIPay=" + this.DailyAllowanceIPay + ", IsIPayEligible=" + this.IsIPayEligible + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Double d = this.AllowanceUsedIPay;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        Double d2 = this.DailyAllowanceIPay;
        if (d2 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d2.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.IsIPayEligible;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
            return;
        }
        parcel.writeInt(0);
    }

    public IsIpayEligibleAndDailyAllowance(@Nullable Double d, @Nullable Double d2, @Nullable Boolean bool) {
        this.AllowanceUsedIPay = d;
        this.DailyAllowanceIPay = d2;
        this.IsIPayEligible = bool;
    }

    @Nullable
    public final Double getAllowanceUsedIPay() {
        return this.AllowanceUsedIPay;
    }

    @Nullable
    public final Double getDailyAllowanceIPay() {
        return this.DailyAllowanceIPay;
    }

    @Nullable
    public final Boolean getIsIPayEligible() {
        return this.IsIPayEligible;
    }
}
