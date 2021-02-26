package com.iaai.android.bdt.model.auctionmainlist;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BI\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J[\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006'"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionmainlist/AuctionCalender;", "", "AuctionCalendarInfo", "", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionCalendarInfo;", "AuctionFilters", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionFilters;", "CurrentAuction", "", "CurrentAuctionLable", "NextAuction", "NextAuctionLable", "WhoCanBuyDropDown", "Lcom/iaai/android/bdt/model/auctionmainlist/WhoCanBuyDropDown;", "(Ljava/util/List;Lcom/iaai/android/bdt/model/auctionmainlist/AuctionFilters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAuctionCalendarInfo", "()Ljava/util/List;", "getAuctionFilters", "()Lcom/iaai/android/bdt/model/auctionmainlist/AuctionFilters;", "getCurrentAuction", "()Ljava/lang/String;", "getCurrentAuctionLable", "getNextAuction", "getNextAuctionLable", "getWhoCanBuyDropDown", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionCalender.kt */
public final class AuctionCalender {
    @NotNull
    private final List<AuctionCalendarInfo> AuctionCalendarInfo;
    @NotNull
    private final AuctionFilters AuctionFilters;
    @NotNull
    private final String CurrentAuction;
    @NotNull
    private final String CurrentAuctionLable;
    @NotNull
    private final String NextAuction;
    @NotNull
    private final String NextAuctionLable;
    @NotNull
    private final List<WhoCanBuyDropDown> WhoCanBuyDropDown;

    @NotNull
    public static /* synthetic */ AuctionCalender copy$default(AuctionCalender auctionCalender, List<AuctionCalendarInfo> list, AuctionFilters auctionFilters, String str, String str2, String str3, String str4, List<WhoCanBuyDropDown> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = auctionCalender.AuctionCalendarInfo;
        }
        if ((i & 2) != 0) {
            auctionFilters = auctionCalender.AuctionFilters;
        }
        AuctionFilters auctionFilters2 = auctionFilters;
        if ((i & 4) != 0) {
            str = auctionCalender.CurrentAuction;
        }
        String str5 = str;
        if ((i & 8) != 0) {
            str2 = auctionCalender.CurrentAuctionLable;
        }
        String str6 = str2;
        if ((i & 16) != 0) {
            str3 = auctionCalender.NextAuction;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = auctionCalender.NextAuctionLable;
        }
        String str8 = str4;
        if ((i & 64) != 0) {
            list2 = auctionCalender.WhoCanBuyDropDown;
        }
        return auctionCalender.copy(list, auctionFilters2, str5, str6, str7, str8, list2);
    }

    @NotNull
    public final List<AuctionCalendarInfo> component1() {
        return this.AuctionCalendarInfo;
    }

    @NotNull
    public final AuctionFilters component2() {
        return this.AuctionFilters;
    }

    @NotNull
    public final String component3() {
        return this.CurrentAuction;
    }

    @NotNull
    public final String component4() {
        return this.CurrentAuctionLable;
    }

    @NotNull
    public final String component5() {
        return this.NextAuction;
    }

    @NotNull
    public final String component6() {
        return this.NextAuctionLable;
    }

    @NotNull
    public final List<WhoCanBuyDropDown> component7() {
        return this.WhoCanBuyDropDown;
    }

    @NotNull
    public final AuctionCalender copy(@NotNull List<AuctionCalendarInfo> list, @NotNull AuctionFilters auctionFilters, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull List<WhoCanBuyDropDown> list2) {
        Intrinsics.checkParameterIsNotNull(list, "AuctionCalendarInfo");
        Intrinsics.checkParameterIsNotNull(auctionFilters, "AuctionFilters");
        Intrinsics.checkParameterIsNotNull(str, "CurrentAuction");
        Intrinsics.checkParameterIsNotNull(str2, "CurrentAuctionLable");
        Intrinsics.checkParameterIsNotNull(str3, "NextAuction");
        Intrinsics.checkParameterIsNotNull(str4, "NextAuctionLable");
        List<WhoCanBuyDropDown> list3 = list2;
        Intrinsics.checkParameterIsNotNull(list3, "WhoCanBuyDropDown");
        return new AuctionCalender(list, auctionFilters, str, str2, str3, str4, list3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuctionCalender)) {
            return false;
        }
        AuctionCalender auctionCalender = (AuctionCalender) obj;
        return Intrinsics.areEqual((Object) this.AuctionCalendarInfo, (Object) auctionCalender.AuctionCalendarInfo) && Intrinsics.areEqual((Object) this.AuctionFilters, (Object) auctionCalender.AuctionFilters) && Intrinsics.areEqual((Object) this.CurrentAuction, (Object) auctionCalender.CurrentAuction) && Intrinsics.areEqual((Object) this.CurrentAuctionLable, (Object) auctionCalender.CurrentAuctionLable) && Intrinsics.areEqual((Object) this.NextAuction, (Object) auctionCalender.NextAuction) && Intrinsics.areEqual((Object) this.NextAuctionLable, (Object) auctionCalender.NextAuctionLable) && Intrinsics.areEqual((Object) this.WhoCanBuyDropDown, (Object) auctionCalender.WhoCanBuyDropDown);
    }

    public int hashCode() {
        List<AuctionCalendarInfo> list = this.AuctionCalendarInfo;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        AuctionFilters auctionFilters = this.AuctionFilters;
        int hashCode2 = (hashCode + (auctionFilters != null ? auctionFilters.hashCode() : 0)) * 31;
        String str = this.CurrentAuction;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.CurrentAuctionLable;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.NextAuction;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.NextAuctionLable;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<WhoCanBuyDropDown> list2 = this.WhoCanBuyDropDown;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        return "AuctionCalender(AuctionCalendarInfo=" + this.AuctionCalendarInfo + ", AuctionFilters=" + this.AuctionFilters + ", CurrentAuction=" + this.CurrentAuction + ", CurrentAuctionLable=" + this.CurrentAuctionLable + ", NextAuction=" + this.NextAuction + ", NextAuctionLable=" + this.NextAuctionLable + ", WhoCanBuyDropDown=" + this.WhoCanBuyDropDown + ")";
    }

    public AuctionCalender(@NotNull List<AuctionCalendarInfo> list, @NotNull AuctionFilters auctionFilters, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull List<WhoCanBuyDropDown> list2) {
        Intrinsics.checkParameterIsNotNull(list, "AuctionCalendarInfo");
        Intrinsics.checkParameterIsNotNull(auctionFilters, "AuctionFilters");
        Intrinsics.checkParameterIsNotNull(str, "CurrentAuction");
        Intrinsics.checkParameterIsNotNull(str2, "CurrentAuctionLable");
        Intrinsics.checkParameterIsNotNull(str3, "NextAuction");
        Intrinsics.checkParameterIsNotNull(str4, "NextAuctionLable");
        Intrinsics.checkParameterIsNotNull(list2, "WhoCanBuyDropDown");
        this.AuctionCalendarInfo = list;
        this.AuctionFilters = auctionFilters;
        this.CurrentAuction = str;
        this.CurrentAuctionLable = str2;
        this.NextAuction = str3;
        this.NextAuctionLable = str4;
        this.WhoCanBuyDropDown = list2;
    }

    @NotNull
    public final List<AuctionCalendarInfo> getAuctionCalendarInfo() {
        return this.AuctionCalendarInfo;
    }

    @NotNull
    public final AuctionFilters getAuctionFilters() {
        return this.AuctionFilters;
    }

    @NotNull
    public final String getCurrentAuction() {
        return this.CurrentAuction;
    }

    @NotNull
    public final String getCurrentAuctionLable() {
        return this.CurrentAuctionLable;
    }

    @NotNull
    public final String getNextAuction() {
        return this.NextAuction;
    }

    @NotNull
    public final String getNextAuctionLable() {
        return this.NextAuctionLable;
    }

    @NotNull
    public final List<WhoCanBuyDropDown> getWhoCanBuyDropDown() {
        return this.WhoCanBuyDropDown;
    }
}
