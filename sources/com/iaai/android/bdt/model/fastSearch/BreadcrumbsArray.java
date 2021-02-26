package com.iaai.android.bdt.model.fastSearch;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/BreadcrumbsArray;", "", "k__BackingField", "", "(Ljava/lang/String;)V", "getK__BackingField", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BreadcrumbsArray.kt */
public final class BreadcrumbsArray {
    @NotNull
    private final String k__BackingField;

    @NotNull
    public static /* synthetic */ BreadcrumbsArray copy$default(BreadcrumbsArray breadcrumbsArray, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = breadcrumbsArray.k__BackingField;
        }
        return breadcrumbsArray.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.k__BackingField;
    }

    @NotNull
    public final BreadcrumbsArray copy(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "k__BackingField");
        return new BreadcrumbsArray(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof BreadcrumbsArray) && Intrinsics.areEqual((Object) this.k__BackingField, (Object) ((BreadcrumbsArray) obj).k__BackingField);
        }
        return true;
    }

    public int hashCode() {
        String str = this.k__BackingField;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "BreadcrumbsArray(k__BackingField=" + this.k__BackingField + ")";
    }

    public BreadcrumbsArray(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "k__BackingField");
        this.k__BackingField = str;
    }

    @NotNull
    public final String getK__BackingField() {
        return this.k__BackingField;
    }
}
