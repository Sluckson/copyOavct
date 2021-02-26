package com.iaai.android.bdt.model.auctionmainlist;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionmainlist/AuctionMainListResponse;", "", "AuctionCalender", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionCalender;", "AuctionLocations", "", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "(Lcom/iaai/android/bdt/model/auctionmainlist/AuctionCalender;Ljava/util/List;)V", "getAuctionCalender", "()Lcom/iaai/android/bdt/model/auctionmainlist/AuctionCalender;", "getAuctionLocations", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListResponse.kt */
public final class AuctionMainListResponse {
    @NotNull
    private final AuctionCalender AuctionCalender;
    @NotNull
    private final List<AuctionLocations> AuctionLocations;

    @NotNull
    public static /* synthetic */ AuctionMainListResponse copy$default(AuctionMainListResponse auctionMainListResponse, AuctionCalender auctionCalender, List<AuctionLocations> list, int i, Object obj) {
        if ((i & 1) != 0) {
            auctionCalender = auctionMainListResponse.AuctionCalender;
        }
        if ((i & 2) != 0) {
            list = auctionMainListResponse.AuctionLocations;
        }
        return auctionMainListResponse.copy(auctionCalender, list);
    }

    @NotNull
    public final AuctionCalender component1() {
        return this.AuctionCalender;
    }

    @NotNull
    public final List<AuctionLocations> component2() {
        return this.AuctionLocations;
    }

    @NotNull
    public final AuctionMainListResponse copy(@NotNull AuctionCalender auctionCalender, @NotNull List<AuctionLocations> list) {
        Intrinsics.checkParameterIsNotNull(auctionCalender, "AuctionCalender");
        Intrinsics.checkParameterIsNotNull(list, "AuctionLocations");
        return new AuctionMainListResponse(auctionCalender, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuctionMainListResponse)) {
            return false;
        }
        AuctionMainListResponse auctionMainListResponse = (AuctionMainListResponse) obj;
        return Intrinsics.areEqual((Object) this.AuctionCalender, (Object) auctionMainListResponse.AuctionCalender) && Intrinsics.areEqual((Object) this.AuctionLocations, (Object) auctionMainListResponse.AuctionLocations);
    }

    public int hashCode() {
        AuctionCalender auctionCalender = this.AuctionCalender;
        int i = 0;
        int hashCode = (auctionCalender != null ? auctionCalender.hashCode() : 0) * 31;
        List<AuctionLocations> list = this.AuctionLocations;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "AuctionMainListResponse(AuctionCalender=" + this.AuctionCalender + ", AuctionLocations=" + this.AuctionLocations + ")";
    }

    public AuctionMainListResponse(@NotNull AuctionCalender auctionCalender, @NotNull List<AuctionLocations> list) {
        Intrinsics.checkParameterIsNotNull(auctionCalender, "AuctionCalender");
        Intrinsics.checkParameterIsNotNull(list, "AuctionLocations");
        this.AuctionCalender = auctionCalender;
        this.AuctionLocations = list;
    }

    @NotNull
    public final AuctionCalender getAuctionCalender() {
        return this.AuctionCalender;
    }

    @NotNull
    public final List<AuctionLocations> getAuctionLocations() {
        return this.AuctionLocations;
    }
}
