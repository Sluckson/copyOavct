package com.iaai.android.bdt.model.toBePaid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\b\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\bHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/PayPalTokenResponse;", "", "PayPalToken", "", "PayPalCustomerID", "PaymentCode", "Error", "PaypalAccountDetailID", "", "PaymentMethod", "IsUsedInAutoRenew", "", "Istokengenerated", "PayPalCustomerResponseText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getIsUsedInAutoRenew", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIstokengenerated", "getPayPalCustomerID", "getPayPalCustomerResponseText", "getPayPalToken", "getPaymentCode", "getPaymentMethod", "getPaypalAccountDetailID", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/iaai/android/bdt/model/toBePaid/PayPalTokenResponse;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PayPalTokenResponse.kt */
public final class PayPalTokenResponse {
    @Nullable
    private final String Error;
    @Nullable
    private final Boolean IsUsedInAutoRenew;
    @Nullable
    private final Boolean Istokengenerated;
    @Nullable
    private final String PayPalCustomerID;
    @Nullable
    private final String PayPalCustomerResponseText;
    @Nullable
    private final String PayPalToken;
    @Nullable
    private final String PaymentCode;
    @Nullable
    private final String PaymentMethod;
    @Nullable
    private final Integer PaypalAccountDetailID;

    @NotNull
    public static /* synthetic */ PayPalTokenResponse copy$default(PayPalTokenResponse payPalTokenResponse, String str, String str2, String str3, String str4, Integer num, String str5, Boolean bool, Boolean bool2, String str6, int i, Object obj) {
        PayPalTokenResponse payPalTokenResponse2 = payPalTokenResponse;
        int i2 = i;
        return payPalTokenResponse.copy((i2 & 1) != 0 ? payPalTokenResponse2.PayPalToken : str, (i2 & 2) != 0 ? payPalTokenResponse2.PayPalCustomerID : str2, (i2 & 4) != 0 ? payPalTokenResponse2.PaymentCode : str3, (i2 & 8) != 0 ? payPalTokenResponse2.Error : str4, (i2 & 16) != 0 ? payPalTokenResponse2.PaypalAccountDetailID : num, (i2 & 32) != 0 ? payPalTokenResponse2.PaymentMethod : str5, (i2 & 64) != 0 ? payPalTokenResponse2.IsUsedInAutoRenew : bool, (i2 & 128) != 0 ? payPalTokenResponse2.Istokengenerated : bool2, (i2 & 256) != 0 ? payPalTokenResponse2.PayPalCustomerResponseText : str6);
    }

    @Nullable
    public final String component1() {
        return this.PayPalToken;
    }

    @Nullable
    public final String component2() {
        return this.PayPalCustomerID;
    }

    @Nullable
    public final String component3() {
        return this.PaymentCode;
    }

    @Nullable
    public final String component4() {
        return this.Error;
    }

    @Nullable
    public final Integer component5() {
        return this.PaypalAccountDetailID;
    }

    @Nullable
    public final String component6() {
        return this.PaymentMethod;
    }

    @Nullable
    public final Boolean component7() {
        return this.IsUsedInAutoRenew;
    }

    @Nullable
    public final Boolean component8() {
        return this.Istokengenerated;
    }

    @Nullable
    public final String component9() {
        return this.PayPalCustomerResponseText;
    }

    @NotNull
    public final PayPalTokenResponse copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str6) {
        return new PayPalTokenResponse(str, str2, str3, str4, num, str5, bool, bool2, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayPalTokenResponse)) {
            return false;
        }
        PayPalTokenResponse payPalTokenResponse = (PayPalTokenResponse) obj;
        return Intrinsics.areEqual((Object) this.PayPalToken, (Object) payPalTokenResponse.PayPalToken) && Intrinsics.areEqual((Object) this.PayPalCustomerID, (Object) payPalTokenResponse.PayPalCustomerID) && Intrinsics.areEqual((Object) this.PaymentCode, (Object) payPalTokenResponse.PaymentCode) && Intrinsics.areEqual((Object) this.Error, (Object) payPalTokenResponse.Error) && Intrinsics.areEqual((Object) this.PaypalAccountDetailID, (Object) payPalTokenResponse.PaypalAccountDetailID) && Intrinsics.areEqual((Object) this.PaymentMethod, (Object) payPalTokenResponse.PaymentMethod) && Intrinsics.areEqual((Object) this.IsUsedInAutoRenew, (Object) payPalTokenResponse.IsUsedInAutoRenew) && Intrinsics.areEqual((Object) this.Istokengenerated, (Object) payPalTokenResponse.Istokengenerated) && Intrinsics.areEqual((Object) this.PayPalCustomerResponseText, (Object) payPalTokenResponse.PayPalCustomerResponseText);
    }

    public int hashCode() {
        String str = this.PayPalToken;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.PayPalCustomerID;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.PaymentCode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.Error;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.PaypalAccountDetailID;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        String str5 = this.PaymentMethod;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Boolean bool = this.IsUsedInAutoRenew;
        int hashCode7 = (hashCode6 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.Istokengenerated;
        int hashCode8 = (hashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str6 = this.PayPalCustomerResponseText;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode8 + i;
    }

    @NotNull
    public String toString() {
        return "PayPalTokenResponse(PayPalToken=" + this.PayPalToken + ", PayPalCustomerID=" + this.PayPalCustomerID + ", PaymentCode=" + this.PaymentCode + ", Error=" + this.Error + ", PaypalAccountDetailID=" + this.PaypalAccountDetailID + ", PaymentMethod=" + this.PaymentMethod + ", IsUsedInAutoRenew=" + this.IsUsedInAutoRenew + ", Istokengenerated=" + this.Istokengenerated + ", PayPalCustomerResponseText=" + this.PayPalCustomerResponseText + ")";
    }

    public PayPalTokenResponse(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str6) {
        this.PayPalToken = str;
        this.PayPalCustomerID = str2;
        this.PaymentCode = str3;
        this.Error = str4;
        this.PaypalAccountDetailID = num;
        this.PaymentMethod = str5;
        this.IsUsedInAutoRenew = bool;
        this.Istokengenerated = bool2;
        this.PayPalCustomerResponseText = str6;
    }

    @Nullable
    public final String getPayPalToken() {
        return this.PayPalToken;
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
    public final String getError() {
        return this.Error;
    }

    @Nullable
    public final Integer getPaypalAccountDetailID() {
        return this.PaypalAccountDetailID;
    }

    @Nullable
    public final String getPaymentMethod() {
        return this.PaymentMethod;
    }

    @Nullable
    public final Boolean getIsUsedInAutoRenew() {
        return this.IsUsedInAutoRenew;
    }

    @Nullable
    public final Boolean getIstokengenerated() {
        return this.Istokengenerated;
    }

    @Nullable
    public final String getPayPalCustomerResponseText() {
        return this.PayPalCustomerResponseText;
    }
}
