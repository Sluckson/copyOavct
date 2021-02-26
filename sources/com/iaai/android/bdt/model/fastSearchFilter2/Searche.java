package com.iaai.android.bdt.model.fastSearchFilter2;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0007\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0007HÆ\u0003Jw\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00072\u001c\b\u0002\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR%\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R%\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/Searche;", "", "BreadCrumb", "", "Facets", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Facet;", "Lkotlin/collections/ArrayList;", "FullSearch", "LongDiscretes", "Lcom/iaai/android/bdt/model/fastSearchFilter2/LongDiscretes;", "LongRanges", "Lcom/iaai/android/bdt/model/fastSearchFilter2/LongRangesData;", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getBreadCrumb", "()Ljava/lang/String;", "getFacets", "()Ljava/util/ArrayList;", "getFullSearch", "getLongDiscretes", "getLongRanges", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Searche.kt */
public final class Searche {
    @NotNull
    private final String BreadCrumb;
    @Nullable
    private final ArrayList<Facet> Facets;
    @NotNull
    private final String FullSearch;
    @Nullable
    private final ArrayList<LongDiscretes> LongDiscretes;
    @Nullable
    private final ArrayList<LongRangesData> LongRanges;

    @NotNull
    public static /* synthetic */ Searche copy$default(Searche searche, String str, ArrayList<Facet> arrayList, String str2, ArrayList<LongDiscretes> arrayList2, ArrayList<LongRangesData> arrayList3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searche.BreadCrumb;
        }
        if ((i & 2) != 0) {
            arrayList = searche.Facets;
        }
        ArrayList<Facet> arrayList4 = arrayList;
        if ((i & 4) != 0) {
            str2 = searche.FullSearch;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            arrayList2 = searche.LongDiscretes;
        }
        ArrayList<LongDiscretes> arrayList5 = arrayList2;
        if ((i & 16) != 0) {
            arrayList3 = searche.LongRanges;
        }
        return searche.copy(str, arrayList4, str3, arrayList5, arrayList3);
    }

    @NotNull
    public final String component1() {
        return this.BreadCrumb;
    }

    @Nullable
    public final ArrayList<Facet> component2() {
        return this.Facets;
    }

    @NotNull
    public final String component3() {
        return this.FullSearch;
    }

    @Nullable
    public final ArrayList<LongDiscretes> component4() {
        return this.LongDiscretes;
    }

    @Nullable
    public final ArrayList<LongRangesData> component5() {
        return this.LongRanges;
    }

    @NotNull
    public final Searche copy(@NotNull String str, @Nullable ArrayList<Facet> arrayList, @NotNull String str2, @Nullable ArrayList<LongDiscretes> arrayList2, @Nullable ArrayList<LongRangesData> arrayList3) {
        Intrinsics.checkParameterIsNotNull(str, "BreadCrumb");
        Intrinsics.checkParameterIsNotNull(str2, "FullSearch");
        return new Searche(str, arrayList, str2, arrayList2, arrayList3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Searche)) {
            return false;
        }
        Searche searche = (Searche) obj;
        return Intrinsics.areEqual((Object) this.BreadCrumb, (Object) searche.BreadCrumb) && Intrinsics.areEqual((Object) this.Facets, (Object) searche.Facets) && Intrinsics.areEqual((Object) this.FullSearch, (Object) searche.FullSearch) && Intrinsics.areEqual((Object) this.LongDiscretes, (Object) searche.LongDiscretes) && Intrinsics.areEqual((Object) this.LongRanges, (Object) searche.LongRanges);
    }

    public int hashCode() {
        String str = this.BreadCrumb;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<Facet> arrayList = this.Facets;
        int hashCode2 = (hashCode + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        String str2 = this.FullSearch;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        ArrayList<LongDiscretes> arrayList2 = this.LongDiscretes;
        int hashCode4 = (hashCode3 + (arrayList2 != null ? arrayList2.hashCode() : 0)) * 31;
        ArrayList<LongRangesData> arrayList3 = this.LongRanges;
        if (arrayList3 != null) {
            i = arrayList3.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        return "Searche(BreadCrumb=" + this.BreadCrumb + ", Facets=" + this.Facets + ", FullSearch=" + this.FullSearch + ", LongDiscretes=" + this.LongDiscretes + ", LongRanges=" + this.LongRanges + ")";
    }

    public Searche(@NotNull String str, @Nullable ArrayList<Facet> arrayList, @NotNull String str2, @Nullable ArrayList<LongDiscretes> arrayList2, @Nullable ArrayList<LongRangesData> arrayList3) {
        Intrinsics.checkParameterIsNotNull(str, "BreadCrumb");
        Intrinsics.checkParameterIsNotNull(str2, "FullSearch");
        this.BreadCrumb = str;
        this.Facets = arrayList;
        this.FullSearch = str2;
        this.LongDiscretes = arrayList2;
        this.LongRanges = arrayList3;
    }

    @NotNull
    public final String getBreadCrumb() {
        return this.BreadCrumb;
    }

    @Nullable
    public final ArrayList<Facet> getFacets() {
        return this.Facets;
    }

    @NotNull
    public final String getFullSearch() {
        return this.FullSearch;
    }

    @Nullable
    public final ArrayList<LongDiscretes> getLongDiscretes() {
        return this.LongDiscretes;
    }

    @Nullable
    public final ArrayList<LongRangesData> getLongRanges() {
        return this.LongRanges;
    }
}
