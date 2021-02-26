package com.iaai.android.bdt.model.fastSearch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/QuickFilter;", "", "quickFilterTitle", "", "quickFilterCount", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuickFilterCount", "()Ljava/lang/String;", "getQuickFilterTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: QuickFilter.kt */
public final class QuickFilter {
    @NotNull
    private final String quickFilterCount;
    @NotNull
    private final String quickFilterTitle;

    @NotNull
    public static /* synthetic */ QuickFilter copy$default(QuickFilter quickFilter, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quickFilter.quickFilterTitle;
        }
        if ((i & 2) != 0) {
            str2 = quickFilter.quickFilterCount;
        }
        return quickFilter.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.quickFilterTitle;
    }

    @NotNull
    public final String component2() {
        return this.quickFilterCount;
    }

    @NotNull
    public final QuickFilter copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "quickFilterTitle");
        Intrinsics.checkParameterIsNotNull(str2, "quickFilterCount");
        return new QuickFilter(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickFilter)) {
            return false;
        }
        QuickFilter quickFilter = (QuickFilter) obj;
        return Intrinsics.areEqual((Object) this.quickFilterTitle, (Object) quickFilter.quickFilterTitle) && Intrinsics.areEqual((Object) this.quickFilterCount, (Object) quickFilter.quickFilterCount);
    }

    public int hashCode() {
        String str = this.quickFilterTitle;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.quickFilterCount;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "QuickFilter(quickFilterTitle=" + this.quickFilterTitle + ", quickFilterCount=" + this.quickFilterCount + ")";
    }

    public QuickFilter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "quickFilterTitle");
        Intrinsics.checkParameterIsNotNull(str2, "quickFilterCount");
        this.quickFilterTitle = str;
        this.quickFilterCount = str2;
    }

    @NotNull
    public final String getQuickFilterTitle() {
        return this.quickFilterTitle;
    }

    @NotNull
    public final String getQuickFilterCount() {
        return this.quickFilterCount;
    }
}
