package com.iaai.android.bdt.model.productDetail.biddingInfo;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ConditionOverviewInfo;", "Ljava/io/Serializable;", "DisplayPattern", "", "DisplayText", "", "DisplayValues", "", "", "Name", "Rank", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Object;)V", "getDisplayPattern", "()I", "getDisplayText", "()Ljava/lang/String;", "getDisplayValues", "()Ljava/util/List;", "getName", "getRank", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ConditionOverviewInfo.kt */
public final class ConditionOverviewInfo implements Serializable {
    private final int DisplayPattern;
    @NotNull
    private final String DisplayText;
    @NotNull
    private final List<Object> DisplayValues;
    @NotNull
    private final String Name;
    @NotNull
    private final Object Rank;

    @NotNull
    public static /* synthetic */ ConditionOverviewInfo copy$default(ConditionOverviewInfo conditionOverviewInfo, int i, String str, List<Object> list, String str2, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = conditionOverviewInfo.DisplayPattern;
        }
        if ((i2 & 2) != 0) {
            str = conditionOverviewInfo.DisplayText;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            list = conditionOverviewInfo.DisplayValues;
        }
        List<Object> list2 = list;
        if ((i2 & 8) != 0) {
            str2 = conditionOverviewInfo.Name;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            obj = conditionOverviewInfo.Rank;
        }
        return conditionOverviewInfo.copy(i, str3, list2, str4, obj);
    }

    public final int component1() {
        return this.DisplayPattern;
    }

    @NotNull
    public final String component2() {
        return this.DisplayText;
    }

    @NotNull
    public final List<Object> component3() {
        return this.DisplayValues;
    }

    @NotNull
    public final String component4() {
        return this.Name;
    }

    @NotNull
    public final Object component5() {
        return this.Rank;
    }

    @NotNull
    public final ConditionOverviewInfo copy(int i, @NotNull String str, @NotNull List<? extends Object> list, @NotNull String str2, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "DisplayText");
        Intrinsics.checkParameterIsNotNull(list, "DisplayValues");
        Intrinsics.checkParameterIsNotNull(str2, "Name");
        Intrinsics.checkParameterIsNotNull(obj, "Rank");
        return new ConditionOverviewInfo(i, str, list, str2, obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ConditionOverviewInfo) {
                ConditionOverviewInfo conditionOverviewInfo = (ConditionOverviewInfo) obj;
                if (!(this.DisplayPattern == conditionOverviewInfo.DisplayPattern) || !Intrinsics.areEqual((Object) this.DisplayText, (Object) conditionOverviewInfo.DisplayText) || !Intrinsics.areEqual((Object) this.DisplayValues, (Object) conditionOverviewInfo.DisplayValues) || !Intrinsics.areEqual((Object) this.Name, (Object) conditionOverviewInfo.Name) || !Intrinsics.areEqual(this.Rank, conditionOverviewInfo.Rank)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = Integer.valueOf(this.DisplayPattern).hashCode() * 31;
        String str = this.DisplayText;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<Object> list = this.DisplayValues;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.Name;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj = this.Rank;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        return "ConditionOverviewInfo(DisplayPattern=" + this.DisplayPattern + ", DisplayText=" + this.DisplayText + ", DisplayValues=" + this.DisplayValues + ", Name=" + this.Name + ", Rank=" + this.Rank + ")";
    }

    public ConditionOverviewInfo(int i, @NotNull String str, @NotNull List<? extends Object> list, @NotNull String str2, @NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "DisplayText");
        Intrinsics.checkParameterIsNotNull(list, "DisplayValues");
        Intrinsics.checkParameterIsNotNull(str2, "Name");
        Intrinsics.checkParameterIsNotNull(obj, "Rank");
        this.DisplayPattern = i;
        this.DisplayText = str;
        this.DisplayValues = list;
        this.Name = str2;
        this.Rank = obj;
    }

    public final int getDisplayPattern() {
        return this.DisplayPattern;
    }

    @NotNull
    public final String getDisplayText() {
        return this.DisplayText;
    }

    @NotNull
    public final List<Object> getDisplayValues() {
        return this.DisplayValues;
    }

    @NotNull
    public final String getName() {
        return this.Name;
    }

    @NotNull
    public final Object getRank() {
        return this.Rank;
    }
}
