package com.iaai.android.bdt.model.auctionmainlist;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015¨\u0006\u001a"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionmainlist/AuctionCalendarInfo;", "", "()V", "auctionCount", "", "getAuctionCount", "()Ljava/lang/Integer;", "setAuctionCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "auctionDate", "", "getAuctionDate", "()Ljava/lang/String;", "setAuctionDate", "(Ljava/lang/String;)V", "hasAnnouncement", "", "getHasAnnouncement", "()Ljava/lang/Boolean;", "setHasAnnouncement", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "hasPublicAuction", "getHasPublicAuction", "setHasPublicAuction", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionCalendarInfo.kt */
public final class AuctionCalendarInfo {
    @SerializedName("AuctionCount")
    @Nullable
    private Integer auctionCount;
    @SerializedName("AuctionDate")
    @Nullable
    private String auctionDate;
    @SerializedName("HasAnnouncement")
    @Nullable
    private Boolean hasAnnouncement;
    @SerializedName("HasPublicAuction")
    @Nullable
    private Boolean hasPublicAuction;

    @Nullable
    public final Integer getAuctionCount() {
        return this.auctionCount;
    }

    public final void setAuctionCount(@Nullable Integer num) {
        this.auctionCount = num;
    }

    @Nullable
    public final String getAuctionDate() {
        return this.auctionDate;
    }

    public final void setAuctionDate(@Nullable String str) {
        this.auctionDate = str;
    }

    @Nullable
    public final Boolean getHasAnnouncement() {
        return this.hasAnnouncement;
    }

    public final void setHasAnnouncement(@Nullable Boolean bool) {
        this.hasAnnouncement = bool;
    }

    @Nullable
    public final Boolean getHasPublicAuction() {
        return this.hasPublicAuction;
    }

    public final void setHasPublicAuction(@Nullable Boolean bool) {
        this.hasPublicAuction = bool;
    }
}
