package com.iaai.android.bdt.model.fastSearchFilter2;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/Quickfilters;", "", "DisplayName", "", "RefinerOrder", "", "Refiners", "", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Refiner;", "(Ljava/lang/String;ILjava/util/List;)V", "getDisplayName", "()Ljava/lang/String;", "getRefinerOrder", "()I", "getRefiners", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Quickfilters.kt */
public final class Quickfilters {
    @NotNull
    private final String DisplayName;
    private final int RefinerOrder;
    @NotNull
    private final List<Refiner> Refiners;

    @NotNull
    public static /* synthetic */ Quickfilters copy$default(Quickfilters quickfilters, String str, int i, List<Refiner> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = quickfilters.DisplayName;
        }
        if ((i2 & 2) != 0) {
            i = quickfilters.RefinerOrder;
        }
        if ((i2 & 4) != 0) {
            list = quickfilters.Refiners;
        }
        return quickfilters.copy(str, i, list);
    }

    @NotNull
    public final String component1() {
        return this.DisplayName;
    }

    public final int component2() {
        return this.RefinerOrder;
    }

    @NotNull
    public final List<Refiner> component3() {
        return this.Refiners;
    }

    @NotNull
    public final Quickfilters copy(@NotNull String str, int i, @NotNull List<Refiner> list) {
        Intrinsics.checkParameterIsNotNull(str, "DisplayName");
        Intrinsics.checkParameterIsNotNull(list, "Refiners");
        return new Quickfilters(str, i, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Quickfilters) {
                Quickfilters quickfilters = (Quickfilters) obj;
                if (Intrinsics.areEqual((Object) this.DisplayName, (Object) quickfilters.DisplayName)) {
                    if (!(this.RefinerOrder == quickfilters.RefinerOrder) || !Intrinsics.areEqual((Object) this.Refiners, (Object) quickfilters.Refiners)) {
                        return false;
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
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.RefinerOrder).hashCode()) * 31;
        List<Refiner> list = this.Refiners;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "Quickfilters(DisplayName=" + this.DisplayName + ", RefinerOrder=" + this.RefinerOrder + ", Refiners=" + this.Refiners + ")";
    }

    public Quickfilters(@NotNull String str, int i, @NotNull List<Refiner> list) {
        Intrinsics.checkParameterIsNotNull(str, "DisplayName");
        Intrinsics.checkParameterIsNotNull(list, "Refiners");
        this.DisplayName = str;
        this.RefinerOrder = i;
        this.Refiners = list;
    }

    @NotNull
    public final String getDisplayName() {
        return this.DisplayName;
    }

    public final int getRefinerOrder() {
        return this.RefinerOrder;
    }

    @NotNull
    public final List<Refiner> getRefiners() {
        return this.Refiners;
    }
}
