package com.iaai.android.bdt.model.fastSearchFilter2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/fastSearchFilter2/ResultX;", "", "Data", "Lcom/iaai/android/bdt/model/fastSearchFilter2/Data;", "Distance", "Id", "", "(Lcom/iaai/android/bdt/model/fastSearchFilter2/Data;Ljava/lang/Object;I)V", "getData", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/Data;", "getDistance", "()Ljava/lang/Object;", "getId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ResultX.kt */
public final class ResultX {
    @NotNull
    private final Data Data;
    @NotNull
    private final Object Distance;

    /* renamed from: Id */
    private final int f506Id;

    @NotNull
    public static /* synthetic */ ResultX copy$default(ResultX resultX, Data data, Object obj, int i, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            data = resultX.Data;
        }
        if ((i2 & 2) != 0) {
            obj = resultX.Distance;
        }
        if ((i2 & 4) != 0) {
            i = resultX.f506Id;
        }
        return resultX.copy(data, obj, i);
    }

    @NotNull
    public final Data component1() {
        return this.Data;
    }

    @NotNull
    public final Object component2() {
        return this.Distance;
    }

    public final int component3() {
        return this.f506Id;
    }

    @NotNull
    public final ResultX copy(@NotNull Data data, @NotNull Object obj, int i) {
        Intrinsics.checkParameterIsNotNull(data, "Data");
        Intrinsics.checkParameterIsNotNull(obj, "Distance");
        return new ResultX(data, obj, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ResultX) {
                ResultX resultX = (ResultX) obj;
                if (Intrinsics.areEqual((Object) this.Data, (Object) resultX.Data) && Intrinsics.areEqual(this.Distance, resultX.Distance)) {
                    if (this.f506Id == resultX.f506Id) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Data data = this.Data;
        int i = 0;
        int hashCode = (data != null ? data.hashCode() : 0) * 31;
        Object obj = this.Distance;
        if (obj != null) {
            i = obj.hashCode();
        }
        return ((hashCode + i) * 31) + Integer.valueOf(this.f506Id).hashCode();
    }

    @NotNull
    public String toString() {
        return "ResultX(Data=" + this.Data + ", Distance=" + this.Distance + ", Id=" + this.f506Id + ")";
    }

    public ResultX(@NotNull Data data, @NotNull Object obj, int i) {
        Intrinsics.checkParameterIsNotNull(data, "Data");
        Intrinsics.checkParameterIsNotNull(obj, "Distance");
        this.Data = data;
        this.Distance = obj;
        this.f506Id = i;
    }

    @NotNull
    public final Data getData() {
        return this.Data;
    }

    @NotNull
    public final Object getDistance() {
        return this.Distance;
    }

    public final int getId() {
        return this.f506Id;
    }
}
