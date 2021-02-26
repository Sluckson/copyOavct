package com.iaai.android.bdt.model.toBePaid.paymentDueList;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsCCEligibleAndDailyAllowance;", "Landroid/os/Parcelable;", "AllowanceUsedCCPay", "", "DailyAllowanceCCPay", "IsCCEligible", "", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;)V", "getAllowanceUsedCCPay", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDailyAllowanceCCPay", "getIsCCEligible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;)Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsCCEligibleAndDailyAllowance;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: IsCCEligibleAndDailyAllowance.kt */
public final class IsCCEligibleAndDailyAllowance implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @Nullable
    private final Double AllowanceUsedCCPay;
    @Nullable
    private final Double DailyAllowanceCCPay;
    @Nullable
    private final Boolean IsCCEligible;

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
            return new IsCCEligibleAndDailyAllowance(valueOf, valueOf2, bool);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new IsCCEligibleAndDailyAllowance[i];
        }
    }

    @NotNull
    public static /* synthetic */ IsCCEligibleAndDailyAllowance copy$default(IsCCEligibleAndDailyAllowance isCCEligibleAndDailyAllowance, Double d, Double d2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            d = isCCEligibleAndDailyAllowance.AllowanceUsedCCPay;
        }
        if ((i & 2) != 0) {
            d2 = isCCEligibleAndDailyAllowance.DailyAllowanceCCPay;
        }
        if ((i & 4) != 0) {
            bool = isCCEligibleAndDailyAllowance.IsCCEligible;
        }
        return isCCEligibleAndDailyAllowance.copy(d, d2, bool);
    }

    @Nullable
    public final Double component1() {
        return this.AllowanceUsedCCPay;
    }

    @Nullable
    public final Double component2() {
        return this.DailyAllowanceCCPay;
    }

    @Nullable
    public final Boolean component3() {
        return this.IsCCEligible;
    }

    @NotNull
    public final IsCCEligibleAndDailyAllowance copy(@Nullable Double d, @Nullable Double d2, @Nullable Boolean bool) {
        return new IsCCEligibleAndDailyAllowance(d, d2, bool);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IsCCEligibleAndDailyAllowance)) {
            return false;
        }
        IsCCEligibleAndDailyAllowance isCCEligibleAndDailyAllowance = (IsCCEligibleAndDailyAllowance) obj;
        return Intrinsics.areEqual((Object) this.AllowanceUsedCCPay, (Object) isCCEligibleAndDailyAllowance.AllowanceUsedCCPay) && Intrinsics.areEqual((Object) this.DailyAllowanceCCPay, (Object) isCCEligibleAndDailyAllowance.DailyAllowanceCCPay) && Intrinsics.areEqual((Object) this.IsCCEligible, (Object) isCCEligibleAndDailyAllowance.IsCCEligible);
    }

    public int hashCode() {
        Double d = this.AllowanceUsedCCPay;
        int i = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 31;
        Double d2 = this.DailyAllowanceCCPay;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
        Boolean bool = this.IsCCEligible;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "IsCCEligibleAndDailyAllowance(AllowanceUsedCCPay=" + this.AllowanceUsedCCPay + ", DailyAllowanceCCPay=" + this.DailyAllowanceCCPay + ", IsCCEligible=" + this.IsCCEligible + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        Double d = this.AllowanceUsedCCPay;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        Double d2 = this.DailyAllowanceCCPay;
        if (d2 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d2.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.IsCCEligible;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
            return;
        }
        parcel.writeInt(0);
    }

    public IsCCEligibleAndDailyAllowance(@Nullable Double d, @Nullable Double d2, @Nullable Boolean bool) {
        this.AllowanceUsedCCPay = d;
        this.DailyAllowanceCCPay = d2;
        this.IsCCEligible = bool;
    }

    @Nullable
    public final Double getAllowanceUsedCCPay() {
        return this.AllowanceUsedCCPay;
    }

    @Nullable
    public final Double getDailyAllowanceCCPay() {
        return this.DailyAllowanceCCPay;
    }

    @Nullable
    public final Boolean getIsCCEligible() {
        return this.IsCCEligible;
    }
}
