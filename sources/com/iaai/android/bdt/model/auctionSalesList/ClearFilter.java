package com.iaai.android.bdt.model.auctionSalesList;

import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionSalesList/ClearFilter;", "", "filterName", "", "filterValue", "(Ljava/lang/String;Ljava/lang/String;)V", "getFilterName", "()Ljava/lang/String;", "getFilterValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ClearFilter.kt */
public final class ClearFilter {
    @NotNull
    private final String filterName;
    @NotNull
    private final String filterValue;

    @NotNull
    public static /* synthetic */ ClearFilter copy$default(ClearFilter clearFilter, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clearFilter.filterName;
        }
        if ((i & 2) != 0) {
            str2 = clearFilter.filterValue;
        }
        return clearFilter.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.filterName;
    }

    @NotNull
    public final String component2() {
        return this.filterValue;
    }

    @NotNull
    public final ClearFilter copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "filterName");
        Intrinsics.checkParameterIsNotNull(str2, Constants_MVVM.EXTRA_SELECTED_FILTER_VALUE);
        return new ClearFilter(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClearFilter)) {
            return false;
        }
        ClearFilter clearFilter = (ClearFilter) obj;
        return Intrinsics.areEqual((Object) this.filterName, (Object) clearFilter.filterName) && Intrinsics.areEqual((Object) this.filterValue, (Object) clearFilter.filterValue);
    }

    public int hashCode() {
        String str = this.filterName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.filterValue;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "ClearFilter(filterName=" + this.filterName + ", filterValue=" + this.filterValue + ")";
    }

    public ClearFilter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "filterName");
        Intrinsics.checkParameterIsNotNull(str2, Constants_MVVM.EXTRA_SELECTED_FILTER_VALUE);
        this.filterName = str;
        this.filterValue = str2;
    }

    @NotNull
    public final String getFilterName() {
        return this.filterName;
    }

    @NotNull
    public final String getFilterValue() {
        return this.filterValue;
    }
}
