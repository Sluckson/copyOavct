package com.iaai.android.bdt.model.saveSearch;

import com.iaai.android.bdt.model.fastSearchFilter2.Searche;
import com.iaai.android.bdt.model.fastSearchFilter2.Sort;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016Jt\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00052\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016¨\u0006,"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/saveSearch/Refiners;", "", "CurrentPage", "", "GenerateFacets", "", "PageSize", "Searches", "", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Searche;", "Sort", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Sort;", "UserLevelDocuments", "", "Miles", "ZipCode", "(IZILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCurrentPage", "()I", "getGenerateFacets", "()Z", "getMiles", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageSize", "getSearches", "()Ljava/util/List;", "getSort", "getUserLevelDocuments", "getZipCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(IZILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/iaai/android/bdt/model/saveSearch/Refiners;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Refiners.kt */
public final class Refiners {
    private final int CurrentPage;
    private final boolean GenerateFacets;
    @Nullable
    private final Integer Miles;
    private final int PageSize;
    @NotNull
    private final List<Searche> Searches;
    @NotNull
    private final List<Sort> Sort;
    @NotNull
    private final List<String> UserLevelDocuments;
    @Nullable
    private final Integer ZipCode;

    @NotNull
    public static /* synthetic */ Refiners copy$default(Refiners refiners, int i, boolean z, int i2, List list, List list2, List list3, Integer num, Integer num2, int i3, Object obj) {
        Refiners refiners2 = refiners;
        int i4 = i3;
        return refiners.copy((i4 & 1) != 0 ? refiners2.CurrentPage : i, (i4 & 2) != 0 ? refiners2.GenerateFacets : z, (i4 & 4) != 0 ? refiners2.PageSize : i2, (i4 & 8) != 0 ? refiners2.Searches : list, (i4 & 16) != 0 ? refiners2.Sort : list2, (i4 & 32) != 0 ? refiners2.UserLevelDocuments : list3, (i4 & 64) != 0 ? refiners2.Miles : num, (i4 & 128) != 0 ? refiners2.ZipCode : num2);
    }

    public final int component1() {
        return this.CurrentPage;
    }

    public final boolean component2() {
        return this.GenerateFacets;
    }

    public final int component3() {
        return this.PageSize;
    }

    @NotNull
    public final List<Searche> component4() {
        return this.Searches;
    }

    @NotNull
    public final List<Sort> component5() {
        return this.Sort;
    }

    @NotNull
    public final List<String> component6() {
        return this.UserLevelDocuments;
    }

    @Nullable
    public final Integer component7() {
        return this.Miles;
    }

    @Nullable
    public final Integer component8() {
        return this.ZipCode;
    }

    @NotNull
    public final Refiners copy(int i, boolean z, int i2, @NotNull List<Searche> list, @NotNull List<Sort> list2, @NotNull List<String> list3, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkParameterIsNotNull(list, "Searches");
        Intrinsics.checkParameterIsNotNull(list2, "Sort");
        List<String> list4 = list3;
        Intrinsics.checkParameterIsNotNull(list4, "UserLevelDocuments");
        return new Refiners(i, z, i2, list, list2, list4, num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Refiners) {
                Refiners refiners = (Refiners) obj;
                if (this.CurrentPage == refiners.CurrentPage) {
                    if (this.GenerateFacets == refiners.GenerateFacets) {
                        if (!(this.PageSize == refiners.PageSize) || !Intrinsics.areEqual((Object) this.Searches, (Object) refiners.Searches) || !Intrinsics.areEqual((Object) this.Sort, (Object) refiners.Sort) || !Intrinsics.areEqual((Object) this.UserLevelDocuments, (Object) refiners.UserLevelDocuments) || !Intrinsics.areEqual((Object) this.Miles, (Object) refiners.Miles) || !Intrinsics.areEqual((Object) this.ZipCode, (Object) refiners.ZipCode)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.CurrentPage).hashCode() * 31;
        boolean z = this.GenerateFacets;
        if (z) {
            z = true;
        }
        int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + Integer.valueOf(this.PageSize).hashCode()) * 31;
        List<Searche> list = this.Searches;
        int i = 0;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<Sort> list2 = this.Sort;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.UserLevelDocuments;
        int hashCode5 = (hashCode4 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Integer num = this.Miles;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.ZipCode;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        return "Refiners(CurrentPage=" + this.CurrentPage + ", GenerateFacets=" + this.GenerateFacets + ", PageSize=" + this.PageSize + ", Searches=" + this.Searches + ", Sort=" + this.Sort + ", UserLevelDocuments=" + this.UserLevelDocuments + ", Miles=" + this.Miles + ", ZipCode=" + this.ZipCode + ")";
    }

    public Refiners(int i, boolean z, int i2, @NotNull List<Searche> list, @NotNull List<Sort> list2, @NotNull List<String> list3, @Nullable Integer num, @Nullable Integer num2) {
        Intrinsics.checkParameterIsNotNull(list, "Searches");
        Intrinsics.checkParameterIsNotNull(list2, "Sort");
        Intrinsics.checkParameterIsNotNull(list3, "UserLevelDocuments");
        this.CurrentPage = i;
        this.GenerateFacets = z;
        this.PageSize = i2;
        this.Searches = list;
        this.Sort = list2;
        this.UserLevelDocuments = list3;
        this.Miles = num;
        this.ZipCode = num2;
    }

    public final int getCurrentPage() {
        return this.CurrentPage;
    }

    public final boolean getGenerateFacets() {
        return this.GenerateFacets;
    }

    public final int getPageSize() {
        return this.PageSize;
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

    @Nullable
    public final Integer getMiles() {
        return this.Miles;
    }

    @Nullable
    public final Integer getZipCode() {
        return this.ZipCode;
    }
}
