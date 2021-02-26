package com.iaai.android.bdt.model.toBePaid;

import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0005HÆ\u0001J\u0013\u0010/\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0017\"\u0004\b\u001a\u0010\u0019R\u001a\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00064"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/PaymentMethodInformation;", "", "paymentMethodType", "Lcom/iaai/android/bdt/utils/Constants_MVVM$PaymentMethod;", "paymentMethodName", "", "paymentMethodInfo", "dailyAllowance", "accountInfo", "accountInfoAfc", "errorText", "isSetAsDefault", "", "isSelected", "isSelectedAFCBuyGo", "isCheckBoxVisible", "linkPaymentMethodText", "(Lcom/iaai/android/bdt/utils/Constants_MVVM$PaymentMethod;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;)V", "getAccountInfo", "()Ljava/lang/String;", "getAccountInfoAfc", "getDailyAllowance", "getErrorText", "()Z", "setCheckBoxVisible", "(Z)V", "setSelected", "setSelectedAFCBuyGo", "setSetAsDefault", "getLinkPaymentMethodText", "getPaymentMethodInfo", "getPaymentMethodName", "getPaymentMethodType", "()Lcom/iaai/android/bdt/utils/Constants_MVVM$PaymentMethod;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PaymentMethodInformation.kt */
public final class PaymentMethodInformation {
    @NotNull
    private final String accountInfo;
    @NotNull
    private final String accountInfoAfc;
    @NotNull
    private final String dailyAllowance;
    @NotNull
    private final String errorText;
    private boolean isCheckBoxVisible;
    private boolean isSelected;
    private boolean isSelectedAFCBuyGo;
    private boolean isSetAsDefault;
    @NotNull
    private final String linkPaymentMethodText;
    @NotNull
    private final String paymentMethodInfo;
    @NotNull
    private final String paymentMethodName;
    @NotNull
    private final Constants_MVVM.PaymentMethod paymentMethodType;

    @NotNull
    public static /* synthetic */ PaymentMethodInformation copy$default(PaymentMethodInformation paymentMethodInformation, Constants_MVVM.PaymentMethod paymentMethod, String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, boolean z4, String str7, int i, Object obj) {
        PaymentMethodInformation paymentMethodInformation2 = paymentMethodInformation;
        int i2 = i;
        return paymentMethodInformation.copy((i2 & 1) != 0 ? paymentMethodInformation2.paymentMethodType : paymentMethod, (i2 & 2) != 0 ? paymentMethodInformation2.paymentMethodName : str, (i2 & 4) != 0 ? paymentMethodInformation2.paymentMethodInfo : str2, (i2 & 8) != 0 ? paymentMethodInformation2.dailyAllowance : str3, (i2 & 16) != 0 ? paymentMethodInformation2.accountInfo : str4, (i2 & 32) != 0 ? paymentMethodInformation2.accountInfoAfc : str5, (i2 & 64) != 0 ? paymentMethodInformation2.errorText : str6, (i2 & 128) != 0 ? paymentMethodInformation2.isSetAsDefault : z, (i2 & 256) != 0 ? paymentMethodInformation2.isSelected : z2, (i2 & 512) != 0 ? paymentMethodInformation2.isSelectedAFCBuyGo : z3, (i2 & 1024) != 0 ? paymentMethodInformation2.isCheckBoxVisible : z4, (i2 & 2048) != 0 ? paymentMethodInformation2.linkPaymentMethodText : str7);
    }

    @NotNull
    public final Constants_MVVM.PaymentMethod component1() {
        return this.paymentMethodType;
    }

    public final boolean component10() {
        return this.isSelectedAFCBuyGo;
    }

    public final boolean component11() {
        return this.isCheckBoxVisible;
    }

    @NotNull
    public final String component12() {
        return this.linkPaymentMethodText;
    }

    @NotNull
    public final String component2() {
        return this.paymentMethodName;
    }

    @NotNull
    public final String component3() {
        return this.paymentMethodInfo;
    }

    @NotNull
    public final String component4() {
        return this.dailyAllowance;
    }

    @NotNull
    public final String component5() {
        return this.accountInfo;
    }

    @NotNull
    public final String component6() {
        return this.accountInfoAfc;
    }

    @NotNull
    public final String component7() {
        return this.errorText;
    }

    public final boolean component8() {
        return this.isSetAsDefault;
    }

    public final boolean component9() {
        return this.isSelected;
    }

    @NotNull
    public final PaymentMethodInformation copy(@NotNull Constants_MVVM.PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z, boolean z2, boolean z3, boolean z4, @NotNull String str7) {
        Intrinsics.checkParameterIsNotNull(paymentMethod, "paymentMethodType");
        String str8 = str;
        Intrinsics.checkParameterIsNotNull(str8, "paymentMethodName");
        String str9 = str2;
        Intrinsics.checkParameterIsNotNull(str9, "paymentMethodInfo");
        String str10 = str3;
        Intrinsics.checkParameterIsNotNull(str10, "dailyAllowance");
        String str11 = str4;
        Intrinsics.checkParameterIsNotNull(str11, "accountInfo");
        String str12 = str5;
        Intrinsics.checkParameterIsNotNull(str12, "accountInfoAfc");
        String str13 = str6;
        Intrinsics.checkParameterIsNotNull(str13, "errorText");
        String str14 = str7;
        Intrinsics.checkParameterIsNotNull(str14, "linkPaymentMethodText");
        return new PaymentMethodInformation(paymentMethod, str8, str9, str10, str11, str12, str13, z, z2, z3, z4, str14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PaymentMethodInformation) {
                PaymentMethodInformation paymentMethodInformation = (PaymentMethodInformation) obj;
                if (Intrinsics.areEqual((Object) this.paymentMethodType, (Object) paymentMethodInformation.paymentMethodType) && Intrinsics.areEqual((Object) this.paymentMethodName, (Object) paymentMethodInformation.paymentMethodName) && Intrinsics.areEqual((Object) this.paymentMethodInfo, (Object) paymentMethodInformation.paymentMethodInfo) && Intrinsics.areEqual((Object) this.dailyAllowance, (Object) paymentMethodInformation.dailyAllowance) && Intrinsics.areEqual((Object) this.accountInfo, (Object) paymentMethodInformation.accountInfo) && Intrinsics.areEqual((Object) this.accountInfoAfc, (Object) paymentMethodInformation.accountInfoAfc) && Intrinsics.areEqual((Object) this.errorText, (Object) paymentMethodInformation.errorText)) {
                    if (this.isSetAsDefault == paymentMethodInformation.isSetAsDefault) {
                        if (this.isSelected == paymentMethodInformation.isSelected) {
                            if (this.isSelectedAFCBuyGo == paymentMethodInformation.isSelectedAFCBuyGo) {
                                if (!(this.isCheckBoxVisible == paymentMethodInformation.isCheckBoxVisible) || !Intrinsics.areEqual((Object) this.linkPaymentMethodText, (Object) paymentMethodInformation.linkPaymentMethodText)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Constants_MVVM.PaymentMethod paymentMethod = this.paymentMethodType;
        int i = 0;
        int hashCode = (paymentMethod != null ? paymentMethod.hashCode() : 0) * 31;
        String str = this.paymentMethodName;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.paymentMethodInfo;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.dailyAllowance;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.accountInfo;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.accountInfoAfc;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.errorText;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z = this.isSetAsDefault;
        if (z) {
            z = true;
        }
        int i2 = (hashCode7 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isSelected;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.isSelectedAFCBuyGo;
        if (z3) {
            z3 = true;
        }
        int i4 = (i3 + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.isCheckBoxVisible;
        if (z4) {
            z4 = true;
        }
        int i5 = (i4 + (z4 ? 1 : 0)) * 31;
        String str7 = this.linkPaymentMethodText;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return i5 + i;
    }

    @NotNull
    public String toString() {
        return "PaymentMethodInformation(paymentMethodType=" + this.paymentMethodType + ", paymentMethodName=" + this.paymentMethodName + ", paymentMethodInfo=" + this.paymentMethodInfo + ", dailyAllowance=" + this.dailyAllowance + ", accountInfo=" + this.accountInfo + ", accountInfoAfc=" + this.accountInfoAfc + ", errorText=" + this.errorText + ", isSetAsDefault=" + this.isSetAsDefault + ", isSelected=" + this.isSelected + ", isSelectedAFCBuyGo=" + this.isSelectedAFCBuyGo + ", isCheckBoxVisible=" + this.isCheckBoxVisible + ", linkPaymentMethodText=" + this.linkPaymentMethodText + ")";
    }

    public PaymentMethodInformation(@NotNull Constants_MVVM.PaymentMethod paymentMethod, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z, boolean z2, boolean z3, boolean z4, @NotNull String str7) {
        Intrinsics.checkParameterIsNotNull(paymentMethod, "paymentMethodType");
        Intrinsics.checkParameterIsNotNull(str, "paymentMethodName");
        Intrinsics.checkParameterIsNotNull(str2, "paymentMethodInfo");
        Intrinsics.checkParameterIsNotNull(str3, "dailyAllowance");
        Intrinsics.checkParameterIsNotNull(str4, "accountInfo");
        Intrinsics.checkParameterIsNotNull(str5, "accountInfoAfc");
        Intrinsics.checkParameterIsNotNull(str6, "errorText");
        Intrinsics.checkParameterIsNotNull(str7, "linkPaymentMethodText");
        this.paymentMethodType = paymentMethod;
        this.paymentMethodName = str;
        this.paymentMethodInfo = str2;
        this.dailyAllowance = str3;
        this.accountInfo = str4;
        this.accountInfoAfc = str5;
        this.errorText = str6;
        this.isSetAsDefault = z;
        this.isSelected = z2;
        this.isSelectedAFCBuyGo = z3;
        this.isCheckBoxVisible = z4;
        this.linkPaymentMethodText = str7;
    }

    @NotNull
    public final Constants_MVVM.PaymentMethod getPaymentMethodType() {
        return this.paymentMethodType;
    }

    @NotNull
    public final String getPaymentMethodName() {
        return this.paymentMethodName;
    }

    @NotNull
    public final String getPaymentMethodInfo() {
        return this.paymentMethodInfo;
    }

    @NotNull
    public final String getDailyAllowance() {
        return this.dailyAllowance;
    }

    @NotNull
    public final String getAccountInfo() {
        return this.accountInfo;
    }

    @NotNull
    public final String getAccountInfoAfc() {
        return this.accountInfoAfc;
    }

    @NotNull
    public final String getErrorText() {
        return this.errorText;
    }

    public final boolean isSetAsDefault() {
        return this.isSetAsDefault;
    }

    public final void setSetAsDefault(boolean z) {
        this.isSetAsDefault = z;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final boolean isSelectedAFCBuyGo() {
        return this.isSelectedAFCBuyGo;
    }

    public final void setSelectedAFCBuyGo(boolean z) {
        this.isSelectedAFCBuyGo = z;
    }

    public final boolean isCheckBoxVisible() {
        return this.isCheckBoxVisible;
    }

    public final void setCheckBoxVisible(boolean z) {
        this.isCheckBoxVisible = z;
    }

    @NotNull
    public final String getLinkPaymentMethodText() {
        return this.linkPaymentMethodText;
    }
}
