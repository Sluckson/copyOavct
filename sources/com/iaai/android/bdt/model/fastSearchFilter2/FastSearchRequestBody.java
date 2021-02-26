package com.iaai.android.bdt.model.fastSearchFilter2;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b8\b\b\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bHÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bHÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0007HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0007HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\u0011\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010*J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u000fHÆ\u0003Jä\u0001\u0010M\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÆ\u0001¢\u0006\u0002\u0010NJ\u0013\u0010O\u001a\u00020\u00072\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020\u0005HÖ\u0001J\t\u0010R\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0011\u0010\u0017\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b¢\u0006\b\n\u0000\u001a\u0004\b3\u0010(R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b4\u0010(R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001eR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010 ¨\u0006S"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "", "Created", "", "CurrentPage", "", "GenerateFacets", "", "IncludeLikeWords", "IncludeReasoning", "IncludedColumns", "", "Miles", "PageSize", "Point", "Lcom/iaai/android/bdt/model/fastSearchFilter2/LatLong;", "Searches", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Searche;", "Sort", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Sort;", "UserLevelDocuments", "ReturnAllIDs", "SkipCaching", "RoughGeoSearch", "userTimeZoneId", "ZipCode", "savedsearch", "Lcom/iaai/android/bdt/model/fastSearchFilter2/SavedSearch;", "(Ljava/lang/String;IZZZLjava/util/List;Ljava/lang/Integer;ILcom/iaai/android/bdt/model/fastSearchFilter2/LatLong;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZZILjava/lang/String;Lcom/iaai/android/bdt/model/fastSearchFilter2/SavedSearch;)V", "getCreated", "()Ljava/lang/String;", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "getGenerateFacets", "()Z", "getIncludeLikeWords", "getIncludeReasoning", "getIncludedColumns", "()Ljava/util/List;", "getMiles", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageSize", "getPoint", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/LatLong;", "getReturnAllIDs", "getRoughGeoSearch", "getSearches", "getSkipCaching", "getSort", "getUserLevelDocuments", "getZipCode", "getSavedsearch", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/SavedSearch;", "setSavedsearch", "(Lcom/iaai/android/bdt/model/fastSearchFilter2/SavedSearch;)V", "getUserTimeZoneId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;IZZZLjava/util/List;Ljava/lang/Integer;ILcom/iaai/android/bdt/model/fastSearchFilter2/LatLong;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZZZILjava/lang/String;Lcom/iaai/android/bdt/model/fastSearchFilter2/SavedSearch;)Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchRequestBody.kt */
public final class FastSearchRequestBody {
    @NotNull
    private final String Created;
    private int CurrentPage;
    private final boolean GenerateFacets;
    private final boolean IncludeLikeWords;
    private final boolean IncludeReasoning;
    @Nullable
    private final List<String> IncludedColumns;
    @Nullable
    private final Integer Miles;
    private final int PageSize;
    @Nullable
    private final LatLong Point;
    private final boolean ReturnAllIDs;
    private final boolean RoughGeoSearch;
    @NotNull
    private final List<Searche> Searches;
    private final boolean SkipCaching;
    @NotNull
    private final List<Sort> Sort;
    @NotNull
    private final List<String> UserLevelDocuments;
    @Nullable
    private final String ZipCode;
    @Nullable
    private SavedSearch savedsearch;
    private final int userTimeZoneId;

    @NotNull
    public static /* synthetic */ FastSearchRequestBody copy$default(FastSearchRequestBody fastSearchRequestBody, String str, int i, boolean z, boolean z2, boolean z3, List list, Integer num, int i2, LatLong latLong, List list2, List list3, List list4, boolean z4, boolean z5, boolean z6, int i3, String str2, SavedSearch savedSearch, int i4, Object obj) {
        boolean z7;
        int i5;
        int i6;
        String str3;
        FastSearchRequestBody fastSearchRequestBody2 = fastSearchRequestBody;
        int i7 = i4;
        String str4 = (i7 & 1) != 0 ? fastSearchRequestBody2.Created : str;
        int i8 = (i7 & 2) != 0 ? fastSearchRequestBody2.CurrentPage : i;
        boolean z8 = (i7 & 4) != 0 ? fastSearchRequestBody2.GenerateFacets : z;
        boolean z9 = (i7 & 8) != 0 ? fastSearchRequestBody2.IncludeLikeWords : z2;
        boolean z10 = (i7 & 16) != 0 ? fastSearchRequestBody2.IncludeReasoning : z3;
        List list5 = (i7 & 32) != 0 ? fastSearchRequestBody2.IncludedColumns : list;
        Integer num2 = (i7 & 64) != 0 ? fastSearchRequestBody2.Miles : num;
        int i9 = (i7 & 128) != 0 ? fastSearchRequestBody2.PageSize : i2;
        LatLong latLong2 = (i7 & 256) != 0 ? fastSearchRequestBody2.Point : latLong;
        List list6 = (i7 & 512) != 0 ? fastSearchRequestBody2.Searches : list2;
        List list7 = (i7 & 1024) != 0 ? fastSearchRequestBody2.Sort : list3;
        List list8 = (i7 & 2048) != 0 ? fastSearchRequestBody2.UserLevelDocuments : list4;
        boolean z11 = (i7 & 4096) != 0 ? fastSearchRequestBody2.ReturnAllIDs : z4;
        boolean z12 = (i7 & 8192) != 0 ? fastSearchRequestBody2.SkipCaching : z5;
        boolean z13 = (i7 & 16384) != 0 ? fastSearchRequestBody2.RoughGeoSearch : z6;
        if ((i7 & 32768) != 0) {
            z7 = z13;
            i5 = fastSearchRequestBody2.userTimeZoneId;
        } else {
            z7 = z13;
            i5 = i3;
        }
        if ((i7 & 65536) != 0) {
            i6 = i5;
            str3 = fastSearchRequestBody2.ZipCode;
        } else {
            i6 = i5;
            str3 = str2;
        }
        return fastSearchRequestBody.copy(str4, i8, z8, z9, z10, list5, num2, i9, latLong2, list6, list7, list8, z11, z12, z7, i6, str3, (i7 & 131072) != 0 ? fastSearchRequestBody2.savedsearch : savedSearch);
    }

    @NotNull
    public final String component1() {
        return this.Created;
    }

    @NotNull
    public final List<Searche> component10() {
        return this.Searches;
    }

    @NotNull
    public final List<Sort> component11() {
        return this.Sort;
    }

    @NotNull
    public final List<String> component12() {
        return this.UserLevelDocuments;
    }

    public final boolean component13() {
        return this.ReturnAllIDs;
    }

    public final boolean component14() {
        return this.SkipCaching;
    }

    public final boolean component15() {
        return this.RoughGeoSearch;
    }

    public final int component16() {
        return this.userTimeZoneId;
    }

    @Nullable
    public final String component17() {
        return this.ZipCode;
    }

    @Nullable
    public final SavedSearch component18() {
        return this.savedsearch;
    }

    public final int component2() {
        return this.CurrentPage;
    }

    public final boolean component3() {
        return this.GenerateFacets;
    }

    public final boolean component4() {
        return this.IncludeLikeWords;
    }

    public final boolean component5() {
        return this.IncludeReasoning;
    }

    @Nullable
    public final List<String> component6() {
        return this.IncludedColumns;
    }

    @Nullable
    public final Integer component7() {
        return this.Miles;
    }

    public final int component8() {
        return this.PageSize;
    }

    @Nullable
    public final LatLong component9() {
        return this.Point;
    }

    @NotNull
    public final FastSearchRequestBody copy(@NotNull String str, int i, boolean z, boolean z2, boolean z3, @Nullable List<String> list, @Nullable Integer num, int i2, @Nullable LatLong latLong, @NotNull List<Searche> list2, @NotNull List<Sort> list3, @NotNull List<String> list4, boolean z4, boolean z5, boolean z6, int i3, @Nullable String str2, @Nullable SavedSearch savedSearch) {
        String str3 = str;
        Intrinsics.checkParameterIsNotNull(str3, "Created");
        Intrinsics.checkParameterIsNotNull(list2, "Searches");
        Intrinsics.checkParameterIsNotNull(list3, "Sort");
        Intrinsics.checkParameterIsNotNull(list4, "UserLevelDocuments");
        return new FastSearchRequestBody(str3, i, z, z2, z3, list, num, i2, latLong, list2, list3, list4, z4, z5, z6, i3, str2, savedSearch);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof FastSearchRequestBody) {
                FastSearchRequestBody fastSearchRequestBody = (FastSearchRequestBody) obj;
                if (Intrinsics.areEqual((Object) this.Created, (Object) fastSearchRequestBody.Created)) {
                    if (this.CurrentPage == fastSearchRequestBody.CurrentPage) {
                        if (this.GenerateFacets == fastSearchRequestBody.GenerateFacets) {
                            if (this.IncludeLikeWords == fastSearchRequestBody.IncludeLikeWords) {
                                if ((this.IncludeReasoning == fastSearchRequestBody.IncludeReasoning) && Intrinsics.areEqual((Object) this.IncludedColumns, (Object) fastSearchRequestBody.IncludedColumns) && Intrinsics.areEqual((Object) this.Miles, (Object) fastSearchRequestBody.Miles)) {
                                    if ((this.PageSize == fastSearchRequestBody.PageSize) && Intrinsics.areEqual((Object) this.Point, (Object) fastSearchRequestBody.Point) && Intrinsics.areEqual((Object) this.Searches, (Object) fastSearchRequestBody.Searches) && Intrinsics.areEqual((Object) this.Sort, (Object) fastSearchRequestBody.Sort) && Intrinsics.areEqual((Object) this.UserLevelDocuments, (Object) fastSearchRequestBody.UserLevelDocuments)) {
                                        if (this.ReturnAllIDs == fastSearchRequestBody.ReturnAllIDs) {
                                            if (this.SkipCaching == fastSearchRequestBody.SkipCaching) {
                                                if (this.RoughGeoSearch == fastSearchRequestBody.RoughGeoSearch) {
                                                    if (!(this.userTimeZoneId == fastSearchRequestBody.userTimeZoneId) || !Intrinsics.areEqual((Object) this.ZipCode, (Object) fastSearchRequestBody.ZipCode) || !Intrinsics.areEqual((Object) this.savedsearch, (Object) fastSearchRequestBody.savedsearch)) {
                                                        return false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
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
        String str = this.Created;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.CurrentPage).hashCode()) * 31;
        boolean z = this.GenerateFacets;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z2 = this.IncludeLikeWords;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.IncludeReasoning;
        if (z3) {
            z3 = true;
        }
        int i4 = (i3 + (z3 ? 1 : 0)) * 31;
        List<String> list = this.IncludedColumns;
        int hashCode2 = (i4 + (list != null ? list.hashCode() : 0)) * 31;
        Integer num = this.Miles;
        int hashCode3 = (((hashCode2 + (num != null ? num.hashCode() : 0)) * 31) + Integer.valueOf(this.PageSize).hashCode()) * 31;
        LatLong latLong = this.Point;
        int hashCode4 = (hashCode3 + (latLong != null ? latLong.hashCode() : 0)) * 31;
        List<Searche> list2 = this.Searches;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Sort> list3 = this.Sort;
        int hashCode6 = (hashCode5 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<String> list4 = this.UserLevelDocuments;
        int hashCode7 = (hashCode6 + (list4 != null ? list4.hashCode() : 0)) * 31;
        boolean z4 = this.ReturnAllIDs;
        if (z4) {
            z4 = true;
        }
        int i5 = (hashCode7 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.SkipCaching;
        if (z5) {
            z5 = true;
        }
        int i6 = (i5 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.RoughGeoSearch;
        if (z6) {
            z6 = true;
        }
        int hashCode8 = (((i6 + (z6 ? 1 : 0)) * 31) + Integer.valueOf(this.userTimeZoneId).hashCode()) * 31;
        String str2 = this.ZipCode;
        int hashCode9 = (hashCode8 + (str2 != null ? str2.hashCode() : 0)) * 31;
        SavedSearch savedSearch = this.savedsearch;
        if (savedSearch != null) {
            i = savedSearch.hashCode();
        }
        return hashCode9 + i;
    }

    @NotNull
    public String toString() {
        return "FastSearchRequestBody(Created=" + this.Created + ", CurrentPage=" + this.CurrentPage + ", GenerateFacets=" + this.GenerateFacets + ", IncludeLikeWords=" + this.IncludeLikeWords + ", IncludeReasoning=" + this.IncludeReasoning + ", IncludedColumns=" + this.IncludedColumns + ", Miles=" + this.Miles + ", PageSize=" + this.PageSize + ", Point=" + this.Point + ", Searches=" + this.Searches + ", Sort=" + this.Sort + ", UserLevelDocuments=" + this.UserLevelDocuments + ", ReturnAllIDs=" + this.ReturnAllIDs + ", SkipCaching=" + this.SkipCaching + ", RoughGeoSearch=" + this.RoughGeoSearch + ", userTimeZoneId=" + this.userTimeZoneId + ", ZipCode=" + this.ZipCode + ", savedsearch=" + this.savedsearch + ")";
    }

    public FastSearchRequestBody(@NotNull String str, int i, boolean z, boolean z2, boolean z3, @Nullable List<String> list, @Nullable Integer num, int i2, @Nullable LatLong latLong, @NotNull List<Searche> list2, @NotNull List<Sort> list3, @NotNull List<String> list4, boolean z4, boolean z5, boolean z6, int i3, @Nullable String str2, @Nullable SavedSearch savedSearch) {
        List<Searche> list5 = list2;
        List<Sort> list6 = list3;
        List<String> list7 = list4;
        Intrinsics.checkParameterIsNotNull(str, "Created");
        Intrinsics.checkParameterIsNotNull(list5, "Searches");
        Intrinsics.checkParameterIsNotNull(list6, "Sort");
        Intrinsics.checkParameterIsNotNull(list7, "UserLevelDocuments");
        this.Created = str;
        this.CurrentPage = i;
        this.GenerateFacets = z;
        this.IncludeLikeWords = z2;
        this.IncludeReasoning = z3;
        this.IncludedColumns = list;
        this.Miles = num;
        this.PageSize = i2;
        this.Point = latLong;
        this.Searches = list5;
        this.Sort = list6;
        this.UserLevelDocuments = list7;
        this.ReturnAllIDs = z4;
        this.SkipCaching = z5;
        this.RoughGeoSearch = z6;
        this.userTimeZoneId = i3;
        this.ZipCode = str2;
        this.savedsearch = savedSearch;
    }

    @NotNull
    public final String getCreated() {
        return this.Created;
    }

    public final int getCurrentPage() {
        return this.CurrentPage;
    }

    public final void setCurrentPage(int i) {
        this.CurrentPage = i;
    }

    public final boolean getGenerateFacets() {
        return this.GenerateFacets;
    }

    public final boolean getIncludeLikeWords() {
        return this.IncludeLikeWords;
    }

    public final boolean getIncludeReasoning() {
        return this.IncludeReasoning;
    }

    @Nullable
    public final List<String> getIncludedColumns() {
        return this.IncludedColumns;
    }

    @Nullable
    public final Integer getMiles() {
        return this.Miles;
    }

    public final int getPageSize() {
        return this.PageSize;
    }

    @Nullable
    public final LatLong getPoint() {
        return this.Point;
    }

    @NotNull
    public final List<Searche> getSearches() {
        return this.Searches;
    }

    @NotNull
    public final List<Sort> getSort() {
        return this.Sort;
    }

    @NotNull
    public final List<String> getUserLevelDocuments() {
        return this.UserLevelDocuments;
    }

    public final boolean getReturnAllIDs() {
        return this.ReturnAllIDs;
    }

    public final boolean getSkipCaching() {
        return this.SkipCaching;
    }

    public final boolean getRoughGeoSearch() {
        return this.RoughGeoSearch;
    }

    public final int getUserTimeZoneId() {
        return this.userTimeZoneId;
    }

    @Nullable
    public final String getZipCode() {
        return this.ZipCode;
    }

    @Nullable
    public final SavedSearch getSavedsearch() {
        return this.savedsearch;
    }

    public final void setSavedsearch(@Nullable SavedSearch savedSearch) {
        this.savedsearch = savedSearch;
    }
}
