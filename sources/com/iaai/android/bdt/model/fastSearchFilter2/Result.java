package com.iaai.android.bdt.model.fastSearchFilter2;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0001HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0001HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0003Ja\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006'"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/Result;", "", "Count", "", "DocumentIds", "Facets", "", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetX;", "Reasons", "Results", "Lcom/iaai/android/bdt/model/fastSearchFilter2/ResultX;", "URI", "", "WordCounts", "(ILjava/lang/Object;Ljava/util/List;Ljava/lang/Object;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getCount", "()I", "getDocumentIds", "()Ljava/lang/Object;", "getFacets", "()Ljava/util/List;", "getReasons", "getResults", "getURI", "()Ljava/lang/String;", "getWordCounts", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Result.kt */
public final class Result {
    private final int Count;
    @NotNull
    private final Object DocumentIds;
    @NotNull
    private final List<FacetX> Facets;
    @NotNull
    private final Object Reasons;
    @NotNull
    private final List<ResultX> Results;
    @NotNull
    private final String URI;
    @NotNull
    private final List<Object> WordCounts;

    @NotNull
    public static /* synthetic */ Result copy$default(Result result, int i, Object obj, List<FacetX> list, Object obj2, List<ResultX> list2, String str, List<Object> list3, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            i = result.Count;
        }
        if ((i2 & 2) != 0) {
            obj = result.DocumentIds;
        }
        Object obj4 = obj;
        if ((i2 & 4) != 0) {
            list = result.Facets;
        }
        List<FacetX> list4 = list;
        if ((i2 & 8) != 0) {
            obj2 = result.Reasons;
        }
        Object obj5 = obj2;
        if ((i2 & 16) != 0) {
            list2 = result.Results;
        }
        List<ResultX> list5 = list2;
        if ((i2 & 32) != 0) {
            str = result.URI;
        }
        String str2 = str;
        if ((i2 & 64) != 0) {
            list3 = result.WordCounts;
        }
        return result.copy(i, obj4, list4, obj5, list5, str2, list3);
    }

    public final int component1() {
        return this.Count;
    }

    @NotNull
    public final Object component2() {
        return this.DocumentIds;
    }

    @NotNull
    public final List<FacetX> component3() {
        return this.Facets;
    }

    @NotNull
    public final Object component4() {
        return this.Reasons;
    }

    @NotNull
    public final List<ResultX> component5() {
        return this.Results;
    }

    @NotNull
    public final String component6() {
        return this.URI;
    }

    @NotNull
    public final List<Object> component7() {
        return this.WordCounts;
    }

    @NotNull
    public final Result copy(int i, @NotNull Object obj, @NotNull List<FacetX> list, @NotNull Object obj2, @NotNull List<ResultX> list2, @NotNull String str, @NotNull List<? extends Object> list3) {
        Intrinsics.checkParameterIsNotNull(obj, "DocumentIds");
        Intrinsics.checkParameterIsNotNull(list, "Facets");
        Intrinsics.checkParameterIsNotNull(obj2, "Reasons");
        Intrinsics.checkParameterIsNotNull(list2, "Results");
        Intrinsics.checkParameterIsNotNull(str, "URI");
        List<? extends Object> list4 = list3;
        Intrinsics.checkParameterIsNotNull(list4, "WordCounts");
        return new Result(i, obj, list, obj2, list2, str, list4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Result) {
                Result result = (Result) obj;
                if (!(this.Count == result.Count) || !Intrinsics.areEqual(this.DocumentIds, result.DocumentIds) || !Intrinsics.areEqual((Object) this.Facets, (Object) result.Facets) || !Intrinsics.areEqual(this.Reasons, result.Reasons) || !Intrinsics.areEqual((Object) this.Results, (Object) result.Results) || !Intrinsics.areEqual((Object) this.URI, (Object) result.URI) || !Intrinsics.areEqual((Object) this.WordCounts, (Object) result.WordCounts)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.Count).hashCode() * 31;
        Object obj = this.DocumentIds;
        int i = 0;
        int hashCode2 = (hashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        List<FacetX> list = this.Facets;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        Object obj2 = this.Reasons;
        int hashCode4 = (hashCode3 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        List<ResultX> list2 = this.Results;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.URI;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        List<Object> list3 = this.WordCounts;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        return "Result(Count=" + this.Count + ", DocumentIds=" + this.DocumentIds + ", Facets=" + this.Facets + ", Reasons=" + this.Reasons + ", Results=" + this.Results + ", URI=" + this.URI + ", WordCounts=" + this.WordCounts + ")";
    }

    public Result(int i, @NotNull Object obj, @NotNull List<FacetX> list, @NotNull Object obj2, @NotNull List<ResultX> list2, @NotNull String str, @NotNull List<? extends Object> list3) {
        Intrinsics.checkParameterIsNotNull(obj, "DocumentIds");
        Intrinsics.checkParameterIsNotNull(list, "Facets");
        Intrinsics.checkParameterIsNotNull(obj2, "Reasons");
        Intrinsics.checkParameterIsNotNull(list2, "Results");
        Intrinsics.checkParameterIsNotNull(str, "URI");
        Intrinsics.checkParameterIsNotNull(list3, "WordCounts");
        this.Count = i;
        this.DocumentIds = obj;
        this.Facets = list;
        this.Reasons = obj2;
        this.Results = list2;
        this.URI = str;
        this.WordCounts = list3;
    }

    public final int getCount() {
        return this.Count;
    }

    @NotNull
    public final Object getDocumentIds() {
        return this.DocumentIds;
    }

    @NotNull
    public final List<FacetX> getFacets() {
        return this.Facets;
    }

    @NotNull
    public final Object getReasons() {
        return this.Reasons;
    }

    @NotNull
    public final List<ResultX> getResults() {
        return this.Results;
    }

    @NotNull
    public final String getURI() {
        return this.URI;
    }

    @NotNull
    public final List<Object> getWordCounts() {
        return this.WordCounts;
    }
}
