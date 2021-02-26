package com.iaai.android.bdt.model.fastSearchFilter2;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingArray;", "", "FilterName", "", "groups", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SearchMappingGroup;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "getFilterName", "()Ljava/lang/String;", "getGroups", "()Ljava/util/ArrayList;", "setGroups", "(Ljava/util/ArrayList;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchMappingArray.kt */
public final class SearchMappingArray {
    @NotNull
    private final String FilterName;
    @NotNull
    private ArrayList<SearchMappingGroup> groups;

    @NotNull
    public static /* synthetic */ SearchMappingArray copy$default(SearchMappingArray searchMappingArray, String str, ArrayList<SearchMappingGroup> arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            str = searchMappingArray.FilterName;
        }
        if ((i & 2) != 0) {
            arrayList = searchMappingArray.groups;
        }
        return searchMappingArray.copy(str, arrayList);
    }

    @NotNull
    public final String component1() {
        return this.FilterName;
    }

    @NotNull
    public final ArrayList<SearchMappingGroup> component2() {
        return this.groups;
    }

    @NotNull
    public final SearchMappingArray copy(@NotNull String str, @NotNull ArrayList<SearchMappingGroup> arrayList) {
        Intrinsics.checkParameterIsNotNull(str, "FilterName");
        Intrinsics.checkParameterIsNotNull(arrayList, "groups");
        return new SearchMappingArray(str, arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchMappingArray)) {
            return false;
        }
        SearchMappingArray searchMappingArray = (SearchMappingArray) obj;
        return Intrinsics.areEqual((Object) this.FilterName, (Object) searchMappingArray.FilterName) && Intrinsics.areEqual((Object) this.groups, (Object) searchMappingArray.groups);
    }

    public int hashCode() {
        String str = this.FilterName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<SearchMappingGroup> arrayList = this.groups;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "SearchMappingArray(FilterName=" + this.FilterName + ", groups=" + this.groups + ")";
    }

    public SearchMappingArray(@NotNull String str, @NotNull ArrayList<SearchMappingGroup> arrayList) {
        Intrinsics.checkParameterIsNotNull(str, "FilterName");
        Intrinsics.checkParameterIsNotNull(arrayList, "groups");
        this.FilterName = str;
        this.groups = arrayList;
    }

    @NotNull
    public final String getFilterName() {
        return this.FilterName;
    }

    @NotNull
    public final ArrayList<SearchMappingGroup> getGroups() {
        return this.groups;
    }

    public final void setGroups(@NotNull ArrayList<SearchMappingGroup> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.groups = arrayList;
    }
}
