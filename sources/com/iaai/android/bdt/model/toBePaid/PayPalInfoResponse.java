package com.iaai.android.bdt.model.toBePaid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\nHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/PayPalInfoResponse;", "", "AllowanceUsedPPPay", "", "CashDiscountForfeited", "DailyAllowancePPPay", "IsPPEligible", "", "MaxLimit", "error", "", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/String;)V", "getAllowanceUsedPPPay", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCashDiscountForfeited", "getDailyAllowancePPPay", "getIsPPEligible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxLimit", "getError", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/String;)Lcom/iaai/android/bdt/model/toBePaid/PayPalInfoResponse;", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PayPalInfoResponse.kt */
public final class PayPalInfoResponse {
    @Nullable
    private final Double AllowanceUsedPPPay;
    @Nullable
    private final Double CashDiscountForfeited;
    @Nullable
    private final Double DailyAllowancePPPay;
    @Nullable
    private final Boolean IsPPEligible;
    @Nullable
    private final Double MaxLimit;
    @Nullable
    private final String error;

    @NotNull
    public static /* synthetic */ PayPalInfoResponse copy$default(PayPalInfoResponse payPalInfoResponse, Double d, Double d2, Double d3, Boolean bool, Double d4, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d = payPalInfoResponse.AllowanceUsedPPPay;
        }
        if ((i & 2) != 0) {
            d2 = payPalInfoResponse.CashDiscountForfeited;
        }
        Double d5 = d2;
        if ((i & 4) != 0) {
            d3 = payPalInfoResponse.DailyAllowancePPPay;
        }
        Double d6 = d3;
        if ((i & 8) != 0) {
            bool = payPalInfoResponse.IsPPEligible;
        }
        Boolean bool2 = bool;
        if ((i & 16) != 0) {
            d4 = payPalInfoResponse.MaxLimit;
        }
        Double d7 = d4;
        if ((i & 32) != 0) {
            str = payPalInfoResponse.error;
        }
        return payPalInfoResponse.copy(d, d5, d6, bool2, d7, str);
    }

    @Nullable
    public final Double component1() {
        return this.AllowanceUsedPPPay;
    }

    @Nullable
    public final Double component2() {
        return this.CashDiscountForfeited;
    }

    @Nullable
    public final Double component3() {
        return this.DailyAllowancePPPay;
    }

    @Nullable
    public final Boolean component4() {
        return this.IsPPEligible;
    }

    @Nullable
    public final Double component5() {
        return this.MaxLimit;
    }

    @Nullable
    public final String component6() {
        return this.error;
    }

    @NotNull
    public final PayPalInfoResponse copy(@Nullable Double d, @Nullable Double d2, @Nullable Double d3, @Nullable Boolean bool, @Nullable Double d4, @Nullable String str) {
        return new PayPalInfoResponse(d, d2, d3, bool, d4, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayPalInfoResponse)) {
            return false;
        }
        PayPalInfoResponse payPalInfoResponse = (PayPalInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.AllowanceUsedPPPay, (Object) payPalInfoResponse.AllowanceUsedPPPay) && Intrinsics.areEqual((Object) this.CashDiscountForfeited, (Object) payPalInfoResponse.CashDiscountForfeited) && Intrinsics.areEqual((Object) this.DailyAllowancePPPay, (Object) payPalInfoResponse.DailyAllowancePPPay) && Intrinsics.areEqual((Object) this.IsPPEligible, (Object) payPalInfoResponse.IsPPEligible) && Intrinsics.areEqual((Object) this.MaxLimit, (Object) payPalInfoResponse.MaxLimit) && Intrinsics.areEqual((Object) this.error, (Object) payPalInfoResponse.error);
    }

    public int hashCode() {
        Double d = this.AllowanceUsedPPPay;
        int i = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 31;
        Double d2 = this.CashDiscountForfeited;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
        Double d3 = this.DailyAllowancePPPay;
        int hashCode3 = (hashCode2 + (d3 != null ? d3.hashCode() : 0)) * 31;
        Boolean bool = this.IsPPEligible;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Double d4 = this.MaxLimit;
        int hashCode5 = (hashCode4 + (d4 != null ? d4.hashCode() : 0)) * 31;
        String str = this.error;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        return "PayPalInfoResponse(AllowanceUsedPPPay=" + this.AllowanceUsedPPPay + ", CashDiscountForfeited=" + this.CashDiscountForfeited + ", DailyAllowancePPPay=" + this.DailyAllowancePPPay + ", IsPPEligible=" + this.IsPPEligible + ", MaxLimit=" + this.MaxLimit + ", error=" + this.error + ")";
    }

    public PayPalInfoResponse(@Nullable Double d, @Nullable Double d2, @Nullable Double d3, @Nullable Boolean bool, @Nullable Double d4, @Nullable String str) {
        this.AllowanceUsedPPPay = d;
        this.CashDiscountForfeited = d2;
        this.DailyAllowancePPPay = d3;
        this.IsPPEligible = bool;
        this.MaxLimit = d4;
        this.error = str;
    }

    @Nullable
    public final Double getAllowanceUsedPPPay() {
        return this.AllowanceUsedPPPay;
    }

    @Nullable
    public final Double getCashDiscountForfeited() {
        return this.CashDiscountForfeited;
    }

    @Nullable
    public final Double getDailyAllowancePPPay() {
        return this.DailyAllowancePPPay;
    }

    @Nullable
    public final Boolean getIsPPEligible() {
        return this.IsPPEligible;
    }

    @Nullable
    public final Double getMaxLimit() {
        return this.MaxLimit;
    }

    @Nullable
    public final String getError() {
        return this.error;
    }
}
