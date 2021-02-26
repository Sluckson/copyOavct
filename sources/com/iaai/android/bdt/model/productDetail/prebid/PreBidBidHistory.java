package com.iaai.android.bdt.model.productDetail.prebid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidBidHistory;", "", "_date", "", "_UserName", "_amount", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "get_UserName", "()Ljava/lang/String;", "get_amount", "()I", "get_date", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreBidBidHistory.kt */
public final class PreBidBidHistory {
    @NotNull
    private final String _UserName;
    private final int _amount;
    @NotNull
    private final String _date;

    @NotNull
    public static /* synthetic */ PreBidBidHistory copy$default(PreBidBidHistory preBidBidHistory, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = preBidBidHistory._date;
        }
        if ((i2 & 2) != 0) {
            str2 = preBidBidHistory._UserName;
        }
        if ((i2 & 4) != 0) {
            i = preBidBidHistory._amount;
        }
        return preBidBidHistory.copy(str, str2, i);
    }

    @NotNull
    public final String component1() {
        return this._date;
    }

    @NotNull
    public final String component2() {
        return this._UserName;
    }

    public final int component3() {
        return this._amount;
    }

    @NotNull
    public final PreBidBidHistory copy(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "_date");
        Intrinsics.checkParameterIsNotNull(str2, "_UserName");
        return new PreBidBidHistory(str, str2, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PreBidBidHistory) {
                PreBidBidHistory preBidBidHistory = (PreBidBidHistory) obj;
                if (Intrinsics.areEqual((Object) this._date, (Object) preBidBidHistory._date) && Intrinsics.areEqual((Object) this._UserName, (Object) preBidBidHistory._UserName)) {
                    if (this._amount == preBidBidHistory._amount) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this._date;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this._UserName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode + i) * 31) + Integer.valueOf(this._amount).hashCode();
    }

    @NotNull
    public String toString() {
        return "PreBidBidHistory(_date=" + this._date + ", _UserName=" + this._UserName + ", _amount=" + this._amount + ")";
    }

    public PreBidBidHistory(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "_date");
        Intrinsics.checkParameterIsNotNull(str2, "_UserName");
        this._date = str;
        this._UserName = str2;
        this._amount = i;
    }

    @NotNull
    public final String get_date() {
        return this._date;
    }

    @NotNull
    public final String get_UserName() {
        return this._UserName;
    }

    public final int get_amount() {
        return this._amount;
    }
}
