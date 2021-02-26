package com.iaai.android.bdt.model.auctionSalesList;

import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J©\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u0006="}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSaleList;", "", "auctiondate", "", "branchcode", "", "cultureCode", "deviceType", "deviceVersion", "direction", "end", "endYear", "lane", "pagesize", "sortcolumn", "start", "startYear", "userid", "vehicleType", "losstype", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuctiondate", "()Ljava/lang/String;", "getBranchcode", "()I", "getCultureCode", "getDeviceType", "getDeviceVersion", "getDirection", "getEnd", "getEndYear", "getLane", "getLosstype", "getPagesize", "getSortcolumn", "getStart", "getStartYear", "getUserid", "getVehicleType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesList.kt */
public final class AuctionSaleList {
    @NotNull
    private final String auctiondate;
    private final int branchcode;
    @NotNull
    private final String cultureCode;
    @NotNull
    private final String deviceType;
    @NotNull
    private final String deviceVersion;
    @NotNull
    private final String direction;
    private final int end;
    @NotNull
    private final String endYear;
    @NotNull
    private final String lane;
    @NotNull
    private final String losstype;
    private final int pagesize;
    @NotNull
    private final String sortcolumn;
    private final int start;
    @NotNull
    private final String startYear;
    @NotNull
    private final String userid;
    @NotNull
    private final String vehicleType;

    @NotNull
    public static /* synthetic */ AuctionSaleList copy$default(AuctionSaleList auctionSaleList, String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, String str7, int i3, String str8, int i4, String str9, String str10, String str11, String str12, int i5, Object obj) {
        AuctionSaleList auctionSaleList2 = auctionSaleList;
        int i6 = i5;
        return auctionSaleList.copy((i6 & 1) != 0 ? auctionSaleList2.auctiondate : str, (i6 & 2) != 0 ? auctionSaleList2.branchcode : i, (i6 & 4) != 0 ? auctionSaleList2.cultureCode : str2, (i6 & 8) != 0 ? auctionSaleList2.deviceType : str3, (i6 & 16) != 0 ? auctionSaleList2.deviceVersion : str4, (i6 & 32) != 0 ? auctionSaleList2.direction : str5, (i6 & 64) != 0 ? auctionSaleList2.end : i2, (i6 & 128) != 0 ? auctionSaleList2.endYear : str6, (i6 & 256) != 0 ? auctionSaleList2.lane : str7, (i6 & 512) != 0 ? auctionSaleList2.pagesize : i3, (i6 & 1024) != 0 ? auctionSaleList2.sortcolumn : str8, (i6 & 2048) != 0 ? auctionSaleList2.start : i4, (i6 & 4096) != 0 ? auctionSaleList2.startYear : str9, (i6 & 8192) != 0 ? auctionSaleList2.userid : str10, (i6 & 16384) != 0 ? auctionSaleList2.vehicleType : str11, (i6 & 32768) != 0 ? auctionSaleList2.losstype : str12);
    }

    @NotNull
    public final String component1() {
        return this.auctiondate;
    }

    public final int component10() {
        return this.pagesize;
    }

    @NotNull
    public final String component11() {
        return this.sortcolumn;
    }

    public final int component12() {
        return this.start;
    }

    @NotNull
    public final String component13() {
        return this.startYear;
    }

    @NotNull
    public final String component14() {
        return this.userid;
    }

    @NotNull
    public final String component15() {
        return this.vehicleType;
    }

    @NotNull
    public final String component16() {
        return this.losstype;
    }

    public final int component2() {
        return this.branchcode;
    }

    @NotNull
    public final String component3() {
        return this.cultureCode;
    }

    @NotNull
    public final String component4() {
        return this.deviceType;
    }

    @NotNull
    public final String component5() {
        return this.deviceVersion;
    }

    @NotNull
    public final String component6() {
        return this.direction;
    }

    public final int component7() {
        return this.end;
    }

    @NotNull
    public final String component8() {
        return this.endYear;
    }

    @NotNull
    public final String component9() {
        return this.lane;
    }

    @NotNull
    public final AuctionSaleList copy(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i2, @NotNull String str6, @NotNull String str7, int i3, @NotNull String str8, int i4, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12) {
        String str13 = str;
        Intrinsics.checkParameterIsNotNull(str13, "auctiondate");
        Intrinsics.checkParameterIsNotNull(str2, "cultureCode");
        Intrinsics.checkParameterIsNotNull(str3, "deviceType");
        Intrinsics.checkParameterIsNotNull(str4, "deviceVersion");
        Intrinsics.checkParameterIsNotNull(str5, "direction");
        Intrinsics.checkParameterIsNotNull(str6, "endYear");
        Intrinsics.checkParameterIsNotNull(str7, Constants_MVVM.EXTRA_LANE);
        Intrinsics.checkParameterIsNotNull(str8, "sortcolumn");
        Intrinsics.checkParameterIsNotNull(str9, Constants_MVVM.EXTRA_START_YEAR);
        Intrinsics.checkParameterIsNotNull(str10, Constants.EXTRA_IAAI_USERID);
        Intrinsics.checkParameterIsNotNull(str11, "vehicleType");
        Intrinsics.checkParameterIsNotNull(str12, "losstype");
        return new AuctionSaleList(str13, i, str2, str3, str4, str5, i2, str6, str7, i3, str8, i4, str9, str10, str11, str12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AuctionSaleList) {
                AuctionSaleList auctionSaleList = (AuctionSaleList) obj;
                if (Intrinsics.areEqual((Object) this.auctiondate, (Object) auctionSaleList.auctiondate)) {
                    if ((this.branchcode == auctionSaleList.branchcode) && Intrinsics.areEqual((Object) this.cultureCode, (Object) auctionSaleList.cultureCode) && Intrinsics.areEqual((Object) this.deviceType, (Object) auctionSaleList.deviceType) && Intrinsics.areEqual((Object) this.deviceVersion, (Object) auctionSaleList.deviceVersion) && Intrinsics.areEqual((Object) this.direction, (Object) auctionSaleList.direction)) {
                        if ((this.end == auctionSaleList.end) && Intrinsics.areEqual((Object) this.endYear, (Object) auctionSaleList.endYear) && Intrinsics.areEqual((Object) this.lane, (Object) auctionSaleList.lane)) {
                            if ((this.pagesize == auctionSaleList.pagesize) && Intrinsics.areEqual((Object) this.sortcolumn, (Object) auctionSaleList.sortcolumn)) {
                                if (!(this.start == auctionSaleList.start) || !Intrinsics.areEqual((Object) this.startYear, (Object) auctionSaleList.startYear) || !Intrinsics.areEqual((Object) this.userid, (Object) auctionSaleList.userid) || !Intrinsics.areEqual((Object) this.vehicleType, (Object) auctionSaleList.vehicleType) || !Intrinsics.areEqual((Object) this.losstype, (Object) auctionSaleList.losstype)) {
                                    return false;
                                }
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
        String str = this.auctiondate;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.branchcode).hashCode()) * 31;
        String str2 = this.cultureCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.deviceType;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.deviceVersion;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.direction;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + Integer.valueOf(this.end).hashCode()) * 31;
        String str6 = this.endYear;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.lane;
        int hashCode7 = (((hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31) + Integer.valueOf(this.pagesize).hashCode()) * 31;
        String str8 = this.sortcolumn;
        int hashCode8 = (((hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31) + Integer.valueOf(this.start).hashCode()) * 31;
        String str9 = this.startYear;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.userid;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.vehicleType;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.losstype;
        if (str12 != null) {
            i = str12.hashCode();
        }
        return hashCode11 + i;
    }

    @NotNull
    public String toString() {
        return "AuctionSaleList(auctiondate=" + this.auctiondate + ", branchcode=" + this.branchcode + ", cultureCode=" + this.cultureCode + ", deviceType=" + this.deviceType + ", deviceVersion=" + this.deviceVersion + ", direction=" + this.direction + ", end=" + this.end + ", endYear=" + this.endYear + ", lane=" + this.lane + ", pagesize=" + this.pagesize + ", sortcolumn=" + this.sortcolumn + ", start=" + this.start + ", startYear=" + this.startYear + ", userid=" + this.userid + ", vehicleType=" + this.vehicleType + ", losstype=" + this.losstype + ")";
    }

    public AuctionSaleList(@NotNull String str, int i, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, int i2, @NotNull String str6, @NotNull String str7, int i3, @NotNull String str8, int i4, @NotNull String str9, @NotNull String str10, @NotNull String str11, @NotNull String str12) {
        String str13 = str2;
        String str14 = str3;
        String str15 = str4;
        String str16 = str5;
        String str17 = str6;
        String str18 = str7;
        String str19 = str8;
        String str20 = str9;
        String str21 = str10;
        String str22 = str11;
        String str23 = str12;
        Intrinsics.checkParameterIsNotNull(str, "auctiondate");
        Intrinsics.checkParameterIsNotNull(str13, "cultureCode");
        Intrinsics.checkParameterIsNotNull(str14, "deviceType");
        Intrinsics.checkParameterIsNotNull(str15, "deviceVersion");
        Intrinsics.checkParameterIsNotNull(str16, "direction");
        Intrinsics.checkParameterIsNotNull(str17, "endYear");
        Intrinsics.checkParameterIsNotNull(str18, Constants_MVVM.EXTRA_LANE);
        Intrinsics.checkParameterIsNotNull(str19, "sortcolumn");
        Intrinsics.checkParameterIsNotNull(str20, Constants_MVVM.EXTRA_START_YEAR);
        Intrinsics.checkParameterIsNotNull(str21, Constants.EXTRA_IAAI_USERID);
        Intrinsics.checkParameterIsNotNull(str22, "vehicleType");
        Intrinsics.checkParameterIsNotNull(str23, "losstype");
        this.auctiondate = str;
        this.branchcode = i;
        this.cultureCode = str13;
        this.deviceType = str14;
        this.deviceVersion = str15;
        this.direction = str16;
        this.end = i2;
        this.endYear = str17;
        this.lane = str18;
        this.pagesize = i3;
        this.sortcolumn = str19;
        this.start = i4;
        this.startYear = str20;
        this.userid = str21;
        this.vehicleType = str22;
        this.losstype = str23;
    }

    @NotNull
    public final String getAuctiondate() {
        return this.auctiondate;
    }

    public final int getBranchcode() {
        return this.branchcode;
    }

    @NotNull
    public final String getCultureCode() {
        return this.cultureCode;
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    @NotNull
    public final String getDeviceVersion() {
        return this.deviceVersion;
    }

    @NotNull
    public final String getDirection() {
        return this.direction;
    }

    public final int getEnd() {
        return this.end;
    }

    @NotNull
    public final String getEndYear() {
        return this.endYear;
    }

    @NotNull
    public final String getLane() {
        return this.lane;
    }

    public final int getPagesize() {
        return this.pagesize;
    }

    @NotNull
    public final String getSortcolumn() {
        return this.sortcolumn;
    }

    public final int getStart() {
        return this.start;
    }

    @NotNull
    public final String getStartYear() {
        return this.startYear;
    }

    @NotNull
    public final String getUserid() {
        return this.userid;
    }

    @NotNull
    public final String getVehicleType() {
        return this.vehicleType;
    }

    @NotNull
    public final String getLosstype() {
        return this.losstype;
    }
}
