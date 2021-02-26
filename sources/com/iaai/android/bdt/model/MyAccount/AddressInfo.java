package com.iaai.android.bdt.model.MyAccount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/AddressInfo;", "", "address1", "", "address2", "city", "state", "zipCode", "country", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress1", "()Ljava/lang/String;", "getAddress2", "getCity", "getCountry", "getState", "getZipCode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AddressInfo.kt */
public final class AddressInfo {
    @Nullable
    private final String address1;
    @Nullable
    private final String address2;
    @Nullable
    private final String city;
    @Nullable
    private final String country;
    @Nullable
    private final String state;
    @Nullable
    private final String zipCode;

    @NotNull
    public static /* synthetic */ AddressInfo copy$default(AddressInfo addressInfo, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = addressInfo.address1;
        }
        if ((i & 2) != 0) {
            str2 = addressInfo.address2;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = addressInfo.city;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = addressInfo.state;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = addressInfo.zipCode;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = addressInfo.country;
        }
        return addressInfo.copy(str, str7, str8, str9, str10, str6);
    }

    @Nullable
    public final String component1() {
        return this.address1;
    }

    @Nullable
    public final String component2() {
        return this.address2;
    }

    @Nullable
    public final String component3() {
        return this.city;
    }

    @Nullable
    public final String component4() {
        return this.state;
    }

    @Nullable
    public final String component5() {
        return this.zipCode;
    }

    @Nullable
    public final String component6() {
        return this.country;
    }

    @NotNull
    public final AddressInfo copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return new AddressInfo(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressInfo)) {
            return false;
        }
        AddressInfo addressInfo = (AddressInfo) obj;
        return Intrinsics.areEqual((Object) this.address1, (Object) addressInfo.address1) && Intrinsics.areEqual((Object) this.address2, (Object) addressInfo.address2) && Intrinsics.areEqual((Object) this.city, (Object) addressInfo.city) && Intrinsics.areEqual((Object) this.state, (Object) addressInfo.state) && Intrinsics.areEqual((Object) this.zipCode, (Object) addressInfo.zipCode) && Intrinsics.areEqual((Object) this.country, (Object) addressInfo.country);
    }

    public int hashCode() {
        String str = this.address1;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.address2;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.city;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.state;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.zipCode;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.country;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        return "AddressInfo(address1=" + this.address1 + ", address2=" + this.address2 + ", city=" + this.city + ", state=" + this.state + ", zipCode=" + this.zipCode + ", country=" + this.country + ")";
    }

    public AddressInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.address1 = str;
        this.address2 = str2;
        this.city = str3;
        this.state = str4;
        this.zipCode = str5;
        this.country = str6;
    }

    @Nullable
    public final String getAddress1() {
        return this.address1;
    }

    @Nullable
    public final String getAddress2() {
        return this.address2;
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    @Nullable
    public final String getState() {
        return this.state;
    }

    @Nullable
    public final String getZipCode() {
        return this.zipCode;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }
}
