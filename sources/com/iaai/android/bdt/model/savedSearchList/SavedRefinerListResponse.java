package com.iaai.android.bdt.model.savedSearchList;

import com.iaai.android.bdt.model.fastSearchFilter2.LatLong;
import com.iaai.android.bdt.model.fastSearchFilter2.Searche;
import com.iaai.android.bdt.model.fastSearchFilter2.Sort;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\b\b\u0018\u00002\u00020\u0001B³\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001aJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\t\u0010:\u001a\u00020\u000fHÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010=\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010A\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010B\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010D\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0011HÆ\u0003JÞ\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u000f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020\u00032\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\nHÖ\u0001J\t\u0010K\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b#\u0010!R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b%\u0010!R\u0015\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b'\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b*\u0010!R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b+\u0010!R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001cR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b4\u0010\u001e¨\u0006L"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/savedSearchList/SavedRefinerListResponse;", "", "SkipCaching", "", "Searches", "", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Searche;", "Sort", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Sort;", "PageSize", "", "CurrentPage", "UserLevelDocuments", "Miles", "ZipCode", "", "Point", "Lcom/iaai/android/bdt/model/fastSearchFilter2/LatLong;", "GenerateFacets", "IncludedColumns", "IncludeReasoning", "IncludeLikeWords", "Created", "ReturnAllIDs", "RoughGeoSearch", "userTimeZoneId", "(ZLjava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Lcom/iaai/android/bdt/model/fastSearchFilter2/LatLong;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getCreated", "()Ljava/lang/String;", "getCurrentPage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGenerateFacets", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIncludeLikeWords", "getIncludeReasoning", "getIncludedColumns", "getMiles", "getPageSize", "getPoint", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/LatLong;", "getReturnAllIDs", "getRoughGeoSearch", "getSearches", "()Ljava/util/List;", "getSkipCaching", "()Z", "getSort", "getUserLevelDocuments", "()Ljava/lang/Object;", "getZipCode", "getUserTimeZoneId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Lcom/iaai/android/bdt/model/fastSearchFilter2/LatLong;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/iaai/android/bdt/model/savedSearchList/SavedRefinerListResponse;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SavedRefinerListResponse.kt */
public final class SavedRefinerListResponse {
    @NotNull
    private final String Created;
    @Nullable
    private final Integer CurrentPage;
    @Nullable
    private final Boolean GenerateFacets;
    @Nullable
    private final Boolean IncludeLikeWords;
    @Nullable
    private final Boolean IncludeReasoning;
    @Nullable
    private final Boolean IncludedColumns;
    @Nullable
    private final Integer Miles;
    @Nullable
    private final Integer PageSize;
    @Nullable
    private final LatLong Point;
    @Nullable
    private final Boolean ReturnAllIDs;
    @Nullable
    private final Boolean RoughGeoSearch;
    @NotNull
    private final List<Searche> Searches;
    private final boolean SkipCaching;
    @NotNull
    private final List<Sort> Sort;
    @Nullable
    private final Object UserLevelDocuments;
    @Nullable
    private final String ZipCode;
    @Nullable
    private final Integer userTimeZoneId;

    @NotNull
    public static /* synthetic */ SavedRefinerListResponse copy$default(SavedRefinerListResponse savedRefinerListResponse, boolean z, List list, List list2, Integer num, Integer num2, Object obj, Integer num3, String str, LatLong latLong, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str2, Boolean bool5, Boolean bool6, Integer num4, int i, Object obj2) {
        Boolean bool7;
        Boolean bool8;
        SavedRefinerListResponse savedRefinerListResponse2 = savedRefinerListResponse;
        int i2 = i;
        boolean z2 = (i2 & 1) != 0 ? savedRefinerListResponse2.SkipCaching : z;
        List list3 = (i2 & 2) != 0 ? savedRefinerListResponse2.Searches : list;
        List list4 = (i2 & 4) != 0 ? savedRefinerListResponse2.Sort : list2;
        Integer num5 = (i2 & 8) != 0 ? savedRefinerListResponse2.PageSize : num;
        Integer num6 = (i2 & 16) != 0 ? savedRefinerListResponse2.CurrentPage : num2;
        Object obj3 = (i2 & 32) != 0 ? savedRefinerListResponse2.UserLevelDocuments : obj;
        Integer num7 = (i2 & 64) != 0 ? savedRefinerListResponse2.Miles : num3;
        String str3 = (i2 & 128) != 0 ? savedRefinerListResponse2.ZipCode : str;
        LatLong latLong2 = (i2 & 256) != 0 ? savedRefinerListResponse2.Point : latLong;
        Boolean bool9 = (i2 & 512) != 0 ? savedRefinerListResponse2.GenerateFacets : bool;
        Boolean bool10 = (i2 & 1024) != 0 ? savedRefinerListResponse2.IncludedColumns : bool2;
        Boolean bool11 = (i2 & 2048) != 0 ? savedRefinerListResponse2.IncludeReasoning : bool3;
        Boolean bool12 = (i2 & 4096) != 0 ? savedRefinerListResponse2.IncludeLikeWords : bool4;
        String str4 = (i2 & 8192) != 0 ? savedRefinerListResponse2.Created : str2;
        Boolean bool13 = (i2 & 16384) != 0 ? savedRefinerListResponse2.ReturnAllIDs : bool5;
        if ((i2 & 32768) != 0) {
            bool7 = bool13;
            bool8 = savedRefinerListResponse2.RoughGeoSearch;
        } else {
            bool7 = bool13;
            bool8 = bool6;
        }
        return savedRefinerListResponse.copy(z2, list3, list4, num5, num6, obj3, num7, str3, latLong2, bool9, bool10, bool11, bool12, str4, bool7, bool8, (i2 & 65536) != 0 ? savedRefinerListResponse2.userTimeZoneId : num4);
    }

    public final boolean component1() {
        return this.SkipCaching;
    }

    @Nullable
    public final Boolean component10() {
        return this.GenerateFacets;
    }

    @Nullable
    public final Boolean component11() {
        return this.IncludedColumns;
    }

    @Nullable
    public final Boolean component12() {
        return this.IncludeReasoning;
    }

    @Nullable
    public final Boolean component13() {
        return this.IncludeLikeWords;
    }

    @NotNull
    public final String component14() {
        return this.Created;
    }

    @Nullable
    public final Boolean component15() {
        return this.ReturnAllIDs;
    }

    @Nullable
    public final Boolean component16() {
        return this.RoughGeoSearch;
    }

    @Nullable
    public final Integer component17() {
        return this.userTimeZoneId;
    }

    @NotNull
    public final List<Searche> component2() {
        return this.Searches;
    }

    @NotNull
    public final List<Sort> component3() {
        return this.Sort;
    }

    @Nullable
    public final Integer component4() {
        return this.PageSize;
    }

    @Nullable
    public final Integer component5() {
        return this.CurrentPage;
    }

    @Nullable
    public final Object component6() {
        return this.UserLevelDocuments;
    }

    @Nullable
    public final Integer component7() {
        return this.Miles;
    }

    @Nullable
    public final String component8() {
        return this.ZipCode;
    }

    @Nullable
    public final LatLong component9() {
        return this.Point;
    }

    @NotNull
    public final SavedRefinerListResponse copy(boolean z, @NotNull List<Searche> list, @NotNull List<Sort> list2, @Nullable Integer num, @Nullable Integer num2, @Nullable Object obj, @Nullable Integer num3, @Nullable String str, @Nullable LatLong latLong, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @NotNull String str2, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Integer num4) {
        boolean z2 = z;
        Intrinsics.checkParameterIsNotNull(list, "Searches");
        Intrinsics.checkParameterIsNotNull(list2, "Sort");
        Intrinsics.checkParameterIsNotNull(str2, "Created");
        return new SavedRefinerListResponse(z, list, list2, num, num2, obj, num3, str, latLong, bool, bool2, bool3, bool4, str2, bool5, bool6, num4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SavedRefinerListResponse) {
                SavedRefinerListResponse savedRefinerListResponse = (SavedRefinerListResponse) obj;
                if (!(this.SkipCaching == savedRefinerListResponse.SkipCaching) || !Intrinsics.areEqual((Object) this.Searches, (Object) savedRefinerListResponse.Searches) || !Intrinsics.areEqual((Object) this.Sort, (Object) savedRefinerListResponse.Sort) || !Intrinsics.areEqual((Object) this.PageSize, (Object) savedRefinerListResponse.PageSize) || !Intrinsics.areEqual((Object) this.CurrentPage, (Object) savedRefinerListResponse.CurrentPage) || !Intrinsics.areEqual(this.UserLevelDocuments, savedRefinerListResponse.UserLevelDocuments) || !Intrinsics.areEqual((Object) this.Miles, (Object) savedRefinerListResponse.Miles) || !Intrinsics.areEqual((Object) this.ZipCode, (Object) savedRefinerListResponse.ZipCode) || !Intrinsics.areEqual((Object) this.Point, (Object) savedRefinerListResponse.Point) || !Intrinsics.areEqual((Object) this.GenerateFacets, (Object) savedRefinerListResponse.GenerateFacets) || !Intrinsics.areEqual((Object) this.IncludedColumns, (Object) savedRefinerListResponse.IncludedColumns) || !Intrinsics.areEqual((Object) this.IncludeReasoning, (Object) savedRefinerListResponse.IncludeReasoning) || !Intrinsics.areEqual((Object) this.IncludeLikeWords, (Object) savedRefinerListResponse.IncludeLikeWords) || !Intrinsics.areEqual((Object) this.Created, (Object) savedRefinerListResponse.Created) || !Intrinsics.areEqual((Object) this.ReturnAllIDs, (Object) savedRefinerListResponse.ReturnAllIDs) || !Intrinsics.areEqual((Object) this.RoughGeoSearch, (Object) savedRefinerListResponse.RoughGeoSearch) || !Intrinsics.areEqual((Object) this.userTimeZoneId, (Object) savedRefinerListResponse.userTimeZoneId)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.SkipCaching;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        List<Searche> list = this.Searches;
        int i2 = 0;
        int hashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<Sort> list2 = this.Sort;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        Integer num = this.PageSize;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.CurrentPage;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Object obj = this.UserLevelDocuments;
        int hashCode5 = (hashCode4 + (obj != null ? obj.hashCode() : 0)) * 31;
        Integer num3 = this.Miles;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 31;
        String str = this.ZipCode;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 31;
        LatLong latLong = this.Point;
        int hashCode8 = (hashCode7 + (latLong != null ? latLong.hashCode() : 0)) * 31;
        Boolean bool = this.GenerateFacets;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.IncludedColumns;
        int hashCode10 = (hashCode9 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.IncludeReasoning;
        int hashCode11 = (hashCode10 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.IncludeLikeWords;
        int hashCode12 = (hashCode11 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        String str2 = this.Created;
        int hashCode13 = (hashCode12 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool5 = this.ReturnAllIDs;
        int hashCode14 = (hashCode13 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        Boolean bool6 = this.RoughGeoSearch;
        int hashCode15 = (hashCode14 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
        Integer num4 = this.userTimeZoneId;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        return hashCode15 + i2;
    }

    @NotNull
    public String toString() {
        return "SavedRefinerListResponse(SkipCaching=" + this.SkipCaching + ", Searches=" + this.Searches + ", Sort=" + this.Sort + ", PageSize=" + this.PageSize + ", CurrentPage=" + this.CurrentPage + ", UserLevelDocuments=" + this.UserLevelDocuments + ", Miles=" + this.Miles + ", ZipCode=" + this.ZipCode + ", Point=" + this.Point + ", GenerateFacets=" + this.GenerateFacets + ", IncludedColumns=" + this.IncludedColumns + ", IncludeReasoning=" + this.IncludeReasoning + ", IncludeLikeWords=" + this.IncludeLikeWords + ", Created=" + this.Created + ", ReturnAllIDs=" + this.ReturnAllIDs + ", RoughGeoSearch=" + this.RoughGeoSearch + ", userTimeZoneId=" + this.userTimeZoneId + ")";
    }

    public SavedRefinerListResponse(boolean z, @NotNull List<Searche> list, @NotNull List<Sort> list2, @Nullable Integer num, @Nullable Integer num2, @Nullable Object obj, @Nullable Integer num3, @Nullable String str, @Nullable LatLong latLong, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @NotNull String str2, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Integer num4) {
        String str3 = str2;
        Intrinsics.checkParameterIsNotNull(list, "Searches");
        Intrinsics.checkParameterIsNotNull(list2, "Sort");
        Intrinsics.checkParameterIsNotNull(str3, "Created");
        this.SkipCaching = z;
        this.Searches = list;
        this.Sort = list2;
        this.PageSize = num;
        this.CurrentPage = num2;
        this.UserLevelDocuments = obj;
        this.Miles = num3;
        this.ZipCode = str;
        this.Point = latLong;
        this.GenerateFacets = bool;
        this.IncludedColumns = bool2;
        this.IncludeReasoning = bool3;
        this.IncludeLikeWords = bool4;
        this.Created = str3;
        this.ReturnAllIDs = bool5;
        this.RoughGeoSearch = bool6;
        this.userTimeZoneId = num4;
    }

    public final boolean getSkipCaching() {
        return this.SkipCaching;
    }

    @NotNull
    public final List<Searche> getSearches() {
        return this.Searches;
    }

    @NotNull
    public final List<Sort> getSort() {
        return this.Sort;
    }

    @Nullable
    public final Integer getPageSize() {
        return this.PageSize;
    }

    @Nullable
    public final Integer getCurrentPage() {
        return this.CurrentPage;
    }

    @Nullable
    public final Object getUserLevelDocuments() {
        return this.UserLevelDocuments;
    }

    @Nullable
    public final Integer getMiles() {
        return this.Miles;
    }

    @Nullable
    public final String getZipCode() {
        return this.ZipCode;
    }

    @Nullable
    public final LatLong getPoint() {
        return this.Point;
    }

    @Nullable
    public final Boolean getGenerateFacets() {
        return this.GenerateFacets;
    }

    @Nullable
    public final Boolean getIncludedColumns() {
        return this.IncludedColumns;
    }

    @Nullable
    public final Boolean getIncludeReasoning() {
        return this.IncludeReasoning;
    }

    @Nullable
    public final Boolean getIncludeLikeWords() {
        return this.IncludeLikeWords;
    }

    @NotNull
    public final String getCreated() {
        return this.Created;
    }

    @Nullable
    public final Boolean getReturnAllIDs() {
        return this.ReturnAllIDs;
    }

    @Nullable
    public final Boolean getRoughGeoSearch() {
        return this.RoughGeoSearch;
    }

    @Nullable
    public final Integer getUserTimeZoneId() {
        return this.userTimeZoneId;
    }
}
