package com.iaai.android.bdt.model.MyAccount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JT\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0004\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/MailAddressInfo;", "", "businessName", "", "isSelected", "", "addressInfo", "Lcom/iaai/android/bdt/model/MyAccount/AddressInfo;", "useMailingInd", "phone", "accountNo", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/iaai/android/bdt/model/MyAccount/AddressInfo;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAccountNo", "()Ljava/lang/String;", "getAddressInfo", "()Lcom/iaai/android/bdt/model/MyAccount/AddressInfo;", "getBusinessName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPhone", "getUseMailingInd", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/iaai/android/bdt/model/MyAccount/AddressInfo;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/iaai/android/bdt/model/MyAccount/MailAddressInfo;", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MailAddressInfo.kt */
public final class MailAddressInfo {
    @Nullable
    private final String accountNo;
    @NotNull
    private final AddressInfo addressInfo;
    @Nullable
    private final String businessName;
    @Nullable
    private final Boolean isSelected;
    @Nullable
    private final String phone;
    @Nullable
    private final Boolean useMailingInd;

    @NotNull
    public static /* synthetic */ MailAddressInfo copy$default(MailAddressInfo mailAddressInfo, String str, Boolean bool, AddressInfo addressInfo2, Boolean bool2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mailAddressInfo.businessName;
        }
        if ((i & 2) != 0) {
            bool = mailAddressInfo.isSelected;
        }
        Boolean bool3 = bool;
        if ((i & 4) != 0) {
            addressInfo2 = mailAddressInfo.addressInfo;
        }
        AddressInfo addressInfo3 = addressInfo2;
        if ((i & 8) != 0) {
            bool2 = mailAddressInfo.useMailingInd;
        }
        Boolean bool4 = bool2;
        if ((i & 16) != 0) {
            str2 = mailAddressInfo.phone;
        }
        String str4 = str2;
        if ((i & 32) != 0) {
            str3 = mailAddressInfo.accountNo;
        }
        return mailAddressInfo.copy(str, bool3, addressInfo3, bool4, str4, str3);
    }

    @Nullable
    public final String component1() {
        return this.businessName;
    }

    @Nullable
    public final Boolean component2() {
        return this.isSelected;
    }

    @NotNull
    public final AddressInfo component3() {
        return this.addressInfo;
    }

    @Nullable
    public final Boolean component4() {
        return this.useMailingInd;
    }

    @Nullable
    public final String component5() {
        return this.phone;
    }

    @Nullable
    public final String component6() {
        return this.accountNo;
    }

    @NotNull
    public final MailAddressInfo copy(@Nullable String str, @Nullable Boolean bool, @NotNull AddressInfo addressInfo2, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(addressInfo2, "addressInfo");
        return new MailAddressInfo(str, bool, addressInfo2, bool2, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MailAddressInfo)) {
            return false;
        }
        MailAddressInfo mailAddressInfo = (MailAddressInfo) obj;
        return Intrinsics.areEqual((Object) this.businessName, (Object) mailAddressInfo.businessName) && Intrinsics.areEqual((Object) this.isSelected, (Object) mailAddressInfo.isSelected) && Intrinsics.areEqual((Object) this.addressInfo, (Object) mailAddressInfo.addressInfo) && Intrinsics.areEqual((Object) this.useMailingInd, (Object) mailAddressInfo.useMailingInd) && Intrinsics.areEqual((Object) this.phone, (Object) mailAddressInfo.phone) && Intrinsics.areEqual((Object) this.accountNo, (Object) mailAddressInfo.accountNo);
    }

    public int hashCode() {
        String str = this.businessName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Boolean bool = this.isSelected;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        AddressInfo addressInfo2 = this.addressInfo;
        int hashCode3 = (hashCode2 + (addressInfo2 != null ? addressInfo2.hashCode() : 0)) * 31;
        Boolean bool2 = this.useMailingInd;
        int hashCode4 = (hashCode3 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str2 = this.phone;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.accountNo;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        return "MailAddressInfo(businessName=" + this.businessName + ", isSelected=" + this.isSelected + ", addressInfo=" + this.addressInfo + ", useMailingInd=" + this.useMailingInd + ", phone=" + this.phone + ", accountNo=" + this.accountNo + ")";
    }

    public MailAddressInfo(@Nullable String str, @Nullable Boolean bool, @NotNull AddressInfo addressInfo2, @Nullable Boolean bool2, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(addressInfo2, "addressInfo");
        this.businessName = str;
        this.isSelected = bool;
        this.addressInfo = addressInfo2;
        this.useMailingInd = bool2;
        this.phone = str2;
        this.accountNo = str3;
    }

    @Nullable
    public final String getBusinessName() {
        return this.businessName;
    }

    @Nullable
    public final Boolean isSelected() {
        return this.isSelected;
    }

    @NotNull
    public final AddressInfo getAddressInfo() {
        return this.addressInfo;
    }

    @Nullable
    public final Boolean getUseMailingInd() {
        return this.useMailingInd;
    }

    @Nullable
    public final String getPhone() {
        return this.phone;
    }

    @Nullable
    public final String getAccountNo() {
        return this.accountNo;
    }
}
