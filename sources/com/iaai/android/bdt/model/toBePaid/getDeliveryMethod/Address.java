package com.iaai.android.bdt.model.toBePaid.getDeliveryMethod;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/getDeliveryMethod/Address;", "", "Address1", "", "Address2", "City", "Country", "State", "ZipCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress1", "()Ljava/lang/String;", "getAddress2", "getCity", "getCountry", "getState", "getZipCode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Address.kt */
public final class Address {
    @Nullable
    private final String Address1;
    @Nullable
    private final String Address2;
    @Nullable
    private final String City;
    @Nullable
    private final String Country;
    @Nullable
    private final String State;
    @Nullable
    private final String ZipCode;

    @NotNull
    public static /* synthetic */ Address copy$default(Address address, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = address.Address1;
        }
        if ((i & 2) != 0) {
            str2 = address.Address2;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = address.City;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = address.Country;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = address.State;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = address.ZipCode;
        }
        return address.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    public final String component1() {
        return this.Address1;
    }

    @Nullable
    public final String component2() {
        return this.Address2;
    }

    @Nullable
    public final String component3() {
        return this.City;
    }

    @Nullable
    public final String component4() {
        return this.Country;
    }

    @Nullable
    public final String component5() {
        return this.State;
    }

    @Nullable
    public final String component6() {
        return this.ZipCode;
    }

    @NotNull
    public final Address copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return new Address(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return Intrinsics.areEqual((Object) this.Address1, (Object) address.Address1) && Intrinsics.areEqual((Object) this.Address2, (Object) address.Address2) && Intrinsics.areEqual((Object) this.City, (Object) address.City) && Intrinsics.areEqual((Object) this.Country, (Object) address.Country) && Intrinsics.areEqual((Object) this.State, (Object) address.State) && Intrinsics.areEqual((Object) this.ZipCode, (Object) address.ZipCode);
    }

    public int hashCode() {
        String str = this.Address1;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.Address2;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.City;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.Country;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.State;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.ZipCode;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        return "Address(Address1=" + this.Address1 + ", Address2=" + this.Address2 + ", City=" + this.City + ", Country=" + this.Country + ", State=" + this.State + ", ZipCode=" + this.ZipCode + ")";
    }

    public Address(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.Address1 = str;
        this.Address2 = str2;
        this.City = str3;
        this.Country = str4;
        this.State = str5;
        this.ZipCode = str6;
    }

    @Nullable
    public final String getAddress1() {
        return this.Address1;
    }

    @Nullable
    public final String getAddress2() {
        return this.Address2;
    }

    @Nullable
    public final String getCity() {
        return this.City;
    }

    @Nullable
    public final String getCountry() {
        return this.Country;
    }

    @Nullable
    public final String getState() {
        return this.State;
    }

    @Nullable
    public final String getZipCode() {
        return this.ZipCode;
    }
}
