package com.iaai.android.bdt.model.fastSearchFilter2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/Refiner;", "", "DisplayName", "", "RefinerCount", "", "RefinerValue", "RefinerTypeValue", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getRefinerCount", "()I", "getRefinerTypeValue", "getRefinerValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: Refiner.kt */
public final class Refiner {
    @NotNull
    private final String DisplayName;
    private final int RefinerCount;
    @NotNull
    private final String RefinerTypeValue;
    @NotNull
    private final String RefinerValue;

    @NotNull
    public static /* synthetic */ Refiner copy$default(Refiner refiner, String str, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = refiner.DisplayName;
        }
        if ((i2 & 2) != 0) {
            i = refiner.RefinerCount;
        }
        if ((i2 & 4) != 0) {
            str2 = refiner.RefinerValue;
        }
        if ((i2 & 8) != 0) {
            str3 = refiner.RefinerTypeValue;
        }
        return refiner.copy(str, i, str2, str3);
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

    @NotNull
    public final String component4() {
        return this.RefinerTypeValue;
    }

    @NotNull
    public final Refiner copy(@NotNull String str, int i, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "DisplayName");
        Intrinsics.checkParameterIsNotNull(str2, "RefinerValue");
        Intrinsics.checkParameterIsNotNull(str3, "RefinerTypeValue");
        return new Refiner(str, i, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Refiner) {
                Refiner refiner = (Refiner) obj;
                if (Intrinsics.areEqual((Object) this.DisplayName, (Object) refiner.DisplayName)) {
                    if (!(this.RefinerCount == refiner.RefinerCount) || !Intrinsics.areEqual((Object) this.RefinerValue, (Object) refiner.RefinerValue) || !Intrinsics.areEqual((Object) this.RefinerTypeValue, (Object) refiner.RefinerTypeValue)) {
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
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Integer.valueOf(this.RefinerCount).hashCode()) * 31;
        String str2 = this.RefinerValue;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.RefinerTypeValue;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "Refiner(DisplayName=" + this.DisplayName + ", RefinerCount=" + this.RefinerCount + ", RefinerValue=" + this.RefinerValue + ", RefinerTypeValue=" + this.RefinerTypeValue + ")";
    }

    public Refiner(@NotNull String str, int i, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "DisplayName");
        Intrinsics.checkParameterIsNotNull(str2, "RefinerValue");
        Intrinsics.checkParameterIsNotNull(str3, "RefinerTypeValue");
        this.DisplayName = str;
        this.RefinerCount = i;
        this.RefinerValue = str2;
        this.RefinerTypeValue = str3;
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

    @NotNull
    public final String getRefinerTypeValue() {
        return this.RefinerTypeValue;
    }
}
