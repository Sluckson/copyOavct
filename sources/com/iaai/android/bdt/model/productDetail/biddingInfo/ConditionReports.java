package com.iaai.android.bdt.model.productDetail.biddingInfo;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J%\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionReports;", "", "Receipts", "Reports", "", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/Reports;", "(Ljava/lang/Object;Ljava/util/List;)V", "getReceipts", "()Ljava/lang/Object;", "getReports", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ConditionReports.kt */
public final class ConditionReports {
    @NotNull
    private final Object Receipts;
    @Nullable
    private final List<Reports> Reports;

    @NotNull
    public static /* synthetic */ ConditionReports copy$default(ConditionReports conditionReports, Object obj, List<Reports> list, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = conditionReports.Receipts;
        }
        if ((i & 2) != 0) {
            list = conditionReports.Reports;
        }
        return conditionReports.copy(obj, list);
    }

    @NotNull
    public final Object component1() {
        return this.Receipts;
    }

    @Nullable
    public final List<Reports> component2() {
        return this.Reports;
    }

    @NotNull
    public final ConditionReports copy(@NotNull Object obj, @Nullable List<Reports> list) {
        Intrinsics.checkParameterIsNotNull(obj, "Receipts");
        return new ConditionReports(obj, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConditionReports)) {
            return false;
        }
        ConditionReports conditionReports = (ConditionReports) obj;
        return Intrinsics.areEqual(this.Receipts, conditionReports.Receipts) && Intrinsics.areEqual((Object) this.Reports, (Object) conditionReports.Reports);
    }

    public int hashCode() {
        Object obj = this.Receipts;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        List<Reports> list = this.Reports;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "ConditionReports(Receipts=" + this.Receipts + ", Reports=" + this.Reports + ")";
    }

    public ConditionReports(@NotNull Object obj, @Nullable List<Reports> list) {
        Intrinsics.checkParameterIsNotNull(obj, "Receipts");
        this.Receipts = obj;
        this.Reports = list;
    }

    @NotNull
    public final Object getReceipts() {
        return this.Receipts;
    }

    @Nullable
    public final List<Reports> getReports() {
        return this.Reports;
    }
}
