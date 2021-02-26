package com.iaai.android.bdt.model.MyAccount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b-\b\b\u0018\u00002\u00020\u0001B}\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0005HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013¨\u00065"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/ManageBranchModel;", "", "DisplayName", "", "DisplayCount", "", "TypeCode", "IsSelected", "", "CompanyName", "Address1", "Address2", "PhoneNo", "City", "State", "ZipCode", "Country", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress1", "()Ljava/lang/String;", "getAddress2", "getCity", "getCompanyName", "getCountry", "getDisplayCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDisplayName", "getIsSelected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPhoneNo", "getState", "getTypeCode", "getZipCode", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/iaai/android/bdt/model/MyAccount/ManageBranchModel;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageBranchModel.kt */
public final class ManageBranchModel {
    @Nullable
    private final String Address1;
    @Nullable
    private final String Address2;
    @Nullable
    private final String City;
    @Nullable
    private final String CompanyName;
    @Nullable
    private final String Country;
    @Nullable
    private final Integer DisplayCount;
    @Nullable
    private final String DisplayName;
    @Nullable
    private final Boolean IsSelected;
    @Nullable
    private final String PhoneNo;
    @Nullable
    private final String State;
    @Nullable
    private final String TypeCode;
    @Nullable
    private final String ZipCode;

    @NotNull
    public static /* synthetic */ ManageBranchModel copy$default(ManageBranchModel manageBranchModel, String str, Integer num, String str2, Boolean bool, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        ManageBranchModel manageBranchModel2 = manageBranchModel;
        int i2 = i;
        return manageBranchModel.copy((i2 & 1) != 0 ? manageBranchModel2.DisplayName : str, (i2 & 2) != 0 ? manageBranchModel2.DisplayCount : num, (i2 & 4) != 0 ? manageBranchModel2.TypeCode : str2, (i2 & 8) != 0 ? manageBranchModel2.IsSelected : bool, (i2 & 16) != 0 ? manageBranchModel2.CompanyName : str3, (i2 & 32) != 0 ? manageBranchModel2.Address1 : str4, (i2 & 64) != 0 ? manageBranchModel2.Address2 : str5, (i2 & 128) != 0 ? manageBranchModel2.PhoneNo : str6, (i2 & 256) != 0 ? manageBranchModel2.City : str7, (i2 & 512) != 0 ? manageBranchModel2.State : str8, (i2 & 1024) != 0 ? manageBranchModel2.ZipCode : str9, (i2 & 2048) != 0 ? manageBranchModel2.Country : str10);
    }

    @Nullable
    public final String component1() {
        return this.DisplayName;
    }

    @Nullable
    public final String component10() {
        return this.State;
    }

    @Nullable
    public final String component11() {
        return this.ZipCode;
    }

    @Nullable
    public final String component12() {
        return this.Country;
    }

    @Nullable
    public final Integer component2() {
        return this.DisplayCount;
    }

    @Nullable
    public final String component3() {
        return this.TypeCode;
    }

    @Nullable
    public final Boolean component4() {
        return this.IsSelected;
    }

    @Nullable
    public final String component5() {
        return this.CompanyName;
    }

    @Nullable
    public final String component6() {
        return this.Address1;
    }

    @Nullable
    public final String component7() {
        return this.Address2;
    }

    @Nullable
    public final String component8() {
        return this.PhoneNo;
    }

    @Nullable
    public final String component9() {
        return this.City;
    }

    @NotNull
    public final ManageBranchModel copy(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        return new ManageBranchModel(str, num, str2, bool, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ManageBranchModel)) {
            return false;
        }
        ManageBranchModel manageBranchModel = (ManageBranchModel) obj;
        return Intrinsics.areEqual((Object) this.DisplayName, (Object) manageBranchModel.DisplayName) && Intrinsics.areEqual((Object) this.DisplayCount, (Object) manageBranchModel.DisplayCount) && Intrinsics.areEqual((Object) this.TypeCode, (Object) manageBranchModel.TypeCode) && Intrinsics.areEqual((Object) this.IsSelected, (Object) manageBranchModel.IsSelected) && Intrinsics.areEqual((Object) this.CompanyName, (Object) manageBranchModel.CompanyName) && Intrinsics.areEqual((Object) this.Address1, (Object) manageBranchModel.Address1) && Intrinsics.areEqual((Object) this.Address2, (Object) manageBranchModel.Address2) && Intrinsics.areEqual((Object) this.PhoneNo, (Object) manageBranchModel.PhoneNo) && Intrinsics.areEqual((Object) this.City, (Object) manageBranchModel.City) && Intrinsics.areEqual((Object) this.State, (Object) manageBranchModel.State) && Intrinsics.areEqual((Object) this.ZipCode, (Object) manageBranchModel.ZipCode) && Intrinsics.areEqual((Object) this.Country, (Object) manageBranchModel.Country);
    }

    public int hashCode() {
        String str = this.DisplayName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.DisplayCount;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.TypeCode;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.IsSelected;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str3 = this.CompanyName;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.Address1;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.Address2;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.PhoneNo;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.City;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.State;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.ZipCode;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.Country;
        if (str10 != null) {
            i = str10.hashCode();
        }
        return hashCode11 + i;
    }

    @NotNull
    public String toString() {
        return "ManageBranchModel(DisplayName=" + this.DisplayName + ", DisplayCount=" + this.DisplayCount + ", TypeCode=" + this.TypeCode + ", IsSelected=" + this.IsSelected + ", CompanyName=" + this.CompanyName + ", Address1=" + this.Address1 + ", Address2=" + this.Address2 + ", PhoneNo=" + this.PhoneNo + ", City=" + this.City + ", State=" + this.State + ", ZipCode=" + this.ZipCode + ", Country=" + this.Country + ")";
    }

    public ManageBranchModel(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        this.DisplayName = str;
        this.DisplayCount = num;
        this.TypeCode = str2;
        this.IsSelected = bool;
        this.CompanyName = str3;
        this.Address1 = str4;
        this.Address2 = str5;
        this.PhoneNo = str6;
        this.City = str7;
        this.State = str8;
        this.ZipCode = str9;
        this.Country = str10;
    }

    @Nullable
    public final String getDisplayName() {
        return this.DisplayName;
    }

    @Nullable
    public final Integer getDisplayCount() {
        return this.DisplayCount;
    }

    @Nullable
    public final String getTypeCode() {
        return this.TypeCode;
    }

    @Nullable
    public final Boolean getIsSelected() {
        return this.IsSelected;
    }

    @Nullable
    public final String getCompanyName() {
        return this.CompanyName;
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
    public final String getPhoneNo() {
        return this.PhoneNo;
    }

    @Nullable
    public final String getCity() {
        return this.City;
    }

    @Nullable
    public final String getState() {
        return this.State;
    }

    @Nullable
    public final String getZipCode() {
        return this.ZipCode;
    }

    @Nullable
    public final String getCountry() {
        return this.Country;
    }
}
