package com.iaai.android.bdt.model.recommendedVehicles;

import androidx.exifinterface.media.ExifInterface;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0007HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017¨\u00064"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/recommendedVehicles/RecommendedVehiclesResponse;", "", "BadgeType", "", "BranchCode", "BranchName", "Itemid", "", "LossType", "Make", "Model", "RecommendationsID", "SeriesName", "State", "ThumbnailUrl", "Title", "Year", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBadgeType", "()Ljava/lang/String;", "getBranchCode", "getBranchName", "getItemid", "()I", "getLossType", "getMake", "getModel", "getRecommendationsID", "getSeriesName", "getState", "getThumbnailUrl", "getTitle", "getYear", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RecommendedVehiclesResponse.kt */
public final class RecommendedVehiclesResponse {
    @NotNull
    private final String BadgeType;
    @NotNull
    private final String BranchCode;
    @NotNull
    private final String BranchName;
    private final int Itemid;
    @NotNull
    private final String LossType;
    @NotNull
    private final String Make;
    @NotNull
    private final String Model;
    private final int RecommendationsID;
    @NotNull
    private final String SeriesName;
    @NotNull
    private final String State;
    @NotNull
    private final String ThumbnailUrl;
    @NotNull
    private final String Title;
    private final int Year;

    @NotNull
    public static /* synthetic */ RecommendedVehiclesResponse copy$default(RecommendedVehiclesResponse recommendedVehiclesResponse, String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, String str7, String str8, String str9, String str10, int i3, int i4, Object obj) {
        RecommendedVehiclesResponse recommendedVehiclesResponse2 = recommendedVehiclesResponse;
        int i5 = i4;
        return recommendedVehiclesResponse.copy((i5 & 1) != 0 ? recommendedVehiclesResponse2.BadgeType : str, (i5 & 2) != 0 ? recommendedVehiclesResponse2.BranchCode : str2, (i5 & 4) != 0 ? recommendedVehiclesResponse2.BranchName : str3, (i5 & 8) != 0 ? recommendedVehiclesResponse2.Itemid : i, (i5 & 16) != 0 ? recommendedVehiclesResponse2.LossType : str4, (i5 & 32) != 0 ? recommendedVehiclesResponse2.Make : str5, (i5 & 64) != 0 ? recommendedVehiclesResponse2.Model : str6, (i5 & 128) != 0 ? recommendedVehiclesResponse2.RecommendationsID : i2, (i5 & 256) != 0 ? recommendedVehiclesResponse2.SeriesName : str7, (i5 & 512) != 0 ? recommendedVehiclesResponse2.State : str8, (i5 & 1024) != 0 ? recommendedVehiclesResponse2.ThumbnailUrl : str9, (i5 & 2048) != 0 ? recommendedVehiclesResponse2.Title : str10, (i5 & 4096) != 0 ? recommendedVehiclesResponse2.Year : i3);
    }

    @NotNull
    public final String component1() {
        return this.BadgeType;
    }

    @NotNull
    public final String component10() {
        return this.State;
    }

    @NotNull
    public final String component11() {
        return this.ThumbnailUrl;
    }

    @NotNull
    public final String component12() {
        return this.Title;
    }

    public final int component13() {
        return this.Year;
    }

    @NotNull
    public final String component2() {
        return this.BranchCode;
    }

    @NotNull
    public final String component3() {
        return this.BranchName;
    }

    public final int component4() {
        return this.Itemid;
    }

    @NotNull
    public final String component5() {
        return this.LossType;
    }

    @NotNull
    public final String component6() {
        return this.Make;
    }

    @NotNull
    public final String component7() {
        return this.Model;
    }

    public final int component8() {
        return this.RecommendationsID;
    }

    @NotNull
    public final String component9() {
        return this.SeriesName;
    }

    @NotNull
    public final RecommendedVehiclesResponse copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i2, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, int i3) {
        String str11 = str;
        Intrinsics.checkParameterIsNotNull(str11, "BadgeType");
        String str12 = str2;
        Intrinsics.checkParameterIsNotNull(str12, Constants.EXTRA_BRANCH_CODE_FOR_ADESA_TERMS_OF_USE);
        String str13 = str3;
        Intrinsics.checkParameterIsNotNull(str13, "BranchName");
        String str14 = str4;
        Intrinsics.checkParameterIsNotNull(str14, "LossType");
        String str15 = str5;
        Intrinsics.checkParameterIsNotNull(str15, ExifInterface.TAG_MAKE);
        String str16 = str6;
        Intrinsics.checkParameterIsNotNull(str16, ExifInterface.TAG_MODEL);
        String str17 = str7;
        Intrinsics.checkParameterIsNotNull(str17, "SeriesName");
        String str18 = str8;
        Intrinsics.checkParameterIsNotNull(str18, "State");
        String str19 = str9;
        Intrinsics.checkParameterIsNotNull(str19, "ThumbnailUrl");
        String str20 = str10;
        Intrinsics.checkParameterIsNotNull(str20, "Title");
        return new RecommendedVehiclesResponse(str11, str12, str13, i, str14, str15, str16, i2, str17, str18, str19, str20, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RecommendedVehiclesResponse) {
                RecommendedVehiclesResponse recommendedVehiclesResponse = (RecommendedVehiclesResponse) obj;
                if (Intrinsics.areEqual((Object) this.BadgeType, (Object) recommendedVehiclesResponse.BadgeType) && Intrinsics.areEqual((Object) this.BranchCode, (Object) recommendedVehiclesResponse.BranchCode) && Intrinsics.areEqual((Object) this.BranchName, (Object) recommendedVehiclesResponse.BranchName)) {
                    if ((this.Itemid == recommendedVehiclesResponse.Itemid) && Intrinsics.areEqual((Object) this.LossType, (Object) recommendedVehiclesResponse.LossType) && Intrinsics.areEqual((Object) this.Make, (Object) recommendedVehiclesResponse.Make) && Intrinsics.areEqual((Object) this.Model, (Object) recommendedVehiclesResponse.Model)) {
                        if ((this.RecommendationsID == recommendedVehiclesResponse.RecommendationsID) && Intrinsics.areEqual((Object) this.SeriesName, (Object) recommendedVehiclesResponse.SeriesName) && Intrinsics.areEqual((Object) this.State, (Object) recommendedVehiclesResponse.State) && Intrinsics.areEqual((Object) this.ThumbnailUrl, (Object) recommendedVehiclesResponse.ThumbnailUrl) && Intrinsics.areEqual((Object) this.Title, (Object) recommendedVehiclesResponse.Title)) {
                            if (this.Year == recommendedVehiclesResponse.Year) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.BadgeType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.BranchCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.BranchName;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Integer.valueOf(this.Itemid).hashCode()) * 31;
        String str4 = this.LossType;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.Make;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.Model;
        int hashCode6 = (((hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + Integer.valueOf(this.RecommendationsID).hashCode()) * 31;
        String str7 = this.SeriesName;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.State;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.ThumbnailUrl;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.Title;
        if (str10 != null) {
            i = str10.hashCode();
        }
        return ((hashCode9 + i) * 31) + Integer.valueOf(this.Year).hashCode();
    }

    @NotNull
    public String toString() {
        return "RecommendedVehiclesResponse(BadgeType=" + this.BadgeType + ", BranchCode=" + this.BranchCode + ", BranchName=" + this.BranchName + ", Itemid=" + this.Itemid + ", LossType=" + this.LossType + ", Make=" + this.Make + ", Model=" + this.Model + ", RecommendationsID=" + this.RecommendationsID + ", SeriesName=" + this.SeriesName + ", State=" + this.State + ", ThumbnailUrl=" + this.ThumbnailUrl + ", Title=" + this.Title + ", Year=" + this.Year + ")";
    }

    public RecommendedVehiclesResponse(@NotNull String str, @NotNull String str2, @NotNull String str3, int i, @NotNull String str4, @NotNull String str5, @NotNull String str6, int i2, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, int i3) {
        Intrinsics.checkParameterIsNotNull(str, "BadgeType");
        Intrinsics.checkParameterIsNotNull(str2, Constants.EXTRA_BRANCH_CODE_FOR_ADESA_TERMS_OF_USE);
        Intrinsics.checkParameterIsNotNull(str3, "BranchName");
        Intrinsics.checkParameterIsNotNull(str4, "LossType");
        Intrinsics.checkParameterIsNotNull(str5, ExifInterface.TAG_MAKE);
        Intrinsics.checkParameterIsNotNull(str6, ExifInterface.TAG_MODEL);
        Intrinsics.checkParameterIsNotNull(str7, "SeriesName");
        Intrinsics.checkParameterIsNotNull(str8, "State");
        Intrinsics.checkParameterIsNotNull(str9, "ThumbnailUrl");
        Intrinsics.checkParameterIsNotNull(str10, "Title");
        this.BadgeType = str;
        this.BranchCode = str2;
        this.BranchName = str3;
        this.Itemid = i;
        this.LossType = str4;
        this.Make = str5;
        this.Model = str6;
        this.RecommendationsID = i2;
        this.SeriesName = str7;
        this.State = str8;
        this.ThumbnailUrl = str9;
        this.Title = str10;
        this.Year = i3;
    }

    @NotNull
    public final String getBadgeType() {
        return this.BadgeType;
    }

    @NotNull
    public final String getBranchCode() {
        return this.BranchCode;
    }

    @NotNull
    public final String getBranchName() {
        return this.BranchName;
    }

    public final int getItemid() {
        return this.Itemid;
    }

    @NotNull
    public final String getLossType() {
        return this.LossType;
    }

    @NotNull
    public final String getMake() {
        return this.Make;
    }

    @NotNull
    public final String getModel() {
        return this.Model;
    }

    public final int getRecommendationsID() {
        return this.RecommendationsID;
    }

    @NotNull
    public final String getSeriesName() {
        return this.SeriesName;
    }

    @NotNull
    public final String getState() {
        return this.State;
    }

    @NotNull
    public final String getThumbnailUrl() {
        return this.ThumbnailUrl;
    }

    @NotNull
    public final String getTitle() {
        return this.Title;
    }

    public final int getYear() {
        return this.Year;
    }
}
