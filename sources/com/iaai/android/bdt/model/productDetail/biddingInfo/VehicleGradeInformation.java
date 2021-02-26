package com.iaai.android.bdt.model.productDetail.biddingInfo;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VehicleGradeInformation;", "Ljava/io/Serializable;", "IsVehicleGrade", "", "VehicleGradeValue", "", "VehicleGradePercent", "", "SalesForceVehicleConditionGradeURL", "(ZLjava/lang/String;ILjava/lang/String;)V", "getIsVehicleGrade", "()Z", "getSalesForceVehicleConditionGradeURL", "()Ljava/lang/String;", "getVehicleGradePercent", "()I", "getVehicleGradeValue", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: VehicleGradeInformation.kt */
public final class VehicleGradeInformation implements Serializable {
    private final boolean IsVehicleGrade;
    @NotNull
    private final String SalesForceVehicleConditionGradeURL;
    private final int VehicleGradePercent;
    @NotNull
    private final String VehicleGradeValue;

    @NotNull
    public static /* synthetic */ VehicleGradeInformation copy$default(VehicleGradeInformation vehicleGradeInformation, boolean z, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = vehicleGradeInformation.IsVehicleGrade;
        }
        if ((i2 & 2) != 0) {
            str = vehicleGradeInformation.VehicleGradeValue;
        }
        if ((i2 & 4) != 0) {
            i = vehicleGradeInformation.VehicleGradePercent;
        }
        if ((i2 & 8) != 0) {
            str2 = vehicleGradeInformation.SalesForceVehicleConditionGradeURL;
        }
        return vehicleGradeInformation.copy(z, str, i, str2);
    }

    public final boolean component1() {
        return this.IsVehicleGrade;
    }

    @NotNull
    public final String component2() {
        return this.VehicleGradeValue;
    }

    public final int component3() {
        return this.VehicleGradePercent;
    }

    @NotNull
    public final String component4() {
        return this.SalesForceVehicleConditionGradeURL;
    }

    @NotNull
    public final VehicleGradeInformation copy(boolean z, @NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "VehicleGradeValue");
        Intrinsics.checkParameterIsNotNull(str2, "SalesForceVehicleConditionGradeURL");
        return new VehicleGradeInformation(z, str, i, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof VehicleGradeInformation) {
                VehicleGradeInformation vehicleGradeInformation = (VehicleGradeInformation) obj;
                if ((this.IsVehicleGrade == vehicleGradeInformation.IsVehicleGrade) && Intrinsics.areEqual((Object) this.VehicleGradeValue, (Object) vehicleGradeInformation.VehicleGradeValue)) {
                    if (!(this.VehicleGradePercent == vehicleGradeInformation.VehicleGradePercent) || !Intrinsics.areEqual((Object) this.SalesForceVehicleConditionGradeURL, (Object) vehicleGradeInformation.SalesForceVehicleConditionGradeURL)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.IsVehicleGrade;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.VehicleGradeValue;
        int i2 = 0;
        int hashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + Integer.valueOf(this.VehicleGradePercent).hashCode()) * 31;
        String str2 = this.SalesForceVehicleConditionGradeURL;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        return "VehicleGradeInformation(IsVehicleGrade=" + this.IsVehicleGrade + ", VehicleGradeValue=" + this.VehicleGradeValue + ", VehicleGradePercent=" + this.VehicleGradePercent + ", SalesForceVehicleConditionGradeURL=" + this.SalesForceVehicleConditionGradeURL + ")";
    }

    public VehicleGradeInformation(boolean z, @NotNull String str, int i, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "VehicleGradeValue");
        Intrinsics.checkParameterIsNotNull(str2, "SalesForceVehicleConditionGradeURL");
        this.IsVehicleGrade = z;
        this.VehicleGradeValue = str;
        this.VehicleGradePercent = i;
        this.SalesForceVehicleConditionGradeURL = str2;
    }

    public final boolean getIsVehicleGrade() {
        return this.IsVehicleGrade;
    }

    @NotNull
    public final String getVehicleGradeValue() {
        return this.VehicleGradeValue;
    }

    public final int getVehicleGradePercent() {
        return this.VehicleGradePercent;
    }

    @NotNull
    public final String getSalesForceVehicleConditionGradeURL() {
        return this.SalesForceVehicleConditionGradeURL;
    }
}
