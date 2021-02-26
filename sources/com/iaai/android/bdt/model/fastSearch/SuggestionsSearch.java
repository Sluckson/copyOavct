package com.iaai.android.bdt.model.fastSearch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/SuggestionsSearch;", "", "suggestionsTitle", "", "(Ljava/lang/String;)V", "getSuggestionsTitle", "()Ljava/lang/String;", "setSuggestionsTitle", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SuggestionsSearch.kt */
public final class SuggestionsSearch {
    @NotNull
    private String suggestionsTitle;

    @NotNull
    public static /* synthetic */ SuggestionsSearch copy$default(SuggestionsSearch suggestionsSearch, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = suggestionsSearch.suggestionsTitle;
        }
        return suggestionsSearch.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.suggestionsTitle;
    }

    @NotNull
    public final SuggestionsSearch copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "suggestionsTitle");
        return new SuggestionsSearch(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SuggestionsSearch) && Intrinsics.areEqual((Object) this.suggestionsTitle, (Object) ((SuggestionsSearch) obj).suggestionsTitle);
        }
        return true;
    }

    public int hashCode() {
        String str = this.suggestionsTitle;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "SuggestionsSearch(suggestionsTitle=" + this.suggestionsTitle + ")";
    }

    public SuggestionsSearch(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "suggestionsTitle");
        this.suggestionsTitle = str;
    }

    @NotNull
    public final String getSuggestionsTitle() {
        return this.suggestionsTitle;
    }

    public final void setSuggestionsTitle(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.suggestionsTitle = str;
    }
}
