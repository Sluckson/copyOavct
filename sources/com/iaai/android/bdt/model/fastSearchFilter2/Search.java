package com.iaai.android.bdt.model.fastSearchFilter2;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/Search;", "", "FormattedResults", "", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "Request", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "Result", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Result;", "(Ljava/util/List;Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;Lcom/iaai/android/bdt/model/fastSearchFilter2/Result;)V", "getFormattedResults", "()Ljava/util/List;", "getRequest", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "getResult", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/Result;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Search.kt */
public final class Search {
    @NotNull
    private final List<FormattedResult> FormattedResults;
    @NotNull
    private final FastSearchRequestBody Request;
    @NotNull
    private final Result Result;

    @NotNull
    public static /* synthetic */ Search copy$default(Search search, List<FormattedResult> list, FastSearchRequestBody fastSearchRequestBody, Result result, int i, Object obj) {
        if ((i & 1) != 0) {
            list = search.FormattedResults;
        }
        if ((i & 2) != 0) {
            fastSearchRequestBody = search.Request;
        }
        if ((i & 4) != 0) {
            result = search.Result;
        }
        return search.copy(list, fastSearchRequestBody, result);
    }

    @NotNull
    public final List<FormattedResult> component1() {
        return this.FormattedResults;
    }

    @NotNull
    public final FastSearchRequestBody component2() {
        return this.Request;
    }

    @NotNull
    public final Result component3() {
        return this.Result;
    }

    @NotNull
    public final Search copy(@NotNull List<FormattedResult> list, @NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull Result result) {
        Intrinsics.checkParameterIsNotNull(list, "FormattedResults");
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "Request");
        Intrinsics.checkParameterIsNotNull(result, "Result");
        return new Search(list, fastSearchRequestBody, result);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Search)) {
            return false;
        }
        Search search = (Search) obj;
        return Intrinsics.areEqual((Object) this.FormattedResults, (Object) search.FormattedResults) && Intrinsics.areEqual((Object) this.Request, (Object) search.Request) && Intrinsics.areEqual((Object) this.Result, (Object) search.Result);
    }

    public int hashCode() {
        List<FormattedResult> list = this.FormattedResults;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        FastSearchRequestBody fastSearchRequestBody = this.Request;
        int hashCode2 = (hashCode + (fastSearchRequestBody != null ? fastSearchRequestBody.hashCode() : 0)) * 31;
        Result result = this.Result;
        if (result != null) {
            i = result.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "Search(FormattedResults=" + this.FormattedResults + ", Request=" + this.Request + ", Result=" + this.Result + ")";
    }

    public Search(@NotNull List<FormattedResult> list, @NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull Result result) {
        Intrinsics.checkParameterIsNotNull(list, "FormattedResults");
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "Request");
        Intrinsics.checkParameterIsNotNull(result, "Result");
        this.FormattedResults = list;
        this.Request = fastSearchRequestBody;
        this.Result = result;
    }

    @NotNull
    public final List<FormattedResult> getFormattedResults() {
        return this.FormattedResults;
    }

    @NotNull
    public final FastSearchRequestBody getRequest() {
        return this.Request;
    }

    @NotNull
    public final Result getResult() {
        return this.Result;
    }
}
