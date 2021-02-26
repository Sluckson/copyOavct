package com.iaai.android.bdt.model.toBePaid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bq\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u000eHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u000eHÖ\u0001J\t\u00103\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 ¨\u00064"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/MakePayPalPaymentRequest;", "", "Amount", "", "CDFAmount", "PayPalCustomerID", "", "PaymentAmount", "PaymentCode", "PaymentMethodNonce", "buyerChargeIDs", "salvageBuyerChargeIDs", "salvageIDs", "PaypalAccountDetailID", "", "subsidiarybuyerid", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)V", "getAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCDFAmount", "getPayPalCustomerID", "()Ljava/lang/String;", "getPaymentAmount", "getPaymentCode", "getPaymentMethodNonce", "getPaypalAccountDetailID", "()I", "getBuyerChargeIDs", "getSalvageBuyerChargeIDs", "getSalvageIDs", "getSubsidiarybuyerid", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;)Lcom/iaai/android/bdt/model/toBePaid/MakePayPalPaymentRequest;", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MakePayPalPaymentRequest.kt */
public final class MakePayPalPaymentRequest {
    @Nullable
    private final Double Amount;
    @Nullable
    private final Double CDFAmount;
    @Nullable
    private final String PayPalCustomerID;
    @Nullable
    private final Double PaymentAmount;
    @Nullable
    private final String PaymentCode;
    @Nullable
    private final String PaymentMethodNonce;
    private final int PaypalAccountDetailID;
    @Nullable
    private final String buyerChargeIDs;
    @Nullable
    private final String salvageBuyerChargeIDs;
    @Nullable
    private final String salvageIDs;
    @Nullable
    private final Integer subsidiarybuyerid;

    @NotNull
    public static /* synthetic */ MakePayPalPaymentRequest copy$default(MakePayPalPaymentRequest makePayPalPaymentRequest, Double d, Double d2, String str, Double d3, String str2, String str3, String str4, String str5, String str6, int i, Integer num, int i2, Object obj) {
        MakePayPalPaymentRequest makePayPalPaymentRequest2 = makePayPalPaymentRequest;
        int i3 = i2;
        return makePayPalPaymentRequest.copy((i3 & 1) != 0 ? makePayPalPaymentRequest2.Amount : d, (i3 & 2) != 0 ? makePayPalPaymentRequest2.CDFAmount : d2, (i3 & 4) != 0 ? makePayPalPaymentRequest2.PayPalCustomerID : str, (i3 & 8) != 0 ? makePayPalPaymentRequest2.PaymentAmount : d3, (i3 & 16) != 0 ? makePayPalPaymentRequest2.PaymentCode : str2, (i3 & 32) != 0 ? makePayPalPaymentRequest2.PaymentMethodNonce : str3, (i3 & 64) != 0 ? makePayPalPaymentRequest2.buyerChargeIDs : str4, (i3 & 128) != 0 ? makePayPalPaymentRequest2.salvageBuyerChargeIDs : str5, (i3 & 256) != 0 ? makePayPalPaymentRequest2.salvageIDs : str6, (i3 & 512) != 0 ? makePayPalPaymentRequest2.PaypalAccountDetailID : i, (i3 & 1024) != 0 ? makePayPalPaymentRequest2.subsidiarybuyerid : num);
    }

    @Nullable
    public final Double component1() {
        return this.Amount;
    }

    public final int component10() {
        return this.PaypalAccountDetailID;
    }

    @Nullable
    public final Integer component11() {
        return this.subsidiarybuyerid;
    }

    @Nullable
    public final Double component2() {
        return this.CDFAmount;
    }

    @Nullable
    public final String component3() {
        return this.PayPalCustomerID;
    }

    @Nullable
    public final Double component4() {
        return this.PaymentAmount;
    }

    @Nullable
    public final String component5() {
        return this.PaymentCode;
    }

    @Nullable
    public final String component6() {
        return this.PaymentMethodNonce;
    }

    @Nullable
    public final String component7() {
        return this.buyerChargeIDs;
    }

    @Nullable
    public final String component8() {
        return this.salvageBuyerChargeIDs;
    }

    @Nullable
    public final String component9() {
        return this.salvageIDs;
    }

    @NotNull
    public final MakePayPalPaymentRequest copy(@Nullable Double d, @Nullable Double d2, @Nullable String str, @Nullable Double d3, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i, @Nullable Integer num) {
        return new MakePayPalPaymentRequest(d, d2, str, d3, str2, str3, str4, str5, str6, i, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MakePayPalPaymentRequest) {
                MakePayPalPaymentRequest makePayPalPaymentRequest = (MakePayPalPaymentRequest) obj;
                if (Intrinsics.areEqual((Object) this.Amount, (Object) makePayPalPaymentRequest.Amount) && Intrinsics.areEqual((Object) this.CDFAmount, (Object) makePayPalPaymentRequest.CDFAmount) && Intrinsics.areEqual((Object) this.PayPalCustomerID, (Object) makePayPalPaymentRequest.PayPalCustomerID) && Intrinsics.areEqual((Object) this.PaymentAmount, (Object) makePayPalPaymentRequest.PaymentAmount) && Intrinsics.areEqual((Object) this.PaymentCode, (Object) makePayPalPaymentRequest.PaymentCode) && Intrinsics.areEqual((Object) this.PaymentMethodNonce, (Object) makePayPalPaymentRequest.PaymentMethodNonce) && Intrinsics.areEqual((Object) this.buyerChargeIDs, (Object) makePayPalPaymentRequest.buyerChargeIDs) && Intrinsics.areEqual((Object) this.salvageBuyerChargeIDs, (Object) makePayPalPaymentRequest.salvageBuyerChargeIDs) && Intrinsics.areEqual((Object) this.salvageIDs, (Object) makePayPalPaymentRequest.salvageIDs)) {
                    if (!(this.PaypalAccountDetailID == makePayPalPaymentRequest.PaypalAccountDetailID) || !Intrinsics.areEqual((Object) this.subsidiarybuyerid, (Object) makePayPalPaymentRequest.subsidiarybuyerid)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Double d = this.Amount;
        int i = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 31;
        Double d2 = this.CDFAmount;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str = this.PayPalCustomerID;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Double d3 = this.PaymentAmount;
        int hashCode4 = (hashCode3 + (d3 != null ? d3.hashCode() : 0)) * 31;
        String str2 = this.PaymentCode;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.PaymentMethodNonce;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.buyerChargeIDs;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.salvageBuyerChargeIDs;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.salvageIDs;
        int hashCode9 = (((hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31) + Integer.valueOf(this.PaypalAccountDetailID).hashCode()) * 31;
        Integer num = this.subsidiarybuyerid;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode9 + i;
    }

    @NotNull
    public String toString() {
        return "MakePayPalPaymentRequest(Amount=" + this.Amount + ", CDFAmount=" + this.CDFAmount + ", PayPalCustomerID=" + this.PayPalCustomerID + ", PaymentAmount=" + this.PaymentAmount + ", PaymentCode=" + this.PaymentCode + ", PaymentMethodNonce=" + this.PaymentMethodNonce + ", buyerChargeIDs=" + this.buyerChargeIDs + ", salvageBuyerChargeIDs=" + this.salvageBuyerChargeIDs + ", salvageIDs=" + this.salvageIDs + ", PaypalAccountDetailID=" + this.PaypalAccountDetailID + ", subsidiarybuyerid=" + this.subsidiarybuyerid + ")";
    }

    public MakePayPalPaymentRequest(@Nullable Double d, @Nullable Double d2, @Nullable String str, @Nullable Double d3, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, int i, @Nullable Integer num) {
        this.Amount = d;
        this.CDFAmount = d2;
        this.PayPalCustomerID = str;
        this.PaymentAmount = d3;
        this.PaymentCode = str2;
        this.PaymentMethodNonce = str3;
        this.buyerChargeIDs = str4;
        this.salvageBuyerChargeIDs = str5;
        this.salvageIDs = str6;
        this.PaypalAccountDetailID = i;
        this.subsidiarybuyerid = num;
    }

    @Nullable
    public final Double getAmount() {
        return this.Amount;
    }

    @Nullable
    public final Double getCDFAmount() {
        return this.CDFAmount;
    }

    @Nullable
    public final String getPayPalCustomerID() {
        return this.PayPalCustomerID;
    }

    @Nullable
    public final Double getPaymentAmount() {
        return this.PaymentAmount;
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
    public final String getBuyerChargeIDs() {
        return this.buyerChargeIDs;
    }

    @Nullable
    public final String getSalvageBuyerChargeIDs() {
        return this.salvageBuyerChargeIDs;
    }

    @Nullable
    public final String getSalvageIDs() {
        return this.salvageIDs;
    }

    public final int getPaypalAccountDetailID() {
        return this.PaypalAccountDetailID;
    }

    @Nullable
    public final Integer getSubsidiarybuyerid() {
        return this.subsidiarybuyerid;
    }
}
