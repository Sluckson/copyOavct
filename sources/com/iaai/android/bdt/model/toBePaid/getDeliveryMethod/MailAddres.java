package com.iaai.android.bdt.model.toBePaid.getDeliveryMethod;

import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006%"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/MailAddres;", "", "AccountNo", "", "Address", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;", "BusinessName", "IsSelected", "", "Phone", "Ljava/math/BigDecimal;", "UseMailingInd", "(Ljava/lang/String;Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;Ljava/lang/String;ZLjava/math/BigDecimal;Z)V", "getAccountNo", "()Ljava/lang/String;", "getAddress", "()Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;", "getBusinessName", "getIsSelected", "()Z", "setIsSelected", "(Z)V", "getPhone", "()Ljava/math/BigDecimal;", "getUseMailingInd", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MailAddres.kt */
public final class MailAddres {
    @NotNull
    private final String AccountNo;
    @NotNull
    private final Address Address;
    @NotNull
    private final String BusinessName;
    private boolean IsSelected;
    @NotNull
    private final BigDecimal Phone;
    private final boolean UseMailingInd;

    @NotNull
    public static /* synthetic */ MailAddres copy$default(MailAddres mailAddres, String str, Address address, String str2, boolean z, BigDecimal bigDecimal, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mailAddres.AccountNo;
        }
        if ((i & 2) != 0) {
            address = mailAddres.Address;
        }
        Address address2 = address;
        if ((i & 4) != 0) {
            str2 = mailAddres.BusinessName;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = mailAddres.IsSelected;
        }
        boolean z3 = z;
        if ((i & 16) != 0) {
            bigDecimal = mailAddres.Phone;
        }
        BigDecimal bigDecimal2 = bigDecimal;
        if ((i & 32) != 0) {
            z2 = mailAddres.UseMailingInd;
        }
        return mailAddres.copy(str, address2, str3, z3, bigDecimal2, z2);
    }

    @NotNull
    public final String component1() {
        return this.AccountNo;
    }

    @NotNull
    public final Address component2() {
        return this.Address;
    }

    @NotNull
    public final String component3() {
        return this.BusinessName;
    }

    public final boolean component4() {
        return this.IsSelected;
    }

    @NotNull
    public final BigDecimal component5() {
        return this.Phone;
    }

    public final boolean component6() {
        return this.UseMailingInd;
    }

    @NotNull
    public final MailAddres copy(@NotNull String str, @NotNull Address address, @NotNull String str2, boolean z, @NotNull BigDecimal bigDecimal, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "AccountNo");
        Intrinsics.checkParameterIsNotNull(address, "Address");
        Intrinsics.checkParameterIsNotNull(str2, "BusinessName");
        Intrinsics.checkParameterIsNotNull(bigDecimal, "Phone");
        return new MailAddres(str, address, str2, z, bigDecimal, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MailAddres) {
                MailAddres mailAddres = (MailAddres) obj;
                if (Intrinsics.areEqual((Object) this.AccountNo, (Object) mailAddres.AccountNo) && Intrinsics.areEqual((Object) this.Address, (Object) mailAddres.Address) && Intrinsics.areEqual((Object) this.BusinessName, (Object) mailAddres.BusinessName)) {
                    if ((this.IsSelected == mailAddres.IsSelected) && Intrinsics.areEqual((Object) this.Phone, (Object) mailAddres.Phone)) {
                        if (this.UseMailingInd == mailAddres.UseMailingInd) {
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
        String str = this.AccountNo;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Address address = this.Address;
        int hashCode2 = (hashCode + (address != null ? address.hashCode() : 0)) * 31;
        String str2 = this.BusinessName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z = this.IsSelected;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        BigDecimal bigDecimal = this.Phone;
        if (bigDecimal != null) {
            i = bigDecimal.hashCode();
        }
        int i3 = (i2 + i) * 31;
        boolean z2 = this.UseMailingInd;
        if (z2) {
            z2 = true;
        }
        return i3 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "MailAddres(AccountNo=" + this.AccountNo + ", Address=" + this.Address + ", BusinessName=" + this.BusinessName + ", IsSelected=" + this.IsSelected + ", Phone=" + this.Phone + ", UseMailingInd=" + this.UseMailingInd + ")";
    }

    public MailAddres(@NotNull String str, @NotNull Address address, @NotNull String str2, boolean z, @NotNull BigDecimal bigDecimal, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "AccountNo");
        Intrinsics.checkParameterIsNotNull(address, "Address");
        Intrinsics.checkParameterIsNotNull(str2, "BusinessName");
        Intrinsics.checkParameterIsNotNull(bigDecimal, "Phone");
        this.AccountNo = str;
        this.Address = address;
        this.BusinessName = str2;
        this.IsSelected = z;
        this.Phone = bigDecimal;
        this.UseMailingInd = z2;
    }

    @NotNull
    public final String getAccountNo() {
        return this.AccountNo;
    }

    @NotNull
    public final Address getAddress() {
        return this.Address;
    }

    @NotNull
    public final String getBusinessName() {
        return this.BusinessName;
    }

    public final boolean getIsSelected() {
        return this.IsSelected;
    }

    public final void setIsSelected(boolean z) {
        this.IsSelected = z;
    }

    @NotNull
    public final BigDecimal getPhone() {
        return this.Phone;
    }

    public final boolean getUseMailingInd() {
        return this.UseMailingInd;
    }
}
