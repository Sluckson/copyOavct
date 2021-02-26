package com.iaai.android.bdt.model.toBePaid.paymentDueList;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bu\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0014J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010 J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010 J\u0001\u00102\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00103J\t\u00104\u001a\u00020\rHÖ\u0001J\u0013\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020\rHÖ\u0001J\t\u00109\u001a\u00020:HÖ\u0001J\u0019\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\rHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010%\u001a\u0004\b'\u0010$¨\u0006@"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDueModel;", "Landroid/os/Parcelable;", "ActiveCCAccountDetailsList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/ActiveCCAccountDetails;", "IsCCEligibleAndDailyAllowance", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsCCEligibleAndDailyAllowance;", "IsEligibleforAFC", "", "IsIpayEligibleAndDailyAllowance", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsIpayEligibleAndDailyAllowance;", "IsShippingEnabledForBuyer", "ItemsCount", "", "PaymentDueList", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "TotalAwardPendingBidAmount", "", "TotalDisclosureItems", "TotalDueAmount", "(Ljava/util/List;Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsCCEligibleAndDailyAllowance;Ljava/lang/Boolean;Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsIpayEligibleAndDailyAllowance;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;)V", "getActiveCCAccountDetailsList", "()Ljava/util/List;", "getIsCCEligibleAndDailyAllowance", "()Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsCCEligibleAndDailyAllowance;", "getIsEligibleforAFC", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIsIpayEligibleAndDailyAllowance", "()Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsIpayEligibleAndDailyAllowance;", "getIsShippingEnabledForBuyer", "getItemsCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPaymentDueList", "getTotalAwardPendingBidAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTotalDisclosureItems", "getTotalDueAmount", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsCCEligibleAndDailyAllowance;Ljava/lang/Boolean;Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/IsIpayEligibleAndDailyAllowance;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDueModel;", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: PaymentDueModel.kt */
public final class PaymentDueModel implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @Nullable
    private final List<ActiveCCAccountDetails> ActiveCCAccountDetailsList;
    @Nullable
    private final IsCCEligibleAndDailyAllowance IsCCEligibleAndDailyAllowance;
    @Nullable
    private final Boolean IsEligibleforAFC;
    @Nullable
    private final IsIpayEligibleAndDailyAllowance IsIpayEligibleAndDailyAllowance;
    @Nullable
    private final Boolean IsShippingEnabledForBuyer;
    @Nullable
    private final Integer ItemsCount;
    @Nullable
    private final List<PaymentDue> PaymentDueList;
    @Nullable
    private final Double TotalAwardPendingBidAmount;
    @Nullable
    private final Integer TotalDisclosureItems;
    @Nullable
    private final Double TotalDueAmount;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Boolean bool;
            Boolean bool2;
            ArrayList arrayList2;
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((ActiveCCAccountDetails) ActiveCCAccountDetails.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            IsCCEligibleAndDailyAllowance isCCEligibleAndDailyAllowance = parcel.readInt() != 0 ? (IsCCEligibleAndDailyAllowance) IsCCEligibleAndDailyAllowance.CREATOR.createFromParcel(parcel) : null;
            boolean z = true;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            IsIpayEligibleAndDailyAllowance isIpayEligibleAndDailyAllowance = parcel.readInt() != 0 ? (IsIpayEligibleAndDailyAllowance) IsIpayEligibleAndDailyAllowance.CREATOR.createFromParcel(parcel) : null;
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool2 = Boolean.valueOf(z);
            } else {
                bool2 = null;
            }
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList3.add((PaymentDue) PaymentDue.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
                arrayList2 = arrayList3;
            } else {
                arrayList2 = null;
            }
            return new PaymentDueModel(arrayList, isCCEligibleAndDailyAllowance, bool, isIpayEligibleAndDailyAllowance, bool2, valueOf, arrayList2, parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new PaymentDueModel[i];
        }
    }

    @NotNull
    public static /* synthetic */ PaymentDueModel copy$default(PaymentDueModel paymentDueModel, List list, IsCCEligibleAndDailyAllowance isCCEligibleAndDailyAllowance, Boolean bool, IsIpayEligibleAndDailyAllowance isIpayEligibleAndDailyAllowance, Boolean bool2, Integer num, List list2, Double d, Integer num2, Double d2, int i, Object obj) {
        PaymentDueModel paymentDueModel2 = paymentDueModel;
        int i2 = i;
        return paymentDueModel.copy((i2 & 1) != 0 ? paymentDueModel2.ActiveCCAccountDetailsList : list, (i2 & 2) != 0 ? paymentDueModel2.IsCCEligibleAndDailyAllowance : isCCEligibleAndDailyAllowance, (i2 & 4) != 0 ? paymentDueModel2.IsEligibleforAFC : bool, (i2 & 8) != 0 ? paymentDueModel2.IsIpayEligibleAndDailyAllowance : isIpayEligibleAndDailyAllowance, (i2 & 16) != 0 ? paymentDueModel2.IsShippingEnabledForBuyer : bool2, (i2 & 32) != 0 ? paymentDueModel2.ItemsCount : num, (i2 & 64) != 0 ? paymentDueModel2.PaymentDueList : list2, (i2 & 128) != 0 ? paymentDueModel2.TotalAwardPendingBidAmount : d, (i2 & 256) != 0 ? paymentDueModel2.TotalDisclosureItems : num2, (i2 & 512) != 0 ? paymentDueModel2.TotalDueAmount : d2);
    }

    @Nullable
    public final List<ActiveCCAccountDetails> component1() {
        return this.ActiveCCAccountDetailsList;
    }

    @Nullable
    public final Double component10() {
        return this.TotalDueAmount;
    }

    @Nullable
    public final IsCCEligibleAndDailyAllowance component2() {
        return this.IsCCEligibleAndDailyAllowance;
    }

    @Nullable
    public final Boolean component3() {
        return this.IsEligibleforAFC;
    }

    @Nullable
    public final IsIpayEligibleAndDailyAllowance component4() {
        return this.IsIpayEligibleAndDailyAllowance;
    }

    @Nullable
    public final Boolean component5() {
        return this.IsShippingEnabledForBuyer;
    }

    @Nullable
    public final Integer component6() {
        return this.ItemsCount;
    }

    @Nullable
    public final List<PaymentDue> component7() {
        return this.PaymentDueList;
    }

    @Nullable
    public final Double component8() {
        return this.TotalAwardPendingBidAmount;
    }

    @Nullable
    public final Integer component9() {
        return this.TotalDisclosureItems;
    }

    @NotNull
    public final PaymentDueModel copy(@Nullable List<ActiveCCAccountDetails> list, @Nullable IsCCEligibleAndDailyAllowance isCCEligibleAndDailyAllowance, @Nullable Boolean bool, @Nullable IsIpayEligibleAndDailyAllowance isIpayEligibleAndDailyAllowance, @Nullable Boolean bool2, @Nullable Integer num, @Nullable List<PaymentDue> list2, @Nullable Double d, @Nullable Integer num2, @Nullable Double d2) {
        return new PaymentDueModel(list, isCCEligibleAndDailyAllowance, bool, isIpayEligibleAndDailyAllowance, bool2, num, list2, d, num2, d2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentDueModel)) {
            return false;
        }
        PaymentDueModel paymentDueModel = (PaymentDueModel) obj;
        return Intrinsics.areEqual((Object) this.ActiveCCAccountDetailsList, (Object) paymentDueModel.ActiveCCAccountDetailsList) && Intrinsics.areEqual((Object) this.IsCCEligibleAndDailyAllowance, (Object) paymentDueModel.IsCCEligibleAndDailyAllowance) && Intrinsics.areEqual((Object) this.IsEligibleforAFC, (Object) paymentDueModel.IsEligibleforAFC) && Intrinsics.areEqual((Object) this.IsIpayEligibleAndDailyAllowance, (Object) paymentDueModel.IsIpayEligibleAndDailyAllowance) && Intrinsics.areEqual((Object) this.IsShippingEnabledForBuyer, (Object) paymentDueModel.IsShippingEnabledForBuyer) && Intrinsics.areEqual((Object) this.ItemsCount, (Object) paymentDueModel.ItemsCount) && Intrinsics.areEqual((Object) this.PaymentDueList, (Object) paymentDueModel.PaymentDueList) && Intrinsics.areEqual((Object) this.TotalAwardPendingBidAmount, (Object) paymentDueModel.TotalAwardPendingBidAmount) && Intrinsics.areEqual((Object) this.TotalDisclosureItems, (Object) paymentDueModel.TotalDisclosureItems) && Intrinsics.areEqual((Object) this.TotalDueAmount, (Object) paymentDueModel.TotalDueAmount);
    }

    public int hashCode() {
        List<ActiveCCAccountDetails> list = this.ActiveCCAccountDetailsList;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        IsCCEligibleAndDailyAllowance isCCEligibleAndDailyAllowance = this.IsCCEligibleAndDailyAllowance;
        int hashCode2 = (hashCode + (isCCEligibleAndDailyAllowance != null ? isCCEligibleAndDailyAllowance.hashCode() : 0)) * 31;
        Boolean bool = this.IsEligibleforAFC;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 31;
        IsIpayEligibleAndDailyAllowance isIpayEligibleAndDailyAllowance = this.IsIpayEligibleAndDailyAllowance;
        int hashCode4 = (hashCode3 + (isIpayEligibleAndDailyAllowance != null ? isIpayEligibleAndDailyAllowance.hashCode() : 0)) * 31;
        Boolean bool2 = this.IsShippingEnabledForBuyer;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Integer num = this.ItemsCount;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        List<PaymentDue> list2 = this.PaymentDueList;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Double d = this.TotalAwardPendingBidAmount;
        int hashCode8 = (hashCode7 + (d != null ? d.hashCode() : 0)) * 31;
        Integer num2 = this.TotalDisclosureItems;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Double d2 = this.TotalDueAmount;
        if (d2 != null) {
            i = d2.hashCode();
        }
        return hashCode9 + i;
    }

    @NotNull
    public String toString() {
        return "PaymentDueModel(ActiveCCAccountDetailsList=" + this.ActiveCCAccountDetailsList + ", IsCCEligibleAndDailyAllowance=" + this.IsCCEligibleAndDailyAllowance + ", IsEligibleforAFC=" + this.IsEligibleforAFC + ", IsIpayEligibleAndDailyAllowance=" + this.IsIpayEligibleAndDailyAllowance + ", IsShippingEnabledForBuyer=" + this.IsShippingEnabledForBuyer + ", ItemsCount=" + this.ItemsCount + ", PaymentDueList=" + this.PaymentDueList + ", TotalAwardPendingBidAmount=" + this.TotalAwardPendingBidAmount + ", TotalDisclosureItems=" + this.TotalDisclosureItems + ", TotalDueAmount=" + this.TotalDueAmount + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        List<ActiveCCAccountDetails> list = this.ActiveCCAccountDetailsList;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (ActiveCCAccountDetails writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        IsCCEligibleAndDailyAllowance isCCEligibleAndDailyAllowance = this.IsCCEligibleAndDailyAllowance;
        if (isCCEligibleAndDailyAllowance != null) {
            parcel.writeInt(1);
            isCCEligibleAndDailyAllowance.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.IsEligibleforAFC;
        if (bool != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        IsIpayEligibleAndDailyAllowance isIpayEligibleAndDailyAllowance = this.IsIpayEligibleAndDailyAllowance;
        if (isIpayEligibleAndDailyAllowance != null) {
            parcel.writeInt(1);
            isIpayEligibleAndDailyAllowance.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool2 = this.IsShippingEnabledForBuyer;
        if (bool2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        Integer num = this.ItemsCount;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        List<PaymentDue> list2 = this.PaymentDueList;
        if (list2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            for (PaymentDue writeToParcel2 : list2) {
                writeToParcel2.writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        Double d = this.TotalAwardPendingBidAmount;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        Integer num2 = this.TotalDisclosureItems;
        if (num2 != null) {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        } else {
            parcel.writeInt(0);
        }
        Double d2 = this.TotalDueAmount;
        if (d2 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d2.doubleValue());
            return;
        }
        parcel.writeInt(0);
    }

    public PaymentDueModel(@Nullable List<ActiveCCAccountDetails> list, @Nullable IsCCEligibleAndDailyAllowance isCCEligibleAndDailyAllowance, @Nullable Boolean bool, @Nullable IsIpayEligibleAndDailyAllowance isIpayEligibleAndDailyAllowance, @Nullable Boolean bool2, @Nullable Integer num, @Nullable List<PaymentDue> list2, @Nullable Double d, @Nullable Integer num2, @Nullable Double d2) {
        this.ActiveCCAccountDetailsList = list;
        this.IsCCEligibleAndDailyAllowance = isCCEligibleAndDailyAllowance;
        this.IsEligibleforAFC = bool;
        this.IsIpayEligibleAndDailyAllowance = isIpayEligibleAndDailyAllowance;
        this.IsShippingEnabledForBuyer = bool2;
        this.ItemsCount = num;
        this.PaymentDueList = list2;
        this.TotalAwardPendingBidAmount = d;
        this.TotalDisclosureItems = num2;
        this.TotalDueAmount = d2;
    }

    @Nullable
    public final List<ActiveCCAccountDetails> getActiveCCAccountDetailsList() {
        return this.ActiveCCAccountDetailsList;
    }

    @Nullable
    public final IsCCEligibleAndDailyAllowance getIsCCEligibleAndDailyAllowance() {
        return this.IsCCEligibleAndDailyAllowance;
    }

    @Nullable
    public final Boolean getIsEligibleforAFC() {
        return this.IsEligibleforAFC;
    }

    @Nullable
    public final IsIpayEligibleAndDailyAllowance getIsIpayEligibleAndDailyAllowance() {
        return this.IsIpayEligibleAndDailyAllowance;
    }

    @Nullable
    public final Boolean getIsShippingEnabledForBuyer() {
        return this.IsShippingEnabledForBuyer;
    }

    @Nullable
    public final Integer getItemsCount() {
        return this.ItemsCount;
    }

    @Nullable
    public final List<PaymentDue> getPaymentDueList() {
        return this.PaymentDueList;
    }

    @Nullable
    public final Double getTotalAwardPendingBidAmount() {
        return this.TotalAwardPendingBidAmount;
    }

    @Nullable
    public final Integer getTotalDisclosureItems() {
        return this.TotalDisclosureItems;
    }

    @Nullable
    public final Double getTotalDueAmount() {
        return this.TotalDueAmount;
    }
}
