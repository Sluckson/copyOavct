package com.iaai.android.bdt.model.fastSearchFilter2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/LongDiscretes;", "", "Name", "", "Value", "", "(Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getValue", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LongDiscretes.kt */
public final class LongDiscretes {
    @NotNull
    private final String Name;
    private final long Value;

    @NotNull
    public static /* synthetic */ LongDiscretes copy$default(LongDiscretes longDiscretes, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = longDiscretes.Name;
        }
        if ((i & 2) != 0) {
            j = longDiscretes.Value;
        }
        return longDiscretes.copy(str, j);
    }

    @NotNull
    public final String component1() {
        return this.Name;
    }

    public final long component2() {
        return this.Value;
    }

    @NotNull
    public final LongDiscretes copy(@NotNull String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "Name");
        return new LongDiscretes(str, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof LongDiscretes) {
                LongDiscretes longDiscretes = (LongDiscretes) obj;
                if (Intrinsics.areEqual((Object) this.Name, (Object) longDiscretes.Name)) {
                    if (this.Value == longDiscretes.Value) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.Name;
        return ((str != null ? str.hashCode() : 0) * 31) + Long.valueOf(this.Value).hashCode();
    }

    @NotNull
    public String toString() {
        return "LongDiscretes(Name=" + this.Name + ", Value=" + this.Value + ")";
    }

    public LongDiscretes(@NotNull String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "Name");
        this.Name = str;
        this.Value = j;
    }

    @NotNull
    public final String getName() {
        return this.Name;
    }

    public final long getValue() {
        return this.Value;
    }
}
