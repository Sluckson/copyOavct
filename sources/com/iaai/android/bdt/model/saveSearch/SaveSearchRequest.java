package com.iaai.android.bdt.model.saveSearch;

import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/saveSearch/SaveSearchRequest;", "", "Refiners", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "SaveSearchName", "", "SearchUrl", "Sort", "(Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRefiners", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "getSaveSearchName", "()Ljava/lang/String;", "getSearchUrl", "getSort", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaveSearchRequest.kt */
public final class SaveSearchRequest {
    @NotNull
    private final FastSearchRequestBody Refiners;
    @NotNull
    private final String SaveSearchName;
    @NotNull
    private final String SearchUrl;
    @NotNull
    private final String Sort;

    @NotNull
    public static /* synthetic */ SaveSearchRequest copy$default(SaveSearchRequest saveSearchRequest, FastSearchRequestBody fastSearchRequestBody, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            fastSearchRequestBody = saveSearchRequest.Refiners;
        }
        if ((i & 2) != 0) {
            str = saveSearchRequest.SaveSearchName;
        }
        if ((i & 4) != 0) {
            str2 = saveSearchRequest.SearchUrl;
        }
        if ((i & 8) != 0) {
            str3 = saveSearchRequest.Sort;
        }
        return saveSearchRequest.copy(fastSearchRequestBody, str, str2, str3);
    }

    @NotNull
    public final FastSearchRequestBody component1() {
        return this.Refiners;
    }

    @NotNull
    public final String component2() {
        return this.SaveSearchName;
    }

    @NotNull
    public final String component3() {
        return this.SearchUrl;
    }

    @NotNull
    public final String component4() {
        return this.Sort;
    }

    @NotNull
    public final SaveSearchRequest copy(@NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "Refiners");
        Intrinsics.checkParameterIsNotNull(str, "SaveSearchName");
        Intrinsics.checkParameterIsNotNull(str2, "SearchUrl");
        Intrinsics.checkParameterIsNotNull(str3, "Sort");
        return new SaveSearchRequest(fastSearchRequestBody, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SaveSearchRequest)) {
            return false;
        }
        SaveSearchRequest saveSearchRequest = (SaveSearchRequest) obj;
        return Intrinsics.areEqual((Object) this.Refiners, (Object) saveSearchRequest.Refiners) && Intrinsics.areEqual((Object) this.SaveSearchName, (Object) saveSearchRequest.SaveSearchName) && Intrinsics.areEqual((Object) this.SearchUrl, (Object) saveSearchRequest.SearchUrl) && Intrinsics.areEqual((Object) this.Sort, (Object) saveSearchRequest.Sort);
    }

    public int hashCode() {
        FastSearchRequestBody fastSearchRequestBody = this.Refiners;
        int i = 0;
        int hashCode = (fastSearchRequestBody != null ? fastSearchRequestBody.hashCode() : 0) * 31;
        String str = this.SaveSearchName;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.SearchUrl;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Sort;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        return "SaveSearchRequest(Refiners=" + this.Refiners + ", SaveSearchName=" + this.SaveSearchName + ", SearchUrl=" + this.SearchUrl + ", Sort=" + this.Sort + ")";
    }

    public SaveSearchRequest(@NotNull FastSearchRequestBody fastSearchRequestBody, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "Refiners");
        Intrinsics.checkParameterIsNotNull(str, "SaveSearchName");
        Intrinsics.checkParameterIsNotNull(str2, "SearchUrl");
        Intrinsics.checkParameterIsNotNull(str3, "Sort");
        this.Refiners = fastSearchRequestBody;
        this.SaveSearchName = str;
        this.SearchUrl = str2;
        this.Sort = str3;
    }

    @NotNull
    public final FastSearchRequestBody getRefiners() {
        return this.Refiners;
    }

    @NotNull
    public final String getSaveSearchName() {
        return this.SaveSearchName;
    }

    @NotNull
    public final String getSearchUrl() {
        return this.SearchUrl;
    }

    @NotNull
    public final String getSort() {
        return this.Sort;
    }
}
