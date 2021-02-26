package com.iaai.android.bdt.model.fastSearchFilter2;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetX;", "", "Facets", "", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "Group", "", "(Ljava/util/List;Ljava/lang/String;)V", "getFacets", "()Ljava/util/List;", "getGroup", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FacetX.kt */
public final class FacetX {
    @NotNull
    private final List<FacetXX> Facets;
    @NotNull
    private final String Group;

    @NotNull
    public static /* synthetic */ FacetX copy$default(FacetX facetX, List<FacetXX> list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = facetX.Facets;
        }
        if ((i & 2) != 0) {
            str = facetX.Group;
        }
        return facetX.copy(list, str);
    }

    @NotNull
    public final List<FacetXX> component1() {
        return this.Facets;
    }

    @NotNull
    public final String component2() {
        return this.Group;
    }

    @NotNull
    public final FacetX copy(@NotNull List<FacetXX> list, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(list, "Facets");
        Intrinsics.checkParameterIsNotNull(str, "Group");
        return new FacetX(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FacetX)) {
            return false;
        }
        FacetX facetX = (FacetX) obj;
        return Intrinsics.areEqual((Object) this.Facets, (Object) facetX.Facets) && Intrinsics.areEqual((Object) this.Group, (Object) facetX.Group);
    }

    public int hashCode() {
        List<FacetXX> list = this.Facets;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.Group;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "FacetX(Facets=" + this.Facets + ", Group=" + this.Group + ")";
    }

    public FacetX(@NotNull List<FacetXX> list, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(list, "Facets");
        Intrinsics.checkParameterIsNotNull(str, "Group");
        this.Facets = list;
        this.Group = str;
    }

    @NotNull
    public final List<FacetXX> getFacets() {
        return this.Facets;
    }

    @NotNull
    public final String getGroup() {
        return this.Group;
    }
}
