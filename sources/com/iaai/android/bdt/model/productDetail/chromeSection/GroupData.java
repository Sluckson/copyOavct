package com.iaai.android.bdt.model.productDetail.chromeSection;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/chromeSection/GroupData;", "", "HeaderName", "", "HeaderValue", "", "Lcom/iaai/android/bdt/model/productDetail/chromeSection/HeaderValue;", "(Ljava/lang/String;Ljava/util/List;)V", "getHeaderName", "()Ljava/lang/String;", "getHeaderValue", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: GroupData.kt */
public final class GroupData {
    @NotNull
    private final String HeaderName;
    @NotNull
    private final List<HeaderValue> HeaderValue;

    @NotNull
    public static /* synthetic */ GroupData copy$default(GroupData groupData, String str, List<HeaderValue> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = groupData.HeaderName;
        }
        if ((i & 2) != 0) {
            list = groupData.HeaderValue;
        }
        return groupData.copy(str, list);
    }

    @NotNull
    public final String component1() {
        return this.HeaderName;
    }

    @NotNull
    public final List<HeaderValue> component2() {
        return this.HeaderValue;
    }

    @NotNull
    public final GroupData copy(@NotNull String str, @NotNull List<HeaderValue> list) {
        Intrinsics.checkParameterIsNotNull(str, "HeaderName");
        Intrinsics.checkParameterIsNotNull(list, "HeaderValue");
        return new GroupData(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GroupData)) {
            return false;
        }
        GroupData groupData = (GroupData) obj;
        return Intrinsics.areEqual((Object) this.HeaderName, (Object) groupData.HeaderName) && Intrinsics.areEqual((Object) this.HeaderValue, (Object) groupData.HeaderValue);
    }

    public int hashCode() {
        String str = this.HeaderName;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<HeaderValue> list = this.HeaderValue;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "GroupData(HeaderName=" + this.HeaderName + ", HeaderValue=" + this.HeaderValue + ")";
    }

    public GroupData(@NotNull String str, @NotNull List<HeaderValue> list) {
        Intrinsics.checkParameterIsNotNull(str, "HeaderName");
        Intrinsics.checkParameterIsNotNull(list, "HeaderValue");
        this.HeaderName = str;
        this.HeaderValue = list;
    }

    @NotNull
    public final String getHeaderName() {
        return this.HeaderName;
    }

    @NotNull
    public final List<HeaderValue> getHeaderValue() {
        return this.HeaderValue;
    }
}
