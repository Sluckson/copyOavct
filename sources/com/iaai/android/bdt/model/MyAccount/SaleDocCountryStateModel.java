package com.iaai.android.bdt.model.MyAccount;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/SaleDocCountryStateModel;", "", "CountryCode", "", "CountryName", "StateCode", "StateName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCountryCode", "()Ljava/lang/String;", "getCountryName", "getStateCode", "getStateName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleDocCountryStateModel.kt */
public final class SaleDocCountryStateModel {
    @NotNull
    private final String CountryCode;
    @NotNull
    private final String CountryName;
    @NotNull
    private final String StateCode;
    @NotNull
    private final String StateName;

    @NotNull
    public static /* synthetic */ SaleDocCountryStateModel copy$default(SaleDocCountryStateModel saleDocCountryStateModel, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = saleDocCountryStateModel.CountryCode;
        }
        if ((i & 2) != 0) {
            str2 = saleDocCountryStateModel.CountryName;
        }
        if ((i & 4) != 0) {
            str3 = saleDocCountryStateModel.StateCode;
        }
        if ((i & 8) != 0) {
            str4 = saleDocCountryStateModel.StateName;
        }
        return saleDocCountryStateModel.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.CountryCode;
    }

    @NotNull
    public final String component2() {
        return this.CountryName;
    }

    @NotNull
    public final String component3() {
        return this.StateCode;
    }

    @NotNull
    public final String component4() {
        return this.StateName;
    }

    @NotNull
    public final SaleDocCountryStateModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "CountryCode");
        Intrinsics.checkParameterIsNotNull(str2, "CountryName");
        Intrinsics.checkParameterIsNotNull(str3, "StateCode");
        Intrinsics.checkParameterIsNotNull(str4, "StateName");
        return new SaleDocCountryStateModel(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SaleDocCountryStateModel)) {
            return false;
        }
        SaleDocCountryStateModel saleDocCountryStateModel = (SaleDocCountryStateModel) obj;
        return Intrinsics.areEqual((Object) this.CountryCode, (Object) saleDocCountryStateModel.CountryCode) && Intrinsics.areEqual((Object) this.CountryName, (Object) saleDocCountryStateModel.CountryName) && Intrinsics.areEqual((Object) this.StateCode, (Object) saleDocCountryStateModel.StateCode) && Intrinsics.areEqual((Object) this.StateName, (Object) saleDocCountryStateModel.StateName);
    }

    public int hashCode() {
        String str = this.CountryCode;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.CountryName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.StateCode;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.StateName;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "SaleDocCountryStateModel(CountryCode=" + this.CountryCode + ", CountryName=" + this.CountryName + ", StateCode=" + this.StateCode + ", StateName=" + this.StateName + ")";
    }

    public SaleDocCountryStateModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkParameterIsNotNull(str, "CountryCode");
        Intrinsics.checkParameterIsNotNull(str2, "CountryName");
        Intrinsics.checkParameterIsNotNull(str3, "StateCode");
        Intrinsics.checkParameterIsNotNull(str4, "StateName");
        this.CountryCode = str;
        this.CountryName = str2;
        this.StateCode = str3;
        this.StateName = str4;
    }

    @NotNull
    public final String getCountryCode() {
        return this.CountryCode;
    }

    @NotNull
    public final String getCountryName() {
        return this.CountryName;
    }

    @NotNull
    public final String getStateCode() {
        return this.StateCode;
    }

    @NotNull
    public final String getStateName() {
        return this.StateName;
    }
}
