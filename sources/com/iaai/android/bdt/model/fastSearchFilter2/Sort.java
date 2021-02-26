package com.iaai.android.bdt.model.fastSearchFilter2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/Sort;", "", "IsDescending", "", "IsGeoSort", "SortField", "", "(ZZLjava/lang/String;)V", "getIsDescending", "()Z", "getIsGeoSort", "getSortField", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Sort.kt */
public final class Sort {
    private final boolean IsDescending;
    private final boolean IsGeoSort;
    @NotNull
    private final String SortField;

    @NotNull
    public static /* synthetic */ Sort copy$default(Sort sort, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sort.IsDescending;
        }
        if ((i & 2) != 0) {
            z2 = sort.IsGeoSort;
        }
        if ((i & 4) != 0) {
            str = sort.SortField;
        }
        return sort.copy(z, z2, str);
    }

    public final boolean component1() {
        return this.IsDescending;
    }

    public final boolean component2() {
        return this.IsGeoSort;
    }

    @NotNull
    public final String component3() {
        return this.SortField;
    }

    @NotNull
    public final Sort copy(boolean z, boolean z2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "SortField");
        return new Sort(z, z2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Sort) {
                Sort sort = (Sort) obj;
                if (this.IsDescending == sort.IsDescending) {
                    if (!(this.IsGeoSort == sort.IsGeoSort) || !Intrinsics.areEqual((Object) this.SortField, (Object) sort.SortField)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.IsDescending;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.IsGeoSort;
        if (!z3) {
            z2 = z3;
        }
        int i2 = (i + (z2 ? 1 : 0)) * 31;
        String str = this.SortField;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Sort(IsDescending=" + this.IsDescending + ", IsGeoSort=" + this.IsGeoSort + ", SortField=" + this.SortField + ")";
    }

    public Sort(boolean z, boolean z2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "SortField");
        this.IsDescending = z;
        this.IsGeoSort = z2;
        this.SortField = str;
    }

    public final boolean getIsDescending() {
        return this.IsDescending;
    }

    public final boolean getIsGeoSort() {
        return this.IsGeoSort;
    }

    @NotNull
    public final String getSortField() {
        return this.SortField;
    }
}
