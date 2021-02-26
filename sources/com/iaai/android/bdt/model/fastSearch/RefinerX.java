package com.iaai.android.bdt.model.fastSearch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/RefinerX;", "", "DisplayName", "", "RefinerCount", "", "RefinerValue", "isSelect", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getDisplayName", "()Ljava/lang/String;", "getRefinerCount", "()I", "getRefinerValue", "()Z", "setSelect", "(Z)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RefinerX.kt */
public final class RefinerX {
    @NotNull
    private final String DisplayName;
    private final int RefinerCount;
    @NotNull
    private final String RefinerValue;
    private boolean isSelect;

    @NotNull
    public static /* synthetic */ RefinerX copy$default(RefinerX refinerX, String str, int i, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = refinerX.DisplayName;
        }
        if ((i2 & 2) != 0) {
            i = refinerX.RefinerCount;
        }
        if ((i2 & 4) != 0) {
            str2 = refinerX.RefinerValue;
        }
        if ((i2 & 8) != 0) {
            z = refinerX.isSelect;
        }
        return refinerX.copy(str, i, str2, z);
    }

    @NotNull
    public final String component1() {
        return this.DisplayName;
    }

    public final int component2() {
        return this.RefinerCount;
    }

    @NotNull
    public final String component3() {
        return this.RefinerValue;
    }

    public final boolean component4() {
        return this.isSelect;
    }

    @NotNull
    public final RefinerX copy(@NotNull String str, int i, @NotNull String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "DisplayName");
        Intrinsics.checkParameterIsNotNull(str2, "RefinerValue");
        return new RefinerX(str, i, str2, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RefinerX) {
                RefinerX refinerX = (RefinerX) obj;
                if (Intrinsics.areEqual((Object) this.DisplayName, (Object) refinerX.DisplayName)) {
                    if ((this.RefinerCount == refinerX.RefinerCount) && Intrinsics.areEqual((Object) this.RefinerValue, (Object) refinerX.RefinerValue)) {
                        if (this.isSelect == refinerX.isSelect) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.DisplayName;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.RefinerCount).hashCode()) * 31;
        String str2 = this.RefinerValue;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.isSelect;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "RefinerX(DisplayName=" + this.DisplayName + ", RefinerCount=" + this.RefinerCount + ", RefinerValue=" + this.RefinerValue + ", isSelect=" + this.isSelect + ")";
    }

    public RefinerX(@NotNull String str, int i, @NotNull String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "DisplayName");
        Intrinsics.checkParameterIsNotNull(str2, "RefinerValue");
        this.DisplayName = str;
        this.RefinerCount = i;
        this.RefinerValue = str2;
        this.isSelect = z;
    }

    @NotNull
    public final String getDisplayName() {
        return this.DisplayName;
    }

    public final int getRefinerCount() {
        return this.RefinerCount;
    }

    @NotNull
    public final String getRefinerValue() {
        return this.RefinerValue;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RefinerX(String str, int i, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 8) != 0 ? false : z);
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
