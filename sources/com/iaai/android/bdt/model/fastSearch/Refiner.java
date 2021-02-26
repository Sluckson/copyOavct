package com.iaai.android.bdt.model.fastSearch;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearch/Refiner;", "", "DisplayName", "", "RefinerTypeValue", "Refiners", "", "Lcom/iaai/android/bdt/model/fastSearch/RefinerX;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDisplayName", "()Ljava/lang/String;", "getRefinerTypeValue", "getRefiners", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Refiner.kt */
public final class Refiner {
    @NotNull
    private final String DisplayName;
    @NotNull
    private final String RefinerTypeValue;
    @NotNull
    private final List<RefinerX> Refiners;

    @NotNull
    public static /* synthetic */ Refiner copy$default(Refiner refiner, String str, String str2, List<RefinerX> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = refiner.DisplayName;
        }
        if ((i & 2) != 0) {
            str2 = refiner.RefinerTypeValue;
        }
        if ((i & 4) != 0) {
            list = refiner.Refiners;
        }
        return refiner.copy(str, str2, list);
    }

    @NotNull
    public final String component1() {
        return this.DisplayName;
    }

    @NotNull
    public final String component2() {
        return this.RefinerTypeValue;
    }

    @NotNull
    public final List<RefinerX> component3() {
        return this.Refiners;
    }

    @NotNull
    public final Refiner copy(@NotNull String str, @NotNull String str2, @NotNull List<RefinerX> list) {
        Intrinsics.checkParameterIsNotNull(str, "DisplayName");
        Intrinsics.checkParameterIsNotNull(str2, "RefinerTypeValue");
        Intrinsics.checkParameterIsNotNull(list, "Refiners");
        return new Refiner(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Refiner)) {
            return false;
        }
        Refiner refiner = (Refiner) obj;
        return Intrinsics.areEqual((Object) this.DisplayName, (Object) refiner.DisplayName) && Intrinsics.areEqual((Object) this.RefinerTypeValue, (Object) refiner.RefinerTypeValue) && Intrinsics.areEqual((Object) this.Refiners, (Object) refiner.Refiners);
    }

    public int hashCode() {
        String str = this.DisplayName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.RefinerTypeValue;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<RefinerX> list = this.Refiners;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "Refiner(DisplayName=" + this.DisplayName + ", RefinerTypeValue=" + this.RefinerTypeValue + ", Refiners=" + this.Refiners + ")";
    }

    public Refiner(@NotNull String str, @NotNull String str2, @NotNull List<RefinerX> list) {
        Intrinsics.checkParameterIsNotNull(str, "DisplayName");
        Intrinsics.checkParameterIsNotNull(str2, "RefinerTypeValue");
        Intrinsics.checkParameterIsNotNull(list, "Refiners");
        this.DisplayName = str;
        this.RefinerTypeValue = str2;
        this.Refiners = list;
    }

    @NotNull
    public final String getDisplayName() {
        return this.DisplayName;
    }

    @NotNull
    public final String getRefinerTypeValue() {
        return this.RefinerTypeValue;
    }

    @NotNull
    public final List<RefinerX> getRefiners() {
        return this.Refiners;
    }
}
