package com.iaai.android.bdt.model.fastSearchFilter2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/SavedSearch;", "", "url", "", "usertimezoneid", "", "savedsearchlogid", "", "zipcode", "(Ljava/lang/String;IJLjava/lang/String;)V", "getSavedsearchlogid", "()J", "getUrl", "()Ljava/lang/String;", "getUsertimezoneid", "()I", "getZipcode", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SavedSearch.kt */
public final class SavedSearch {
    private final long savedsearchlogid;
    @NotNull
    private final String url;
    private final int usertimezoneid;
    @NotNull
    private final String zipcode;

    @NotNull
    public static /* synthetic */ SavedSearch copy$default(SavedSearch savedSearch, String str, int i, long j, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = savedSearch.url;
        }
        if ((i2 & 2) != 0) {
            i = savedSearch.usertimezoneid;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            j = savedSearch.savedsearchlogid;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            str2 = savedSearch.zipcode;
        }
        return savedSearch.copy(str, i3, j2, str2);
    }

    @NotNull
    public final String component1() {
        return this.url;
    }

    public final int component2() {
        return this.usertimezoneid;
    }

    public final long component3() {
        return this.savedsearchlogid;
    }

    @NotNull
    public final String component4() {
        return this.zipcode;
    }

    @NotNull
    public final SavedSearch copy(@NotNull String str, int i, long j, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, "zipcode");
        return new SavedSearch(str, i, j, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SavedSearch) {
                SavedSearch savedSearch = (SavedSearch) obj;
                if (Intrinsics.areEqual((Object) this.url, (Object) savedSearch.url)) {
                    if (this.usertimezoneid == savedSearch.usertimezoneid) {
                        if (!(this.savedsearchlogid == savedSearch.savedsearchlogid) || !Intrinsics.areEqual((Object) this.zipcode, (Object) savedSearch.zipcode)) {
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
        String str = this.url;
        int i = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.usertimezoneid).hashCode()) * 31) + Long.valueOf(this.savedsearchlogid).hashCode()) * 31;
        String str2 = this.zipcode;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "SavedSearch(url=" + this.url + ", usertimezoneid=" + this.usertimezoneid + ", savedsearchlogid=" + this.savedsearchlogid + ", zipcode=" + this.zipcode + ")";
    }

    public SavedSearch(@NotNull String str, int i, long j, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, "zipcode");
        this.url = str;
        this.usertimezoneid = i;
        this.savedsearchlogid = j;
        this.zipcode = str2;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getUsertimezoneid() {
        return this.usertimezoneid;
    }

    public final long getSavedsearchlogid() {
        return this.savedsearchlogid;
    }

    @NotNull
    public final String getZipcode() {
        return this.zipcode;
    }
}
