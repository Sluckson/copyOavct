package com.iaai.android.bdt.model.auctionSalesList;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001d"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;", "", "AdjCloseddate", "", "AdjLivedate", "AuctionClosed", "", "IBidLiveIndicator", "", "SealedIndicator", "(Ljava/lang/String;Ljava/lang/String;ZIZ)V", "getAdjCloseddate", "()Ljava/lang/String;", "getAdjLivedate", "getAuctionClosed", "()Z", "getIBidLiveIndicator", "()I", "getSealedIndicator", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionDetails.kt */
public final class AuctionDetails {
    @NotNull
    private final String AdjCloseddate;
    @NotNull
    private final String AdjLivedate;
    private final boolean AuctionClosed;
    private final int IBidLiveIndicator;
    private final boolean SealedIndicator;

    @NotNull
    public static /* synthetic */ AuctionDetails copy$default(AuctionDetails auctionDetails, String str, String str2, boolean z, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = auctionDetails.AdjCloseddate;
        }
        if ((i2 & 2) != 0) {
            str2 = auctionDetails.AdjLivedate;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            z = auctionDetails.AuctionClosed;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            i = auctionDetails.IBidLiveIndicator;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z2 = auctionDetails.SealedIndicator;
        }
        return auctionDetails.copy(str, str3, z3, i3, z2);
    }

    @NotNull
    public final String component1() {
        return this.AdjCloseddate;
    }

    @NotNull
    public final String component2() {
        return this.AdjLivedate;
    }

    public final boolean component3() {
        return this.AuctionClosed;
    }

    public final int component4() {
        return this.IBidLiveIndicator;
    }

    public final boolean component5() {
        return this.SealedIndicator;
    }

    @NotNull
    public final AuctionDetails copy(@NotNull String str, @NotNull String str2, boolean z, int i, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "AdjCloseddate");
        Intrinsics.checkParameterIsNotNull(str2, "AdjLivedate");
        return new AuctionDetails(str, str2, z, i, z2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AuctionDetails) {
                AuctionDetails auctionDetails = (AuctionDetails) obj;
                if (Intrinsics.areEqual((Object) this.AdjCloseddate, (Object) auctionDetails.AdjCloseddate) && Intrinsics.areEqual((Object) this.AdjLivedate, (Object) auctionDetails.AdjLivedate)) {
                    if (this.AuctionClosed == auctionDetails.AuctionClosed) {
                        if (this.IBidLiveIndicator == auctionDetails.IBidLiveIndicator) {
                            if (this.SealedIndicator == auctionDetails.SealedIndicator) {
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
        String str = this.AdjCloseddate;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.AdjLivedate;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.AuctionClosed;
        if (z) {
            z = true;
        }
        int hashCode2 = (((i2 + (z ? 1 : 0)) * 31) + Integer.valueOf(this.IBidLiveIndicator).hashCode()) * 31;
        boolean z2 = this.SealedIndicator;
        if (z2) {
            z2 = true;
        }
        return hashCode2 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "AuctionDetails(AdjCloseddate=" + this.AdjCloseddate + ", AdjLivedate=" + this.AdjLivedate + ", AuctionClosed=" + this.AuctionClosed + ", IBidLiveIndicator=" + this.IBidLiveIndicator + ", SealedIndicator=" + this.SealedIndicator + ")";
    }

    public AuctionDetails(@NotNull String str, @NotNull String str2, boolean z, int i, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "AdjCloseddate");
        Intrinsics.checkParameterIsNotNull(str2, "AdjLivedate");
        this.AdjCloseddate = str;
        this.AdjLivedate = str2;
        this.AuctionClosed = z;
        this.IBidLiveIndicator = i;
        this.SealedIndicator = z2;
    }

    @NotNull
    public final String getAdjCloseddate() {
        return this.AdjCloseddate;
    }

    @NotNull
    public final String getAdjLivedate() {
        return this.AdjLivedate;
    }

    public final boolean getAuctionClosed() {
        return this.AuctionClosed;
    }

    public final int getIBidLiveIndicator() {
        return this.IBidLiveIndicator;
    }

    public final boolean getSealedIndicator() {
        return this.SealedIndicator;
    }
}
