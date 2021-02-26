package com.iaai.android.bdt.model.saveSearch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/saveSearch/SaveSearchResponse;", "", "Error", "", "Success", "", "(Ljava/lang/String;Z)V", "getError", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaveSearchResponse.kt */
public final class SaveSearchResponse {
    @NotNull
    private final String Error;
    private final boolean Success;

    @NotNull
    public static /* synthetic */ SaveSearchResponse copy$default(SaveSearchResponse saveSearchResponse, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = saveSearchResponse.Error;
        }
        if ((i & 2) != 0) {
            z = saveSearchResponse.Success;
        }
        return saveSearchResponse.copy(str, z);
    }

    @NotNull
    public final String component1() {
        return this.Error;
    }

    public final boolean component2() {
        return this.Success;
    }

    @NotNull
    public final SaveSearchResponse copy(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "Error");
        return new SaveSearchResponse(str, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SaveSearchResponse) {
                SaveSearchResponse saveSearchResponse = (SaveSearchResponse) obj;
                if (Intrinsics.areEqual((Object) this.Error, (Object) saveSearchResponse.Error)) {
                    if (this.Success == saveSearchResponse.Success) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.Error;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.Success;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "SaveSearchResponse(Error=" + this.Error + ", Success=" + this.Success + ")";
    }

    public SaveSearchResponse(@NotNull String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "Error");
        this.Error = str;
        this.Success = z;
    }

    @NotNull
    public final String getError() {
        return this.Error;
    }

    public final boolean getSuccess() {
        return this.Success;
    }
}
