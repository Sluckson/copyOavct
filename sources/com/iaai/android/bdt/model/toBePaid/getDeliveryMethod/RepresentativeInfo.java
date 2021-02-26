package com.iaai.android.bdt.model.toBePaid.getDeliveryMethod;

import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0001HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006&"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/RepresentativeInfo;", "", "Address", "Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;", "BusinessName", "", "Email", "IsSelected", "", "Phone", "Ljava/math/BigDecimal;", "RepresentativeName", "(Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;Ljava/lang/String;Ljava/lang/Object;ZLjava/math/BigDecimal;Ljava/lang/String;)V", "getAddress", "()Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;", "getBusinessName", "()Ljava/lang/String;", "getEmail", "()Ljava/lang/Object;", "getIsSelected", "()Z", "setIsSelected", "(Z)V", "getPhone", "()Ljava/math/BigDecimal;", "getRepresentativeName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RepresentativeInfo.kt */
public final class RepresentativeInfo {
    @NotNull
    private final Address Address;
    @NotNull
    private final String BusinessName;
    @NotNull
    private final Object Email;
    private boolean IsSelected;
    @NotNull
    private final BigDecimal Phone;
    @NotNull
    private final String RepresentativeName;

    @NotNull
    public static /* synthetic */ RepresentativeInfo copy$default(RepresentativeInfo representativeInfo, Address address, String str, Object obj, boolean z, BigDecimal bigDecimal, String str2, int i, Object obj2) {
        if ((i & 1) != 0) {
            address = representativeInfo.Address;
        }
        if ((i & 2) != 0) {
            str = representativeInfo.BusinessName;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            obj = representativeInfo.Email;
        }
        Object obj3 = obj;
        if ((i & 8) != 0) {
            z = representativeInfo.IsSelected;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            bigDecimal = representativeInfo.Phone;
        }
        BigDecimal bigDecimal2 = bigDecimal;
        if ((i & 32) != 0) {
            str2 = representativeInfo.RepresentativeName;
        }
        return representativeInfo.copy(address, str3, obj3, z2, bigDecimal2, str2);
    }

    @NotNull
    public final Address component1() {
        return this.Address;
    }

    @NotNull
    public final String component2() {
        return this.BusinessName;
    }

    @NotNull
    public final Object component3() {
        return this.Email;
    }

    public final boolean component4() {
        return this.IsSelected;
    }

    @NotNull
    public final BigDecimal component5() {
        return this.Phone;
    }

    @NotNull
    public final String component6() {
        return this.RepresentativeName;
    }

    @NotNull
    public final RepresentativeInfo copy(@NotNull Address address, @NotNull String str, @NotNull Object obj, boolean z, @NotNull BigDecimal bigDecimal, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(address, "Address");
        Intrinsics.checkParameterIsNotNull(str, "BusinessName");
        Intrinsics.checkParameterIsNotNull(obj, "Email");
        Intrinsics.checkParameterIsNotNull(bigDecimal, "Phone");
        Intrinsics.checkParameterIsNotNull(str2, "RepresentativeName");
        return new RepresentativeInfo(address, str, obj, z, bigDecimal, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RepresentativeInfo) {
                RepresentativeInfo representativeInfo = (RepresentativeInfo) obj;
                if (Intrinsics.areEqual((Object) this.Address, (Object) representativeInfo.Address) && Intrinsics.areEqual((Object) this.BusinessName, (Object) representativeInfo.BusinessName) && Intrinsics.areEqual(this.Email, representativeInfo.Email)) {
                    if (!(this.IsSelected == representativeInfo.IsSelected) || !Intrinsics.areEqual((Object) this.Phone, (Object) representativeInfo.Phone) || !Intrinsics.areEqual((Object) this.RepresentativeName, (Object) representativeInfo.RepresentativeName)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Address address = this.Address;
        int i = 0;
        int hashCode = (address != null ? address.hashCode() : 0) * 31;
        String str = this.BusinessName;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Object obj = this.Email;
        int hashCode3 = (hashCode2 + (obj != null ? obj.hashCode() : 0)) * 31;
        boolean z = this.IsSelected;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        BigDecimal bigDecimal = this.Phone;
        int hashCode4 = (i2 + (bigDecimal != null ? bigDecimal.hashCode() : 0)) * 31;
        String str2 = this.RepresentativeName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        return "RepresentativeInfo(Address=" + this.Address + ", BusinessName=" + this.BusinessName + ", Email=" + this.Email + ", IsSelected=" + this.IsSelected + ", Phone=" + this.Phone + ", RepresentativeName=" + this.RepresentativeName + ")";
    }

    public RepresentativeInfo(@NotNull Address address, @NotNull String str, @NotNull Object obj, boolean z, @NotNull BigDecimal bigDecimal, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(address, "Address");
        Intrinsics.checkParameterIsNotNull(str, "BusinessName");
        Intrinsics.checkParameterIsNotNull(obj, "Email");
        Intrinsics.checkParameterIsNotNull(bigDecimal, "Phone");
        Intrinsics.checkParameterIsNotNull(str2, "RepresentativeName");
        this.Address = address;
        this.BusinessName = str;
        this.Email = obj;
        this.IsSelected = z;
        this.Phone = bigDecimal;
        this.RepresentativeName = str2;
    }

    @NotNull
    public final Address getAddress() {
        return this.Address;
    }

    @NotNull
    public final String getBusinessName() {
        return this.BusinessName;
    }

    @NotNull
    public final Object getEmail() {
        return this.Email;
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

    @NotNull
    public final String getRepresentativeName() {
        return this.RepresentativeName;
    }
}
