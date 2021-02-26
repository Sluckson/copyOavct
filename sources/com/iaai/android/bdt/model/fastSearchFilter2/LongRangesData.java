package com.iaai.android.bdt.model.fastSearchFilter2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/LongRangesData;", "", "From", "", "To", "Name", "", "(JJLjava/lang/String;)V", "getFrom", "()J", "getName", "()Ljava/lang/String;", "getTo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LongRangesData.kt */
public final class LongRangesData {
    private final long From;
    @NotNull
    private final String Name;

    /* renamed from: To */
    private final long f505To;

    @NotNull
    public static /* synthetic */ LongRangesData copy$default(LongRangesData longRangesData, long j, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = longRangesData.From;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = longRangesData.f505To;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            str = longRangesData.Name;
        }
        return longRangesData.copy(j3, j4, str);
    }

    public final long component1() {
        return this.From;
    }

    public final long component2() {
        return this.f505To;
    }

    @NotNull
    public final String component3() {
        return this.Name;
    }

    @NotNull
    public final LongRangesData copy(long j, long j2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "Name");
        return new LongRangesData(j, j2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof LongRangesData) {
                LongRangesData longRangesData = (LongRangesData) obj;
                if (this.From == longRangesData.From) {
                    if (!(this.f505To == longRangesData.f505To) || !Intrinsics.areEqual((Object) this.Name, (Object) longRangesData.Name)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = ((Long.valueOf(this.From).hashCode() * 31) + Long.valueOf(this.f505To).hashCode()) * 31;
        String str = this.Name;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LongRangesData(From=" + this.From + ", To=" + this.f505To + ", Name=" + this.Name + ")";
    }

    public LongRangesData(long j, long j2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "Name");
        this.From = j;
        this.f505To = j2;
        this.Name = str;
    }

    public final long getFrom() {
        return this.From;
    }

    public final long getTo() {
        return this.f505To;
    }

    @NotNull
    public final String getName() {
        return this.Name;
    }
}
