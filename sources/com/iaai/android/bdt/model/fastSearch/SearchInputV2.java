package com.iaai.android.bdt.model.fastSearch;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Je\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014¨\u0006-"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;", "", "CountOfVehicles", "", "Keyword", "", "Latitude", "Longitude", "RefinerInd", "", "SelectedRefiners", "", "Lcom/iaai/android/bdt/model/fastSearch/RequestSelectedRefiner;", "SortRule", "Lcom/iaai/android/bdt/model/fastSearch/SortRule;", "StartIndex", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;I)V", "getCountOfVehicles", "()I", "setCountOfVehicles", "(I)V", "getKeyword", "()Ljava/lang/String;", "getLatitude", "getLongitude", "getRefinerInd", "()Z", "getSelectedRefiners", "()Ljava/util/List;", "getSortRule", "getStartIndex", "setStartIndex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchInputV2.kt */
public final class SearchInputV2 {
    private int CountOfVehicles;
    @NotNull
    private final String Keyword;
    @NotNull
    private final String Latitude;
    @NotNull
    private final String Longitude;
    private final boolean RefinerInd;
    @NotNull
    private final List<RequestSelectedRefiner> SelectedRefiners;
    @NotNull
    private final List<SortRule> SortRule;
    private int StartIndex;

    @NotNull
    public static /* synthetic */ SearchInputV2 copy$default(SearchInputV2 searchInputV2, int i, String str, String str2, String str3, boolean z, List list, List list2, int i2, int i3, Object obj) {
        SearchInputV2 searchInputV22 = searchInputV2;
        int i4 = i3;
        return searchInputV2.copy((i4 & 1) != 0 ? searchInputV22.CountOfVehicles : i, (i4 & 2) != 0 ? searchInputV22.Keyword : str, (i4 & 4) != 0 ? searchInputV22.Latitude : str2, (i4 & 8) != 0 ? searchInputV22.Longitude : str3, (i4 & 16) != 0 ? searchInputV22.RefinerInd : z, (i4 & 32) != 0 ? searchInputV22.SelectedRefiners : list, (i4 & 64) != 0 ? searchInputV22.SortRule : list2, (i4 & 128) != 0 ? searchInputV22.StartIndex : i2);
    }

    public final int component1() {
        return this.CountOfVehicles;
    }

    @NotNull
    public final String component2() {
        return this.Keyword;
    }

    @NotNull
    public final String component3() {
        return this.Latitude;
    }

    @NotNull
    public final String component4() {
        return this.Longitude;
    }

    public final boolean component5() {
        return this.RefinerInd;
    }

    @NotNull
    public final List<RequestSelectedRefiner> component6() {
        return this.SelectedRefiners;
    }

    @NotNull
    public final List<SortRule> component7() {
        return this.SortRule;
    }

    public final int component8() {
        return this.StartIndex;
    }

    @NotNull
    public final SearchInputV2 copy(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull List<RequestSelectedRefiner> list, @NotNull List<SortRule> list2, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "Keyword");
        Intrinsics.checkParameterIsNotNull(str2, "Latitude");
        Intrinsics.checkParameterIsNotNull(str3, "Longitude");
        List<RequestSelectedRefiner> list3 = list;
        Intrinsics.checkParameterIsNotNull(list3, "SelectedRefiners");
        List<SortRule> list4 = list2;
        Intrinsics.checkParameterIsNotNull(list4, "SortRule");
        return new SearchInputV2(i, str, str2, str3, z, list3, list4, i2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SearchInputV2) {
                SearchInputV2 searchInputV2 = (SearchInputV2) obj;
                if ((this.CountOfVehicles == searchInputV2.CountOfVehicles) && Intrinsics.areEqual((Object) this.Keyword, (Object) searchInputV2.Keyword) && Intrinsics.areEqual((Object) this.Latitude, (Object) searchInputV2.Latitude) && Intrinsics.areEqual((Object) this.Longitude, (Object) searchInputV2.Longitude)) {
                    if ((this.RefinerInd == searchInputV2.RefinerInd) && Intrinsics.areEqual((Object) this.SelectedRefiners, (Object) searchInputV2.SelectedRefiners) && Intrinsics.areEqual((Object) this.SortRule, (Object) searchInputV2.SortRule)) {
                        if (this.StartIndex == searchInputV2.StartIndex) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.CountOfVehicles).hashCode() * 31;
        String str = this.Keyword;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Latitude;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Longitude;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.RefinerInd;
        if (z) {
            z = true;
        }
        int i2 = (hashCode4 + (z ? 1 : 0)) * 31;
        List<RequestSelectedRefiner> list = this.SelectedRefiners;
        int hashCode5 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        List<SortRule> list2 = this.SortRule;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return ((hashCode5 + i) * 31) + Integer.valueOf(this.StartIndex).hashCode();
    }

    @NotNull
    public String toString() {
        return "SearchInputV2(CountOfVehicles=" + this.CountOfVehicles + ", Keyword=" + this.Keyword + ", Latitude=" + this.Latitude + ", Longitude=" + this.Longitude + ", RefinerInd=" + this.RefinerInd + ", SelectedRefiners=" + this.SelectedRefiners + ", SortRule=" + this.SortRule + ", StartIndex=" + this.StartIndex + ")";
    }

    public SearchInputV2(int i, @NotNull String str, @NotNull String str2, @NotNull String str3, boolean z, @NotNull List<RequestSelectedRefiner> list, @NotNull List<SortRule> list2, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "Keyword");
        Intrinsics.checkParameterIsNotNull(str2, "Latitude");
        Intrinsics.checkParameterIsNotNull(str3, "Longitude");
        Intrinsics.checkParameterIsNotNull(list, "SelectedRefiners");
        Intrinsics.checkParameterIsNotNull(list2, "SortRule");
        this.CountOfVehicles = i;
        this.Keyword = str;
        this.Latitude = str2;
        this.Longitude = str3;
        this.RefinerInd = z;
        this.SelectedRefiners = list;
        this.SortRule = list2;
        this.StartIndex = i2;
    }

    public final int getCountOfVehicles() {
        return this.CountOfVehicles;
    }

    public final void setCountOfVehicles(int i) {
        this.CountOfVehicles = i;
    }

    @NotNull
    public final String getKeyword() {
        return this.Keyword;
    }

    @NotNull
    public final String getLatitude() {
        return this.Latitude;
    }

    @NotNull
    public final String getLongitude() {
        return this.Longitude;
    }

    public final boolean getRefinerInd() {
        return this.RefinerInd;
    }

    @NotNull
    public final List<RequestSelectedRefiner> getSelectedRefiners() {
        return this.SelectedRefiners;
    }

    @NotNull
    public final List<SortRule> getSortRule() {
        return this.SortRule;
    }

    public final int getStartIndex() {
        return this.StartIndex;
    }

    public final void setStartIndex(int i) {
        this.StartIndex = i;
    }
}
