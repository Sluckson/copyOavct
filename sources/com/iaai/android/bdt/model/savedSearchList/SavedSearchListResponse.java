package com.iaai.android.bdt.model.savedSearchList;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JT\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f¨\u0006#"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "", "SavedSearchLogId", "", "SearchUrl", "", "SaveSearchName", "Refiners", "Sort", "IsaNewSearch", "", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getIsaNewSearch", "()Z", "getRefiners", "()Ljava/lang/String;", "getSaveSearchName", "getSavedSearchLogId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSearchUrl", "getSort", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/iaai/android/bdt/model/savedSearchList/SavedSearchListResponse;", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearchListResponse.kt */
public final class SavedSearchListResponse {
    private final boolean IsaNewSearch;
    @Nullable
    private final String Refiners;
    @Nullable
    private final String SaveSearchName;
    @Nullable
    private final Long SavedSearchLogId;
    @Nullable
    private final String SearchUrl;
    @Nullable
    private final String Sort;

    @NotNull
    public static /* synthetic */ SavedSearchListResponse copy$default(SavedSearchListResponse savedSearchListResponse, Long l, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            l = savedSearchListResponse.SavedSearchLogId;
        }
        if ((i & 2) != 0) {
            str = savedSearchListResponse.SearchUrl;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = savedSearchListResponse.SaveSearchName;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = savedSearchListResponse.Refiners;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = savedSearchListResponse.Sort;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            z = savedSearchListResponse.IsaNewSearch;
        }
        return savedSearchListResponse.copy(l, str5, str6, str7, str8, z);
    }

    @Nullable
    public final Long component1() {
        return this.SavedSearchLogId;
    }

    @Nullable
    public final String component2() {
        return this.SearchUrl;
    }

    @Nullable
    public final String component3() {
        return this.SaveSearchName;
    }

    @Nullable
    public final String component4() {
        return this.Refiners;
    }

    @Nullable
    public final String component5() {
        return this.Sort;
    }

    public final boolean component6() {
        return this.IsaNewSearch;
    }

    @NotNull
    public final SavedSearchListResponse copy(@Nullable Long l, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z) {
        return new SavedSearchListResponse(l, str, str2, str3, str4, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SavedSearchListResponse) {
                SavedSearchListResponse savedSearchListResponse = (SavedSearchListResponse) obj;
                if (Intrinsics.areEqual((Object) this.SavedSearchLogId, (Object) savedSearchListResponse.SavedSearchLogId) && Intrinsics.areEqual((Object) this.SearchUrl, (Object) savedSearchListResponse.SearchUrl) && Intrinsics.areEqual((Object) this.SaveSearchName, (Object) savedSearchListResponse.SaveSearchName) && Intrinsics.areEqual((Object) this.Refiners, (Object) savedSearchListResponse.Refiners) && Intrinsics.areEqual((Object) this.Sort, (Object) savedSearchListResponse.Sort)) {
                    if (this.IsaNewSearch == savedSearchListResponse.IsaNewSearch) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Long l = this.SavedSearchLogId;
        int i = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.SearchUrl;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.SaveSearchName;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Refiners;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.Sort;
        if (str4 != null) {
            i = str4.hashCode();
        }
        int i2 = (hashCode4 + i) * 31;
        boolean z = this.IsaNewSearch;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "SavedSearchListResponse(SavedSearchLogId=" + this.SavedSearchLogId + ", SearchUrl=" + this.SearchUrl + ", SaveSearchName=" + this.SaveSearchName + ", Refiners=" + this.Refiners + ", Sort=" + this.Sort + ", IsaNewSearch=" + this.IsaNewSearch + ")";
    }

    public SavedSearchListResponse(@Nullable Long l, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z) {
        this.SavedSearchLogId = l;
        this.SearchUrl = str;
        this.SaveSearchName = str2;
        this.Refiners = str3;
        this.Sort = str4;
        this.IsaNewSearch = z;
    }

    @Nullable
    public final Long getSavedSearchLogId() {
        return this.SavedSearchLogId;
    }

    @Nullable
    public final String getSearchUrl() {
        return this.SearchUrl;
    }

    @Nullable
    public final String getSaveSearchName() {
        return this.SaveSearchName;
    }

    @Nullable
    public final String getRefiners() {
        return this.Refiners;
    }

    @Nullable
    public final String getSort() {
        return this.Sort;
    }

    public final boolean getIsaNewSearch() {
        return this.IsaNewSearch;
    }
}
