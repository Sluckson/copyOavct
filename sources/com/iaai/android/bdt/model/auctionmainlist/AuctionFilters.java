package com.iaai.android.bdt.model.auctionmainlist;

import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b7\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J³\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0003HÆ\u0001J\u0013\u0010=\u001a\u00020\n2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0005HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006A"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionmainlist/AuctionFilters;", "", "BranchCode", "", "EndIndex", "", "GroupId", "GroupName", "GroupTypeId", "IBuyFast", "", "JoinNow", "Latitude", "LiveDate", "Longitude", "Query", "SortAscending", "SortField", "StartIndex", "TimeZoneOffSetMinutes", "UserId", "WhoCanBuy", "(Ljava/lang/String;IILjava/lang/String;IZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;IIILjava/lang/String;)V", "getBranchCode", "()Ljava/lang/String;", "getEndIndex", "()I", "getGroupId", "getGroupName", "getGroupTypeId", "getIBuyFast", "()Z", "getJoinNow", "getLatitude", "getLiveDate", "getLongitude", "getQuery", "getSortAscending", "getSortField", "getStartIndex", "getTimeZoneOffSetMinutes", "getUserId", "getWhoCanBuy", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionFilters.kt */
public final class AuctionFilters {
    @NotNull
    private final String BranchCode;
    private final int EndIndex;
    private final int GroupId;
    @NotNull
    private final String GroupName;
    private final int GroupTypeId;
    private final boolean IBuyFast;
    private final boolean JoinNow;
    @NotNull
    private final String Latitude;
    @NotNull
    private final String LiveDate;
    @NotNull
    private final String Longitude;
    @NotNull
    private final String Query;
    private final boolean SortAscending;
    @NotNull
    private final String SortField;
    private final int StartIndex;
    private final int TimeZoneOffSetMinutes;
    private final int UserId;
    @NotNull
    private final String WhoCanBuy;

    @NotNull
    public static /* synthetic */ AuctionFilters copy$default(AuctionFilters auctionFilters, String str, int i, int i2, String str2, int i3, boolean z, boolean z2, String str3, String str4, String str5, String str6, boolean z3, String str7, int i4, int i5, int i6, String str8, int i7, Object obj) {
        int i8;
        int i9;
        AuctionFilters auctionFilters2 = auctionFilters;
        int i10 = i7;
        String str9 = (i10 & 1) != 0 ? auctionFilters2.BranchCode : str;
        int i11 = (i10 & 2) != 0 ? auctionFilters2.EndIndex : i;
        int i12 = (i10 & 4) != 0 ? auctionFilters2.GroupId : i2;
        String str10 = (i10 & 8) != 0 ? auctionFilters2.GroupName : str2;
        int i13 = (i10 & 16) != 0 ? auctionFilters2.GroupTypeId : i3;
        boolean z4 = (i10 & 32) != 0 ? auctionFilters2.IBuyFast : z;
        boolean z5 = (i10 & 64) != 0 ? auctionFilters2.JoinNow : z2;
        String str11 = (i10 & 128) != 0 ? auctionFilters2.Latitude : str3;
        String str12 = (i10 & 256) != 0 ? auctionFilters2.LiveDate : str4;
        String str13 = (i10 & 512) != 0 ? auctionFilters2.Longitude : str5;
        String str14 = (i10 & 1024) != 0 ? auctionFilters2.Query : str6;
        boolean z6 = (i10 & 2048) != 0 ? auctionFilters2.SortAscending : z3;
        String str15 = (i10 & 4096) != 0 ? auctionFilters2.SortField : str7;
        int i14 = (i10 & 8192) != 0 ? auctionFilters2.StartIndex : i4;
        int i15 = (i10 & 16384) != 0 ? auctionFilters2.TimeZoneOffSetMinutes : i5;
        if ((i10 & 32768) != 0) {
            i8 = i15;
            i9 = auctionFilters2.UserId;
        } else {
            i8 = i15;
            i9 = i6;
        }
        return auctionFilters.copy(str9, i11, i12, str10, i13, z4, z5, str11, str12, str13, str14, z6, str15, i14, i8, i9, (i10 & 65536) != 0 ? auctionFilters2.WhoCanBuy : str8);
    }

    @NotNull
    public final String component1() {
        return this.BranchCode;
    }

    @NotNull
    public final String component10() {
        return this.Longitude;
    }

    @NotNull
    public final String component11() {
        return this.Query;
    }

    public final boolean component12() {
        return this.SortAscending;
    }

    @NotNull
    public final String component13() {
        return this.SortField;
    }

    public final int component14() {
        return this.StartIndex;
    }

    public final int component15() {
        return this.TimeZoneOffSetMinutes;
    }

    public final int component16() {
        return this.UserId;
    }

    @NotNull
    public final String component17() {
        return this.WhoCanBuy;
    }

    public final int component2() {
        return this.EndIndex;
    }

    public final int component3() {
        return this.GroupId;
    }

    @NotNull
    public final String component4() {
        return this.GroupName;
    }

    public final int component5() {
        return this.GroupTypeId;
    }

    public final boolean component6() {
        return this.IBuyFast;
    }

    public final boolean component7() {
        return this.JoinNow;
    }

    @NotNull
    public final String component8() {
        return this.Latitude;
    }

    @NotNull
    public final String component9() {
        return this.LiveDate;
    }

    @NotNull
    public final AuctionFilters copy(@NotNull String str, int i, int i2, @NotNull String str2, int i3, boolean z, boolean z2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z3, @NotNull String str7, int i4, int i5, int i6, @NotNull String str8) {
        String str9 = str;
        Intrinsics.checkParameterIsNotNull(str9, Constants.EXTRA_BRANCH_CODE_FOR_ADESA_TERMS_OF_USE);
        Intrinsics.checkParameterIsNotNull(str2, "GroupName");
        Intrinsics.checkParameterIsNotNull(str3, "Latitude");
        Intrinsics.checkParameterIsNotNull(str4, "LiveDate");
        Intrinsics.checkParameterIsNotNull(str5, "Longitude");
        Intrinsics.checkParameterIsNotNull(str6, "Query");
        Intrinsics.checkParameterIsNotNull(str7, "SortField");
        Intrinsics.checkParameterIsNotNull(str8, "WhoCanBuy");
        return new AuctionFilters(str9, i, i2, str2, i3, z, z2, str3, str4, str5, str6, z3, str7, i4, i5, i6, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AuctionFilters) {
                AuctionFilters auctionFilters = (AuctionFilters) obj;
                if (Intrinsics.areEqual((Object) this.BranchCode, (Object) auctionFilters.BranchCode)) {
                    if (this.EndIndex == auctionFilters.EndIndex) {
                        if ((this.GroupId == auctionFilters.GroupId) && Intrinsics.areEqual((Object) this.GroupName, (Object) auctionFilters.GroupName)) {
                            if (this.GroupTypeId == auctionFilters.GroupTypeId) {
                                if (this.IBuyFast == auctionFilters.IBuyFast) {
                                    if ((this.JoinNow == auctionFilters.JoinNow) && Intrinsics.areEqual((Object) this.Latitude, (Object) auctionFilters.Latitude) && Intrinsics.areEqual((Object) this.LiveDate, (Object) auctionFilters.LiveDate) && Intrinsics.areEqual((Object) this.Longitude, (Object) auctionFilters.Longitude) && Intrinsics.areEqual((Object) this.Query, (Object) auctionFilters.Query)) {
                                        if ((this.SortAscending == auctionFilters.SortAscending) && Intrinsics.areEqual((Object) this.SortField, (Object) auctionFilters.SortField)) {
                                            if (this.StartIndex == auctionFilters.StartIndex) {
                                                if (this.TimeZoneOffSetMinutes == auctionFilters.TimeZoneOffSetMinutes) {
                                                    if (!(this.UserId == auctionFilters.UserId) || !Intrinsics.areEqual((Object) this.WhoCanBuy, (Object) auctionFilters.WhoCanBuy)) {
                                                        return false;
                                                    }
                                                }
                                            }
                                        }
                                    }
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
        String str = this.BranchCode;
        int i = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.EndIndex).hashCode()) * 31) + Integer.valueOf(this.GroupId).hashCode()) * 31;
        String str2 = this.GroupName;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.valueOf(this.GroupTypeId).hashCode()) * 31;
        boolean z = this.IBuyFast;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        boolean z2 = this.JoinNow;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        String str3 = this.Latitude;
        int hashCode3 = (i3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.LiveDate;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.Longitude;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.Query;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z3 = this.SortAscending;
        if (z3) {
            z3 = true;
        }
        int i4 = (hashCode6 + (z3 ? 1 : 0)) * 31;
        String str7 = this.SortField;
        int hashCode7 = (((((((i4 + (str7 != null ? str7.hashCode() : 0)) * 31) + Integer.valueOf(this.StartIndex).hashCode()) * 31) + Integer.valueOf(this.TimeZoneOffSetMinutes).hashCode()) * 31) + Integer.valueOf(this.UserId).hashCode()) * 31;
        String str8 = this.WhoCanBuy;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode7 + i;
    }

    @NotNull
    public String toString() {
        return "AuctionFilters(BranchCode=" + this.BranchCode + ", EndIndex=" + this.EndIndex + ", GroupId=" + this.GroupId + ", GroupName=" + this.GroupName + ", GroupTypeId=" + this.GroupTypeId + ", IBuyFast=" + this.IBuyFast + ", JoinNow=" + this.JoinNow + ", Latitude=" + this.Latitude + ", LiveDate=" + this.LiveDate + ", Longitude=" + this.Longitude + ", Query=" + this.Query + ", SortAscending=" + this.SortAscending + ", SortField=" + this.SortField + ", StartIndex=" + this.StartIndex + ", TimeZoneOffSetMinutes=" + this.TimeZoneOffSetMinutes + ", UserId=" + this.UserId + ", WhoCanBuy=" + this.WhoCanBuy + ")";
    }

    public AuctionFilters(@NotNull String str, int i, int i2, @NotNull String str2, int i3, boolean z, boolean z2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, boolean z3, @NotNull String str7, int i4, int i5, int i6, @NotNull String str8) {
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        String str13 = str7;
        String str14 = str8;
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_BRANCH_CODE_FOR_ADESA_TERMS_OF_USE);
        Intrinsics.checkParameterIsNotNull(str2, "GroupName");
        Intrinsics.checkParameterIsNotNull(str9, "Latitude");
        Intrinsics.checkParameterIsNotNull(str10, "LiveDate");
        Intrinsics.checkParameterIsNotNull(str11, "Longitude");
        Intrinsics.checkParameterIsNotNull(str12, "Query");
        Intrinsics.checkParameterIsNotNull(str13, "SortField");
        Intrinsics.checkParameterIsNotNull(str14, "WhoCanBuy");
        this.BranchCode = str;
        this.EndIndex = i;
        this.GroupId = i2;
        this.GroupName = str2;
        this.GroupTypeId = i3;
        this.IBuyFast = z;
        this.JoinNow = z2;
        this.Latitude = str9;
        this.LiveDate = str10;
        this.Longitude = str11;
        this.Query = str12;
        this.SortAscending = z3;
        this.SortField = str13;
        this.StartIndex = i4;
        this.TimeZoneOffSetMinutes = i5;
        this.UserId = i6;
        this.WhoCanBuy = str14;
    }

    @NotNull
    public final String getBranchCode() {
        return this.BranchCode;
    }

    public final int getEndIndex() {
        return this.EndIndex;
    }

    public final int getGroupId() {
        return this.GroupId;
    }

    @NotNull
    public final String getGroupName() {
        return this.GroupName;
    }

    public final int getGroupTypeId() {
        return this.GroupTypeId;
    }

    public final boolean getIBuyFast() {
        return this.IBuyFast;
    }

    public final boolean getJoinNow() {
        return this.JoinNow;
    }

    @NotNull
    public final String getLatitude() {
        return this.Latitude;
    }

    @NotNull
    public final String getLiveDate() {
        return this.LiveDate;
    }

    @NotNull
    public final String getLongitude() {
        return this.Longitude;
    }

    @NotNull
    public final String getQuery() {
        return this.Query;
    }

    public final boolean getSortAscending() {
        return this.SortAscending;
    }

    @NotNull
    public final String getSortField() {
        return this.SortField;
    }

    public final int getStartIndex() {
        return this.StartIndex;
    }

    public final int getTimeZoneOffSetMinutes() {
        return this.TimeZoneOffSetMinutes;
    }

    public final int getUserId() {
        return this.UserId;
    }

    @NotNull
    public final String getWhoCanBuy() {
        return this.WhoCanBuy;
    }
}
