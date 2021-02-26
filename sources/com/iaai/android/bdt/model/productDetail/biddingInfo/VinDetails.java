package com.iaai.android.bdt.model.productDetail.biddingInfo;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Js\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\u0013\u0010)\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006/"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VinDetails;", "Ljava/io/Serializable;", "VIN", "", "VINStatus", "VehicleType", "ManufacturedIn", "Model", "Series", "PartsIndicator", "", "ChromeIndicator", "VinToolTip", "VINInfo", "", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/VINInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/List;)V", "getChromeIndicator", "()Z", "getManufacturedIn", "()Ljava/lang/String;", "getModel", "getPartsIndicator", "getSeries", "getVIN", "getVINInfo", "()Ljava/util/List;", "getVINStatus", "getVehicleType", "getVinToolTip", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: VinDetails.kt */
public final class VinDetails implements Serializable {
    private final boolean ChromeIndicator;
    @NotNull
    private final String ManufacturedIn;
    @NotNull
    private final String Model;
    private final boolean PartsIndicator;
    @NotNull
    private final String Series;
    @NotNull
    private final String VIN;
    @NotNull
    private final List<VINInfo> VINInfo;
    @NotNull
    private final String VINStatus;
    @NotNull
    private final String VehicleType;
    @NotNull
    private final String VinToolTip;

    @NotNull
    public static /* synthetic */ VinDetails copy$default(VinDetails vinDetails, String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, String str7, List list, int i, Object obj) {
        VinDetails vinDetails2 = vinDetails;
        int i2 = i;
        return vinDetails.copy((i2 & 1) != 0 ? vinDetails2.VIN : str, (i2 & 2) != 0 ? vinDetails2.VINStatus : str2, (i2 & 4) != 0 ? vinDetails2.VehicleType : str3, (i2 & 8) != 0 ? vinDetails2.ManufacturedIn : str4, (i2 & 16) != 0 ? vinDetails2.Model : str5, (i2 & 32) != 0 ? vinDetails2.Series : str6, (i2 & 64) != 0 ? vinDetails2.PartsIndicator : z, (i2 & 128) != 0 ? vinDetails2.ChromeIndicator : z2, (i2 & 256) != 0 ? vinDetails2.VinToolTip : str7, (i2 & 512) != 0 ? vinDetails2.VINInfo : list);
    }

    @NotNull
    public final String component1() {
        return this.VIN;
    }

    @NotNull
    public final List<VINInfo> component10() {
        return this.VINInfo;
    }

    @NotNull
    public final String component2() {
        return this.VINStatus;
    }

    @NotNull
    public final String component3() {
        return this.VehicleType;
    }

    @NotNull
    public final String component4() {
        return this.ManufacturedIn;
    }

    @NotNull
    public final String component5() {
        return this.Model;
    }

    @NotNull
    public final String component6() {
        return this.Series;
    }

    public final boolean component7() {
        return this.PartsIndicator;
    }

    public final boolean component8() {
        return this.ChromeIndicator;
    }

    @NotNull
    public final String component9() {
        return this.VinToolTip;
    }

    @NotNull
    public final VinDetails copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z, boolean z2, @NotNull String str7, @NotNull List<VINInfo> list) {
        Intrinsics.checkParameterIsNotNull(str, "VIN");
        Intrinsics.checkParameterIsNotNull(str2, "VINStatus");
        Intrinsics.checkParameterIsNotNull(str3, "VehicleType");
        String str8 = str4;
        Intrinsics.checkParameterIsNotNull(str8, "ManufacturedIn");
        String str9 = str5;
        Intrinsics.checkParameterIsNotNull(str9, ExifInterface.TAG_MODEL);
        String str10 = str6;
        Intrinsics.checkParameterIsNotNull(str10, "Series");
        String str11 = str7;
        Intrinsics.checkParameterIsNotNull(str11, "VinToolTip");
        List<VINInfo> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "VINInfo");
        return new VinDetails(str, str2, str3, str8, str9, str10, z, z2, str11, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof VinDetails) {
                VinDetails vinDetails = (VinDetails) obj;
                if (Intrinsics.areEqual((Object) this.VIN, (Object) vinDetails.VIN) && Intrinsics.areEqual((Object) this.VINStatus, (Object) vinDetails.VINStatus) && Intrinsics.areEqual((Object) this.VehicleType, (Object) vinDetails.VehicleType) && Intrinsics.areEqual((Object) this.ManufacturedIn, (Object) vinDetails.ManufacturedIn) && Intrinsics.areEqual((Object) this.Model, (Object) vinDetails.Model) && Intrinsics.areEqual((Object) this.Series, (Object) vinDetails.Series)) {
                    if (this.PartsIndicator == vinDetails.PartsIndicator) {
                        if (!(this.ChromeIndicator == vinDetails.ChromeIndicator) || !Intrinsics.areEqual((Object) this.VinToolTip, (Object) vinDetails.VinToolTip) || !Intrinsics.areEqual((Object) this.VINInfo, (Object) vinDetails.VINInfo)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.VIN;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.VINStatus;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.VehicleType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ManufacturedIn;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.Model;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.Series;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z = this.PartsIndicator;
        if (z) {
            z = true;
        }
        int i2 = (hashCode6 + (z ? 1 : 0)) * 31;
        boolean z2 = this.ChromeIndicator;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        String str7 = this.VinToolTip;
        int hashCode7 = (i3 + (str7 != null ? str7.hashCode() : 0)) * 31;
        List<VINInfo> list = this.VINInfo;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode7 + i;
    }

    @NotNull
    public String toString() {
        return "VinDetails(VIN=" + this.VIN + ", VINStatus=" + this.VINStatus + ", VehicleType=" + this.VehicleType + ", ManufacturedIn=" + this.ManufacturedIn + ", Model=" + this.Model + ", Series=" + this.Series + ", PartsIndicator=" + this.PartsIndicator + ", ChromeIndicator=" + this.ChromeIndicator + ", VinToolTip=" + this.VinToolTip + ", VINInfo=" + this.VINInfo + ")";
    }

    public VinDetails(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z, boolean z2, @NotNull String str7, @NotNull List<VINInfo> list) {
        Intrinsics.checkParameterIsNotNull(str, "VIN");
        Intrinsics.checkParameterIsNotNull(str2, "VINStatus");
        Intrinsics.checkParameterIsNotNull(str3, "VehicleType");
        Intrinsics.checkParameterIsNotNull(str4, "ManufacturedIn");
        Intrinsics.checkParameterIsNotNull(str5, ExifInterface.TAG_MODEL);
        Intrinsics.checkParameterIsNotNull(str6, "Series");
        Intrinsics.checkParameterIsNotNull(str7, "VinToolTip");
        Intrinsics.checkParameterIsNotNull(list, "VINInfo");
        this.VIN = str;
        this.VINStatus = str2;
        this.VehicleType = str3;
        this.ManufacturedIn = str4;
        this.Model = str5;
        this.Series = str6;
        this.PartsIndicator = z;
        this.ChromeIndicator = z2;
        this.VinToolTip = str7;
        this.VINInfo = list;
    }

    @NotNull
    public final String getVIN() {
        return this.VIN;
    }

    @NotNull
    public final String getVINStatus() {
        return this.VINStatus;
    }

    @NotNull
    public final String getVehicleType() {
        return this.VehicleType;
    }

    @NotNull
    public final String getManufacturedIn() {
        return this.ManufacturedIn;
    }

    @NotNull
    public final String getModel() {
        return this.Model;
    }

    @NotNull
    public final String getSeries() {
        return this.Series;
    }

    public final boolean getPartsIndicator() {
        return this.PartsIndicator;
    }

    public final boolean getChromeIndicator() {
        return this.ChromeIndicator;
    }

    @NotNull
    public final String getVinToolTip() {
        return this.VinToolTip;
    }

    @NotNull
    public final List<VINInfo> getVINInfo() {
        return this.VINInfo;
    }
}
