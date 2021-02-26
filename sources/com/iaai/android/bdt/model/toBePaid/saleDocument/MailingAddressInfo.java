package com.iaai.android.bdt.model.toBePaid.saleDocument;

import com.iaai.android.bdt.model.toBePaid.getDeliveryMethod.Address;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/saleDocument/MailingAddressInfo;", "", "accountNo", "", "address", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;", "businessName", "isSelected", "", "phone", "Ljava/math/BigDecimal;", "useMailingInd", "(Ljava/lang/String;Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;Ljava/lang/String;ZLjava/math/BigDecimal;Z)V", "getAccountNo", "()Ljava/lang/String;", "getAddress", "()Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;", "getBusinessName", "()Z", "getPhone", "()Ljava/math/BigDecimal;", "getUseMailingInd", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MailingAddressInfo.kt */
public final class MailingAddressInfo {
    @NotNull
    private final String accountNo;
    @NotNull
    private final Address address;
    @NotNull
    private final String businessName;
    private final boolean isSelected;
    @NotNull
    private final BigDecimal phone;
    private final boolean useMailingInd;

    @NotNull
    public static /* synthetic */ MailingAddressInfo copy$default(MailingAddressInfo mailingAddressInfo, String str, Address address2, String str2, boolean z, BigDecimal bigDecimal, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mailingAddressInfo.accountNo;
        }
        if ((i & 2) != 0) {
            address2 = mailingAddressInfo.address;
        }
        Address address3 = address2;
        if ((i & 4) != 0) {
            str2 = mailingAddressInfo.businessName;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = mailingAddressInfo.isSelected;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            bigDecimal = mailingAddressInfo.phone;
        }
        BigDecimal bigDecimal2 = bigDecimal;
        if ((i & 32) != 0) {
            z2 = mailingAddressInfo.useMailingInd;
        }
        return mailingAddressInfo.copy(str, address3, str3, z3, bigDecimal2, z2);
    }

    @NotNull
    public final String component1() {
        return this.accountNo;
    }

    @NotNull
    public final Address component2() {
        return this.address;
    }

    @NotNull
    public final String component3() {
        return this.businessName;
    }

    public final boolean component4() {
        return this.isSelected;
    }

    @NotNull
    public final BigDecimal component5() {
        return this.phone;
    }

    public final boolean component6() {
        return this.useMailingInd;
    }

    @NotNull
    public final MailingAddressInfo copy(@NotNull String str, @NotNull Address address2, @NotNull String str2, boolean z, @NotNull BigDecimal bigDecimal, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "accountNo");
        Intrinsics.checkParameterIsNotNull(address2, "address");
        Intrinsics.checkParameterIsNotNull(str2, "businessName");
        Intrinsics.checkParameterIsNotNull(bigDecimal, "phone");
        return new MailingAddressInfo(str, address2, str2, z, bigDecimal, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MailingAddressInfo) {
                MailingAddressInfo mailingAddressInfo = (MailingAddressInfo) obj;
                if (Intrinsics.areEqual((Object) this.accountNo, (Object) mailingAddressInfo.accountNo) && Intrinsics.areEqual((Object) this.address, (Object) mailingAddressInfo.address) && Intrinsics.areEqual((Object) this.businessName, (Object) mailingAddressInfo.businessName)) {
                    if ((this.isSelected == mailingAddressInfo.isSelected) && Intrinsics.areEqual((Object) this.phone, (Object) mailingAddressInfo.phone)) {
                        if (this.useMailingInd == mailingAddressInfo.useMailingInd) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.accountNo;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Address address2 = this.address;
        int hashCode2 = (hashCode + (address2 != null ? address2.hashCode() : 0)) * 31;
        String str2 = this.businessName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        BigDecimal bigDecimal = this.phone;
        if (bigDecimal != null) {
            i = bigDecimal.hashCode();
        }
        int i3 = (i2 + i) * 31;
        boolean z2 = this.useMailingInd;
        if (z2) {
            z2 = true;
        }
        return i3 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "MailingAddressInfo(accountNo=" + this.accountNo + ", address=" + this.address + ", businessName=" + this.businessName + ", isSelected=" + this.isSelected + ", phone=" + this.phone + ", useMailingInd=" + this.useMailingInd + ")";
    }

    public MailingAddressInfo(@NotNull String str, @NotNull Address address2, @NotNull String str2, boolean z, @NotNull BigDecimal bigDecimal, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "accountNo");
        Intrinsics.checkParameterIsNotNull(address2, "address");
        Intrinsics.checkParameterIsNotNull(str2, "businessName");
        Intrinsics.checkParameterIsNotNull(bigDecimal, "phone");
        this.accountNo = str;
        this.address = address2;
        this.businessName = str2;
        this.isSelected = z;
        this.phone = bigDecimal;
        this.useMailingInd = z2;
    }

    @NotNull
    public final String getAccountNo() {
        return this.accountNo;
    }

    @NotNull
    public final Address getAddress() {
        return this.address;
    }

    @NotNull
    public final String getBusinessName() {
        return this.businessName;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    @NotNull
    public final BigDecimal getPhone() {
        return this.phone;
    }

    public final boolean getUseMailingInd() {
        return this.useMailingInd;
    }
}
