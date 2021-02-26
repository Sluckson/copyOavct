package com.iaai.android.bdt.model.fastSearchFilter2;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchResponse2;", "", "quickfilters", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Quickfilters;", "search", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Search;", "(Lcom/iaai/android/bdt/model/fastSearchFilter2/Quickfilters;Lcom/iaai/android/bdt/model/fastSearchFilter2/Search;)V", "getQuickfilters", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/Quickfilters;", "getSearch", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/Search;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchResponse2.kt */
public final class FastSearchResponse2 {
    @NotNull
    private final Quickfilters quickfilters;
    @NotNull
    private final Search search;

    @NotNull
    public static /* synthetic */ FastSearchResponse2 copy$default(FastSearchResponse2 fastSearchResponse2, Quickfilters quickfilters2, Search search2, int i, Object obj) {
        if ((i & 1) != 0) {
            quickfilters2 = fastSearchResponse2.quickfilters;
        }
        if ((i & 2) != 0) {
            search2 = fastSearchResponse2.search;
        }
        return fastSearchResponse2.copy(quickfilters2, search2);
    }

    @NotNull
    public final Quickfilters component1() {
        return this.quickfilters;
    }

    @NotNull
    public final Search component2() {
        return this.search;
    }

    @NotNull
    public final FastSearchResponse2 copy(@NotNull Quickfilters quickfilters2, @NotNull Search search2) {
        Intrinsics.checkParameterIsNotNull(quickfilters2, "quickfilters");
        Intrinsics.checkParameterIsNotNull(search2, FirebaseAnalytics.Event.SEARCH);
        return new FastSearchResponse2(quickfilters2, search2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastSearchResponse2)) {
            return false;
        }
        FastSearchResponse2 fastSearchResponse2 = (FastSearchResponse2) obj;
        return Intrinsics.areEqual((Object) this.quickfilters, (Object) fastSearchResponse2.quickfilters) && Intrinsics.areEqual((Object) this.search, (Object) fastSearchResponse2.search);
    }

    public int hashCode() {
        Quickfilters quickfilters2 = this.quickfilters;
        int i = 0;
        int hashCode = (quickfilters2 != null ? quickfilters2.hashCode() : 0) * 31;
        Search search2 = this.search;
        if (search2 != null) {
            i = search2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "FastSearchResponse2(quickfilters=" + this.quickfilters + ", search=" + this.search + ")";
    }

    public FastSearchResponse2(@NotNull Quickfilters quickfilters2, @NotNull Search search2) {
        Intrinsics.checkParameterIsNotNull(quickfilters2, "quickfilters");
        Intrinsics.checkParameterIsNotNull(search2, FirebaseAnalytics.Event.SEARCH);
        this.quickfilters = quickfilters2;
        this.search = search2;
    }

    @NotNull
    public final Quickfilters getQuickfilters() {
        return this.quickfilters;
    }

    @NotNull
    public final Search getSearch() {
        return this.search;
    }
}
